/*    */ package src.jojobadv.Items;
/*    */ 
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import src.jojobadv.Entities.Stands.EntityStickyFingers;
/*    */ import src.jojobadv.ModBase.SoundEvents;
/*    */ 
/*    */ public class TileEntityBlockZip
/*    */   extends TileEntity {
/*  9 */   private int tick = 0;
/*    */   
/*    */   public EntityStickyFingers stand;
/*    */   
/*    */   private BlockSF_zip block;
/*    */   
/* 15 */   public TileEntityBlockZip(BlockSF_zip blockSF_zip) { this.block = blockSF_zip; }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateEntity() {
/* 20 */     super.updateEntity();
/* 21 */     this.tick++;
/* 22 */     if (this.tick == 100 && !this.worldObj.isRemote)
/*    */     {
/* 24 */       zipDown();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void zipDown() {
/* 30 */     this.worldObj.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, SoundEvents.zipdown.toString(), 1.0F, 1.0F);
/* 31 */     this.block.breakBlock(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.block, this.blockMetadata);
/* 32 */     this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
/* 33 */     this.worldObj.removeTileEntity(this.xCoord, this.yCoord, this.zCoord);
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/TileEntityBlockZip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */