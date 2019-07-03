/*    */ package src.jojobadv.Models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class ModelStoneMask
/*    */   extends ModelBiped
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   ModelRenderer Shape2;
/*    */   
/*    */   public ModelStoneMask() {
/* 15 */     this.textureWidth = 64;
/* 16 */     this.textureHeight = 32;
/*    */     
/* 18 */     this.Shape1 = new ModelRenderer(this, 0, 22);
/* 19 */     this.Shape1.addBox(-4.0F, -8.0F, -5.0F, 8, 8, 2);
/* 20 */     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 21 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 22 */     this.Shape2 = new ModelRenderer(this, 20, 22);
/* 23 */     this.Shape2.addBox(-4.0F, -8.0F, -6.0F, 3, 3, 1);
/* 24 */     this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 25 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 30 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 31 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 32 */     this.Shape1.render(f5);
/* 33 */     this.Shape2.render(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 38 */     model.rotateAngleX = x;
/* 39 */     model.rotateAngleY = y;
/* 40 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
/* 45 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
/* 46 */     this.Shape1.rotateAngleY = this.bipedHead.rotateAngleY;
/* 47 */     this.Shape1.rotateAngleX = this.bipedHead.rotateAngleX;
/* 48 */     this.Shape2.rotateAngleY = this.bipedHead.rotateAngleY;
/* 49 */     this.Shape2.rotateAngleX = this.bipedHead.rotateAngleX;
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelStoneMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */