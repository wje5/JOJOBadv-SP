/*     */ package src.jojobadv.Entities;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdvConfig;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ public class EntityVampirepower
/*     */   extends EntityCreature
/*     */ {
/*  23 */   protected EntityPlayer master = null;
/*     */   String mastername;
/*  25 */   protected int tick = 0;
/*  26 */   int standontick = 0;
/*  27 */   int icepunchint = 0;
/*  28 */   private int oratick = 0;
/*     */   private boolean bloodsucking = false;
/*  30 */   private int oratickr = 0;
/*  31 */   private int vintickr = 0;
/*     */   
/*     */   private boolean icepunch = false;
/*  34 */   private int havestandint = 0;
/*     */   
/*  36 */   int lasercooltimeanswer = 0;
/*  37 */   int lasercooltime = 1;
/*  38 */   int lasercooltimetimer = 0;
/*  39 */   private EntityLivingBase forskillentity = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean havestand = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityVampirepower(World par1World) {
/*  51 */     super(par1World);
/*  52 */     setSize(0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void playStepSound(int par1, int par2, int par3, int par4) {}
/*     */ 
/*     */ 
/*     */   
/*  62 */   protected void entityInit() { super.entityInit(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   public void setMaster(EntityPlayer par1) { this.master = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   public EntityPlayer getMaster() { return this.master; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public void setMasterName(String par1) { this.mastername = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public String getMasterName() { return this.mastername; }
/*     */ 
/*     */ 
/*     */   
/*     */   private void vampirePower() {
/*  89 */     if (!this.worldObj.isRemote) {
/*     */       
/*  91 */       if (!this.havestand) {
/*     */         
/*  93 */         Entity entity = null;
/*  94 */         for (int i1 = 0; i1 < this.master.worldObj.loadedEntityList.size(); i1++) {
/*     */           
/*  96 */           Entity entityplayer1 = (Entity)this.master.worldObj.loadedEntityList.get(i1);
/*  97 */           double dst = entityplayer1.getDistanceSq(this.master.posX, this.master.posY, this.master.posZ);
/*  98 */           double offdst = entityplayer1.getDistanceSq(this.master.posX, -5.0D, this.master.posZ);
/*  99 */           double d2 = 25.132741228718345D;
/* 100 */           entity = entityplayer1;
/* 101 */           if (entity instanceof EntityOneStand) if (((dst <= 3.0D) ? true : false) ^ ((offdst <= 3.0D) ? true : false))
/*     */             {
/* 103 */               if (!this.master.worldObj.isRemote)
/*     */               {
/* 105 */                 if (((EntityOneStand)entity).getMaster() == this.master) {
/*     */                   
/* 107 */                   this.master.addChatMessage(new ChatComponentText("ï¿½ï¿½ï¿½ï¿½ï¿½Õ´Ï´ï¿½!"));
/* 108 */                   this.master.addChatMessage(new ChatComponentText("ï¿½ï¿½ï¿½Äµï¿½ ï¿½É·ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ß½ï¿½ï¿½Ï´ï¿½"));
/* 109 */                   this.havestand = true;
/*     */                 } 
/*     */               }
/*     */             } 
/*     */         } 
/* 114 */         if (this.master.isSneaking()) {
/*     */           
/* 116 */           if (this.master.getFoodStats().getFoodLevel() > 6) {
/*     */             
/* 118 */             this.standontick++;
/* 119 */             if (this.standontick <= 20) {
/*     */               
/* 121 */               if (this.master.swingProgressInt != 0 && !this.icepunch && this.lasercooltime == 1) {
/*     */                 
/* 123 */                 this.tick++;
/* 124 */                 if (this.tick == 1) {
/*     */                   
/* 126 */                   this.lasercooltimeanswer = 0;
/* 127 */                   this.worldObj.playSoundAtEntity(this.master, SoundEvents.eyeslaser.toString(), 1.0F, 1.0F);
/* 128 */                   this.lasercooltime = 1800;
/* 129 */                   if (!this.master.capabilities.isCreativeMode)
/*     */                   {
/* 131 */                     this.master.getFoodStats().addStats(-6, 0.0F);
/*     */                   }
/*     */                   
/* 134 */                   EntityVampire_bim entityarrow = new EntityVampire_bim(this.worldObj, this, 2.0F);
/* 135 */                   entityarrow.setIsCritical(true);
/* 136 */                   this.worldObj.spawnEntityInWorld(entityarrow);
/*     */                 } 
/*     */               } 
/* 139 */               if (this.master.swingProgressInt != 0 && this.icepunch)
/*     */               {
/* 141 */                 this.master.addChatMessage(new ChatComponentText("ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ú±ï¿½ï¿½ï¿½ ï¿½Ãµï¿½ï¿½ï¿½Ä¡ï¿½ï¿½ï¿½ï¿½ï¿½ß¿ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Ï½Ç¼ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½"));
/*     */               }
/* 143 */               if (this.master.swingProgressInt != 0 && this.lasercooltime != 0) {
/*     */                 
/* 145 */                 this.master.addChatMessage(new ChatComponentText("ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ú±ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Øºï¿½ï¿½ï¿½ï¿½ ï¿½È¾Ò½ï¿½ï¿½Ï´ï¿½"));
/* 146 */                 this.master.addChatMessage(new ChatComponentText("ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Å¸ï¿½ï¿½ : " + (this.lasercooltime / 20)));
/*     */               } 
/* 148 */               if (Math.abs(this.master.motionY) >= 0.3D) {
/*     */ 
/*     */                 
/* 151 */                 this.tick++;
/* 152 */                 if (this.tick == 1)
/*     */                 {
/* 154 */                   this.worldObj.playSoundAtEntity(this, SoundEvents.wry.toString(), 3.0F, 1.0F);
/* 155 */                   if (!this.master.capabilities.isCreativeMode)
/*     */                   {
/* 157 */                     this.master.getFoodStats().addStats(-2, 0.0F);
/*     */                   }
/* 159 */                   this.icepunch = true;
/*     */                 }
/*     */               
/*     */               } 
/*     */             } 
/*     */           } else {
/*     */             
/* 166 */             this.master.addChatMessage(new ChatComponentText("ï¿½è°¡ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Å³ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Ï½Ç¼ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½"));
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 171 */           this.standontick = 0;
/* 172 */           this.tick = 0;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 177 */       if (this.icepunch) {
/*     */         
/* 179 */         if (this.master.swingProgressInt != 0) {
/*     */           
/* 181 */           this.oratickr++;
/* 182 */           if (this.forskillentity != null && (this.master.getLastAttacker()).hurtResistantTime != 0) {
/*     */             
/* 184 */             this.worldObj.playSoundAtEntity(this.master.getLastAttacker(), SoundEvents.ice_crack.toString(), 1.0F, 1.0F);
/* 185 */             if (!this.worldObj.isRemote)
/*     */             {
/* 187 */               this.forskillentity.attackEntityFrom(DamageSource.causeMobDamage(this.master), 1.0F);
/* 188 */               this.forskillentity.motionX = 0.0D;
/* 189 */               this.forskillentity.motionY = 0.0D;
/* 190 */               this.forskillentity.motionZ = 0.0D;
/* 191 */               onImpact((int)this.forskillentity.posX, (int)this.forskillentity.posY, (int)this.forskillentity.posZ);
/* 192 */               this.icepunch = false;
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 197 */             this.icepunch = false;
/*     */           } 
/*     */         } 
/*     */         
/* 201 */         if (this.forskillentity != null && (this.master.getLastAttacker()).hurtResistantTime != 0) {
/*     */           
/* 203 */           this.worldObj.playSoundAtEntity(this.master.getLastAttacker(), SoundEvents.ice_crack.toString(), 1.0F, 1.0F);
/* 204 */           if (!this.worldObj.isRemote) {
/*     */             
/* 206 */             this.forskillentity.attackEntityFrom(DamageSource.causeMobDamage(this.master), 1.0F);
/* 207 */             this.forskillentity.motionX = 0.0D;
/* 208 */             this.forskillentity.motionY = 0.0D;
/* 209 */             this.forskillentity.motionZ = 0.0D;
/* 210 */             onImpact((int)this.forskillentity.posX, (int)this.forskillentity.posY, (int)this.forskillentity.posZ);
/* 211 */             this.icepunch = false;
/*     */           } 
/*     */         } 
/* 214 */         if (this.oratickr >= 200) {
/*     */           
/* 216 */           if (!this.worldObj.isRemote)
/*     */           {
/* 218 */             this.icepunch = false;
/*     */           }
/* 220 */           this.oratickr = 0;
/* 221 */           this.icepunchint = 0;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 226 */       if (this.master.isSprinting())
/*     */       {
/* 228 */         if (this.forskillentity != null && !(this.master.getLastAttacker() instanceof net.minecraft.entity.monster.EntityMob) && (this.master.getLastAttacker()).hurtResistantTime != 0) {
/*     */           
/* 230 */           double d5 = this.forskillentity.getDistanceSq(this.posX, this.posY, this.posZ);
/* 231 */           double r = 1.5D;
/* 232 */           double closet = Math.PI * r * r * r;
/* 233 */           if (d5 < closet) {
/*     */             
/* 235 */             this.oratick++;
/* 236 */             if (this.oratick == 1) {
/*     */               
/* 238 */               this.worldObj.playSoundAtEntity(this, SoundEvents.vinjak.toString(), 1.0F, 1.0F);
/*     */               
/* 240 */               this.bloodsucking = true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 246 */       if (this.bloodsucking) {
/*     */         
/* 248 */         this.master.setSprinting(false);
/* 249 */         if (this.forskillentity != null)
/*     */         {
/* 251 */           hold_entity(this.forskillentity);
/* 252 */           this.forskillentity.posY++;
/* 253 */           this.oratickr++;
/* 254 */           if (!this.worldObj.isRemote)
/*     */           {
/* 256 */             if (this.oratickr < 42) {
/*     */               
/* 258 */               this.vintickr++;
/* 259 */               if (this.vintickr == 10) {
/*     */                 
/* 261 */                 this.worldObj.playSoundAtEntity(this, SoundEvents.claw_hit_flesh_1.toString(), 1.0F, 1.0F);
/* 262 */                 this.forskillentity.attackEntityFrom(DamageSource.causeMobDamage(this.master), 2.0F);
/* 263 */                 this.master.getFoodStats().addStats(2, 2.0F);
/* 264 */                 this.vintickr = 0;
/*     */                 
/* 266 */                 if (this.forskillentity.getHealth() <= 0.0F) {
/*     */                   
/* 268 */                   this.oratickr = 0;
/* 269 */                   this.vintickr = 0;
/* 270 */                   if (this.forskillentity instanceof net.minecraft.entity.passive.EntityVillager)
/*     */                   {
/* 272 */                     if (!this.worldObj.isRemote) {
/*     */                       
/* 274 */                       EntityVampire entityzombie = new EntityVampire(this.worldObj);
/* 275 */                       entityzombie.copyLocationAndAnglesFrom(this.forskillentity);
/* 276 */                       this.worldObj.removeEntity(this.forskillentity);
/*     */                       
/* 278 */                       this.worldObj.spawnEntityInWorld(entityzombie);
/* 279 */                       this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
/* 280 */                       this.bloodsucking = false;
/* 281 */                       this.forskillentity = null;
/*     */                     } 
/*     */                   }
/* 284 */                   if (this.forskillentity instanceof EntityPlayer)
/*     */                   {
/* 286 */                     if (!this.worldObj.isRemote) {
/*     */                       
/* 288 */                       EntityVampire entityzombie = new EntityVampire(this.worldObj);
/* 289 */                       entityzombie.copyLocationAndAnglesFrom(this.forskillentity);
/* 290 */                       this.worldObj.removeEntity(this.forskillentity);
/*     */                       
/* 292 */                       this.worldObj.spawnEntityInWorld(entityzombie);
/* 293 */                       this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
/* 294 */                       this.bloodsucking = false;
/* 295 */                       this.forskillentity = null;
/*     */                     } 
/*     */                   }
/* 298 */                   if (this.forskillentity instanceof Entityhamonuser) {
/*     */                     
/* 300 */                     if (!this.worldObj.isRemote)
/*     */                     {
/* 302 */                       EntityVampire entityzombie = new EntityVampire(this.worldObj);
/* 303 */                       entityzombie.copyLocationAndAnglesFrom(this.forskillentity);
/* 304 */                       this.worldObj.removeEntity(this.forskillentity);
/*     */                       
/* 306 */                       this.worldObj.spawnEntityInWorld(entityzombie);
/* 307 */                       this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
/* 308 */                       this.bloodsucking = false;
/* 309 */                       this.forskillentity = null;
/*     */                     }
/*     */                   
/*     */                   } else {
/*     */                     
/* 314 */                     this.worldObj.playSoundAtEntity(this, SoundEvents.noroee.toString(), 2.0F, 1.0F);
/* 315 */                     this.bloodsucking = false;
/* 316 */                     this.forskillentity = null;
/*     */                   }
/*     */                 
/*     */                 } 
/*     */               } 
/* 321 */             } else if (this.oratickr >= 42) {
/*     */               
/* 323 */               this.bloodsucking = false;
/* 324 */               this.oratickr = 0;
/* 325 */               this.vintickr = 0;
/*     */             }
/*     */           
/*     */           }
/*     */         }
/*     */       
/*     */       }
/* 332 */       else if (!this.worldObj.isRemote) {
/*     */         
/* 334 */         this.oratick = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void vampirePower2() {
/* 342 */     if (!this.worldObj.isRemote) {
/*     */       
/* 344 */       if (!this.havestand) {
/*     */         
/* 346 */         Entity entity = null;
/* 347 */         for (int i1 = 0; i1 < this.master.worldObj.loadedEntityList.size(); i1++) {
/*     */           
/* 349 */           Entity entityplayer1 = (Entity)this.master.worldObj.loadedEntityList.get(i1);
/* 350 */           double dst = entityplayer1.getDistanceSq(this.master.posX, this.master.posY, this.master.posZ);
/* 351 */           double offdst = entityplayer1.getDistanceSq(this.master.posX, -5.0D, this.master.posZ);
/* 352 */           double d2 = 25.132741228718345D;
/* 353 */           entity = entityplayer1;
/* 354 */           if (entity instanceof EntityOneStand) if (((dst <= 3.0D) ? true : false) ^ ((offdst <= 3.0D) ? true : false))
/*     */             {
/* 356 */               if (!this.master.worldObj.isRemote)
/*     */               {
/* 358 */                 if (((EntityOneStand)entity).getMaster() == this.master)
/*     */                 {
/* 360 */                   this.havestand = true;
/*     */                 }
/*     */               }
/*     */             } 
/*     */         } 
/* 365 */         if (this.master.isSneaking()) {
/*     */           
/* 367 */           if (this.master.getFoodStats().getFoodLevel() > 6) {
/*     */             
/* 369 */             this.standontick++;
/* 370 */             if (this.standontick <= 20) {
/*     */               
/* 372 */               if (this.master.swingProgressInt != 0 && !this.icepunch && this.lasercooltime == 1) {
/*     */ 
/*     */                 
/* 375 */                 this.tick++;
/* 376 */                 if (this.tick == 1) {
/*     */                   
/* 378 */                   this.lasercooltimeanswer = 0;
/* 379 */                   this.worldObj.playSoundAtEntity(this.master, SoundEvents.eyeslaser.toString(), 1.0F, 1.0F);
/* 380 */                   this.lasercooltime = 1800;
/* 381 */                   if (!this.master.capabilities.isCreativeMode)
/*     */                   {
/* 383 */                     this.master.getFoodStats().addStats(-6, 0.0F);
/*     */                   }
/*     */                   
/* 386 */                   EntityVampire_bim entityarrow = new EntityVampire_bim(this.worldObj, this, 2.0F);
/* 387 */                   entityarrow.setIsCritical(true);
/* 388 */                   this.worldObj.spawnEntityInWorld(entityarrow);
/*     */                 } 
/*     */               } 
/* 391 */               if (this.master.swingProgressInt == 0 || this.icepunch);
/*     */ 
/*     */               
/* 394 */               if (this.master.swingProgressInt != 0 && this.lasercooltime != 0) {
/*     */                 
/* 396 */                 this.master.addChatMessage(new ChatComponentText("'space ripper stingy eyes' is not ready"));
/* 397 */                 this.master.addChatMessage(new ChatComponentText("Cooldown time : " + (this.lasercooltime / 20)));
/*     */               } 
/* 399 */               if (Math.abs(this.master.motionY) >= 0.3D) {
/*     */ 
/*     */                 
/* 402 */                 this.tick++;
/* 403 */                 if (this.tick == 1)
/*     */                 {
/* 405 */                   this.worldObj.playSoundAtEntity(this, SoundEvents.wry.toString(), 3.0F, 1.0F);
/* 406 */                   if (!this.master.capabilities.isCreativeMode)
/*     */                   {
/* 408 */                     this.master.getFoodStats().addStats(-2, 0.0F);
/*     */                   }
/* 410 */                   this.icepunch = true;
/*     */                 }
/*     */               
/*     */               } 
/*     */             } 
/*     */           } else {
/*     */             
/* 417 */             this.master.addChatMessage(new ChatComponentText("Check your hunger!"));
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 422 */           this.standontick = 0;
/* 423 */           this.tick = 0;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 428 */       if (this.icepunch) {
/*     */         
/* 430 */         if (this.master.swingProgressInt != 0) {
/*     */           
/* 432 */           this.oratickr++;
/* 433 */           if (this.forskillentity != null && (this.master.getLastAttacker()).hurtResistantTime != 0) {
/*     */             
/* 435 */             this.worldObj.playSoundAtEntity(this.master.getLastAttacker(), "jojo:ice_crack", 1.0F, 1.0F);
/* 436 */             if (!this.worldObj.isRemote)
/*     */             {
/* 438 */               this.forskillentity.attackEntityFrom(DamageSource.causeMobDamage(this.master), 1.0F);
/* 439 */               this.forskillentity.motionX = 0.0D;
/* 440 */               this.forskillentity.motionY = 0.0D;
/* 441 */               this.forskillentity.motionZ = 0.0D;
/* 442 */               onImpact((int)this.forskillentity.posX, (int)this.forskillentity.posY, (int)this.forskillentity.posZ);
/* 443 */               this.icepunch = false;
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 448 */             this.icepunch = false;
/*     */           } 
/*     */         } 
/*     */         
/* 452 */         if (this.forskillentity != null && (this.master.getLastAttacker()).hurtResistantTime != 0) {
/*     */           
/* 454 */           this.worldObj.playSoundAtEntity(this.master.getLastAttacker(), "jojo:ice_crack", 1.0F, 1.0F);
/* 455 */           if (!this.worldObj.isRemote) {
/*     */             
/* 457 */             this.forskillentity.attackEntityFrom(DamageSource.causeMobDamage(this.master), 1.0F);
/* 458 */             this.forskillentity.motionX = 0.0D;
/* 459 */             this.forskillentity.motionY = 0.0D;
/* 460 */             this.forskillentity.motionZ = 0.0D;
/* 461 */             onImpact((int)this.forskillentity.posX, (int)this.forskillentity.posY, (int)this.forskillentity.posZ);
/* 462 */             this.icepunch = false;
/*     */           } 
/*     */         } 
/* 465 */         if (this.oratickr >= 200) {
/*     */           
/* 467 */           if (!this.worldObj.isRemote)
/*     */           {
/* 469 */             this.icepunch = false;
/*     */           }
/* 471 */           this.oratickr = 0;
/* 472 */           this.icepunchint = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void onImpact(int i, int j, int k) {
/* 479 */     if (!this.worldObj.isRemote) {
/*     */       
/* 481 */       i -= 2;
/* 482 */       k -= 2;
/* 483 */       j -= 4;
/* 484 */       this.worldObj.setBlock(i + 0, j + 1, k + 1, Blocks.ice);
/* 485 */       this.worldObj.setBlock(i + 0, j + 2, k + 0, Blocks.ice);
/* 486 */       this.worldObj.setBlock(i + 0, j + 2, k + 1, Blocks.ice);
/* 487 */       this.worldObj.setBlock(i + 0, j + 2, k + 2, Blocks.ice);
/* 488 */       this.worldObj.setBlock(i + 0, j + 3, k + 0, Blocks.ice);
/* 489 */       this.worldObj.setBlock(i + 0, j + 3, k + 1, Blocks.ice);
/* 490 */       this.worldObj.setBlock(i + 0, j + 3, k + 2, Blocks.ice);
/* 491 */       this.worldObj.setBlock(i + 0, j + 4, k + 0, Blocks.ice);
/* 492 */       this.worldObj.setBlock(i + 0, j + 4, k + 1, Blocks.ice);
/* 493 */       this.worldObj.setBlock(i + 0, j + 4, k + 2, Blocks.ice);
/* 494 */       this.worldObj.setBlock(i + 0, j + 5, k + 1, Blocks.ice);
/* 495 */       this.worldObj.setBlock(i + 1, j + 0, k + 1, Blocks.ice);
/* 496 */       this.worldObj.setBlock(i + 1, j + 1, k + 0, Blocks.ice);
/* 497 */       this.worldObj.setBlock(i + 1, j + 1, k + 2, Blocks.ice);
/* 498 */       this.worldObj.setBlock(i + 1, j + 2, k + 0, Blocks.ice);
/* 499 */       this.worldObj.setBlock(i + 1, j + 2, k + 2, Blocks.ice);
/* 500 */       this.worldObj.setBlock(i + 1, j + 3, k + 0, Blocks.ice);
/* 501 */       this.worldObj.setBlock(i + 1, j + 3, k + 2, Blocks.ice);
/* 502 */       this.worldObj.setBlock(i + 1, j + 4, k + 0, Blocks.ice);
/* 503 */       this.worldObj.setBlock(i + 1, j + 4, k + 2, Blocks.ice);
/* 504 */       this.worldObj.setBlock(i + 1, j + 5, k + 0, Blocks.ice);
/* 505 */       this.worldObj.setBlock(i + 1, j + 5, k + 2, Blocks.ice);
/* 506 */       this.worldObj.setBlock(i + 1, j + 6, k + 1, Blocks.ice);
/* 507 */       this.worldObj.setBlock(i + 2, j + 1, k + 1, Blocks.ice);
/* 508 */       this.worldObj.setBlock(i + 2, j + 2, k + 0, Blocks.ice);
/* 509 */       this.worldObj.setBlock(i + 2, j + 2, k + 1, Blocks.ice);
/* 510 */       this.worldObj.setBlock(i + 2, j + 2, k + 2, Blocks.ice);
/* 511 */       this.worldObj.setBlock(i + 2, j + 3, k + 0, Blocks.ice);
/* 512 */       this.worldObj.setBlock(i + 2, j + 3, k + 1, Blocks.ice);
/* 513 */       this.worldObj.setBlock(i + 2, j + 3, k + 2, Blocks.ice);
/* 514 */       this.worldObj.setBlock(i + 2, j + 4, k + 0, Blocks.ice);
/* 515 */       this.worldObj.setBlock(i + 2, j + 4, k + 1, Blocks.ice);
/* 516 */       this.worldObj.setBlock(i + 2, j + 4, k + 2, Blocks.ice);
/* 517 */       this.worldObj.setBlock(i + 2, j + 5, k + 1, Blocks.ice);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void hold_entity(Entity par1Entity) {
/* 523 */     Entity entity = null;
/* 524 */     double d5 = par1Entity.getDistanceSq(this.posX, this.posY, this.posZ);
/* 525 */     double r = 0.0D;
/* 526 */     double closet = Math.PI * r * r * r;
/* 527 */     double max = Math.PI;
/* 528 */     if (d5 > closet) {
/*     */       
/* 530 */       entity = par1Entity;
/* 531 */       double dx = entity.posX - this.posX;
/* 532 */       double dy = entity.posY - this.posY;
/* 533 */       double dz = entity.posZ - this.posZ;
/* 534 */       float impower = 0.1F;
/* 535 */       if (dx > 0.0D)
/*     */       {
/* 537 */         entity.motionX += -impower;
/*     */       }
/* 539 */       if (dx < 0.0D)
/*     */       {
/* 541 */         entity.motionX += impower;
/*     */       }
/*     */       
/* 544 */       if (dy > 0.0D)
/*     */       {
/* 546 */         entity.motionY += -impower;
/*     */       }
/* 548 */       if (dy < 0.0D)
/*     */       {
/* 550 */         entity.motionY += impower;
/*     */       }
/*     */       
/* 553 */       if (dz > 0.0D)
/*     */       {
/* 555 */         entity.motionZ += -impower;
/*     */       }
/* 557 */       if (dz < 0.0D)
/*     */       {
/* 559 */         entity.motionZ += impower;
/*     */       }
/*     */     } 
/* 562 */     if (d5 > max)
/*     */     {
/* 564 */       entity.setPosition(this.posX, this.posY, this.posZ);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDead() {
/* 571 */     if (getMaster() != null) {
/*     */       
/* 573 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(getMaster());
/* 574 */       props.setPowerSpawned(false);
/*     */     } 
/* 576 */     super.setDead();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 581 */     super.onUpdate();
/* 582 */     if (!this.worldObj.isRemote)
/*     */     {
/* 584 */       if (getMaster() == null) {
/*     */         
/* 586 */         setDead();
/*     */       }
/*     */       else {
/*     */         
/* 590 */         if ((getMaster()).isDead)
/*     */         {
/* 592 */           setDead();
/*     */         }
/*     */         
/* 595 */         this.master.fallDistance = 0.0F;
/* 596 */         this.master.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 'Ұ', 0));
/* 597 */         this.master.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 'Ұ', 1));
/*     */         
/* 599 */         this.master.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 'Ұ', 3));
/* 600 */         this.master.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 'Ұ', 2));
/* 601 */         this.master.addPotionEffect(new PotionEffect(Potion.jump.getId(), 'Ұ', 2));
/* 602 */         setPosition(this.master.posX, this.master.posY, this.master.posZ);
/* 603 */         this.motionX = 0.0D;
/* 604 */         this.motionY = 0.0D;
/* 605 */         this.motionZ = 0.0D;
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
/* 623 */         float f = getBrightness(1.0F);
/*     */         
/* 625 */         if ((f > 0.7F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) || (this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.worldObj.isDaytime()))
/*     */         {
/* 627 */           getMaster().attackEntityFrom(DamageSource.inFire, JojoBAdvConfig.sunlightBurn);
/*     */         }
/*     */         
/* 630 */         int healAmount = 1;
/*     */ 
/*     */         
/* 633 */         this.healTimer++;
/* 634 */         if (this.healTimer > 20) {
/*     */           
/* 636 */           getMaster().heal(JojoBAdvConfig.vampireHeal);
/* 637 */           this.healTimer = 0;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/* 643 */   int healTimer = 0;
/*     */ 
/*     */   
/*     */   protected void setmaster(String par1Str) {
/* 647 */     if (!this.worldObj.isRemote) {
/* 648 */       this.master = this.worldObj.getPlayerEntityByName(par1Str);
/*     */     }
/*     */   }
/*     */   
/*     */   protected String getmastername() {
/* 653 */     if (!this.worldObj.isRemote) {
/*     */       
/* 655 */       if (this.master == null)
/*     */       {
/* 657 */         return this.mastername;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 662 */       return this.master.getDisplayName();
/*     */     } 
/*     */ 
/*     */     
/* 666 */     return "client";
/*     */   }
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
/* 670 */     super.readEntityFromNBT(nbttagcompound);
/* 671 */     if (!this.worldObj.isRemote) {
/*     */       
/* 673 */       this.mastername = nbttagcompound.getString("Owner");
/* 674 */       setmaster(this.mastername);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
/* 680 */     super.writeEntityToNBT(nbttagcompound);
/* 681 */     if (!this.worldObj.isRemote)
/*     */     {
/* 683 */       if (getmastername() == null) {
/*     */         
/* 685 */         nbttagcompound.setString("Owner", "");
/*     */       }
/*     */       else {
/*     */         
/* 689 */         nbttagcompound.setString("Owner", getmastername());
/* 690 */         System.out.println(getmastername() + "SAVE!!");
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 698 */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { return false; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/EntityVampirepower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */