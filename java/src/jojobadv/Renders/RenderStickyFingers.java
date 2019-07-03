/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import src.jojobadv.Entities.EntityOneStand;
/*    */ import src.jojobadv.Entities.Stands.EntityStickyFingers;
/*    */ import src.jojobadv.Models.ModelStickyFingers;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderStickyFingers
/*    */   extends RenderLiving
/*    */ {
/* 19 */   public RenderStickyFingers(ModelStickyFingers modelStickyFingers, float shadow) { super(modelStickyFingers, shadow); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 24 */   public void renderStickyFingers(EntityOneStand var1, double var2, double var4, double var6, float var8, float var9) { doRender(var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 29 */   public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) { renderStickyFingers((EntityStickyFingers)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public void doStickyFingers(Entity var1, double var2, double var4, double var6, float var8, float var9) { renderStickyFingers((EntityStickyFingers)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 40 */   protected ResourceLocation getEntityTexture(Entity entity) { return texture; }
/*    */ 
/*    */   
/* 43 */   public static ResourceLocation texture = new ResourceLocation("jojobadv", "textures/stands/SF.png");
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderStickyFingers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */