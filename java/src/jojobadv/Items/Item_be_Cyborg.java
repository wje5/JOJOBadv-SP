/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.ArrowNockEvent;
/*     */ import src.jojobadv.Entities.Stands.EntityTheWorld;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Item_be_Cyborg
/*     */   extends Item
/*     */ {
/*     */   private boolean getpower = false;
/*     */   
/*     */   public Item_be_Cyborg() {
/*  23 */     this.maxStackSize = 1;
/*  24 */     setTextureName("jojobadv:item_beCyborg");
/*  25 */     setUnlocalizedName("item_beCyborg");
/*  26 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  34 */     Entity entity = null;
/*  35 */     this.getpower = true;
/*  36 */     for (int i1 = 0; i1 < par3EntityPlayer.worldObj.loadedEntityList.size(); i1++) {
/*     */       
/*  38 */       Entity entityplayer1 = (Entity)par3EntityPlayer.worldObj.loadedEntityList.get(i1);
/*  39 */       double dst = entityplayer1.getDistanceSq(par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ);
/*  40 */       double offdst = entityplayer1.getDistanceSq(par3EntityPlayer.posX, -5.0D, par3EntityPlayer.posZ);
/*  41 */       double d2 = 25.132741228718345D;
/*  42 */       entity = entityplayer1;
/*  43 */       if ((entity instanceof src.jojobadv.Entities.EntityOneStand && dst <= 10.0D) || offdst <= 10.0D)
/*     */       {
/*  45 */         if (!par3EntityPlayer.worldObj.isRemote)
/*     */         {
/*  47 */           this.getpower = false;
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/*  52 */     if (this.getpower) {
/*     */       
/*  54 */       if (!par2World.isRemote)
/*     */       {
/*     */         
/*  57 */         EntityTheWorld entitypigzombie = new EntityTheWorld(par2World);
/*  58 */         entitypigzombie.setLocationAndAngles(par3EntityPlayer.posX + 0.1D, par3EntityPlayer.posY, par3EntityPlayer.posZ, par3EntityPlayer.rotationYaw, par3EntityPlayer.rotationPitch);
/*  59 */         par2World.spawnEntityInWorld(entitypigzombie);
/*  60 */         entitypigzombie.setMaster(par3EntityPlayer.getCommandSenderName());
/*  61 */         entitypigzombie.setMastername(par3EntityPlayer.getDisplayName());
/*  62 */         entitypigzombie.bespawn();
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  67 */       par3EntityPlayer.addChatMessage(new ChatComponentText("You already have a stand"));
/*  68 */       par3EntityPlayer.addChatMessage(new ChatComponentText("or you close stand"));
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
/*     */ 
/*     */   
/*  81 */   public int getMaxItemUseDuration(ItemStack par1ItemStack) { return 72000; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   public EnumAction getItemUseAction(ItemStack par1ItemStack) { return EnumAction.bow; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  97 */     ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
/*  98 */     MinecraftForge.EVENT_BUS.post(event);
/*  99 */     if (event.isCanceled())
/*     */     {
/* 101 */       return event.result;
/*     */     }
/* 103 */     par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*     */ 
/*     */     
/* 106 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public int getItemEnchantability() { return 1; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/Item_be_Cyborg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */