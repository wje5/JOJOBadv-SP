/*     */ package src.jojobadv.Entities;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JojoBAdvEntityList
/*     */ {
/*  20 */   private static final Logger logger = LogManager.getLogger();
/*     */ 
/*     */   
/*  23 */   public static Map stringToClassMapping = new HashMap();
/*     */ 
/*     */   
/*  26 */   public static Map classToStringMapping = new HashMap();
/*     */ 
/*     */   
/*  29 */   public static Map IDtoClassMapping = new HashMap();
/*     */ 
/*     */   
/*  32 */   private static Map classToIDMapping = new HashMap();
/*     */ 
/*     */   
/*  35 */   private static Map stringToIDMapping = new HashMap();
/*     */ 
/*     */   
/*  38 */   public static HashMap entityEggs = new LinkedHashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addMapping(Class par1Class, String par2String, int par3Id) {
/*  45 */     if (stringToClassMapping.containsKey(par2String))
/*     */     {
/*  47 */       throw new IllegalArgumentException("ID is already registered: " + par2String);
/*     */     }
/*  49 */     if (IDtoClassMapping.containsKey(Integer.valueOf(par3Id)))
/*     */     {
/*  51 */       throw new IllegalArgumentException("ID is already registered: " + par3Id);
/*     */     }
/*     */ 
/*     */     
/*  55 */     stringToClassMapping.put(par2String, par1Class);
/*  56 */     classToStringMapping.put(par1Class, par2String);
/*  57 */     IDtoClassMapping.put(Integer.valueOf(par3Id), par1Class);
/*  58 */     classToIDMapping.put(par1Class, Integer.valueOf(par3Id));
/*  59 */     stringToIDMapping.put(par2String, Integer.valueOf(par3Id));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addMapping(Class entity, String name, int id, int solidColour, int spotcolour) {
/*  68 */     addMapping(entity, name, id);
/*  69 */     entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, solidColour, spotcolour));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity createEntityByName(String name, World world) {
/*  77 */     Entity entity = null;
/*     */ 
/*     */     
/*     */     try {
/*  81 */       Class oclass = (Class)stringToClassMapping.get(name);
/*     */       
/*  83 */       if (oclass != null)
/*     */       {
/*  85 */         entity = (Entity)oclass.getConstructor(new Class[] { World.class }).newInstance(new Object[] { world });
/*     */       }
/*     */     }
/*  88 */     catch (Exception exception) {
/*     */       
/*  90 */       exception.printStackTrace();
/*     */     } 
/*     */     
/*  93 */     return entity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity createEntityFromNBT(NBTTagCompound compound, World world) {
/* 101 */     Entity entity = null;
/*     */     
/* 103 */     if ("Minecart".equals(compound.getString("id"))) {
/*     */       
/* 105 */       switch (compound.getInteger("Type")) {
/*     */         
/*     */         case 0:
/* 108 */           compound.setString("id", "MinecartRideable");
/*     */           break;
/*     */         case 1:
/* 111 */           compound.setString("id", "MinecartChest");
/*     */           break;
/*     */         case 2:
/* 114 */           compound.setString("id", "MinecartFurnace");
/*     */           break;
/*     */       } 
/* 117 */       compound.removeTag("Type");
/*     */     } 
/*     */     
/* 120 */     Class oclass = null;
/*     */     
/*     */     try {
/* 123 */       oclass = (Class)stringToClassMapping.get(compound.getString("id"));
/*     */       
/* 125 */       if (oclass != null)
/*     */       {
/* 127 */         entity = (Entity)oclass.getConstructor(new Class[] { World.class }).newInstance(new Object[] { world });
/*     */       }
/*     */     }
/* 130 */     catch (Exception exception) {
/*     */       
/* 132 */       exception.printStackTrace();
/*     */     } 
/*     */     
/* 135 */     if (entity != null) {
/*     */       
/*     */       try
/*     */       {
/* 139 */         entity.readFromNBT(compound);
/*     */       }
/* 141 */       catch (Exception e)
/*     */       {
/* 143 */         FMLLog.log(Level.ERROR, e, "An Entity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author", new Object[] { compound
/*     */               
/* 145 */               .getString("id"), oclass.getName() });
/* 146 */         entity = null;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 151 */       logger.warn("Skipping Entity with id " + compound.getString("id"));
/*     */     } 
/*     */     
/* 154 */     return entity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity createEntityByID(int entityid, World world) {
/* 162 */     Entity entity = null;
/*     */ 
/*     */     
/*     */     try {
/* 166 */       Class oclass = getClassFromID(entityid);
/*     */       
/* 168 */       if (oclass != null)
/*     */       {
/* 170 */         entity = (Entity)oclass.getConstructor(new Class[] { World.class }).newInstance(new Object[] { world });
/*     */       }
/*     */     }
/* 173 */     catch (Exception exception) {
/*     */       
/* 175 */       exception.printStackTrace();
/*     */     } 
/*     */     
/* 178 */     if (entity == null)
/*     */     {
/* 180 */       logger.warn("Skipping Entity with id " + entityid);
/*     */     }
/*     */     
/* 183 */     return entity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getEntityID(Entity entity) {
/* 191 */     Class oclass = entity.getClass();
/* 192 */     return classToIDMapping.containsKey(oclass) ? ((Integer)classToIDMapping.get(oclass)).intValue() : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 200 */   public static Class getClassFromID(int entityid) { return (Class)IDtoClassMapping.get(Integer.valueOf(entityid)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 208 */   public static String getEntityString(Entity entityName) { return (String)classToStringMapping.get(entityName.getClass()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getStringFromID(int p_75617_0_) {
/* 216 */     Class oclass = getClassFromID(p_75617_0_);
/* 217 */     return (oclass != null) ? (String)classToStringMapping.get(oclass) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_151514_a() {}
/*     */ 
/*     */   
/* 224 */   public static Set func_151515_b() { return Collections.unmodifiableSet(stringToIDMapping.keySet()); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class EntityEggInfo
/*     */   {
/*     */     public final int spawnedID;
/*     */ 
/*     */ 
/*     */     
/*     */     public final int primaryColour;
/*     */ 
/*     */     
/*     */     public final int secondaryColour;
/*     */ 
/*     */ 
/*     */     
/*     */     public EntityEggInfo(int entityId, int solidColour, int spotColour) {
/* 243 */       this.spawnedID = entityId;
/* 244 */       this.primaryColour = solidColour;
/* 245 */       this.secondaryColour = spotColour;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/JojoBAdvEntityList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */