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
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.Entityhamonuser;
/*     */ 
/*     */ public class EntityEchoesAct3_punch
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
/*     */   public EntityEchoesAct3 shootingStand;
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
/*     */   public EntityEchoesAct3_punch(World par1World) {
/*  57 */     super(par1World);
/*  58 */     this.renderDistanceWeight = 10.0D;
/*  59 */     setSize(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityEchoesAct3_punch(World par1World, double par2, double par4, double par6) {
/*  64 */     super(par1World);
/*  65 */     this.renderDistanceWeight = 10.0D;
/*  66 */     setSize(0.5F, 0.5F);
/*  67 */     setPosition(par2, par4, par6);
/*  68 */     this.yOffset = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityEchoesAct3_punch(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  73 */     super(par1World);
/*  74 */     this.renderDistanceWeight = 10.0D;
/*  75 */     this.shootingEntity = par2EntityLivingBase;
/*     */     
/*  77 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/*  79 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/*  82 */     this.posY = par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
/*  83 */     double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
/*  84 */     double d1 = par3EntityLivingBase.boundingBox.minY + (par3EntityLivingBase.height / 3.0F) - this.posY;
/*  85 */     double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
/*  86 */     double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
/*     */     
/*  88 */     if (d3 >= 1.0E-7D) {
/*     */       
/*  90 */       float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
/*  91 */       float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
/*  92 */       double d4 = d0 / d3;
/*  93 */       double d5 = d2 / d3;
/*  94 */       setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
/*  95 */       this.yOffset = 0.0F;
/*  96 */       float f4 = (float)d3 * 0.2F;
/*  97 */       setThrowableHeading(d0, d1 + f4, d2, par4, par5);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityEchoesAct3_punch(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
/* 103 */     super(par1World);
/* 104 */     this.renderDistanceWeight = 10.0D;
/* 105 */     this.shootingEntity = par2EntityLivingBase;
/* 106 */     this.shootingStand = (EntityEchoesAct3)par2EntityLivingBase;
/*     */     
/* 108 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/* 110 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/* 113 */     setSize(0.5F, 0.5F);
/*     */ 
/*     */ 
/*     */     
/* 117 */     if (this.shootingStand.special) {
/*     */       
/* 119 */       int randp = this.rand.nextInt(2) - this.rand.nextInt(2);
/* 120 */       int randp2 = this.rand.nextInt(2) - this.rand.nextInt(2);
/* 121 */       int randp3 = this.rand.nextInt(2) - this.rand.nextInt(2);
/* 122 */       setLocationAndAngles(par2EntityLivingBase.posX + randp, par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() + randp2, par2EntityLivingBase.posZ + randp3, (this.shootingStand.getMaster()).rotationYaw, (this.shootingStand.getMaster()).rotationPitch);
/*     */     }
/*     */     else {
/*     */       
/* 126 */       int randp = 0;
/* 127 */       int randp2 = 0;
/* 128 */       int randp3 = 0;
/* 129 */       setLocationAndAngles((this.shootingStand.getMaster()).posX + randp, (this.shootingStand.getMaster()).posY + this.shootingStand.getMaster().getEyeHeight() + randp2, (this.shootingStand.getMaster()).posZ + randp3, (this.shootingStand.getMaster()).rotationYaw, (this.shootingStand.getMaster()).rotationPitch);
/*     */     } 
/* 131 */     this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 132 */     this.posY -= 0.10000000149011612D;
/* 133 */     this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 134 */     setPosition(this.posX, this.posY, this.posZ);
/* 135 */     this.yOffset = 0.0F;
/* 136 */     this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 137 */     this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 138 */     this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F);
/* 139 */     setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 144 */   protected void entityInit() { this.dataWatcher.addObject(16, Byte.valueOf((byte)0)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/* 152 */     float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
/* 153 */     par1 /= f2;
/* 154 */     par3 /= f2;
/* 155 */     par5 /= f2;
/* 156 */     par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 157 */     par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 158 */     par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 159 */     par1 *= par7;
/* 160 */     par3 *= par7;
/* 161 */     par5 *= par7;
/* 162 */     this.motionX = par1;
/* 163 */     this.motionY = par3;
/* 164 */     this.motionZ = par5;
/* 165 */     float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 166 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 167 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f3) * 180.0D / Math.PI);
/* 168 */     this.ticksInGround = 0;
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
/* 179 */     setPosition(par1, par3, par5);
/* 180 */     setRotation(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 190 */     this.motionX = par1;
/* 191 */     this.motionY = par3;
/* 192 */     this.motionZ = par5;
/*     */     
/* 194 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 196 */       float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 197 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 198 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f) * 180.0D / Math.PI);
/* 199 */       this.prevRotationPitch = this.rotationPitch;
/* 200 */       this.prevRotationYaw = this.rotationYaw;
/* 201 */       setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
/* 202 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 211 */     super.onUpdate();
/*     */     
/* 213 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 215 */       float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 216 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 217 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 220 */     Block blockA = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 221 */     int i = Block.getIdFromBlock(blockA);
/*     */     
/* 223 */     if (i > 0) {
/*     */       
/* 225 */       blockA.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 226 */       AxisAlignedBB axisalignedbb = blockA.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 228 */       if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
/*     */       {
/* 230 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 234 */     if (this.arrowShake > 0)
/*     */     {
/* 236 */       this.arrowShake--;
/*     */     }
/*     */     
/* 239 */     if (!this.inGround) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 244 */       this.ticksInAir++;
/* 245 */       if (this.ticksInAir >= 3)
/*     */       {
/* 247 */         setDead();
/*     */       }
/* 249 */       Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 250 */       Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 251 */       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
/* 252 */       vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 253 */       vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 255 */       if (movingobjectposition != null)
/*     */       {
/* 257 */         vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */       }
/*     */       
/* 260 */       Entity entity = null;
/* 261 */       List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 262 */       double d0 = 0.0D;
/*     */       
/*     */       int l;
/*     */       
/* 266 */       for (l = 0; l < list.size(); l++) {
/*     */         
/* 268 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 270 */         if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */           
/* 272 */           float f1 = 0.3F;
/* 273 */           AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
/* 274 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);
/*     */           
/* 276 */           if (movingobjectposition1 != null) {
/*     */             
/* 278 */             double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
/*     */             
/* 280 */             if (d1 < d0 || d0 == 0.0D) {
/*     */               
/* 282 */               entity = entity1;
/* 283 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 289 */       if (entity != null)
/*     */       {
/* 291 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 294 */       if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */         
/* 296 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
/*     */         
/* 298 */         if (entityplayer.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))
/*     */         {
/* 300 */           movingobjectposition = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 307 */       if (movingobjectposition != null)
/*     */       {
/* 309 */         if (movingobjectposition.entityHit != null) {
/*     */           
/* 311 */           if (!this.worldObj.isRemote)
/*     */           {
/*     */             
/* 314 */             if (this.shootingStand.getMaster() != null && movingobjectposition.entityHit == this.shootingStand.getMaster())
/*     */             {
/* 316 */               movingobjectposition = null;
/*     */             }
/*     */             else
/*     */             {
/* 320 */               if (this.shootingStand.special) {
/*     */                 
/* 322 */                 ((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 100, 2));
/* 323 */                 ((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 100, 'ϧ'));
/*     */               } 
/* 325 */               this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 326 */               if (movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityVampire) {
/*     */                 
/* 328 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 10.0F);
/* 329 */                 movingobjectposition.entityHit.hurtResistantTime = 0;
/* 330 */                 movingobjectposition.entityHit.motionX = 0.0D;
/* 331 */                 movingobjectposition.entityHit.motionY -= 0.1D;
/* 332 */                 movingobjectposition.entityHit.motionZ = 0.0D;
/* 333 */                 setDead();
/*     */               }
/* 335 */               else if (movingobjectposition.entityHit instanceof Entityhamonuser) {
/*     */                 
/* 337 */                 Entityhamonuser hamonuser = (Entityhamonuser)movingobjectposition.entityHit;
/* 338 */                 if (hamonuser.getOwner() == this.shootingStand.getMaster())
/*     */                 {
/* 340 */                   movingobjectposition = null;
/*     */                 }
/*     */                 else
/*     */                 {
/* 344 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 2.0F);
/* 345 */                   movingobjectposition.entityHit.hurtResistantTime = 0;
/* 346 */                   movingobjectposition.entityHit.motionX = 0.0D;
/* 347 */                   movingobjectposition.entityHit.motionY -= 0.1D;
/* 348 */                   movingobjectposition.entityHit.motionZ = 0.0D;
/* 349 */                   setDead();
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 354 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 2.0F);
/* 355 */                 movingobjectposition.entityHit.hurtResistantTime = 0;
/* 356 */                 movingobjectposition.entityHit.motionX = 0.0D;
/* 357 */                 movingobjectposition.entityHit.motionY -= 0.1D;
/* 358 */                 movingobjectposition.entityHit.motionZ = 0.0D;
/* 359 */                 setDead();
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */         } else {
/*     */           
/* 367 */           this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 368 */           this.xTile = movingobjectposition.blockX;
/* 369 */           this.yTile = movingobjectposition.blockY;
/* 370 */           this.zTile = movingobjectposition.blockZ;
/* 371 */           this.inTile = Block.getIdFromBlock(this.worldObj.getBlock(this.xTile, this.yTile, this.zTile));
/* 372 */           this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/* 373 */           this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
/* 374 */           this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
/* 375 */           this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
/* 376 */           float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 377 */           this.posX -= this.motionX / f2 * 0.05000000074505806D;
/* 378 */           this.posY -= this.motionY / f2 * 0.05000000074505806D;
/* 379 */           this.posZ -= this.motionZ / f2 * 0.05000000074505806D;
/* 380 */           this.inGround = true;
/* 381 */           this.arrowShake = 7;
/* 382 */           setIsCritical(false);
/* 383 */           int p = 3;
/* 384 */           Block blockB = Block.getBlockById(this.inTile);
/* 385 */           if (this.inTile != 7 && this.inTile != 49 && this.inTile != 119) {
/*     */             
/* 387 */             if (!this.worldObj.isRemote)
/*     */             {
/* 389 */               //this.worldObj.setBlockToAir(this.xTile, this.yTile, this.zTile);
/* 390 */               //blockB.dropBlockAsItemWithChance(this.worldObj, this.xTile, this.yTile, this.zTile, this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile), 1.0F, 0);
/* 391 */               setDead();
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 396 */             setDead();
/*     */           } 
/*     */           
/* 399 */           if (this.inTile != 0)
/*     */           {
/* 401 */             Block.getBlockById(this.inTile).onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 406 */       if (getIsCritical())
/*     */       {
/* 408 */         for (l = 0; l < 4; l++)
/*     */         {
/* 410 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 414 */       this.posX += this.motionX;
/* 415 */       this.posY += this.motionY;
/* 416 */       this.posZ += this.motionZ;
/* 417 */       float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 418 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 420 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 425 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 427 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 430 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 432 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 435 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 437 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 440 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 441 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 442 */       float f4 = 0.99F;
/* 443 */       float f1 = 0.05F;
/*     */       
/* 445 */       if (isInWater()) {
/*     */         
/* 447 */         for (int j1 = 0; j1 < 4; j1++) {
/*     */           
/* 449 */           float f3 = 0.25F;
/* 450 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 453 */         f4 = 0.8F;
/*     */       } 
/*     */       
/* 456 */       this.motionX *= f4;
/* 457 */       this.motionY *= f4;
/* 458 */       this.motionZ *= f4;
/* 459 */       this.motionY -= f1;
/* 460 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 469 */     par1NBTTagCompound.setShort("xTile", (short)this.xTile);
/* 470 */     par1NBTTagCompound.setShort("yTile", (short)this.yTile);
/* 471 */     par1NBTTagCompound.setShort("zTile", (short)this.zTile);
/* 472 */     par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
/* 473 */     par1NBTTagCompound.setByte("inData", (byte)this.inData);
/* 474 */     par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
/* 475 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 476 */     par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
/* 477 */     par1NBTTagCompound.setDouble("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 485 */     this.xTile = par1NBTTagCompound.getShort("xTile");
/* 486 */     this.yTile = par1NBTTagCompound.getShort("yTile");
/* 487 */     this.zTile = par1NBTTagCompound.getShort("zTile");
/* 488 */     this.inTile = par1NBTTagCompound.getByte("inTile") & 0xFF;
/* 489 */     this.inData = par1NBTTagCompound.getByte("inData") & 0xFF;
/* 490 */     this.arrowShake = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 491 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */     
/* 493 */     if (par1NBTTagCompound.hasKey("damage"))
/*     */     {
/* 495 */       this.damage = par1NBTTagCompound.getDouble("damage");
/*     */     }
/*     */     
/* 498 */     if (par1NBTTagCompound.hasKey("pickup")) {
/*     */       
/* 500 */       this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
/*     */     }
/* 502 */     else if (par1NBTTagCompound.hasKey("player")) {
/*     */       
/* 504 */       this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 514 */   protected boolean canTriggerWalking() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 520 */   public float getShadowSize() { return 0.5F; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 525 */   public void setDamage(double par1) { this.damage = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 530 */   public double getDamage() { return this.damage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 538 */   public void setKnockbackStrength(int par1) { this.knockbackStrength = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 546 */   public boolean canAttackWithItem() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 554 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 556 */     if (par1) {
/*     */       
/* 558 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
/*     */     }
/*     */     else {
/*     */       
/* 562 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 571 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/* 572 */     return ((b0 & 1) != 0);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityEchoesAct3_punch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */