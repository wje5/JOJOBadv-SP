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
/*     */ public class EntityMagicians_Red
/*     */   extends EntityOneStand
/*     */ {
/*  15 */   private int oratick = 0;
/*     */   public boolean special = false;
/*  17 */   private int oratickr = 0;
/*     */   
/*     */   public EntityMagicians_Red(World par1World) {
/*  20 */     super(par1World);
/*  21 */     this.isImmuneToFire = true;
/*  22 */     setSize(1.2F, 2.7F);
/*  23 */     this.spawnSound = SoundEvents.spawn_mr.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  29 */   protected void applyEntityAttributes() { super.applyEntityAttributes(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  34 */   protected boolean canDespawn() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   protected boolean isAIEnabled() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   public void readEntityFromNBT(NBTTagCompound nbttagcompound) { super.readEntityFromNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   public void writeEntityToNBT(NBTTagCompound nbttagcompound) { super.writeEntityToNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  56 */     super.onUpdate();
/*  57 */     this.fallDistance = 0.0F;
/*  58 */     if (getMaster() != null) {
/*     */       
/*  60 */       getMaster().addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 40, 0));
/*  61 */       if (this.standOn) {
/*     */ 
/*     */         
/*     */         try {
/*  65 */           setHealth(1000.0F);
/*     */         }
/*  67 */         catch (ClassCastException classCastException) {}
/*     */ 
/*     */         
/*  70 */         fallowmaster();
/*  71 */         setRotationYawHead((getMaster()).rotationYaw);
/*  72 */         setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  73 */         if ((getMaster()).isDead)
/*     */         {
/*  75 */           setDead();
/*     */         }
/*     */         
/*  78 */         if (getMaster() instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */           
/*  80 */           if (getMaster().isSprinting()) {
/*     */             
/*  82 */             if (attackSwing(getMaster()))
/*     */             {
/*  84 */               if (getMaster().getFoodStats().getFoodLevel() > 6) {
/*     */                 
/*  86 */                 this.oratick++;
/*  87 */                 if (this.oratick == 1)
/*     */                 {
/*  89 */                   this.worldObj.playSoundAtEntity(this, SoundEvents.crossfire.toString(), 3.0F, 1.0F);
/*  90 */                   if (!(getMaster()).capabilities.isCreativeMode)
/*     */                   {
/*  92 */                     getMaster().getFoodStats().addStats(-6, 0.0F);
/*     */                   }
/*  94 */                   if (!this.worldObj.isRemote)
/*     */                   {
/*  96 */                     this.special = true;
/*     */                   }
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 102 */                 hungerMessage();
/*     */               }
/*     */             
/*     */             }
/*     */           }
/* 107 */           else if (attackSwing(getMaster())) {
/*     */             
/* 109 */             if (!this.worldObj.isRemote) {
/*     */ 
/*     */               
/* 112 */               this.oratick++;
/* 113 */               if (this.oratick == 1) {
/*     */                 
/* 115 */                 EntityMagicians_Red_fire entityarrow = new EntityMagicians_Red_fire(this.worldObj, this, 2.0F);
/* 116 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.fireball.toString(), 1.0F, 0.8F / (this.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/* 117 */                 entityarrow.setFire(100);
/* 118 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               } 
/*     */             } 
/*     */           } 
/* 122 */           if ((getMaster()).swingProgressInt == 1)
/*     */           {
/* 124 */             this.oratick = 0;
/*     */           }
/*     */           
/* 127 */           if (this.special) {
/*     */             
/* 129 */             setFire(2);
/* 130 */             getMaster().setSprinting(false);
/* 131 */             this.oratickr++;
/* 132 */             if (this.oratickr == 1)
/*     */             {
/* 134 */               getMaster().addChatMessage(new ChatComponentTranslation("msg.jojobadv.magicianred_crossfire.txt", new Object[0]));
/*     */             }
/* 136 */             if (!this.worldObj.isRemote) {
/*     */               
/* 138 */               this.worldObj.playSoundAtEntity(this, SoundEvents.fireball.toString(), 1.0F, 0.8F / (this.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/* 139 */               EntityMagicians_Red_fire entityarrow = new EntityMagicians_Red_fire(this.worldObj, this, 2.0F);
/* 140 */               entityarrow.setFire(100);
/* 141 */               this.worldObj.spawnEntityInWorld(entityarrow);
/*     */             } 
/* 143 */             if (this.oratickr >= 60) {
/*     */               
/* 145 */               if (!this.worldObj.isRemote)
/*     */               {
/* 147 */                 this.special = false;
/*     */               }
/* 149 */               this.oratickr = 0;
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
/* 163 */   public boolean isEntityInsideOpaqueBlock() { return false; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityMagicians_Red.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */