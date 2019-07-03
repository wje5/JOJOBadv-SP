/*    */ package src.jojobadv.Entities;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*    */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*    */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*    */ import net.minecraft.entity.ai.EntityAISwimming;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityDiavolo
/*    */   extends EntityCreature
/*    */ {
/* 18 */   private int tick = 0;
/*    */   
/*    */   public EntityDiavolo(World par1World) {
/* 21 */     super(par1World);
/* 22 */     setSize(0.6F, 1.8F);
/* 23 */     getNavigator().setBreakDoors(true);
/* 24 */     getNavigator().setAvoidsWater(true);
/* 25 */     this.tasks.addTask(0, new EntityAISwimming(this));
/* 26 */     this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityPlayer.class, 8.0F, 0.8D, 0.8D));
/* 27 */     this.tasks.addTask(1, new EntityAIAvoidEntity(this, net.minecraft.entity.monster.EntityMob.class, 8.0F, 0.8D, 0.8D));
/* 28 */     this.tasks.addTask(2, new EntityAIMoveIndoors(this));
/* 29 */     this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
/*    */   }
/*    */   
/*    */   public void onUpdate() {
/* 33 */     super.onUpdate();
/* 34 */     setHealth(9999.0F);
/* 35 */     if (this.tick <= 1)
/*    */     {
/* 37 */       this.tick++;
/*    */     }
/* 39 */     if (this.tick == 1)
/*    */     {
/* 41 */       this.worldObj.playSoundAtEntity(this, "jojo:di_", 2.0F, 1.0F);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void applyEntityAttributes() {
/* 46 */     super.applyEntityAttributes();
/* 47 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(9999.0D);
/* 48 */     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(13.0D);
/* 49 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
/*    */   }
/*    */ 
/*    */   
/* 53 */   protected boolean isAIEnabled() { return true; }
/*    */ 
/*    */ 
/*    */   
/* 57 */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) { super.writeEntityToNBT(par1NBTTagCompound); }
/*    */ 
/*    */ 
/*    */   
/* 61 */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) { super.readEntityFromNBT(par1NBTTagCompound); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 66 */   protected void entityInit() { super.entityInit(); }
/*    */ 
/*    */ 
/*    */   
/* 70 */   public int getTotalArmorValue() { return 999; }
/*    */ 
/*    */ 
/*    */   
/* 74 */   protected boolean canDespawn() { return false; }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 79 */     super.attackEntityFrom(par1DamageSource, par2);
/* 80 */     if (par1DamageSource.getEntity() instanceof EntityPlayer)
/*    */     {
/* 82 */       ((EntityPlayer)par1DamageSource.getEntity()).addChatMessage(new ChatComponentText(par1DamageSource.damageType + " : " + par2));
/*    */     }
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/EntityDiavolo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */