/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityTNTPrimed;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ public class EntityTheWorld_StopTime
/*     */   extends EntityOneStand
/*     */ {
/*     */   public EntityTheWorld_StopTime(World par1World) {
/*  22 */     super(par1World);
/*  23 */     setSize(0.0F, 0.0F);
/*  24 */     isEntityInvulnerable();
/*  25 */     this.spawnSound = SoundEvents.stoptime.toString();
/*  26 */     setMaster("");
/*  27 */     this.savedInfo[0] = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  33 */     onUpdate2();
/*  34 */     if (!this.worldObj.isRemote) {
/*     */       
/*  36 */       this.fallDistance = 0.0F;
/*  37 */       if (getSpawnedBy() != null) {
/*     */         
/*  39 */         double worldScaleSq = 3.0D * this.worldScale * this.worldScale;
/*  40 */         if (getDistanceSqToEntity(getSpawnedBy()) > worldScaleSq || !getSpawnedBy().getTimeIsStopped() || (getSpawnedBy()).isDead || this.ticksExisted > getStopLength())
/*     */         {
/*  42 */           getSpawnedBy().setTimeContinue(true);
/*  43 */           this.worldObj.playSoundAtEntity(getSpawnedBy().getMaster(), SoundEvents.gotime.toString(), 0.5F, 1.0F);
/*  44 */           goTime();
/*  45 */           setDead();
/*     */         }
/*     */         else
/*     */         {
/*  49 */           stopTime();
/*  50 */           updateEntityList();
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/*  55 */         goTime();
/*  56 */         setDead();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStopLength(int value) {
/*  63 */     this.stopLength = value;
/*     */     
/*  65 */     if (value <= 0)
/*     */     {
/*  67 */       this.stopLength = 200;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   public int getStopLength() { return this.stopLength; }
/*     */ 
/*     */   
/*  77 */   int stopLength = 200;
/*     */ 
/*     */ 
/*     */   
/*  81 */   public void setSpawnedBy(EntityOneStand stand) { this.standSpawnedBy = stand; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public EntityOneStand getSpawnedBy() { return this.standSpawnedBy; }
/*     */ 
/*     */   
/*  90 */   EntityOneStand standSpawnedBy = null;
/*     */ 
/*     */ 
/*     */   
/*  94 */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public List getEntityList() { return this.worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getBoundingBox(this.posX, this.posY, this.posZ, this.posX, this.posY, this.posZ).expand(this.worldScale, this.worldScale, this.worldScale)); }
/*     */ 
/*     */ 
/*     */   
/* 103 */   private double[] motionx = new double[9999];
/* 104 */   private double[] motiony = new double[9999];
/* 105 */   private double[] motionz = new double[9999];
/* 106 */   private double[] positionx = new double[9999];
/* 107 */   private double[] positiony = new double[9999];
/* 108 */   private double[] positionz = new double[9999];
/* 109 */   private int[] fuseint = new int[9999];
/* 110 */   private float[] rty = new float[9999];
/* 111 */   private float[] rtp = new float[9999];
/* 112 */   private List entityList = null;
/* 113 */   private int[] skip = new int[9999];
/* 114 */   private int[] ticksRemove = new int[9999];
/* 115 */   private boolean[] savedInfo = new boolean[9999];
/* 116 */   private int entListPRELength = 0;
/* 117 */   private int entListLength = 0;
/*     */   
/* 119 */   double worldScale = 10.0D;
/*     */ 
/*     */   
/*     */   public void stopTime() {
/* 123 */     EntityTheWorld_StopTime timeEntity = this;
/* 124 */     if (!timeEntity.worldObj.isRemote) {
/*     */       
/* 126 */       if (!this.savedInfo[0])
/*     */       {
/* 128 */         this.entityList = timeEntity.getEntityList();
/*     */       }
/* 130 */       EntityOneStand theStand = timeEntity.getSpawnedBy();
/* 131 */       EntityPlayer player = theStand.getMaster();
/*     */       
/* 133 */       if (this.entityList != null)
/*     */       {
/* 135 */         for (int i = 0; i < this.entityList.size(); i++) {
/*     */           
/* 137 */           this.skip[i] = 0;
/* 138 */           Entity entity = (Entity)this.entityList.get(i);
/* 139 */           if (entity != null) {
/*     */             
/* 141 */             if (entity instanceof EntityPlayer && entity != getSpawnedBy().getMaster())
/*     */             {
/* 143 */               if (getPlayerScale(entity) == -1) {
/*     */                 
/* 145 */                 this.skip[i] = 1;
/*     */               }
/* 147 */               else if (getPlayerScale(entity) != 99) {
/*     */                 
/* 149 */                 this.skip[i] = 2;
/*     */               } 
/*     */             }
/*     */             
/* 153 */             if (entity instanceof EntityStarplatinum || entity instanceof EntityTheWorld)
/*     */             {
/* 155 */               if (entity != theStand) {
/*     */                 
/* 157 */                 EntityOneStand checkStand = (EntityOneStand)entity;
/* 158 */                 EntityPlayer checkPlayer = checkStand.getMaster();
/* 159 */                 if (checkPlayer != null)
/*     */                 {
/* 161 */                   if (getPlayerScale(checkPlayer) == -1) {
/*     */                     
/* 163 */                     this.skip[i] = 1;
/*     */                   }
/* 165 */                   else if (getPlayerScale(checkPlayer) != 99) {
/*     */                     
/* 167 */                     this.skip[i] = 2;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             }
/*     */             
/* 173 */             if (entity instanceof EntityTheWorld_punch) {
/*     */               
/* 175 */               EntityTheWorld_punch punch = (EntityTheWorld_punch)entity;
/* 176 */               if (punch.shootingStand == theStand) {
/*     */                 
/* 178 */                 this.skip[i] = 1;
/*     */               }
/*     */               else {
/*     */                 
/* 182 */                 EntityPlayer checkPlayer = punch.shootingStand.getMaster();
/* 183 */                 if (checkPlayer != null)
/*     */                 {
/* 185 */                   if (getPlayerScale(checkPlayer) == -1) {
/*     */                     
/* 187 */                     this.skip[i] = 1;
/*     */                   }
/* 189 */                   else if (getPlayerScale(checkPlayer) != 99) {
/*     */                     
/* 191 */                     this.skip[i] = 2;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             
/* 197 */             if (entity instanceof EntityStarplatinum_punch) {
/*     */               
/* 199 */               EntityStarplatinum_punch punch = (EntityStarplatinum_punch)entity;
/* 200 */               if (punch.shootingStand == theStand) {
/*     */                 
/* 202 */                 this.skip[i] = 1;
/*     */               }
/*     */               else {
/*     */                 
/* 206 */                 EntityPlayer checkPlayer = punch.shootingStand.getMaster();
/* 207 */                 if (checkPlayer != null)
/*     */                 {
/* 209 */                   if (getPlayerScale(checkPlayer) == -1) {
/*     */                     
/* 211 */                     this.skip[i] = 1;
/*     */                   }
/* 213 */                   else if (getPlayerScale(checkPlayer) != 99) {
/*     */                     
/* 215 */                     this.skip[i] = 2;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             
/* 221 */             if (entity == player || entity == theStand) {
/*     */ 
/*     */               
/* 224 */               this.skip[i] = 1;
/*     */             }
/*     */             else {
/*     */               
/* 228 */               if (!this.savedInfo[i])
/*     */               {
/* 230 */                 saveRotPot(i, entity);
/*     */               }
/*     */ 
/*     */               
/* 234 */               if (timeEntity.ticksExisted < timeEntity.getStopLength()) {
/*     */                 
/* 236 */                 if (this.skip[i] == 0) {
/*     */                   
/* 238 */                   entity.setPositionAndRotation(this.positionx[i], this.positiony[i], this.positionz[i], this.rty[i], this.rtp[i]);
/* 239 */                   entity.moveEntity(0.0D, 0.0D, 0.0D);
/* 240 */                   if (entity instanceof EntityTNTPrimed)
/*     */                   {
/* 242 */                     ((EntityTNTPrimed)entity).fuse = this.fuseint[i];
/*     */                   }
/*     */                 } 
/*     */                 
/* 246 */                 if (entity instanceof EntityLivingBase) {
/*     */                   
/* 248 */                   int scale = 99;
/* 249 */                   if (entity instanceof EntityPlayer)
/*     */                   {
/* 251 */                     scale = getPlayerScale(entity);
/*     */                   }
/* 253 */                   ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.blindness.getId(), 40, scale));
/* 254 */                   ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 40, scale));
/* 255 */                   ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 40, scale));
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveRotPot(int i, Entity entity) {
/* 267 */     this.savedInfo[i] = true;
/* 268 */     if (entity != null) {
/*     */       
/* 270 */       this.motionx[i] = entity.motionX;
/* 271 */       this.motiony[i] = entity.motionY;
/* 272 */       this.motionz[i] = entity.motionZ;
/* 273 */       this.positionx[i] = entity.posX;
/* 274 */       this.positiony[i] = entity.posY;
/* 275 */       this.positionz[i] = entity.posZ;
/* 276 */       this.rtp[i] = entity.rotationPitch;
/* 277 */       this.rty[i] = entity.rotationYaw;
/* 278 */       this.ticksRemove[i] = this.ticksExisted;
/* 279 */       if (entity instanceof EntityTNTPrimed)
/*     */       {
/* 281 */         this.fuseint[i] = ((EntityTNTPrimed)entity).fuse;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void goTime() {
/* 288 */     if (!this.worldObj.isRemote)
/*     */     {
/* 290 */       if (this.entityList != null)
/*     */       {
/* 292 */         for (int i = 0; i < this.entityList.size(); i++) {
/*     */           
/* 294 */           Entity entity = (Entity)this.entityList.get(i);
/* 295 */           if (entity != null)
/*     */           {
/* 297 */             if (this.skip[i] == 0) {
/*     */               
/* 299 */               entity.setPositionAndRotation(this.positionx[i], this.positiony[i], this.positionz[i], this.rty[i], this.rtp[i]);
/* 300 */               entity.addVelocity(this.motionx[i], this.motiony[i], this.motionz[i]);
/* 301 */               entity.ticksExisted -= this.ticksExisted - this.ticksRemove[i];
/* 302 */               if (entity instanceof EntityTNTPrimed)
/*     */               {
/* 304 */                 ((EntityTNTPrimed)entity).fuse = this.fuseint[i];
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPlayerScale(Entity entity) {
/* 315 */     int targetAmp = 99;
/*     */     
/* 317 */     EntityPlayer targetPlayer = (EntityPlayer)entity;
/* 318 */     ExtendedPlayerJojoBAdvProperties targetPlayerProps = ExtendedPlayerJojoBAdvProperties.get(targetPlayer);
/* 319 */     ExtendedPlayerJojoBAdvProperties playerProps = ExtendedPlayerJojoBAdvProperties.get(getSpawnedBy().getMaster());
/* 320 */     if (targetPlayerProps.getPlayerStandID() == 3 || targetPlayerProps.getPlayerStandID() == 4)
/*     */     {
/* 322 */       if (targetPlayerProps.getPlayerStandExp() > playerProps.getPlayerStandExp()) {
/*     */         
/* 324 */         targetAmp = -1;
/*     */       }
/*     */       else {
/*     */         
/* 328 */         int diff = playerProps.getPlayerStandExp() - targetPlayerProps.getPlayerStandExp();
/* 329 */         float powerScale = (diff / playerProps.getPlayerStandExp());
/* 330 */         targetAmp = Math.round(99.0F * powerScale);
/*     */       } 
/*     */     }
/* 333 */     return targetAmp;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateEntityList() {
/* 338 */     List tempList = getEntityList();
/* 339 */     if (tempList != null)
/*     */     {
/* 341 */       if (this.entityList != null) {
/*     */         
/* 343 */         tempList.removeAll(this.entityList);
/* 344 */         this.entListLength = this.entityList.size();
/* 345 */         this.entityList.addAll(this.entListLength, tempList);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityTheWorld_StopTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */