/*    */ package src.jojobadv.ModBase;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JojoBAdvLib
/*    */ {
/*    */   public static final String modid = "jojobadv";
/*    */   public static final String name = "Steve's Bizarre Adventure";
/*    */   public static final String version = "0.2.4";
/*    */   public static final String clientProxy = "src.jojobadv.ModBase.ClientProxy";
/*    */   public static final String commonProxy = "src.jojobadv.ModBase.CommonProxy";
/*    */   
/*    */   public static void destroyItemInSlot(IInventory iInventory, ItemStack stack, int slot) {
/* 24 */     ItemStack orig = stack;
/* 25 */     iInventory.setInventorySlotContents(slot, (ItemStack)null);
/* 26 */     if (iInventory instanceof InventoryPlayer) {
/*    */       
/* 28 */       InventoryPlayer invPlayer = (InventoryPlayer)iInventory;
/* 29 */       MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(invPlayer.player, orig));
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class JojoPowers
/*    */   {
/* 35 */     public static int Vampire = 1;
/* 36 */     public static int Hamon = 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean enderCore = false;
/*    */ 
/*    */   
/* 43 */   public static void setEnderCore(boolean value) { enderCore = value; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   public static boolean getEnderCore() { return enderCore; }
/*    */ 
/*    */ 
/*    */   
/*    */   public static MovingObjectPosition getPlayerRayTrace(EntityPlayer player, double par1Double, float par2Float) {
/* 54 */     Vec3 vec3 = getPlayerPosition(player, par2Float);
/* 55 */     Vec3 vec31 = getPlayerLook(player, par2Float);
/* 56 */     Vec3 vec32 = vec3.addVector(vec31.xCoord * par1Double, vec31.yCoord * par1Double, vec31.zCoord * par1Double);
/* 57 */     return player.worldObj.func_147447_a(vec3, vec32, false, false, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Vec3 getPlayerPosition(EntityPlayer player, float par2Float) {
/* 62 */     if (par2Float == 1.0F)
/*    */     {
/* 64 */       return Vec3.createVectorHelper(player.posX, player.posY + 0.1D, player.posZ);
/*    */     }
/*    */ 
/*    */     
/* 68 */     double d0 = player.prevPosX + (player.posX - player.prevPosX) * par2Float;
/* 69 */     double d1 = 1.0D + player.prevPosY + (player.posY - player.prevPosY) * par2Float;
/* 70 */     double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * par2Float;
/* 71 */     return Vec3.createVectorHelper(d0, d1, d2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Vec3 getPlayerLook(EntityPlayer player, float par2Float) {
/* 82 */     if (par2Float == 1.0F) {
/*    */       
/* 84 */       float f1 = MathHelper.cos(-player.rotationYaw * 0.017453292F - 3.1415927F);
/* 85 */       float f2 = MathHelper.sin(-player.rotationYaw * 0.017453292F - 3.1415927F);
/* 86 */       float f3 = -MathHelper.cos(-player.rotationPitch * 0.017453292F);
/* 87 */       float f4 = MathHelper.sin(-player.rotationPitch * 0.017453292F);
/* 88 */       return Vec3.createVectorHelper((f2 * f3), f4, (f1 * f3));
/*    */     } 
/*    */ 
/*    */     
/* 92 */     float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * par2Float;
/* 93 */     float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * par2Float;
/* 94 */     float f3 = MathHelper.cos(-f2 * 0.017453292F - 3.1415927F);
/* 95 */     float f4 = MathHelper.sin(-f2 * 0.017453292F - 3.1415927F);
/* 96 */     float f5 = -MathHelper.cos(-f1 * 0.017453292F);
/* 97 */     float f6 = MathHelper.sin(-f1 * 0.017453292F);
/* 98 */     return Vec3.createVectorHelper((f4 * f5), f6, (f3 * f5));
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/JojoBAdvLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */