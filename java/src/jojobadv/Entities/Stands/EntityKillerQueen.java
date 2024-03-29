/*    */ package src.jojobadv.Entities.Stands;
/*    */ 
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ import src.jojobadv.Entities.EntityOneStand;
/*    */ import src.jojobadv.ModBase.SoundEvents;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityKillerQueen
/*    */   extends EntityOneStand
/*    */ {
/* 15 */   private int atttick = 0;
/*    */   
/*    */   public EntityKillerQueen(World par1World) {
/* 18 */     super(par1World);
/* 19 */     this.spawnSound = "jojobadvmod:spawn_kq";
/* 20 */     setSize(1.0F, 2.7F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 25 */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { return false; }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate() {
/* 30 */     super.onUpdate();
/* 31 */     this.fallDistance = 0.0F;
/* 32 */     if (getMaster() != null) {
/*    */       
/* 34 */       getMaster().addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 40, 1));
/* 35 */       if (this.standOn) {
/*    */         
/* 37 */         fallowmaster();
/* 38 */         setRotationYawHead((getMaster()).rotationYaw);
/* 39 */         setRotation((getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*    */         
/* 41 */         if (attackSwing(getMaster())) {
/*    */           
/* 43 */           this.punchTick++;
/* 44 */           if (this.punchTick == 1) {
/*    */             
/* 46 */             this.worldObj.playSoundAtEntity(this, SoundEvents.last_ora.toString(), 1.0F, 0.8F / (this.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/* 47 */             EntityKillerQueen_punch entityarrow = new EntityKillerQueen_punch(this.worldObj, this, 2.0F);
/* 48 */             entityarrow.setIsCritical(true);
/* 49 */             this.worldObj.spawnEntityInWorld(entityarrow);
/*    */           } 
/*    */         } 
/*    */         
/* 53 */         if ((getMaster()).swingProgressInt == 0)
/*    */         {
/* 55 */           this.punchTick = 0; } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/* 60 */   private int punchTick = 0;
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityKillerQueen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */