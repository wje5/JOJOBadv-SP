/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.Entities.Entityhamonuser;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ public class EntityEchoesAct3
/*     */   extends EntityOneStand
/*     */ {
/*  19 */   private int spawnsound = 0;
/*  20 */   private int spawntick = 0;
/*     */   public boolean special;
/*  22 */   private int specialtick = 0;
/*     */   
/*     */   private boolean canchange = false;
/*     */   
/*     */   public EntityEchoesAct3(World par1World) {
/*  27 */     super(par1World);
/*  28 */     setSize(0.8F, 1.5F);
/*  29 */     this.spawnSound = SoundEvents.spawn_ea.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void spawnAct1(EntityPlayer player) {
/*  34 */     if (!this.worldObj.isRemote) {
/*     */ 
/*     */       
/*  37 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  38 */       EntityEchoesAct1 entitypigzombie = new EntityEchoesAct1(this.worldObj);
/*  39 */       entitypigzombie.setLocationAndAngles((getMaster()).posX + 0.1D, (getMaster()).posY, (getMaster()).posZ, (getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  40 */       this.worldObj.spawnEntityInWorld(entitypigzombie);
/*  41 */       entitypigzombie.setMaster(getMaster().getCommandSenderName());
/*  42 */       entitypigzombie.setMastername(getMastername());
/*  43 */       entitypigzombie.bespawn();
/*  44 */       props.setPlayerStandAct(1);
/*  45 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanChangeAct() {
/*  52 */     EntityPlayer player = getMaster();
/*  53 */     if (player.onGround)
/*     */     {
/*  55 */       if (player.hurtTime < 5)
/*     */       {
/*  57 */         return true;
/*     */       }
/*     */     }
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeAct() {
/*  66 */     EntityPlayer player = getMaster();
/*  67 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  68 */     if (!this.worldObj.isRemote) {
/*     */       
/*  70 */       player.addChatMessage(new ChatComponentText("Act.1!"));
/*  71 */       spawnAct1(player);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  77 */     super.onUpdate();
/*  78 */     if (getMaster() != null)
/*     */     {
/*  80 */       if (this.standOn) {
/*     */         
/*  82 */         this.posY++;
/*     */         
/*  84 */         if (getMaster().isSprinting()) {
/*     */           
/*  86 */           if ((getMaster()).swingProgressInt != 0 && getMaster().getFoodStats().getFoodLevel() > 6)
/*     */           {
/*  88 */             if (!(getMaster()).capabilities.isCreativeMode)
/*     */             {
/*  90 */               getMaster().getFoodStats().addStats(-6, 0.0F);
/*     */             }
/*  92 */             this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.echoesrush.toString(), 3.0F, 1.0F);
/*  93 */             this.spawnsound++;
/*  94 */             if (this.spawnsound == 1)
/*     */             {
/*  96 */               this.special = true;
/*     */             }
/*     */           }
/*     */         
/* 100 */         } else if ((getMaster()).swingProgressInt != 0) {
/*     */           
/* 102 */           this.spawnsound++;
/* 103 */           if (this.spawnsound == 1)
/*     */           {
/* 105 */             EntityEchoesAct3_punch entityarrow = new EntityEchoesAct3_punch(this.worldObj, this, 2.0F);
/* 106 */             entityarrow.setIsCritical(true);
/* 107 */             this.worldObj.spawnEntityInWorld(entityarrow);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 112 */           this.spawnsound = 0;
/*     */         } 
/* 114 */         if (this.special) {
/*     */           
/* 116 */           getMaster().setSprinting(false);
/* 117 */           this.specialtick++;
/* 118 */           if (this.specialtick >= 20 && this.specialtick <= 58) {
/*     */             
/* 120 */             fallowmaster();
/* 121 */             if (!this.worldObj.isRemote) {
/*     */               
/* 123 */               getMaster().setSprinting(false);
/* 124 */               EntityEchoesAct3_punch entityarrow = new EntityEchoesAct3_punch(this.worldObj, this, 2.0F);
/* 125 */               entityarrow.setIsCritical(true);
/* 126 */               this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               
/* 128 */               EntityEchoesAct3_punch entityarrow2 = new EntityEchoesAct3_punch(this.worldObj, this, 2.0F);
/* 129 */               entityarrow2.setIsCritical(true);
/* 130 */               this.worldObj.spawnEntityInWorld(entityarrow2);
/*     */             } 
/*     */           } 
/* 133 */           if (this.specialtick >= 65 && this.specialtick < 69) {
/*     */             
/* 135 */             EntityEchoesAct3_punch entityarrow = new EntityEchoesAct3_punch(this.worldObj, this, 2.0F);
/* 136 */             entityarrow.setIsCritical(true);
/* 137 */             this.worldObj.spawnEntityInWorld(entityarrow);
/* 138 */             this.motionX = entityarrow.motionX / 2.0D;
/* 139 */             this.motionY = entityarrow.motionY / 2.0D;
/* 140 */             this.motionZ = entityarrow.motionZ / 2.0D;
/*     */           } 
/* 142 */           if (this.specialtick >= 65)
/*     */           {
/* 144 */             for (int i1 = 0; i1 < this.worldObj.loadedEntityList.size(); i1++) {
/*     */               
/* 146 */               Entity entityplayer1 = (Entity)this.worldObj.loadedEntityList.get(i1);
/* 147 */               double dst = entityplayer1.getDistanceSq(this.posX, this.posY, this.posZ);
/* 148 */               if (dst <= 15.0D && entityplayer1 instanceof EntityLivingBase && entityplayer1 != getMaster() && !(entityplayer1 instanceof EntityOneStand)) {
/*     */                 
/* 150 */                 entityplayer1.motionX = 0.0D;
/* 151 */                 entityplayer1.motionY = 0.0D;
/* 152 */                 entityplayer1.motionZ = 0.0D;
/* 153 */                 ((EntityLivingBase)entityplayer1).addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 100, 2));
/* 154 */                 ((EntityLivingBase)entityplayer1).addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 100, 'ϧ'));
/*     */                 
/* 156 */                 this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/* 157 */                 if (entityplayer1 instanceof src.jojobadv.Entities.EntityVampire) {
/*     */                   
/* 159 */                   entityplayer1.attackEntityFrom(DamageSource.causeMobDamage(getMaster()), 10.0F);
/* 160 */                   entityplayer1.motionX = 0.0D;
/* 161 */                   entityplayer1.motionY = 0.0D;
/* 162 */                   entityplayer1.motionZ = 0.0D;
/*     */                 }
/* 164 */                 else if (entityplayer1 instanceof Entityhamonuser) {
/*     */                   
/* 166 */                   Entityhamonuser hamonuser = (Entityhamonuser)entityplayer1;
/* 167 */                   if (hamonuser.getOwner() == getMaster())
/*     */                   {
/* 169 */                     entityplayer1 = null;
/*     */                   }
/*     */                   else
/*     */                   {
/* 173 */                     entityplayer1.attackEntityFrom(DamageSource.causeMobDamage(getMaster()), 2.0F);
/* 174 */                     entityplayer1.motionX = 0.0D;
/* 175 */                     entityplayer1.motionY = 0.0D;
/* 176 */                     entityplayer1.motionZ = 0.0D;
/*     */                   }
/*     */                 
/*     */                 } else {
/*     */                   
/* 181 */                   entityplayer1.attackEntityFrom(DamageSource.causeMobDamage(getMaster()), 2.0F);
/* 182 */                   entityplayer1.motionX = 0.0D;
/* 183 */                   entityplayer1.motionY = 0.0D;
/* 184 */                   entityplayer1.motionZ = 0.0D;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/* 189 */           if (this.specialtick == 80)
/*     */           {
/* 191 */             this.special = false;
/* 192 */             this.specialtick = 0;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 197 */           fallowmaster();
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 202 */         this.spawntick = 0;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityEchoesAct3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */