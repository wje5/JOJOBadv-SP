/*    */ package src.jojobadv.Entities.Stands;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityBomb
/*    */   extends Entity {
/* 11 */   protected Entity owner = null;
/*    */ 
/*    */   
/* 14 */   public EntityBomb(World par1World) { super(par1World); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 19 */   public void setOwner(Entity par1) { this.owner = par1; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   public Entity getOwner() { return this.owner; }
/*    */ 
/*    */ 
/*    */   
/*    */   public void selfex() {
/* 30 */     if (!this.worldObj.isRemote) {
/*    */       
/* 32 */       setDead();
/* 33 */       this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2.0F, true);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void inex() {
/* 39 */     if (!this.worldObj.isRemote) {
/*    */       
/* 41 */       if (!this.worldObj.isRemote && this.owner != null)
/*    */       {
/* 43 */         if (this.owner instanceof EntityLivingBase) {
/*    */           
/* 45 */           this.owner.attackEntityFrom(DamageSource.magic, 20.0F);
/* 46 */           ((EntityLivingBase)this.owner).setHealth(0.0F);
/*    */         } 
/*    */       }
/* 49 */       setDead();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onUpdate() {
/* 54 */     if (!this.worldObj.isRemote && this.owner != null)
/*    */     {
/* 56 */       setPosition(this.owner.posX, this.owner.posY, this.owner.posZ);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void entityInit() {}
/*    */   
/*    */   protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {}
/*    */   
/*    */   protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {}
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityBomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */