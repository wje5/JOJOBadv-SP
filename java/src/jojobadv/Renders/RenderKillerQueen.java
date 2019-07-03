/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import src.jojobadv.Entities.EntityOneStand;
/*    */ import src.jojobadv.Entities.Stands.EntityKillerQueen;
/*    */ import src.jojobadv.Models.ModelKillerQueen;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderKillerQueen
/*    */   extends RenderLiving
/*    */ {
/* 19 */   public RenderKillerQueen(ModelKillerQueen modelKillerQueen, float shadow) { super(modelKillerQueen, shadow); }
/*    */ 
/*    */ 
/*    */   
/* 23 */   public void renderKillerQueen(EntityOneStand var1, double var2, double var4, double var6, float var8, float var9) { doRender(var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 28 */   public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) { renderKillerQueen((EntityKillerQueen)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   public void doKillerQueen(Entity var1, double var2, double var4, double var6, float var8, float var9) { renderKillerQueen((EntityKillerQueen)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */   
/* 37 */   protected ResourceLocation getEntityTexture(Entity entity) { return texture; }
/*    */   
/* 39 */   public static ResourceLocation texture = new ResourceLocation("jojobadv", "textures/stands/KQ.png");
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderKillerQueen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */