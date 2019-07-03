/*    */ package src.jojobadv.ModBase;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.TickEvent;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import src.jojobadv.Entities.EntityVampirepower;
/*    */ import src.jojobadv.Items.JojoBAdvItems;
/*    */ 
/*    */ public class CommonTickHandler
/*    */ {
/* 12 */   private int tickSlow = 0;
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void itemTick(TickEvent.PlayerTickEvent event) {
/* 17 */     if (!event.player.worldObj.isRemote)
/*    */     {
/* 19 */       if (this.tickSlow == 20) {
/*    */         
/* 21 */         ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(event.player);
/* 22 */         InventoryPlayer playerInv = event.player.inventory;
/*    */         
/* 24 */         if (props.getJojoPower() != 0)
/*    */         {
/* 26 */           if (props.getSpawnedPower() == null || !props.getPowerSpawned()) {
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 31 */             EntityVampirepower entVampPower = new EntityVampirepower(event.player.worldObj);
/* 32 */             entVampPower.setLocationAndAngles(event.player.posX, event.player.posY, event.player.posZ, event.player.rotationYaw, event.player.rotationPitch);
/* 33 */             entVampPower.worldObj.spawnEntityInWorld(entVampPower);
/* 34 */             entVampPower.setMaster(event.player);
/* 35 */             entVampPower.setMasterName(event.player.getDisplayName());
/* 36 */             props.setPowerSpawned(true);
/*    */           } 
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 54 */         if (playerInv != null)
/*    */         {
/* 56 */           for (int i = 0; i < playerInv.mainInventory.length; i++) {
/*    */             
/* 58 */             ItemStack stack = playerInv.getStackInSlot(i);
/* 59 */             if (stack != null)
/*    */             {
/* 61 */               if (stack.getItem() == JojoBAdvItems.Emperor && stack != playerInv.getCurrentItem())
/*    */               {
/* 63 */                 JojoBAdvLib.destroyItemInSlot(playerInv, stack, i);
/*    */               }
/*    */             }
/*    */           } 
/* 67 */           this.tickSlow = 0;
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 72 */         this.tickSlow++;
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/CommonTickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */