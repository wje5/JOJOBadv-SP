/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.Stands.EntityEmperor_bullet;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemEmperor
/*     */   extends Item
/*     */ {
/*     */   public ItemEmperor() {
/*  23 */     setTextureName("jojobadv:item_emperor_stand");
/*  24 */     setUnlocalizedName("item_emperor_stand");
/*  25 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*  26 */     this.maxStackSize = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  34 */     par1ItemStack.stackSize = 1;
/*  35 */     int spawn = 0;
/*  36 */     spawn++;
/*  37 */     if (!par2World.isRemote) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  42 */       EntityEmperor_bullet entityarrow = new EntityEmperor_bullet(par2World, par3EntityPlayer, 2.0F);
/*  43 */       par2World.playSoundAtEntity(par3EntityPlayer, SoundEvents.gunshot.toString(), 3.0F, 1.0F);
/*  44 */       entityarrow.setIsCritical(true);
/*  45 */       par2World.spawnEntityInWorld(entityarrow);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  50 */   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { return par1ItemStack; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   public int getMaxItemUseDuration(ItemStack par1ItemStack) { return 72000; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   public EnumAction getItemUseAction(ItemStack par1ItemStack) { return EnumAction.bow; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  90 */     par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*  91 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public int getItemEnchantability() { return 1; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
/* 105 */     if (entity instanceof EntityPlayer)
/*     */     {
/* 107 */       if (!world.isRemote) {
/*     */         
/* 109 */         EntityPlayer player = (EntityPlayer)entity;
/* 110 */         ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 111 */         if (!player.capabilities.isCreativeMode)
/*     */         {
/* 113 */           if (player.getCurrentEquippedItem() == stack)
/*     */           {
/* 115 */             if (props.getPlayerStandID() == 0 || !props.getStandOn()) {
/*     */               
/* 117 */               player.destroyCurrentEquippedItem();
/*     */               return;
/*     */             } 
/*     */           }
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemEmperor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */