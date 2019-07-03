/*    */ package src.jojobadv.Entities.Stands;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ import src.jojobadv.Entities.EntityOneStand;
/*    */ import src.jojobadv.Items.JojoBAdvItems;
/*    */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*    */ import src.jojobadv.ModBase.SoundEvents;
/*    */ 
/*    */ public class EntityEmperor
/*    */   extends EntityOneStand
/*    */ {
/*    */   public EntityEmperor(World par1World) {
/* 16 */     super(par1World);
/* 17 */     setSize(0.0F, 0.0F);
/* 18 */     this.spawnSound = SoundEvents.spawn_e.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void giveItems(EntityPlayer player) {
/* 24 */     if (player.getCurrentEquippedItem() != null)
/*    */     {
/* 26 */       player.entityDropItem(player.getCurrentEquippedItem(), 1.0F);
/*    */     }
/*    */     
/* 29 */     ItemStack emperor = new ItemStack(JojoBAdvItems.Emperor);
/* 30 */     player.setCurrentItemOrArmor(0, emperor);
/*    */   }
/*    */   
/* 33 */   private int tickSlow = 0;
/*    */ 
/*    */   
/*    */   public void onUpdate() {
/* 37 */     if (!this.worldObj.isRemote)
/*    */     {
/* 39 */       if (getMaster() != null) {
/*    */         
/* 41 */         fallowmaster();
/* 42 */         EntityPlayer player = getMaster();
/* 43 */         ItemStack stack = player.getCurrentEquippedItem();
/* 44 */         ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*    */         
/* 46 */         if (props.getStandOn()) {
/*    */           
/* 48 */           if (this.ticksExisted > 10)
/*    */           {
/* 50 */             if (stack == null)
/*    */             {
/* 52 */               props.setStandOn(false);
/*    */             }
/* 54 */             if (stack != null && stack.getItem() != JojoBAdvItems.Emperor)
/*    */             {
/* 56 */               props.setStandOn(false);
/*    */             }
/*    */           }
/*    */         
/* 60 */         } else if (!props.getStandOn()) {
/*    */           
/* 62 */           if (stack != null && stack.getItem() == JojoBAdvItems.Emperor)
/*    */           {
/* 64 */             player.destroyCurrentEquippedItem();
/*    */           }
/*    */         } 
/*    */         
/* 68 */         super.onUpdate();
/* 69 */         this.fallDistance = 0.0F;
/* 70 */         setPosition((getMaster()).posX, (getMaster()).posY - 2.0D, (getMaster()).posZ);
/*    */       }
/*    */       else {
/*    */         
/* 74 */         super.onUpdate();
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 81 */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { return false; }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityEmperor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */