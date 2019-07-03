/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import src.jojobadv.Entities.Stands.EntityMagicians_Red_fire;
/*    */ import src.jojobadv.Models.ModelMagicians_Red_fire;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderMagicians_Red_fire
/*    */   extends Render
/*    */ {
/*    */   protected ModelMagicians_Red_fire base;
/* 20 */   private static final ResourceLocation boomTextures = new ResourceLocation("jojobadv", "textures/stands/MR_fire.png");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   public RenderMagicians_Red_fire() { this.base = new ModelMagicians_Red_fire(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 30 */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) { renderEntityModel((EntityMagicians_Red_fire)par1Entity, par2, par4, par6, par8, par9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderEntityModel(EntityMagicians_Red_fire par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 36 */     bindEntityTexture(par1Entity);
/* 37 */     GL11.glPushMatrix();
/* 38 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 39 */     GL11.glRotatef(par1Entity.prevRotationYaw + (par1Entity.rotationYaw - par1Entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
/* 40 */     GL11.glRotatef(par1Entity.prevRotationPitch + (par1Entity.rotationPitch - par1Entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
/* 41 */     float f10 = 0.05625F;
/* 42 */     GL11.glEnable(32826);
/* 43 */     float f11 = par1Entity.arrowShake - par9;
/* 44 */     (Minecraft.getMinecraft()).renderEngine.bindTexture(boomTextures);
/* 45 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 46 */     GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/* 47 */     GL11.glScalef(1.5F, 1.5F, 1.5F);
/* 48 */     GL11.glTranslatef(0.0F, -0.3F, 0.0F);
/* 49 */     this.base.render(par1Entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/* 50 */     GL11.glDisable(32826);
/* 51 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 56 */   protected ResourceLocation getArrowTextures(EntityMagicians_Red_fire par1EntityArrow) { return boomTextures; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 64 */   protected ResourceLocation getEntityTexture(Entity par1Entity) { return getArrowTextures((EntityMagicians_Red_fire)par1Entity); }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderMagicians_Red_fire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */