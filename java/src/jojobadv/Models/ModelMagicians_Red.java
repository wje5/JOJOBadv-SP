/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class ModelMagicians_Red
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Headbase;
/*     */   ModelRenderer Bodybase;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape10;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer Shape12;
/*     */   ModelRenderer Shape13;
/*     */   ModelRenderer Shape14;
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
/*     */   ModelRenderer Shape9;
/*     */   
/*     */   public ModelMagicians_Red() {
/*  35 */     this.textureWidth = 128;
/*  36 */     this.textureHeight = 64;
/*     */     
/*  38 */     this.Headbase = new ModelRenderer(this, "Headbase");
/*  39 */     this.Headbase.setRotationPoint(0.0F, -4.0F, 0.0F);
/*  40 */     setRotation(this.Headbase, 0.0F, 0.0F, 0.0F);
/*  41 */     this.Shape13 = new ModelRenderer(this, 40, 4);
/*  42 */     this.Shape13.addBox(-2.0F, -3.0F, -7.0F, 4, 1, 5);
/*  43 */     this.Shape13.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  44 */     this.Shape13.setTextureSize(128, 64);
/*  45 */     setRotation(this.Shape13, 0.0F, 0.0F, 0.0F);
/*  46 */     this.Shape12 = new ModelRenderer(this, 40, 4);
/*  47 */     this.Shape12.addBox(-1.0F, 0.0F, 2.0F, 2, 1, 1);
/*  48 */     this.Shape12.setRotationPoint(0.0F, -2.0F, -7.0F);
/*  49 */     this.Shape12.setTextureSize(128, 64);
/*  50 */     setRotation(this.Shape12, 0.8179294F, 0.0F, 0.0F);
/*  51 */     this.Shape11 = new ModelRenderer(this, 40, 4);
/*  52 */     this.Shape11.addBox(-2.0F, -5.0F, -6.0F, 4, 1, 5);
/*  53 */     this.Shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  54 */     this.Shape11.setTextureSize(128, 64);
/*  55 */     setRotation(this.Shape11, 0.2974289F, 0.0F, 0.0F);
/*  56 */     this.Shape10 = new ModelRenderer(this, 42, 1);
/*  57 */     this.Shape10.addBox(-1.0F, -5.0F, -5.0F, 2, 1, 2);
/*  58 */     this.Shape10.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  59 */     this.Shape10.setTextureSize(128, 64);
/*  60 */     setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
/*  61 */     this.Shape14 = new ModelRenderer(this, 20, 2);
/*  62 */     this.Shape14.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 7);
/*  63 */     this.Shape14.setRotationPoint(0.0F, -7.0F, 1.0F);
/*  64 */     this.Shape14.setTextureSize(128, 64);
/*  65 */     setRotation(this.Shape14, -0.4461433F, 0.0F, 0.0F);
/*  66 */     this.head = new ModelRenderer(this, 0, 5);
/*  67 */     this.head.addBox(-3.0F, -6.0F, -3.0F, 5, 6, 5);
/*  68 */     this.head.setRotationPoint(0.0F, -1.0F, 0.0F);
/*  69 */     this.head.setTextureSize(128, 64);
/*  70 */     setRotation(this.head, 0.0F, -0.7853982F, 0.0F);
/*     */ 
/*     */     
/*  73 */     this.Headbase.addChild(this.Shape13);
/*  74 */     this.Headbase.addChild(this.Shape12);
/*  75 */     this.Headbase.addChild(this.Shape11);
/*  76 */     this.Headbase.addChild(this.Shape10);
/*  77 */     this.Headbase.addChild(this.Shape14);
/*  78 */     this.Headbase.addChild(this.head);
/*     */     
/*  80 */     this.Bodybase = new ModelRenderer(this, "Bodybase");
/*  81 */     this.Bodybase.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  82 */     setRotation(this.Bodybase, 0.0F, 0.0F, 0.0F);
/*  83 */     this.Bodybase.mirror = true;
/*  84 */     this.Shape6 = new ModelRenderer(this, 56, 16);
/*  85 */     this.Shape6.addBox(-1.0F, 0.0F, -1.0F, 3, 7, 3);
/*  86 */     this.Shape6.setRotationPoint(7.0F, 2.0F, -1.0F);
/*  87 */     this.Shape6.setTextureSize(128, 64);
/*  88 */     setRotation(this.Shape6, -0.4089647F, 0.0371786F, 0.1972532F);
/*  89 */     this.Shape6.mirror = true;
/*  90 */     this.Shape9 = new ModelRenderer(this, 20, 10);
/*  91 */     this.Shape9.addBox(-2.0F, -5.0F, -2.0F, 4, 2, 4);
/*  92 */     this.Shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  93 */     this.Shape9.setTextureSize(128, 64);
/*  94 */     setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
/*  95 */     this.Shape5 = new ModelRenderer(this, 56, 16);
/*  96 */     this.Shape5.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3);
/*  97 */     this.Shape5.setRotationPoint(-7.0F, 3.0F, 0.0F);
/*  98 */     this.Shape5.setTextureSize(128, 64);
/*  99 */     setRotation(this.Shape5, -0.2602503F, 0.2230717F, -0.3346075F);
/* 100 */     this.Shape4 = new ModelRenderer(this, 24, 31);
/* 101 */     this.Shape4.addBox(-3.0F, 11.0F, -2.0F, 6, 2, 4);
/* 102 */     this.Shape4.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 103 */     this.Shape4.setTextureSize(128, 64);
/* 104 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 105 */     this.Shape3 = new ModelRenderer(this, 0, 42);
/* 106 */     this.Shape3.addBox(-4.0F, 1.0F, -3.0F, 8, 6, 6);
/* 107 */     this.Shape3.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 108 */     this.Shape3.setTextureSize(128, 64);
/* 109 */     setRotation(this.Shape3, 0.1745329F, 0.0F, 0.0F);
/* 110 */     this.Shape2 = new ModelRenderer(this, 0, 31);
/* 111 */     this.Shape2.addBox(-6.0F, 1.0F, -3.0F, 5, 4, 6);
/* 112 */     this.Shape2.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 113 */     this.Shape2.setTextureSize(128, 64);
/* 114 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 115 */     this.Shape1 = new ModelRenderer(this, 0, 31);
/* 116 */     this.Shape1.addBox(1.0F, 1.0F, -3.0F, 5, 4, 6);
/* 117 */     this.Shape1.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 118 */     this.Shape1.setTextureSize(128, 64);
/* 119 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 120 */     this.Shape1.mirror = true;
/* 121 */     this.leftleg = new ModelRenderer(this, 0, 16);
/* 122 */     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 123 */     this.leftleg.setRotationPoint(3.0F, 9.0F, 0.0F);
/* 124 */     this.leftleg.setTextureSize(128, 64);
/* 125 */     setRotation(this.leftleg, 0.2974289F, -0.0371786F, -0.4089647F);
/* 126 */     this.rightleg = new ModelRenderer(this, 0, 16);
/* 127 */     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 128 */     this.rightleg.setRotationPoint(-3.0F, 9.0F, 0.0F);
/* 129 */     this.rightleg.setTextureSize(128, 64);
/* 130 */     setRotation(this.rightleg, 0.2974289F, -0.0371786F, 0.2602503F);
/* 131 */     this.leftarm = new ModelRenderer(this, 40, 16);
/* 132 */     this.leftarm.addBox(-1.0F, -1.0F, -1.0F, 3, 8, 3);
/* 133 */     this.leftarm.setRotationPoint(5.0F, -2.0F, 0.0F);
/* 134 */     this.leftarm.setTextureSize(128, 64);
/* 135 */     setRotation(this.leftarm, -0.5934119F, -1.308997F, 0.0872665F);
/* 136 */     this.rightarm = new ModelRenderer(this, 40, 16);
/* 137 */     this.rightarm.addBox(-3.0F, -1.0F, -1.0F, 3, 8, 3);
/* 138 */     this.rightarm.setRotationPoint(-5.0F, -2.0F, 0.0F);
/* 139 */     this.rightarm.setTextureSize(128, 64);
/* 140 */     setRotation(this.rightarm, -0.5948578F, 1.320977F, -0.0970775F);
/* 141 */     this.Shape7 = new ModelRenderer(this, 56, 26);
/* 142 */     this.Shape7.addBox(-2.0F, 0.0F, 0.0F, 3, 7, 3);
/* 143 */     this.Shape7.setRotationPoint(-5.0F, 14.0F, 1.0F);
/* 144 */     this.Shape7.setTextureSize(128, 64);
/* 145 */     setRotation(this.Shape7, 0.5205006F, 0.0743572F, -0.0371786F);
/* 146 */     this.Shape8 = new ModelRenderer(this, 56, 26);
/* 147 */     this.Shape8.addBox(0.0F, 0.0F, -1.0F, 3, 7, 3);
/* 148 */     this.Shape8.setRotationPoint(4.0F, 13.0F, 2.0F);
/* 149 */     this.Shape8.setTextureSize(128, 64);
/* 150 */     setRotation(this.Shape8, 0.5205006F, -0.1115358F, 0.0F);
/* 151 */     this.Shape8.mirror = true;
/* 152 */     this.body = new ModelRenderer(this, 16, 16);
/* 153 */     this.body.addBox(-3.0F, 0.0F, -2.0F, 6, 11, 4);
/* 154 */     this.body.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 155 */     this.body.setTextureSize(128, 64);
/* 156 */     setRotation(this.body, 0.0872665F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 159 */     this.Bodybase.addChild(this.Shape6);
/* 160 */     this.Bodybase.addChild(this.Shape9);
/* 161 */     this.Bodybase.addChild(this.Shape5);
/* 162 */     this.Bodybase.addChild(this.Shape4);
/* 163 */     this.Bodybase.addChild(this.Shape3);
/* 164 */     this.Bodybase.addChild(this.Shape2);
/* 165 */     this.Bodybase.addChild(this.Shape1);
/* 166 */     this.Bodybase.addChild(this.leftleg);
/* 167 */     this.Bodybase.addChild(this.rightleg);
/* 168 */     this.Bodybase.addChild(this.leftarm);
/* 169 */     this.Bodybase.addChild(this.rightarm);
/* 170 */     this.Bodybase.addChild(this.Shape7);
/* 171 */     this.Bodybase.addChild(this.Shape8);
/* 172 */     this.Bodybase.addChild(this.body);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 177 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 178 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 179 */     this.Headbase.render(f5);
/* 180 */     this.Bodybase.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 185 */     model.rotateAngleX = x;
/* 186 */     model.rotateAngleY = y;
/* 187 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
/* 192 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
/* 193 */     this.Headbase.rotateAngleY = f3 / 57.295776F;
/* 194 */     this.Headbase.rotateAngleX = f4 / 57.295776F;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelMagicians_Red.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */