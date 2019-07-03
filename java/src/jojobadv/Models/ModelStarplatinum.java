/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelStarplatinum
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape9;
/*     */   ModelRenderer Shape10;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer Shape12;
/*     */   ModelRenderer Shape13;
/*     */   ModelRenderer Shape14;
/*     */   ModelRenderer Shape15;
/*     */   ModelRenderer Shape16;
/*     */   ModelRenderer Shape17;
/*     */   ModelRenderer Shape18;
/*     */   ModelRenderer Shape19;
/*     */   ModelRenderer Shape20;
/*     */   ModelRenderer Shape21;
/*     */   ModelRenderer Shape22;
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
/*     */   ModelRenderer Shape23;
/*     */   
/*     */   public ModelStarplatinum() {
/*  44 */     this.textureWidth = 128;
/*  45 */     this.textureHeight = 64;
/*     */     
/*  47 */     this.Shape6 = new ModelRenderer(this, 56, 16);
/*  48 */     this.Shape6.mirror = true;
/*  49 */     this.Shape6.addBox(-1.0F, 0.0F, -1.0F, 3, 7, 3);
/*  50 */     this.Shape6.setRotationPoint(8.0F, 2.0F, -1.0F);
/*  51 */     setRotation(this.Shape6, -0.4089647F, 0.0371786F, 0.1972532F);
/*  52 */     this.Shape7 = new ModelRenderer(this, 56, 26);
/*  53 */     this.Shape7.addBox(-2.0F, 0.0F, 0.0F, 3, 7, 3);
/*  54 */     this.Shape7.setRotationPoint(-5.0F, 14.0F, 1.0F);
/*  55 */     setRotation(this.Shape7, 0.5205006F, 0.0743572F, -0.0371786F);
/*  56 */     this.Shape8 = new ModelRenderer(this, 56, 26);
/*  57 */     this.Shape8.addBox(0.0F, 0.0F, -1.0F, 3, 7, 3);
/*  58 */     this.Shape8.setRotationPoint(4.0F, 13.0F, 2.0F);
/*  59 */     setRotation(this.Shape8, 0.5205006F, -0.1115358F, 0.0F);
/*  60 */     this.Shape8.mirror = true;
/*  61 */     this.Shape9 = new ModelRenderer(this, 78, 8);
/*  62 */     this.Shape9.addBox(-3.0F, -1.0F, -4.0F, 6, 2, 7);
/*  63 */     this.Shape9.setRotationPoint(0.0F, -4.0F, 0.0F);
/*  64 */     setRotation(this.Shape9, 0.1858931F, 0.0F, 0.0F);
/*  65 */     this.Shape10 = new ModelRenderer(this, 28, 0);
/*  66 */     this.Shape10.addBox(-3.0F, -7.0F, -4.0F, 6, 1, 7);
/*  67 */     this.Shape10.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  68 */     setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
/*  69 */     this.Shape11 = new ModelRenderer(this, 28, 0);
/*  70 */     this.Shape11.addBox(-4.0F, -9.0F, -5.0F, 8, 3, 9);
/*  71 */     this.Shape11.setRotationPoint(0.0F, -6.0F, 0.0F);
/*  72 */     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
/*  73 */     this.Shape12 = new ModelRenderer(this, 0, 0);
/*  74 */     this.Shape12.addBox(-3.0F, -6.0F, -4.5F, 6, 1, 1);
/*  75 */     this.Shape12.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  76 */     setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
/*  77 */     this.Shape13 = new ModelRenderer(this, 28, 0);
/*  78 */     this.Shape13.addBox(-3.0F, -12.0F, -3.0F, 6, 2, 8);
/*  79 */     this.Shape13.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  80 */     setRotation(this.Shape13, 0.0F, 0.0F, 0.0F);
/*  81 */     this.Shape14 = new ModelRenderer(this, 28, 0);
/*  82 */     this.Shape14.addBox(2.0F, -8.0F, 2.0F, 1, 4, 4);
/*  83 */     this.Shape14.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  84 */     setRotation(this.Shape14, 0.0F, 0.1745329F, 0.0F);
/*  85 */     this.Shape15 = new ModelRenderer(this, 28, 0);
/*  86 */     this.Shape15.addBox(-3.0F, -8.0F, 2.0F, 1, 4, 4);
/*  87 */     this.Shape15.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  88 */     setRotation(this.Shape15, 0.0F, -0.1745329F, 0.0F);
/*  89 */     this.Shape16 = new ModelRenderer(this, 28, 0);
/*  90 */     this.Shape16.addBox(-4.0F, -10.0F, 4.0F, 8, 2, 4);
/*  91 */     this.Shape16.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  92 */     setRotation(this.Shape16, 0.0F, 0.0F, 0.0F);
/*  93 */     this.Shape17 = new ModelRenderer(this, 28, 0);
/*  94 */     this.Shape17.addBox(-3.0F, -6.0F, 2.0F, 6, 2, 5);
/*  95 */     this.Shape17.setRotationPoint(0.0F, -5.0F, 0.0F);
/*  96 */     setRotation(this.Shape17, 0.0F, 0.0F, 0.0F);
/*  97 */     this.Shape18 = new ModelRenderer(this, 0, 54);
/*  98 */     this.Shape18.addBox(-4.5F, 9.0F, -2.0F, 9, 2, 5);
/*  99 */     this.Shape18.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 100 */     setRotation(this.Shape18, 0.0F, 0.0F, 0.0F);
/* 101 */     this.Shape19 = new ModelRenderer(this, 28, 54);
/* 102 */     this.Shape19.addBox(-2.0F, 10.0F, -3.0F, 4, 6, 1);
/* 103 */     this.Shape19.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 104 */     setRotation(this.Shape19, 0.0F, 0.0F, 0.0F);
/* 105 */     this.Shape20 = new ModelRenderer(this, 28, 54);
/* 106 */     this.Shape20.addBox(-2.0F, 10.0F, 3.0F, 4, 6, 1);
/* 107 */     this.Shape20.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 108 */     setRotation(this.Shape20, 0.0F, 0.0F, 0.0F);
/* 109 */     this.Shape21 = new ModelRenderer(this, 62, 0);
/* 110 */     this.Shape21.addBox(2.0F, -4.0F, -3.0F, 5, 2, 6);
/* 111 */     this.Shape21.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 112 */     setRotation(this.Shape21, 0.0F, 0.0F, 0.2449038F);
/* 113 */     this.Shape21.mirror = true;
/* 114 */     this.Shape22 = new ModelRenderer(this, 62, 0);
/* 115 */     this.Shape22.addBox(-7.0F, -4.0F, -3.0F, 5, 2, 6);
/* 116 */     this.Shape22.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 117 */     setRotation(this.Shape22, 0.0F, 0.0F, -0.2932153F);
/* 118 */     this.head = new ModelRenderer(this, 0, 4);
/* 119 */     this.head.addBox(-3.0F, -6.0F, -4.0F, 6, 6, 6);
/* 120 */     this.head.setRotationPoint(0.0F, -5.0F, 0.0F);
/* 121 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 122 */     this.body = new ModelRenderer(this, 16, 16);
/* 123 */     this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 11, 4);
/* 124 */     this.body.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 125 */     setRotation(this.body, 0.0872665F, 0.0F, 0.0F);
/* 126 */     this.rightarm = new ModelRenderer(this, 40, 16);
/* 127 */     this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 8, 4);
/* 128 */     this.rightarm.setRotationPoint(-5.0F, -2.0F, 0.0F);
/* 129 */     setRotation(this.rightarm, -0.5948578F, 1.320977F, -0.0970775F);
/* 130 */     this.leftarm = new ModelRenderer(this, 40, 16);
/* 131 */     this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 8, 4);
/* 132 */     this.leftarm.setRotationPoint(5.0F, -2.0F, 0.0F);
/* 133 */     this.leftarm.mirror = true;
/* 134 */     setRotation(this.leftarm, -0.5934119F, -1.308997F, 0.0872665F);
/* 135 */     this.rightleg = new ModelRenderer(this, 0, 16);
/* 136 */     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 137 */     this.rightleg.setRotationPoint(-3.0F, 9.0F, 0.0F);
/* 138 */     setRotation(this.rightleg, 0.2974289F, -0.0371786F, 0.2602503F);
/* 139 */     this.leftleg = new ModelRenderer(this, 0, 16);
/* 140 */     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 141 */     this.leftleg.setRotationPoint(3.0F, 9.0F, 0.0F);
/* 142 */     setRotation(this.leftleg, 0.2974289F, -0.0371786F, -0.4089647F);
/* 143 */     this.Shape1 = new ModelRenderer(this, 0, 31);
/* 144 */     this.Shape1.mirror = true;
/* 145 */     this.Shape1.addBox(1.0F, -1.0F, -3.0F, 6, 5, 6);
/* 146 */     this.Shape1.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 147 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 148 */     this.Shape2 = new ModelRenderer(this, 0, 31);
/* 149 */     this.Shape2.addBox(-7.0F, -1.0F, -3.0F, 6, 5, 6);
/* 150 */     this.Shape2.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 151 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 152 */     this.Shape3 = new ModelRenderer(this, 0, 42);
/* 153 */     this.Shape3.addBox(-4.0F, 1.0F, -3.0F, 8, 6, 6);
/* 154 */     this.Shape3.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 155 */     setRotation(this.Shape3, 0.1745329F, 0.0F, 0.0F);
/* 156 */     this.Shape4 = new ModelRenderer(this, 24, 31);
/* 157 */     this.Shape4.addBox(-3.0F, 11.0F, -2.0F, 6, 2, 4);
/* 158 */     this.Shape4.setRotationPoint(0.0F, -3.0F, 0.0F);
/* 159 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 160 */     this.Shape5 = new ModelRenderer(this, 56, 16);
/* 161 */     this.Shape5.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3);
/* 162 */     this.Shape5.setRotationPoint(-7.0F, 3.0F, 0.0F);
/* 163 */     setRotation(this.Shape5, -0.2602503F, 0.2230717F, -0.3346075F);
/* 164 */     this.Shape23 = new ModelRenderer(this, 0, 0);
/* 165 */     this.Shape23.addBox(-1.0F, -0.5F, -4.5F, 2, 1, 1);
/* 166 */     this.Shape23.setRotationPoint(0.0F, -5.0F, 0.0F);
/* 167 */     setRotation(this.Shape23, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 172 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 173 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 174 */     this.Shape6.render(f5);
/* 175 */     this.Shape7.render(f5);
/* 176 */     this.Shape8.render(f5);
/* 177 */     this.Shape9.render(f5);
/* 178 */     this.Shape10.render(f5);
/* 179 */     this.Shape11.render(f5);
/* 180 */     this.Shape12.render(f5);
/* 181 */     this.Shape13.render(f5);
/* 182 */     this.Shape14.render(f5);
/* 183 */     this.Shape15.render(f5);
/* 184 */     this.Shape16.render(f5);
/* 185 */     this.Shape17.render(f5);
/* 186 */     this.Shape18.render(f5);
/* 187 */     this.Shape19.render(f5);
/* 188 */     this.Shape20.render(f5);
/* 189 */     this.Shape21.render(f5);
/* 190 */     this.Shape22.render(f5);
/* 191 */     this.Shape23.render(f5);
/* 192 */     this.head.render(f5);
/* 193 */     this.body.render(f5);
/* 194 */     this.rightarm.render(f5);
/* 195 */     this.leftarm.render(f5);
/* 196 */     this.rightleg.render(f5);
/* 197 */     this.leftleg.render(f5);
/* 198 */     this.Shape1.render(f5);
/* 199 */     this.Shape2.render(f5);
/* 200 */     this.Shape3.render(f5);
/* 201 */     this.Shape4.render(f5);
/* 202 */     this.Shape5.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 207 */     model.rotateAngleX = x;
/* 208 */     model.rotateAngleY = y;
/* 209 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
/* 214 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
/* 215 */     this.head.rotateAngleY = f3 / 57.295776F;
/* 216 */     this.head.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 218 */     this.Shape10.rotateAngleY = f3 / 57.295776F;
/* 219 */     this.Shape10.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 221 */     this.Shape11.rotateAngleY = f3 / 57.295776F;
/* 222 */     this.Shape11.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 224 */     this.Shape12.rotateAngleY = f3 / 57.295776F;
/* 225 */     this.Shape12.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 227 */     this.Shape13.rotateAngleY = f3 / 57.295776F;
/* 228 */     this.Shape13.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 230 */     this.Shape14.rotateAngleY = f3 / 57.295776F;
/* 231 */     this.Shape14.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 233 */     this.Shape15.rotateAngleY = f3 / 57.295776F;
/* 234 */     this.Shape15.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 236 */     this.Shape16.rotateAngleY = f3 / 57.295776F;
/* 237 */     this.Shape16.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 239 */     this.Shape17.rotateAngleY = f3 / 57.295776F;
/* 240 */     this.Shape17.rotateAngleX = f4 / 57.295776F;
/*     */     
/* 242 */     this.Shape23.rotateAngleY = f3 / 57.295776F;
/* 243 */     this.Shape23.rotateAngleX = f4 / 57.295776F;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelStarplatinum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */