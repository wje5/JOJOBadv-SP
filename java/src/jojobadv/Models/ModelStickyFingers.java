/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class ModelStickyFingers
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Shape9;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape10;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer hat;
/*     */   ModelRenderer Shape5;
/*     */   
/*     */   public ModelStickyFingers() {
/*  28 */     this.textureWidth = 128;
/*  29 */     this.textureHeight = 128;
/*     */     
/*  31 */     this.Shape9 = new ModelRenderer(this, 46, 74);
/*  32 */     this.Shape9.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/*  33 */     this.Shape9.setRotationPoint(0.0F, -1.0F, -5.0F);
/*  34 */     this.Shape9.setTextureSize(128, 128);
/*  35 */     this.Shape9.mirror = true;
/*  36 */     setRotation(this.Shape9, -0.6320364F, 0.0F, 0.0F);
/*  37 */     this.Shape8 = new ModelRenderer(this, 0, 69);
/*  38 */     this.Shape8.addBox(-1.0F, 1.0F, 0.0F, 2, 7, 1);
/*  39 */     this.Shape8.setRotationPoint(0.0F, 8.0F, -8.0F);
/*  40 */     this.Shape8.setTextureSize(128, 128);
/*  41 */     this.Shape8.mirror = true;
/*  42 */     setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
/*  43 */     this.Shape1 = new ModelRenderer(this, 18, 28);
/*  44 */     this.Shape1.addBox(-3.5F, -3.466667F, -1.0F, 7, 7, 4);
/*  45 */     this.Shape1.setRotationPoint(0.0F, 6.0F, -5.0F);
/*  46 */     this.Shape1.setTextureSize(128, 128);
/*  47 */     this.Shape1.mirror = true;
/*  48 */     setRotation(this.Shape1, -0.0523599F, 0.0F, 0.0F);
/*  49 */     this.Shape2 = new ModelRenderer(this, 36, 79);
/*  50 */     this.Shape2.addBox(-4.5F, -1.0F, -3.0F, 9, 4, 6);
/*  51 */     this.Shape2.setRotationPoint(0.0F, 9.0F, -4.0F);
/*  52 */     this.Shape2.setTextureSize(128, 128);
/*  53 */     this.Shape2.mirror = true;
/*  54 */     setRotation(this.Shape2, 0.2094395F, 0.0F, 0.0F);
/*  55 */     this.Shape4 = new ModelRenderer(this, 36, 91);
/*  56 */     this.Shape4.addBox(-10.0F, 0.0F, 0.0F, 20, 5, 6);
/*  57 */     this.Shape4.setRotationPoint(0.0F, -2.0F, -4.0F);
/*  58 */     this.Shape4.setTextureSize(128, 128);
/*  59 */     this.Shape4.mirror = true;
/*  60 */     setRotation(this.Shape4, 0.1919862F, 0.0F, 0.0F);
/*  61 */     this.body = new ModelRenderer(this, 16, 16);
/*  62 */     this.body.addBox(-5.5F, 0.0F, -3.0F, 11, 6, 5);
/*  63 */     this.body.setRotationPoint(0.0F, -0.5F, -1.0F);
/*  64 */     this.body.setTextureSize(128, 128);
/*  65 */     this.body.mirror = true;
/*  66 */     setRotation(this.body, -0.4770567F, 0.0F, 0.0F);
/*  67 */     this.rightarm = new ModelRenderer(this, 67, 73);
/*  68 */     this.rightarm.addBox(-3.0F, 1.0F, -2.0F, 4, 12, 4);
/*  69 */     this.rightarm.setRotationPoint(-6.0F, 0.0F, 0.0F);
/*  70 */     this.rightarm.setTextureSize(128, 128);
/*  71 */     this.rightarm.mirror = true;
/*  72 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.3141593F);
/*  73 */     this.leftarm = new ModelRenderer(this, 67, 73);
/*  74 */     this.leftarm.addBox(0.0F, 1.0F, -3.0F, 4, 12, 4);
/*  75 */     this.leftarm.setRotationPoint(5.0F, 0.0F, 0.0F);
/*  76 */     this.leftarm.setTextureSize(128, 128);
/*  77 */     this.leftarm.mirror = true;
/*  78 */     setRotation(this.leftarm, 0.0F, 0.0F, -0.3141593F);
/*  79 */     this.rightleg = new ModelRenderer(this, 53, 103);
/*  80 */     this.rightleg.addBox(-2.5F, 0.0F, -2.0F, 4, 9, 4);
/*  81 */     this.rightleg.setRotationPoint(-2.0F, 10.0F, -3.0F);
/*  82 */     this.rightleg.setTextureSize(128, 128);
/*  83 */     this.rightleg.mirror = true;
/*  84 */     setRotation(this.rightleg, 0.1396263F, 0.0F, 0.0F);
/*  85 */     this.leftleg = new ModelRenderer(this, 53, 103);
/*  86 */     this.leftleg.addBox(-1.5F, 0.0F, -2.0F, 4, 9, 4);
/*  87 */     this.leftleg.setRotationPoint(2.0F, 10.0F, -3.0F);
/*  88 */     this.leftleg.setTextureSize(128, 128);
/*  89 */     this.leftleg.mirror = true;
/*  90 */     setRotation(this.leftleg, -0.1570796F, 0.0F, 0.0F);
/*  91 */     this.Shape3 = new ModelRenderer(this, 36, 103);
/*  92 */     this.Shape3.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
/*  93 */     this.Shape3.setRotationPoint(-3.0F, 18.0F, -2.0F);
/*  94 */     this.Shape3.setTextureSize(128, 128);
/*  95 */     this.Shape3.mirror = true;
/*  96 */     setRotation(this.Shape3, 0.2792527F, 0.0F, 0.0F);
/*  97 */     this.Shape10 = new ModelRenderer(this, 36, 103);
/*  98 */     this.Shape10.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
/*  99 */     this.Shape10.setRotationPoint(3.0F, 18.0F, -5.0F);
/* 100 */     this.Shape10.setTextureSize(128, 128);
/* 101 */     this.Shape10.mirror = true;
/* 102 */     setRotation(this.Shape10, 0.5759587F, 0.0F, 0.0F);
/* 103 */     this.Shape6 = new ModelRenderer(this, 0, 62);
/* 104 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 2, 6, 1);
/* 105 */     this.Shape6.setRotationPoint(-1.0F, -2.0F, -4.0F);
/* 106 */     this.Shape6.setTextureSize(128, 128);
/* 107 */     this.Shape6.mirror = true;
/* 108 */     setRotation(this.Shape6, -0.7634008F, 0.0F, 0.0F);
/* 109 */     this.hat = new ModelRenderer(this, 48, 0);
/* 110 */     this.hat.addBox(-5.0F, -12.0F, -5.0F, 10, 8, 10);
/* 111 */     this.hat.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 112 */     this.hat.setTextureSize(128, 128);
/* 113 */     this.hat.mirror = true;
/* 114 */     setRotation(this.hat, 0.2617994F, 0.0F, 0.0F);
/* 115 */     this.Shape5 = new ModelRenderer(this, 0, 0);
/* 116 */     this.Shape5.addBox(-4.0F, -11.0F, -4.0F, 8, 8, 8);
/* 117 */     this.Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 118 */     this.Shape5.setTextureSize(128, 128);
/* 119 */     this.Shape5.mirror = true;
/* 120 */     setRotation(this.Shape5, 0.2617994F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 125 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 126 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 127 */     this.Shape9.render(f5);
/* 128 */     this.Shape8.render(f5);
/* 129 */     this.Shape1.render(f5);
/* 130 */     this.Shape2.render(f5);
/* 131 */     this.Shape4.render(f5);
/* 132 */     this.body.render(f5);
/* 133 */     this.rightarm.render(f5);
/* 134 */     this.leftarm.render(f5);
/* 135 */     this.rightleg.render(f5);
/* 136 */     this.leftleg.render(f5);
/* 137 */     this.Shape3.render(f5);
/* 138 */     this.Shape10.render(f5);
/* 139 */     this.Shape6.render(f5);
/* 140 */     this.hat.render(f5);
/* 141 */     this.Shape5.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 146 */     model.rotateAngleX = x;
/* 147 */     model.rotateAngleY = y;
/* 148 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
/* 153 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
/*     */     
/* 155 */     this.Shape5.rotateAngleY = f3 / 57.295776F;
/* 156 */     this.Shape5.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 158 */     this.hat.rotateAngleY = f3 / 57.295776F;
/* 159 */     this.hat.rotateAngleX = f4 / 57.295776F;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelStickyFingers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */