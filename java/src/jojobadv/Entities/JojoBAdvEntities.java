/*     */ package src.jojobadv.Entities;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.EntityRegistry;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.JojoBAdvConfig;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JojoBAdvEntities
/*     */ {
/*     */   public static void createEntityMapped(Class entityClass, String entityName, int randomID) {
/*  42 */     EntityRegistry.registerModEntity(entityClass, entityName, randomID, JojoBAdv.instance, 80, 3, true);
/*  43 */     JojoBAdvEntityList.addMapping(entityClass, entityName, randomID);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createEntityMapped(Class entityClass, String entityName, int randomID, int solidColour, int spotColour) {
/*  48 */     EntityRegistry.registerModEntity(entityClass, entityName, randomID, JojoBAdv.instance, 80, 3, true);
/*  49 */     JojoBAdvEntityList.addMapping(entityClass, entityName, randomID, solidColour, spotColour);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addEntities() {
/*  54 */     createEntityMapped(Entityhamon.class, "Hamon", 0);
/*  55 */     createEntityMapped(Entityhamonuser.class, "Hamonuser", 1, 16773220, 16777215);
/*  56 */     EntityRegistry.addSpawn(Entityhamonuser.class, JojoBAdvConfig.hamonUserSpawn, JojoBAdvConfig.hamonUserGroupMin, JojoBAdvConfig.hamonUserGroupMax, EnumCreatureType.monster, biomes);
/*  57 */     createEntityMapped(EntityVampire_bim.class, "Vampire_laser", 2);
/*  58 */     createEntityMapped(EntityVampirepower.class, "Vampirepower", 3);
/*  59 */     createEntityMapped(EntityVampire.class, "Vampire", 4, 13434880, 13434880);
/*  60 */     EntityRegistry.addSpawn(EntityVampire.class, JojoBAdvConfig.vampireUserSpawn, JojoBAdvConfig.vampireUserGroupMin, JojoBAdvConfig.vampireUserGroupMax, EnumCreatureType.monster, biomesHell);
/*  61 */     createEntityMapped(EntityOneStand.class, "Stand", 5);
/*  62 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityStarplatinum.class, "Star_Platinum", 6);
/*  63 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityStarplatinum_punch.class, "Star Platinum punch", 7);
/*  64 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityMagicians_Red.class, "Magician's Red", 8);
/*  65 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityMagicians_Red_fire.class, "Magician's Red-fire", 9);
/*  66 */     createEntityMapped(src.jojobadv.Entities.Stands.EntitySilver_Chariot.class, "Silver Chariot", 10);
/*  67 */     createEntityMapped(src.jojobadv.Entities.Stands.EntitySilver_Chariot_blade.class, "Silver Chariot blade", 11);
/*  68 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityTheWorld.class, "The World", 12);
/*  69 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityTheWorld_punch.class, "The World punch", 13);
/*  70 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityEmperor.class, "Emperor", 14);
/*  71 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityEmperor_bullet.class, "Emperor - bullet", 15);
/*  72 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityCrazyDiamond.class, "Crazy Diamond", 16);
/*  73 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityCrazyDiamond_punch.class, "Crazy Diamond - punch", 17);
/*  74 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityEchoesEgg.class, "Echoes Egg", 18);
/*  75 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityEchoesAct1.class, "Echoes Act1", 19);
/*  76 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityEchoes_sound.class, "Echoes sound", 20);
/*  77 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityEchoesAct2.class, "Echoes Act2", 21);
/*  78 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityEchoesAct3.class, "Echoes Act3", 22);
/*  79 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityEchoesAct3_punch.class, "Echoes Act3 punch", 23);
/*  80 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityKillerQueen.class, "Killer Queen", 24);
/*  81 */     createEntityMapped(src.jojobadv.Entities.Stands.EntitySheerHeartAttack_target.class, "Sheer Heart Attack_target", 25);
/*  82 */     createEntityMapped(src.jojobadv.Entities.Stands.EntitySheerHeartAttack.class, "Sheer Heart Attack", 26);
/*  83 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityInBomb.class, "In Bomb", 27);
/*  84 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityOutBomb.class, "Out Bomb", 28);
/*  85 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityKillerQueen_punch.class, "Killer Queen - punch", 29);
/*  86 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityTheHand.class, "The Hand", 30);
/*  87 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityStickyFingers.class, "Sticky Fingers", 31);
/*  88 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityStickyFingers_punch.class, "Sticky Fingers - punch", 32);
/*  89 */     createEntityMapped(EntityDiavolo.class, "Diavolo", 33, 16777215, 16777215);
/*     */     
/*  91 */     createEntityMapped(EntityKnife.class, "Knife", 34);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityTheHand_punch.class, "The Hand - punch", 40);
/* 100 */     createEntityMapped(src.jojobadv.Entities.Stands.EntityTheWorld_StopTime.class, "The World - stop time", 41);
/*     */   }
/*     */   
/* 103 */   public static BiomeGenBase[] biomes = { BiomeGenBase.plains, BiomeGenBase.jungle, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.extremeHills };
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
/* 116 */   public static BiomeGenBase[] biomesHell = { BiomeGenBase.plains, BiomeGenBase.jungle, BiomeGenBase.forest, BiomeGenBase.roofedForest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.hell };
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/JojoBAdvEntities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */