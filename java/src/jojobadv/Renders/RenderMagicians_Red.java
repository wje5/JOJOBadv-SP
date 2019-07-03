/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import src.jojobadv.Entities.EntityOneStand;
/*    */ import src.jojobadv.Entities.Stands.EntityMagicians_Red;
/*    */ import src.jojobadv.Models.ModelMagicians_Red;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderMagicians_Red
/*    */   extends RenderLiving
/*    */ {
/* 19 */   public RenderMagicians_Red(ModelMagicians_Red modelStarplatinum, float shadow) { super(modelStarplatinum, shadow); }
/*    */ 
/*    */ 
/*    */   
/* 23 */   public void renderStarplatinum(EntityOneStand var1, double var2, double var4, double var6, float var8, float var9) { doRender(var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 28 */   public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) { renderStarplatinum((EntityMagicians_Red)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   public void doStarplatinum(Entity var1, double var2, double var4, double var6, float var8, float var9) { renderStarplatinum((EntityMagicians_Red)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 39 */   protected ResourceLocation getEntityTexture(Entity entity) { return texture; }
/*    */ 
/*    */   
/* 42 */   public static ResourceLocation texture = new ResourceLocation("jojobadv", "textures/stands/MR.png");
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderMagicians_Red.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */