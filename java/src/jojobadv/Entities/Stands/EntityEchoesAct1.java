/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ public class EntityEchoesAct1
/*     */   extends EntityOneStand {
/*  13 */   private int sonar = 0;
/*  14 */   private int baseatt = 0;
/*     */   private boolean canchange = false;
/*  16 */   private int spawntick = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityEchoesAct1(World par1World) {
/*  21 */     super(par1World);
/*  22 */     setSize(1.8F, 1.5F);
/*  23 */     this.spawnSound = SoundEvents.spawn_ea.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void spawnAct2(EntityPlayer player) {
/*  28 */     if (!this.worldObj.isRemote) {
/*     */       
/*  30 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  31 */       EntityEchoesAct2 entitypigzombie = new EntityEchoesAct2(this.worldObj);
/*  32 */       entitypigzombie.setLocationAndAngles((getMaster()).posX + 0.1D, (getMaster()).posY, (getMaster()).posZ, (getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  33 */       this.worldObj.spawnEntityInWorld(entitypigzombie);
/*  34 */       entitypigzombie.setMaster(getMaster().getCommandSenderName());
/*  35 */       entitypigzombie.setMastername(getMastername());
/*  36 */       entitypigzombie.bespawn();
/*  37 */       props.setPlayerStandAct(2);
/*  38 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanChangeAct() {
/*  45 */     EntityPlayer player = getMaster();
/*  46 */     if (player.onGround)
/*     */     {
/*  48 */       if (player.hurtTime < 5)
/*     */       {
/*  50 */         return true;
/*     */       }
/*     */     }
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeAct() {
/*  59 */     EntityPlayer player = getMaster();
/*  60 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  61 */     int exp = props.getPlayerStandExp();
/*  62 */     if (exp > 200) {
/*     */       
/*  64 */       if (!this.worldObj.isRemote) {
/*     */         
/*  66 */         player.addChatMessage(new ChatComponentText("Act.2!"));
/*  67 */         spawnAct2(player);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } else {
/*  73 */       player.addChatMessage(new ChatComponentText("Cannot activate the next Act!"));
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  80 */     super.onUpdate();
/*  81 */     if (getMaster() != null) {
/*     */       
/*  83 */       this.posY++;
/*  84 */       fallowmaster();
/*     */ 
/*     */       
/*  87 */       if (getMaster().isSprinting()) {
/*     */         
/*  89 */         if ((getMaster()).swingProgressInt != 0)
/*     */         {
/*  91 */           this.sonar++;
/*  92 */           if (this.sonar == 1)
/*     */           {
/*  94 */             sonar();
/*     */           }
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 100 */         this.sonar = 0;
/*     */         
/* 102 */         if ((getMaster()).swingProgressInt != 0) {
/*     */           
/* 104 */           if (!this.worldObj.isRemote) {
/*     */             
/* 106 */             this.baseatt++;
/* 107 */             if (this.baseatt == 1)
/*     */             {
/* 109 */               EntityEchoes_sound entityarrow = new EntityEchoes_sound(this.worldObj, this, 2.0F);
/* 110 */               entityarrow.setIsCritical(true);
/* 111 */               this.worldObj.spawnEntityInWorld(entityarrow);
/*     */             }
/*     */           
/*     */           } 
/*     */         } else {
/*     */           
/* 117 */           this.baseatt = 0;
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 123 */       this.spawntick = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void sonar() {
/* 129 */     this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.sonar.toString(), 5.0F, 1.0F);
/* 130 */     Entity entity = null;
/* 131 */     for (int i1 = 0; i1 < this.worldObj.loadedEntityList.size(); i1++) {
/*     */       
/* 133 */       Entity entityplayer1 = (Entity)this.worldObj.loadedEntityList.get(i1);
/* 134 */       double dst = entityplayer1.getDistanceSq((getMaster()).posX, (getMaster()).posY, (getMaster()).posZ);
/* 135 */       double max = 3141.5926535897934D;
/* 136 */       double d4 = 1608.495438637974D;
/* 137 */       double d3 = 392.69908169872417D;
/* 138 */       double d2 = 25.132741228718345D;
/* 139 */       entity = entityplayer1;
/* 140 */       if (entity instanceof EntityPlayer) {
/*     */         
/* 142 */         double xp = -((getMaster()).posX - entity.posX) / 5.0D;
/* 143 */         double yp = -((getMaster()).posY - entity.posY) / 5.0D;
/* 144 */         double zp = -((getMaster()).posZ - entity.posZ) / 5.0D;
/* 145 */         if (d2 < dst)
/*     */         {
/*     */ 
/*     */           
/* 149 */           if (d3 >= dst) {
/*     */             
/* 151 */             getMaster().addChatMessage(new ChatComponentText("ï¿½ï¿½ï¿½ï¿½ï¿½Ì¿ï¿½ ï¿½Ö´ï¿½!!"));
/* 152 */             this.worldObj.spawnParticle("explode", (getMaster()).posX, (getMaster()).posY, (getMaster()).posZ, xp, yp, zp);
/*     */           }
/* 154 */           else if (d4 >= dst) {
/*     */             
/* 156 */             getMaster().addChatMessage(new ChatComponentText("ï¿½ï¿½Ã³ï¿½ï¿½ ï¿½Ö´ï¿½!"));
/* 157 */             this.worldObj.spawnParticle("explode", (getMaster()).posX, (getMaster()).posY, (getMaster()).posZ, xp, yp, zp);
/*     */           }
/* 159 */           else if (max >= dst) {
/*     */             
/* 161 */             getMaster().addChatMessage(new ChatComponentText("ï¿½Õ°ï¿½ï¿½ï¿½ ï¿½Ö´ï¿½"));
/* 162 */             this.worldObj.spawnParticle("explode", (getMaster()).posX, (getMaster()).posY, (getMaster()).posZ, xp, yp, zp);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityEchoesAct1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */