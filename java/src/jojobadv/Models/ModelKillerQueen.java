/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class ModelKillerQueen
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer HEAD;
/*     */   ModelRenderer Bodybase;
/*     */   private ModelRenderer Shape7;
/*     */   private ModelRenderer Shape5;
/*     */   private ModelRenderer Shape6;
/*     */   private ModelRenderer Shape10;
/*     */   private ModelRenderer Shape3;
/*     */   private ModelRenderer leftleg;
/*     */   private ModelRenderer rightleg;
/*     */   private ModelRenderer leftarm;
/*     */   private ModelRenderer rightarm;
/*     */   private ModelRenderer body;
/*     */   private ModelRenderer Shape4;
/*     */   private ModelRenderer Shape2;
/*     */   private ModelRenderer Shape1;
/*     */   private ModelRenderer Shape8;
/*     */   
/*     */   public ModelKillerQueen() {
/*  29 */     this.textureWidth = 128;
/*  30 */     this.textureHeight = 128;
/*     */     
/*  32 */     this.HEAD = new ModelRenderer(this, "HEAD");
/*  33 */     this.HEAD.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  34 */     setRotation(this.HEAD, 0.0F, 0.0F, 0.0F);
/*  35 */     this.Shape7 = new ModelRenderer(this, 32, 0);
/*  36 */     this.Shape7.addBox(-4.0F, -14.0F, -2.0F, 1, 3, 5);
/*  37 */     this.Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  38 */     this.Shape7.setTextureSize(128, 128);
/*  39 */     setRotation(this.Shape7, 0.2617994F, 0.0F, 0.0F);
/*  40 */     this.Shape5 = new ModelRenderer(this, 0, 0);
/*  41 */     this.Shape5.addBox(-4.0F, -11.0F, -4.0F, 8, 8, 8);
/*  42 */     this.Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  43 */     this.Shape5.setTextureSize(128, 128);
/*  44 */     setRotation(this.Shape5, 0.2617994F, 0.0F, 0.0F);
/*  45 */     this.Shape6 = new ModelRenderer(this, 32, 0);
/*  46 */     this.Shape6.addBox(3.0F, -14.0F, -2.0F, 1, 3, 5);
/*  47 */     this.Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  48 */     this.Shape6.setTextureSize(128, 128);
/*  49 */     setRotation(this.Shape6, 0.2617994F, 0.0F, 0.0F);
/*  50 */     this.HEAD.addChild(this.Shape7);
/*  51 */     this.HEAD.addChild(this.Shape5);
/*  52 */     this.HEAD.addChild(this.Shape6);
/*  53 */     this.Bodybase = new ModelRenderer(this, "Bodybase");
/*  54 */     this.Bodybase.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  55 */     setRotation(this.Bodybase, 0.0F, 0.0F, 0.0F);
/*  56 */     this.Shape10 = new ModelRenderer(this, 36, 103);
/*  57 */     this.Shape10.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
/*  58 */     this.Shape10.setRotationPoint(3.0F, 18.0F, -5.0F);
/*  59 */     this.Shape10.setTextureSize(128, 128);
/*  60 */     setRotation(this.Shape10, 0.5759587F, 0.0F, 0.0F);
/*  61 */     this.Shape3 = new ModelRenderer(this, 36, 103);
/*  62 */     this.Shape3.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
/*  63 */     this.Shape3.setRotationPoint(-3.0F, 18.0F, -2.0F);
/*  64 */     this.Shape3.setTextureSize(128, 128);
/*  65 */     setRotation(this.Shape3, 0.2792527F, 0.0F, 0.0F);
/*  66 */     this.leftleg = new ModelRenderer(this, 53, 103);
/*  67 */     this.leftleg.addBox(-1.5F, 0.0F, -2.0F, 4, 9, 4);
/*  68 */     this.leftleg.setRotationPoint(2.0F, 10.0F, -3.0F);
/*  69 */     this.leftleg.setTextureSize(128, 128);
/*  70 */     setRotation(this.leftleg, -0.1570796F, 0.0F, 0.0F);
/*  71 */     this.rightleg = new ModelRenderer(this, 53, 103);
/*  72 */     this.rightleg.addBox(-2.5F, 0.0F, -2.0F, 4, 9, 4);
/*  73 */     this.rightleg.setRotationPoint(-2.0F, 10.0F, -3.0F);
/*  74 */     this.rightleg.setTextureSize(128, 128);
/*  75 */     setRotation(this.rightleg, 0.1396263F, 0.0F, 0.0F);
/*  76 */     this.leftarm = new ModelRenderer(this, 67, 73);
/*  77 */     this.leftarm.addBox(0.0F, 1.0F, -3.0F, 4, 12, 4);
/*  78 */     this.leftarm.setRotationPoint(5.0F, 0.0F, 0.0F);
/*  79 */     this.leftarm.setTextureSize(128, 128);
/*  80 */     this.leftarm.mirror = true;
/*  81 */     setRotation(this.leftarm, 0.0F, 0.0F, -0.3141593F);
/*  82 */     this.rightarm = new ModelRenderer(this, 67, 73);
/*  83 */     this.rightarm.addBox(-3.0F, 1.0F, -2.0F, 4, 12, 4);
/*  84 */     this.rightarm.setRotationPoint(-6.0F, 0.0F, 0.0F);
/*  85 */     this.rightarm.setTextureSize(128, 128);
/*  86 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.3141593F);
/*  87 */     this.body = new ModelRenderer(this, 16, 16);
/*  88 */     this.body.addBox(-5.5F, 0.0F, -3.0F, 11, 6, 5);
/*  89 */     this.body.setRotationPoint(0.0F, -0.5F, -1.0F);
/*  90 */     this.body.setTextureSize(128, 128);
/*  91 */     setRotation(this.body, -0.4770567F, 0.0F, 0.0F);
/*  92 */     this.Shape4 = new ModelRenderer(this, 36, 91);
/*  93 */     this.Shape4.addBox(-10.0F, 0.0F, 0.0F, 20, 5, 6);
/*  94 */     this.Shape4.setRotationPoint(0.0F, -2.0F, -4.0F);
/*  95 */     this.Shape4.setTextureSize(128, 128);
/*  96 */     setRotation(this.Shape4, 0.1919862F, 0.0F, 0.0F);
/*  97 */     this.Shape2 = new ModelRenderer(this, 36, 79);
/*  98 */     this.Shape2.addBox(-4.5F, -1.0F, -3.0F, 9, 4, 6);
/*  99 */     this.Shape2.setRotationPoint(0.0F, 9.0F, -4.0F);
/* 100 */     this.Shape2.setTextureSize(128, 128);
/* 101 */     setRotation(this.Shape2, 0.2094395F, 0.0F, 0.0F);
/* 102 */     this.Shape1 = new ModelRenderer(this, 18, 28);
/* 103 */     this.Shape1.addBox(-3.5F, -3.466667F, -1.0F, 7, 7, 4);
/* 104 */     this.Shape1.setRotationPoint(0.0F, 6.0F, -5.0F);
/* 105 */     this.Shape1.setTextureSize(128, 128);
/* 106 */     setRotation(this.Shape1, -0.0523599F, 0.0F, 0.0F);
/* 107 */     this.Shape8 = new ModelRenderer(this, 46, 74);
/* 108 */     this.Shape8.addBox(-2.0F, 1.0F, 0.0F, 4, 4, 1);
/* 109 */     this.Shape8.setRotationPoint(0.0F, 10.0F, -7.0F);
/* 110 */     this.Shape8.setTextureSize(128, 128);
/* 111 */     setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
/* 112 */     this.Bodybase.addChild(this.Shape10);
/* 113 */     this.Bodybase.addChild(this.Shape3);
/* 114 */     this.Bodybase.addChild(this.leftleg);
/* 115 */     this.Bodybase.addChild(this.rightleg);
/* 116 */     this.Bodybase.addChild(this.leftarm);
/* 117 */     this.Bodybase.addChild(this.rightarm);
/* 118 */     this.Bodybase.addChild(this.body);
/* 119 */     this.Bodybase.addChild(this.Shape4);
/* 120 */     this.Bodybase.addChild(this.Shape2);
/* 121 */     this.Bodybase.addChild(this.Shape1);
/* 122 */     this.Bodybase.addChild(this.Shape8);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 127 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 128 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 129 */     this.HEAD.render(f5);
/* 130 */     this.Bodybase.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 135 */     model.rotateAngleX = x;
/* 136 */     model.rotateAngleY = y;
/* 137 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
/* 142 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
/* 143 */     this.HEAD.rotateAngleY = f3 / 57.295776F;
/* 144 */     this.HEAD.rotateAngleX = f4 / 57.295776F;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelKillerQueen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */