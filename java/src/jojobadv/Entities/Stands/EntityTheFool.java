/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ public class EntityTheFool
/*     */   extends EntityOneStand
/*     */ {
/*  14 */   private int oratick = 0;
/*     */   public boolean orarush = false;
/*  16 */   private int oratickr = 0;
/*     */   
/*     */   public EntityTheFool(World par1World) {
/*  19 */     super(par1World);
/*  20 */     setSize(1.2F, 1.6F);
/*  21 */     this.spawnSound = SoundEvents.spawn_tf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  27 */   protected void applyEntityAttributes() { super.applyEntityAttributes(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   protected boolean canDespawn() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   protected boolean isAIEnabled() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   public void readEntityFromNBT(NBTTagCompound nbttagcompound) { super.readEntityFromNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   public void writeEntityToNBT(NBTTagCompound nbttagcompound) { super.writeEntityToNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  54 */     super.onUpdate();
/*  55 */     this.fallDistance = 0.0F;
/*  56 */     if (getMaster() != null) {
/*     */       
/*  58 */       getMaster().addPotionEffect(new PotionEffect(Potion.resistance.getId(), 40, 2));
/*  59 */       if (this.standOn) {
/*     */ 
/*     */         
/*     */         try {
/*  63 */           setHealth(1000.0F);
/*     */         }
/*  65 */         catch (ClassCastException classCastException) {}
/*     */ 
/*     */         
/*  68 */         fallowmaster();
/*  69 */         setRotationYawHead((getMaster()).rotationYaw);
/*  70 */         setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  71 */         if ((getMaster()).isDead)
/*     */         {
/*  73 */           setDead();
/*     */         }
/*     */         
/*  76 */         if (getMaster() instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */           
/*  78 */           if (getMaster().isSprinting()) {
/*     */             
/*  80 */             if (attackSwing(getMaster()))
/*     */             {
/*  82 */               if (getMaster().getFoodStats().getFoodLevel() > 6) {
/*     */                 
/*  84 */                 this.oratick++;
/*  85 */                 if (this.oratick == 1)
/*     */                 {
/*  87 */                   this.worldObj.playSoundAtEntity(this, SoundEvents.orarush.toString(), 1.0F, 1.0F);
/*  88 */                   if (!(getMaster()).capabilities.isCreativeMode)
/*     */                   {
/*  90 */                     getMaster().getFoodStats().addStats(-6, 0.0F);
/*     */                   }
/*  92 */                   if (!this.worldObj.isRemote)
/*     */                   {
/*  94 */                     this.orarush = true;
/*     */                   }
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 100 */                 hungerMessage();
/*     */               }
/*     */             
/*     */             }
/*     */           }
/* 105 */           else if (attackSwing(getMaster())) {
/*     */             
/* 107 */             if (!this.worldObj.isRemote) {
/*     */ 
/*     */               
/* 110 */               this.oratick++;
/* 111 */               if (this.oratick == 1) {
/*     */                 
/* 113 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.last_ora.toString(), 1.0F, 0.8F / (this.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/* 114 */                 EntityStarplatinum_punch entityarrow = new EntityStarplatinum_punch(this.worldObj, this, 2.0F);
/* 115 */                 entityarrow.setIsCritical(true);
/* 116 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               } 
/*     */             } 
/*     */           } 
/* 120 */           if ((getMaster()).swingProgressInt == 0)
/*     */           {
/* 122 */             this.oratick = 0;
/*     */           }
/*     */           
/* 125 */           if (this.orarush) {
/*     */             
/* 127 */             getMaster().setSprinting(false);
/* 128 */             this.oratickr++;
/* 129 */             if (!this.worldObj.isRemote) {
/*     */               
/* 131 */               getMaster().setSprinting(false);
/* 132 */               EntityStarplatinum_punch entityarrow = new EntityStarplatinum_punch(this.worldObj, this, 2.0F);
/* 133 */               entityarrow.setIsCritical(true);
/* 134 */               this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               
/* 136 */               EntityStarplatinum_punch entityarrow2 = new EntityStarplatinum_punch(this.worldObj, this, 2.0F);
/* 137 */               entityarrow2.setIsCritical(true);
/* 138 */               this.worldObj.spawnEntityInWorld(entityarrow2);
/*     */             } 
/* 140 */             if (this.oratickr == 100) {
/*     */               
/* 142 */               if (!this.worldObj.isRemote)
/*     */               {
/* 144 */                 this.orarush = false;
/*     */               }
/* 146 */               this.oratickr = 0;
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
/* 160 */   public boolean isEntityInsideOpaqueBlock() { return false; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityTheFool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */