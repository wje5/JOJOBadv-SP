/*     */ package src.jojobadv.ModBase;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IExtendedEntityProperties;
/*     */ import src.jojobadv.Entities.EntityVampirepower;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExtendedPlayerJojoBAdvProperties
/*     */   implements IExtendedEntityProperties
/*     */ {
/*     */   public static final String EXT_PROP_NAME = "ExtendedPlayerJojoBAdvProperties";
/*     */   private final EntityPlayer player;
/*     */   private int playerStandID;
/*     */   private int playerStandAct;
/*     */   private boolean playerStandOn;
/*     */   private int playerStandExp;
/*     */   private boolean playerPowerSpawned;
/*     */   private int playerJojoPower;
/*     */   private String playerStandName;
/*     */   
/*     */   public ExtendedPlayerJojoBAdvProperties(EntityPlayer player) {
/*  30 */     this.player = player;
/*  31 */     player.getExtendedProperties(null);
/*  32 */     this.playerStandID = 0;
/*  33 */     this.playerStandAct = 0;
/*  34 */     this.playerStandOn = false;
/*  35 */     this.playerStandExp = 0;
/*  36 */     this.playerPowerSpawned = false;
/*  37 */     this.playerJojoPower = 0;
/*  38 */     this.playerStandName = "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static final void register(EntityPlayer player) {
/*  43 */     if (player.getExtendedProperties("ExtendedPlayerJojoBAdvProperties") == null)
/*     */     {
/*  45 */       player.registerExtendedProperties("ExtendedPlayerJojoBAdvProperties", new ExtendedPlayerJojoBAdvProperties(player));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  51 */   public static final ExtendedPlayerJojoBAdvProperties get(EntityLivingBase entity) { return (ExtendedPlayerJojoBAdvProperties)entity.getExtendedProperties("ExtendedPlayerJojoBAdvProperties"); }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final ExtendedPlayerJojoBAdvProperties getFromID(int entityID) {
/*  56 */     Entity entity = (Minecraft.getMinecraft()).theWorld.getEntityByID(entityID);
/*  57 */     EntityPlayer entPlayer = (EntityPlayer)entity;
/*  58 */     return (ExtendedPlayerJojoBAdvProperties)entPlayer.getExtendedProperties("ExtendedPlayerJojoBAdvProperties");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveNBTData(NBTTagCompound compound) {
/*  64 */     NBTTagCompound props = new NBTTagCompound();
/*  65 */     props.setInteger("StandID", this.playerStandID);
/*  66 */     props.setInteger("StandAct", this.playerStandAct);
/*  67 */     props.setBoolean("StandOn", this.playerStandOn);
/*  68 */     props.setInteger("StandExp", this.playerStandExp);
/*  69 */     props.setBoolean("PowerOn", this.playerPowerSpawned);
/*  70 */     props.setInteger("PowerID", this.playerJojoPower);
/*  71 */     props.setString("StandName", this.playerStandName);
/*  72 */     compound.setTag("ExtendedPlayerJojoBAdvProperties", props);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadNBTData(NBTTagCompound compound) {
/*  78 */     if (compound.hasKey("ExtendedPlayerJojoBAdvProperties")) {
/*     */       
/*  80 */       NBTTagCompound propertyData = compound.getCompoundTag("ExtendedPlayerJojoBAdvProperties");
/*  81 */       this.playerStandID = propertyData.getInteger("StandID");
/*  82 */       this.playerStandAct = propertyData.getInteger("StandAct");
/*  83 */       this.playerStandOn = propertyData.getBoolean("StandOn");
/*  84 */       this.playerStandExp = propertyData.getInteger("StandExp");
/*  85 */       this.playerPowerSpawned = propertyData.getBoolean("PowerOn");
/*  86 */       this.playerJojoPower = propertyData.getInteger("PowerID");
/*  87 */       this.playerStandName = propertyData.getString("StandName");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public void setPlayerStandID(int value) { this.playerStandID = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public int getPlayerStandID() { return this.playerStandID; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   public void setPlayerStandAct(int value) { this.playerStandAct = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public int getPlayerStandAct() { return this.playerStandAct; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 115 */   public void setStandOn(boolean value) { this.playerStandOn = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   public boolean getStandOn() { return this.playerStandOn; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public void setPlayerStandExp(int value) { this.playerStandExp = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   public int getPlayerStandExp() { return this.playerStandExp; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   public void setPlayerStandName(String value) { this.playerStandName = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   public String getPlayerStandName() { return this.playerStandName; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Entity entity, World world) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStandRemoved() {
/* 154 */     setStandOn(false);
/* 155 */     setPlayerStandAct(0);
/* 156 */     setPlayerStandExp(0);
/* 157 */     setPlayerStandID(0);
/* 158 */     setPlayerStandName("");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 164 */   public void setJojoPower(int value) { this.playerJojoPower = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 170 */   public int getJojoPower() { return this.playerJojoPower; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public void setPowerSpawned(boolean value) { this.playerPowerSpawned = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 180 */   public boolean getPowerSpawned() { return this.playerPowerSpawned; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityVampirepower getSpawnedPower() {
/* 188 */     List entList = this.player.worldObj.getEntitiesWithinAABB(EntityVampirepower.class, AxisAlignedBB.getBoundingBox(this.player.posX - 1.0D, this.player.posY - 1.0D, this.player.posZ - 1.0D, this.player.posX + 1.0D, this.player.posY + 1.0D, this.player.posZ + 1.0D));
/* 189 */     if (entList != null)
/*     */     {
/* 191 */       for (int i = 0; i < entList.size(); i++) {
/*     */         
/* 193 */         EntityVampirepower power = (EntityVampirepower)entList.get(i);
/* 194 */         if (power.getMaster() == this.player)
/*     */         {
/* 196 */           return power;
/*     */         }
/*     */       } 
/*     */     }
/* 200 */     return null;
/*     */   }
/*     */   
/* 203 */   public static int vampire = 1;
/* 204 */   public static int hamon = 2;
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/ModBase/ExtendedPlayerJojoBAdvProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */