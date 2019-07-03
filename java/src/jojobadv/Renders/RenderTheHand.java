/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import src.jojobadv.Entities.EntityOneStand;
/*    */ import src.jojobadv.Entities.Stands.EntityTheHand;
/*    */ import src.jojobadv.Models.ModelTheHand;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderTheHand
/*    */   extends RenderLiving
/*    */ {
/* 21 */   public RenderTheHand(ModelTheHand modelTheHand, float shadow) { super(modelTheHand, shadow); }
/*    */ 
/*    */ 
/*    */   
/* 25 */   public void renderTheHand(EntityOneStand var1, double var2, double var4, double var6, float var8, float var9) { doRender(var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 30 */   public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) { renderTheHand((EntityTheHand)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   public void doTheHand(Entity var1, double var2, double var4, double var6, float var8, float var9) { renderTheHand((EntityTheHand)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */   
/* 39 */   protected ResourceLocation getEntityTexture(Entity entity) { return texture; }
/*    */   
/* 41 */   public static ResourceLocation texture = new ResourceLocation("jojobadv", "textures/stands/TH.png");
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderTheHand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */