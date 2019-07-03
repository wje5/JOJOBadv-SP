/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
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
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityEmperor_bullet
/*     */   extends Entity
/*     */   implements IProjectile
/*     */ {
/*     */   boolean flag = true;
/*  34 */   int timer = 0;
/*  35 */   private int xTile = -1;
/*  36 */   private int yTile = -1;
/*  37 */   private int zTile = -1;
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
/*     */   private int ticksInGround;
/*     */   private int ticksInAir;
/*  52 */   private double damage = 2.5D;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*     */   private boolean hit = false;
/*     */   
/*     */   private double dx;
/*     */   private double dy;
/*     */   private double dz;
/*     */   
/*     */   public EntityEmperor_bullet(World par1World) {
/*  63 */     super(par1World);
/*  64 */     this.renderDistanceWeight = 10.0D;
/*  65 */     setSize(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityEmperor_bullet(World par1World, double par2, double par4, double par6) {
/*  70 */     super(par1World);
/*  71 */     this.renderDistanceWeight = 10.0D;
/*  72 */     setSize(0.5F, 0.5F);
/*  73 */     setPosition(par2, par4, par6);
/*  74 */     this.yOffset = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityEmperor_bullet(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  79 */     super(par1World);
/*  80 */     this.renderDistanceWeight = 10.0D;
/*  81 */     this.shootingEntity = par2EntityLivingBase;
/*     */     
/*  83 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/*  85 */       this.canBePickedUp = 0;
/*     */     }
/*     */     
/*  88 */     this.posY = par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
/*  89 */     double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
/*  90 */     double d1 = par3EntityLivingBase.boundingBox.minY + (par3EntityLivingBase.height / 3.0F) - this.posY;
/*  91 */     double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
/*  92 */     double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
/*     */     
/*  94 */     if (d3 >= 1.0E-7D) {
/*     */       
/*  96 */       float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
/*  97 */       float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
/*  98 */       double d4 = d0 / d3;
/*  99 */       double d5 = d2 / d3;
/* 100 */       setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
/* 101 */       this.yOffset = 0.0F;
/* 102 */       float f4 = (float)d3 * 0.2F;
/* 103 */       setThrowableHeading(d0, d1 + f4, d2, par4, par5);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityEmperor_bullet(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
/* 109 */     super(par1World);
/* 110 */     this.renderDistanceWeight = 10.0D;
/* 111 */     this.shootingEntity = par2EntityLivingBase;
/*     */     
/* 113 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/* 115 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/* 118 */     setSize(0.5F, 0.5F);
/*     */ 
/*     */ 
/*     */     
/* 122 */     setLocationAndAngles(this.shootingEntity.posX, this.shootingEntity.posY + this.shootingEntity.getEyeHeight(), this.shootingEntity.posZ, this.shootingEntity.rotationYaw, this.shootingEntity.rotationPitch);
/* 123 */     this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 124 */     this.posY -= 0.10000000149011612D;
/* 125 */     this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 126 */     setPosition(this.posX, this.posY, this.posZ);
/* 127 */     this.yOffset = 0.0F;
/* 128 */     this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 129 */     this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 130 */     this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F);
/* 131 */     setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 136 */   protected void entityInit() { this.dataWatcher.addObject(16, Byte.valueOf((byte)0)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/* 144 */     float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
/* 145 */     par1 /= f2;
/* 146 */     par3 /= f2;
/* 147 */     par5 /= f2;
/* 148 */     par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 149 */     par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 150 */     par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 151 */     par1 *= par7;
/* 152 */     par3 *= par7;
/* 153 */     par5 *= par7;
/* 154 */     this.motionX = par1;
/* 155 */     this.motionY = par3;
/* 156 */     this.motionZ = par5;
/* 157 */     float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 158 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 159 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f3) * 180.0D / Math.PI);
/* 160 */     this.ticksInGround = 0;
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
/* 171 */     setPosition(par1, par3, par5);
/* 172 */     setRotation(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 182 */     this.motionX = par1;
/* 183 */     this.motionY = par3;
/* 184 */     this.motionZ = par5;
/*     */     
/* 186 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 188 */       float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 189 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 190 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f) * 180.0D / Math.PI);
/* 191 */       this.prevRotationPitch = this.rotationPitch;
/* 192 */       this.prevRotationYaw = this.rotationYaw;
/* 193 */       setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
/* 194 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTarget() {
/* 200 */     Entity Etarget = null;
/* 201 */     if (!this.worldObj.isRemote)
/*     */     {
/* 203 */       if (Etarget == null) {
/*     */         EntityLivingBase entityLivingBase = null;
/* 205 */         Vector vc = new Vector();
/* 206 */         for (int i1 = 0; i1 < this.worldObj.loadedEntityList.size(); i1++) {
/*     */           
/* 208 */           Entity target = (Entity)this.worldObj.loadedEntityList.get(i1);
/* 209 */           double dst = target.getDistanceSq(this.posX, this.posY, this.posZ);
/* 210 */           int r = 2;
/* 211 */           double d2 = Math.PI * r * r * r;
/* 212 */           if (dst <= d2 && target != this.shootingEntity && target instanceof EntityLivingBase && target.hurtResistantTime == 0 && !(target instanceof src.jojobadv.Entities.Entityhamon) && !(target instanceof src.jojobadv.Entities.EntityVampirepower) && !(target instanceof src.jojobadv.Entities.EntityOneStand) && !(target instanceof net.minecraft.entity.player.EntityPlayerMP)) {
/*     */ 
/*     */ 
/*     */             
/* 216 */             vc.add(target);
/* 217 */             this.motionX = 0.0D;
/* 218 */             this.motionY = 0.0D;
/* 219 */             this.motionZ = 0.0D;
/*     */           } 
/*     */         } 
/* 222 */         double closest = 9999.0D;
/* 223 */         for (int i1 = 0; i1 < vc.size(); i1++) {
/*     */           
/* 225 */           if (((EntityLivingBase)vc.get(i1)).getDistanceSqToEntity(this) < closest) {
/*     */             
/* 227 */             closest = ((EntityLivingBase)vc.get(i1)).getDistanceSqToEntity(this);
/* 228 */             entityLivingBase = (EntityLivingBase)vc.get(i1);
/*     */           } 
/*     */         } 
/*     */         
/* 232 */         if (entityLivingBase != null)
/*     */         {
/* 234 */           if (entityLivingBase.hurtResistantTime != 0) {
/*     */             
/* 236 */             entityLivingBase = null;
/*     */           }
/*     */           else {
/*     */             
/* 240 */             double maxSpeed = 1.0D;
/*     */             
/* 242 */             double dx = this.posX - entityLivingBase.posX;
/* 243 */             double dy = this.posY - 1.0D - entityLivingBase.posY;
/* 244 */             double dz = this.posZ - entityLivingBase.posZ;
/* 245 */             double impower = getDistanceSqToEntity(entityLivingBase) / 70.0D;
/* 246 */             double dis = 0.0D;
/* 247 */             if (dx > dis && this.motionX > -maxSpeed) {
/*     */               
/* 249 */               this.motionX += -impower;
/* 250 */               if (this.rand.nextInt(30) == 0)
/* 251 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.bullet_shot1.toString(), 0.2F, 1.0F); 
/*     */             } 
/* 253 */             if (dx < dis && this.motionX < maxSpeed) {
/*     */               
/* 255 */               this.motionX += impower;
/* 256 */               if (this.rand.nextInt(30) == 0) {
/* 257 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.bullet_shot2.toString(), 0.2F, 1.0F);
/*     */               }
/*     */             } 
/* 260 */             if (dy > dis && this.motionY > -maxSpeed) {
/*     */               
/* 262 */               this.motionY += -impower;
/* 263 */               if (this.rand.nextInt(30) == 0)
/* 264 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.bullet_shot1.toString(), 0.2F, 1.0F); 
/*     */             } 
/* 266 */             if (dy < dis && this.motionY < maxSpeed) {
/*     */               
/* 268 */               this.motionY += impower;
/* 269 */               if (this.rand.nextInt(30) == 0) {
/* 270 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.bullet_shot2.toString(), 0.2F, 1.0F);
/*     */               }
/*     */             } 
/* 273 */             if (dz > dis && this.motionZ > -maxSpeed) {
/*     */               
/* 275 */               this.motionZ += -impower;
/* 276 */               if (this.rand.nextInt(30) == 0)
/* 277 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.bullet_shot1.toString(), 0.2F, 1.0F); 
/*     */             } 
/* 279 */             if (dz < dis && this.motionZ < maxSpeed) {
/*     */               
/* 281 */               this.motionZ += impower;
/* 282 */               if (this.rand.nextInt(30) == 0) {
/* 283 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.bullet_shot2.toString(), 0.2F, 1.0F);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 295 */     super.onUpdate();
/* 296 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 298 */       float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 299 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 300 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 303 */     Block blockA = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/*     */     
/* 305 */     if (blockA != Blocks.air) {
/*     */       
/* 307 */       blockA.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 308 */       AxisAlignedBB axisalignedbb = blockA.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 310 */       if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
/*     */       {
/* 312 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 316 */     if (this.arrowShake > 0)
/*     */     {
/* 318 */       this.arrowShake--;
/*     */     }
/*     */     
/* 321 */     this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/* 322 */     this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/* 323 */     this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/* 324 */     this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/* 325 */     this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/* 326 */     this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/* 327 */     this.ticksInAir++;
/* 328 */     if (this.ticksInAir >= 60)
/*     */     {
/* 330 */       setDead();
/*     */     }
/* 332 */     setTarget();
/* 333 */     Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 334 */     Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 335 */     MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
/* 336 */     vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 337 */     vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */     
/* 339 */     if (movingobjectposition != null)
/*     */     {
/* 341 */       vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */     }
/*     */     
/* 344 */     Entity entity = null;
/* 345 */     List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 346 */     double d0 = 0.0D;
/*     */ 
/*     */ 
/*     */     
/* 350 */     for (int l = 0; l < list.size(); l++) {
/*     */       
/* 352 */       Entity entity1 = (Entity)list.get(l);
/*     */       
/* 354 */       if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
/* 355 */         entity = entity1;
/*     */       }
/*     */     } 
/* 358 */     if (entity != null)
/*     */     {
/* 360 */       movingobjectposition = new MovingObjectPosition(entity);
/*     */     }
/*     */     
/* 363 */     if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */       
/* 365 */       EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
/*     */       
/* 367 */       if (entityplayer.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))
/*     */       {
/* 369 */         movingobjectposition = null;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 376 */     if (movingobjectposition != null)
/*     */     {
/* 378 */       if (movingobjectposition.entityHit != null) {
/*     */         
/* 380 */         if (!this.worldObj.isRemote) {
/*     */           
/* 382 */           movingobjectposition.entityHit.motionX = 0.0D;
/* 383 */           movingobjectposition.entityHit.motionY = 0.0D;
/* 384 */           movingobjectposition.entityHit.motionZ = 0.0D;
/*     */           
/* 386 */           if (movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityVampire) {
/*     */             
/* 388 */             movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), 3.0F);
/* 389 */             movingobjectposition.entityHit.hurtResistantTime = 0;
/*     */           }
/* 391 */           else if (movingobjectposition.entityHit instanceof Entityhamonuser) {
/*     */             
/* 393 */             Entityhamonuser hamonuser = (Entityhamonuser)movingobjectposition.entityHit;
/* 394 */             if (hamonuser.getOwner() == this.shootingEntity)
/*     */             {
/* 396 */               movingobjectposition = null;
/*     */             }
/* 398 */             else if (this.rand.nextInt(3) == 1)
/*     */             {
/* 400 */               movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), 5.0F);
/* 401 */               movingobjectposition.entityHit.hurtResistantTime = 0;
/*     */             }
/*     */             else
/*     */             {
/* 405 */               movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), 3.0F);
/* 406 */               movingobjectposition.entityHit.hurtResistantTime = 0;
/*     */             }
/*     */           
/* 409 */           } else if (movingobjectposition.entityHit instanceof net.minecraft.entity.monster.EntityMob) {
/*     */             
/* 411 */             movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), 10.0F);
/* 412 */             movingobjectposition.entityHit.hurtResistantTime = 0;
/*     */           }
/* 414 */           else if (movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */             
/* 416 */             movingobjectposition.entityHit.setSneaking(true);
/* 417 */             if (this.rand.nextInt(3) == 1)
/*     */             {
/* 419 */               movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), 5.0F);
/* 420 */               movingobjectposition.entityHit.hurtResistantTime = 0;
/*     */             }
/*     */             else
/*     */             {
/* 424 */               movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), 3.0F);
/* 425 */               movingobjectposition.entityHit.hurtResistantTime = 0;
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 430 */           else if (this.rand.nextInt(3) == 1) {
/*     */             
/* 432 */             movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), 5.0F);
/* 433 */             movingobjectposition.entityHit.hurtResistantTime = 0;
/*     */           }
/*     */           else {
/*     */             
/* 437 */             movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), 3.0F);
/* 438 */             movingobjectposition.entityHit.hurtResistantTime = 0;
/*     */           } 
/*     */         } 
/*     */         
/* 442 */         setDead();
/*     */       } 
/*     */     }
/*     */     
/* 446 */     this.posX += this.motionX;
/* 447 */     this.posY += this.motionY;
/* 448 */     this.posZ += this.motionZ;
/* 449 */     float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 450 */     this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */     
/* 452 */     for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 457 */     while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */     {
/* 459 */       this.prevRotationPitch += 360.0F;
/*     */     }
/*     */     
/* 462 */     while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */     {
/* 464 */       this.prevRotationYaw -= 360.0F;
/*     */     }
/*     */     
/* 467 */     while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */     {
/* 469 */       this.prevRotationYaw += 360.0F;
/*     */     }
/*     */     
/* 472 */     this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 473 */     this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 474 */     float f4 = 0.99F;
/* 475 */     float f1 = 0.05F;
/*     */     
/* 477 */     if (isInWater()) {
/*     */       
/* 479 */       for (int j1 = 0; j1 < 4; j1++) {
/*     */         
/* 481 */         float f3 = 0.25F;
/* 482 */         this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
/*     */       } 
/*     */       
/* 485 */       f4 = 0.8F;
/*     */     } 
/*     */     
/* 488 */     this.motionX *= f4;
/* 489 */     this.motionY *= f4;
/* 490 */     this.motionZ *= f4;
/* 491 */     setPosition(this.posX, this.posY, this.posZ);
/*     */     
/* 493 */     if (this.ticksExisted > 100)
/*     */     {
/* 495 */       setDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 505 */     par1NBTTagCompound.setShort("xTile", (short)this.xTile);
/* 506 */     par1NBTTagCompound.setShort("yTile", (short)this.yTile);
/* 507 */     par1NBTTagCompound.setShort("zTile", (short)this.zTile);
/* 508 */     par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
/* 509 */     par1NBTTagCompound.setByte("inData", (byte)this.inData);
/* 510 */     par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
/* 511 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 512 */     par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
/* 513 */     par1NBTTagCompound.setDouble("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 521 */     this.xTile = par1NBTTagCompound.getShort("xTile");
/* 522 */     this.yTile = par1NBTTagCompound.getShort("yTile");
/* 523 */     this.zTile = par1NBTTagCompound.getShort("zTile");
/* 524 */     this.inTile = par1NBTTagCompound.getByte("inTile") & 0xFF;
/* 525 */     this.inData = par1NBTTagCompound.getByte("inData") & 0xFF;
/* 526 */     this.arrowShake = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 527 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */     
/* 529 */     if (par1NBTTagCompound.hasKey("damage"))
/*     */     {
/* 531 */       this.damage = par1NBTTagCompound.getDouble("damage");
/*     */     }
/*     */     
/* 534 */     if (par1NBTTagCompound.hasKey("pickup")) {
/*     */       
/* 536 */       this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
/*     */     }
/* 538 */     else if (par1NBTTagCompound.hasKey("player")) {
/*     */       
/* 540 */       this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 550 */   protected boolean canTriggerWalking() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 556 */   public float getShadowSize() { return 0.5F; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 561 */   public void setDamage(double par1) { this.damage = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 566 */   public double getDamage() { return this.damage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 574 */   public void setKnockbackStrength(int par1) { this.knockbackStrength = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 582 */   public boolean canAttackWithItem() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 590 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 592 */     if (par1) {
/*     */       
/* 594 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
/*     */     }
/*     */     else {
/*     */       
/* 598 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 607 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/* 608 */     return ((b0 & 1) != 0);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityEmperor_bullet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */