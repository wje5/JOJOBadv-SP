/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.SyncStandSummonButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemDiscPower
/*     */   extends Item
/*     */ {
/*     */   public ItemDiscPower() {
/*  26 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*  27 */     setUnlocalizedName("item_discStand");
/*  28 */     setTextureName("jojobadv:disc");
/*     */   }
/*     */ 
/*     */   
/*     */   public void getTargetStand(EntityPlayer player, ItemStack stack) {
/*  33 */     if (getStandID(stack) == 0) {
/*     */       
/*  35 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  36 */       setStandID(stack, props.getPlayerStandID());
/*  37 */       setStandACT(stack, props.getPlayerStandAct());
/*  38 */       setStandEXP(stack, props.getPlayerStandExp());
/*  39 */       setStandNAME(stack, props.getPlayerStandName());
/*  40 */       setStandUser(stack, player);
/*  41 */       props.setStandRemoved();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean giveTargetStand(EntityPlayer player, ItemStack stack) {
/*  48 */     EntityPlayer target = player;
/*  49 */     ExtendedPlayerJojoBAdvProperties targetProps = ExtendedPlayerJojoBAdvProperties.get(target);
/*  50 */     if (targetProps.getPlayerStandID() != 0)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  56 */     if (getStandID(stack) != 0) {
/*     */       
/*  58 */       targetProps.setPlayerStandID(getStandID(stack));
/*  59 */       targetProps.setPlayerStandAct(getStandACT(stack));
/*  60 */       targetProps.setPlayerStandExp(getStandEXP(stack));
/*  61 */       targetProps.setPlayerStandName(getStandNAME(stack));
/*  62 */       stack.stackSize = 0;
/*  63 */       SyncStandSummonButton.summonStand(target);
/*  64 */       return true;
/*     */     } 
/*     */     
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int intpar7, float fx, float fy, float fz) {
/*  72 */     if (!world.isRemote) {
/*     */       
/*  74 */       if (world.getBlock(x, y, z) == Blocks.iron_block) {
/*     */         
/*  76 */         giveTargetStand(player, stack);
/*  77 */         return true;
/*     */       } 
/*  79 */       if (world.getBlock(x, y, z) == Blocks.gold_block) {
/*     */         
/*  81 */         getTargetStand(player, stack);
/*  82 */         return true;
/*     */       } 
/*     */     } 
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity) {
/*  91 */     if (entity.worldObj.isRemote)
/*     */     {
/*  93 */       return false;
/*     */     }
/*  95 */     if (entity instanceof EntityPlayer)
/*     */     {
/*  97 */       giveTargetStand((EntityPlayer)entity, itemstack);
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getEntityStandName(EntityOneStand standEnt) {
/* 104 */     String output = "";
/* 105 */     if (standEnt != null)
/*     */     {
/* 107 */       output = standEnt.getCommandSenderName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     return output;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean smt) {
/* 122 */     int standID = getStandID(stack);
/* 123 */     if (standID == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 128 */     int standAct = getStandACT(stack);
/* 129 */     int standExp = getStandEXP(stack);
/*     */     
/* 131 */     String standName = getStandNAME(stack);
/* 132 */     EntityOneStand standEnt = ItemStandArrow.getStand(standID, player.worldObj);
/* 133 */     String standEntName = standEnt.getCommandSenderName();
/* 134 */     if (standName.equals("")) {
/*     */       
/* 136 */       standName = getEntityStandName(standEnt);
/*     */     }
/*     */     else {
/*     */       
/* 140 */       stack.setStackDisplayName(standEntName);
/*     */     } 
/* 142 */     String standActPre = StatCollector.translateToLocal("stands.jojobadv.Act.txt");
/* 143 */     String standExpPre = StatCollector.translateToLocal("stands.jojobadv.Exp.txt");
/*     */     
/* 145 */     list.add(standName);
/* 146 */     list.add(standActPre + " " + standAct + "!");
/* 147 */     list.add(standExpPre + " " + standExp);
/*     */   }
/*     */   
/* 150 */   public String standInfo = "standInfo";
/* 151 */   public String standID = "standID";
/* 152 */   public String standExp = "standEXP";
/* 153 */   public String standAct = "standACT";
/* 154 */   public String standUser = "standUSER";
/* 155 */   public String standName = "standNAME";
/*     */ 
/*     */   
/*     */   public int getStandID(ItemStack stack) {
/* 159 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 161 */     if (nbttagcompound == null)
/*     */     {
/* 163 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 167 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/* 168 */     return (nbttagcompound1 == null) ? 0 : (nbttagcompound1.hasKey(this.standID) ? nbttagcompound1.getInteger(this.standID) : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStandACT(ItemStack stack) {
/* 174 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 176 */     if (nbttagcompound == null)
/*     */     {
/* 178 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 182 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/* 183 */     return (nbttagcompound1 == null) ? 0 : (nbttagcompound1.hasKey(this.standAct) ? nbttagcompound1.getInteger(this.standAct) : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStandEXP(ItemStack stack) {
/* 189 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 191 */     if (nbttagcompound == null)
/*     */     {
/* 193 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 197 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/* 198 */     return (nbttagcompound1 == null) ? 0 : (nbttagcompound1.hasKey(this.standExp) ? nbttagcompound1.getInteger(this.standExp) : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStandUser(ItemStack stack) {
/* 204 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 206 */     if (nbttagcompound == null)
/*     */     {
/* 208 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 212 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/* 213 */     return (nbttagcompound1 == null) ? "" : (nbttagcompound1.hasKey(this.standUser) ? nbttagcompound1.getString(this.standUser) : "");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStandID(ItemStack stack, int ID) {
/* 219 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 221 */     if (nbttagcompound == null) {
/*     */       
/* 223 */       nbttagcompound = new NBTTagCompound();
/* 224 */       stack.setTagCompound(nbttagcompound);
/*     */     } 
/*     */     
/* 227 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/*     */     
/* 229 */     if (!nbttagcompound.hasKey(this.standInfo))
/*     */     {
/* 231 */       nbttagcompound.setTag(this.standInfo, nbttagcompound1);
/*     */     }
/*     */     
/* 234 */     nbttagcompound1.setInteger(this.standID, ID);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStandACT(ItemStack stack, int ACT) {
/* 239 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 241 */     if (nbttagcompound == null) {
/*     */       
/* 243 */       nbttagcompound = new NBTTagCompound();
/* 244 */       stack.setTagCompound(nbttagcompound);
/*     */     } 
/*     */     
/* 247 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/*     */     
/* 249 */     if (!nbttagcompound.hasKey(this.standInfo))
/*     */     {
/* 251 */       nbttagcompound.setTag(this.standInfo, nbttagcompound1);
/*     */     }
/*     */     
/* 254 */     nbttagcompound1.setInteger(this.standAct, ACT);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStandEXP(ItemStack stack, int EXP) {
/* 259 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 261 */     if (nbttagcompound == null) {
/*     */       
/* 263 */       nbttagcompound = new NBTTagCompound();
/* 264 */       stack.setTagCompound(nbttagcompound);
/*     */     } 
/*     */     
/* 267 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/*     */     
/* 269 */     if (!nbttagcompound.hasKey(this.standInfo))
/*     */     {
/* 271 */       nbttagcompound.setTag(this.standInfo, nbttagcompound1);
/*     */     }
/*     */     
/* 274 */     nbttagcompound1.setInteger(this.standExp, EXP);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStandUser(ItemStack stack, EntityPlayer player) {
/* 279 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 281 */     if (nbttagcompound == null) {
/*     */       
/* 283 */       nbttagcompound = new NBTTagCompound();
/* 284 */       stack.setTagCompound(nbttagcompound);
/*     */     } 
/*     */     
/* 287 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/*     */     
/* 289 */     if (!nbttagcompound.hasKey(this.standInfo))
/*     */     {
/* 291 */       nbttagcompound.setTag(this.standInfo, nbttagcompound1);
/*     */     }
/*     */     
/* 294 */     nbttagcompound1.setString(this.standUser, player.getDisplayName());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStandNAME(ItemStack stack) {
/* 299 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 301 */     if (nbttagcompound == null)
/*     */     {
/* 303 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 307 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/* 308 */     return (nbttagcompound1 == null) ? "" : (nbttagcompound1.hasKey(this.standName) ? nbttagcompound1.getString(this.standName) : "");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStandNAME(ItemStack stack, String name) {
/* 314 */     NBTTagCompound nbttagcompound = stack.getTagCompound();
/*     */     
/* 316 */     if (nbttagcompound == null) {
/*     */       
/* 318 */       nbttagcompound = new NBTTagCompound();
/* 319 */       stack.setTagCompound(nbttagcompound);
/*     */     } 
/*     */     
/* 322 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag(this.standInfo);
/*     */     
/* 324 */     if (!nbttagcompound.hasKey(this.standInfo))
/*     */     {
/* 326 */       nbttagcompound.setTag(this.standInfo, nbttagcompound1);
/*     */     }
/*     */     
/* 329 */     nbttagcompound1.setString(this.standName, name);
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemDiscPower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */