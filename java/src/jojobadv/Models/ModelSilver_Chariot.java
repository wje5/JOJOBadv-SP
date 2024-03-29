/*     */ package src.jojobadv.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class ModelSilver_Chariot
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Headbase;
/*     */   ModelRenderer Bodybase;
/*     */   private ModelRenderer Shape6;
/*     */   private ModelRenderer Shape5;
/*     */   private ModelRenderer Shape8;
/*     */   private ModelRenderer Shape9;
/*     */   private ModelRenderer Shape7;
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
/*     */   
/*     */   public ModelSilver_Chariot() {
/*  30 */     this.textureWidth = 128;
/*  31 */     this.textureHeight = 128;
/*     */     
/*  33 */     this.Headbase = new ModelRenderer(this, "Headbase");
/*  34 */     this.Headbase.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  35 */     setRotation(this.Headbase, 0.0F, 0.0F, 0.0F);
/*  36 */     this.Shape6 = new ModelRenderer(this, 42, 39);
/*  37 */     this.Shape6.addBox(-5.0F, -12.0F, -5.0F, 10, 9, 10);
/*  38 */     this.Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  39 */     this.Shape6.setTextureSize(128, 128);
/*  40 */     setRotation(this.Shape6, 0.2617994F, 0.0F, 0.0F);
/*  41 */     this.Shape5 = new ModelRenderer(this, 0, 0);
/*  42 */     this.Shape5.addBox(-4.0F, -11.0F, -4.0F, 8, 8, 8);
/*  43 */     this.Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  44 */     this.Shape5.setTextureSize(128, 128);
/*  45 */     setRotation(this.Shape5, 0.2617994F, 0.0F, 0.0F);
/*  46 */     this.Shape8 = new ModelRenderer(this, 37, 60);
/*  47 */     this.Shape8.addBox(-6.0F, -9.0F, -4.0F, 12, 5, 5);
/*  48 */     this.Shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  49 */     this.Shape8.setTextureSize(128, 128);
/*  50 */     this.Shape8.mirror = true;
/*  51 */     setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
/*  52 */     this.Headbase.addChild(this.Shape6);
/*  53 */     this.Headbase.addChild(this.Shape5);
/*  54 */     this.Headbase.addChild(this.Shape8);
/*     */     
/*  56 */     this.Bodybase = new ModelRenderer(this, "Bodybase");
/*  57 */     this.Bodybase.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  58 */     setRotation(this.Bodybase, 0.0F, 0.0F, 0.0F);
/*  59 */     this.Shape9 = new ModelRenderer(this, 0, 41);
/*  60 */     this.Shape9.addBox(-1.0F, -4.0F, -1.0F, 3, 3, 3);
/*  61 */     this.Shape9.setRotationPoint(9.0F, 7.0F, -9.0F);
/*  62 */     this.Shape9.setTextureSize(128, 128);
/*  63 */     setRotation(this.Shape9, 0.8179311F, 0.5204921F, -0.9294576F);
/*  64 */     this.Shape7 = new ModelRenderer(this, 0, 16);
/*  65 */     this.Shape7.addBox(0.0F, -23.0F, 0.0F, 1, 24, 1);
/*  66 */     this.Shape7.setRotationPoint(9.0F, 7.0F, -9.0F);
/*  67 */     this.Shape7.setTextureSize(128, 128);
/*  68 */     setRotation(this.Shape7, 0.8179294F, 0.5205006F, -0.9294653F);
/*  69 */     this.Shape10 = new ModelRenderer(this, 36, 103);
/*  70 */     this.Shape10.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
/*  71 */     this.Shape10.setRotationPoint(3.0F, 18.0F, -5.0F);
/*  72 */     this.Shape10.setTextureSize(128, 128);
/*  73 */     setRotation(this.Shape10, 0.5759587F, 0.0F, 0.0F);
/*  74 */     this.Shape3 = new ModelRenderer(this, 36, 103);
/*  75 */     this.Shape3.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
/*  76 */     this.Shape3.setRotationPoint(-3.0F, 18.0F, -2.0F);
/*  77 */     this.Shape3.setTextureSize(128, 128);
/*  78 */     setRotation(this.Shape3, 0.2792527F, 0.0F, 0.0F);
/*  79 */     this.leftleg = new ModelRenderer(this, 53, 103);
/*  80 */     this.leftleg.addBox(-1.5F, 0.0F, -2.0F, 4, 9, 4);
/*  81 */     this.leftleg.setRotationPoint(2.0F, 10.0F, -3.0F);
/*  82 */     this.leftleg.setTextureSize(128, 128);
/*  83 */     setRotation(this.leftleg, -0.1570796F, 0.0F, 0.0F);
/*  84 */     this.rightleg = new ModelRenderer(this, 53, 103);
/*  85 */     this.rightleg.addBox(-2.5F, 0.0F, -2.0F, 4, 9, 4);
/*  86 */     this.rightleg.setRotationPoint(-2.0F, 10.0F, -3.0F);
/*  87 */     this.rightleg.setTextureSize(128, 128);
/*  88 */     setRotation(this.rightleg, 0.1396263F, 0.0F, 0.0F);
/*  89 */     this.leftarm = new ModelRenderer(this, 67, 73);
/*  90 */     this.leftarm.addBox(0.0F, 1.0F, -3.0F, 4, 12, 4);
/*  91 */     this.leftarm.setRotationPoint(5.0F, 0.0F, 0.0F);
/*  92 */     this.leftarm.setTextureSize(128, 128);
/*  93 */     this.leftarm.mirror = true;
/*  94 */     setRotation(this.leftarm, -0.669215F, 0.0F, -0.3141593F);
/*  95 */     this.rightarm = new ModelRenderer(this, 67, 73);
/*  96 */     this.rightarm.addBox(-3.0F, 1.0F, -2.0F, 4, 12, 4);
/*  97 */     this.rightarm.setRotationPoint(-6.0F, 0.0F, 0.0F);
/*  98 */     this.rightarm.setTextureSize(128, 128);
/*  99 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.3141593F);
/* 100 */     this.body = new ModelRenderer(this, 16, 16);
/* 101 */     this.body.addBox(-5.5F, 0.0F, -3.0F, 11, 6, 5);
/* 102 */     this.body.setRotationPoint(0.0F, -0.5F, -1.0F);
/* 103 */     this.body.setTextureSize(128, 128);
/* 104 */     setRotation(this.body, -0.4770567F, 0.0F, 0.0F);
/* 105 */     this.Shape4 = new ModelRenderer(this, 36, 91);
/* 106 */     this.Shape4.addBox(-10.0F, 0.0F, 0.0F, 20, 5, 6);
/* 107 */     this.Shape4.setRotationPoint(0.0F, -2.0F, -4.0F);
/* 108 */     this.Shape4.setTextureSize(128, 128);
/* 109 */     setRotation(this.Shape4, 0.1919862F, 0.1745329F, 0.0F);
/* 110 */     this.Shape2 = new ModelRenderer(this, 36, 79);
/* 111 */     this.Shape2.addBox(-4.5F, -1.0F, -3.0F, 9, 4, 6);
/* 112 */     this.Shape2.setRotationPoint(0.0F, 9.0F, -4.0F);
/* 113 */     this.Shape2.setTextureSize(128, 128);
/* 114 */     setRotation(this.Shape2, 0.2094395F, 0.0F, 0.0F);
/* 115 */     this.Shape1 = new ModelRenderer(this, 18, 28);
/* 116 */     this.Shape1.addBox(-3.5F, -3.466667F, -1.0F, 7, 7, 4);
/* 117 */     this.Shape1.setRotationPoint(0.0F, 6.0F, -5.0F);
/* 118 */     this.Shape1.setTextureSize(128, 128);
/* 119 */     setRotation(this.Shape1, -0.0523599F, 0.0F, 0.0F);
/* 120 */     this.Bodybase.addChild(this.Shape9);
/* 121 */     this.Bodybase.addChild(this.Shape7);
/* 122 */     this.Bodybase.addChild(this.Shape10);
/* 123 */     this.Bodybase.addChild(this.leftleg);
/* 124 */     this.Bodybase.addChild(this.rightleg);
/* 125 */     this.Bodybase.addChild(this.leftarm);
/* 126 */     this.Bodybase.addChild(this.rightarm);
/* 127 */     this.Bodybase.addChild(this.body);
/* 128 */     this.Bodybase.addChild(this.Shape1);
/* 129 */     this.Bodybase.addChild(this.Shape2);
/* 130 */     this.Bodybase.addChild(this.Shape4);
/* 131 */     this.Bodybase.addChild(this.Shape3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 136 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 137 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 138 */     this.Headbase.render(f5);
/* 139 */     this.Bodybase.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 144 */     model.rotateAngleX = x;
/* 145 */     model.rotateAngleY = y;
/* 146 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
/* 151 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
/* 152 */     this.Headbase.rotateAngleY = f3 / 57.295776F;
/* 153 */     this.Headbase.rotateAngleX = f4 / 57.295776F;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Models/ModelSilver_Chariot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */