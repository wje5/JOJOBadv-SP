/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.Stands.EntityBomb;
/*     */ import src.jojobadv.Entities.Stands.EntityInBomb;
/*     */ import src.jojobadv.Entities.Stands.EntityOutBomb;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemBombswitch
/*     */   extends Item
/*     */ {
/*     */   private EntityPlayer player;
/*  25 */   private int bomb = 0;
/*     */   
/*  27 */   private int bombid = 1;
/*  28 */   private EntityBomb[] bomblist = new EntityBomb[11];
/*  29 */   private int swingtick = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemBombswitch() {
/*  34 */     this.maxStackSize = 99;
/*  35 */     setTextureName("jojobadv:item_bombswitch");
/*  36 */     setUnlocalizedName("item_bombswitch");
/*  37 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  45 */     int spawn = 0;
/*  46 */     spawn++;
/*  47 */     if (!par2World.isRemote && this.bomb > 0 && this.bomblist[this.bombid] != null) {
/*     */       
/*  49 */       this.bomblist[this.bombid].selfex();
/*  50 */       this.bomblist[this.bombid] = null;
/*  51 */       this.bombid++;
/*  52 */       this.bomb--;
/*  53 */       this.player.addChatMessage(new ChatComponentText("ï¿½ï¿½Ä¡ï¿½ï¿½ ï¿½ï¿½Åº : " + Integer.toString(this.bomb)));
/*     */     }
/*  55 */     else if (this.bomblist[this.bombid] == null) {
/*     */       
/*  57 */       this.bombid = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
/*  62 */     if (this.bomb < 0)
/*     */     {
/*  64 */       this.bomb = 0;
/*     */     }
/*  66 */     if (this.bombid > 10)
/*     */     {
/*  68 */       this.bombid = 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  73 */   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { return par1ItemStack; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public int getMaxItemUseDuration(ItemStack par1ItemStack) { return 72000; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public EnumAction getItemUseAction(ItemStack par1ItemStack) { return EnumAction.bow; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 103 */     par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/* 104 */     return par1ItemStack;
/*     */   }
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
/*     */   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
/* 210 */     entity.hurtResistantTime = 10;
/* 211 */     if (this.bomb < 0)
/*     */     {
/* 213 */       this.bomb = 0;
/*     */     }
/* 215 */     if (this.bomb < 10 && player.getFoodStats().getFoodLevel() > 1) {
/*     */       
/* 217 */       if (player.swingProgressInt != 0) {
/*     */         
/* 219 */         if (!entity.worldObj.isRemote) {
/*     */           
/* 221 */           this.swingtick++;
/* 222 */           if (this.swingtick == 1)
/*     */           {
/* 224 */             if (Math.abs(player.motionY) >= 0.3D)
/*     */             {
/* 226 */               if (!player.capabilities.isCreativeMode)
/*     */               {
/* 228 */                 player.getFoodStats().addStats(-1, 0.0F);
/*     */               }
/* 230 */               EntityInBomb entitypigzombie = new EntityInBomb(player.worldObj);
/* 231 */               entitypigzombie.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, 0.0F, 0.0F);
/* 232 */               player.worldObj.spawnEntityInWorld(entitypigzombie);
/* 233 */               entitypigzombie.setOwner(entity);
/* 234 */               EntityInBomb.player = player;
/* 235 */               this.bomb++;
/* 236 */               player.addChatMessage(new ChatComponentText("ï¿½ï¿½Ä¡ï¿½ï¿½ ï¿½ï¿½Åº : " + Integer.toString(this.bomb)));
/*     */               
/* 238 */               this.bomblist[this.bomb] = entitypigzombie;
/*     */             }
/*     */             else
/*     */             {
/* 242 */               if (!player.capabilities.isCreativeMode)
/*     */               {
/* 244 */                 player.getFoodStats().addStats(-1, 0.0F);
/*     */               }
/* 246 */               EntityOutBomb entitypigzombie = new EntityOutBomb(player.worldObj);
/* 247 */               entitypigzombie.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, 0.0F, 0.0F);
/* 248 */               player.worldObj.spawnEntityInWorld(entitypigzombie);
/* 249 */               entitypigzombie.setOwner(entity);
/* 250 */               this.bomb++;
/* 251 */               player.addChatMessage(new ChatComponentText("ï¿½ï¿½Ä¡ï¿½ï¿½ ï¿½ï¿½Åº : " + Integer.toString(this.bomb)));
/*     */               
/* 253 */               this.bomblist[this.bomb] = entitypigzombie;
/*     */             }
/*     */           
/*     */           }
/*     */         } 
/* 258 */       } else if (player.swingProgressInt == 0) {
/*     */         
/* 260 */         this.swingtick = 0;
/*     */       }
/*     */     
/* 263 */     } else if (player.getFoodStats().getFoodLevel() < 1) {
/*     */       
/* 265 */       player.addChatMessage(new ChatComponentText("ï¿½è°¡ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Å³ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Ï½Ç¼ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½"));
/*     */     }
/*     */     else {
/*     */       
/* 269 */       for (int i = 0; i <= 10; i++) {
/*     */         
/* 271 */         if (this.bomblist[i] != null) {
/*     */           
/* 273 */           this.bomblist[i].selfex();
/* 274 */           this.bomblist[i] = null;
/* 275 */           this.bomb = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/* 279 */     return false;
/*     */   }
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
/*     */   public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
/* 378 */     if (entityLiving instanceof EntityPlayer) {
/*     */       
/* 380 */       this.player = (EntityPlayer)entityLiving;
/* 381 */       if (this.bomb < 0)
/*     */       {
/* 383 */         this.bomb = 0;
/*     */       }
/* 385 */       if (this.bomb < 10 && this.player.getFoodStats().getFoodLevel() > 1) {
/*     */         
/* 387 */         if (this.player.swingProgressInt != 0)
/*     */         {
/* 389 */           if (!entityLiving.worldObj.isRemote)
/*     */           {
/* 391 */             this.swingtick++;
/* 392 */             if (this.swingtick == 1) {
/*     */               
/*     */               try {
/* 395 */                 if (Math.abs(this.player.motionY) >= 0.3D)
/*     */                 {
/* 397 */                   if (!this.player.capabilities.isCreativeMode)
/*     */                   {
/* 399 */                     this.player.getFoodStats().addStats(-1, 0.0F);
/*     */                   }
/* 401 */                   EntityInBomb entitypigzombie = new EntityInBomb(entityLiving.worldObj);
/* 402 */                   entitypigzombie.setLocationAndAngles((Minecraft.getMinecraft()).objectMouseOver.blockX, (Minecraft.getMinecraft()).objectMouseOver.blockY, (Minecraft.getMinecraft()).objectMouseOver.blockZ, 0.0F, 0.0F);
/* 403 */                   entityLiving.worldObj.spawnEntityInWorld(entitypigzombie);
/* 404 */                   EntityInBomb.player = this.player;
/* 405 */                   this.bomb++;
/* 406 */                   this.player.addChatMessage(new ChatComponentText("ï¿½ï¿½Ä¡ï¿½ï¿½ ï¿½ï¿½Åº : " + Integer.toString(this.bomb)));
/*     */                   
/* 408 */                   this.bomblist[this.bomb] = entitypigzombie;
/*     */                 
/*     */                 }
/*     */                 else
/*     */                 {
/*     */                   
/* 414 */                   if (!this.player.capabilities.isCreativeMode)
/*     */                   {
/* 416 */                     this.player.getFoodStats().addStats(-1, 0.0F);
/*     */                   }
/* 418 */                   EntityOutBomb entitypigzombie = new EntityOutBomb(entityLiving.worldObj);
/* 419 */                   entitypigzombie.setLocationAndAngles((Minecraft.getMinecraft()).objectMouseOver.blockX, (Minecraft.getMinecraft()).objectMouseOver.blockY, (Minecraft.getMinecraft()).objectMouseOver.blockZ, 0.0F, 0.0F);
/* 420 */                   entityLiving.worldObj.spawnEntityInWorld(entitypigzombie);
/* 421 */                   this.bomb++;
/* 422 */                   this.player.addChatMessage(new ChatComponentText("ï¿½ï¿½Ä¡ï¿½ï¿½ ï¿½ï¿½Åº : " + Integer.toString(this.bomb)));
/*     */                   
/* 424 */                   this.bomblist[this.bomb] = entitypigzombie;
/*     */                 }
/*     */               
/* 427 */               } catch (NullPointerException nullPointerException) {}
/*     */             
/*     */             }
/*     */           }
/*     */         
/*     */         }
/* 433 */         else if (this.player.swingProgressInt == 0)
/*     */         {
/* 435 */           this.swingtick = 0;
/*     */         }
/*     */       
/* 438 */       } else if (this.player.getFoodStats().getFoodLevel() < 1) {
/*     */         
/* 440 */         this.player.addChatMessage(new ChatComponentText("ï¿½è°¡ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Å³ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Ï½Ç¼ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½"));
/*     */       }
/*     */       else {
/*     */         
/* 444 */         for (int i = 0; i <= 10; i++) {
/*     */           
/* 446 */           if (this.bomblist[i] != null) {
/*     */             
/* 448 */             this.bomblist[i].selfex();
/* 449 */             this.bomblist[i] = null;
/* 450 */             this.bomb = 0;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 455 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 463 */   public int getItemEnchantability() { return 1; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemBombswitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */