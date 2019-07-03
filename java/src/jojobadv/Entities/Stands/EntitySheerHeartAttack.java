/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
/*     */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ public class EntitySheerHeartAttack
/*     */   extends EntityOneStand
/*     */ {
/*     */   private boolean targeting = true;
/*  20 */   private int attv = 0;
/*     */ 
/*     */   
/*     */   public EntitySheerHeartAttack(World par1World) {
/*  24 */     super(par1World);
/*  25 */     setSize(0.3F, 0.3F);
/*  26 */     getNavigator().setBreakDoors(true);
/*  27 */     this.tasks.addTask(0, new EntityAISwimming(this));
/*  28 */     this.tasks.addTask(1, new EntityAIOpenDoor(this, true));
/*  29 */     this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
/*  30 */     this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
/*  31 */     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
/*     */   }
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  35 */     super.applyEntityAttributes();
/*  36 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(99999.0D);
/*  37 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/*  41 */     super.entityInit();
byte a = 0;
/*  42 */     this.dataWatcher.addObject(16, a);
/*     */   }
/*     */   
/*     */   public void onUpdate() {
/*  46 */     super.onUpdate();
/*  47 */     setBesideClimbableBlock(this.isCollidedHorizontally);
/*  48 */     if (getEntityToAttack() != null) {
/*     */       
/*  50 */       double dst = getEntityToAttack().getDistanceSq(this.posX, this.posY, this.posZ);
/*  51 */       if (dst < 2.0D && !this.worldObj.isRemote) {
/*     */         
/*  53 */         this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 4.0F, true);
/*  54 */         if (!this.worldObj.isRemote)
/*     */         {
/*     */           
/*  57 */           setDead();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  64 */   public boolean isOnLadder() { return isBesideClimbableBlock(); }
/*     */ 
/*     */ 
/*     */   
/*  68 */   public boolean isBesideClimbableBlock() { return ((this.dataWatcher.getWatchableObjectByte(16) & 1) != 0); }
/*     */ 
/*     */   
/*     */   public void setBesideClimbableBlock(boolean par1) {
/*  72 */     byte b0 = this.dataWatcher.getWatchableObjectByte(16);
/*     */     
/*  74 */     if (par1) {
/*     */       
/*  76 */       b0 = (byte)(b0 | 1);
/*     */     }
/*     */     else {
/*     */       
/*  80 */       b0 = (byte)(b0 & 0xFFFFFFFE);
/*     */     } 
/*     */     
/*  83 */     this.dataWatcher.updateObject(16, Byte.valueOf(b0));
/*     */   }
/*     */   
/*     */   protected void attackEntity(Entity par1Entity, float par2) {
/*  87 */     if (par2 > 2.0F && par2 < 6.0F) {
/*     */       
/*  89 */       this.attv++;
/*  90 */       if (this.attv == 1)
/*     */       {
/*  92 */         this.worldObj.playSoundAtEntity(this, SoundEvents.sha_a.toString(), 1.0F, 1.0F);
/*     */       }
/*  94 */       if (this.onGround)
/*     */       {
/*  96 */         double d0 = par1Entity.posX - this.posX;
/*  97 */         double d1 = par1Entity.posZ - this.posZ;
/*  98 */         float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
/*  99 */         this.motionX = d0 / f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
/* 100 */         this.motionZ = d1 / f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
/* 101 */         this.motionY = 0.6000000059604645D;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 106 */       super.attackEntity(par1Entity, par2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntitySheerHeartAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */