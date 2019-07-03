/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ public class EntityEchoesAct2
/*     */   extends EntityOneStand {
/*  12 */   private int spawnsound = 0;
/*     */   public boolean windat = false;
/*     */   public boolean exat = false;
/*     */   public boolean fireat = false;
/*     */   public boolean tailout = false;
/*  17 */   private int spawntick = 0;
/*     */ 
/*     */   
/*     */   public EntityEchoesAct2(World par1World) {
/*  21 */     super(par1World);
/*  22 */     setSize(1.8F, 1.5F);
/*  23 */     this.spawnSound = SoundEvents.spawn_ea.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void spawnAct3(EntityPlayer player) {
/*  28 */     if (!this.worldObj.isRemote) {
/*     */       
/*  30 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  31 */       EntityEchoesAct3 entitypigzombie = new EntityEchoesAct3(this.worldObj);
/*  32 */       entitypigzombie.setLocationAndAngles((getMaster()).posX + 0.1D, (getMaster()).posY, (getMaster()).posZ, (getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  33 */       this.worldObj.spawnEntityInWorld(entitypigzombie);
/*  34 */       entitypigzombie.setMaster(getMaster().getCommandSenderName());
/*  35 */       entitypigzombie.setMastername(getMaster().getDisplayName());
/*  36 */       entitypigzombie.bespawn();
/*  37 */       props.setPlayerStandAct(3);
/*  38 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void spawnAct1(EntityPlayer player) {
/*  44 */     if (!this.worldObj.isRemote) {
/*     */       
/*  46 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  47 */       EntityEchoesAct1 entitypigzombie = new EntityEchoesAct1(this.worldObj);
/*  48 */       entitypigzombie.setLocationAndAngles((getMaster()).posX + 0.1D, (getMaster()).posY, (getMaster()).posZ, (getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  49 */       this.worldObj.spawnEntityInWorld(entitypigzombie);
/*  50 */       entitypigzombie.setMaster(getMaster().getCommandSenderName());
/*  51 */       entitypigzombie.setMastername(getMastername());
/*  52 */       entitypigzombie.bespawn();
/*  53 */       props.setPlayerStandAct(1);
/*  54 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getCanChangeAct() {
/*  60 */     EntityPlayer player = getMaster();
/*  61 */     if (player.onGround)
/*     */     {
/*  63 */       if (player.hurtTime < 5)
/*     */       {
/*  65 */         return true;
/*     */       }
/*     */     }
/*  68 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeAct() {
/*  74 */     EntityPlayer player = getMaster();
/*  75 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  76 */     int exp = props.getPlayerStandExp();
/*  77 */     if (exp > 300) {
/*     */       
/*  79 */       if (!this.worldObj.isRemote)
/*     */       {
/*  81 */         getMaster().addChatMessage(new ChatComponentText("Act.3!"));
/*  82 */         spawnAct3(player);
/*     */       
/*     */       }
/*     */     
/*     */     }
/*  87 */     else if (!this.worldObj.isRemote) {
/*     */       
/*  89 */       getMaster().addChatMessage(new ChatComponentText("Act.1!"));
/*  90 */       spawnAct1(player);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  97 */     super.onUpdate();
/*  98 */     if (getMaster() != null)
/*     */     {
/* 100 */       if (this.standOn) {
/*     */         
/* 102 */         this.posY++;
/* 103 */         fallowmaster();
/*     */         
/* 105 */         if (!this.tailout)
/*     */         {
/* 107 */           if (getMaster().getFoodStats().getFoodLevel() > 4)
/*     */           {
/* 109 */             if (getMaster().isSprinting()) {
/*     */               
/* 111 */               if ((getMaster()).swingProgressInt != 0) {
/*     */                 
/* 113 */                 this.spawnsound++;
/* 114 */                 if (this.spawnsound == 1)
/*     */                 {
/* 116 */                   if (!(getMaster()).capabilities.isCreativeMode)
/*     */                   {
/* 118 */                     getMaster().getFoodStats().addStats(-2, 0.0F);
/*     */                   }
/* 120 */                   this.windat = true;
/* 121 */                   this.tailout = true;
/* 122 */                   EntityEchoes_sound entityarrow = new EntityEchoes_sound(this.worldObj, this, 2.0F);
/* 123 */                   entityarrow.setIsCritical(true);
/* 124 */                   this.worldObj.spawnEntityInWorld(entityarrow);
/*     */                 }
/*     */               
/*     */               } 
/* 128 */             } else if (Math.abs((getMaster()).motionY) >= 0.3D) {
/*     */               
/* 130 */               if ((getMaster()).swingProgressInt != 0) {
/*     */                 
/* 132 */                 this.spawnsound++;
/* 133 */                 if (this.spawnsound == 1)
/*     */                 {
/* 135 */                   if (!(getMaster()).capabilities.isCreativeMode)
/*     */                   {
/* 137 */                     getMaster().getFoodStats().addStats(-4, 0.0F);
/*     */                   }
/* 139 */                   this.exat = true;
/* 140 */                   this.tailout = true;
/* 141 */                   EntityEchoes_sound entityarrow = new EntityEchoes_sound(this.worldObj, this, 2.0F);
/* 142 */                   entityarrow.setIsCritical(true);
/* 143 */                   this.worldObj.spawnEntityInWorld(entityarrow);
/*     */                 }
/*     */               
/*     */               } 
/* 147 */             } else if ((getMaster()).swingProgressInt != 0) {
/*     */               
/* 149 */               this.spawnsound++;
/* 150 */               if (this.spawnsound == 1)
/*     */               {
/* 152 */                 if (!(getMaster()).capabilities.isCreativeMode)
/*     */                 {
/* 154 */                   getMaster().getFoodStats().addStats(-1, 0.0F);
/*     */                 }
/* 156 */                 this.fireat = true;
/* 157 */                 this.tailout = true;
/* 158 */                 EntityEchoes_sound entityarrow = new EntityEchoes_sound(this.worldObj, this, 2.0F);
/* 159 */                 entityarrow.setIsCritical(true);
/* 160 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               }
/*     */             
/*     */             } else {
/*     */               
/* 165 */               this.windat = false;
/* 166 */               this.exat = false;
/* 167 */               this.fireat = false;
/* 168 */               this.spawnsound = 0;
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */         }
/* 174 */         else if (!this.worldObj.isRemote)
/*     */         {
/* 176 */           if (getMaster().isSneaking())
/*     */           {
/* 178 */             this.tailout = false;
/*     */           }
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 185 */         this.spawntick = 0;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityEchoesAct2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */