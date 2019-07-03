/*    */ package src.jojobadv.ModBase;
/*    */ 
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ 
/*    */ 
/*    */ public class JojoBAdvConfig
/*    */ {
/*    */   public static int hamonUserSpawn;
/*    */   public static int hamonUserGroupMin;
/*    */   public static int hamonUserGroupMax;
/*    */   public static int vampireUserSpawn;
/*    */   public static int vampireUserGroupMin;
/*    */   public static int vampireUserGroupMax;
/*    */   public static int standExpTime;
/*    */   public static int standExpGain;
/*    */   public static int sunlightBurn;
/*    */   public static boolean allowStandHunger;
/*    */   public static int hungerTime;
/*    */   public static boolean timeVampireReduce;
/*    */   public static int vampireHeal;
/*    */   public static boolean saveStandOnDeath;
/*    */   public static boolean savePowerOnDeath;
/*    */   
/*    */   public static void addConfig(FMLPreInitializationEvent event) {
/* 26 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 27 */     config.load();
/*    */     
/* 29 */     hamonUserSpawn = config.getInt("Hamon User - Spawn weight", "Entities", 10, 1, 100, "The spawn weight at which the Hamon User spawns, Higher means more likely");
/* 30 */     hamonUserGroupMin = config.getInt("Hamon User - Spawn min", "Entities", 1, 0, hamonUserGroupMax, "The minimum amount of Hamon Users that can spawn at any instance of spawn.");
/* 31 */     hamonUserGroupMax = config.getInt("Hamon User - Spawn max", "Entities", 2, hamonUserGroupMin, 20, "The maximum amount of Hamon Users that can spawn at any instance of spawn.");
/* 32 */     vampireUserSpawn = config.getInt("Vampire User - Spawn weight", "Entities", 70, 1, 100, "The spawn weight at which the Vampire spawns, Higher means more likely");
/* 33 */     vampireUserGroupMin = config.getInt("Vampire User - Spawn min", "Entities", 2, 0, vampireUserGroupMax, "The minimum amount of Vampire that can spawn at any instance of spawn.");
/* 34 */     vampireUserGroupMax = config.getInt("Vampire User - Spawn max", "Entities", 10, vampireUserGroupMin, 20, "The maximum amount of Vampire that can spawn at any instance of spawn.");
/* 35 */     standExpTime = config.getInt("Stand Exp - Time per gain", "Player", 3, 1, 100, "The time between each exp gain, default is 3 seconds for 1 exp");
/* 36 */     standExpGain = config.getInt("Stand Exp - Gain per run", "Player", 1, 0, 100, "The amount of exp gained per run of time, default is 3 seconds for 1 exp");
/* 37 */     sunlightBurn = config.getInt("Damage dealt by sun", "Player", 8, 2, 20, "The amount of damage (in half hearts) that is taken from sunlight as a Vampire");
/* 38 */     allowStandHunger = config.getBoolean("Stand hunger check", "Player", true, "Set to false to disable the player from losing hunger whilst using a stand.");
/* 39 */     hungerTime = config.getInt("Stand hunger time", "Player", 20, 1, 1000, "Time (in seconds) between each 1 half hunger point removed whilst using a stand.");
/* 40 */     timeVampireReduce = config.getBoolean("Vampire StopTime hunger reduced", "Player", false, "If true, when player is a vampire, The Worlds Stop Time will cost less hunger.");
/* 41 */     vampireHeal = config.getInt("Vampire heal", "Player", 4, 0, sunlightBurn - 1, "Amount healed as player, max is sunlight damage take 1 to avoid heal greater than burn.");
/* 42 */     saveStandOnDeath = config.getBoolean("Save Stand", "Player", false, "True to save stand on death");
/* 43 */     savePowerOnDeath = config.getBoolean("Save Power", "Player", false, "True to save Vampire or Hamon on death");
/*    */     
/* 45 */     config.save();
/*    */   }
/*    */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/JojoBAdvConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */