/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.ModBase.ClientProxy;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.JojoBAdvLib;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemStoneMask
/*     */   extends ItemArmor
/*     */ {
/*     */   public ItemStoneMask() {
/*  28 */     super(JojoBAdvItems.stoneMaskMaterial, 4, 0);
/*  29 */     setTextureName("jojobadv:item_stoneMask");
/*  30 */     setUnlocalizedName("item_stoneMask");
/*  31 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xf, float yf, float zf) {
/*  36 */     if (world.getBlock(x, y, z) == Blocks.anvil) {
/*     */       
/*  38 */       if (!world.isRemote) {
/*     */         
/*  40 */         Random rand = new Random();
/*  41 */         player.playSound("minecraft:random.break", 1.0F, 1.0F);
/*  42 */         player.entityDropItem(new ItemStack(Blocks.cobblestone), 0.4F + rand.nextFloat());
/*  43 */         player.entityDropItem(new ItemStack(Blocks.cobblestone), 0.4F + rand.nextFloat());
/*  44 */         player.entityDropItem(new ItemStack(Blocks.cobblestone), 0.4F + rand.nextFloat());
/*     */       } 
/*  46 */       stack.stackSize--;
/*  47 */       return true;
/*     */     } 
/*  49 */     super.onItemRightClick(stack, world, player);
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
/*  56 */     if (entity instanceof EntityZombie) {
/*     */       
/*  58 */       EntityZombie zombie = (EntityZombie)entity;
/*  59 */       if (zombie.getEquipmentInSlot(4) == null) {
/*     */         
/*  61 */         ItemStack newStack = ItemStack.copyItemStack(stack);
/*  62 */         zombie.setCurrentItemOrArmor(4, newStack);
/*  63 */         stack.stackSize--;
/*  64 */         return true;
/*     */       } 
/*     */     } 
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  72 */   public boolean itemInteractionForEntity(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase p_111207_3_) { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) { return p_77659_1_; }
/*     */ 
/*     */   
/*  81 */   private int killCount = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
/*  86 */     if (!world.isRemote)
/*     */     {
/*  88 */       if (stack != null && player != null) {
/*     */         
/*  90 */         EntityLivingBase entity = player.getLastAttacker();
/*  91 */         if (entity != null && entity.hurtResistantTime != 0)
/*     */         {
/*  93 */           if (entity.getHealth() <= entity.getMaxHealth()) {
/*     */             
/*  95 */             ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  96 */             if (props.getJojoPower() == 0)
/*     */             {
/*  98 */               if (entity instanceof src.jojobadv.Entities.EntityHumanJojo || entity instanceof net.minecraft.entity.passive.EntityVillager || entity instanceof EntityPlayer) {
/*     */                 
/* 100 */                 if (entity instanceof src.jojobadv.Entities.Entityhamonuser) {
/*     */                   return;
/*     */                 }
/*     */                 
/* 104 */                 this.killCount++;
/* 105 */                 if (this.killCount == 1) {
/*     */                   
/* 107 */                   props.setJojoPower(JojoBAdvLib.JojoPowers.Vampire);
/* 108 */                   this.killCount = 0;
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) { return "jojobadv:textures/models/armour/stonemask.png"; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
/* 128 */     ModelBiped armorModel = (ModelBiped)ClientProxy.armorModels.get(this);
/* 129 */     if (itemStack != null)
/*     */     {
/* 131 */       if (armorModel != null) {
/*     */         
/* 133 */         armorModel.bipedHead.showModel = (armorSlot == 0);
/* 134 */         armorModel.bipedHeadwear.showModel = (armorSlot == 0);
/* 135 */         armorModel.bipedBody.showModel = (armorSlot == 1 || armorSlot == 2);
/* 136 */         armorModel.bipedRightArm.showModel = (armorSlot == 1);
/* 137 */         armorModel.bipedLeftArm.showModel = (armorSlot == 1);
/* 138 */         armorModel.bipedRightLeg.showModel = (armorSlot == 2 || armorSlot == 3);
/* 139 */         armorModel.bipedLeftLeg.showModel = (armorSlot == 2 || armorSlot == 3);
/*     */         
/* 141 */         armorModel.isSneak = entityLiving.isSneaking();
/* 142 */         armorModel.isRiding = entityLiving.isRiding();
/* 143 */         armorModel.isChild = entityLiving.isChild();
/* 144 */         armorModel.heldItemRight = (entityLiving.getHeldItem() != null) ? 1 : 0;
/* 145 */         if (entityLiving instanceof EntityPlayer)
/*     */         {
/* 147 */           armorModel.aimedBow = (((EntityPlayer)entityLiving).getItemInUseDuration() > 2);
/*     */         }
/* 149 */         return armorModel;
/*     */       } 
/*     */     }
/* 152 */     return null;
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemStoneMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */