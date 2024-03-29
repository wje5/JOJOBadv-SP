/*     */ package src.jojobadv.Items;
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
/*     */ import src.jojobadv.Entities.JojoBAdvEntityList;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemJojoSpawnEggs
/*     */   extends Item
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon theIcon;
/*     */   
/*     */   public ItemJojoSpawnEggs() {
/*  35 */     setHasSubtypes(true);
/*  36 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*  37 */     setUnlocalizedName("monsterPlacer");
/*  38 */     setTextureName("spawn_egg");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getItemStackDisplayName(ItemStack itemStack) {
/*  43 */     String s = ("" + StatCollector.translateToLocal(getUnlocalizedName() + ".name")).trim();
/*  44 */     String s1 = JojoBAdvEntityList.getStringFromID(itemStack.getItemDamage());
/*     */     
/*  46 */     if (s1 != null)
/*     */     {
/*  48 */       s = s + " " + StatCollector.translateToLocal(s1);
/*     */     }
/*     */     
/*  51 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getColorFromItemStack(ItemStack itemStack, int p_82790_2_) {
/*  57 */     JojoBAdvEntityList.EntityEggInfo entityegginfo = (JojoBAdvEntityList.EntityEggInfo)JojoBAdvEntityList.entityEggs.get(Integer.valueOf(itemStack.getItemDamage()));
/*  58 */     return (entityegginfo != null) ? ((p_82790_2_ == 0) ? entityegginfo.primaryColour : entityegginfo.secondaryColour) : 16777215;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  67 */     if (world.isRemote)
/*     */     {
/*  69 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  73 */     Block block = world.getBlock(x, y, z);
/*  74 */     x += Facing.offsetsXForSide[p_77648_7_];
/*  75 */     y += Facing.offsetsYForSide[p_77648_7_];
/*  76 */     z += Facing.offsetsZForSide[p_77648_7_];
/*  77 */     double d0 = 0.0D;
/*     */     
/*  79 */     if (p_77648_7_ == 1 && block.getRenderType() == 11)
/*     */     {
/*  81 */       d0 = 0.5D;
/*     */     }
/*     */     
/*  84 */     Entity entity = spawnCreature(world, itemStack.getItemDamage(), x + 0.5D, y + d0, z + 0.5D);
/*     */     
/*  86 */     if (entity != null) {
/*     */       
/*  88 */       if (entity instanceof net.minecraft.entity.EntityLivingBase && itemStack.hasDisplayName())
/*     */       {
/*  90 */         ((EntityLiving)entity).setCustomNameTag(itemStack.getDisplayName());
/*     */       }
/*     */       
/*  93 */       if (!player.capabilities.isCreativeMode)
/*     */       {
/*  95 */         itemStack.stackSize--;
/*     */       }
/*     */     } 
/*     */     
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
/* 108 */     if (world.isRemote)
/*     */     {
/* 110 */       return itemStack;
/*     */     }
/*     */ 
/*     */     
/* 114 */     MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, player, true);
/*     */     
/* 116 */     if (movingobjectposition == null)
/*     */     {
/* 118 */       return itemStack;
/*     */     }
/*     */ 
/*     */     
/* 122 */     if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/* 124 */       int i = movingobjectposition.blockX;
/* 125 */       int j = movingobjectposition.blockY;
/* 126 */       int k = movingobjectposition.blockZ;
/*     */       
/* 128 */       if (!world.canMineBlock(player, i, j, k))
/*     */       {
/* 130 */         return itemStack;
/*     */       }
/*     */       
/* 133 */       if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack))
/*     */       {
/* 135 */         return itemStack;
/*     */       }
/*     */       
/* 138 */       if (world.getBlock(i, j, k) instanceof net.minecraft.block.BlockLiquid) {
/*     */         
/* 140 */         Entity entity = spawnCreature(world, itemStack.getItemDamage(), i, j, k);
/*     */         
/* 142 */         if (entity != null) {
/*     */           
/* 144 */           if (entity instanceof net.minecraft.entity.EntityLivingBase && itemStack.hasDisplayName())
/*     */           {
/* 146 */             ((EntityLiving)entity).setCustomNameTag(itemStack.getDisplayName());
/*     */           }
/*     */           
/* 149 */           if (!player.capabilities.isCreativeMode)
/*     */           {
/* 151 */             itemStack.stackSize--;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     return itemStack;
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
/* 168 */     if (!JojoBAdvEntityList.entityEggs.containsKey(Integer.valueOf(entityID)))
/*     */     {
/* 170 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 174 */     Entity entity = null;
/*     */     
/* 176 */     for (int j = 0; j < 1; j++) {
/*     */       
/* 178 */       entity = JojoBAdvEntityList.createEntityByID(entityID, world);
/*     */       
/* 180 */       if (entity != null && entity instanceof net.minecraft.entity.EntityLivingBase) {
/*     */         
/* 182 */         EntityLiving entityliving = (EntityLiving)entity;
/* 183 */         entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
/* 184 */         entityliving.rotationYawHead = entityliving.rotationYaw;
/* 185 */         entityliving.renderYawOffset = entityliving.rotationYaw;
/* 186 */         entityliving.onSpawnWithEgg((IEntityLivingData)null);
/* 187 */         world.spawnEntityInWorld(entity);
/* 188 */         entityliving.playLivingSound();
/*     */       } 
/*     */     } 
/*     */     
/* 192 */     return entity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 199 */   public boolean requiresMultipleRenderPasses() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 208 */   public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_) { return (p_77618_2_ > 0) ? this.theIcon : super.getIconFromDamageForRenderPass(p_77618_1_, p_77618_2_); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void getSubItems(Item item, CreativeTabs creativeTab, List par3List) {
/* 217 */     Iterator iterator = JojoBAdvEntityList.entityEggs.values().iterator();
/*     */     
/* 219 */     while (iterator.hasNext()) {
/*     */       
/* 221 */       JojoBAdvEntityList.EntityEggInfo entityegginfo = (JojoBAdvEntityList.EntityEggInfo)iterator.next();
/* 222 */       par3List.add(new ItemStack(item, 1, entityegginfo.spawnedID));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister icon) {
/* 229 */     super.registerIcons(icon);
/* 230 */     this.theIcon = icon.registerIcon(getIconString() + "_overlay");
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemJojoSpawnEggs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */