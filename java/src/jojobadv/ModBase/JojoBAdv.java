/*     */ package src.jojobadv.ModBase;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.Mod.Instance;
/*     */ import cpw.mods.fml.common.SidedProxy;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import src.jojobadv.Entities.JojoBAdvEntities;
/*     */ import src.jojobadv.Items.JojoBAdvItems;
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
/*     */ @Mod(modid = "jojobadv", name = "Steve's Bizarre Adventure", version = "0.2.4")
/*     */ public class JojoBAdv
/*     */ {
/*     */   @Instance("jojobadv")
/*     */   public static JojoBAdv instance;
/*     */   @SidedProxy(clientSide = "src.jojobadv.ModBase.ClientProxy", serverSide = "src.jojobadv.ModBase.CommonProxy")
/*     */   public static CommonProxy proxy;
/*     */   public static SimpleNetworkWrapper snw;
/*     */   public static CreativeTabs tabJojoBAdvMain;
/*     */   public static final String PacketChannel = "jojobadvmod";
/*     */   
/*     */   @EventHandler
/*     */   public void preInit(FMLPreInitializationEvent event) {
/* 110 */     JojoBAdvConfig.addConfig(event);
/*     */     
/* 112 */     tabJojoBAdvMain = new CreativeTabs("tabJojoBAdv")
/*     */       {
/* 114 */         public Item getTabIconItem() { return JojoBAdvItems.StandArrow; }
/*     */       };
/* 116 */     JojoBAdvItems.addItems();
/* 117 */     JojoBAdvItems.addBlocks();
/*     */     
/* 119 */     MinecraftForge.EVENT_BUS.register(new EventHandlerJojoBAdv());
/* 120 */     FMLCommonHandler.instance().bus().register(new EventControlInputs());
/* 121 */     FMLCommonHandler.instance().bus().register(new CommonTickHandler());
/*     */     
/* 123 */     snw = NetworkRegistry.INSTANCE.newSimpleChannel("jojobadv");
/* 124 */     snw.registerMessage(SyncStandSummonButton.Handler.class, SyncStandSummonButton.class, 0, Side.SERVER);
/* 125 */     snw.registerMessage(SyncPlayerAttackMessage.Handler.class, SyncPlayerAttackMessage.class, 1, Side.SERVER);
/*     */     
/* 127 */     if (Loader.isModLoaded("endercore"))
/*     */     {
/* 129 */       JojoBAdvLib.setEnderCore(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void load(FMLInitializationEvent event) {
/* 136 */     JojoBAdvItems.registerItems();
/* 137 */     JojoBAdvEntities.addEntities();
/* 138 */     proxy.registerRecipes();
/* 139 */     proxy.registerRenderInformation();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void postInit(FMLPostInitializationEvent event) {}
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/JojoBAdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */