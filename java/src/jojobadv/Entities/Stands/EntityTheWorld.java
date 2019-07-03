/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdvConfig;
/*     */ import src.jojobadv.ModBase.JojoBAdvLib;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ public class EntityTheWorld
/*     */   extends EntityOneStand {
/*  18 */   private int oratick = 0;
/*     */   public boolean special = false;
/*  20 */   private int oratickr = 0;
/*     */   public int theworldtick;
/*  22 */   private int stoptimemp = 0;
/*     */   private int jumpTick;
/*  24 */   public int timeStopped = 0;
/*     */   
/*     */   private boolean timeStop = false;
/*     */   
/*     */   public EntityTheWorld(World par1World) {
/*  29 */     super(par1World);
/*  30 */     setSize(1.2F, 2.7F);
/*  31 */     this.spawnSound = SoundEvents.spawn_tw.toString();
/*  32 */     setCatchPassive();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   protected void applyEntityAttributes() { super.applyEntityAttributes(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   protected boolean canDespawn() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   protected boolean isAIEnabled() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   public void readEntityFromNBT(NBTTagCompound nbttagcompound) { super.readEntityFromNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   public void writeEntityToNBT(NBTTagCompound nbttagcompound) { super.writeEntityToNBT(nbttagcompound); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void spawnTimeStopEntity(EntityOneStand stand, World world, int stopLength) {
/*  70 */     EntityTheWorld_StopTime stopTimeEnt = new EntityTheWorld_StopTime(world);
/*  71 */     stopTimeEnt.setLocationAndAngles(stand.posX, stand.posY, stand.posZ, stand.rotationYaw, stand.rotationPitch);
/*  72 */     stopTimeEnt.setStopLength(stopLength);
/*  73 */     stopTimeEnt.setSpawnedBy(stand);
/*  74 */     world.spawnEntityInWorld(stopTimeEnt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void goTime() {
/*  80 */     this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.gotime.toString(), 0.5F, 1.0F);
/*  81 */     setTimeContinue(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopTime() {
/*  86 */     this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.stoptime.toString(), 5.0F, 1.0F);
/*  87 */     spawnTimeStopEntity(this, this.worldObj, getStopLength());
/*  88 */     getMaster().addChatComponentMessage(new ChatComponentTranslation("msg.jojobadv.theworld_stoptime.txt", new Object[0]));
/*  89 */     setTimeIsStopped(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  94 */     super.onUpdate();
/*  95 */     this.fallDistance = 0.0F;
/*  96 */     if (getMaster() != null) {
/*     */       
/*  98 */       getMaster().addPotionEffect(new PotionEffect(Potion.resistance.getId(), 40, 2));
/*  99 */       if (this.standOn) {
/*     */ 
/*     */         
/*     */         try {
/* 103 */           setHealth(1000.0F);
/*     */         }
/* 105 */         catch (ClassCastException classCastException) {}
/*     */ 
/*     */         
/* 108 */         fallowmaster();
/* 109 */         setRotationYawHead((getMaster()).rotationYaw);
/* 110 */         setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/* 111 */         if ((getMaster()).isDead)
/*     */         {
/* 113 */           setDead();
/*     */         }
/*     */         
/* 116 */         if (getMaster() instanceof EntityPlayer) {
/*     */           
/* 118 */           EntityPlayer player = getMaster();
/* 119 */           ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*     */           
/* 121 */           if (getMaster().isSneaking())
/*     */           {
/* 123 */             if (getMaster().getFoodStats().getFoodLevel() > 6 && props.getPlayerStandExp() > 200) {
/*     */               
/* 125 */               if (Math.abs((getMaster()).motionY) >= 0.3D)
/*     */               {
/*     */                 
/* 128 */                 if (getTimeIsStopped())
/*     */                 {
/* 130 */                   if (this.ticksExisted > this.timeStopped + 20)
/*     */                   {
/*     */                     
/* 133 */                     goTime();
/* 134 */                     this.timeStopped = this.ticksExisted;
/*     */                   
/*     */                   }
/*     */                 
/*     */                 }
/* 139 */                 else if (this.timeStopped + 100 < this.ticksExisted)
/*     */                 {
/*     */                   
/* 142 */                   this.timeStopped = this.ticksExisted;
/* 143 */                   int hungerCost = 3;
/* 144 */                   if (JojoBAdvConfig.timeVampireReduce)
/*     */                   {
/* 146 */                     if (props.getJojoPower() == JojoBAdvLib.JojoPowers.Vampire)
/*     */                     {
/* 148 */                       hungerCost = 2;
/*     */                     }
/*     */                   }
/* 151 */                   if (!player.capabilities.isCreativeMode)
/*     */                   {
/* 153 */                     getMaster().getFoodStats().addStats(-hungerCost * 2, 0.0F);
/*     */                   }
/* 155 */                   stopTime();
/*     */                 
/*     */                 }
/*     */ 
/*     */               
/*     */               }
/*     */             }
/* 162 */             else if (Math.abs((getMaster()).motionY) >= 0.3D) {
/*     */               
/* 164 */               if (props.getPlayerStandExp() <= 200) {
/*     */                 
/* 166 */                 notEnoughExpMessage();
/*     */               }
/*     */               else {
/*     */                 
/* 170 */                 hungerMessage();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 178 */           if (getMaster().isSprinting()) {
/*     */             
/* 180 */             if (attackSwing(getMaster()))
/*     */             {
/* 182 */               if (getMaster().getFoodStats().getFoodLevel() > 6) {
/*     */                 
/* 184 */                 this.oratick++;
/* 185 */                 if (this.oratick == 1)
/*     */                 {
/* 187 */                   this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.mudarush.toString(), 4.0F, 1.0F);
/* 188 */                   if (!(getMaster()).capabilities.isCreativeMode)
/*     */                   {
/* 190 */                     getMaster().getFoodStats().addStats(-2, 0.0F);
/*     */                   }
/* 192 */                   if (!this.worldObj.isRemote)
/*     */                   {
/* 194 */                     this.special = true;
/*     */                   }
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 200 */                 hungerMessage();
/*     */               }
/*     */             
/*     */             }
/* 204 */           } else if (attackSwing(getMaster())) {
/*     */             
/* 206 */             if (!this.worldObj.isRemote) {
/*     */ 
/*     */               
/* 209 */               this.oratick++;
/* 210 */               if (this.oratick == 1) {
/*     */                 
/* 212 */                 EntityTheWorld_punch entityarrow = new EntityTheWorld_punch(this.worldObj, this, 2.0F);
/* 213 */                 this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.knife_swing_miss2.toString(), 0.3F, 4.0F);
/* 214 */                 entityarrow.setIsCritical(true);
/* 215 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               } 
/*     */             } 
/*     */           } 
/* 219 */           if ((getMaster()).swingProgressInt == 0)
/*     */           {
/* 221 */             this.oratick = 0;
/*     */           }
/*     */           
/* 224 */           if (getTimeIsStopped()) {
/*     */             
/* 226 */             if (player.getFoodStats().getFoodLevel() == 0) {
/*     */               
/* 228 */               goTime();
/* 229 */               this.timeStopped = this.ticksExisted;
/*     */             } 
/*     */             
/* 232 */             if (!player.capabilities.isCreativeMode) {
/*     */               
/* 234 */               this.stoptimemp++;
/* 235 */               int exp = props.getPlayerStandExp();
/* 236 */               int expScale = exp % 50;
/* 237 */               if (this.stoptimemp >= 20 + expScale) {
/*     */                 
/* 239 */                 this.stoptimemp = 0;
/*     */ 
/*     */                 
/* 242 */                 player.getFoodStats().addStats(-1, 0.0F);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 248 */           if (this.special) {
/*     */             
/* 250 */             getMaster().setSprinting(false);
/* 251 */             this.oratickr++;
/* 252 */             if (!this.worldObj.isRemote) {
/*     */               
/* 254 */               getMaster().setSprinting(false);
/* 255 */               EntityTheWorld_punch entityarrow = new EntityTheWorld_punch(this.worldObj, this, 2.0F);
/* 256 */               entityarrow.setIsCritical(true);
/* 257 */               this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               
/* 259 */               EntityTheWorld_punch entityarrow2 = new EntityTheWorld_punch(this.worldObj, this, 2.0F);
/* 260 */               entityarrow2.setIsCritical(true);
/* 261 */               this.worldObj.spawnEntityInWorld(entityarrow2);
/*     */             } 
/* 263 */             if (this.oratickr >= 20) {
/*     */               
/* 265 */               if (!this.worldObj.isRemote)
/*     */               {
/* 267 */                 this.special = false;
/*     */               }
/* 269 */               this.oratickr = 0;
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
/*     */   public int getStopLength() {
/* 283 */     EntityPlayer player = getMaster();
/* 284 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 285 */     int exp = props.getPlayerStandExp();
/*     */     
/* 287 */     int tickScale = 20;
/* 288 */     int baseTime = 10;
/* 289 */     int expBonus = Math.round((exp / 10));
/* 290 */     return baseTime * tickScale + expBonus;
/*     */   }
/*     */ 
/*     */   
/*     */   private void jumpPassive() {
/* 295 */     if ((getMaster()).onGround && getMaster().isSneaking()) {
/*     */       
/* 297 */       if (this.jumpTick < 30)
/*     */       {
/* 299 */         this.jumpTick++;
/* 300 */         double pp = 0.8D;
/* 301 */         this.worldObj.spawnParticle("explode", (getMaster()).posX - 5.0D, (getMaster()).posY + 0.10000000149011612D, (getMaster()).posZ, pp, -pp, 0.0D);
/* 302 */         this.worldObj.spawnParticle("explode", (getMaster()).posX + 5.0D, (getMaster()).posY + 0.10000000149011612D, (getMaster()).posZ, -pp, -pp, 0.0D);
/* 303 */         this.worldObj.spawnParticle("explode", (getMaster()).posX, (getMaster()).posY + 0.10000000149011612D, (getMaster()).posZ - 5.0D, 0.0D, -pp, pp);
/* 304 */         this.worldObj.spawnParticle("explode", (getMaster()).posX, (getMaster()).posY + 0.10000000149011612D, (getMaster()).posZ + 5.0D, 0.0D, -pp, -pp);
/*     */       }
/*     */     
/* 307 */     } else if (!getMaster().isSneaking()) {
/*     */       
/* 309 */       this.jumpTick = 0;
/*     */     } 
/* 311 */     if (!(getMaster()).onGround && this.jumpTick != 0) {
/*     */       
/* 313 */       if (!this.worldObj.isRemote)
/*     */       {
/* 315 */         this.worldObj.playSoundAtEntity(this, SoundEvents.wry.toString(), 3.0F, 1.0F);
/*     */       }
/* 317 */       Vec3 vLook = getMaster().getLook(1.0F);
/* 318 */       (getMaster()).motionY += 0.30000001192092896D;
/* 319 */       (getMaster()).motionX += vLook.xCoord * this.jumpTick / 30.0D;
/* 320 */       (getMaster()).motionY += vLook.yCoord * this.jumpTick / 30.0D;
/* 321 */       (getMaster()).motionZ += vLook.zCoord * this.jumpTick / 30.0D;
/* 322 */       this.jumpTick = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 328 */   public boolean isEntityInsideOpaqueBlock() { return false; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityTheWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */