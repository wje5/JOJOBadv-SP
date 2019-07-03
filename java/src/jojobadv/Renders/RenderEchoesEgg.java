/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import src.jojobadv.Entities.EntityOneStand;
/*    */ import src.jojobadv.Entities.Stands.EntityEchoesEgg;
/*    */ import src.jojobadv.Models.ModelEchoesEgg;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderEchoesEgg
/*    */   extends RenderLiving
/*    */ {
/*    */   public static float scale;
/*    */   
/*    */   public RenderEchoesEgg(ModelEchoesEgg modelEchoesEgg, float shadow) {
/* 24 */     super(modelEchoesEgg, shadow);
/* 25 */     scale = 0.7F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 30 */   protected void preRenderScale(EntityLivingBase entity, float par2) { GL11.glScalef(scale, scale, scale); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   protected void preRenderCallback(EntityLivingBase entityliving, float f) { preRenderScale(entityliving, f); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 40 */   public void renderEchoesEgg(EntityOneStand var1, double var2, double var4, double var6, float var8, float var9) { doRender(var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) { renderEchoesEgg((EntityEchoesEgg)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 50 */   public void doEchoesEgg(Entity var1, double var2, double var4, double var6, float var8, float var9) { renderEchoesEgg((EntityEchoesEgg)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 56 */   protected ResourceLocation getEntityTexture(Entity entity) { return texture; }
/*    */ 
/*    */   
/* 59 */   public static ResourceLocation texture = new ResourceLocation("jojobadv", "textures/stands/E_e.png");
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderEchoesEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */