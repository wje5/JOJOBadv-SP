/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import src.jojobadv.Entities.Stands.EntityKillerQueen_punch;
/*    */ import src.jojobadv.Models.ModelTheWorld_punch;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderKillerQueen_punch
/*    */   extends Render
/*    */ {
/*    */   protected ModelTheWorld_punch base;
/* 20 */   private static final ResourceLocation boomTextures = new ResourceLocation("jojobadv", "textures/stands/KQ_punch.png");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   public RenderKillerQueen_punch() { this.base = new ModelTheWorld_punch(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 30 */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) { renderEntityModel((EntityKillerQueen_punch)par1Entity, par2, par4, par6, par8, par9); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderEntityModel(EntityKillerQueen_punch par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 35 */     bindEntityTexture(par1Entity);
/* 36 */     GL11.glPushMatrix();
/* 37 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 38 */     GL11.glRotatef(par1Entity.prevRotationYaw + (par1Entity.rotationYaw - par1Entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
/* 39 */     GL11.glRotatef(par1Entity.prevRotationPitch + (par1Entity.rotationPitch - par1Entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
/* 40 */     float f10 = 0.05625F;
/* 41 */     GL11.glEnable(32826);
/* 42 */     float f11 = par1Entity.arrowShake - par9;
/* 43 */     (Minecraft.getMinecraft()).renderEngine.bindTexture(boomTextures);
/* 44 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 45 */     GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/* 46 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 47 */     this.base.render(par1Entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/* 48 */     GL11.glDisable(32826);
/* 49 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 54 */   protected ResourceLocation getArrowTextures(EntityKillerQueen_punch par1EntityArrow) { return boomTextures; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 62 */   protected ResourceLocation getEntityTexture(Entity par1Entity) { return getArrowTextures((EntityKillerQueen_punch)par1Entity); }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderKillerQueen_punch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */