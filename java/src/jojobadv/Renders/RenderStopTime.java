/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import src.jojobadv.Entities.Stands.EntityTheWorld_StopTime;
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
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderStopTime
/*    */   extends Render
/*    */ {
/*    */   protected ModelBase base;
/*    */   
/* 27 */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) { renderEntityModel((EntityTheWorld_StopTime)par1Entity, par2, par4, par6, par8, par9); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderEntityModel(EntityTheWorld_StopTime par1Entity, double par2, double par4, double par6, float par8, float par9) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 41 */   protected ResourceLocation getEntityTexture(Entity par1Entity) { return new ResourceLocation("jojobadv", ""); }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderStopTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */