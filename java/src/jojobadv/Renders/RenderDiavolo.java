/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.renderer.entity.RenderBiped;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import src.jojobadv.Entities.EntityDiavolo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderDiavolo
/*    */   extends RenderBiped
/*    */ {
/* 16 */   public RenderDiavolo(ModelBiped par1ModelBiped, float par2) { super(par1ModelBiped, par2); }
/*    */   
/* 18 */   ResourceLocation texture = new ResourceLocation("jojobadv", "textures/mobs/diavolo.png");
/*    */ 
/*    */ 
/*    */   
/* 22 */   public void rendertestmob(EntityDiavolo var1, double var2, double var4, double var6, float var8, float var9) { doRender(var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) { rendertestmob((EntityDiavolo)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 32 */   public void dotestmob(Entity var1, double var2, double var4, double var6, float var8, float var9) { rendertestmob((EntityDiavolo)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */   
/* 36 */   protected ResourceLocation getEntityTexture(Entity entity) { return this.texture; }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderDiavolo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */