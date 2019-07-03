/*    */ package src.jojobadv.Items;
/*    */ 
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.Explosion;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockSF_zip
/*    */   extends BlockContainer
/*    */ {
/* 17 */   private int tick = 0;
/*    */   
/*    */   private TileEntityBlockZip tile;
/*    */   
/*    */   public BlockSF_zip() {
/* 22 */     super(Material.rock);
/* 23 */     setTickRandomly(true);
/* 24 */     setBlockTextureName("jojobadv:block_zip");
/* 25 */     setBlockName("block_zip");
/* 26 */     setHardness(-1.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 32 */   public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) { par5Entity.noClip = true; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 37 */   public void registerIcons(IIconRegister iconRegister) { this.blockIcon = iconRegister.registerIcon("jojo:zip"); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 42 */   public boolean canDropFromExplosion(Explosion par1Explosion) { return false; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 47 */   public boolean isOpaqueCube() { return false; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 52 */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) { return null; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TileEntity createNewTileEntity(World world, int par2) {
/* 58 */     this.tile = new TileEntityBlockZip(this);
/* 59 */     return this.tile;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 67 */   public boolean renderAsNormalBlock() { return false; }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/BlockSF_zip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */