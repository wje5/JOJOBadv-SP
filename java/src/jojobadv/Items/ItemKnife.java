/*    */ package src.jojobadv.Items;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ import src.jojobadv.Entities.EntityKnife;
/*    */ import src.jojobadv.ModBase.JojoBAdv;
/*    */ import src.jojobadv.ModBase.SoundEvents;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemKnife
/*    */   extends Item
/*    */ {
/*    */   public ItemKnife() {
/* 17 */     this.maxStackSize = 64;
/* 18 */     setTextureName("jojobadv:item_knife");
/* 19 */     setUnlocalizedName("item_knife");
/* 20 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 28 */     if (!par3EntityPlayer.capabilities.isCreativeMode)
/*    */     {
/* 30 */       par1ItemStack.stackSize--;
/*    */     }
/* 32 */     par2World.playSoundAtEntity(par3EntityPlayer, SoundEvents.knife_stab.toString(), 0.5F, 4.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
/*    */     
/* 34 */     if (!par2World.isRemote) {
/*    */       
/* 36 */       EntityKnife entityarrow = new EntityKnife(par2World, par3EntityPlayer, 2.0F);
/* 37 */       entityarrow.setIsCritical(true);
/* 38 */       par2World.spawnEntityInWorld(entityarrow);
/*    */     } 
/*    */     
/* 41 */     return par1ItemStack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 46 */   public boolean isFull3D() { return true; }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */