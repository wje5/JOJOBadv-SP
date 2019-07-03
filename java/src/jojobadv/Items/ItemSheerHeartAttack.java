/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.Stands.EntitySheerHeartAttack_target;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemSheerHeartAttack
/*     */   extends Item
/*     */ {
/*     */   public ItemSheerHeartAttack() {
/*  18 */     this.maxStackSize = 64;
/*  19 */     setTextureName("jojobadv:item_sheerheart_attack");
/*  20 */     setUnlocalizedName("item_sheerheart_attack");
/*  21 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  29 */     if (!par2World.isRemote) {
/*     */       
/*  31 */       if (!par3EntityPlayer.capabilities.isCreativeMode)
/*     */       {
/*  33 */         par3EntityPlayer.getFoodStats().addStats(-4, 0.0F);
/*     */       }
/*  35 */       par1ItemStack.stackSize = 0;
/*  36 */       par2World.playSoundAtEntity(par3EntityPlayer, SoundEvents.sp_sha.toString(), 1.0F, 1.0F);
/*  37 */       EntitySheerHeartAttack_target entityarrow = new EntitySheerHeartAttack_target(par2World, par3EntityPlayer, 5.0F);
/*  38 */       par2World.spawnEntityInWorld(entityarrow);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  44 */   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { return par1ItemStack; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   public int getMaxItemUseDuration(ItemStack par1ItemStack) { return 72000; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  88 */     if (par3EntityPlayer.getFoodStats().getFoodLevel() > 4) {
/*     */       
/*  90 */       par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*     */     }
/*     */     else {
/*     */       
/*  94 */       par3EntityPlayer.addChatMessage(new ChatComponentText("ï¿½è°¡ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Å³ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Ï½Ç¼ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½"));
/*     */     } 
/*  96 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   public int getItemEnchantability() { return 1; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemSheerHeartAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */