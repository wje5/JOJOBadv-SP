/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockSand;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.item.EntityFallingBlock;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
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
/*     */ public class EntityCrazyDiamond_punch
/*     */   extends Entity
/*     */   implements IProjectile {
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
/*     */   public EntityCrazyDiamond shootingStand;
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
/*     */   public EntityCrazyDiamond_punch(World par1World) {
/*  59 */     super(par1World);
/*  60 */     this.renderDistanceWeight = 10.0D;
/*  61 */     setSize(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityCrazyDiamond_punch(World par1World, double par2, double par4, double par6) {
/*  66 */     super(par1World);
/*  67 */     this.renderDistanceWeight = 10.0D;
/*  68 */     setSize(0.5F, 0.5F);
/*  69 */     setPosition(par2, par4, par6);
/*  70 */     this.yOffset = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityCrazyDiamond_punch(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  75 */     super(par1World);
/*  76 */     this.renderDistanceWeight = 10.0D;
/*  77 */     this.shootingEntity = par2EntityLivingBase;
/*  78 */     this.shootingStand = (EntityCrazyDiamond)par2EntityLivingBase;
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
/*     */   public EntityCrazyDiamond_punch(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
/* 106 */     super(par1World);
/* 107 */     this.renderDistanceWeight = 10.0D;
/* 108 */     this.shootingEntity = par2EntityLivingBase;
/* 109 */     this.shootingStand = (EntityCrazyDiamond)par2EntityLivingBase;
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
/* 120 */     if (this.shootingStand.orarush) {
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
/* 215 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 217 */       float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 218 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 219 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 222 */     Block blockA = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/*     */     
/* 224 */     if (blockA != null && blockA != Blocks.air) {
/*     */       
/* 226 */       blockA.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 227 */       AxisAlignedBB axisalignedbb = blockA.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 229 */       if (axisalignedbb != null && this.worldObj.checkBlockCollision(axisalignedbb))
/*     */       {
/* 231 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 235 */     if (this.arrowShake > 0)
/*     */     {
/* 237 */       this.arrowShake--;
/*     */     }
/*     */     
/* 240 */     if (!this.inGround) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 245 */       this.ticksInAir++;
/* 246 */       if (this.ticksInAir >= 3)
/*     */       {
/* 248 */         setDead();
/*     */       }
/* 250 */       Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 251 */       Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 252 */       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
/* 253 */       vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 254 */       vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 256 */       if (movingobjectposition != null)
/*     */       {
/* 258 */         vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */       }
/*     */       
/* 261 */       Entity entity = null;
/* 262 */       List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 263 */       double d0 = 0.0D;
/*     */       
/*     */       int l;
/*     */       
/* 267 */       for (l = 0; l < list.size(); l++) {
/*     */         
/* 269 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 271 */         if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */           
/* 273 */           float f1 = 0.3F;
/* 274 */           AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
/* 275 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);
/*     */           
/* 277 */           if (movingobjectposition1 != null) {
/*     */             
/* 279 */             double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
/*     */             
/* 281 */             if (d1 < d0 || d0 == 0.0D) {
/*     */               
/* 283 */               entity = entity1;
/* 284 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 290 */       if (entity != null)
/*     */       {
/* 292 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 295 */       if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */         
/* 297 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
/*     */         
/* 299 */         if (entityplayer.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))
/*     */         {
/* 301 */           movingobjectposition = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 308 */       if (movingobjectposition != null)
/*     */       {
/* 310 */         if (movingobjectposition.entityHit != null) {
/*     */           
/* 312 */           if (!this.worldObj.isRemote)
/*     */           {
/* 314 */             if (this.shootingStand.onheal)
/*     */             {
/* 316 */               if (this.shootingStand.getMaster() != null && movingobjectposition.entityHit == this.shootingStand.getMaster())
/*     */               {
/* 318 */                 movingobjectposition = null;
/*     */               }
/*     */               else
/*     */               {
/* 322 */                 setDead();
/* 323 */                 if (movingobjectposition.entityHit instanceof EntityLivingBase)
/*     */                 {
/* 325 */                   if (this.shootingStand.orarush) {
/*     */                     
/* 327 */                     ((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.heal.getId(), 40, 0));
/*     */                   }
/*     */                   else {
/*     */                     
/* 331 */                     ((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 40, 3));
/*     */                   } 
/* 333 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 0.0F);
/* 334 */                   movingobjectposition.entityHit.hurtResistantTime = 0;
/* 335 */                   movingobjectposition.entityHit.motionX = 0.0D;
/* 336 */                   movingobjectposition.entityHit.motionY = 0.0D;
/* 337 */                   movingobjectposition.entityHit.motionZ = 0.0D;
/*     */                 }
/*     */                 else
/*     */                 {
/* 341 */                   movingobjectposition.entityHit.motionX = 0.0D;
/* 342 */                   movingobjectposition.entityHit.motionY = 0.0D;
/* 343 */                   movingobjectposition.entityHit.motionZ = 0.0D;
/*     */                 }
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 349 */             else if (this.shootingStand.getMaster() != null && movingobjectposition.entityHit == this.shootingStand.getMaster())
/*     */             {
/* 351 */               movingobjectposition = null;
/*     */             }
/*     */             else
/*     */             {
/* 355 */               this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 356 */               float p = 0.2F;
/* 357 */               float p2 = 0.4F;
/* 358 */               if (movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityVampire) {
/*     */                 
/* 360 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 10.0F);
/* 361 */                 movingobjectposition.entityHit.hurtResistantTime = 0;
/* 362 */                 movingobjectposition.entityHit.motionX = 0.0D;
/* 363 */                 if (movingobjectposition.entityHit.posY > this.shootingStand.posY + 3.0D) {
/*     */                   
/* 365 */                   movingobjectposition.entityHit.motionY -= p2;
/*     */                 }
/*     */                 else {
/*     */                   
/* 369 */                   movingobjectposition.entityHit.motionY -= p;
/*     */                 } 
/* 371 */                 movingobjectposition.entityHit.motionZ = 0.0D;
/* 372 */                 setDead();
/*     */               }
/* 374 */               else if (movingobjectposition.entityHit instanceof Entityhamonuser) {
/*     */                 
/* 376 */                 Entityhamonuser hamonuser = (Entityhamonuser)movingobjectposition.entityHit;
/* 377 */                 if (hamonuser.getOwner() == this.shootingStand.getMaster())
/*     */                 {
/* 379 */                   movingobjectposition = null;
/*     */                 }
/*     */                 else
/*     */                 {
/* 383 */                   movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 2.0F);
/* 384 */                   movingobjectposition.entityHit.hurtResistantTime = 0;
/* 385 */                   movingobjectposition.entityHit.motionX = 0.0D;
/* 386 */                   if (movingobjectposition.entityHit.posY > this.shootingStand.posY + 3.0D) {
/*     */                     
/* 388 */                     movingobjectposition.entityHit.motionY -= p2;
/*     */                   }
/*     */                   else {
/*     */                     
/* 392 */                     movingobjectposition.entityHit.motionY -= p;
/*     */                   } 
/* 394 */                   movingobjectposition.entityHit.motionZ = 0.0D;
/* 395 */                   setDead();
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 400 */                 movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingStand.getMaster()), 2.0F);
/* 401 */                 movingobjectposition.entityHit.hurtResistantTime = 0;
/* 402 */                 movingobjectposition.entityHit.motionX = 0.0D;
/* 403 */                 if (movingobjectposition.entityHit.posY > this.shootingStand.posY + 3.0D) {
/*     */                   
/* 405 */                   movingobjectposition.entityHit.motionY -= p2;
/*     */                 }
/*     */                 else {
/*     */                   
/* 409 */                   movingobjectposition.entityHit.motionY -= p;
/*     */                 } 
/* 411 */                 movingobjectposition.entityHit.motionZ = 0.0D;
/* 412 */                 setDead();
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */         }
/*     */         else {
/*     */           
/* 421 */           this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 422 */           this.xTile = movingobjectposition.blockX;
/* 423 */           this.yTile = movingobjectposition.blockY;
/* 424 */           this.zTile = movingobjectposition.blockZ;
/* 425 */           this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 426 */           this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/* 427 */           this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
/* 428 */           this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
/* 429 */           this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
/* 430 */           float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 431 */           this.posX -= this.motionX / f2 * 0.05000000074505806D;
/* 432 */           this.posY -= this.motionY / f2 * 0.05000000074505806D;
/* 433 */           this.posZ -= this.motionZ / f2 * 0.05000000074505806D;
/* 434 */           this.inGround = true;
/* 435 */           this.arrowShake = 7;
/* 436 */           setIsCritical(false);
/* 437 */           int p = 3;
/* 438 */           Block block = this.inTile;
/* 439 */           float hardness = block.getBlockHardness(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 440 */           if (hardness != -1.0F && hardness < 3.0F) {
/*     */             
/* 442 */             if (!this.worldObj.isRemote)
/*     */             {
/* 444 */               if (this.shootingStand.onheal) {
/*     */                 
/* 446 */                 int par2 = (int)this.posX;
/* 447 */                 int par3 = (int)this.posY;
/* 448 */                 int par4 = (int)this.posZ;
/* 449 */                 int b0 = 32;
/* 450 */                 if (!BlockSand.fallInstantly && this.worldObj.checkChunksExist(par2 - b0, par3 - b0, par4 - b0, par2 + b0, par3 + b0, par4 + b0))
/*     */                 {
/* 452 */                   EntityFallingBlock entityfallingsand = new EntityFallingBlock(this.worldObj, (this.xTile + 0.5F), (this.yTile + 0.5F), (this.zTile + 0.5F), this.inTile, this.inData);
/* 453 */                   entityfallingsand.motionY = 0.5D;
/* 454 */                   this.worldObj.spawnEntityInWorld(entityfallingsand);
/* 455 */                   setDead();
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 460 */                 setDead();
/* 461 */                 //this.worldObj.setBlockToAir(this.xTile, this.yTile, this.zTile);
/* 462 */                 //block.dropBlockAsItemWithChance(this.worldObj, this.xTile, this.yTile, this.zTile, this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile), 1.0F, 0);
/*     */               }
/*     */             
/*     */             }
/*     */           } else {
/*     */             
/* 468 */             setDead();
/*     */           } 
/*     */           
/* 471 */           if (this.inTile != Blocks.air)
/*     */           {
/* 473 */             this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 478 */       if (getIsCritical())
/*     */       {
/* 480 */         for (l = 0; l < 4; l++)
/*     */         {
/* 482 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 486 */       this.posX += this.motionX;
/* 487 */       this.posY += this.motionY;
/* 488 */       this.posZ += this.motionZ;
/* 489 */       float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 490 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 492 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 497 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 499 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 502 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 504 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 507 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 509 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 512 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 513 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 514 */       float f4 = 0.99F;
/* 515 */       float f1 = 0.05F;
/*     */       
/* 517 */       if (isInWater()) {
/*     */         
/* 519 */         for (int j1 = 0; j1 < 4; j1++) {
/*     */           
/* 521 */           float f3 = 0.25F;
/* 522 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 525 */         f4 = 0.8F;
/*     */       } 
/*     */       
/* 528 */       this.motionX *= f4;
/* 529 */       this.motionY *= f4;
/* 530 */       this.motionZ *= f4;
/* 531 */       this.motionY -= f1;
/* 532 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 541 */     par1NBTTagCompound.setShort("xTile", (short)this.xTile);
/* 542 */     par1NBTTagCompound.setShort("yTile", (short)this.yTile);
/* 543 */     par1NBTTagCompound.setShort("zTile", (short)this.zTile);
/* 544 */     par1NBTTagCompound.setByte("inTile", (byte)this.inTile.getIdFromBlock(this.inTile));
/* 545 */     par1NBTTagCompound.setByte("inData", (byte)this.inData);
/* 546 */     par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
/* 547 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 548 */     par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
/* 549 */     par1NBTTagCompound.setDouble("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 557 */     this.xTile = par1NBTTagCompound.getShort("xTile");
/* 558 */     this.yTile = par1NBTTagCompound.getShort("yTile");
/* 559 */     this.zTile = par1NBTTagCompound.getShort("zTile");
/* 560 */     this.inTile.getBlockById(par1NBTTagCompound.getByte("inTile"));
/* 561 */     this.inData = par1NBTTagCompound.getByte("inData") & 0xFF;
/* 562 */     this.arrowShake = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 563 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */     
/* 565 */     if (par1NBTTagCompound.hasKey("damage"))
/*     */     {
/* 567 */       this.damage = par1NBTTagCompound.getDouble("damage");
/*     */     }
/*     */     
/* 570 */     if (par1NBTTagCompound.hasKey("pickup")) {
/*     */       
/* 572 */       this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
/*     */     }
/* 574 */     else if (par1NBTTagCompound.hasKey("player")) {
/*     */       
/* 576 */       this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 586 */   protected boolean canTriggerWalking() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 592 */   public float getShadowSize() { return 0.5F; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 597 */   public void setDamage(double par1) { this.damage = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 602 */   public double getDamage() { return this.damage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 610 */   public void setKnockbackStrength(int par1) { this.knockbackStrength = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 618 */   public boolean canAttackWithItem() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 626 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 628 */     if (par1) {
/*     */       
/* 630 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
/*     */     }
/*     */     else {
/*     */       
/* 634 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 643 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/* 644 */     return ((b0 & 1) != 0);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityCrazyDiamond_punch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */