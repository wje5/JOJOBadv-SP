/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.Entityhamonuser;
/*     */ 
/*     */ 
/*     */ public class EntityMagicians_Red_fire
/*     */   extends Entity
/*     */   implements IProjectile
/*     */ {
/*     */   boolean flag = true;
/*  27 */   int timer = 0;
/*  28 */   private int xTile = -1;
/*  29 */   private int yTile = -1;
/*  30 */   private int zTile = -1;
/*     */   
/*     */   private int inTile;
/*     */   
/*     */   private int inData;
/*     */   
/*     */   private boolean inGround;
/*     */   
/*     */   public int canBePickedUp;
/*     */   
/*     */   public int arrowShake;
/*     */   
/*     */   public Entity shootingEntity;
/*     */   public EntityMagicians_Red shootingStand;
/*     */   private int ticksInGround;
/*     */   private int ticksInAir;
/*  46 */   private double damage = 2.5D;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*     */   private boolean hit = false;
/*     */   
/*     */   private double dx;
/*     */   private double dy;
/*     */   private double dz;
/*     */   
/*     */   public EntityMagicians_Red_fire(World par1World) {
/*  57 */     super(par1World);
/*  58 */     this.renderDistanceWeight = 10.0D;
/*  59 */     setSize(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityMagicians_Red_fire(World par1World, double par2, double par4, double par6) {
/*  64 */     super(par1World);
/*  65 */     this.renderDistanceWeight = 10.0D;
/*  66 */     setSize(0.5F, 0.5F);
/*  67 */     setPosition(par2, par4, par6);
/*  68 */     this.yOffset = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityMagicians_Red_fire(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  73 */     super(par1World);
/*  74 */     this.renderDistanceWeight = 10.0D;
/*  75 */     this.shootingEntity = par2EntityLivingBase;
/*  76 */     this.shootingStand = (EntityMagicians_Red)par2EntityLivingBase;
/*     */     
/*  78 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/*  80 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/*  83 */     this.posY = par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
/*  84 */     double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
/*  85 */     double d1 = par3EntityLivingBase.boundingBox.minY + (par3EntityLivingBase.height / 3.0F) - this.posY;
/*  86 */     double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
/*  87 */     double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
/*     */     
/*  89 */     if (d3 >= 1.0E-7D) {
/*     */       
/*  91 */       float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
/*  92 */       float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
/*  93 */       double d4 = d0 / d3;
/*  94 */       double d5 = d2 / d3;
/*  95 */       setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
/*  96 */       this.yOffset = 0.0F;
/*  97 */       float f4 = (float)d3 * 0.2F;
/*  98 */       setThrowableHeading(d0, d1 + f4, d2, par4, par5);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityMagicians_Red_fire(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
/* 104 */     super(par1World);
/* 105 */     this.renderDistanceWeight = 10.0D;
/* 106 */     this.shootingEntity = par2EntityLivingBase;
/* 107 */     this.shootingStand = (EntityMagicians_Red)par2EntityLivingBase;
/*     */     
/* 109 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/* 111 */       this.canBePickedUp = 1;
/*     */     }
/* 113 */     this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
/* 114 */     setSize(1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */     
/* 118 */     int randp = 0;
/* 119 */     int randp2 = 0;
/* 120 */     int randp3 = 0;
/* 121 */     setLocationAndAngles((this.shootingStand.getMaster()).posX + randp, (this.shootingStand.getMaster()).posY + this.shootingStand.getMaster().getEyeHeight() + 0.2D, (this.shootingStand.getMaster()).posZ + randp3, (this.shootingStand.getMaster()).rotationYaw, (this.shootingStand.getMaster()).rotationPitch);
/* 122 */     this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 123 */     this.posY -= 0.10000000149011612D;
/* 124 */     this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 125 */     setPosition(this.posX, this.posY, this.posZ);
/* 126 */     this.yOffset = 0.0F;
/* 127 */     this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 128 */     this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 129 */     this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F);
/* 130 */     setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 135 */   protected void entityInit() { this.dataWatcher.addObject(16, Byte.valueOf((byte)0)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/* 143 */     float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
/* 144 */     par1 /= f2;
/* 145 */     par3 /= f2;
/* 146 */     par5 /= f2;
/* 147 */     par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 148 */     par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 149 */     par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 150 */     par1 *= par7;
/* 151 */     par3 *= par7;
/* 152 */     par5 *= par7;
/* 153 */     this.motionX = par1;
/* 154 */     this.motionY = par3;
/* 155 */     this.motionZ = par5;
/* 156 */     float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 157 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 158 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f3) * 180.0D / Math.PI);
/* 159 */     this.ticksInGround = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 170 */     setPosition(par1, par3, par5);
/* 171 */     setRotation(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 181 */     this.motionX = par1;
/* 182 */     this.motionY = par3;
/* 183 */     this.motionZ = par5;
/*     */     
/* 185 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 187 */       float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 188 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 189 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f) * 180.0D / Math.PI);
/* 190 */       this.prevRotationPitch = this.rotationPitch;
/* 191 */       this.prevRotationYaw = this.rotationYaw;
/* 192 */       setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
/* 193 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 202 */     super.onUpdate();
/*     */     
/* 204 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 206 */       float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 207 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 208 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 211 */     Block blockA = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 212 */     int i = Block.getIdFromBlock(blockA);
/*     */     
/* 214 */     if (i > 0) {
/*     */       
/* 216 */       blockA.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 217 */       AxisAlignedBB axisalignedbb = blockA.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 219 */       if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
/*     */       {
/* 221 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 225 */     if (this.arrowShake > 0)
/*     */     {
/* 227 */       this.arrowShake--;
/*     */     }
/*     */     
/* 230 */     if (!this.inGround) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       this.ticksInAir++;
/* 236 */       if (this.ticksInAir >= 10)
/*     */       {
/* 238 */         setDead();
/*     */       }
/* 240 */       Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 241 */       Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 242 */       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
/* 243 */       vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 244 */       vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 246 */       if (movingobjectposition != null)
/*     */       {
/* 248 */         vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */       }
/*     */       
/* 251 */       Entity entity = null;
/* 252 */       List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 253 */       double d0 = 0.0D;
/*     */       
/*     */       int l;
/*     */       
/* 257 */       for (l = 0; l < list.size(); l++) {
/*     */         
/* 259 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 261 */         if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */           
/* 263 */           float f1 = 0.3F;
/* 264 */           AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
/* 265 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);
/*     */           
/* 267 */           if (movingobjectposition1 != null) {
/*     */             
/* 269 */             double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
/*     */             
/* 271 */             if (d1 < d0 || d0 == 0.0D) {
/*     */               
/* 273 */               entity = entity1;
/* 274 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 280 */       if (entity != null)
/*     */       {
/* 282 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 285 */       if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */         
/* 287 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
/*     */         
/* 289 */         if (entityplayer.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))
/*     */         {
/* 291 */           movingobjectposition = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 298 */       if (movingobjectposition != null)
/*     */       {
/* 300 */         if (movingobjectposition.entityHit != null) {
/*     */           
/* 302 */           if (!this.worldObj.isRemote)
/*     */           {
/*     */             
/* 305 */             if (this.shootingStand.getMaster() != null && movingobjectposition.entityHit == this.shootingStand.getMaster())
/*     */             {
/* 307 */               movingobjectposition = null;
/*     */             }
/*     */             else
/*     */             {
/* 311 */               this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 312 */               movingobjectposition.entityHit.setFire(10);
/* 313 */               movingobjectposition.entityHit.hurtResistantTime = 0;
/* 314 */               movingobjectposition.entityHit.motionY += 0.1D;
/* 315 */               movingobjectposition.entityHit.motionX = 0.0D;
/* 316 */               movingobjectposition.entityHit.motionZ = 0.0D;
/* 317 */               movingobjectposition.entityHit.setSprinting(false);
/* 318 */               if (movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityVampire) {
/*     */                 
/* 320 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 10.0F);
/* 321 */                 setDead();
/*     */               }
/* 323 */               else if (movingobjectposition.entityHit instanceof Entityhamonuser) {
/*     */                 
/* 325 */                 Entityhamonuser hamonuser = (Entityhamonuser)movingobjectposition.entityHit;
/* 326 */                 if (hamonuser.getOwner() == this.shootingStand.getMaster())
/*     */                 {
/* 328 */                   movingobjectposition = null;
/*     */                 }
/*     */                 else
/*     */                 {
/* 332 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 1.5F);
/* 333 */                   setDead();
/*     */                 }
/*     */               
/* 336 */               } else if (movingobjectposition.entityHit instanceof net.minecraft.entity.monster.EntityMob) {
/*     */                 
/* 338 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 4.0F);
/* 339 */                 setDead();
/*     */               }
/*     */               else {
/*     */                 
/* 343 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 1.5F);
/* 344 */                 setDead();
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */         } else {
/*     */           
/* 352 */           this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 353 */           this.xTile = movingobjectposition.blockX;
/* 354 */           this.yTile = movingobjectposition.blockY;
/* 355 */           this.zTile = movingobjectposition.blockZ;
/* 356 */           this.inTile = Block.getIdFromBlock(this.worldObj.getBlock(this.xTile, this.yTile, this.zTile));
/* 357 */           this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/* 358 */           this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
/* 359 */           this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
/* 360 */           this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
/* 361 */           float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 362 */           this.posX -= this.motionX / f2 * 0.05000000074505806D;
/* 363 */           this.posY -= this.motionY / f2 * 0.05000000074505806D;
/* 364 */           this.posZ -= this.motionZ / f2 * 0.05000000074505806D;
/* 365 */           this.inGround = true;
/* 366 */           this.arrowShake = 7;
/* 367 */           setIsCritical(false);
/* 368 */           int p = 3;
/* 369 */           Block blockB = Block.getBlockById(this.inTile);
/* 370 */           if (!this.worldObj.isRemote)
/*     */           {
/* 372 */             switch (movingobjectposition.sideHit) {
/*     */               
/*     */               case 1:
/* 375 */                 this.worldObj.setBlock(this.xTile, this.yTile + 1, this.zTile, Blocks.fire);
/* 376 */                 setDead();
/*     */                 break;
/*     */               
/*     */               case 0:
/* 380 */                 this.worldObj.setBlock(this.xTile, this.yTile - 1, this.zTile, Blocks.fire);
/* 381 */                 setDead();
/*     */                 break;
/*     */               
/*     */               case 2:
/* 385 */                 this.worldObj.setBlock(this.xTile, this.yTile, this.zTile - 1, Blocks.fire);
/* 386 */                 setDead();
/*     */                 break;
/*     */               
/*     */               case 3:
/* 390 */                 this.worldObj.setBlock(this.xTile, this.yTile, this.zTile + 1, Blocks.fire);
/* 391 */                 setDead();
/*     */                 break;
/*     */               
/*     */               case 5:
/* 395 */                 this.worldObj.setBlock(this.xTile - 1, this.yTile, this.zTile, Blocks.fire);
/* 396 */                 setDead();
/*     */                 break;
/*     */               
/*     */               case 4:
/* 400 */                 this.worldObj.setBlock(this.xTile + 1, this.yTile, this.zTile, Blocks.fire);
/* 401 */                 setDead();
/*     */                 break;
/*     */             } 
/*     */           
/*     */           }
/* 406 */           if (this.inTile != 0) {
/*     */             
/* 408 */             Block.getBlockById(this.inTile).onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
/* 409 */             setDead();
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 414 */       if (getIsCritical())
/*     */       {
/* 416 */         for (l = 0; l < 4; l++)
/*     */         {
/* 418 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 422 */       this.posX += this.motionX;
/* 423 */       this.posY += this.motionY;
/* 424 */       this.posZ += this.motionZ;
/* 425 */       float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 426 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 428 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 433 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 435 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 438 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 440 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 443 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 445 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 448 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 449 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 450 */       float f4 = 0.99F;
/* 451 */       float f1 = 0.05F;
/*     */       
/* 453 */       if (isInWater()) {
/*     */         
/* 455 */         setDead();
/* 456 */         for (int j1 = 0; j1 < 4; j1++) {
/*     */           
/* 458 */           float f3 = 0.25F;
/* 459 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 462 */         f4 = 0.8F;
/*     */       } 
/*     */       
/* 465 */       this.motionX *= f4;
/* 466 */       this.motionY *= f4;
/* 467 */       this.motionZ *= f4;
/* 468 */       this.motionY -= f1;
/* 469 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 478 */     par1NBTTagCompound.setShort("xTile", (short)this.xTile);
/* 479 */     par1NBTTagCompound.setShort("yTile", (short)this.yTile);
/* 480 */     par1NBTTagCompound.setShort("zTile", (short)this.zTile);
/* 481 */     par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
/* 482 */     par1NBTTagCompound.setByte("inData", (byte)this.inData);
/* 483 */     par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
/* 484 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 485 */     par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
/* 486 */     par1NBTTagCompound.setDouble("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 494 */     this.xTile = par1NBTTagCompound.getShort("xTile");
/* 495 */     this.yTile = par1NBTTagCompound.getShort("yTile");
/* 496 */     this.zTile = par1NBTTagCompound.getShort("zTile");
/* 497 */     this.inTile = par1NBTTagCompound.getByte("inTile") & 0xFF;
/* 498 */     this.inData = par1NBTTagCompound.getByte("inData") & 0xFF;
/* 499 */     this.arrowShake = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 500 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */     
/* 502 */     if (par1NBTTagCompound.hasKey("damage"))
/*     */     {
/* 504 */       this.damage = par1NBTTagCompound.getDouble("damage");
/*     */     }
/*     */     
/* 507 */     if (par1NBTTagCompound.hasKey("pickup")) {
/*     */       
/* 509 */       this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
/*     */     }
/* 511 */     else if (par1NBTTagCompound.hasKey("player")) {
/*     */       
/* 513 */       this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 523 */   protected boolean canTriggerWalking() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 529 */   public float getShadowSize() { return 0.5F; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 534 */   public void setDamage(double par1) { this.damage = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 539 */   public double getDamage() { return this.damage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 547 */   public void setKnockbackStrength(int par1) { this.knockbackStrength = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 555 */   public boolean canAttackWithItem() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 563 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 565 */     if (par1) {
/*     */       
/* 567 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
/*     */     }
/*     */     else {
/*     */       
/* 571 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 580 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/* 581 */     return ((b0 & 1) != 0);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityMagicians_Red_fire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */