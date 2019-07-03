/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.SoundEvents;
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
/*     */ public class EntityCrazyDiamond
/*     */   extends EntityOneStand
/*     */ {
/*  28 */   private int oratick = 0;
/*     */   public boolean orarush = false;
/*  30 */   private int oratickr = 0;
/*     */   public boolean onheal = false;
/*  32 */   private int changetick = 0;
/*     */   
/*     */   public EntityCrazyDiamond(World par1World) {
/*  35 */     super(par1World);
/*  36 */     setSize(1.2F, 2.7F);
/*  37 */     this.spawnSound = SoundEvents.spawn_cd.toString();
/*  38 */     setCatchPassive();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   protected void applyEntityAttributes() { super.applyEntityAttributes(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   protected boolean canDespawn() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   protected boolean isAIEnabled() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   public void readEntityFromNBT(NBTTagCompound nbttagcompound) { super.readEntityFromNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   public void writeEntityToNBT(NBTTagCompound nbttagcompound) { super.writeEntityToNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  71 */     super.onUpdate();
/*  72 */     this.fallDistance = 0.0F;
/*  73 */     if (getMaster() != null) {
/*     */       
/*  75 */       getMaster().addPotionEffect(new PotionEffect(Potion.resistance.getId(), 40, 2));
/*  76 */       if (this.onheal)
/*     */       {
/*  78 */         if (getMaster().getLastAttacker() != null && (getMaster().getLastAttacker()).hurtResistantTime != 0 && getMaster().getLastAttacker().getAITarget() == getMaster())
/*     */         {
/*  80 */           getMaster().getLastAttacker().addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 40, 3));
/*     */         }
/*     */       }
/*  83 */       if (getMaster().isSneaking()) {
/*     */         
/*  85 */         if (Math.abs((getMaster()).motionY) >= 0.3D) {
/*     */           
/*  87 */           this.changetick++;
/*  88 */           if (this.changetick == 1) {
/*     */             
/*  90 */             this.onheal = !this.onheal;
/*  91 */             if (this.onheal)
/*     */             {
/*  93 */               getMaster().addChatMessage(new ChatComponentTranslation("msg.jojobadv.fusion.txt", new Object[0]));
/*     */             }
/*     */             else
/*     */             {
/*  97 */               getMaster().addChatMessage(new ChatComponentTranslation("msg.jojobadv.destruction.txt", new Object[0]));
/*     */             }
/*     */           
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 104 */         this.changetick = 0;
/*     */       } 
/*     */ 
/*     */       
/* 108 */       if (this.standOn) {
/*     */ 
/*     */         
/*     */         try {
/* 112 */           setHealth(1000.0F);
/*     */         }
/* 114 */         catch (ClassCastException classCastException) {}
/*     */ 
/*     */ 
/*     */         
/* 118 */         fallowmaster();
/* 119 */         setRotationYawHead((getMaster()).rotationYaw);
/* 120 */         setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/* 121 */         if ((getMaster()).isDead)
/*     */         {
/* 123 */           setDead();
/*     */         }
/*     */         
/* 126 */         if (getMaster() instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */           
/* 128 */           if (getMaster().isSprinting()) {
/*     */             
/* 130 */             if (attackSwing(getMaster()))
/*     */             {
/* 132 */               if (getMaster().getFoodStats().getFoodLevel() > 6) {
/*     */                 
/* 134 */                 this.oratick++;
/* 135 */                 if (this.oratick == 1)
/*     */                 {
/* 137 */                   this.worldObj.playSoundAtEntity(this, SoundEvents.dorarush.toString(), 3.0F, 1.0F);
/* 138 */                   if (!(getMaster()).capabilities.isCreativeMode)
/*     */                   {
/* 140 */                     getMaster().getFoodStats().addStats(-6, 0.0F);
/*     */                   }
/* 142 */                   if (!this.worldObj.isRemote)
/*     */                   {
/* 144 */                     this.orarush = true;
/*     */                   }
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 150 */                 hungerMessage();
/*     */               }
/*     */             
/*     */             }
/*     */           }
/* 155 */           else if (attackSwing(getMaster())) {
/*     */             
/* 157 */             if (!this.worldObj.isRemote) {
/*     */ 
/*     */               
/* 160 */               this.oratick++;
/* 161 */               if (this.oratick == 1) {
/*     */                 
/* 163 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.knife_swing_miss1.toString(), 1.0F, 0.8F / (this.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/* 164 */                 EntityCrazyDiamond_punch entityarrow = new EntityCrazyDiamond_punch(this.worldObj, this, 2.0F);
/* 165 */                 entityarrow.setIsCritical(true);
/* 166 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               } 
/*     */             } 
/*     */           } 
/* 170 */           if ((getMaster()).swingProgressInt == 0)
/*     */           {
/* 172 */             this.oratick = 0;
/*     */           }
/*     */           
/* 175 */           if (this.orarush) {
/*     */             
/* 177 */             getMaster().setSprinting(false);
/* 178 */             this.oratickr++;
/* 179 */             if (this.oratickr >= 15)
/*     */             {
/* 181 */               if (!this.worldObj.isRemote) {
/*     */                 
/* 183 */                 getMaster().setSprinting(false);
/* 184 */                 EntityCrazyDiamond_punch entityarrow = new EntityCrazyDiamond_punch(this.worldObj, this, 2.0F);
/* 185 */                 entityarrow.setIsCritical(true);
/* 186 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */                 
/* 188 */                 EntityCrazyDiamond_punch entityarrow2 = new EntityCrazyDiamond_punch(this.worldObj, this, 2.0F);
/* 189 */                 entityarrow2.setIsCritical(true);
/* 190 */                 this.worldObj.spawnEntityInWorld(entityarrow2);
/*     */               } 
/*     */             }
/* 193 */             if (this.oratickr >= 80) {
/*     */               
/* 195 */               if (!this.worldObj.isRemote)
/*     */               {
/* 197 */                 this.orarush = false;
/*     */               }
/* 199 */               this.oratickr = 0;
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
/* 214 */   public boolean isEntityInsideOpaqueBlock() { return false; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityCrazyDiamond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */