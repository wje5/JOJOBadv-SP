/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class ModelCrazyDiamond
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape18;
/*     */   ModelRenderer Shape12;
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer hat;
/*     */   
/*     */   public ModelCrazyDiamond() {
/*  31 */     this.textureWidth = 128;
/*  32 */     this.textureHeight = 64;
/*     */     
/*  34 */     this.Shape6 = new ModelRenderer(this, 56, 16);
/*  35 */     this.Shape6.addBox(-1.0F, 0.0F, -1.0F, 3, 7, 3);
/*  36 */     this.Shape6.setRotationPoint(8.0F, 2.0F, -1.0F);
/*  37 */     this.Shape6.setTextureSize(128, 64);
/*  38 */     this.Shape6.mirror = true;
/*  39 */     setRotation(this.Shape6, -0.4089647F, 0.0371786F, 0.1972532F);
/*  40 */     this.Shape7 = new ModelRenderer(this, 56, 26);
/*  41 */     this.Shape7.addBox(-2.0F, 0.0F, 0.0F, 3, 7, 3);
/*  42 */     this.Shape7.setRotationPoint(-5.0F, 14.0F, 1.0F);
/*  43 */     this.Shape7.setTextureSize(128, 64);
/*  44 */     setRotation(this.Shape7, 0.5205006F, 0.0743572F, -0.0371786F);
/*  45 */     this.Shape8 = new ModelRenderer(this, 56, 26);
/*  46 */     this.Shape8.addBox(0.0F, 0.0F, -1.0F, 3, 7, 3);
/*  47 */     this.Shape8.setRotationPoint(4.0F, 13.0F, 2.0F);
/*  48 */     this.Shape8.setTextureSize(128, 64);
/*  49 */     this.Shape8.mirror = true;
/*  50 */     setRotation(this.Shape8, 0.5205006F, -0.1115358F, 0.0F);
/*  51 */     this.Shape18 = new ModelRenderer(this, 0, 54);
/*  52 */     this.Shape18.addBox(-4.5F, 9.0F, -2.0F, 9, 2, 5);
/*  53 */     this.Shape18.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  54 */     this.Shape18.setTextureSize(128, 64);
/*  55 */     setRotation(this.Shape18, 0.0F, 0.0F, 0.0F);
/*  56 */     this.Shape12 = new ModelRenderer(this, 68, 16);
/*  57 */     this.Shape12.addBox(-3.0F, -2.0F, 2.0F, 6, 7, 3);
/*  58 */     this.Shape12.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  59 */     this.Shape12.setTextureSize(128, 64);
/*  60 */     setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
/*  61 */     this.head = new ModelRenderer(this, 0, 4);
/*  62 */     this.head.addBox(-3.0F, -6.0F, -4.0F, 6, 6, 6);
/*  63 */     this.head.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  64 */     this.head.setTextureSize(128, 64);
/*  65 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  66 */     this.body = new ModelRenderer(this, 16, 16);
/*  67 */     this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 11, 4);
/*  68 */     this.body.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  69 */     this.body.setTextureSize(128, 64);
/*  70 */     setRotation(this.body, 0.0872665F, 0.0F, 0.0F);
/*  71 */     this.rightarm = new ModelRenderer(this, 40, 16);
/*  72 */     this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 8, 4);
/*  73 */     this.rightarm.setRotationPoint(-5.0F, -2.0F, 0.0F);
/*  74 */     this.rightarm.setTextureSize(128, 64);
/*  75 */     this.rightarm.mirror = true;
/*  76 */     setRotation(this.rightarm, -0.5948578F, 1.320977F, -0.0970775F);
/*  77 */     this.leftarm = new ModelRenderer(this, 40, 16);
/*  78 */     this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 8, 4);
/*  79 */     this.leftarm.setRotationPoint(5.0F, -2.0F, 0.0F);
/*  80 */     this.leftarm.setTextureSize(128, 64);
/*  81 */     setRotation(this.leftarm, -0.5934119F, -1.308997F, 0.0872665F);
/*  82 */     this.rightleg = new ModelRenderer(this, 0, 16);
/*  83 */     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/*  84 */     this.rightleg.setRotationPoint(-3.0F, 9.0F, 0.0F);
/*  85 */     this.rightleg.setTextureSize(128, 64);
/*  86 */     setRotation(this.rightleg, 0.2974289F, -0.0371786F, 0.2602503F);
/*  87 */     this.leftleg = new ModelRenderer(this, 0, 16);
/*  88 */     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/*  89 */     this.leftleg.setRotationPoint(3.0F, 9.0F, 0.0F);
/*  90 */     this.leftleg.setTextureSize(128, 64);
/*  91 */     this.leftleg.mirror = true;
/*  92 */     setRotation(this.leftleg, 0.2974289F, -0.0371786F, -0.4089647F);
/*  93 */     this.Shape1 = new ModelRenderer(this, 0, 31);
/*  94 */     this.Shape1.addBox(1.0F, -1.0F, -3.0F, 6, 5, 6);
/*  95 */     this.Shape1.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  96 */     this.Shape1.setTextureSize(128, 64);
/*  97 */     this.Shape1.mirror = true;
/*  98 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  99 */     this.Shape2 = new ModelRenderer(this, 0, 31);
/* 100 */     this.Shape2.addBox(-7.0F, -1.0F, -3.0F, 6, 5, 6);
/* 101 */     this.Shape2.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 102 */     this.Shape2.setTextureSize(128, 64);
/* 103 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 104 */     this.Shape3 = new ModelRenderer(this, 0, 42);
/* 105 */     this.Shape3.addBox(-4.0F, 1.0F, -3.0F, 8, 6, 6);
/* 106 */     this.Shape3.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 107 */     this.Shape3.setTextureSize(128, 64);
/* 108 */     setRotation(this.Shape3, 0.1745329F, 0.0F, 0.0F);
/* 109 */     this.Shape4 = new ModelRenderer(this, 24, 31);
/* 110 */     this.Shape4.addBox(-3.0F, 11.0F, -2.0F, 6, 2, 4);
/* 111 */     this.Shape4.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 112 */     this.Shape4.setTextureSize(128, 64);
/* 113 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 114 */     this.Shape5 = new ModelRenderer(this, 56, 16);
/* 115 */     this.Shape5.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3);
/* 116 */     this.Shape5.setRotationPoint(-7.0F, 3.0F, 0.0F);
/* 117 */     this.Shape5.setTextureSize(128, 64);
/* 118 */     setRotation(this.Shape5, -0.2602503F, 0.2230717F, -0.3346075F);
/* 119 */     this.neck = new ModelRenderer(this, 44, 41);
/* 120 */     this.neck.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 3);
/* 121 */     this.neck.setRotationPoint(0.0F, -5.0F, 0.0F);
/* 122 */     this.neck.setTextureSize(128, 64);
/* 123 */     setRotation(this.neck, 0.0F, 0.0F, 0.0F);
/* 124 */     this.hat = new ModelRenderer(this, 24, 0);
/* 125 */     this.hat.addBox(-4.0F, -7.0F, -5.0F, 8, 7, 8);
/* 126 */     this.hat.setRotationPoint(0.0F, -5.0F, 0.0F);
/* 127 */     this.hat.setTextureSize(128, 64);
/* 128 */     setRotation(this.hat, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 133 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 134 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 135 */     this.Shape6.render(f5);
/* 136 */     this.Shape7.render(f5);
/* 137 */     this.Shape8.render(f5);
/* 138 */     this.Shape18.render(f5);
/* 139 */     this.Shape12.render(f5);
/* 140 */     this.head.render(f5);
/* 141 */     this.body.render(f5);
/* 142 */     this.rightarm.render(f5);
/* 143 */     this.leftarm.render(f5);
/* 144 */     this.rightleg.render(f5);
/* 145 */     this.leftleg.render(f5);
/* 146 */     this.Shape1.render(f5);
/* 147 */     this.Shape2.render(f5);
/* 148 */     this.Shape3.render(f5);
/* 149 */     this.Shape4.render(f5);
/* 150 */     this.Shape5.render(f5);
/* 151 */     this.neck.render(f5);
/* 152 */     this.hat.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 157 */     model.rotateAngleX = x;
/* 158 */     model.rotateAngleY = y;
/* 159 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
/* 164 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
/* 165 */     this.head.rotateAngleY = f3 / 57.295776F;
/* 166 */     this.head.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 168 */     this.hat.rotateAngleY = f3 / 57.295776F;
/* 169 */     this.hat.rotateAngleX = f4 / 57.295776F;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelCrazyDiamond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */