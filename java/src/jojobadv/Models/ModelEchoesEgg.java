/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class ModelEchoesEgg
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer BASE;
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape9;
/*     */   ModelRenderer Shape10;
/*     */   
/*     */   public ModelEchoesEgg() {
/*  24 */     this.textureWidth = 256;
/*  25 */     this.textureHeight = 128;
/*     */     
/*  27 */     this.BASE = new ModelRenderer(this, "BASE");
/*  28 */     this.BASE.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  29 */     setRotation(this.BASE, 0.0F, 0.0F, 0.0F);
/*  30 */     this.Shape1 = new ModelRenderer(this, 0, 95);
/*  31 */     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 20, 4, 20);
/*  32 */     this.Shape1.setRotationPoint(-10.0F, 9.0F, -10.0F);
/*  33 */     this.Shape1.setTextureSize(64, 32);
/*  34 */     this.Shape1.mirror = true;
/*  35 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  36 */     this.Shape2 = new ModelRenderer(this, 62, 0);
/*  37 */     this.Shape2.addBox(0.0F, 0.0F, 0.0F, 22, 5, 22);
/*  38 */     this.Shape2.setRotationPoint(-11.0F, 13.0F, -11.0F);
/*  39 */     this.Shape2.setTextureSize(64, 32);
/*  40 */     this.Shape2.mirror = true;
/*  41 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*  42 */     this.Shape3 = new ModelRenderer(this, 73, 32);
/*  43 */     this.Shape3.addBox(0.0F, 0.0F, 0.0F, 20, 3, 20);
/*  44 */     this.Shape3.setRotationPoint(-10.0F, 18.0F, -10.0F);
/*  45 */     this.Shape3.setTextureSize(64, 32);
/*  46 */     this.Shape3.mirror = true;
/*  47 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  48 */     this.Shape4 = new ModelRenderer(this, 77, 59);
/*  49 */     this.Shape4.addBox(0.0F, 0.0F, 0.0F, 18, 2, 18);
/*  50 */     this.Shape4.setRotationPoint(-9.0F, 21.0F, -9.0F);
/*  51 */     this.Shape4.setTextureSize(64, 32);
/*  52 */     this.Shape4.mirror = true;
/*  53 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/*  54 */     this.Shape5 = new ModelRenderer(this, 89, 82);
/*  55 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14);
/*  56 */     this.Shape5.setRotationPoint(-7.0F, 23.0F, -7.0F);
/*  57 */     this.Shape5.setTextureSize(64, 32);
/*  58 */     this.Shape5.mirror = true;
/*  59 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/*  60 */     this.Shape6 = new ModelRenderer(this, 0, 71);
/*  61 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 18, 3, 18);
/*  62 */     this.Shape6.setRotationPoint(-9.0F, 6.0F, -9.0F);
/*  63 */     this.Shape6.setTextureSize(64, 32);
/*  64 */     this.Shape6.mirror = true;
/*  65 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/*  66 */     this.Shape7 = new ModelRenderer(this, 0, 50);
/*  67 */     this.Shape7.addBox(0.0F, 0.0F, 0.0F, 16, 3, 16);
/*  68 */     this.Shape7.setRotationPoint(-8.0F, 3.0F, -8.0F);
/*  69 */     this.Shape7.setTextureSize(64, 32);
/*  70 */     this.Shape7.mirror = true;
/*  71 */     setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
/*  72 */     this.Shape8 = new ModelRenderer(this, 0, 31);
/*  73 */     this.Shape8.addBox(0.0F, 0.0F, 0.0F, 14, 2, 14);
/*  74 */     this.Shape8.setRotationPoint(-7.0F, 1.0F, -7.0F);
/*  75 */     this.Shape8.setTextureSize(64, 32);
/*  76 */     this.Shape8.mirror = true;
/*  77 */     setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
/*  78 */     this.Shape9 = new ModelRenderer(this, 0, 14);
/*  79 */     this.Shape9.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12);
/*  80 */     this.Shape9.setRotationPoint(-6.0F, -1.0F, -6.0F);
/*  81 */     this.Shape9.setTextureSize(64, 32);
/*  82 */     this.Shape9.mirror = true;
/*  83 */     setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
/*  84 */     this.Shape10 = new ModelRenderer(this, 0, 0);
/*  85 */     this.Shape10.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
/*  86 */     this.Shape10.setRotationPoint(-5.0F, -2.0F, -5.0F);
/*  87 */     this.Shape10.setTextureSize(64, 32);
/*  88 */     this.Shape10.mirror = true;
/*  89 */     setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
/*  90 */     this.BASE.addChild(this.Shape1);
/*  91 */     this.BASE.addChild(this.Shape2);
/*  92 */     this.BASE.addChild(this.Shape3);
/*  93 */     this.BASE.addChild(this.Shape4);
/*  94 */     this.BASE.addChild(this.Shape5);
/*  95 */     this.BASE.addChild(this.Shape6);
/*  96 */     this.BASE.addChild(this.Shape7);
/*  97 */     this.BASE.addChild(this.Shape8);
/*  98 */     this.BASE.addChild(this.Shape9);
/*  99 */     this.BASE.addChild(this.Shape10);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 104 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 105 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 106 */     this.BASE.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 111 */     model.rotateAngleX = x;
/* 112 */     model.rotateAngleY = y;
/* 113 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 118 */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) { super.setRotationAngles(f, f1, f2, f3, f4, f5, e); }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelEchoesEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */