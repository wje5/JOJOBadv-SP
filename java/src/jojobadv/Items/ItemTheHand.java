/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemTheHand
/*     */   extends Item
/*     */ {
/*  23 */   int tick = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemTheHand() {
/*  28 */     this.maxStackSize = 64;
/*  29 */     setTextureName("jojobadv:item_thehand_stand");
/*  30 */     setUnlocalizedName("item_thehand_stand");
/*  31 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  36 */   public EnumAction getItemUseAction(ItemStack par1ItemStack) { return EnumAction.bow; }
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
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  65 */     if (!par2World.isRemote) {
/*     */       
/*  67 */       par1ItemStack.stackSize = 1;
/*     */       
/*  69 */       if (!par3EntityPlayer.capabilities.isCreativeMode)
/*     */       {
/*  71 */         par3EntityPlayer.getFoodStats().addStats(-6, 0.0F);
/*     */       }
/*  73 */       par2World.playSoundAtEntity(par3EntityPlayer, "jojobadv:th_a", 1.0F, 1.0F);
/*  74 */       //TheHanduse(par3EntityPlayer, par2World);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void TheHanduse(EntityPlayer par3EntityPlayer, World world) {
/*  80 */     if (!world.isRemote) {
/*     */       
/*  82 */       int i = (int)par3EntityPlayer.posX - 3;
/*  83 */       int j = (int)par3EntityPlayer.posY;
/*  84 */       int k = (int)par3EntityPlayer.posZ - 3;
/*  85 */       world.setBlockToAir(i + 0, j + 0, k + 1);
/*  86 */       world.setBlockToAir(i + 0, j + 0, k + 2);
/*  87 */       world.setBlockToAir(i + 0, j + 0, k + 3);
/*  88 */       world.setBlockToAir(i + 0, j + 1, k + 2);
/*  89 */       world.setBlockToAir(i + 1, j + 0, k + 0);
/*  90 */       world.setBlockToAir(i + 1, j + 0, k + 1);
/*  91 */       world.setBlockToAir(i + 1, j + 0, k + 2);
/*  92 */       world.setBlockToAir(i + 1, j + 0, k + 3);
/*  93 */       world.setBlockToAir(i + 1, j + 0, k + 4);
/*  94 */       world.setBlockToAir(i + 1, j + 1, k + 1);
/*  95 */       world.setBlockToAir(i + 1, j + 1, k + 2);
/*  96 */       world.setBlockToAir(i + 1, j + 1, k + 3);
/*  97 */       world.setBlockToAir(i + 1, j + 2, k + 2);
/*  98 */       world.setBlockToAir(i + 2, j + 0, k + 0);
/*  99 */       world.setBlockToAir(i + 2, j + 0, k + 1);
/* 100 */       world.setBlockToAir(i + 2, j + 0, k + 2);
/* 101 */       world.setBlockToAir(i + 2, j + 0, k + 3);
/* 102 */       world.setBlockToAir(i + 2, j + 0, k + 4);
/* 103 */       world.setBlockToAir(i + 2, j + 1, k + 0);
/* 104 */       world.setBlockToAir(i + 2, j + 1, k + 1);
/* 105 */       world.setBlockToAir(i + 2, j + 1, k + 2);
/* 106 */       world.setBlockToAir(i + 2, j + 1, k + 3);
/* 107 */       world.setBlockToAir(i + 2, j + 1, k + 4);
/* 108 */       world.setBlockToAir(i + 2, j + 2, k + 1);
/* 109 */       world.setBlockToAir(i + 2, j + 2, k + 2);
/* 110 */       world.setBlockToAir(i + 2, j + 2, k + 3);
/* 111 */       world.setBlockToAir(i + 3, j + 0, k + 0);
/* 112 */       world.setBlockToAir(i + 3, j + 0, k + 1);
/* 113 */       world.setBlockToAir(i + 3, j + 0, k + 2);
/* 114 */       world.setBlockToAir(i + 3, j + 0, k + 3);
/* 115 */       world.setBlockToAir(i + 3, j + 0, k + 4);
/* 116 */       world.setBlockToAir(i + 3, j + 1, k + 1);
/* 117 */       world.setBlockToAir(i + 3, j + 1, k + 2);
/* 118 */       world.setBlockToAir(i + 3, j + 1, k + 3);
/* 119 */       world.setBlockToAir(i + 3, j + 2, k + 2);
/* 120 */       world.setBlockToAir(i + 4, j + 0, k + 1);
/* 121 */       world.setBlockToAir(i + 4, j + 0, k + 2);
/* 122 */       world.setBlockToAir(i + 4, j + 0, k + 3);
/* 123 */       world.setBlockToAir(i + 4, j + 1, k + 2);
/*     */     } 
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
/* 194 */     Entity entity = null;
/* 195 */     for (int i1 = 0; i1 < world.loadedEntityList.size(); i1++) {
/*     */       
/* 197 */       Entity entityplayer1 = (Entity)world.loadedEntityList.get(i1);
/* 198 */       double d5 = entityplayer1.getDistanceSq(par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ);
/* 199 */       double r = 1.5D;
/* 200 */       double par7 = Math.PI * r * r * r;
/* 201 */       if (d5 < par7 && entityplayer1.posY >= par3EntityPlayer.posY && entityplayer1 != par3EntityPlayer)
/*     */       {
/* 203 */         if (!(entityplayer1 instanceof EntityOneStand) || ((EntityOneStand)entityplayer1).getMaster() != par3EntityPlayer)
/*     */         {
/*     */           
/* 206 */           if (entityplayer1 instanceof EntityPlayer) {
/*     */             
/* 208 */             entity = entityplayer1;
/*     */             try {
/* 210 */               ((EntityLivingBase)entity).onDeath(DamageSource.causeMobDamage(par3EntityPlayer));
/* 211 */               ((EntityLivingBase)entity).setHealth(0.0F);
/*     */             }
/* 213 */             catch (ClassCastException classCastException) {}
/*     */           
/*     */           }
/*     */           else {
/*     */ 
/*     */             
/* 219 */             entity = entityplayer1;
/* 220 */             entity.setDead();
/*     */           }  } 
/*     */       }
/* 223 */       if (d5 >= par7 && entityplayer1 != par3EntityPlayer) {
/*     */         
/* 225 */         entity = entityplayer1;
/* 226 */         double dx = entity.posX - par3EntityPlayer.posX;
/* 227 */         double dy = entity.posY - par3EntityPlayer.posY;
/* 228 */         double dz = entity.posZ - par3EntityPlayer.posZ;
/* 229 */         float impower = 0.5F;
/* 230 */         if (dx > 0.0D)
/*     */         {
/* 232 */           entity.motionX += -impower;
/*     */         }
/* 234 */         if (dx < 0.0D)
/*     */         {
/* 236 */           entity.motionX += impower;
/*     */         }
/*     */         
/* 239 */         if (dy > 0.0D)
/*     */         {
/* 241 */           entity.motionY += -impower;
/*     */         }
/* 243 */         if (dy < 0.0D)
/*     */         {
/* 245 */           entity.motionY += impower;
/*     */         }
/*     */         
/* 248 */         if (dz > 0.0D)
/*     */         {
/* 250 */           entity.motionZ += -impower;
/*     */         }
/* 252 */         if (dz < 0.0D)
/*     */         {
/* 254 */           entity.motionZ += impower;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 262 */   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { return par1ItemStack; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 268 */   public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 276 */   public int getMaxItemUseDuration(ItemStack par1ItemStack) { return 72000; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count) {
/* 281 */     this.tick++;
/* 282 */     if (this.tick < 100) {
/*     */       
/* 284 */       double pp = 0.8D;
/* 285 */       player.worldObj.spawnParticle("explode", player.posX - 5.0D, player.posY, player.posZ, pp, 0.0D, 0.0D);
/* 286 */       player.worldObj.spawnParticle("explode", player.posX + 5.0D, player.posY, player.posZ, -pp, 0.0D, 0.0D);
/* 287 */       player.worldObj.spawnParticle("explode", player.posX, player.posY, player.posZ - 5.0D, 0.0D, 0.0D, pp);
/* 288 */       player.worldObj.spawnParticle("explode", player.posX, player.posY, player.posZ + 5.0D, 0.0D, 0.0D, -pp);
/* 289 */       player.worldObj.spawnParticle("explode", player.posX, player.posY - 5.0D, player.posZ, 0.0D, pp, 0.0D);
/* 290 */       player.worldObj.spawnParticle("explode", player.posX, player.posY + 5.0D, player.posZ, 0.0D, -pp, 0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 299 */     Entity entity = null;
/* 300 */     for (int i1 = 0; i1 < par3EntityPlayer.worldObj.loadedEntityList.size(); i1++) {
/*     */       
/* 302 */       Entity entityplayer1 = (Entity)par3EntityPlayer.worldObj.loadedEntityList.get(i1);
/* 303 */       double dst = entityplayer1.getDistanceSq(par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ);
/* 304 */       entity = entityplayer1;
/* 305 */       if (entity instanceof src.jojobadv.Entities.Stands.EntityTheHand && dst <= 15.0D)
/*     */       {
/* 307 */         if (par3EntityPlayer.getFoodStats().getFoodLevel() > 6) {
/*     */           
/* 309 */           par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*     */         }
/*     */         else {
/*     */           
/* 313 */           par3EntityPlayer.addChatMessage(new ChatComponentText("ï¿½è°¡ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Å³ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Ï½Ç¼ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½"));
/*     */         } 
/*     */       }
/*     */     } 
/* 317 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 325 */   public int getItemEnchantability() { return 1; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemTheHand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */