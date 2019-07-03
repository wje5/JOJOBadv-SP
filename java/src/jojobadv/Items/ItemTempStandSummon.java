/*    */ package src.jojobadv.Items;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*    */ import src.jojobadv.ModBase.JojoBAdv;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemTempStandSummon
/*    */   extends Item
/*    */ {
/*    */   public ItemTempStandSummon() {
/* 19 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/* 20 */     setUnlocalizedName("item_tempStandSummon");
/* 21 */     setTextureName("jojobadv:disc");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
/* 27 */     super.addInformation(stack, player, list, bool);
/* 28 */     list.add("Debug Item, gives 50exp on use, or ");
/* 29 */     list.add("when used against Iron block, deletes");
/* 30 */     list.add(" stand without death.");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int intpar7, float fx, float fy, float fz) {
/* 35 */     if (!world.isRemote) {
/*    */       
/* 37 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 38 */       if (world.getBlock(x, y, z) == Blocks.iron_block) {
/*    */         
/* 40 */         props.setStandRemoved();
/* 41 */         return true;
/*    */       } 
/*    */ 
/*    */       
/* 45 */       props.setPlayerStandExp(props.getPlayerStandExp() + 50);
/*    */     } 
/*    */     
/* 48 */     return false;
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemTempStandSummon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */