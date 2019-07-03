/*     */ package src.jojobadv.Renders;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import src.jojobadv.Entities.EntityKnife;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderKnife
/*     */   extends Render
/*     */ {
/*  19 */   private static final ResourceLocation arrowTextures = new ResourceLocation("jojobadv", "textures/items/knifeT.png");
/*     */ 
/*     */   
/*     */   public void renderArrow(EntityKnife par1EntityKnife, double par2, double par4, double par6, float par8, float par9) {
/*  23 */     bindEntityTexture(par1EntityKnife);
/*  24 */     GL11.glPushMatrix();
/*  25 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  26 */     GL11.glRotatef(par1EntityKnife.prevRotationYaw + (par1EntityKnife.rotationYaw - par1EntityKnife.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
/*  27 */     GL11.glRotatef(par1EntityKnife.prevRotationPitch + (par1EntityKnife.rotationPitch - par1EntityKnife.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
/*  28 */     Tessellator tessellator = Tessellator.instance;
/*  29 */     byte b0 = 0;
/*  30 */     float f2 = 0.0F;
/*  31 */     float f3 = 0.5F;
/*  32 */     float f4 = (0 + b0 * 10) / 32.0F;
/*  33 */     float f5 = (5 + b0 * 10) / 32.0F;
/*  34 */     float f6 = 0.0F;
/*  35 */     float f7 = 0.15625F;
/*  36 */     float f8 = (5 + b0 * 10) / 32.0F;
/*  37 */     float f9 = (10 + b0 * 10) / 32.0F;
/*  38 */     float f10 = 0.05625F;
/*  39 */     GL11.glEnable(32826);
/*  40 */     float f11 = par1EntityKnife.arrowShake - par9;
/*     */     
/*  42 */     if (f11 > 0.0F) {
/*     */       
/*  44 */       float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
/*  45 */       GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
/*     */     } 
/*     */     
/*  48 */     GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
/*  49 */     GL11.glScalef(f10, f10, f10);
/*  50 */     GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
/*  51 */     GL11.glNormal3f(f10, 0.0F, 0.0F);
/*  52 */     tessellator.startDrawingQuads();
/*  53 */     tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, f6, f8);
/*  54 */     tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, f7, f8);
/*  55 */     tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, f7, f9);
/*  56 */     tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, f6, f9);
/*  57 */     tessellator.draw();
/*  58 */     GL11.glNormal3f(-f10, 0.0F, 0.0F);
/*  59 */     tessellator.startDrawingQuads();
/*  60 */     tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, f6, f8);
/*  61 */     tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, f7, f8);
/*  62 */     tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, f7, f9);
/*  63 */     tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, f6, f9);
/*  64 */     tessellator.draw();
/*     */     
/*  66 */     for (int i = 0; i < 4; i++) {
/*     */       
/*  68 */       GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*  69 */       GL11.glNormal3f(0.0F, 0.0F, f10);
/*  70 */       tessellator.startDrawingQuads();
/*  71 */       tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, f2, f4);
/*  72 */       tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, f3, f4);
/*  73 */       tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, f3, f5);
/*  74 */       tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, f2, f5);
/*  75 */       tessellator.draw();
/*     */     } 
/*     */     
/*  78 */     GL11.glDisable(32826);
/*  79 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  84 */   protected ResourceLocation getArrowTextures(EntityKnife par1EntityKnife) { return arrowTextures; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   protected ResourceLocation getEntityTexture(Entity par1Entity) { return getArrowTextures((EntityKnife)par1Entity); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) { renderArrow((EntityKnife)par1Entity, par2, par4, par6, par8, par9); }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/RenderKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */