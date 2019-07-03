/*    */ package src.jojobadv.ModBase;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ import src.jojobadv.Items.JojoBAdvItems;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonProxy
/*    */ {
/*    */   public void registerRenderInformation() {}
/*    */   
/*    */   public void registerTiles() {}
/*    */   
/*    */   public void registerBlocks() {}
/*    */   
/*    */   public void registerRecipes() {
/* 26 */     GameRegistry.addShapedRecipe(new ItemStack(JojoBAdvItems.HardArrow), new Object[] { "M", "D", "D", Character.valueOf('M'), Blocks.obsidian, Character.valueOf('D'), Items.iron_ingot });
/* 27 */     GameRegistry.addShapedRecipe(new ItemStack(JojoBAdvItems.StandArrow), new Object[] { "M", "D", Character.valueOf('M'), JojoBAdvItems.Bloodofvampire, Character.valueOf('D'), JojoBAdvItems.HardArrow });
/* 28 */     GameRegistry.addRecipe(new ItemStack(JojoBAdvItems.StoneMask), new Object[] { "SSS", "SMS", "SSS", Character.valueOf('M'), JojoBAdvItems.Bloodofvampire, Character.valueOf('S'), Blocks.cobblestone });
/* 29 */     GameRegistry.addShapedRecipe(new ItemStack(JojoBAdvItems.knife, 3), new Object[] { "OD", "MO", Character.valueOf('M'), Items.wooden_sword, Character.valueOf('D'), Items.iron_ingot });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 34 */   public void spawnParticle(World world, String string, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) { world.spawnParticle(string, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed); }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/CommonProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */