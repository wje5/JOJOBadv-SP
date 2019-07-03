/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityStickyFingers
/*     */   extends EntityOneStand
/*     */ {
/*     */   public boolean arrirush;
/*     */   public boolean arrirush_s;
/*  20 */   public int arritick = 0;
/*     */   public int arritickr;
/*  22 */   private int changetick = 0;
/*     */   
/*     */   public Entity skilltarget;
/*     */   public boolean revival = false;
/*  26 */   private int revivaltick = 0;
/*  27 */   private int reviveCooldown = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityStickyFingers(World par1World) {
/*  36 */     super(par1World);
/*  37 */     setSize(1.2F, 2.7F);
/*     */     
/*  39 */     this.spawnSound = "jojobadv:spawn_sf";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  48 */     super.onUpdate();
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
/*  94 */     if (!this.worldObj.isRemote)
/*     */     {
/*  96 */       if (getMaster() != null) {
/*     */         
/*  98 */         EntityPlayer player = getMaster();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 121 */         player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 40, 1));
/*     */ 
/*     */         
/* 124 */         ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 125 */         if (player.getFoodStats().getFoodLevel() > 0 && props.getPlayerStandExp() > 300)
/*     */         {
/* 127 */           if (player.isSneaking() && Math.abs(player.motionY) >= 0.3D)
/*     */           {
/* 129 */             if (!player.isDead && player.getHealth() <= 4.0F && this.reviveCooldown == 0) {
/*     */               
/* 131 */               this.revival = true;
/* 132 */               this.reviveCooldown = 200;
/*     */             } 
/*     */           }
/*     */         }
/*     */         
/* 137 */         if (this.revival) {
/*     */           
/* 139 */           this.revivaltick++;
/* 140 */           if (this.revivaltick == 1) {
/*     */             
/* 142 */             this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.revival.toString(), 1.0F, 1.0F);
/* 143 */             getMaster().addPotionEffect(new PotionEffect(Potion.field_76444_x.getId(), 60, 1));
	
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 148 */           if (this.revivaltick >= 100) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 154 */             this.revival = false;
/* 155 */             this.revivaltick = 0;
/*     */           } 
/*     */         } 
/*     */         
/* 159 */         if (this.standOn) {
/*     */           
/* 161 */           if (this.reviveCooldown > 0)
/*     */           {
/* 163 */             this.reviveCooldown--;
/*     */           }
/* 165 */           fallowmaster();
/* 166 */           setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*     */           
/* 168 */           if (getMaster() instanceof EntityPlayer) {
/*     */             
/* 170 */             if (getMaster().isSprinting()) {
/*     */               
/* 172 */               if (attackSwing(getMaster()))
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 181 */                 if (getMaster().getFoodStats().getFoodLevel() > 3) {
/*     */                   
/* 183 */                   this.arritick++;
/* 184 */                   if (this.arritick == 1)
/*     */                   {
/* 186 */                     this.worldObj.playSoundAtEntity(this, SoundEvents.arrirush_s.toString(), 1.0F, 1.0F);
/* 187 */                     if (!(getMaster()).capabilities.isCreativeMode)
/*     */                     {
/* 189 */                       getMaster().getFoodStats().addStats(-4, 0.0F);
/*     */                     }
/* 191 */                     this.arrirush_s = true;
/*     */                   }
/*     */                 
/*     */                 } else {
/*     */                   
/* 196 */                   hungerMessage();
/*     */                 
/*     */                 }
/*     */               
/*     */               }
/*     */             }
/* 202 */             else if (attackSwing(getMaster())) {
/*     */ 
/*     */               
/* 205 */               this.arritick++;
/*     */               
/* 207 */               if (this.arritick == 1) {
/*     */                 
/* 209 */                 this.worldObj.playSoundAtEntity(getMaster(), SoundEvents.knife_swing_miss1.toString(), 0.3F, 4.0F);
/* 210 */                 EntityStickyFingers_punch entityarrow = new EntityStickyFingers_punch(this.worldObj, this, 2.0F);
/* 211 */                 entityarrow.setIsCritical(true);
/* 212 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */               } 
/*     */             } 
/*     */             
/* 216 */             if ((getMaster()).swingProgressInt == 0)
/*     */             {
/* 218 */               this.arritick = 0;
/*     */             }
/* 220 */             if (this.arrirush_s) {
/*     */               
/* 222 */               getMaster().setSprinting(false);
/* 223 */               this.arritickr++;
/* 224 */               if (this.arritickr < 26) {
/*     */                 
/* 226 */                 getMaster().setSprinting(false);
/* 227 */                 EntityStickyFingers_punch entityarrow = new EntityStickyFingers_punch(this.worldObj, this, 2.0F);
/* 228 */                 entityarrow.setIsCritical(true);
/* 229 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */                 
/* 231 */                 EntityStickyFingers_punch entityarrow2 = new EntityStickyFingers_punch(this.worldObj, this, 2.0F);
/* 232 */                 entityarrow2.setIsCritical(true);
/* 233 */                 this.worldObj.spawnEntityInWorld(entityarrow2);
/*     */               } 
/* 235 */               if (this.arritickr >= 30) {
/*     */                 
/* 237 */                 this.arrirush_s = false;
/* 238 */                 this.arritickr = 0;
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 243 */             if (this.arrirush) {
/*     */               
/* 245 */               if (this.skilltarget != null && !this.skilltarget.isDead) {
/*     */                 
/* 247 */                 fallowtarget();
/* 248 */                 setTarget(this.skilltarget);
/*     */               } 
/*     */               
/* 251 */               getMaster().setSprinting(false);
/* 252 */               this.arritickr++;
/* 253 */               if (100 < this.arritickr && this.arritickr < 316) {
/*     */                 
/* 255 */                 getMaster().setSprinting(false);
/* 256 */                 EntityStickyFingers_punch entityarrow = new EntityStickyFingers_punch(this.worldObj, this, 2.0F);
/* 257 */                 entityarrow.setIsCritical(true);
/* 258 */                 this.worldObj.spawnEntityInWorld(entityarrow);
/*     */                 
/* 260 */                 EntityStickyFingers_punch entityarrow2 = new EntityStickyFingers_punch(this.worldObj, this, 2.0F);
/* 261 */                 entityarrow2.setIsCritical(true);
/* 262 */                 this.worldObj.spawnEntityInWorld(entityarrow2);
/*     */               } 
/* 264 */               if (this.arritickr >= 320) {
/*     */                 
/* 266 */                 this.arrirush = false;
/* 267 */                 this.arritickr = 0;
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
/*     */   private void fallowtarget() {
/* 282 */     Entity entity = null;
/* 283 */     double d5 = this.skilltarget.getDistanceSq(this.posX, this.posY, this.posZ);
/* 284 */     double r = 4.0D;
/* 285 */     double max = Math.PI * r * r * r;
/* 286 */     double tp = 678.5840131753953D;
/* 287 */     double closet = 25.132741228718345D;
/* 288 */     if (d5 < max) {
/*     */       
/* 290 */       entity = this.skilltarget;
/* 291 */       double dx = this.posX - entity.posX;
/* 292 */       double dy = this.posY - entity.posY;
/* 293 */       double dz = this.posZ - entity.posZ;
/* 294 */       float impower = (float)d5 / 100.0F;
/* 295 */       float impower2 = (float)d5 / 210.0F;
/* 296 */       if (d5 < closet)
/*     */       {
/* 298 */         if (dx > 0.0D)
/*     */         {
/* 300 */           this.motionX -= -impower2;
/*     */         }
/* 302 */         if (dx < 0.0D)
/*     */         {
/* 304 */           this.motionX -= impower2;
/*     */         }
/* 306 */         if (dz > 0.0D)
/*     */         {
/* 308 */           this.motionZ -= -impower2;
/*     */         }
/* 310 */         if (dz < 0.0D)
/*     */         {
/* 312 */           this.motionZ -= impower2;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 317 */         if (dx > 0.0D)
/*     */         {
/* 319 */           this.motionX += -impower;
/*     */         }
/* 321 */         if (dx < 0.0D)
/*     */         {
/* 323 */           this.motionX += impower;
/*     */         }
/*     */         
/* 326 */         if (dy > 0.0D);
/*     */ 
/*     */ 
/*     */         
/* 330 */         if (dy < 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 335 */         if (dz > 0.0D)
/*     */         {
/* 337 */           this.motionZ += -impower;
/*     */         }
/* 339 */         if (dz < 0.0D)
/*     */         {
/* 341 */           this.motionZ += impower;
/*     */         
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 347 */     else if (!this.worldObj.isRemote) {
/*     */       
/* 349 */       this.posX = this.skilltarget.posX;
/* 350 */       this.posZ = this.skilltarget.posZ;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityStickyFingers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */