/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityStarplatinum
/*     */   extends EntityOneStand
/*     */ {
/*  20 */   private int oratick = 0;
/*     */   public boolean orarush = false;
/*  22 */   private int oratickr = 0;
/*  23 */   private float range = 3.0F;
/*  24 */   private int jumpTick = 0;
/*  25 */   private int stoptimemp = 0;
/*     */ 
/*     */   
/*     */   public EntityStarplatinum(World par1World) {
/*  29 */     super(par1World);
/*  30 */     setSize(1.2F, 2.7F);
/*  31 */     this.spawnSound = SoundEvents.spawn_sp.toString();
/*  32 */     setCatchPassive();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  37 */   protected boolean canDespawn() { return false; }
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
/*  56 */     if (!this.worldObj.isRemote && getMaster() != null) {
/*     */       
/*  58 */       getMaster().addPotionEffect(new PotionEffect(Potion.resistance.getId(), 40, 2));
/*  59 */       if (this.standOn) {
/*     */         
/*  61 */         fallowmaster();
/*  62 */         setRotationYawHead((getMaster()).rotationYaw);
/*  63 */         setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  64 */         if (getMaster() instanceof EntityPlayer) {
/*     */           
/*  66 */           EntityPlayer player = getMaster();
/*  67 */           ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*     */           
/*  69 */           if (getMaster().isSneaking())
/*     */           {
/*  71 */             if (getMaster().getFoodStats().getFoodLevel() > 4 && props.getPlayerStandExp() > 400) {
/*     */               
/*  73 */               if (Math.abs((getMaster()).motionY) >= 0.3D)
/*     */               {
/*     */                 
/*  76 */                 if (getTimeIsStopped())
/*     */                 {
/*  78 */                   if (this.ticksExisted > this.timeStopped + 20)
/*     */                   {
/*     */                     
/*  81 */                     goTime();
/*  82 */                     this.timeStopped = this.ticksExisted;
/*     */                   
/*     */                   }
/*     */                 
/*     */                 }
/*  87 */                 else if (this.timeStopped + 100 < this.ticksExisted)
/*     */                 {
/*     */                   
/*  90 */                   this.timeStopped = this.ticksExisted;
/*  91 */                   if (!player.capabilities.isCreativeMode)
/*     */                   {
/*  93 */                     getMaster().getFoodStats().addStats(-4, 0.0F);
/*     */                   }
/*  95 */                   stopTime();
/*     */                 
/*     */                 }
/*     */ 
/*     */               
/*     */               }
/*     */             }
/* 102 */             else if (Math.abs((getMaster()).motionY) >= 0.3D) {
/*     */               
/* 104 */               if (props.getPlayerStandExp() <= 400) {
/*     */                 
/* 106 */                 notEnoughExpMessage();
/*     */               }
/*     */               else {
/*     */                 
/* 110 */                 hungerMessage();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 117 */           if (getMaster().isSprinting()) {
/*     */             
/* 119 */             if (attackSwing(getMaster()))
/*     */             {
/* 121 */               if (getMaster().getFoodStats().getFoodLevel() > 6) {
/*     */                 
/* 123 */                 this.oratick++;
/* 124 */                 if (this.oratick == 1)
/*     */                 {
/* 126 */                   this.worldObj.playSoundAtEntity(this, SoundEvents.orarush.toString(), 1.0F, 1.0F);
/* 127 */                   if (!(getMaster()).capabilities.isCreativeMode)
/*     */                   {
/* 129 */                     getMaster().getFoodStats().addStats(-6, 0.0F);
/*     */                   }
/* 131 */                   this.orarush = true;
/*     */                 }
/*     */               
/*     */               } else {
/*     */                 
/* 136 */                 hungerMessage();
/*     */               }
/*     */             
/*     */             }
/*     */           }
/* 141 */           else if (attackSwing(getMaster())) {
/*     */             
/* 143 */             this.oratick++;
/* 144 */             if (this.oratick == 1) {
/*     */               
/* 146 */               this.worldObj.playSoundAtEntity(this, SoundEvents.last_ora.toString(), 1.0F, 0.8F / (this.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/* 147 */               EntityStarplatinum_punch entityarrow = new EntityStarplatinum_punch(this.worldObj, this, 2.0F);
/* 148 */               entityarrow.setIsCritical(true);
/* 149 */               this.worldObj.spawnEntityInWorld(entityarrow);
/*     */             } 
/*     */           } 
/* 152 */           if ((getMaster()).swingProgressInt == 0)
/*     */           {
/* 154 */             this.oratick = 0;
/*     */           }
/*     */           
/* 157 */           if (this.orarush) {
/*     */             
/* 159 */             getMaster().setSprinting(false);
/* 160 */             this.oratickr++;
/* 161 */             if (this.oratickr == 1)
/*     */             {
/* 163 */               getMaster().addChatMessage(new ChatComponentTranslation("msg.jojobadv.starplatinum_orarush.txt", new Object[0]));
/*     */             }
/*     */             
/* 166 */             getMaster().setSprinting(false);
/* 167 */             EntityStarplatinum_punch entityarrow = new EntityStarplatinum_punch(this.worldObj, this, 2.0F);
/* 168 */             entityarrow.setIsCritical(true);
/* 169 */             this.worldObj.spawnEntityInWorld(entityarrow);
/*     */             
/* 171 */             EntityStarplatinum_punch entityarrow2 = new EntityStarplatinum_punch(this.worldObj, this, 2.0F);
/* 172 */             entityarrow2.setIsCritical(true);
/* 173 */             this.worldObj.spawnEntityInWorld(entityarrow2);
/*     */ 
/*     */             
/* 176 */             if (this.oratickr >= 80) {
/*     */               
/* 178 */               this.orarush = false;
/* 179 */               this.oratickr = 0;
/*     */             } 
/*     */           } 
/*     */           
/* 183 */           if (getTimeIsStopped()) {
/*     */             
/* 185 */             if (player.getFoodStats().getFoodLevel() == 0) {
/*     */               
/* 187 */               goTime();
/* 188 */               this.timeStopped = this.ticksExisted;
/*     */             } 
/*     */             
/* 191 */             if (!player.capabilities.isCreativeMode) {
/*     */               
/* 193 */               this.stoptimemp++;
/* 194 */               int exp = props.getPlayerStandExp();
/* 195 */               int expScale = exp % 50;
/* 196 */               if (this.stoptimemp >= 20 + expScale) {
/*     */                 
/* 198 */                 this.stoptimemp = 0;
/*     */ 
/*     */                 
/* 201 */                 player.getFoodStats().addStats(-1, 0.0F);
/*     */               } 
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
/*     */   private void jumpPassive() {
/* 217 */     if ((getMaster()).onGround && getMaster().isSneaking()) {
/*     */       
/* 219 */       if (this.jumpTick < 30)
/*     */       {
/* 221 */         this.jumpTick++;
/* 222 */         double pp = 0.8D;
/* 223 */         this.worldObj.spawnParticle("explode", (getMaster()).posX, (getMaster()).posY - 0.20000000298023224D, (getMaster()).posZ, 0.0D, -pp, 0.0D);
/*     */       }
/*     */     
/* 226 */     } else if (!getMaster().isSneaking()) {
/*     */       
/* 228 */       this.jumpTick = 0;
/*     */     } 
/* 230 */     if (!(getMaster()).onGround && this.jumpTick != 0) {
/*     */       
/* 232 */       if (!this.worldObj.isRemote)
/*     */       {
/* 234 */         this.worldObj.playSoundAtEntity(this, SoundEvents.last_ora.toString(), 3.0F, 1.0F);
/*     */       }
/* 236 */       Vec3 vLook = getMaster().getLook(1.0F);
/* 237 */       (getMaster()).motionY += 0.30000001192092896D;
/* 238 */       (getMaster()).motionX += vLook.xCoord * this.jumpTick / 35.0D;
/* 239 */       (getMaster()).motionY += vLook.yCoord * this.jumpTick / 35.0D;
/* 240 */       (getMaster()).motionZ += vLook.zCoord * this.jumpTick / 35.0D;
/* 241 */       this.jumpTick = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void catchpassive() {
/* 247 */     Entity entity = null;
/* 248 */     for (int i1 = 0; i1 < this.worldObj.loadedEntityList.size(); i1++) {
/*     */       
/* 250 */       Entity entityplayer1 = (Entity)this.worldObj.loadedEntityList.get(i1);
/* 251 */       double dst = entityplayer1.getDistanceSq((getMaster()).posX, (getMaster()).posY, (getMaster()).posZ);
/* 252 */       int r = 2;
/* 253 */       double d2 = Math.PI * r * r * r;
/* 254 */       entity = entityplayer1;
/* 255 */       if (!this.worldObj.isRemote && entity instanceof net.minecraft.entity.item.EntityTNTPrimed ^ entity instanceof net.minecraft.entity.projectile.EntityArrow ^ entity instanceof EntityEmperor_bullet ^ entity instanceof net.minecraft.entity.item.EntityFallingBlock && dst <= d2) {
/*     */         
/* 257 */         entity = entityplayer1;
/* 258 */         double dx = this.posX - entity.posX;
/* 259 */         double dy = this.posY - entity.posY;
/* 260 */         double dz = this.posZ - entity.posZ;
/* 261 */         float impower = 0.3F;
/* 262 */         if (dx > 0.0D)
/*     */         {
/* 264 */           entity.motionX = -impower;
/*     */         }
/* 266 */         if (dx < 0.0D)
/*     */         {
/* 268 */           entity.motionX = impower;
/*     */         }
/*     */         
/* 271 */         if (dy > 0.0D)
/*     */         {
/* 273 */           entity.motionY = -impower;
/*     */         }
/* 275 */         if (dy < 1.0D)
/*     */         {
/* 277 */           entity.motionY = impower;
/*     */         }
/*     */         
/* 280 */         if (dz > 0.0D)
/*     */         {
/* 282 */           entity.motionZ = -impower;
/*     */         }
/* 284 */         if (dz < 0.0D)
/*     */         {
/* 286 */           entity.motionZ = impower;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnTimeStopEntity(EntityOneStand stand, World world, int stopLength) {
/* 294 */     EntityTheWorld_StopTime stopTimeEnt = new EntityTheWorld_StopTime(world);
/* 295 */     stopTimeEnt.setLocationAndAngles(stand.posX, stand.posY, stand.posZ, stand.rotationYaw, stand.rotationPitch);
/* 296 */     stopTimeEnt.setStopLength(stopLength);
/* 297 */     stopTimeEnt.setSpawnedBy(stand);
/* 298 */     world.spawnEntityInWorld(stopTimeEnt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void goTime() {
/* 304 */     this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.gotime.toString(), 0.5F, 1.0F);
/* 305 */     setTimeContinue(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopTime() {
/* 310 */     this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.stoptime.toString(), 5.0F, 1.0F);
/* 311 */     spawnTimeStopEntity(this, this.worldObj, getStopLength());
/* 312 */     getMaster().addChatComponentMessage(new ChatComponentTranslation("msg.jojobadv.theworld_stoptime.txt", new Object[0]));
/* 313 */     setTimeIsStopped(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStopLength() {
/* 318 */     EntityPlayer player = getMaster();
/* 319 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 320 */     int exp = props.getPlayerStandExp();
/*     */     
/* 322 */     int tickScale = 20;
/* 323 */     int baseTime = 10;
/* 324 */     int expBonus = Math.round((exp / 10));
/* 325 */     return baseTime * tickScale + expBonus;
/*     */   }
/*     */   
/* 328 */   public int timeStopped = 0;
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityStarplatinum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */