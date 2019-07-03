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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.Entityhamonuser;
/*     */ 
/*     */ 
/*     */ public class EntitySilver_Chariot_blade
/*     */   extends Entity
/*     */   implements IProjectile
/*     */ {
/*     */   boolean flag = true;
/*  26 */   int timer = 0;
/*  27 */   private int xTile = -1;
/*  28 */   private int yTile = -1;
/*  29 */   private int zTile = -1;
/*     */   
/*     */   private int inTile;
/*     */   
/*     */   private int inData;
/*     */   
/*     */   public boolean onFire;
/*     */   
/*     */   private boolean inGround;
/*     */   
/*     */   public int canBePickedUp;
/*     */   
/*     */   public int arrowShake;
/*     */   public Entity shootingEntity;
/*     */   public EntitySilver_Chariot shootingStand;
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
/*     */   public EntitySilver_Chariot_blade(World par1World) {
/*  57 */     super(par1World);
/*  58 */     this.renderDistanceWeight = 10.0D;
/*  59 */     setSize(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntitySilver_Chariot_blade(World par1World, double par2, double par4, double par6) {
/*  64 */     super(par1World);
/*  65 */     this.renderDistanceWeight = 10.0D;
/*  66 */     setSize(0.5F, 0.5F);
/*  67 */     setPosition(par2, par4, par6);
/*  68 */     this.yOffset = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntitySilver_Chariot_blade(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  73 */     super(par1World);
/*  74 */     this.renderDistanceWeight = 10.0D;
/*  75 */     this.shootingEntity = par2EntityLivingBase;
/*  76 */     this.shootingStand = (EntitySilver_Chariot)par2EntityLivingBase;
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
/*     */   public EntitySilver_Chariot_blade(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
/* 104 */     super(par1World);
/* 105 */     this.renderDistanceWeight = 10.0D;
/* 106 */     this.shootingEntity = par2EntityLivingBase;
/* 107 */     this.shootingStand = (EntitySilver_Chariot)par2EntityLivingBase;
/*     */     
/* 109 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/* 111 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/* 114 */     setSize(0.5F, 0.5F);
/*     */ 
/*     */ 
/*     */     float randp,randp2,randp3;
/* 118 */     if (this.shootingStand.special != 0) {
/*     */       
/* 120 */       randp = this.rand.nextFloat();
/* 121 */       randp2 = this.rand.nextFloat();
/* 122 */       randp3 = this.rand.nextFloat();
/*     */       
/* 124 */       randp -= this.rand.nextFloat();
/* 125 */       randp2 -= this.rand.nextFloat();
/* 126 */       randp3 -= this.rand.nextFloat();
/*     */     }
/*     */     else {
/*     */       
/* 130 */       randp = 0.0F;
/* 131 */       randp2 = 0.0F;
/* 132 */       randp3 = 0.0F;
/*     */     } 
/* 134 */     setLocationAndAngles((this.shootingStand.getMaster()).posX + randp, (this.shootingStand.getMaster()).posY + this.shootingStand.getMaster().getEyeHeight() + randp2, (this.shootingStand.getMaster()).posZ + randp3, (this.shootingStand.getMaster()).rotationYaw, (this.shootingStand.getMaster()).rotationPitch);
/* 135 */     this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 136 */     this.posY -= 0.10000000149011612D;
/* 137 */     this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 138 */     setPosition(this.posX, this.posY, this.posZ);
/* 139 */     this.yOffset = 0.0F;
/* 140 */     this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 141 */     this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 142 */     this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F);
/* 143 */     setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 148 */   protected void entityInit() { this.dataWatcher.addObject(16, Byte.valueOf((byte)0)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/* 156 */     float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
/* 157 */     par1 /= f2;
/* 158 */     par3 /= f2;
/* 159 */     par5 /= f2;
/* 160 */     par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 161 */     par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 162 */     par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 163 */     par1 *= par7;
/* 164 */     par3 *= par7;
/* 165 */     par5 *= par7;
/* 166 */     this.motionX = par1;
/* 167 */     this.motionY = par3;
/* 168 */     this.motionZ = par5;
/* 169 */     float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 170 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 171 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f3) * 180.0D / Math.PI);
/* 172 */     this.ticksInGround = 0;
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
/* 183 */     setPosition(par1, par3, par5);
/* 184 */     setRotation(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 194 */     this.motionX = par1;
/* 195 */     this.motionY = par3;
/* 196 */     this.motionZ = par5;
/*     */     
/* 198 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 200 */       float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 201 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 202 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f) * 180.0D / Math.PI);
/* 203 */       this.prevRotationPitch = this.rotationPitch;
/* 204 */       this.prevRotationYaw = this.rotationYaw;
/* 205 */       setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
/* 206 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 215 */     super.onUpdate();
/*     */     
/* 217 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 219 */       float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 220 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 221 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 224 */     Block blockA = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 225 */     int i = Block.getIdFromBlock(blockA);
/*     */     
/* 227 */     if (i > 0) {
/*     */       
/* 229 */       blockA.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 230 */       AxisAlignedBB axisalignedbb = blockA.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 232 */       if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
/*     */       {
/* 234 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 238 */     if (this.arrowShake > 0)
/*     */     {
/* 240 */       this.arrowShake--;
/*     */     }
/*     */     
/* 243 */     if (this.inGround) {
/*     */       
/* 245 */       setDead();
/*     */     }
/*     */     else {
/*     */       
/* 249 */       this.ticksInAir++;
/* 250 */       if (this.ticksInAir >= 3)
/*     */       {
/* 252 */         setDead();
/*     */       }
/* 254 */       Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 255 */       Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 256 */       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
/* 257 */       vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 258 */       vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 260 */       if (movingobjectposition != null)
/*     */       {
/* 262 */         vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */       }
/*     */       
/* 265 */       Entity entity = null;
/* 266 */       List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 267 */       double d0 = 0.0D;
/*     */       
/*     */       int l;
/*     */       
/* 271 */       for (l = 0; l < list.size(); l++) {
/*     */         
/* 273 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 275 */         if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */           
/* 277 */           float f1 = 0.3F;
/* 278 */           AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
/* 279 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);
/*     */           
/* 281 */           if (movingobjectposition1 != null) {
/*     */             
/* 283 */             double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
/*     */             
/* 285 */             if (d1 < d0 || d0 == 0.0D) {
/*     */               
/* 287 */               entity = entity1;
/* 288 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 294 */       if (entity != null)
/*     */       {
/* 296 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 299 */       if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */         
/* 301 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
/*     */         
/* 303 */         if (entityplayer.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))
/*     */         {
/* 305 */           movingobjectposition = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 312 */       if (movingobjectposition != null)
/*     */       {
/* 314 */         if (movingobjectposition.entityHit != null) {
/*     */           
/* 316 */           if (!this.worldObj.isRemote)
/*     */           {
/* 318 */             if (this.shootingStand.getMaster() != null && movingobjectposition.entityHit == this.shootingStand.getMaster())
/*     */             {
/* 320 */               movingobjectposition = null;
/*     */             }
/*     */             else
/*     */             {
/* 324 */               if (this.onFire)
/*     */               {
/* 326 */                 if (this.rand.nextInt(2) == 1)
/*     */                 {
/* 328 */                   movingobjectposition.entityHit.setFire(2);
/*     */                 }
/*     */               }
/* 331 */               movingobjectposition.entityHit.hurtResistantTime = 0;
/* 332 */               movingobjectposition.entityHit.motionY--;
/* 333 */               if (movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityVampire) {
/*     */                 
/* 335 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 10.0F);
/*     */               }
/* 337 */               else if (movingobjectposition.entityHit instanceof Entityhamonuser) {
/*     */                 
/* 339 */                 Entityhamonuser hamonuser = (Entityhamonuser)movingobjectposition.entityHit;
/* 340 */                 if (hamonuser.getOwner() == this.shootingStand.getMaster())
/*     */                 {
/* 342 */                   movingobjectposition = null;
/*     */                 }
/* 344 */                 else if (this.rand.nextInt(9) == 1)
/*     */                 {
/* 346 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 3.0F);
/*     */                 }
/*     */                 else
/*     */                 {
/* 350 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 1.0F);
/*     */                 }
/*     */               
/* 353 */               } else if (movingobjectposition.entityHit instanceof net.minecraft.entity.monster.EntityMob) {
/*     */                 
/* 355 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 3.0F);
/*     */               }
/* 357 */               else if (movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */                 
/* 359 */                 movingobjectposition.entityHit.setSneaking(true);
/* 360 */                 if (this.rand.nextInt(9) == 1)
/*     */                 {
/* 362 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 3.0F);
/*     */                 }
/*     */                 else
/*     */                 {
/* 366 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 1.0F);
/*     */                 
/*     */                 }
/*     */               
/*     */               }
/* 371 */               else if (this.rand.nextInt(9) == 1) {
/*     */                 
/* 373 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 3.0F);
/*     */               }
/*     */               else {
/*     */                 
/* 377 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 1.0F);
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */         }
/*     */         else {
/*     */           
/* 386 */           this.xTile = movingobjectposition.blockX;
/* 387 */           this.yTile = movingobjectposition.blockY;
/* 388 */           this.zTile = movingobjectposition.blockZ;
/* 389 */           this.inTile = Block.getIdFromBlock(this.worldObj.getBlock(this.xTile, this.yTile, this.zTile));
/* 390 */           this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/* 391 */           this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
/* 392 */           this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
/* 393 */           this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
/* 394 */           float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 395 */           this.posX -= this.motionX / f2 * 0.05000000074505806D;
/* 396 */           this.posY -= this.motionY / f2 * 0.05000000074505806D;
/* 397 */           this.posZ -= this.motionZ / f2 * 0.05000000074505806D;
/* 398 */           this.inGround = true;
/* 399 */           this.arrowShake = 7;
/* 400 */           setIsCritical(false);
/* 401 */           int p = 3;
/* 402 */           Block blockB = Block.getBlockById(this.inTile);
/*     */ 
/*     */           
/* 405 */           if (this.inTile != 0)
/*     */           {
/* 407 */             blockB.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 412 */       if (getIsCritical())
/*     */       {
/* 414 */         for (l = 0; l < 4; l++)
/*     */         {
/* 416 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 420 */       this.posX += this.motionX;
/* 421 */       this.posY += this.motionY;
/* 422 */       this.posZ += this.motionZ;
/* 423 */       float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 424 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 426 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 431 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 433 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 436 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 438 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 441 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 443 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 446 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 447 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 448 */       float f4 = 0.99F;
/* 449 */       float f1 = 0.05F;
/*     */       
/* 451 */       if (isInWater()) {
/*     */         
/* 453 */         for (int j1 = 0; j1 < 4; j1++) {
/*     */           
/* 455 */           float f3 = 0.25F;
/* 456 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 459 */         f4 = 0.8F;
/*     */       } 
/*     */       
/* 462 */       this.motionX *= f4;
/* 463 */       this.motionY *= f4;
/* 464 */       this.motionZ *= f4;
/* 465 */       this.motionY -= f1;
/* 466 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 475 */     par1NBTTagCompound.setShort("xTile", (short)this.xTile);
/* 476 */     par1NBTTagCompound.setShort("yTile", (short)this.yTile);
/* 477 */     par1NBTTagCompound.setShort("zTile", (short)this.zTile);
/* 478 */     par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
/* 479 */     par1NBTTagCompound.setByte("inData", (byte)this.inData);
/* 480 */     par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
/* 481 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 482 */     par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
/* 483 */     par1NBTTagCompound.setDouble("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 491 */     this.xTile = par1NBTTagCompound.getShort("xTile");
/* 492 */     this.yTile = par1NBTTagCompound.getShort("yTile");
/* 493 */     this.zTile = par1NBTTagCompound.getShort("zTile");
/* 494 */     this.inTile = par1NBTTagCompound.getByte("inTile") & 0xFF;
/* 495 */     this.inData = par1NBTTagCompound.getByte("inData") & 0xFF;
/* 496 */     this.arrowShake = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 497 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */     
/* 499 */     if (par1NBTTagCompound.hasKey("damage"))
/*     */     {
/* 501 */       this.damage = par1NBTTagCompound.getDouble("damage");
/*     */     }
/*     */     
/* 504 */     if (par1NBTTagCompound.hasKey("pickup")) {
/*     */       
/* 506 */       this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
/*     */     }
/* 508 */     else if (par1NBTTagCompound.hasKey("player")) {
/*     */       
/* 510 */       this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 520 */   protected boolean canTriggerWalking() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 526 */   public float getShadowSize() { return 0.5F; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 531 */   public void setDamage(double par1) { this.damage = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 536 */   public double getDamage() { return this.damage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 544 */   public void setKnockbackStrength(int par1) { this.knockbackStrength = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 552 */   public boolean canAttackWithItem() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 560 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 562 */     if (par1) {
/*     */       
/* 564 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
/*     */     }
/*     */     else {
/*     */       
/* 568 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 577 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/* 578 */     return ((b0 & 1) != 0);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntitySilver_Chariot_blade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */