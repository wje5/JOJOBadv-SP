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
/*     */ 
/*     */ 
/*     */ public class EntityStickyFingers_punch
/*     */   extends Entity
/*     */   implements IProjectile
/*     */ {
/*     */   boolean flag = true;
/*  29 */   int timer = 0;
/*  30 */   private int xTile = -1;
/*  31 */   private int yTile = -1;
/*  32 */   private int zTile = -1;
/*     */   
/*     */   private Block inTile;
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
/*     */   public EntityStickyFingers shootingStand;
/*     */   private int ticksInGround;
/*     */   private int ticksInAir;
/*  48 */   private double damage = 2.5D;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*     */   private boolean hit = false;
/*     */   
/*     */   private double dx;
/*     */   private double dy;
/*     */   private double dz;
/*     */   
/*     */   public EntityStickyFingers_punch(World par1World) {
/*  59 */     super(par1World);
/*  60 */     this.renderDistanceWeight = 10.0D;
/*  61 */     setSize(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityStickyFingers_punch(World par1World, double par2, double par4, double par6) {
/*  66 */     super(par1World);
/*  67 */     this.renderDistanceWeight = 10.0D;
/*  68 */     setSize(0.5F, 0.5F);
/*  69 */     setPosition(par2, par4, par6);
/*  70 */     this.yOffset = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityStickyFingers_punch(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  75 */     super(par1World);
/*  76 */     this.renderDistanceWeight = 10.0D;
/*  77 */     this.shootingEntity = par2EntityLivingBase;
/*  78 */     this.shootingStand = (EntityStickyFingers)par2EntityLivingBase;
/*     */     
/*  80 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/*  82 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/*  85 */     this.posY = par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
/*  86 */     double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
/*  87 */     double d1 = par3EntityLivingBase.boundingBox.minY + (par3EntityLivingBase.height / 3.0F) - this.posY;
/*  88 */     double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
/*  89 */     double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
/*     */     
/*  91 */     if (d3 >= 1.0E-7D) {
/*     */       
/*  93 */       float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
/*  94 */       float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
/*  95 */       double d4 = d0 / d3;
/*  96 */       double d5 = d2 / d3;
/*  97 */       setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
/*  98 */       this.yOffset = 0.0F;
/*  99 */       float f4 = (float)d3 * 0.2F;
/* 100 */       setThrowableHeading(d0, d1 + f4, d2, par4, par5);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityStickyFingers_punch(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
/* 106 */     super(par1World);
/* 107 */     this.renderDistanceWeight = 10.0D;
/* 108 */     this.shootingEntity = par2EntityLivingBase;
/* 109 */     this.shootingStand = (EntityStickyFingers)par2EntityLivingBase;
/*     */     
/* 111 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/* 113 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/* 116 */     setSize(0.5F, 0.5F);
/*     */ 
/*     */ 
/*     */     
/* 120 */     if (this.shootingStand.arrirush || this.shootingStand.arrirush_s) {
/*     */       
/* 122 */       int randp = this.rand.nextInt(2) - this.rand.nextInt(2);
/* 123 */       int randp2 = this.rand.nextInt(2) - this.rand.nextInt(2);
/* 124 */       int randp3 = this.rand.nextInt(2) - this.rand.nextInt(2);
/* 125 */       setLocationAndAngles(par2EntityLivingBase.posX + randp, par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() + randp2, par2EntityLivingBase.posZ + randp3, par2EntityLivingBase.rotationYaw, par2EntityLivingBase.rotationPitch);
/*     */     }
/*     */     else {
/*     */       
/* 129 */       int randp = 0;
/* 130 */       int randp2 = 0;
/* 131 */       int randp3 = 0;
/* 132 */       setLocationAndAngles((this.shootingStand.getMaster()).posX + randp, (this.shootingStand.getMaster()).posY + this.shootingStand.getMaster().getEyeHeight() + randp2, (this.shootingStand.getMaster()).posZ + randp3, (this.shootingStand.getMaster()).rotationYaw, (this.shootingStand.getMaster()).rotationPitch);
/*     */     } 
/* 134 */     this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 135 */     this.posY -= 0.10000000149011612D;
/* 136 */     this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 137 */     setPosition(this.posX, this.posY, this.posZ);
/* 138 */     this.yOffset = 0.0F;
/* 139 */     this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 140 */     this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 141 */     this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F);
/* 142 */     setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 147 */   protected void entityInit() { this.dataWatcher.addObject(16, Byte.valueOf((byte)0)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/* 155 */     float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
/* 156 */     par1 /= f2;
/* 157 */     par3 /= f2;
/* 158 */     par5 /= f2;
/* 159 */     par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 160 */     par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 161 */     par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 162 */     par1 *= par7;
/* 163 */     par3 *= par7;
/* 164 */     par5 *= par7;
/* 165 */     this.motionX = par1;
/* 166 */     this.motionY = par3;
/* 167 */     this.motionZ = par5;
/* 168 */     float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 169 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 170 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f3) * 180.0D / Math.PI);
/* 171 */     this.ticksInGround = 0;
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
/* 182 */     setPosition(par1, par3, par5);
/* 183 */     setRotation(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 193 */     this.motionX = par1;
/* 194 */     this.motionY = par3;
/* 195 */     this.motionZ = par5;
/*     */     
/* 197 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 199 */       float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 200 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 201 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f) * 180.0D / Math.PI);
/* 202 */       this.prevRotationPitch = this.rotationPitch;
/* 203 */       this.prevRotationYaw = this.rotationYaw;
/* 204 */       setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
/* 205 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 214 */     super.onUpdate();
/*     */     
/* 216 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 218 */       float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 219 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 220 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 223 */     Block blockA = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/*     */     
/* 225 */     if (blockA != Blocks.air) {
/*     */       
/* 227 */       blockA.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 228 */       AxisAlignedBB axisalignedbb = blockA.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 230 */       if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
/*     */       {
/* 232 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 236 */     if (this.arrowShake > 0)
/*     */     {
/* 238 */       this.arrowShake--;
/*     */     }
/*     */     
/* 241 */     if (this.inGround) {
/*     */       
/* 243 */       setDead();
/*     */     }
/*     */     else {
/*     */       
/* 247 */       this.ticksInAir++;
/* 248 */       if (this.ticksInAir >= 3)
/*     */       {
/* 250 */         setDead();
/*     */       }
/* 252 */       Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 253 */       Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 254 */       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
/* 255 */       vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 256 */       vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 258 */       if (movingobjectposition != null)
/*     */       {
/* 260 */         vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */       }
/*     */       
/* 263 */       Entity entity = null;
/* 264 */       List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 265 */       double d0 = 0.0D;
/*     */       
/*     */       int l;
/*     */       
/* 269 */       for (l = 0; l < list.size(); l++) {
/*     */         
/* 271 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 273 */         if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */           
/* 275 */           float f1 = 0.3F;
/* 276 */           AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
/* 277 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);
/*     */           
/* 279 */           if (movingobjectposition1 != null) {
/*     */             
/* 281 */             double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
/*     */             
/* 283 */             if (d1 < d0 || d0 == 0.0D) {
/*     */               
/* 285 */               entity = entity1;
/* 286 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 292 */       if (entity != null)
/*     */       {
/* 294 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 297 */       if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */         
/* 299 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
/*     */         
/* 301 */         if (entityplayer.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))
/*     */         {
/* 303 */           movingobjectposition = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 310 */       if (movingobjectposition != null)
/*     */       {
/* 312 */         if (movingobjectposition.entityHit != null) {
/*     */           
/* 314 */           if (!this.worldObj.isRemote)
/*     */           {
/* 316 */             if (this.shootingStand.getMaster() != null && movingobjectposition.entityHit == this.shootingStand.getMaster())
/*     */             {
/* 318 */               movingobjectposition = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 337 */               float p = 0.2F;
/* 338 */               float p2 = 0.4F;
/* 339 */               if (movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityVampire) {
/*     */                 
/* 341 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 10.0F);
/* 342 */                 movingobjectposition.entityHit.hurtResistantTime = 0;
/* 343 */                 movingobjectposition.entityHit.motionX = 0.0D;
/* 344 */                 if (movingobjectposition.entityHit.posY > this.shootingStand.posY + 2.5D) {
/*     */                   
/* 346 */                   movingobjectposition.entityHit.motionY -= p2;
/*     */                 }
/*     */                 else {
/*     */                   
/* 350 */                   movingobjectposition.entityHit.motionY -= p;
/*     */                 } 
/* 352 */                 movingobjectposition.entityHit.motionZ = 0.0D;
/* 353 */                 setDead();
/*     */               }
/* 355 */               else if (movingobjectposition.entityHit instanceof Entityhamonuser) {
/*     */                 
/* 357 */                 Entityhamonuser hamonuser = (Entityhamonuser)movingobjectposition.entityHit;
/* 358 */                 if (hamonuser.getOwner() == this.shootingStand.getMaster())
/*     */                 {
/* 360 */                   movingobjectposition = null;
/*     */                 }
/*     */                 else
/*     */                 {
/* 364 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 1.0F);
/* 365 */                   movingobjectposition.entityHit.hurtResistantTime = 0;
/* 366 */                   movingobjectposition.entityHit.motionX = 0.0D;
/* 367 */                   if (movingobjectposition.entityHit.posY > this.shootingStand.posY + 2.5D) {
/*     */                     
/* 369 */                     movingobjectposition.entityHit.motionY -= p2;
/*     */                   }
/*     */                   else {
/*     */                     
/* 373 */                     movingobjectposition.entityHit.motionY -= p;
/*     */                   } 
/* 375 */                   movingobjectposition.entityHit.motionZ = 0.0D;
/* 376 */                   setDead();
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 381 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 1.0F);
/* 382 */                 movingobjectposition.entityHit.hurtResistantTime = 0;
/* 383 */                 movingobjectposition.entityHit.motionX = 0.0D;
/* 384 */                 if (movingobjectposition.entityHit.posY > this.shootingStand.posY + 2.5D) {
/*     */                   
/* 386 */                   movingobjectposition.entityHit.motionY -= p2;
/*     */                 }
/*     */                 else {
/*     */                   
/* 390 */                   movingobjectposition.entityHit.motionY -= p;
/*     */                 } 
/* 392 */                 movingobjectposition.entityHit.motionZ = 0.0D;
/* 393 */                 setDead();
/*     */               } 
/*     */               
/* 396 */               this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */         }
/*     */         else {
/*     */           
/* 404 */           this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 405 */           this.xTile = movingobjectposition.blockX;
/* 406 */           this.yTile = movingobjectposition.blockY;
/* 407 */           this.zTile = movingobjectposition.blockZ;
/* 408 */           this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 409 */           this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/* 410 */           this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
/* 411 */           this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
/* 412 */           this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
/* 413 */           float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 414 */           this.posX -= this.motionX / f2 * 0.05000000074505806D;
/* 415 */           this.posY -= this.motionY / f2 * 0.05000000074505806D;
/* 416 */           this.posZ -= this.motionZ / f2 * 0.05000000074505806D;
/* 417 */           this.inGround = true;
/* 418 */           this.arrowShake = 7;
/* 419 */           setIsCritical(false);
/* 420 */           Block block = this.inTile;
/* 421 */           float hardness = block.getBlockHardness(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 422 */           if (this.shootingStand != null) {
/*     */ 
/*     */ 
/*     */             
/* 426 */             if (!this.worldObj.isRemote)
/*     */             {
/* 428 */               setDead();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/*     */           else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 479 */             setDead();
/*     */           } 
/*     */           
/* 482 */           if (this.inTile != Blocks.air)
/*     */           {
/* 484 */             this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 489 */       if (getIsCritical())
/*     */       {
/* 491 */         for (l = 0; l < 4; l++)
/*     */         {
/* 493 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 497 */       this.posX += this.motionX;
/* 498 */       this.posY += this.motionY;
/* 499 */       this.posZ += this.motionZ;
/* 500 */       float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 501 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 503 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 508 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 510 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 513 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 515 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 518 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 520 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 523 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 524 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 525 */       float f4 = 0.99F;
/* 526 */       float f1 = 0.05F;
/*     */       
/* 528 */       if (isInWater()) {
/*     */         
/* 530 */         for (int j1 = 0; j1 < 4; j1++) {
/*     */           
/* 532 */           float f3 = 0.25F;
/* 533 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 536 */         f4 = 0.8F;
/*     */       } 
/*     */       
/* 539 */       this.motionX *= f4;
/* 540 */       this.motionY *= f4;
/* 541 */       this.motionZ *= f4;
/* 542 */       this.motionY -= f1;
/* 543 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 552 */     par1NBTTagCompound.setShort("xTile", (short)this.xTile);
/* 553 */     par1NBTTagCompound.setShort("yTile", (short)this.yTile);
/* 554 */     par1NBTTagCompound.setShort("zTile", (short)this.zTile);
/* 555 */     par1NBTTagCompound.setByte("inTile", (byte)Block.getIdFromBlock(this.inTile));
/* 556 */     par1NBTTagCompound.setByte("inData", (byte)this.inData);
/* 557 */     par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
/* 558 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 559 */     par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
/* 560 */     par1NBTTagCompound.setDouble("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 568 */     this.xTile = par1NBTTagCompound.getShort("xTile");
/* 569 */     this.yTile = par1NBTTagCompound.getShort("yTile");
/* 570 */     this.zTile = par1NBTTagCompound.getShort("zTile");
/* 571 */     this.inTile = Block.getBlockById(par1NBTTagCompound.getByte("inTile"));
/* 572 */     this.inData = par1NBTTagCompound.getByte("inData") & 0xFF;
/* 573 */     this.arrowShake = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 574 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */     
/* 576 */     if (par1NBTTagCompound.hasKey("damage"))
/*     */     {
/* 578 */       this.damage = par1NBTTagCompound.getDouble("damage");
/*     */     }
/*     */     
/* 581 */     if (par1NBTTagCompound.hasKey("pickup")) {
/*     */       
/* 583 */       this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
/*     */     }
/* 585 */     else if (par1NBTTagCompound.hasKey("player")) {
/*     */       
/* 587 */       this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 597 */   protected boolean canTriggerWalking() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 603 */   public float getShadowSize() { return 0.5F; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 608 */   public void setDamage(double par1) { this.damage = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 613 */   public double getDamage() { return this.damage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 621 */   public void setKnockbackStrength(int par1) { this.knockbackStrength = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 629 */   public boolean canAttackWithItem() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 637 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 639 */     if (par1) {
/*     */       
/* 641 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
/*     */     }
/*     */     else {
/*     */       
/* 645 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 654 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/* 655 */     return ((b0 & 1) != 0);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityStickyFingers_punch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */