/*     */ package src.jojobadv.ModBase;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraftforge.event.entity.EntityEvent;
/*     */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*     */ import net.minecraftforge.event.entity.item.ItemTossEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*     */ import src.jojobadv.Items.JojoBAdvItems;
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
/*     */ public class EventHandlerJojoBAdv
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onEntityConstructing(EntityEvent.EntityConstructing event) {
/*  33 */     if (event.entity instanceof EntityPlayer) {
/*     */       
/*  35 */       ExtendedPlayerJojoBAdvProperties.register((EntityPlayer)event.entity);
/*  36 */       ExtendedPlayerJojoBAdvProperties.get((EntityPlayer)event.entity).setPowerSpawned(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onEntitySpawn(EntityJoinWorldEvent evt) {
/*  43 */     if (evt.entity instanceof EntityMob) {
/*     */       
/*  45 */       EntityMob zomb = (EntityMob)evt.entity;
/*  46 */       zomb.tasks.addTask(1, new EntityAIAvoidEntity(zomb, src.jojobadv.Entities.EntityVampirepower.class, 30.0F, 0.6D, 0.6D));
/*  47 */       zomb.tasks.addTask(3, new EntityAIAttackOnCollide(zomb, src.jojobadv.Entities.Entityhamonuser.class, 1.0D, true));
/*  48 */       zomb.targetTasks.addTask(2, new EntityAINearestAttackableTarget(zomb, src.jojobadv.Entities.Entityhamonuser.class, 0, false));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerUpdate(TickEvent.PlayerTickEvent event) {
/*  56 */     EntityPlayer player = event.player;
/*  57 */     player.onLivingUpdate();
/*  58 */     player.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onClonePlayer(PlayerEvent.Clone event) {
/*  64 */     if (!event.wasDeath) {
/*     */       
/*  66 */       NBTTagCompound compound = new NBTTagCompound();
/*  67 */       ExtendedPlayerJojoBAdvProperties.get(event.original).saveNBTData(compound);
/*  68 */       ExtendedPlayerJojoBAdvProperties.get(event.entityPlayer).loadNBTData(compound);
/*     */     }
/*  70 */     else if (event.wasDeath) {
/*     */       
/*  72 */       if (JojoBAdvConfig.saveStandOnDeath) {
/*     */         
/*  74 */         NBTTagCompound compound = new NBTTagCompound();
/*  75 */         ExtendedPlayerJojoBAdvProperties.get(event.original).saveNBTData(compound);
/*  76 */         ExtendedPlayerJojoBAdvProperties.get(event.entityPlayer).loadNBTData(compound);
/*  77 */         if (!JojoBAdvConfig.savePowerOnDeath)
/*     */         {
/*  79 */           ExtendedPlayerJojoBAdvProperties.get(event.entityPlayer).setJojoPower(0);
/*     */         }
/*     */       }
/*  82 */       else if (JojoBAdvConfig.savePowerOnDeath) {
/*     */         
/*  84 */         NBTTagCompound compound = new NBTTagCompound();
/*  85 */         ExtendedPlayerJojoBAdvProperties.get(event.original).saveNBTData(compound);
/*  86 */         ExtendedPlayerJojoBAdvProperties.get(event.entityPlayer).loadNBTData(compound);
/*  87 */         ExtendedPlayerJojoBAdvProperties.get(event.entityPlayer).setStandRemoved();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onItemDropped(ItemTossEvent event) {
/*  95 */     EntityItem itemEnt = event.entityItem;
/*  96 */     EntityPlayer player = event.player;
/*  97 */     if (player != null && itemEnt != null) {
/*     */       
/*  99 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 100 */       if (itemEnt.getEntityItem().getItem() == JojoBAdvItems.Emperor) {
/*     */         
/* 102 */         itemEnt.setDead();
/* 103 */         if (props.getPlayerStandID() == 5) {
/*     */           
/* 105 */           props.setStandOn(false);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/EventHandlerJojoBAdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */