/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraftforge.common.util.EnumHelper;
/*     */ 
/*     */ 
/*     */ public class JojoBAdvItems
/*     */ {
/*  11 */   public static ItemArmor.ArmorMaterial stoneMaskMaterial = EnumHelper.addArmorMaterial("StoneMaskMaterial", 1, new int[] { 3, 7, 6, 3 }, 30);
/*     */   
/*     */   public static Item JojoBAdvSpawnEggs;
/*     */   
/*     */   public static Item Bloodofvampire;
/*     */   
/*     */   public static Item HardArrow;
/*     */   
/*     */   public static Item StoneMask;
/*     */   
/*     */   public static Item Emperor;
/*     */   
/*     */   public static Item knife;
/*     */   
/*     */   public static Item StandArrow;
/*     */   
/*     */   public static Item spawn_SC;
/*     */   
/*     */   public static Item spawn_MR;
/*     */   
/*     */   public static Item spawn_SP;
/*     */   
/*     */   public static Item spawn_TW;
/*     */   
/*     */   public static Item spawn_E;
/*     */   
/*     */   public static Item spawn_CD;
/*     */   
/*     */   public static Item spawn_EC;
/*     */   
/*     */   public static Item spawn_KQ;
/*     */   
/*     */   public static Item spawn_TH;
/*     */   public static Item spawn_SF;
/*     */   public static Item standDisc;
/*     */   public static Item standDiscPower;
/*     */   
/*     */   public static void addItems() {
/*  49 */     JojoBAdvSpawnEggs = new ItemJojoSpawnEggs();
/*  50 */     Bloodofvampire = new ItemBloodofvampire();
/*  51 */     HardArrow = new ItemHardArrow();
/*  52 */     StoneMask = new ItemStoneMask();
/*  53 */     Emperor = new ItemEmperor();
/*     */ 
/*     */ 
/*     */     
/*  57 */     knife = new ItemKnife();
/*     */ 
/*     */     
/*  60 */     standDisc = new ItemTempStandSummon();
/*  61 */     standDiscPower = new ItemDiscPower();
/*     */     
/*  63 */     StandArrow = new ItemStandArrow(0, "stand_Arrow");
/*  64 */     spawn_SC = new ItemStandArrow(1, "stand_SC");
/*  65 */     spawn_MR = new ItemStandArrow(2, "stand_MR");
/*  66 */     spawn_SP = new ItemStandArrow(3, "stand_SP");
/*  67 */     spawn_TW = new ItemStandArrow(4, "stand_TW");
/*  68 */     spawn_E = new ItemStandArrow(5, "stand_E");
/*  69 */     spawn_CD = new ItemStandArrow(6, "stand_CD");
/*  70 */     spawn_EC = new ItemStandArrow(7, "stand_EC");
/*  71 */     spawn_KQ = new ItemStandArrow(8, "stand_KQ");
/*  72 */     spawn_TH = new ItemStandArrow(9, "stand_TH");
/*  73 */     spawn_SF = new ItemStandArrow(10, "stand_SF");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerItems() {
/*  83 */     GameRegistry.registerItem(JojoBAdvSpawnEggs, "jojobadv_spawnEggs");
/*  84 */     GameRegistry.registerItem(Bloodofvampire, "item_VampireBlood");
/*  85 */     GameRegistry.registerItem(HardArrow, "item_HardArrow");
/*  86 */     GameRegistry.registerItem(StoneMask, "item_StoneMask");
/*  87 */     GameRegistry.registerItem(Emperor, "item_Emperor");
/*     */ 
/*     */ 
/*     */     
/*  91 */     GameRegistry.registerItem(knife, "item_knife");
/*     */ 
/*     */     
/*  94 */     GameRegistry.registerItem(standDisc, "item_standDisc");
/*  95 */     GameRegistry.registerItem(standDiscPower, "item_standDiscPower");
/*     */     
/*  97 */     GameRegistry.registerItem(StandArrow, "item_StandArrow");
/*  98 */     GameRegistry.registerItem(spawn_SC, "stand_SC");
/*  99 */     GameRegistry.registerItem(spawn_MR, "stand_MR");
/* 100 */     GameRegistry.registerItem(spawn_SP, "stand_SP");
/* 101 */     GameRegistry.registerItem(spawn_TW, "stand_TW");
/* 102 */     GameRegistry.registerItem(spawn_E, "stand_E");
/* 103 */     GameRegistry.registerItem(spawn_CD, "stand_CD");
/* 104 */     GameRegistry.registerItem(spawn_EC, "stand_EC");
/* 105 */     GameRegistry.registerItem(spawn_KQ, "stand_KQ");
/* 106 */     GameRegistry.registerItem(spawn_TH, "stand_TH");
/* 107 */     GameRegistry.registerItem(spawn_SF, "stand_SF");
/*     */   }
/*     */   
/*     */   public static void addBlocks() {}
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/JojoBAdvItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */