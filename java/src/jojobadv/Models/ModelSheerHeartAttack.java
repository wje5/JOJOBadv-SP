/*    */ package src.jojobadv.Models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class ModelSheerHeartAttack
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   ModelRenderer Shape2;
/*    */   ModelRenderer Shape3;
/*    */   ModelRenderer Shape4;
/*    */   ModelRenderer Shape5;
/*    */   
/*    */   public ModelSheerHeartAttack() {
/* 18 */     this.textureWidth = 64;
/* 19 */     this.textureHeight = 32;
/*    */     
/* 21 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 22 */     this.Shape1.addBox(-2.0F, 0.0F, -3.0F, 4, 4, 4);
/* 23 */     this.Shape1.setRotationPoint(0.0F, 19.5F, 0.0F);
/* 24 */     this.Shape1.setTextureSize(64, 32);
/* 25 */     this.Shape1.mirror = true;
/* 26 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 27 */     this.Shape2 = new ModelRenderer(this, 0, 8);
/* 28 */     this.Shape2.addBox(0.0F, 0.0F, -2.0F, 1, 2, 4);
/* 29 */     this.Shape2.setRotationPoint(-3.0F, 22.0F, -1.0F);
/* 30 */     this.Shape2.setTextureSize(64, 32);
/* 31 */     this.Shape2.mirror = true;
/* 32 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 33 */     this.Shape3 = new ModelRenderer(this, 0, 8);
/* 34 */     this.Shape3.addBox(0.0F, 0.0F, -2.0F, 1, 2, 4);
/* 35 */     this.Shape3.setRotationPoint(2.0F, 22.0F, -1.0F);
/* 36 */     this.Shape3.setTextureSize(64, 32);
/* 37 */     this.Shape3.mirror = true;
/* 38 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/* 39 */     this.Shape4 = new ModelRenderer(this, 16, 0);
/* 40 */     this.Shape4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
/* 41 */     this.Shape4.setRotationPoint(-1.0F, 19.0F, -2.0F);
/* 42 */     this.Shape4.setTextureSize(64, 32);
/* 43 */     this.Shape4.mirror = true;
/* 44 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 45 */     this.Shape5 = new ModelRenderer(this, 10, 8);
/* 46 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
/* 47 */     this.Shape5.setRotationPoint(-1.0F, 20.0F, -4.0F);
/* 48 */     this.Shape5.setTextureSize(64, 32);
/* 49 */     this.Shape5.mirror = true;
/* 50 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 55 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 56 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 57 */     this.Shape1.render(f5);
/* 58 */     this.Shape2.render(f5);
/* 59 */     this.Shape3.render(f5);
/* 60 */     this.Shape4.render(f5);
/* 61 */     this.Shape5.render(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 66 */     model.rotateAngleX = x;
/* 67 */     model.rotateAngleY = y;
/* 68 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 73 */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity E) { super.setRotationAngles(f, f1, f2, f3, f4, f5, E); }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelSheerHeartAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */