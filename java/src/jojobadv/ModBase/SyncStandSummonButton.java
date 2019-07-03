/*     */ package src.jojobadv.ModBase;
/*     */ 
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.Items.ItemStandArrow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SyncStandSummonButton
/*     */   implements IMessage
/*     */ {
/*     */   public void fromBytes(ByteBuf buf) {}
/*     */   
/*     */   public void toBytes(ByteBuf buf) {}
/*     */   
/*     */   public static class Handler
/*     */     extends Object
/*     */     implements IMessageHandler<SyncStandSummonButton, IMessage>
/*     */   {
/*     */     public IMessage onMessage(SyncStandSummonButton message, MessageContext ctx) {
/*  38 */       EntityPlayerMP player = (ctx.getServerHandler()).playerEntity;
/*  39 */       World world = player.worldObj;
/*  40 */       if (!world.isRemote)
/*     */       {
/*  42 */         if (player != null) {
/*     */           
/*  44 */           ExtendedPlayerJojoBAdvProperties props = (ExtendedPlayerJojoBAdvProperties)player.getExtendedProperties("ExtendedPlayerJojoBAdvProperties");
/*  45 */           if (props != null) {
/*     */             
/*  47 */             int tickDelay = 0;
/*  48 */             for (int k = 0; k < 20; k++) {
/*     */ 
/*     */               
/*  51 */               tickDelay++;
/*  52 */               if (tickDelay == 20) {
/*     */                 
/*  54 */                 tickDelay = 0;
/*  55 */                 if (!player.isSneaking()) {
/*     */                   
/*  57 */                   boolean standCheck = props.getStandOn();
/*  58 */                   if (standCheck) {
/*     */                     
/*  60 */                     props.setStandOn(false);
/*  61 */                     return null;
/*     */                   } 
/*     */ 
/*     */                   
/*  65 */                   SyncStandSummonButton.summonStand(player);
/*  66 */                   return null;
/*     */                 } 
/*     */ 
/*     */ 
/*     */                 
/*  71 */                 List entityList = world.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(player.posX - 1.0D, player.posY - 1.0D, player.posZ - 1.0D, player.posX + 1.0D, player.posY + 1.0D, player.posZ + 1.0D));
/*  72 */                 if (entityList != null && !entityList.isEmpty())
/*     */                 {
/*  74 */                   for (int i = 0; i < entityList.size(); i++) {
/*     */                     
/*  76 */                     if (entityList.get(i) instanceof EntityOneStand) {
/*     */                       
/*  78 */                       EntityOneStand stand = (EntityOneStand)entityList.get(i);
/*  79 */                       if (stand.getMaster() == player)
/*     */                       {
/*  81 */                         if (stand.getCanChangeAct()) {
/*     */                           
/*  83 */                           stand.changeAct();
/*  84 */                           return null;
/*     */                         } 
/*     */                       }
/*     */                     } 
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/*  96 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void summonStand(EntityPlayer player) {
/* 102 */     ExtendedPlayerJojoBAdvProperties props = (ExtendedPlayerJojoBAdvProperties)player.getExtendedProperties("ExtendedPlayerJojoBAdvProperties");
/* 103 */     int standID = props.getPlayerStandID();
/* 104 */     EntityOneStand theStand = ItemStandArrow.getStand(standID, player.worldObj);
/* 105 */     if (theStand != null) {
/*     */       
/* 107 */       int standAct = props.getPlayerStandAct();
/* 108 */       props.setStandOn(true);
/* 109 */       theStand.setLocationAndAngles(player.posX + 0.1D, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);
/* 110 */       theStand.setMaster(player.getCommandSenderName());
/* 111 */       theStand.setMastername(player.getDisplayName());
/* 112 */       String name = props.getPlayerStandName();
/* 113 */       if (!name.equals(""))
/*     */       {
/* 115 */         theStand.setCustomNameTag(name);
/*     */       }
/* 117 */       player.worldObj.spawnEntityInWorld(theStand);
/* 118 */       theStand.giveItems(player);
/* 119 */       theStand.changeAct();
/* 120 */       theStand.bespawn();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/SyncStandSummonButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */