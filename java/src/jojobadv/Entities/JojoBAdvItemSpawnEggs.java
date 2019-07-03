/*     */ package src.jojobadv.Entities;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JojoBAdvItemSpawnEggs
/*     */   extends Item
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon theIcon;
/*     */   
/*     */   public JojoBAdvItemSpawnEggs() {
/*  34 */     setHasSubtypes(true);
/*  35 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*  36 */     setUnlocalizedName("monsterPlacer");
/*  37 */     setTextureName("spawn_egg");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getItemStackDisplayName(ItemStack itemStack) {
/*  42 */     String s = ("" + StatCollector.translateToLocal(getUnlocalizedName() + ".name")).trim();
/*  43 */     String s1 = JojoBAdvEntityList.getStringFromID(itemStack.getItemDamage());
/*     */     
/*  45 */     if (s1 != null)
/*     */     {
/*  47 */       s = s + " " + StatCollector.translateToLocal(s1);
/*     */     }
/*     */     
/*  50 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getColorFromItemStack(ItemStack itemStack, int p_82790_2_) {
/*  56 */     JojoBAdvEntityList.EntityEggInfo entityegginfo = (JojoBAdvEntityList.EntityEggInfo)JojoBAdvEntityList.entityEggs.get(Integer.valueOf(itemStack.getItemDamage()));
/*  57 */     return (entityegginfo != null) ? ((p_82790_2_ == 0) ? entityegginfo.primaryColour : entityegginfo.secondaryColour) : 16777215;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  66 */     if (world.isRemote)
/*     */     {
/*  68 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  72 */     Block block = world.getBlock(x, y, z);
/*  73 */     x += Facing.offsetsXForSide[p_77648_7_];
/*  74 */     y += Facing.offsetsYForSide[p_77648_7_];
/*  75 */     z += Facing.offsetsZForSide[p_77648_7_];
/*  76 */     double d0 = 0.0D;
/*     */     
/*  78 */     if (p_77648_7_ == 1 && block.getRenderType() == 11)
/*     */     {
/*  80 */       d0 = 0.5D;
/*     */     }
/*     */     
/*  83 */     Entity entity = spawnCreature(world, itemStack.getItemDamage(), x + 0.5D, y + d0, z + 0.5D);
/*     */     
/*  85 */     if (entity != null) {
/*     */       
/*  87 */       if (entity instanceof net.minecraft.entity.EntityLivingBase && itemStack.hasDisplayName())
/*     */       {
/*  89 */         ((EntityLiving)entity).setCustomNameTag(itemStack.getDisplayName());
/*     */       }
/*     */       
/*  92 */       if (!player.capabilities.isCreativeMode)
/*     */       {
/*  94 */         itemStack.stackSize--;
/*     */       }
/*     */     } 
/*     */     
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
/* 107 */     if (world.isRemote)
/*     */     {
/* 109 */       return itemStack;
/*     */     }
/*     */ 
/*     */     
/* 113 */     MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, player, true);
/*     */     
/* 115 */     if (movingobjectposition == null)
/*     */     {
/* 117 */       return itemStack;
/*     */     }
/*     */ 
/*     */     
/* 121 */     if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/* 123 */       int i = movingobjectposition.blockX;
/* 124 */       int j = movingobjectposition.blockY;
/* 125 */       int k = movingobjectposition.blockZ;
/*     */       
/* 127 */       if (!world.canMineBlock(player, i, j, k))
/*     */       {
/* 129 */         return itemStack;
/*     */       }
/*     */       
/* 132 */       if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack))
/*     */       {
/* 134 */         return itemStack;
/*     */       }
/*     */       
/* 137 */       if (world.getBlock(i, j, k) instanceof net.minecraft.block.BlockLiquid) {
/*     */         
/* 139 */         Entity entity = spawnCreature(world, itemStack.getItemDamage(), i, j, k);
/*     */         
/* 141 */         if (entity != null) {
/*     */           
/* 143 */           if (entity instanceof net.minecraft.entity.EntityLivingBase && itemStack.hasDisplayName())
/*     */           {
/* 145 */             ((EntityLiving)entity).setCustomNameTag(itemStack.getDisplayName());
/*     */           }
/*     */           
/* 148 */           if (!player.capabilities.isCreativeMode)
/*     */           {
/* 150 */             itemStack.stackSize--;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 156 */     return itemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World world, int entityID, double x, double y, double z) {
/* 167 */     if (!JojoBAdvEntityList.entityEggs.containsKey(Integer.valueOf(entityID)))
/*     */     {
/* 169 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 173 */     Entity entity = null;
/*     */     
/* 175 */     for (int j = 0; j < 1; j++) {
/*     */       
/* 177 */       entity = JojoBAdvEntityList.createEntityByID(entityID, world);
/*     */       
/* 179 */       if (entity != null && entity instanceof net.minecraft.entity.EntityLivingBase) {
/*     */         
/* 181 */         EntityLiving entityliving = (EntityLiving)entity;
/* 182 */         entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
/* 183 */         entityliving.rotationYawHead = entityliving.rotationYaw;
/* 184 */         entityliving.renderYawOffset = entityliving.rotationYaw;
/* 185 */         entityliving.onSpawnWithEgg((IEntityLivingData)null);
/* 186 */         world.spawnEntityInWorld(entity);
/* 187 */         entityliving.playLivingSound();
/*     */       } 
/*     */     } 
/*     */     
/* 191 */     return entity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 198 */   public boolean requiresMultipleRenderPasses() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 207 */   public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_) { return (p_77618_2_ > 0) ? this.theIcon : super.getIconFromDamageForRenderPass(p_77618_1_, p_77618_2_); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void getSubItems(Item item, CreativeTabs creativeTab, List par3List) {
/* 216 */     Iterator iterator = JojoBAdvEntityList.entityEggs.values().iterator();
/*     */     
/* 218 */     while (iterator.hasNext()) {
/*     */       
/* 220 */       JojoBAdvEntityList.EntityEggInfo entityegginfo = (JojoBAdvEntityList.EntityEggInfo)iterator.next();
/* 221 */       par3List.add(new ItemStack(item, 1, entityegginfo.spawnedID));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister icon) {
/* 228 */     super.registerIcons(icon);
/* 229 */     this.theIcon = icon.registerIcon(getIconString() + "_overlay");
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/JojoBAdvItemSpawnEggs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */