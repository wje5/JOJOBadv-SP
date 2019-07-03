/*     */ package src.jojobadv.Entities.Stands;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.EntityOneStand;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ public class EntityEchoesEgg
/*     */   extends EntityOneStand
/*     */ {
/*     */   public EntityEchoesEgg(World par1World) {
/*  14 */     super(par1World);
/*  15 */     setSize(1.2F, 2.1F);
/*  16 */     this.spawnSound = SoundEvents.spawn_ea.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  21 */   protected boolean canDespawn() { return false; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  26 */     super.onUpdate();
/*  27 */     if (!this.worldObj.isRemote)
/*     */     {
/*  29 */       if (getMaster() != null)
/*     */       {
/*  31 */         if (this.standOn) {
/*     */           
/*  33 */           EntityPlayer player = getMaster();
/*  34 */           ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*     */           
/*  36 */           fallowmaster();
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
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
/*     */   public void changeAct() {
/*  54 */     EntityPlayer player = getMaster();
/*  55 */     ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  56 */     switch (props.getPlayerStandAct()) { case 0:
/*     */         return;
/*     */       case 1:
/*  59 */         spawnAct1(player); break;
/*  60 */       case 2: spawnAct2(player); break;
/*  61 */       case 3: spawnAct3(player);
/*     */         break; }
/*     */   
/*     */   }
/*     */   
/*     */   public void spawnAct1(EntityPlayer player) {
/*  67 */     if (!this.worldObj.isRemote) {
/*     */       
/*  69 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  70 */       EntityEchoesAct1 entitypigzombie = new EntityEchoesAct1(this.worldObj);
/*  71 */       entitypigzombie.setLocationAndAngles((getMaster()).posX + 0.1D, (getMaster()).posY, (getMaster()).posZ, (getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  72 */       this.worldObj.spawnEntityInWorld(entitypigzombie);
/*  73 */       entitypigzombie.setMaster(getMaster().getCommandSenderName());
/*  74 */       entitypigzombie.setMastername(getMastername());
/*  75 */       entitypigzombie.bespawn();
/*  76 */       props.setPlayerStandAct(1);
/*  77 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnAct2(EntityPlayer player) {
/*  83 */     if (!this.worldObj.isRemote) {
/*     */       
/*  85 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/*  86 */       EntityEchoesAct2 entitypigzombie = new EntityEchoesAct2(this.worldObj);
/*  87 */       entitypigzombie.setLocationAndAngles((getMaster()).posX + 0.1D, (getMaster()).posY, (getMaster()).posZ, (getMaster()).rotationYaw, (getMaster()).rotationPitch);
/*  88 */       this.worldObj.spawnEntityInWorld(entitypigzombie);
/*  89 */       entitypigzombie.setMaster(getMaster().getCommandSenderName());
/*  90 */       entitypigzombie.setMastername(getMastername());
/*  91 */       entitypigzombie.bespawn();
/*  92 */       props.setPlayerStandAct(2);
/*  93 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnAct3(EntityPlayer player) {
/*  99 */     if (!this.worldObj.isRemote) {
/*     */       
/* 101 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 102 */       EntityEchoesAct3 entitypigzombie = new EntityEchoesAct3(this.worldObj);
/* 103 */       entitypigzombie.setLocationAndAngles((getMaster()).posX + 0.1D, (getMaster()).posY, (getMaster()).posZ, (getMaster()).rotationYaw, (getMaster()).rotationPitch);
/* 104 */       this.worldObj.spawnEntityInWorld(entitypigzombie);
/* 105 */       entitypigzombie.setMaster(getMaster().getCommandSenderName());
/* 106 */       entitypigzombie.setMastername(getMastername());
/* 107 */       entitypigzombie.bespawn();
/* 108 */       props.setPlayerStandAct(3);
/* 109 */       setDead();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Stands/EntityEchoesEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */