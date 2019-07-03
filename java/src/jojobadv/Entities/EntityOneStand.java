/*     */ package src.jojobadv.Entities;
/*     */ 
/*     */ import net.minecraft.client.audio.SoundHandler;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdvConfig;
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
/*     */ public class EntityOneStand
/*     */   extends EntityCreature
/*     */ {
/*  28 */   private EntityLivingBase master = null;
/*     */   protected boolean standOn = true;
/*  30 */   protected int standAct = 0;
/*  31 */   protected int standActLimit = 0;
/*     */   private String mastername;
/*  33 */   protected int tick = 0;
/*  34 */   protected int standontick = 0;
/*     */   
/*     */   protected String spawnSound;
/*     */   
/*  38 */   protected int hungerTick = 0;
/*  39 */   protected int expTick = 0;
/*     */   
/*     */   public boolean timeStoppedBool = false;
/*     */   
/*     */   public EntityOneStand(World par1World) {
/*  44 */     super(par1World);
/*  45 */     if (par1World.isRemote)
/*     */     {
/*  47 */       this.spawnSound = SoundHandler.missing_sound.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  53 */   public void setTimeIsStopped(boolean value) { this.timeStoppedBool = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   public boolean getTimeIsStopped() { return this.timeStoppedBool; }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean timeContinueCheck = false;
/*     */ 
/*     */   
/*  66 */   public void setTimeContinue(boolean value) { this.timeContinueCheck = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   public boolean getTimeContinue() { return this.timeContinueCheck; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public boolean canRenderOnFire() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   protected void applyEntityAttributes() { super.applyEntityAttributes(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   protected void entityInit() { super.entityInit(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void giveItems(EntityPlayer player) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationYawHead(float value) {
/* 101 */     if (this.worldObj.isRemote)
/*     */     {
/* 103 */       super.setRotationYawHead(value);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 109 */   public void bespawn() { this.worldObj.playSoundAtEntity(getMaster(), this.spawnSound, 1.0F, 1.0F); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public void onUpdate2() { super.onUpdate(); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 119 */     super.onUpdate();
/* 120 */     this.fallDistance = 0.0F;
/* 121 */     if (!this.worldObj.isRemote)
/*     */     {
/* 123 */       if (getMaster() == null) {
/*     */         
/* 125 */         setDead();
/*     */       }
/*     */       else {
/*     */         
/* 129 */         EntityPlayer thePlayer = getMaster();
/*     */         
/*     */         try {
/* 132 */           setHealth(1000.0F);
/*     */         }
/* 134 */         catch (ClassCastException classCastException) {}
/*     */ 
/*     */ 
/*     */         
/* 138 */         if (thePlayer.isDead)
/*     */         {
/* 140 */           setDead();
/*     */         }
/*     */         
/* 143 */         if (thePlayer.fallDistance < 5.0F) {
/*     */           
/* 145 */           thePlayer.fallDistance = 0.0F;
/*     */         }
/*     */         else {
/*     */           
/* 149 */           (getMaster()).fallDistance -= 4.0F;
/*     */         } 
/* 151 */         if (getCatchPassive()) catchpassive();
/*     */         
/* 153 */         if (getTimeContinue()) {
/*     */           
/* 155 */           if (getTimeIsStopped())
/*     */           {
/* 157 */             setTimeIsStopped(false);
/*     */           }
/* 159 */           setTimeContinue(false);
/*     */         } 
/*     */         
/* 162 */         clearActivePotions();
/* 163 */         if (getAir() < 20)
/*     */         {
/* 165 */           setAir(60);
/*     */         }
/* 167 */         ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(thePlayer);
/*     */         
/* 169 */         if (this.expTick == JojoBAdvConfig.standExpTime * 20) {
/*     */           
/* 171 */           props.setPlayerStandExp(props.getPlayerStandExp() + JojoBAdvConfig.standExpGain);
/* 172 */           this.expTick = 0;
/*     */         } 
/*     */         
/* 175 */         if (!props.getStandOn()) {
/*     */           
/* 177 */           setDead();
/*     */         }
/*     */         else {
/*     */           
/* 181 */           fallowmaster();
/*     */           
/* 183 */           this.expTick++;
/* 184 */           if (this.notenoughExpTimer < 80) this.notenoughExpTimer++; 
/* 185 */           if (this.hungerTimer < 80) this.hungerTimer++;
/*     */           
/* 187 */           if (getMaster().getFoodStats().getFoodLevel() < 20)
/*     */           {
/* 189 */             if (JojoBAdvConfig.allowStandHunger) {
/*     */               
/* 191 */               if (this.hungerTick >= JojoBAdvConfig.hungerTime * 20) {
/*     */                 
/* 193 */                 getMaster().getFoodStats().addStats(-1, 0.0F);
/* 194 */                 this.hungerTick = 0;
/*     */               }
/*     */               else {
/*     */                 
/* 198 */                 this.hungerTick++;
/*     */               } 
/* 200 */               setCustomNameTag("");
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer player) {
/* 211 */     if (player.getHeldItem() != null && player.getHeldItem().getItem() == Items.name_tag)
/*     */     {
/* 213 */       if (player == getMaster()) {
/*     */         
/* 215 */         if (player.getHeldItem().hasDisplayName()) {
/*     */           
/* 217 */           ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 218 */           props.setPlayerStandName(player.getHeldItem().getDisplayName());
/* 219 */           setCustomNameTag(player.getHeldItem().getDisplayName());
/* 220 */           (player.getHeldItem()).stackSize--;
/* 221 */           return false;
/*     */         } 
/*     */       } else {
/* 224 */         return false;
/*     */       } 
/*     */     }
/* 227 */     return super.interact(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 232 */   public boolean getCatchPassive() { return this.catchCheck; }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean catchCheck = false;
/*     */ 
/*     */   
/* 239 */   public void setCatchPassive() { this.catchCheck = true; }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fallowmaster() {
/* 244 */     Entity entity = null;
/* 245 */     double d5 = getMaster().getDistanceSq(this.posX, this.posY, this.posZ);
/* 246 */     double r = 1.5D;
/* 247 */     double max = Math.PI * r * r * r;
/* 248 */     double tp = 201.06192982974676D;
/* 249 */     double closet = 0.39269908169872414D;
/* 250 */     if (d5 >= closet)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 256 */       if (d5 < max) {
/*     */         
/* 258 */         EntityPlayer entityPlayer = getMaster();
/* 259 */         double dx = this.posX - entityPlayer.posX;
/* 260 */         double dy = this.posY - entityPlayer.posY;
/* 261 */         double dz = this.posZ - entityPlayer.posZ;
/* 262 */         float impower = (float)d5 / 60.0F;
/* 263 */         if (dx > 0.0D)
/*     */         {
/* 265 */           this.motionX += -impower;
/*     */         }
/* 267 */         if (dx < 0.0D)
/*     */         {
/* 269 */           this.motionX += impower;
/*     */         }
/*     */         
/* 272 */         if (dy > 0.0D)
/*     */         {
/* 274 */           this.motionY += -impower;
/*     */         }
/* 276 */         if (dy < 0.0D)
/*     */         {
/* 278 */           this.motionY += impower;
/*     */         }
/*     */         
/* 281 */         if (dz > 0.0D)
/*     */         {
/* 283 */           this.motionZ += -impower;
/*     */         }
/* 285 */         if (dz < 0.0D)
/*     */         {
/* 287 */           this.motionZ += impower;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 292 */       else if (!this.worldObj.isRemote) {
/*     */         
/* 294 */         setPosition((getMaster()).posX, (getMaster()).posY, (getMaster()).posZ);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 302 */   public boolean getCanChangeAct() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeAct() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 312 */   public boolean getStandOn() { return this.standOn; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 317 */   public void setStandOn(boolean par1) { this.standOn = par1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 323 */   public EntityPlayer getMaster() { return (EntityPlayer)this.master; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaster(String par1Str) {
/* 328 */     if (!this.worldObj.isRemote) {
/* 329 */       this.master = this.worldObj.getPlayerEntityByName(par1Str);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setMastername(String par1Str) {
/* 334 */     if (!this.worldObj.isRemote) {
/* 335 */       this.mastername = par1Str;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMastername() {
/* 340 */     if (!this.worldObj.isRemote) {
/*     */       
/* 342 */       if (getMaster() == null)
/*     */       {
/* 344 */         return this.mastername;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 349 */       return getMaster().getDisplayName();
/*     */     } 
/*     */ 
/*     */     
/* 353 */     return "client";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
/* 359 */     super.readEntityFromNBT(nbttagcompound);
/* 360 */     this.mastername = nbttagcompound.getString("Owner");
/* 361 */     setMaster(this.mastername);
/* 362 */     setMastername(this.mastername);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
/* 368 */     super.writeEntityToNBT(nbttagcompound);
/* 369 */     if (getMastername() == null) {
/*     */       
/* 371 */       nbttagcompound.setString("Owner", "");
/*     */     }
/*     */     else {
/*     */       
/* 375 */       nbttagcompound.setString("Owner", getMastername());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 381 */   protected String getHurtSound() { return null; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 387 */   public boolean isEntityInsideOpaqueBlock() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void playStepSound(int par1, int par2, int par3, int par4) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 398 */     if (getMaster() != null) {
/*     */       
/* 400 */       if (this.standOn) {
/*     */         
/* 402 */         if (par1DamageSource.getEntity() == getMaster())
/*     */         {
/* 404 */           return false;
/*     */         }
/* 406 */         if (par1DamageSource == DamageSource.cactus)
/*     */         {
/* 408 */           return false;
/*     */         }
/*     */ 
/*     */         
/* 412 */         super.attackEntityFrom(par1DamageSource, par2);
/* 413 */         getMaster().attackEntityFrom(par1DamageSource, par2 * 0.5F);
/* 414 */         return false;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 419 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 424 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnActCheck() {}
/*     */   
/* 430 */   public int hungerTimer = 0;
/* 431 */   public int notenoughExpTimer = 0;
/*     */ 
/*     */   
/*     */   public void hungerMessage() {
/* 435 */     if (this.hungerTimer == 1)
/*     */     {
/* 437 */       getMaster().addChatMessage(new ChatComponentTranslation("msg.jojobadv.hunger.txt", new Object[0]));
/*     */     }
/* 439 */     if (this.hungerTimer >= 40)
/*     */     {
/* 441 */       this.hungerTimer = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void notEnoughExpMessage() {
/* 447 */     if (this.notenoughExpTimer == 1)
/*     */     {
/* 449 */       getMaster().addChatMessage(new ChatComponentTranslation("msg.jojobadv.notenoughexp.txt", new Object[0]));
/*     */     }
/* 451 */     if (this.notenoughExpTimer >= 40)
/*     */     {
/* 453 */       this.notenoughExpTimer = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackSwing(EntityPlayer player) {
/* 459 */     if (player.isSwingInProgress)
/*     */     {
/* 461 */       if (getAttackTrue()) {
/*     */         
/* 463 */         setAttackTrue(false);
/* 464 */         return true;
/*     */       } 
/*     */     }
/* 467 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean attackBool = false;
/*     */ 
/*     */   
/* 474 */   public void setAttackTrue(boolean value) { this.attackBool = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 479 */   public boolean getAttackTrue() { return this.attackBool; }
/*     */ 
/*     */ 
/*     */   
/*     */   private void catchpassive() {
/* 484 */     Entity entity = null;
/* 485 */     for (int i1 = 0; i1 < this.worldObj.loadedEntityList.size(); i1++) {
/*     */       
/* 487 */       Entity entityplayer1 = (Entity)this.worldObj.loadedEntityList.get(i1);
/* 488 */       double dst = entityplayer1.getDistanceSq((getMaster()).posX, (getMaster()).posY, (getMaster()).posZ);
/* 489 */       int r = 2;
/* 490 */       double d2 = Math.PI * r * r * r;
/* 491 */       entity = entityplayer1;
/* 492 */       if (!this.worldObj.isRemote && entity instanceof net.minecraft.entity.item.EntityTNTPrimed ^ entity instanceof net.minecraft.entity.projectile.EntityArrow ^ entity instanceof src.jojobadv.Entities.Stands.EntityEmperor_bullet ^ entity instanceof net.minecraft.entity.item.EntityFallingBlock && dst <= d2) {
/*     */         
/* 494 */         entity = entityplayer1;
/* 495 */         double dx = this.posX - entity.posX;
/* 496 */         double dy = this.posY - entity.posY;
/* 497 */         double dz = this.posZ - entity.posZ;
/* 498 */         float impower = 0.3F;
/* 499 */         if (dx > 0.0D)
/*     */         {
/* 501 */           entity.motionX = -impower;
/*     */         }
/* 503 */         if (dx < 0.0D)
/*     */         {
/* 505 */           entity.motionX = impower;
/*     */         }
/*     */         
/* 508 */         if (dy > 0.0D)
/*     */         {
/* 510 */           entity.motionY = -impower;
/*     */         }
/* 512 */         if (dy < 1.0D)
/*     */         {
/* 514 */           entity.motionY = impower;
/*     */         }
/*     */         
/* 517 */         if (dz > 0.0D)
/*     */         {
/* 519 */           entity.motionZ = -impower;
/*     */         }
/* 521 */         if (dz < 0.0D)
/*     */         {
/* 523 */           entity.motionZ = impower;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/EntityOneStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */