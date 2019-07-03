/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityVampire;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemSkillVamprieJump
/*     */   extends Item
/*     */ {
/*  27 */   private int tick = 0;
/*  28 */   private int airtick = 0;
/*     */   
/*     */   private boolean readySucking = false;
/*     */   private double max;
/*     */   private boolean bloodsucking = false;
/*  33 */   private int oratickr = 0;
/*  34 */   private int vintickr = 0;
/*  35 */   private int oratick = 0;
/*     */   
/*  37 */   private int checkGround = 0;
/*     */   
/*  39 */   private EntityLivingBase lastentity = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemSkillVamprieJump() {
/*  44 */     this.maxStackSize = 64;
/*  45 */     setTextureName("jojobadv:item_vampireJump");
/*  46 */     setUnlocalizedName("item_vampireJump");
/*  47 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  52 */   public EnumAction getItemUseAction(ItemStack par1ItemStack) { return EnumAction.bow; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { return par1ItemStack; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public int getMaxItemUseDuration(ItemStack par1ItemStack) { return 72000; }
/*     */ 
/*     */   
/*     */   public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count) {
/*  75 */     this.tick++;
/*  76 */     if (this.tick < 30) {
/*     */       
/*  78 */       double pp = 0.8D;
/*  79 */       player.worldObj.spawnParticle("explode", player.posX - 5.0D, player.posY + 3.0D, player.posZ, pp, -pp, 0.0D);
/*  80 */       player.worldObj.spawnParticle("explode", player.posX + 5.0D, player.posY + 3.0D, player.posZ, -pp, -pp, 0.0D);
/*  81 */       player.worldObj.spawnParticle("explode", player.posX, player.posY + 3.0D, player.posZ - 5.0D, 0.0D, -pp, pp);
/*  82 */       player.worldObj.spawnParticle("explode", player.posX, player.posY + 3.0D, player.posZ + 5.0D, 0.0D, -pp, -pp);
/*  83 */       player.worldObj.spawnParticle("explode", player.posX, player.posY + 3.0D, player.posZ, 0.0D, -pp, 0.0D);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  88 */     Entity entity = null;
/*  89 */     if (par3EntityPlayer.onGround && !this.bloodsucking)
/*     */     {
/*  91 */       for (int i1 = 0; i1 < par3EntityPlayer.worldObj.loadedEntityList.size(); i1++) {
/*     */         
/*  93 */         Entity entityplayer1 = (Entity)par3EntityPlayer.worldObj.loadedEntityList.get(i1);
/*  94 */         double dst = entityplayer1.getDistanceSq(par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ);
/*  95 */         entity = entityplayer1;
/*  96 */         if (entity instanceof src.jojobadv.Entities.EntityVampirepower && dst <= 15.0D)
/*     */         {
/*  98 */           if (par3EntityPlayer.getFoodStats().getFoodLevel() > 6) {
/*     */             
/* 100 */             par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*     */           }
/*     */           else {
/*     */             
/* 104 */             par3EntityPlayer.addChatMessage(new ChatComponentText("Check your hunger!"));
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/* 109 */     return par1ItemStack;
/*     */   }
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/* 113 */     if (!par2World.isRemote)
/*     */     {
/* 115 */       if (this.tick >= 40) {
/*     */         
/* 117 */         par1ItemStack.stackSize = 1;
/*     */         
/* 119 */         if (!par3EntityPlayer.capabilities.isCreativeMode)
/*     */         {
/* 121 */           par3EntityPlayer.getFoodStats().addStats(-6, 0.0F);
/*     */         }
/* 123 */         this.tick = 0;
/* 124 */         this.checkGround = 0;
/* 125 */         this.oratick = 0;
/*     */         
/* 127 */         this.readySucking = true;
/* 128 */         par2World.playSoundAtEntity(par3EntityPlayer, SoundEvents.wry.toString(), 3.0F, 1.0F);
/*     */       }
/*     */       else {
/*     */         
/* 132 */         this.tick = 0;
/*     */       } 
/*     */     }
/* 135 */     Vec3 vLook = par3EntityPlayer.getLook(1.0F);
/* 136 */     if (this.tick >= 40) {
/*     */       
/* 138 */       par3EntityPlayer.motionY += 0.5D;
/* 139 */       par3EntityPlayer.motionX += vLook.xCoord * 3.0D;
/* 140 */       par3EntityPlayer.motionY += vLook.yCoord * 2.0D;
/* 141 */       par3EntityPlayer.motionZ += vLook.zCoord * 3.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
/* 146 */     if (this.lastentity == null && this.readySucking && !par3Entity.onGround)
/*     */     {
/* 148 */       for (int i1 = 0; i1 < par2World.loadedEntityList.size(); i1++) {
/*     */         
/* 150 */         Entity entity = (Entity)par2World.loadedEntityList.get(i1);
/* 151 */         double d5 = entity.getDistanceSq(par3Entity.posX, par3Entity.posY, par3Entity.posZ);
/* 152 */         if (entity != par3Entity && !(entity instanceof net.minecraft.entity.monster.EntityMob ^ entity instanceof src.jojobadv.Entities.EntityOneStand ^ entity instanceof src.jojobadv.Entities.Entityhamon ^ entity instanceof src.jojobadv.Entities.EntityVampirepower) && entity instanceof EntityLivingBase && d5 <= this.max)
/*     */         {
/* 154 */           this.lastentity = (EntityLivingBase)entity;
/*     */         }
/*     */       } 
/*     */     }
/* 158 */     if (par3Entity.onGround)
/*     */     {
/* 160 */       if (!par2World.isRemote) {
/*     */         
/* 162 */         this.checkGround++;
/*     */         
/* 164 */         if (this.checkGround >= 20)
/*     */         {
/* 166 */           this.readySucking = false;
/*     */         }
/*     */       } 
/*     */     }
/* 170 */     if (this.lastentity != null) {
/*     */       
/* 172 */       if (!par2World.isRemote) {
/*     */         
/* 174 */         this.checkGround = 0;
/* 175 */         this.readySucking = false;
/* 176 */         this.bloodsucking = true;
/* 177 */         this.oratick++;
/* 178 */         if (this.oratick == 1) {
/*     */           
/* 180 */           par2World.playSoundAtEntity(par3Entity, SoundEvents.vinjak.toString(), 3.0F, 1.0F);
/*     */           
/* 182 */           this.bloodsucking = true;
/*     */         } 
/*     */       } 
/*     */       
/* 186 */       if (this.bloodsucking)
/*     */       {
/* 188 */         hold_entity(this.lastentity, par3Entity);
/* 189 */         this.lastentity.posY++;
/* 190 */         if (!par2World.isRemote)
/*     */         {
/* 192 */           this.oratickr++;
/* 193 */           if (this.oratickr < 42) {
/*     */             
/* 195 */             this.vintickr++;
/* 196 */             if (this.vintickr >= 10)
/*     */             {
/* 198 */               par2World.playSoundAtEntity(par3Entity, SoundEvents.claw_hit_flesh_1.toString(), 3.0F, 1.0F);
/* 199 */               if (!par2World.isRemote) {
/*     */                 
/* 201 */                 this.lastentity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)par3Entity), 2.0F);
/* 202 */                 ((EntityPlayer)par3Entity).getFoodStats().addStats(2, 2.0F);
/* 203 */                 this.lastentity.hurtResistantTime = 0;
/*     */               } 
/*     */               
/* 206 */               if (this.lastentity.getHealth() <= 0.0F) {
/*     */                 
/* 208 */                 this.oratickr = 0;
/* 209 */                 this.vintickr = 0;
/* 210 */                 if (this.lastentity instanceof net.minecraft.entity.passive.EntityVillager) {
/*     */                   
/* 212 */                   EntityVampire entityzombie = new EntityVampire(par2World);
/* 213 */                   entityzombie.copyLocationAndAnglesFrom(this.lastentity);
/* 214 */                   par2World.removeEntity(this.lastentity);
/* 215 */                   entityzombie.onSpawnWithEgg((IEntityLivingData)null);
/* 216 */                   par2World.spawnEntityInWorld(entityzombie);
/*     */                 } 
/* 218 */                 if (this.lastentity instanceof EntityPlayer) {
/*     */                   
/* 220 */                   EntityVampire entityzombie = new EntityVampire(par2World);
/* 221 */                   entityzombie.copyLocationAndAnglesFrom(this.lastentity);
/* 222 */                   par2World.removeEntity(this.lastentity);
/* 223 */                   entityzombie.onSpawnWithEgg((IEntityLivingData)null);
/* 224 */                   par2World.spawnEntityInWorld(entityzombie);
/*     */                 } 
/* 226 */                 if (this.lastentity instanceof src.jojobadv.Entities.Entityhamonuser) {
/*     */                   
/* 228 */                   EntityVampire entityzombie = new EntityVampire(par2World);
/* 229 */                   entityzombie.copyLocationAndAnglesFrom(this.lastentity);
/* 230 */                   par2World.removeEntity(this.lastentity);
/* 231 */                   entityzombie.onSpawnWithEgg((IEntityLivingData)null);
/* 232 */                   par2World.spawnEntityInWorld(entityzombie);
/*     */                 } 
/* 234 */                 par2World.playSoundAtEntity(par3Entity, SoundEvents.noroee.toString(), 2.0F, 1.0F);
/* 235 */                 this.bloodsucking = false;
/* 236 */                 this.lastentity = null;
/*     */               } 
/*     */               
/* 239 */               this.vintickr = 0;
/*     */             }
/*     */           
/* 242 */           } else if (this.oratickr >= 42) {
/*     */             
/* 244 */             this.bloodsucking = false;
/* 245 */             this.oratickr = 0;
/* 246 */             this.vintickr = 0;
/* 247 */             this.lastentity = null;
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 254 */     } else if (!par2World.isRemote) {
/*     */       
/* 256 */       this.max = 10.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void hold_entity(EntityLivingBase par1Entity, Entity player) {
/* 263 */     par1Entity.fallDistance = 0.0F;
/* 264 */     EntityLivingBase entityLivingBase = null;
/* 265 */     double d5 = par1Entity.getDistanceSq(player.posX, player.posY, player.posZ);
/* 266 */     double r = 0.0D;
/* 267 */     double closet = Math.PI * r * r * r;
/* 268 */     double max = Math.PI;
/* 269 */     if (d5 > closet) {
/*     */       
/* 271 */       entityLivingBase = par1Entity;
/* 272 */       double dx = entityLivingBase.posX - player.posX;
/* 273 */       double dy = entityLivingBase.posY - player.posY;
/* 274 */       double dz = entityLivingBase.posZ - player.posZ;
/* 275 */       float impower = 0.1F;
/* 276 */       if (dx > 0.0D)
/*     */       {
/* 278 */         entityLivingBase.motionX += -impower;
/*     */       }
/* 280 */       if (dx < 0.0D)
/*     */       {
/* 282 */         entityLivingBase.motionX += impower;
/*     */       }
/*     */       
/* 285 */       if (dy > 0.0D)
/*     */       {
/* 287 */         entityLivingBase.motionY += -impower;
/*     */       }
/* 289 */       if (dy < 0.0D)
/*     */       {
/* 291 */         entityLivingBase.motionY += impower;
/*     */       }
/*     */       
/* 294 */       if (dz > 0.0D)
/*     */       {
/* 296 */         entityLivingBase.motionZ += -impower;
/*     */       }
/* 298 */       if (dz < 0.0D)
/*     */       {
/* 300 */         entityLivingBase.motionZ += impower;
/*     */       }
/*     */     } 
/* 303 */     if (d5 > max)
/*     */     {
/* 305 */       entityLivingBase.setPosition(player.posX, player.posY, player.posZ);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 314 */   public int getItemEnchantability() { return 1; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemSkillVamprieJump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */