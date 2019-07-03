/*    */ package src.jojobadv.ModBase;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*    */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*    */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*    */ import net.minecraft.entity.monster.EntityMob;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*    */ import net.minecraftforge.event.entity.living.LivingEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventMobtarget
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onEntitySpawn(EntityJoinWorldEvent evt) {
/* 24 */     if (evt.entity instanceof EntityMob) {
/*    */       
/* 26 */       EntityMob zomb = (EntityMob)evt.entity;
/* 27 */       zomb.tasks.addTask(1, new EntityAIAvoidEntity(zomb, src.jojobadv.Entities.EntityVampirepower.class, 30.0F, 0.6D, 0.6D));
/* 28 */       zomb.tasks.addTask(3, new EntityAIAttackOnCollide(zomb, src.jojobadv.Entities.Entityhamonuser.class, 1.0D, true));
/* 29 */       zomb.targetTasks.addTask(2, new EntityAINearestAttackableTarget(zomb, src.jojobadv.Entities.Entityhamonuser.class, 0, false));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEntity(LivingEvent evt) {
/* 36 */     double d0 = evt.entity.posY + evt.entity.getEyeHeight();
/* 37 */     int i = MathHelper.floor_double(evt.entity.posX);
/* 38 */     int j = MathHelper.floor_double(evt.entity.posY);
/* 39 */     int k = MathHelper.floor_double(evt.entity.posZ);
/* 40 */     Block a = evt.entity.worldObj.getBlock(i, j - 1, k);
/* 41 */     Block b = evt.entity.worldObj.getBlock(i, j, k);
/*    */ 
/*    */ 
/*    */     
/* 45 */     evt.entity.noClip = false;
/* 46 */     if (evt.entity instanceof EntityPlayer && !((EntityPlayer)evt.entity).capabilities.isCreativeMode)
/*    */     {
/* 48 */       ((EntityPlayer)evt.entity).capabilities.disableDamage = false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/EventMobtarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */