/*    */ package src.jojobadv.Models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class ModelTheWorld_punch
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   
/*    */   public ModelTheWorld_punch() {
/* 14 */     this.textureWidth = 64;
/* 15 */     this.textureHeight = 32;
/*    */     
/* 17 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 18 */     this.Shape1.addBox(-1.0F, -1.0F, 0.0F, 3, 3, 7);
/* 19 */     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 20 */     this.Shape1.setTextureSize(64, 32);
/* 21 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 26 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 27 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 28 */     this.Shape1.render(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 33 */     model.rotateAngleX = x;
/* 34 */     model.rotateAngleY = y;
/* 35 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 40 */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) { super.setRotationAngles(f, f1, f2, f3, f4, f5, e); }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelTheWorld_punch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */