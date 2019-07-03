/*    */ package src.jojobadv.Renders;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.renderer.entity.RenderBiped;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import src.jojobadv.Entities.Entityhamonuser;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Renderhamonuser
/*    */   extends RenderBiped
/*    */ {
/* 16 */   public Renderhamonuser(ModelBiped par1ModelBiped, float par2) { super(par1ModelBiped, par2); }
/*    */   
/* 18 */   public static ResourceLocation texture = new ResourceLocation("jojobadv", "textures/mobs/Hamonuser.png");
/* 19 */   public static ResourceLocation texture1 = new ResourceLocation("jojobadv", "textures/mobs/Hamonuser2.png");
/*    */ 
/*    */ 
/*    */   
/* 23 */   public void renderhamonuser(Entityhamonuser var1, double var2, double var4, double var6, float var8, float var9) { doRender(var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 28 */   public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) { renderhamonuser((Entityhamonuser)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   public void dohamonuser(Entity var1, double var2, double var4, double var6, float var8, float var9) { renderhamonuser((Entityhamonuser)var1, var2, var4, var6, var8, var9); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   protected ResourceLocation getEntityTexture(Entityhamonuser hamon) { return (hamon.getIntAge() >= 6000) ? texture1 : texture; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 44 */   protected ResourceLocation getEntityTexture(Entity entity) { return getEntityTexture((Entityhamonuser)entity); }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Renders/Renderhamonuser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */