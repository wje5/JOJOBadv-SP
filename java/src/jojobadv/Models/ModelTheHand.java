/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class ModelTheHand
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Shape10;
/*     */   ModelRenderer head;
/*     */   ModelRenderer Shape9;
/*     */   ModelRenderer body;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer Shape13;
/*     */   ModelRenderer Shape14;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer Shape12;
/*     */   ModelRenderer Shape15;
/*     */   
/*     */   public ModelTheHand() {
/*  35 */     this.textureWidth = 128;
/*  36 */     this.textureHeight = 64;
/*     */     
/*  38 */     this.Shape10 = new ModelRenderer(this, 66, 0);
/*  39 */     this.Shape10.addBox(3.0F, -2.0F, -4.0F, 4, 6, 7);
/*  40 */     this.Shape10.setRotationPoint(1.0F, -3.0F, 0.5F);
/*  41 */     this.Shape10.setTextureSize(128, 64);
/*  42 */     setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
/*  43 */     this.head = new ModelRenderer(this, 0, 4);
/*  44 */     this.head.addBox(-3.0F, -6.0F, -3.0F, 5, 6, 5);
/*  45 */     this.head.setRotationPoint(0.5F, -5.0F, 0.0F);
/*  46 */     this.head.setTextureSize(128, 64);
/*  47 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  48 */     this.Shape9 = new ModelRenderer(this, 66, 0);
/*  49 */     this.Shape9.addBox(-5.0F, -2.0F, -4.0F, 4, 6, 7);
/*  50 */     this.Shape9.setRotationPoint(-3.0F, -3.0F, 0.5F);
/*  51 */     this.Shape9.setTextureSize(128, 64);
/*  52 */     setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
/*  53 */     this.body = new ModelRenderer(this, 16, 16);
/*  54 */     this.body.addBox(-4.0F, 0.0F, -2.0F, 6, 11, 4);
/*  55 */     this.body.setRotationPoint(1.0F, -3.0F, 0.0F);
/*  56 */     this.body.setTextureSize(128, 64);
/*  57 */     setRotation(this.body, 0.0872665F, 0.0F, 0.0F);
/*  58 */     this.Shape8 = new ModelRenderer(this, 56, 26);
/*  59 */     this.Shape8.addBox(0.0F, 0.0F, -1.0F, 3, 7, 3);
/*  60 */     this.Shape8.setRotationPoint(4.0F, 13.0F, 2.0F);
/*  61 */     this.Shape8.setTextureSize(128, 64);
/*  62 */     setRotation(this.Shape8, 0.5205006F, -0.1115358F, 0.0F);
/*  63 */     this.rightarm = new ModelRenderer(this, 40, 16);
/*  64 */     this.rightarm.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
/*  65 */     this.rightarm.setRotationPoint(-5.0F, -3.0F, 0.0F);
/*  66 */     this.rightarm.setTextureSize(128, 64);
/*  67 */     setRotation(this.rightarm, -0.3346075F, 1.570796F, 0.0F);
/*  68 */     this.Shape7 = new ModelRenderer(this, 56, 26);
/*  69 */     this.Shape7.addBox(-2.0F, 0.0F, 0.0F, 3, 7, 3);
/*  70 */     this.Shape7.setRotationPoint(-5.0F, 14.0F, 1.0F);
/*  71 */     this.Shape7.setTextureSize(128, 64);
/*  72 */     setRotation(this.Shape7, 0.5205006F, 0.0743572F, -0.0371786F);
/*  73 */     this.leftarm = new ModelRenderer(this, 40, 16);
/*  74 */     this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 8, 4);
/*  75 */     this.leftarm.setRotationPoint(5.0F, -2.0F, 0.0F);
/*  76 */     this.leftarm.setTextureSize(128, 64);
/*  77 */     setRotation(this.leftarm, -0.5934119F, -1.308997F, 0.0872665F);
/*  78 */     this.Shape6 = new ModelRenderer(this, 56, 16);
/*  79 */     this.Shape6.addBox(-1.0F, 0.0F, -1.0F, 3, 7, 3);
/*  80 */     this.Shape6.setRotationPoint(8.0F, 2.0F, -1.0F);
/*  81 */     this.Shape6.setTextureSize(128, 64);
/*  82 */     setRotation(this.Shape6, -0.4089647F, 0.0371786F, 0.1972532F);
/*  83 */     this.rightleg = new ModelRenderer(this, 0, 16);
/*  84 */     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/*  85 */     this.rightleg.setRotationPoint(-3.0F, 9.0F, 0.0F);
/*  86 */     this.rightleg.setTextureSize(128, 64);
/*  87 */     setRotation(this.rightleg, 0.2974289F, -0.0371786F, 0.2602503F);
/*  88 */     this.leftleg = new ModelRenderer(this, 0, 16);
/*  89 */     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/*  90 */     this.leftleg.setRotationPoint(3.0F, 9.0F, 0.0F);
/*  91 */     this.leftleg.setTextureSize(128, 64);
/*  92 */     setRotation(this.leftleg, 0.2974289F, -0.0371786F, -0.4089647F);
/*  93 */     this.Shape1 = new ModelRenderer(this, 0, 31);
/*  94 */     this.Shape1.addBox(1.0F, -1.0F, -3.0F, 6, 5, 6);
/*  95 */     this.Shape1.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  96 */     this.Shape1.setTextureSize(128, 64);
/*  97 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  98 */     this.Shape2 = new ModelRenderer(this, 0, 31);
/*  99 */     this.Shape2.addBox(-7.0F, -1.0F, -3.0F, 6, 5, 6);
/* 100 */     this.Shape2.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 101 */     this.Shape2.setTextureSize(128, 64);
/* 102 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 103 */     this.Shape3 = new ModelRenderer(this, 0, 42);
/* 104 */     this.Shape3.addBox(-4.0F, 1.0F, -3.0F, 8, 6, 6);
/* 105 */     this.Shape3.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 106 */     this.Shape3.setTextureSize(128, 64);
/* 107 */     setRotation(this.Shape3, 0.1745329F, 0.0F, 0.0F);
/* 108 */     this.Shape4 = new ModelRenderer(this, 24, 31);
/* 109 */     this.Shape4.addBox(-3.0F, 11.0F, -1.0F, 6, 2, 3);
/* 110 */     this.Shape4.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 111 */     this.Shape4.setTextureSize(128, 64);
/* 112 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 113 */     this.Shape5 = new ModelRenderer(this, 56, 16);
/* 114 */     this.Shape5.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3);
/* 115 */     this.Shape5.setRotationPoint(-7.0F, 3.0F, 0.0F);
/* 116 */     this.Shape5.setTextureSize(128, 64);
/* 117 */     setRotation(this.Shape5, -0.4461433F, -0.7063936F, 0.0F);
/* 118 */     this.neck = new ModelRenderer(this, 44, 41);
/* 119 */     this.neck.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 3);
/* 120 */     this.neck.setRotationPoint(0.0F, -5.0F, 0.0F);
/* 121 */     this.neck.setTextureSize(128, 64);
/* 122 */     setRotation(this.neck, 0.0F, 0.0F, 0.0F);
/* 123 */     this.Shape13 = new ModelRenderer(this, 40, 50);
/* 124 */     this.Shape13.addBox(0.0F, 0.0F, -2.0F, 1, 5, 5);
/* 125 */     this.Shape13.setRotationPoint(4.0F, 7.0F, 0.0F);
/* 126 */     this.Shape13.setTextureSize(128, 64);
/* 127 */     setRotation(this.Shape13, 0.0F, 0.0F, 0.7853982F);
/* 128 */     this.Shape14 = new ModelRenderer(this, 40, 50);
/* 129 */     this.Shape14.addBox(-1.0F, 0.0F, -2.0F, 1, 5, 5);
/* 130 */     this.Shape14.setRotationPoint(-4.0F, 7.0F, 0.0F);
/* 131 */     this.Shape14.setTextureSize(128, 64);
/* 132 */     setRotation(this.Shape14, 0.0F, 0.0F, -0.7853982F);
/* 133 */     this.Shape11 = new ModelRenderer(this, 28, 50);
/* 134 */     this.Shape11.addBox(0.0F, -2.0F, -2.0F, 1, 5, 5);
/* 135 */     this.Shape11.setRotationPoint(4.0F, 8.0F, 0.0F);
/* 136 */     this.Shape11.setTextureSize(128, 64);
/* 137 */     setRotation(this.Shape11, 0.0F, 0.0F, -0.7853982F);
/* 138 */     this.Shape12 = new ModelRenderer(this, 28, 50);
/* 139 */     this.Shape12.addBox(1.0F, -2.0F, -3.0F, 1, 5, 5);
/* 140 */     this.Shape12.setRotationPoint(-3.0F, 9.0F, 1.0F);
/* 141 */     this.Shape12.setTextureSize(128, 64);
/* 142 */     setRotation(this.Shape12, 0.0F, 3.141593F, -0.7853982F);
/* 143 */     this.Shape15 = new ModelRenderer(this, 38, 46);
/* 144 */     this.Shape15.addBox(0.0F, 0.0F, 0.0F, 2, 3, 1);
/* 145 */     this.Shape15.setRotationPoint(-1.0F, 8.0F, -2.5F);
/* 146 */     this.Shape15.setTextureSize(128, 64);
/* 147 */     setRotation(this.Shape15, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 152 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 153 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 154 */     this.Shape10.render(f5);
/* 155 */     this.head.render(f5);
/* 156 */     this.Shape9.render(f5);
/* 157 */     this.body.render(f5);
/* 158 */     this.Shape8.render(f5);
/* 159 */     this.rightarm.render(f5);
/* 160 */     this.Shape7.render(f5);
/* 161 */     this.leftarm.render(f5);
/* 162 */     this.Shape6.render(f5);
/* 163 */     this.rightleg.render(f5);
/* 164 */     this.leftleg.render(f5);
/* 165 */     this.Shape1.render(f5);
/* 166 */     this.Shape2.render(f5);
/* 167 */     this.Shape3.render(f5);
/* 168 */     this.Shape4.render(f5);
/* 169 */     this.Shape5.render(f5);
/* 170 */     this.neck.render(f5);
/* 171 */     this.Shape13.render(f5);
/* 172 */     this.Shape14.render(f5);
/* 173 */     this.Shape11.render(f5);
/* 174 */     this.Shape12.render(f5);
/* 175 */     this.Shape15.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 180 */     model.rotateAngleX = x;
/* 181 */     model.rotateAngleY = y;
/* 182 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity E) {
/* 187 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, E);
/* 188 */     this.head.rotateAngleY = f3 / 57.295776F;
/* 189 */     this.head.rotateAngleX = f4 / 57.295776F;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelTheHand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */