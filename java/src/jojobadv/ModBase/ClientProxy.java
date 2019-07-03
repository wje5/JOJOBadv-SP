/*     */ package src.jojobadv.ModBase;
/*     */ 
/*     */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelZombie;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import src.jojobadv.Items.JojoBAdvItems;
/*     */ import src.jojobadv.Models.ModelCrazyDiamond;
/*     */ import src.jojobadv.Models.ModelEchoesEgg;
/*     */ import src.jojobadv.Models.ModelKillerQueen;
/*     */ import src.jojobadv.Models.ModelMagicians_Red;
/*     */ import src.jojobadv.Models.ModelSheerHeartAttack;
/*     */ import src.jojobadv.Models.ModelSilver_Chariot;
/*     */ import src.jojobadv.Models.ModelStarplatinum;
/*     */ import src.jojobadv.Models.ModelStickyFingers;
/*     */ import src.jojobadv.Models.ModelStoneMask;
/*     */ import src.jojobadv.Models.ModelTheHand;
/*     */ import src.jojobadv.Models.ModelTheWorld;
/*     */ import src.jojobadv.Renders.RenderCrazyDiamond;
/*     */ import src.jojobadv.Renders.RenderCrazyDiamond_punch;
/*     */ import src.jojobadv.Renders.RenderDiavolo;
/*     */ import src.jojobadv.Renders.RenderEchoesEgg;
/*     */ import src.jojobadv.Renders.RenderEmperor_bullet;
/*     */ import src.jojobadv.Renders.RenderKillerQueen;
/*     */ import src.jojobadv.Renders.RenderKillerQueen_punch;
/*     */ import src.jojobadv.Renders.RenderKnife;
/*     */ import src.jojobadv.Renders.RenderMagicians_Red;
/*     */ import src.jojobadv.Renders.RenderMagicians_Red_fire;
/*     */ import src.jojobadv.Renders.RenderSheerHeartAttack;
/*     */ import src.jojobadv.Renders.RenderSheerHeartAttack_target;
/*     */ import src.jojobadv.Renders.RenderSilver_Chariot;
/*     */ import src.jojobadv.Renders.RenderSilver_Chariot_blade;
/*     */ import src.jojobadv.Renders.RenderStarplatinum;
/*     */ import src.jojobadv.Renders.RenderStarplatinum_punch;
/*     */ import src.jojobadv.Renders.RenderStickyFingers;
/*     */ import src.jojobadv.Renders.RenderStickyFingers_punch;
/*     */ import src.jojobadv.Renders.RenderTheHand;
/*     */ import src.jojobadv.Renders.RenderTheHand_punch;
/*     */ import src.jojobadv.Renders.RenderTheWorld;
/*     */ import src.jojobadv.Renders.RenderTheWorld_punch;
/*     */ import src.jojobadv.Renders.RenderVampire;
/*     */ import src.jojobadv.Renders.RenderVampire_bim;
/*     */ import src.jojobadv.Renders.Renderhamonuser;
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
/*     */ public class ClientProxy
/*     */   extends CommonProxy
/*     */ {
/*  81 */   public static final Map<Item, ModelBiped> armorModels = new HashMap();
/*     */ 
/*     */   
/*     */   public void registerRenderInformation() {
/*  85 */     MinecraftForge.EVENT_BUS.register(new SoundEvents());
/*  86 */     JojoBAdvKeyHandler.addKeys();
/*     */     
/*  88 */     ModelStoneMask stoneMask = new ModelStoneMask();
/*  89 */     armorModels.put(JojoBAdvItems.StoneMask, stoneMask);
/*     */     
/*  91 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Entityhamonuser.class, new Renderhamonuser(new ModelBiped(), 0.3F));
/*  92 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityStarplatinum.class, new RenderStarplatinum(new ModelStarplatinum(), 0.5F));
/*  93 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityStarplatinum_punch.class, new RenderStarplatinum_punch());
/*  94 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntitySilver_Chariot.class, new RenderSilver_Chariot(new ModelSilver_Chariot(), 0.5F));
/*  95 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntitySilver_Chariot_blade.class, new RenderSilver_Chariot_blade());
/*  96 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityMagicians_Red.class, new RenderMagicians_Red(new ModelMagicians_Red(), 0.5F));
/*  97 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityMagicians_Red_fire.class, new RenderMagicians_Red_fire());
/*  98 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityTheWorld.class, new RenderTheWorld(new ModelTheWorld(), 0.5F));
/*  99 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityTheWorld_punch.class, new RenderTheWorld_punch());
/* 100 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityCrazyDiamond.class, new RenderCrazyDiamond(new ModelCrazyDiamond(), 0.5F));
/* 101 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityCrazyDiamond_punch.class, new RenderCrazyDiamond_punch());
/* 102 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityTheHand.class, new RenderTheHand(new ModelTheHand(), 0.5F));
/* 103 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityTheHand_punch.class, new RenderTheHand_punch());
/* 104 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityKillerQueen.class, new RenderKillerQueen(new ModelKillerQueen(), 0.5F));
/* 105 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityKillerQueen_punch.class, new RenderKillerQueen_punch());
/* 106 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntitySheerHeartAttack_target.class, new RenderSheerHeartAttack_target());
/* 107 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntitySheerHeartAttack.class, new RenderSheerHeartAttack(new ModelSheerHeartAttack(), 0.5F));
/* 108 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityEmperor_bullet.class, new RenderEmperor_bullet());
/* 109 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.EntityVampire.class, new RenderVampire(new ModelZombie(), 0.3F));
/* 110 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.EntityVampire_bim.class, new RenderVampire_bim());
/* 111 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.EntityKnife.class, new RenderKnife());
/* 112 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityEchoesEgg.class, new RenderEchoesEgg(new ModelEchoesEgg(), 0.5F));
/*     */ 
/*     */ 
/*     */     
/* 116 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityStickyFingers.class, new RenderStickyFingers(new ModelStickyFingers(), 0.5F));
/* 117 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.Stands.EntityStickyFingers_punch.class, new RenderStickyFingers_punch());
/* 118 */     RenderingRegistry.registerEntityRenderingHandler(src.jojobadv.Entities.EntityDiavolo.class, new RenderDiavolo(new ModelBiped(), 0.5F));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public void spawnParticle(World world, String string, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) { (Minecraft.getMinecraft()).theWorld.spawnParticle(string, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed); }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/ClientProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */