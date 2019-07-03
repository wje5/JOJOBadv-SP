/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IRangedAttackMob;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ public class EntitySilver_Chariot
/*     */   extends EntityOneStand
/*     */   implements IRangedAttackMob
/*     */ {
/*  18 */   private int oratick = 0;
/*  19 */   public int special = 0;
/*  20 */   private int oratickr = 0;
/*  21 */   private float range = 3.0F;
/*     */ 
/*     */   
/*     */   public EntitySilver_Chariot(World par1World) {
/*  25 */     super(par1World);
/*  26 */     this.tasks.addTask(6, new EntityAILookIdle(this));
/*  27 */     this.isImmuneToFire = true;
/*  28 */     setSize(1.0F, 2.7F);
/*  29 */     this.spawnSound = SoundEvents.spawn_sc.toString();
/*  30 */     setCatchPassive();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   protected void applyEntityAttributes() { super.applyEntityAttributes(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   protected boolean canDespawn() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   protected boolean isAIEnabled() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   public void readEntityFromNBT(NBTTagCompound nbttagcompound) { super.readEntityFromNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   public void writeEntityToNBT(NBTTagCompound nbttagcompound) { super.writeEntityToNBT(nbttagcompound); }
/*     */ 
/*     */   
/*  61 */   int sneakTimer = 0;
/*     */   
/*     */   int shedArmourTimer;
/*     */   boolean shedArmour = false;
/*     */   
/*     */   public void onUpdate() {
/*  67 */     super.onUpdate();
/*  68 */     this.fallDistance = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     if (getMaster() != null) {
/*     */       
/*  77 */       getMaster().addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 40, 2));
/*  78 */       if (this.standOn) {
/*     */         
/*  80 */         setRotationYawHead((getMaster()).rotationYaw);
/*  81 */         setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  82 */         fallowmaster();
/*     */         
/*     */         try {
/*  85 */           setHealth(1000.0F);
/*     */         }
/*  87 */         catch (ClassCastException classCastException) {}
/*     */ 
/*     */         
/*  90 */         if ((getMaster()).isDead)
/*     */         {
/*  92 */           setDead();
/*     */         }
/*     */         
/*  95 */         if (getMaster() instanceof EntityPlayer) {
/*     */           
/*  97 */           EntityPlayer player = getMaster();
/*  98 */           if (getMaster().isSneaking()) {
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
/* 112 */             if (getMaster().getFoodStats().getFoodLevel() > 12) {
/*     */               
/* 114 */               boolean jumpCheck = false;
/* 115 */               if (Math.abs((getMaster()).motionY) >= 0.2D)
/*     */               {
/* 117 */                 jumpCheck = true;
/*     */               }
/*     */               
/* 120 */               if (jumpCheck)
/*     */               {
/* 122 */                 this.special = 2;
/* 123 */                 jumpCheck = false;
/*     */               }
/*     */             
/*     */             } else {
/*     */               
/* 128 */               hungerMessage();
/*     */             }
/*     */           
/*     */           }
/* 132 */           else if (attackSwing(getMaster())) {
/*     */             
/* 134 */             if (player.isSprinting())
/*     */             {
/* 136 */               if (player.getFoodStats().getFoodLevel() > -6)
/*     */               {
/* 138 */                 this.special = 1;
/*     */               }
/*     */             }
/*     */             
/* 142 */             if (!this.worldObj.isRemote) {
/*     */ 
/*     */               
/* 145 */               this.oratick++;
/* 146 */               if (this.oratick == 1) {
/*     */                 
/* 148 */                 EntitySilver_Chariot_blade entityarrow = new EntitySilver_Chariot_blade(this.worldObj, this, 2.0F);
/* 149 */                 this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.knife_swing_miss1.toString(), 0.3F, 4.0F);
/* 150 */                 entityarrow.setIsCritical(true);
/* 151 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               } 
/*     */             } 
/*     */           } 
/* 155 */           if ((getMaster()).swingProgressInt == 0)
/*     */           {
/* 157 */             this.oratick = 0;
/*     */           }
/*     */           
/* 160 */           if (this.special != 0) {
/*     */             
/* 162 */             getMaster().addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 2));
/* 163 */             this.posX += this.rand.nextInt(3);
/* 164 */             this.posX -= this.rand.nextInt(3);
/* 165 */             this.posZ += this.rand.nextInt(3);
/* 166 */             this.posZ -= this.rand.nextInt(3);
/* 167 */             this.oratickr++;
/* 168 */             this.oratick = 0;
/* 169 */             int rapidAttackTime = 0;
/* 170 */             int foodUsed = 0;
/* 171 */             if (this.special == 1) { rapidAttackTime = 60; foodUsed = -3; }
/* 172 */              if (this.special == 2) { rapidAttackTime = 40; foodUsed = -6; }
/*     */             
/* 174 */             if (this.oratickr <= 1) {
/*     */               
/* 176 */               this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.sc_gung.toString(), 3.0F, 1.0F);
/* 177 */               if (!(getMaster()).capabilities.isCreativeMode)
/*     */               {
/* 179 */                 getMaster().getFoodStats().addStats(foodUsed * 2, 0.0F);
/*     */               }
/*     */             }
/* 182 */             else if (this.oratickr < rapidAttackTime) {
/*     */               
/* 184 */               EntitySilver_Chariot_blade entityarrow = new EntitySilver_Chariot_blade(this.worldObj, this, 2.0F);
/* 185 */               this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.knife_swing_miss2.toString(), 0.3F, 4.0F);
/* 186 */               entityarrow.setIsCritical(true);
/* 187 */               if (this.special == 2) {
/*     */                 
/* 189 */                 entityarrow.setFire(100);
/* 190 */                 entityarrow.onFire = true;
/*     */               } 
/* 192 */               this.worldObj.spawnEntityInWorld(entityarrow);
/*     */             } 
/*     */             
/* 195 */             if (this.oratickr >= rapidAttackTime) {
/*     */               
/* 197 */               if (!this.worldObj.isRemote)
/*     */               {
/* 199 */                 this.special = 0;
/*     */               }
/* 201 */               this.oratickr = 0;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/* 233 */   public boolean isEntityInsideOpaqueBlock() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float f) {
/* 239 */     EntitySilver_Chariot_blade entityarrow = new EntitySilver_Chariot_blade(this.worldObj, this, 2.0F);
/* 240 */     this.worldObj.spawnEntityInWorld(entityarrow);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntitySilver_Chariot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */