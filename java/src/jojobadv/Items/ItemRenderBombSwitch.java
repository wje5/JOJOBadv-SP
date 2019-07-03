/*    */ package src.jojobadv.Items;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemRenderBombSwitch
/*    */   implements IItemRenderer
/*    */ {
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
    		   return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 29 */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) { return false; }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*    */ 
/*    */       
/* 38 */         GL11.glTranslatef(0.5F, 0.5F, 0.0F);
/* 39 */         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 40 */         GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
/* 41 */         GL11.glScalef(1.5F, 1.5F, 1.5F);
/* 42 */         GL11.glPushMatrix();
/* 43 */         GL11.glPopMatrix();
/*    */     
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemRenderBombSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */