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
/*     */ public class EntityKillerQueen_punch
/*     */   extends Entity
/*     */   implements IProjectile
/*     */ {
/*     */   boolean flag = true;
/*  25 */   int timer = 0;
/*  26 */   private int xTile = -1;
/*  27 */   private int yTile = -1;
/*  28 */   private int zTile = -1;
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
/*     */   public EntityKillerQueen shootingStand;
/*     */   private int ticksInGround;
/*     */   private int ticksInAir;
/*  44 */   private double damage = 2.5D;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*     */   private boolean hit = false;
/*     */   
/*     */   private double dx;
/*     */   private double dy;
/*     */   private double dz;
/*     */   
/*     */   public EntityKillerQueen_punch(World par1World) {
/*  55 */     super(par1World);
/*  56 */     this.renderDistanceWeight = 10.0D;
/*  57 */     setSize(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityKillerQueen_punch(World par1World, double par2, double par4, double par6) {
/*  62 */     super(par1World);
/*  63 */     this.renderDistanceWeight = 10.0D;
/*  64 */     setSize(0.5F, 0.5F);
/*  65 */     setPosition(par2, par4, par6);
/*  66 */     this.yOffset = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityKillerQueen_punch(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  71 */     super(par1World);
/*  72 */     this.renderDistanceWeight = 10.0D;
/*  73 */     this.shootingEntity = par2EntityLivingBase;
/*  74 */     this.shootingStand = (EntityKillerQueen)par2EntityLivingBase;
/*     */     
/*  76 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/*  78 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/*  81 */     this.posY = par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
/*  82 */     double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
/*  83 */     double d1 = par3EntityLivingBase.boundingBox.minY + (par3EntityLivingBase.height / 3.0F) - this.posY;
/*  84 */     double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
/*  85 */     double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
/*     */     
/*  87 */     if (d3 >= 1.0E-7D) {
/*     */       
/*  89 */       float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
/*  90 */       float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
/*  91 */       double d4 = d0 / d3;
/*  92 */       double d5 = d2 / d3;
/*  93 */       setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
/*  94 */       this.yOffset = 0.0F;
/*  95 */       float f4 = (float)d3 * 0.2F;
/*  96 */       setThrowableHeading(d0, d1 + f4, d2, par4, par5);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityKillerQueen_punch(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
/* 102 */     super(par1World);
/* 103 */     this.renderDistanceWeight = 10.0D;
/* 104 */     this.shootingEntity = par2EntityLivingBase;
/* 105 */     this.shootingStand = (EntityKillerQueen)par2EntityLivingBase;
/*     */     
/* 107 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/* 109 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/* 112 */     setSize(0.5F, 0.5F);
/* 113 */     setLocationAndAngles((this.shootingStand.getMaster()).posX, (this.shootingStand.getMaster()).posY + this.shootingStand.getMaster().getEyeHeight(), (this.shootingStand.getMaster()).posZ, (this.shootingStand.getMaster()).rotationYaw, (this.shootingStand.getMaster()).rotationPitch);
/* 114 */     this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 115 */     this.posY -= 0.10000000149011612D;
/* 116 */     this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 117 */     setPosition(this.posX, this.posY, this.posZ);
/* 118 */     this.yOffset = 0.0F;
/* 119 */     this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 120 */     this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 121 */     this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F);
/* 122 */     setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 127 */   protected void entityInit() { this.dataWatcher.addObject(16, Byte.valueOf((byte)0)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/* 135 */     float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
/* 136 */     par1 /= f2;
/* 137 */     par3 /= f2;
/* 138 */     par5 /= f2;
/* 139 */     par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 140 */     par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 141 */     par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 142 */     par1 *= par7;
/* 143 */     par3 *= par7;
/* 144 */     par5 *= par7;
/* 145 */     this.motionX = par1;
/* 146 */     this.motionY = par3;
/* 147 */     this.motionZ = par5;
/* 148 */     float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 149 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 150 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f3) * 180.0D / Math.PI);
/* 151 */     this.ticksInGround = 0;
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
/* 162 */     setPosition(par1, par3, par5);
/* 163 */     setRotation(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 173 */     this.motionX = par1;
/* 174 */     this.motionY = par3;
/* 175 */     this.motionZ = par5;
/*     */     
/* 177 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 179 */       float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 180 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 181 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f) * 180.0D / Math.PI);
/* 182 */       this.prevRotationPitch = this.rotationPitch;
/* 183 */       this.prevRotationYaw = this.rotationYaw;
/* 184 */       setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
/* 185 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 194 */     super.onUpdate();
/*     */     
/* 196 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 198 */       float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 199 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 200 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 203 */     Block blockA = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 204 */     int i = Block.getIdFromBlock(blockA);
/*     */     
/* 206 */     if (i > 0) {
/*     */       
/* 208 */       blockA.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 209 */       AxisAlignedBB axisalignedbb = blockA.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 211 */       if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
/*     */       {
/* 213 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 217 */     if (this.arrowShake > 0)
/*     */     {
/* 219 */       this.arrowShake--;
/*     */     }
/*     */     
/* 222 */     if (!this.inGround) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 227 */       this.ticksInAir++;
/* 228 */       if (this.ticksInAir >= 3)
/*     */       {
/* 230 */         setDead();
/*     */       }
/* 232 */       Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 233 */       Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 234 */       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
/* 235 */       vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 236 */       vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 238 */       if (movingobjectposition != null)
/*     */       {
/* 240 */         vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */       }
/*     */       
/* 243 */       Entity entity = null;
/* 244 */       List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 245 */       double d0 = 0.0D;
/*     */       
/*     */       int l;
/*     */       
/* 249 */       for (l = 0; l < list.size(); l++) {
/*     */         
/* 251 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 253 */         if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */           
/* 255 */           float f1 = 0.3F;
/* 256 */           AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
/* 257 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);
/*     */           
/* 259 */           if (movingobjectposition1 != null) {
/*     */             
/* 261 */             double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
/*     */             
/* 263 */             if (d1 < d0 || d0 == 0.0D) {
/*     */               
/* 265 */               entity = entity1;
/* 266 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 272 */       if (entity != null)
/*     */       {
/* 274 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 277 */       if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */         
/* 279 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
/*     */         
/* 281 */         if (entityplayer.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))
/*     */         {
/* 283 */           movingobjectposition = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 290 */       if (movingobjectposition != null)
/*     */       {
/* 292 */         if (movingobjectposition.entityHit != null) {
/*     */           
/* 294 */           if (!this.worldObj.isRemote)
/*     */           {
/* 296 */             if (this.shootingStand.getMaster() != null && movingobjectposition.entityHit == this.shootingStand.getMaster())
/*     */             {
/* 298 */               movingobjectposition = null;
/*     */             }
/*     */             else
/*     */             {
/* 302 */               this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 303 */               if (movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityVampire) {
/*     */                 
/* 305 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 10.0F);
/* 306 */                 movingobjectposition.entityHit.motionX += this.motionX / 2.0D;
/* 307 */                 movingobjectposition.entityHit.motionY += this.motionY + 0.5D;
/* 308 */                 movingobjectposition.entityHit.motionZ += this.motionZ / 2.0D;
/* 309 */                 setDead();
/*     */               }
/* 311 */               else if (movingobjectposition.entityHit instanceof Entityhamonuser) {
/*     */                 
/* 313 */                 Entityhamonuser hamonuser = (Entityhamonuser)movingobjectposition.entityHit;
/* 314 */                 if (hamonuser.getOwner() == this.shootingStand.getMaster())
/*     */                 {
/* 316 */                   movingobjectposition = null;
/*     */                 }
/*     */                 else
/*     */                 {
/* 320 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 3.0F);
/* 321 */                   movingobjectposition.entityHit.motionX += this.motionX / 2.0D;
/* 322 */                   movingobjectposition.entityHit.motionY += this.motionY + 0.5D;
/* 323 */                   movingobjectposition.entityHit.motionZ += this.motionZ / 2.0D;
/* 324 */                   setDead();
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 329 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 3.0F);
/* 330 */                 movingobjectposition.entityHit.motionX += this.motionX / 2.0D;
/* 331 */                 movingobjectposition.entityHit.motionY += this.motionY + 0.5D;
/* 332 */                 movingobjectposition.entityHit.motionZ += this.motionZ / 2.0D;
/* 333 */                 setDead();
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */         } else {
/*     */           
/* 341 */           this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 342 */           this.xTile = movingobjectposition.blockX;
/* 343 */           this.yTile = movingobjectposition.blockY;
/* 344 */           this.zTile = movingobjectposition.blockZ;
/* 345 */           this.inTile = Block.getIdFromBlock(this.worldObj.getBlock(this.xTile, this.yTile, this.zTile));
/* 346 */           this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/* 347 */           this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
/* 348 */           this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
/* 349 */           this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
/* 350 */           float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 351 */           this.posX -= this.motionX / f2 * 0.05000000074505806D;
/* 352 */           this.posY -= this.motionY / f2 * 0.05000000074505806D;
/* 353 */           this.posZ -= this.motionZ / f2 * 0.05000000074505806D;
/* 354 */           this.inGround = true;
/* 355 */           this.arrowShake = 7;
/* 356 */           setIsCritical(false);
/* 357 */           int p = 3;
/* 358 */           Block blockB = Block.getBlockById(this.inTile);
/* 359 */           setDead();
/* 360 */           if (this.inTile != 0)
/*     */           {
/* 362 */             blockB.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 367 */       if (getIsCritical())
/*     */       {
/* 369 */         for (l = 0; l < 4; l++)
/*     */         {
/* 371 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 375 */       this.posX += this.motionX;
/* 376 */       this.posY += this.motionY;
/* 377 */       this.posZ += this.motionZ;
/* 378 */       float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 379 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 381 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 386 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 388 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 391 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 393 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 396 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 398 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 401 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 402 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 403 */       float f4 = 0.99F;
/* 404 */       float f1 = 0.05F;
/*     */       
/* 406 */       if (isInWater()) {
/*     */         
/* 408 */         for (int j1 = 0; j1 < 4; j1++) {
/*     */           
/* 410 */           float f3 = 0.25F;
/* 411 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 414 */         f4 = 0.8F;
/*     */       } 
/*     */       
/* 417 */       this.motionX *= f4;
/* 418 */       this.motionY *= f4;
/* 419 */       this.motionZ *= f4;
/* 420 */       this.motionY -= f1;
/* 421 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 430 */     par1NBTTagCompound.setShort("xTile", (short)this.xTile);
/* 431 */     par1NBTTagCompound.setShort("yTile", (short)this.yTile);
/* 432 */     par1NBTTagCompound.setShort("zTile", (short)this.zTile);
/* 433 */     par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
/* 434 */     par1NBTTagCompound.setByte("inData", (byte)this.inData);
/* 435 */     par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
/* 436 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 437 */     par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
/* 438 */     par1NBTTagCompound.setDouble("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 446 */     this.xTile = par1NBTTagCompound.getShort("xTile");
/* 447 */     this.yTile = par1NBTTagCompound.getShort("yTile");
/* 448 */     this.zTile = par1NBTTagCompound.getShort("zTile");
/* 449 */     this.inTile = par1NBTTagCompound.getByte("inTile") & 0xFF;
/* 450 */     this.inData = par1NBTTagCompound.getByte("inData") & 0xFF;
/* 451 */     this.arrowShake = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 452 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */     
/* 454 */     if (par1NBTTagCompound.hasKey("damage"))
/*     */     {
/* 456 */       this.damage = par1NBTTagCompound.getDouble("damage");
/*     */     }
/*     */     
/* 459 */     if (par1NBTTagCompound.hasKey("pickup")) {
/*     */       
/* 461 */       this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
/*     */     }
/* 463 */     else if (par1NBTTagCompound.hasKey("player")) {
/*     */       
/* 465 */       this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 475 */   protected boolean canTriggerWalking() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 481 */   public float getShadowSize() { return 0.5F; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 486 */   public void setDamage(double par1) { this.damage = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 491 */   public double getDamage() { return this.damage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 499 */   public void setKnockbackStrength(int par1) { this.knockbackStrength = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 507 */   public boolean canAttackWithItem() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 515 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 517 */     if (par1) {
/*     */       
/* 519 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
/*     */     }
/*     */     else {
/*     */       
/* 523 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 532 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/* 533 */     return ((b0 & 1) != 0);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityKillerQueen_punch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */