/*    */ package src.jojobadv.Entities;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ 
/*    */ 
/*    */ public class EntityJojoAISit
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityTameable theEntity;
/*    */   private boolean isSitting;
/*    */   private static final String __OBFID = "CL_00001613";
/*    */   
/*    */   public EntityJojoAISit(EntityTameable p_i1654_1_) {
/* 16 */     this.theEntity = p_i1654_1_;
/* 17 */     setMutexBits(5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 25 */     if (!this.theEntity.isTamed())
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if (this.theEntity.isInWater())
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!this.theEntity.onGround)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 39 */     EntityLivingBase entitylivingbase = this.theEntity.getOwner();
/* 40 */     if (entitylivingbase != null)
/*    */     {
/* 42 */       return (entitylivingbase.getAITarget() != null) ? false : this.isSitting;
/*    */     }
/* 44 */     return this.isSitting;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void startExecuting() {
/* 53 */     this.theEntity.getNavigator().clearPathEntity();
/* 54 */     this.theEntity.setSitting(true);
/* 55 */     this.theEntity.setSneaking(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void resetTask() {
/* 63 */     this.theEntity.setSitting(false);
/* 64 */     this.theEntity.setSneaking(false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 72 */   public void setSitting(boolean p_75270_1_) { this.isSitting = p_75270_1_; }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/EntityJojoAISit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */