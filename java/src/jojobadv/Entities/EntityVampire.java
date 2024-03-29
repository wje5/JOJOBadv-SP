/*     */ package src.jojobadv.Entities;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Items.JojoBAdvItems;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityVampire
/*     */   extends EntityMob
/*     */ {
/*     */   private boolean holding = false;
/*     */   private EntityLivingBase holdtarget;
/*  33 */   private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, net.minecraft.entity.player.EntityPlayer.class, 1.0D, true);
/*  34 */   private int atttick = 0;
/*     */   
/*     */   private boolean risk = false;
/*     */   
/*     */   public EntityVampire(World par1World) {
/*  39 */     super(par1World);
/*  40 */     getNavigator().setBreakDoors(true);
/*  41 */     this.tasks.addTask(0, new EntityAISwimming(this));
/*  42 */     this.tasks.addTask(1, new EntityAIOpenDoor(this, true));
/*  43 */     this.tasks.addTask(2, this.aiAttackOnCollide);
/*     */     
/*  45 */     this.tasks.addTask(3, new EntityAIAttackOnCollide(this, net.minecraft.entity.passive.EntityVillager.class, 1.0D, true));
/*  46 */     this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
/*  47 */     this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
/*  48 */     this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
/*  49 */     this.tasks.addTask(7, new EntityAIWatchClosest(this, net.minecraft.entity.player.EntityPlayer.class, 8.0F));
/*  50 */     this.tasks.addTask(7, new EntityAILookIdle(this));
/*  51 */     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
/*  52 */     this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.entity.player.EntityPlayer.class, 0, true));
/*  53 */     this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.entity.passive.EntityVillager.class, 0, false));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCombatTask() {
/*  58 */     if (this.risk) {
/*     */       
/*  60 */       this.atttick++;
/*  61 */       if (this.atttick >= 100) {
/*     */         
/*  63 */         this.tasks.addTask(2, this.aiAttackOnCollide);
/*  64 */         if (this.atttick >= 160) {
/*  65 */           this.atttick = 0;
/*     */         }
/*     */       } else {
/*     */         
/*  69 */         this.holdtarget = null;
/*  70 */         this.holding = false;
/*  71 */         this.tasks.removeTask(this.aiAttackOnCollide);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  76 */       this.tasks.addTask(2, this.aiAttackOnCollide);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  82 */   protected boolean isAIEnabled() { return true; }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  87 */     super.applyEntityAttributes();
/*  88 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0D);
/*  89 */     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
/*  90 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
/*  91 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  97 */     super.entityInit();
			  byte a = 0;
/*  98 */     this.dataWatcher.addObject(16, a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 103 */     super.onUpdate();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.fallDistance = 0.0F;
/* 110 */     setBesideClimbableBlock(this.isCollidedHorizontally);
/* 111 */     if (this.holdtarget != null && this.holdtarget.getHealth() > 0.0F) {
/*     */       
/* 113 */       if (this.holding)
/*     */       {
/* 115 */         if (!this.worldObj.isRemote)
/*     */         {
/* 117 */           hold_entity(this.holdtarget);
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 123 */     else if (!this.worldObj.isRemote) {
/*     */       
/* 125 */       this.holdtarget = null;
/* 126 */       this.holding = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public boolean isOnLadder() { return isBesideClimbableBlock(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public boolean isBesideClimbableBlock() { return ((this.dataWatcher.getWatchableObjectByte(16) & 1) != 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBesideClimbableBlock(boolean par1) {
/* 147 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/* 149 */     if (par1) {
/*     */       
/* 151 */       b0 = (byte)(b0 | 1);
/*     */     }
/*     */     else {
/*     */       
/* 155 */       b0 = (byte)(b0 & 0xFFFFFFFE);
/*     */     } 
/*     */     
/* 158 */     this.dataWatcher.updateObject(16, Byte.valueOf(b0));
/*     */   }
/*     */   
/* 161 */   public int healTimer = 0;
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 165 */     if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
/*     */       
/* 167 */       float f = getBrightness(1.0F);
/*     */       
/* 169 */       if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
/*     */       {
/* 171 */         attackEntityFrom(DamageSource.inFire, 100.0F);
/* 172 */         setFire(100);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 177 */       int timeDelay = 80;
/* 178 */       if (this.ticksExisted > getLastAttackerTime() + timeDelay) {
/*     */         
/* 180 */         this.healTimer++;
/* 181 */         if (this.healTimer > timeDelay)
/*     */         {
/* 183 */           heal(1.0F);
/* 184 */           this.healTimer = 0;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 189 */         this.healTimer = 0;
/*     */       } 
/*     */     } 
/*     */     
/* 193 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 200 */   protected String getLivingSound() { return "mob.zombie.say"; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 208 */   protected String getHurtSound() { return "mob.zombie.hurt"; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 216 */   protected String getDeathSound() { return "mob.zombie.death"; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 224 */   protected void playStepSound(int par1, int par2, int par3, int par4) { playSound("mob.zombie.step", 0.15F, 1.0F); }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 229 */     if (this.rand.nextInt(10) == 1)
/*     */     {
/* 231 */       return JojoBAdvItems.Bloodofvampire;
/*     */     }
/* 233 */     return Items.rotten_flesh;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 238 */     Item j = getDropItem();
/* 239 */     if (this.rand.nextInt(2) == 1)
/*     */     {
/* 241 */       dropItem(j, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 249 */   public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEAD; }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 254 */     boolean flag = super.attackEntityAsMob(par1Entity);
/*     */     
/* 256 */     this.holdtarget = (EntityLivingBase)par1Entity;
/* 257 */     if (!this.worldObj.isRemote && this.holdtarget != null && this.holdtarget.getHealth() > 0.0F) {
/*     */       
/* 259 */       this.holding = true;
/* 260 */       par1Entity.motionX = 0.0D;
/* 261 */       par1Entity.motionY = 0.0D;
/* 262 */       par1Entity.motionZ = 0.0D;
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   private void hold_entity(Entity par1Entity) {
/* 291 */     this.holdtarget.setSprinting(false);
/* 292 */     this.holdtarget.hurtResistantTime = 0;
/* 293 */     Entity entity = null;
/* 294 */     double d5 = par1Entity.getDistanceSq(this.posX, this.posY, this.posZ);
/* 295 */     double r = 0.0D;
/* 296 */     double closet = Math.PI * r * r * r;
/* 297 */     if (d5 > closet) {
/*     */       
/* 299 */       entity = par1Entity;
/* 300 */       double dx = this.posX - entity.posX;
/* 301 */       double dy = this.posY - entity.posY;
/* 302 */       double dz = this.posZ - entity.posZ;
/* 303 */       float impower = 0.1F;
/* 304 */       if (dx > 0.0D)
/*     */       {
/* 306 */         this.motionX += -impower;
/*     */       }
/* 308 */       if (dx < 0.0D)
/*     */       {
/* 310 */         this.motionX += impower;
/*     */       }
/*     */       
/* 313 */       if (dy > 0.0D)
/*     */       {
/* 315 */         this.motionY += -impower;
/*     */       }
/* 317 */       if (dy < 0.0D)
/*     */       {
/* 319 */         this.motionY += impower;
/*     */       }
/*     */       
/* 322 */       if (dz > 0.0D)
/*     */       {
/* 324 */         this.motionZ += -impower;
/*     */       }
/* 326 */       if (dz < 0.0D)
/*     */       {
/* 328 */         this.motionZ += impower;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 336 */     super.attackEntityFrom(par1DamageSource, par2);
/* 337 */     if (par2 > 5.0F)
/*     */     {
/* 339 */       this.holding = false;
/*     */     }
/* 341 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 347 */   public void readEntityFromNBT(NBTTagCompound nbttagcompound) { super.readEntityFromNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 353 */   public void writeEntityToNBT(NBTTagCompound nbttagcompound) { super.writeEntityToNBT(nbttagcompound); }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/EntityVampire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */