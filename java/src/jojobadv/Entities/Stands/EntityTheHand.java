/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.JojoBAdvLib;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityTheHand
/*     */   extends EntityOneStand
/*     */ {
/*  32 */   private int punchTick = 0;
/*     */   public boolean orarush = false;
/*  34 */   public int warpCoolDown = 0;
/*  35 */   public int sneakTimer = 0;
/*     */ 
/*     */   
/*     */   public EntityTheHand(World par1World) {
/*  39 */     super(par1World);
/*  40 */     this.spawnSound = SoundEvents.spawn_th.toString();
/*  41 */     setSize(1.0F, 2.7F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  46 */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { return false; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  51 */     super.onUpdate();
/*  52 */     if (getMaster() != null) {
/*     */       
/*  54 */       EntityPlayer player = getMaster();
/*  55 */       getMaster().addPotionEffect(new PotionEffect(Potion.resistance.getId(), 40, 2));
/*     */       
/*  57 */       if (this.standOn) {
/*     */         
/*  59 */         fallowmaster();
/*  60 */         setRotationYawHead((getMaster()).rotationYaw);
/*  61 */         setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*     */         
/*  63 */         if (player.isSneaking() && !player.capabilities.isFlying) {
/*     */           
/*  65 */           double pp = 0.8D;
/*  66 */           doParticles(this);
/*  67 */           attractItems(this);
/*  68 */           this.sneakTimer++;
/*     */           
/*  70 */           String s1 = StatCollector.translateToLocal("msg.jojobadv.sneaktimer.txt");
/*  71 */           String s2 = StatCollector.translateToLocal("msg.jojobadv.seconds.txt");
/*  72 */           if (this.sneakTimer % 20 == 0) player.addChatMessage(new ChatComponentTranslation(s1 + (this.sneakTimer / 20) + " " + s2, new Object[0]));
/*     */           
/*  74 */           if (Math.abs((getMaster()).motionY) >= 0.2D && player.getFoodStats().getFoodLevel() > 4)
/*     */           {
/*  76 */             int foodUse = 0;
/*  77 */             if (this.sneakTimer > 60) {
/*     */               
/*  79 */               if (this.sneakTimer > 120) {
/*     */                 
/*  81 */                 destroyBlocks(this);
/*  82 */                 foodUse = 3;
/*     */               }
/*     */               else {
/*     */                 
/*  86 */                 attractEntities(this);
/*  87 */                 foodUse = 2;
/*     */               } 
/*  89 */               this.worldObj.playSoundAtEntity(player, SoundEvents.scrape.toString(), 0.6F, 4.0F);
/*     */             } 
/*     */             
/*  92 */             if (!player.capabilities.isCreativeMode)
/*     */             {
/*  94 */               player.getFoodStats().addStats(-foodUse * 2, 0.0F);
/*     */             }
/*  96 */             this.sneakTimer = 0;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 101 */           this.sneakTimer = 0;
/*     */         } 
/*     */ 
/*     */         
/* 105 */         if (player.isSprinting()) {
/*     */           
/* 107 */           if (player.getFoodStats().getFoodLevel() > 4) {
/*     */             
/* 109 */             if (this.warpCoolDown <= 0)
/*     */             {
/* 111 */               if (attackSwing(player))
/*     */               {
/* 113 */                 MovingObjectPosition moveObj = JojoBAdvLib.getPlayerRayTrace(player, 10.0D, 1.0F);
/* 114 */                  if (moveObj.typeOfHit.equals(MovingObjectPosition.MovingObjectType.MISS)) {
/*     */                   
/* 116 */                   player.setPositionAndUpdate(moveObj.blockX + 0.5D, moveObj.blockY + 1.0D, moveObj.blockZ + 0.5D);
/*     */                 } else {
/* 118 */                    if (moveObj.typeOfHit.equals(MovingObjectPosition.MovingObjectType.ENTITY)) {
/*     */                     
/* 120 */                     player.setPositionAndUpdate(moveObj.entityHit.posX + 0.5D, moveObj.entityHit.posY + 1.0D, moveObj.entityHit.posZ + 0.5D);
/*     */                   } else {
/* 122 */                      if (moveObj.typeOfHit.equals(MovingObjectPosition.MovingObjectType.BLOCK))
/*     */                     {
/* 124 */                       player.setPositionAndUpdate(moveObj.blockX + 0.5D, moveObj.blockY + 1.0D, moveObj.blockZ + 0.5D); } 
/*     */                   } 
/*     */                 } 
/* 127 */                 if (!player.capabilities.isCreativeMode)
/*     */                 {
/* 129 */                   player.getFoodStats().addStats(-2, 0.0F);
/*     */                 }
/* 131 */                 this.warpCoolDown = 40;
/* 132 */                 this.worldObj.playSoundAtEntity(player, SoundEvents.scrape.toString(), 0.6F, 4.0F);
/*     */               }
/*     */             
/*     */             }
/*     */           } else {
/*     */             
/* 138 */             hungerMessage();
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
/*     */           }
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
/*     */         }
/* 162 */         else if (attackSwing(getMaster())) {
/*     */           
/* 164 */           this.punchTick++;
/* 165 */           if (this.punchTick == 1) {
/*     */             
/* 167 */             this.worldObj.playSoundAtEntity(this, SoundEvents.last_ora.toString(), 0.7F, 0.8F / (this.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/* 168 */             EntityTheHand_punch entityarrow = new EntityTheHand_punch(this.worldObj, this, 2.0F);
/* 169 */             entityarrow.setIsCritical(true);
/* 170 */             this.worldObj.spawnEntityInWorld(entityarrow);
/*     */           } 
/*     */         } 
/*     */         
/* 174 */         if ((getMaster()).swingProgressInt == 0)
/*     */         {
/* 176 */           this.punchTick = 0;
/*     */         }
/*     */         
/* 179 */         if (this.warpCoolDown > 0)
/*     */         {
/* 181 */           this.warpCoolDown--;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void attractItems(EntityTheHand theHand) {
/* 189 */     if (!theHand.worldObj.isRemote) {
/*     */       
/* 191 */       EntityPlayer player = theHand.getMaster();
/* 192 */       double expansionValue = 10.0D;
/* 193 */       List itemList = theHand.worldObj.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(player.posX, player.posY, player.posZ, player.posX, player.posY, player.posZ).expand(expansionValue, player.height + 0.2D, expansionValue));
/* 194 */       for (int i = 0; i < itemList.size(); i++) {
/*     */         
/* 196 */         if (itemList.get(i) instanceof EntityItem) {
/*     */           
/* 198 */           EntityItem entItem = (EntityItem)itemList.get(i);
/* 199 */           double dx = player.posX - entItem.posX;
/* 200 */           double dy = player.posY - entItem.posY;
/* 201 */           double dz = player.posZ - entItem.posZ;
/* 202 */           entItem.addVelocity(dx / 30.0D, dy / 30.0D, dz / 30.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void attractEntities(EntityTheHand theHand) {
/* 210 */     EntityPlayer player = theHand.getMaster();
/* 211 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 212 */     int exp = props.getPlayerStandExp();
/* 213 */     double expansionValue = 6.0D;
/* 214 */     if (exp % 100 == 0) {
/*     */       
/* 216 */       int toAdd = exp % 100;
/* 217 */       expansionValue += toAdd;
/* 218 */       if (expansionValue > 20.0D)
/*     */       {
/* 220 */         expansionValue = 20.0D;
/*     */       }
/*     */     } 
/* 223 */     List itemList = theHand.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX, player.posY, player.posZ, player.posX, player.posY, player.posZ).expand(expansionValue, player.height + 0.2D, expansionValue));
/* 224 */     for (int i = 0; i < itemList.size(); i++) {
/*     */       
/* 226 */       if (itemList.get(i) instanceof EntityLivingBase) {
/*     */         
/* 228 */         EntityLivingBase entity = (EntityLivingBase)itemList.get(i);
/* 229 */         if (!(entity instanceof EntityOneStand) && entity != player) {
/*     */           
/* 231 */           double dx = player.posX - entity.posX - 0.5D;
/* 232 */           double dy = player.posY - entity.posY + 0.5D;
/* 233 */           double dz = player.posZ - entity.posZ - 0.5D;
/* 234 */           entity.setPositionAndUpdate(entity.posX + dx, entity.posY + dy, entity.posZ + dz);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyBlocks(EntityTheHand theHand) {
/* 242 */     for (int i = 0; i < 7; i++) {
/*     */       
/* 244 */       for (int j = 0; j < 7; j++) {
/*     */         
/* 246 */         for (int k = 0; k < 3; k++) {
/*     */           
/* 248 */           int di = (int)(theHand.getMaster()).posX + i - 4;
/* 249 */           int dj = (int)(theHand.getMaster()).posY + k;
/* 250 */           int dk = (int)(theHand.getMaster()).posZ + j - 3;
/* 251 */           Block block = this.worldObj.getBlock(di, dj, dk);
/* 252 */           if (block != Blocks.air)
/*     */           {
/* 254 */             if (block.getBlockHardness(this.worldObj, di, dj, dk) < 5.0F)
/*     */             {
/* 256 */               //this.worldObj.setBlockToAir(di, dj, dk);
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void doParticles(EntityOneStand stand) {
/* 266 */     EntityPlayer player = stand.getMaster();
/* 267 */     EntityPlayer entityPlayer = player;
/* 268 */     double pp = 0.4D;
/* 269 */     Random random = new Random();
/* 270 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX - 3.0D, entityPlayer.posY + 0.3D, entityPlayer.posZ, pp, -pp / 10.0D, 0.0D);
/* 271 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX - 3.0D, entityPlayer.posY + 0.3D, entityPlayer.posZ, pp, -pp / 10.0D, 0.0D);
/* 272 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX + 3.0D, entityPlayer.posY + 0.3D, entityPlayer.posZ, -pp, -pp / 10.0D, 0.0D);
/* 273 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX, entityPlayer.posY + 0.3D, entityPlayer.posZ - 3.0D, 0.0D, -pp / 10.0D, pp);
/* 274 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX, entityPlayer.posY + 0.3D, entityPlayer.posZ + 3.0D, 0.0D, -pp / 10.0D, -pp);
/* 275 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX - 3.0D, entityPlayer.posY + 0.3D, entityPlayer.posZ - 3.0D, pp, -pp / 10.0D, pp);
/* 276 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX + 3.0D, entityPlayer.posY + 0.3D, entityPlayer.posZ + 3.0D, -pp, -pp / 10.0D, -pp);
/* 277 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX + 3.0D, entityPlayer.posY + 0.3D, entityPlayer.posZ - 3.0D, -pp, -pp / 10.0D, pp);
/* 278 */     JojoBAdv.proxy.spawnParticle(entityPlayer.worldObj, "smoke", entityPlayer.posX - 3.0D, entityPlayer.posY + 0.3D, entityPlayer.posZ + 3.0D, pp, -pp / 10.0D, -pp);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityTheHand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */