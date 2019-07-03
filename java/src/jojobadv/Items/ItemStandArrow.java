/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.ArrowNockEvent;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.Entities.Stands.EntityCrazyDiamond;
/*     */ import src.jojobadv.Entities.Stands.EntityEchoesEgg;
/*     */ import src.jojobadv.Entities.Stands.EntityEmperor;
/*     */ import src.jojobadv.Entities.Stands.EntityKillerQueen;
/*     */ import src.jojobadv.Entities.Stands.EntityMagicians_Red;
/*     */ import src.jojobadv.Entities.Stands.EntitySilver_Chariot;
/*     */ import src.jojobadv.Entities.Stands.EntityStarplatinum;
/*     */ import src.jojobadv.Entities.Stands.EntityStickyFingers;
/*     */ import src.jojobadv.Entities.Stands.EntityTheHand;
/*     */ import src.jojobadv.Entities.Stands.EntityTheWorld;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.JojoBAdvLib;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemStandArrow
/*     */   extends Item
/*     */ {
/*     */   private boolean getpower = false;
/*  32 */   private int standPower = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStandArrow(int par1, String par2) {
/*  37 */     this.maxStackSize = 1;
/*  38 */     this.hasSubtypes = true;
/*  39 */     this.standPower = par1;
/*  40 */     setTextureName("jojobadv:arrow_stand");
/*  41 */     setUnlocalizedName(par2);
/*  42 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  50 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(par3EntityPlayer);
/*     */     
/*  52 */     this.getpower = true;
/*  53 */     if (props != null)
/*     */     {
/*  55 */       if (props.getPlayerStandID() != 0)
/*     */       {
/*  57 */         this.getpower = false;
/*     */       }
/*     */     }
/*     */     
/*  61 */     if (!par3EntityPlayer.worldObj.isRemote)
/*     */     {
/*  63 */       if (this.getpower) {
/*     */         
/*  65 */         if (!par2World.isRemote) {
/*     */           
/*  67 */           int randomstand = 0;
/*  68 */           if (this.standPower == 0) {
/*     */             
/*  70 */             while (randomstand == 0)
/*     */             {
/*  72 */               randomstand = itemRand.nextInt(11);
/*     */             }
/*     */           }
/*     */           else {
/*     */             
/*  77 */             randomstand = this.standPower;
/*     */           } 
/*     */           
/*  80 */           if (randomstand != 0) {
/*     */             
/*  82 */             props.setPlayerStandID(randomstand);
/*  83 */             props.setStandOn(true);
/*  84 */             EntityOneStand theStand = getStand(randomstand, par2World);
/*  85 */             if (theStand != null) {
/*     */               
/*  87 */               theStand.setLocationAndAngles(par3EntityPlayer.posX + 0.1D, par3EntityPlayer.posY, par3EntityPlayer.posZ, par3EntityPlayer.rotationYaw, par3EntityPlayer.rotationPitch);
/*  88 */               theStand.setMaster(par3EntityPlayer.getCommandSenderName());
/*  89 */               theStand.setMastername(par3EntityPlayer.getDisplayName());
/*  90 */               par2World.spawnEntityInWorld(theStand);
/*  91 */               theStand.bespawn();
/*     */               
/*  93 */               if (randomstand == 5) {
/*     */                 
/*  95 */                 ItemStack heldStack = par3EntityPlayer.getHeldItem();
/*  96 */                 if (heldStack != null) {
/*     */                   
/*  98 */                   par3EntityPlayer.entityDropItem(heldStack, 0.5F);
/*  99 */                   par3EntityPlayer.destroyCurrentEquippedItem();
/*     */                 } 
/* 101 */                 par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(JojoBAdvItems.Emperor, 1));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 106 */         ItemStack heldStack2 = par3EntityPlayer.getHeldItem();
/* 107 */         if (heldStack2 != null && heldStack2.getItem() == this && !par3EntityPlayer.capabilities.isCreativeMode)
/*     */         {
/* 109 */           par3EntityPlayer.destroyCurrentEquippedItem();
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 114 */         par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.jojobadv.standalready.txt", new Object[0]));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { return par1ItemStack; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   public int getMaxItemUseDuration(ItemStack par1ItemStack) { return 72000; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public EnumAction getItemUseAction(ItemStack par1ItemStack) { return EnumAction.bow; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 147 */     ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
/* 148 */     if (!JojoBAdvLib.getEnderCore()) {
/*     */       
/* 150 */       MinecraftForge.EVENT_BUS.post(event);
/*     */       
/* 152 */       if (event.isCanceled())
/*     */       {
/* 154 */         return event.result;
/*     */       }
/*     */     } 
/* 157 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(par3EntityPlayer);
/* 158 */     if (par1ItemStack != null) {
/*     */       
/* 160 */       if (props.getPlayerStandID() == 0) {
/*     */         
/* 162 */         par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/* 163 */         return par1ItemStack;
/*     */       } 
/*     */ 
/*     */       
/* 167 */       par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.jojobadv.standalready.txt", new Object[0]));
/*     */     } 
/*     */ 
/*     */     
/* 171 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 180 */   public int getItemEnchantability() { return 1; }
/*     */ 
/*     */ 
/*     */   
/*     */   public static EntityOneStand getStand(int standID, World world) {
/* 185 */     switch (standID) {
/*     */       case 0:
/* 187 */         return null;
/* 188 */       case 1: return new EntitySilver_Chariot(world);
/* 189 */       case 2: return new EntityMagicians_Red(world);
/* 190 */       case 3: return new EntityStarplatinum(world);
/* 191 */       case 4: return new EntityTheWorld(world);
/* 192 */       case 5: return new EntityEmperor(world);
/* 193 */       case 6: return new EntityCrazyDiamond(world);
/* 194 */       case 7: return new EntityEchoesEgg(world);
/* 195 */       case 8: return new EntityKillerQueen(world);
/* 196 */       case 9: return new EntityTheHand(world);
/* 197 */       case 10: return new EntityStickyFingers(world);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 202 */     return null;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemStandArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */