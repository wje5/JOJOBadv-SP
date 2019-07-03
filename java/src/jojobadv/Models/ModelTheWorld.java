/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class ModelTheWorld
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape18;
/*     */   ModelRenderer Shape9;
/*     */   ModelRenderer Shape10;
/*     */   ModelRenderer Shape11;
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
/*     */   public ModelTheWorld() {
/*  34 */     this.textureWidth = 128;
/*  35 */     this.textureHeight = 64;
/*     */     
/*  37 */     this.Shape6 = new ModelRenderer(this, 56, 16);
/*  38 */     this.Shape6.addBox(-1.0F, 0.0F, -1.0F, 3, 7, 3);
/*  39 */     this.Shape6.setRotationPoint(8.0F, 2.0F, -1.0F);
/*  40 */     this.Shape6.setTextureSize(128, 64);
/*  41 */     this.Shape6.mirror = true;
/*  42 */     setRotation(this.Shape6, -0.4089647F, 0.0371786F, 0.1972532F);
/*  43 */     this.Shape7 = new ModelRenderer(this, 56, 26);
/*  44 */     this.Shape7.addBox(-2.0F, 0.0F, 0.0F, 3, 7, 3);
/*  45 */     this.Shape7.setRotationPoint(-5.0F, 14.0F, 1.0F);
/*  46 */     this.Shape7.setTextureSize(128, 64);
/*  47 */     setRotation(this.Shape7, 0.5205006F, 0.0743572F, -0.0371786F);
/*  48 */     this.Shape8 = new ModelRenderer(this, 56, 26);
/*  49 */     this.Shape8.addBox(0.0F, 0.0F, -1.0F, 3, 7, 3);
/*  50 */     this.Shape8.setRotationPoint(4.0F, 13.0F, 2.0F);
/*  51 */     this.Shape8.setTextureSize(128, 64);
/*  52 */     this.Shape8.mirror = true;
/*  53 */     setRotation(this.Shape8, 0.5205006F, -0.1115358F, 0.0F);
/*  54 */     this.Shape18 = new ModelRenderer(this, 0, 54);
/*  55 */     this.Shape18.addBox(-4.5F, 9.0F, -2.0F, 9, 2, 5);
/*  56 */     this.Shape18.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  57 */     this.Shape18.setTextureSize(128, 64);
/*  58 */     setRotation(this.Shape18, 0.0F, 0.0F, 0.0F);
/*  59 */     this.Shape9 = new ModelRenderer(this, 66, 0);
/*  60 */     this.Shape9.addBox(-5.0F, -2.0F, -4.0F, 2, 6, 8);
/*  61 */     this.Shape9.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  62 */     this.Shape9.setTextureSize(128, 64);
/*  63 */     setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
/*  64 */     this.Shape10 = new ModelRenderer(this, 66, 0);
/*  65 */     this.Shape10.addBox(3.0F, -2.0F, -4.0F, 2, 6, 8);
/*  66 */     this.Shape10.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  67 */     this.Shape10.setTextureSize(128, 64);
/*  68 */     setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
/*  69 */     this.Shape11 = new ModelRenderer(this, 68, 16);
/*  70 */     this.Shape11.addBox(0.0F, 0.0F, 3.0F, 3, 6, 3);
/*  71 */     this.Shape11.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  72 */     this.Shape11.setTextureSize(128, 64);
/*  73 */     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
/*  74 */     this.Shape12 = new ModelRenderer(this, 68, 16);
/*  75 */     this.Shape12.addBox(-3.0F, 0.0F, 3.0F, 3, 6, 3);
/*  76 */     this.Shape12.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  77 */     this.Shape12.setTextureSize(128, 64);
/*  78 */     setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
/*  79 */     this.head = new ModelRenderer(this, 0, 4);
/*  80 */     this.head.addBox(-3.0F, -6.0F, -4.0F, 6, 6, 6);
/*  81 */     this.head.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  82 */     this.head.setTextureSize(128, 64);
/*  83 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  84 */     this.body = new ModelRenderer(this, 16, 16);
/*  85 */     this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 11, 4);
/*  86 */     this.body.setRotationPoint(0.0F, -3.0F, 0.0F);
/*  87 */     this.body.setTextureSize(128, 64);
/*  88 */     setRotation(this.body, 0.0872665F, 0.0F, 0.0F);
/*  89 */     this.rightarm = new ModelRenderer(this, 40, 16);
/*  90 */     this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 8, 4);
/*  91 */     this.rightarm.setRotationPoint(-5.0F, -2.0F, 0.0F);
/*  92 */     this.rightarm.setTextureSize(128, 64);
/*  93 */     setRotation(this.rightarm, -0.5948578F, 1.320977F, -0.0970775F);
/*  94 */     this.leftarm = new ModelRenderer(this, 40, 16);
/*  95 */     this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 8, 4);
/*  96 */     this.leftarm.setRotationPoint(5.0F, -2.0F, 0.0F);
/*  97 */     this.leftarm.setTextureSize(128, 64);
/*  98 */     setRotation(this.leftarm, -0.5934119F, -1.308997F, 0.0872665F);
/*  99 */     this.rightleg = new ModelRenderer(this, 0, 16);
/* 100 */     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 101 */     this.rightleg.setRotationPoint(-3.0F, 9.0F, 0.0F);
/* 102 */     this.rightleg.setTextureSize(128, 64);
/* 103 */     setRotation(this.rightleg, 0.2974289F, -0.0371786F, 0.2602503F);
/* 104 */     this.leftleg = new ModelRenderer(this, 0, 16);
/* 105 */     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 106 */     this.leftleg.setRotationPoint(3.0F, 9.0F, 0.0F);
/* 107 */     this.leftleg.setTextureSize(128, 64);
/* 108 */     setRotation(this.leftleg, 0.2974289F, -0.0371786F, -0.4089647F);
/* 109 */     this.Shape1 = new ModelRenderer(this, 0, 31);
/* 110 */     this.Shape1.addBox(1.0F, -1.0F, -3.0F, 6, 5, 6);
/* 111 */     this.Shape1.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 112 */     this.Shape1.setTextureSize(128, 64);
/* 113 */     this.Shape1.mirror = true;
/* 114 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 115 */     this.Shape2 = new ModelRenderer(this, 0, 31);
/* 116 */     this.Shape2.addBox(-7.0F, -1.0F, -3.0F, 6, 5, 6);
/* 117 */     this.Shape2.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 118 */     this.Shape2.setTextureSize(128, 64);
/* 119 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 120 */     this.Shape3 = new ModelRenderer(this, 0, 42);
/* 121 */     this.Shape3.addBox(-4.0F, 1.0F, -3.0F, 8, 6, 6);
/* 122 */     this.Shape3.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 123 */     this.Shape3.setTextureSize(128, 64);
/* 124 */     setRotation(this.Shape3, 0.1745329F, 0.0F, 0.0F);
/* 125 */     this.Shape4 = new ModelRenderer(this, 24, 31);
/* 126 */     this.Shape4.addBox(-3.0F, 11.0F, -2.0F, 6, 2, 4);
/* 127 */     this.Shape4.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 128 */     this.Shape4.setTextureSize(128, 64);
/* 129 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 130 */     this.Shape5 = new ModelRenderer(this, 56, 16);
/* 131 */     this.Shape5.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3);
/* 132 */     this.Shape5.setRotationPoint(-7.0F, 3.0F, 0.0F);
/* 133 */     this.Shape5.setTextureSize(128, 64);
/* 134 */     setRotation(this.Shape5, -0.2602503F, 0.2230717F, -0.3346075F);
/* 135 */     this.neck = new ModelRenderer(this, 44, 41);
/* 136 */     this.neck.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 3);
/* 137 */     this.neck.setRotationPoint(0.0F, -5.0F, 0.0F);
/* 138 */     this.neck.setTextureSize(128, 64);
/* 139 */     setRotation(this.neck, 0.0F, 0.0F, 0.0F);
/* 140 */     this.hat = new ModelRenderer(this, 24, 0);
/* 141 */     this.hat.addBox(-4.0F, -7.0F, -5.0F, 8, 7, 8);
/* 142 */     this.hat.setRotationPoint(0.0F, -5.0F, 0.0F);
/* 143 */     this.hat.setTextureSize(128, 64);
/* 144 */     setRotation(this.hat, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 149 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 150 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 151 */     this.Shape6.render(f5);
/* 152 */     this.Shape7.render(f5);
/* 153 */     this.Shape8.render(f5);
/* 154 */     this.Shape18.render(f5);
/* 155 */     this.Shape9.render(f5);
/* 156 */     this.Shape10.render(f5);
/* 157 */     this.Shape11.render(f5);
/* 158 */     this.Shape12.render(f5);
/* 159 */     this.head.render(f5);
/* 160 */     this.body.render(f5);
/* 161 */     this.rightarm.render(f5);
/* 162 */     this.leftarm.render(f5);
/* 163 */     this.rightleg.render(f5);
/* 164 */     this.leftleg.render(f5);
/* 165 */     this.Shape1.render(f5);
/* 166 */     this.Shape2.render(f5);
/* 167 */     this.Shape3.render(f5);
/* 168 */     this.Shape4.render(f5);
/* 169 */     this.Shape5.render(f5);
/* 170 */     this.neck.render(f5);
/* 171 */     this.hat.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 176 */     model.rotateAngleX = x;
/* 177 */     model.rotateAngleY = y;
/* 178 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
/* 183 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
/*     */     
/* 185 */     this.head.rotateAngleY = f3 / 57.295776F;
/* 186 */     this.head.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 188 */     this.hat.rotateAngleY = f3 / 57.295776F;
/* 189 */     this.hat.rotateAngleX = f4 / 57.295776F;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelTheWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */