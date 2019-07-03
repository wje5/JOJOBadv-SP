/*    */ package src.jojobadv.ModBase;
/*    */ 
/*    */ import cpw.mods.fml.client.registry.ClientRegistry;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JojoBAdvKeyHandler
/*    */ {
/* 19 */   private static final String[] desc = { "spawnStand" };
/* 20 */   private static final int[] keyValues = { 47 };
/* 21 */   public static final KeyBinding[] keys = new KeyBinding[desc.length];
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int STANDSPAWN = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   public static void addKeys() {
/* 30 */     for (int i = 0; i < desc.length; i++) {
/*    */       
/* 32 */       String descStr = "key." + desc[i] + ".desc";
/* 33 */       keys[i] = new KeyBinding(descStr, keyValues[i], "key.categories.JojosBAdv");
/* 34 */       ClientRegistry.registerKeyBinding(keys[i]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/JojoBAdvKeyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */