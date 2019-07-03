/*    */ package src.jojobadv.ModBase;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.InputEvent;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventControlInputs
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onInput(InputEvent event) {
/* 17 */     if (JojoBAdvKeyHandler.keys[0].isPressed()) {
/*    */       
/* 19 */       EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
/* 20 */       if (entityClientPlayerMP != null)
/*    */       {
/* 22 */         JojoBAdv.snw.sendToServer(new SyncStandSummonButton());
/*    */       }
/*    */     } 
/*    */     
/* 26 */     if ((Minecraft.getMinecraft()).gameSettings.isKeyDown((Minecraft.getMinecraft()).gameSettings.keyBindAttack)) {
/*    */       
/* 28 */       EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
/* 29 */       if (entityClientPlayerMP != null)
/*    */       {
/* 31 */         JojoBAdv.snw.sendToServer(new SyncPlayerAttackMessage());
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/EventControlInputs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */