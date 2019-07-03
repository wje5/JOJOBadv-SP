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
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntitySheerHeartAttack_target
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
/*     */   private int ticksInGround;
/*     */   private int ticksInAir;
/*  43 */   private double damage = 2.5D;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*     */   private boolean hit = false;
/*     */   private double dx;
/*     */   private double dy;
/*     */   private double dz;
/*  51 */   private int ticksifout = 0;
/*     */ 
/*     */   
/*     */   public EntitySheerHeartAttack_target(World par1World) {
/*  55 */     super(par1World);
/*  56 */     this.renderDistanceWeight = 10.0D;
/*  57 */     setSize(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntitySheerHeartAttack_target(World par1World, double par2, double par4, double par6) {
/*  63 */     super(par1World);
/*  64 */     this.renderDistanceWeight = 10.0D;
/*  65 */     setSize(0.5F, 0.5F);
/*  66 */     setPosition(par2, par4, par6);
/*  67 */     this.yOffset = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntitySheerHeartAttack_target(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  72 */     super(par1World);
/*  73 */     this.renderDistanceWeight = 10.0D;
/*  74 */     this.shootingEntity = par2EntityLivingBase;
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
/*     */   public EntitySheerHeartAttack_target(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
/* 102 */     super(par1World);
/* 103 */     this.renderDistanceWeight = 10.0D;
/* 104 */     this.shootingEntity = par2EntityLivingBase;
/*     */     
/* 106 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/* 108 */       this.canBePickedUp = 1;
/*     */     }
/*     */     
/* 111 */     setSize(0.5F, 0.5F);
/* 112 */     setLocationAndAngles(this.shootingEntity.posX, this.shootingEntity.posY + this.shootingEntity.getEyeHeight(), this.shootingEntity.posZ, this.shootingEntity.rotationYaw, this.shootingEntity.rotationPitch);
/* 113 */     this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 114 */     this.posY -= 0.10000000149011612D;
/* 115 */     this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 116 */     setPosition(this.posX, this.posY, this.posZ);
/* 117 */     this.yOffset = 0.0F;
/* 118 */     this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 119 */     this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
/* 120 */     this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F);
/* 121 */     setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 126 */   protected void entityInit() { this.dataWatcher.addObject(16, Byte.valueOf((byte)0)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/* 134 */     float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
/* 135 */     par1 /= f2;
/* 136 */     par3 /= f2;
/* 137 */     par5 /= f2;
/* 138 */     par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 139 */     par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 140 */     par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 141 */     par1 *= par7;
/* 142 */     par3 *= par7;
/* 143 */     par5 *= par7;
/* 144 */     this.motionX = par1;
/* 145 */     this.motionY = par3;
/* 146 */     this.motionZ = par5;
/* 147 */     float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 148 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 149 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f3) * 180.0D / Math.PI);
/* 150 */     this.ticksInGround = 0;
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
/* 161 */     setPosition(par1, par3, par5);
/* 162 */     setRotation(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 172 */     this.motionX = par1;
/* 173 */     this.motionY = par3;
/* 174 */     this.motionZ = par5;
/*     */     
/* 176 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 178 */       float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/* 179 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 180 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, f) * 180.0D / Math.PI);
/* 181 */       this.prevRotationPitch = this.rotationPitch;
/* 182 */       this.prevRotationYaw = this.rotationYaw;
/* 183 */       setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
/* 184 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 193 */     super.onUpdate();
/*     */     
/* 195 */     this.ticksifout++;
/* 196 */     if (this.ticksifout >= 3) {
/*     */       
/* 198 */       setDead();
/* 199 */       if (this.worldObj.isRemote || this.shootingEntity instanceof EntityPlayer);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/* 207 */       float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 208 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 209 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 212 */     Block blockA = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 213 */     int i = Block.getIdFromBlock(blockA);
/*     */     
/* 215 */     if (i > 0) {
/*     */       
/* 217 */       blockA.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
/* 218 */       AxisAlignedBB axisalignedbb = blockA.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 220 */       if (axisalignedbb == null || axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)));
/*     */     } 
/*     */ 
/*     */ 
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
/* 236 */       if (this.ticksInAir >= 3);
/*     */ 
/*     */       
/* 239 */       Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 240 */       Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 241 */       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
/* 242 */       vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 243 */       vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 245 */       if (movingobjectposition != null)
/*     */       {
/* 247 */         vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */       }
/*     */       
/* 250 */       Entity entity = null;
/* 251 */       List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 252 */       double d0 = 0.0D;
/*     */       
/*     */       int l;
/*     */       
/* 256 */       for (l = 0; l < list.size(); l++) {
/*     */         
/* 258 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 260 */         if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */           
/* 262 */           float f1 = 0.3F;
/* 263 */           AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
/* 264 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);
/*     */           
/* 266 */           if (movingobjectposition1 != null) {
/*     */             
/* 268 */             double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
/*     */             
/* 270 */             if (d1 < d0 || d0 == 0.0D) {
/*     */               
/* 272 */               entity = entity1;
/* 273 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 279 */       if (entity != null)
/*     */       {
/* 281 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 284 */       if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
/*     */         
/* 286 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
/*     */         
/* 288 */         if (entityplayer.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))
/*     */         {
/* 290 */           movingobjectposition = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 297 */       if (movingobjectposition != null)
/*     */       {
/* 299 */         if (movingobjectposition.entityHit != null && !(movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityOneStand))
/*     */         {
/* 301 */           if (!this.worldObj.isRemote)
/*     */           {
/* 303 */             if (movingobjectposition.entityHit != this.shootingEntity || !(movingobjectposition.entityHit instanceof src.jojobadv.Entities.EntityOneStand) || movingobjectposition.entityHit instanceof EntityLivingBase) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 309 */               setDead();
/* 310 */               EntitySheerHeartAttack entitypigzombie = new EntitySheerHeartAttack(this.worldObj);
/* 311 */               entitypigzombie.setLocationAndAngles(this.shootingEntity.posX, this.shootingEntity.posY, this.shootingEntity.posZ, this.shootingEntity.rotationYaw, this.shootingEntity.rotationPitch);
/* 312 */               this.worldObj.spawnEntityInWorld(entitypigzombie);
/* 313 */               entitypigzombie.setTarget(movingobjectposition.entityHit);
/* 314 */               entitypigzombie.setMaster(this.shootingEntity.getCommandSenderName());
/* 315 */               entitypigzombie.setMastername(this.shootingEntity.getCommandSenderName());
/*     */             } 
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 326 */       if (getIsCritical())
/*     */       {
/* 328 */         for (l = 0; l < 4; l++)
/*     */         {
/* 330 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 334 */       this.posX += this.motionX;
/* 335 */       this.posY += this.motionY;
/* 336 */       this.posZ += this.motionZ;
/* 337 */       float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 338 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 340 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 345 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 347 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 350 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 352 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 355 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 357 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 360 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 361 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 362 */       float f4 = 0.99F;
/* 363 */       float f1 = 0.05F;
/*     */       
/* 365 */       if (isInWater()) {
/*     */         
/* 367 */         for (int j1 = 0; j1 < 4; j1++) {
/*     */           
/* 369 */           float f3 = 0.25F;
/* 370 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 373 */         f4 = 0.8F;
/*     */       } 
/*     */       
/* 376 */       this.motionX *= f4;
/* 377 */       this.motionY *= f4;
/* 378 */       this.motionZ *= f4;
/* 379 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 388 */     par1NBTTagCompound.setShort("xTile", (short)this.xTile);
/* 389 */     par1NBTTagCompound.setShort("yTile", (short)this.yTile);
/* 390 */     par1NBTTagCompound.setShort("zTile", (short)this.zTile);
/* 391 */     par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
/* 392 */     par1NBTTagCompound.setByte("inData", (byte)this.inData);
/* 393 */     par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
/* 394 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 395 */     par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
/* 396 */     par1NBTTagCompound.setDouble("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 404 */     this.xTile = par1NBTTagCompound.getShort("xTile");
/* 405 */     this.yTile = par1NBTTagCompound.getShort("yTile");
/* 406 */     this.zTile = par1NBTTagCompound.getShort("zTile");
/* 407 */     this.inTile = par1NBTTagCompound.getByte("inTile") & 0xFF;
/* 408 */     this.inData = par1NBTTagCompound.getByte("inData") & 0xFF;
/* 409 */     this.arrowShake = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 410 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */     
/* 412 */     if (par1NBTTagCompound.hasKey("damage"))
/*     */     {
/* 414 */       this.damage = par1NBTTagCompound.getDouble("damage");
/*     */     }
/*     */     
/* 417 */     if (par1NBTTagCompound.hasKey("pickup")) {
/*     */       
/* 419 */       this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
/*     */     }
/* 421 */     else if (par1NBTTagCompound.hasKey("player")) {
/*     */       
/* 423 */       this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 433 */   protected boolean canTriggerWalking() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 439 */   public float getShadowSize() { return 0.5F; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 444 */   public void setDamage(double par1) { this.damage = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 449 */   public double getDamage() { return this.damage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 457 */   public void setKnockbackStrength(int par1) { this.knockbackStrength = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 465 */   public boolean canAttackWithItem() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 473 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 475 */     if (par1) {
/*     */       
/* 477 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
/*     */     }
/*     */     else {
/*     */       
/* 481 */       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 490 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/* 491 */     return ((b0 & 1) != 0);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntitySheerHeartAttack_target.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */