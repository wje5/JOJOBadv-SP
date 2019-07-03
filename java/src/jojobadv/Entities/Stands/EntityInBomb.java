/*    */ package src.jojobadv.Entities.Stands;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityInBomb
/*    */   extends EntityBomb
/*    */ {
/*    */   public static EntityPlayer player;
/*    */   
/*    */   public EntityInBomb(World par1World) {
/* 16 */     super(par1World);
/* 17 */     setSize(0.1F, 0.1F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUpdate() {
/* 22 */     super.onUpdate();
/* 23 */     Entity entity = null;
/* 24 */     for (int i1 = 0; i1 < this.worldObj.loadedEntityList.size(); i1++) {
/*    */       
/* 26 */       Entity entityplayer1 = (Entity)this.worldObj.loadedEntityList.get(i1);
/* 27 */       double dst = entityplayer1.getDistanceSq(this.posX, this.posY, this.posZ);
/* 28 */       entity = entityplayer1;
/* 29 */        if (!this.worldObj.isRemote && entity != player && entity != this.owner && entity instanceof net.minecraft.entity.EntityLivingBase && dst <= 2.0D) {
/*    */         
/* 31 */         entityplayer1.setFire(1);
/* 32 */         entityplayer1.hurtResistantTime = 10;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityInBomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */