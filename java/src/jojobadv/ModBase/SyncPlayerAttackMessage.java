/*    */ package src.jojobadv.ModBase;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.World;
/*    */ import src.jojobadv.Entities.EntityOneStand;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SyncPlayerAttackMessage
/*    */   implements IMessage
/*    */ {
/*    */   public void fromBytes(ByteBuf buf) {}
/*    */   
/*    */   public void toBytes(ByteBuf buf) {}
/*    */   
/*    */   public static class Handler
/*    */     extends Object
/*    */     implements IMessageHandler<SyncPlayerAttackMessage, IMessage>
/*    */   {
/*    */     public IMessage onMessage(SyncPlayerAttackMessage message, MessageContext ctx) {
/* 29 */       EntityPlayerMP player = (ctx.getServerHandler()).playerEntity;
/* 30 */       World world = player.worldObj;
/* 31 */       if (!world.isRemote)
/*    */       {
/* 33 */         if (player != null) {
/*    */           
/* 35 */           ExtendedPlayerJojoBAdvProperties props = (ExtendedPlayerJojoBAdvProperties)player.getExtendedProperties("ExtendedPlayerJojoBAdvProperties");
/* 36 */           if (props != null)
/*    */           {
/* 38 */             if (props.getStandOn()) {
/*    */               
/* 40 */               List entityList = world.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(player.posX - 5.0D, player.posY - 5.0D, player.posZ - 5.0D, player.posX + 5.0D, player.posY + 5.0D, player.posZ + 5.0D));
/* 41 */               if (entityList != null && !entityList.isEmpty())
/*    */               {
/* 43 */                 for (int i = 0; i < entityList.size(); i++) {
/*    */                   
/* 45 */                   if (entityList.get(i) instanceof EntityOneStand) {
/*    */                     
/* 47 */                     EntityOneStand stand = (EntityOneStand)entityList.get(i);
/* 48 */                     if (stand.getMaster() == player) {
/*    */                       
/* 50 */                       stand.setAttackTrue(true);
/* 51 */                       return null;
/*    */                     } 
/*    */                   } 
/*    */                 } 
/*    */               }
/*    */             } 
/*    */           }
/*    */         } 
/*    */       }
/* 60 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/SyncPlayerAttackMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */