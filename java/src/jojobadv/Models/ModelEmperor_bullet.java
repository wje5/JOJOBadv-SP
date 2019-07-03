/*    */ package src.jojobadv.Models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class ModelEmperor_bullet
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   
/*    */   public ModelEmperor_bullet() {
/* 14 */     this.textureWidth = 64;
/* 15 */     this.textureHeight = 32;
/*    */     
/* 17 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 18 */     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
/* 19 */     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 20 */     this.Shape1.setTextureSize(64, 32);
/* 21 */     this.Shape1.mirror = true;
/* 22 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 27 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 28 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 29 */     this.Shape1.render(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 34 */     model.rotateAngleX = x;
/* 35 */     model.rotateAngleY = y;
/* 36 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 41 */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) { super.setRotationAngles(f, f1, f2, f3, f4, f5, e); }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelEmperor_bullet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */