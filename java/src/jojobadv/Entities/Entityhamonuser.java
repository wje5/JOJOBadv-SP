/*     */ package src.jojobadv.Entities;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIFollowOwner;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*     */ import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Items.JojoBAdvItems;
/*     */ import src.jojobadv.ModBase.ExtendedPlayerJojoBAdvProperties;
/*     */ import src.jojobadv.ModBase.JojoBAdvLib;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ public class Entityhamonuser
/*     */   extends EntityTameable
/*     */ {
/*     */   private boolean gethamon = false;
/*  37 */   private int spawn = 0;
/*  38 */   private int intage = 0;
/*  39 */   protected EntityJojoAISit aiSit = new EntityJojoAISit(this);
/*  40 */   public int upgradeValue = 6000;
/*     */ 
/*     */   
/*     */   public Entityhamonuser(World par1World) {
/*  44 */     super(par1World);
/*  45 */     setSize(0.6F, 1.8F);
/*  46 */     getNavigator().setBreakDoors(true);
/*  47 */     this.tasks.addTask(0, new EntityAISwimming(this));
/*  48 */     this.tasks.addTask(1, this.aiSit);
/*  49 */     this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
/*  50 */     this.tasks.addTask(2, new EntityAIFollowOwner(this, 1.6D, 8.0F, 3.0F));
/*  51 */     this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.6D, true));
/*  52 */     this.tasks.addTask(7, new EntityAIMoveTowardsRestriction(this, 1.0D));
/*  53 */     this.tasks.addTask(8, new EntityAIWander(this, 1.0D));
/*  54 */     this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/*  55 */     this.tasks.addTask(7, new EntityAILookIdle(this));
/*  56 */     this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, net.minecraft.entity.monster.EntityCreeper.class, 0, true));
/*  57 */     this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, net.minecraft.entity.monster.EntityMob.class, 0, true));
/*  58 */     this.targetTasks.addTask(6, new EntityAIOwnerHurtByTarget(this));
/*  59 */     this.targetTasks.addTask(7, new EntityAIOwnerHurtTarget(this));
/*  60 */     setTamed(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  65 */     super.applyEntityAttributes();
/*  66 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
/*  67 */     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(13.0D);
/*  68 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  74 */     if (isTamed()) {
/*     */       
/*  76 */       if (par1DamageSource.getEntity() == getOwner())
/*     */       {
/*  78 */         return false;
/*     */       }
/*     */ 
/*     */       
/*  82 */       super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  87 */       super.attackEntityFrom(par1DamageSource, par2);
/*     */     } 
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  94 */     float i = 0.0F;
/*     */     
/*  96 */     if (getIntAge() > 12000) {
/*     */       
/*  98 */       par1Entity.hurtResistantTime = 0;
/*     */       
/* 100 */       par1Entity.setSprinting(false);
/* 101 */       par1Entity.moveEntity(0.0D, 0.0D, 0.0D);
/* 102 */       if (par1Entity instanceof net.minecraft.entity.monster.EntityMob) {
/*     */         
/* 104 */         this.worldObj.playSoundAtEntity(par1Entity, SoundEvents.hamonshock.toString(), 0.5F, 1.0F);
/* 105 */         par1Entity.setFire(40);
/* 106 */         if (par1Entity instanceof EntityVampire)
/*     */         {
/* 108 */           return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 12.0F);
/*     */         }
/* 110 */         return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 8.0F);
/*     */       } 
/*     */ 
/*     */       
/* 114 */       i = 4.0F;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 119 */     else if (par1Entity instanceof net.minecraft.entity.monster.EntityMob) {
/*     */       
/* 121 */       int at = this.rand.nextInt(2);
/* 122 */       if (at == 0)
/*     */       {
/* 124 */         par1Entity.setSprinting(false);
/* 125 */         this.worldObj.playSoundAtEntity(par1Entity, SoundEvents.hamonshock.toString(), 0.5F, 1.0F);
/* 126 */         par1Entity.moveEntity(0.0D, 0.0D, 0.0D);
/* 127 */         par1Entity.setFire(40);
/* 128 */         if (par1Entity instanceof EntityVampire)
/*     */         {
/* 130 */           return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 8.0F);
/*     */         }
/* 132 */         return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 4.0F);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 137 */       i = 2.0F;
/*     */     } 
/*     */ 
/*     */     
/* 141 */     if (par1Entity instanceof EntityPlayer) {
/*     */       
/* 143 */       EntityPlayer player = (EntityPlayer)par1Entity;
/* 144 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 145 */       if (props.getJojoPower() == JojoBAdvLib.JojoPowers.Vampire) {
/*     */         
/* 147 */         this.worldObj.playSoundAtEntity(par1Entity, SoundEvents.hamonshock.toString(), 0.5F, 1.0F);
/* 148 */         i *= 2.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 157 */   public int getIntAge() { return this.intage; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   public void setIntAge(int value) { this.intage = value; }
/*     */ 
/*     */ 
/*     */   
/* 166 */   int test = 0;
/*     */   
/*     */   public void onUpdate() {
/* 169 */     super.onUpdate();
/* 170 */     if (!this.worldObj.isRemote) {
/*     */       
/* 172 */       if (getOwner() != null) {
/*     */         
/* 174 */         if ((getOwner()).isDead) {
/*     */           
/* 176 */           setTamed(false);
/* 177 */           func_152115_b("N/A");
/* 178 */           this.spawn = 0;
/* 179 */           this.gethamon = false;
/* 180 */           setIntAge(0);
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */ 
/*     */           
/* 188 */           this.intage++;
/*     */           
/* 190 */           if (getIntAge() == this.upgradeValue)
/*     */           {
/* 192 */             ((EntityPlayer)getOwner()).addChatMessage(new ChatComponentTranslation("msg.jojobadv.hamonUpdate.txt", new Object[0]));
/* 193 */             this.gethamon = true;
/*     */           }
/*     */         
/*     */         } 
/*     */       } else {
/*     */         
/* 199 */         this.aiSit.setSitting(false);
/*     */       } 
/*     */       
/* 202 */       if (this.gethamon);
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
/*     */   public boolean getHamonUserFoodList(ItemFood food) {
/* 233 */     if (food == Items.baked_potato) return true; 
/* 234 */     if (food == Items.pumpkin_pie) return true; 
/* 235 */     if (food == Items.bread) return true; 
/* 236 */     if (food == Items.cooked_beef) return true; 
/* 237 */     if (food == Items.cooked_chicken) return true; 
/* 238 */     if (food == Items.cooked_porkchop) return true; 
/* 239 */     if (food == Items.cooked_fished) return true; 
/* 240 */     if (food == Items.melon) return true;
/*     */     
/* 242 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer player) {
/* 247 */     if (!this.worldObj.isRemote) {
/*     */       
/* 249 */       ItemStack itemstack = player.inventory.getCurrentItem();
/* 250 */       ExtendedPlayerJojoBAdvProperties props = ExtendedPlayerJojoBAdvProperties.get(player);
/* 251 */       if (props.getJojoPower() == JojoBAdvLib.JojoPowers.Vampire) {
/*     */         
/* 253 */         if (getOwner() != null)
/*     */         {
/* 255 */           if (getOwner() == player) {
/*     */             
/* 257 */             setTamed(false);
/* 258 */             func_152115_b("N/A");
/*     */           } 
/*     */         }
/* 261 */         if (isSitting()) {
/*     */           
/* 263 */           this.aiSit.setSitting(false);
/* 264 */           setSneaking(false);
/*     */         } 
/* 266 */         setAttackTarget(player);
/* 267 */         setTarget(player);
/* 268 */         return true;
/*     */       } 
/*     */       
/* 271 */       if (isTamed()) {
/*     */         
/* 273 */         if (itemstack != null && itemstack.getItem() instanceof ItemFood) {
/*     */           
/* 275 */           ItemFood itemfood = (ItemFood)itemstack.getItem();
/* 276 */           if (getHamonUserFoodList(itemfood) && getHealth() < 20.0F)
/*     */           {
/* 278 */             if (!player.capabilities.isCreativeMode)
/*     */             {
/* 280 */               itemstack.stackSize--;
/*     */             }
/*     */             
/* 283 */             heal(itemfood.func_150905_g(itemstack));
/* 284 */             return true;
/*     */           }
/*     */         
/* 287 */         } else if (itemstack != null || itemstack == null) {
/*     */           
/* 289 */           if (getOwner() != null)
/*     */           {
/* 291 */             if (func_152114_e(player))
/*     */             {
/* 293 */               this.aiSit.setSitting(!isSitting());
/* 294 */               this.isJumping = false;
/* 295 */               setPathToEntity(null);
/* 296 */               setTarget(null);
/*     */             }
/*     */           
/*     */           }
/*     */         } 
/* 301 */       } else if (itemstack != null && itemstack.getItem() == JojoBAdvItems.StoneMask) {
/*     */         
/* 303 */         if (!player.capabilities.isCreativeMode)
/*     */         {
/* 305 */           itemstack.stackSize--;
/*     */         }
/*     */         
/* 308 */         if (!this.worldObj.isRemote)
/*     */         {
/* 310 */           if (this.rand.nextInt(1) == 0) {
/*     */             
/* 312 */             this.worldObj.playSoundAtEntity(this, "minecraft:mob.villager.idle", 1.0F, 1.0F);
/* 313 */             setTamed(true);
/* 314 */             setPathToEntity(null);
/* 315 */             setAttackTarget(null);
/* 316 */             setOwner(player);
/* 317 */             playTameEffect(true);
/* 318 */             this.worldObj.setEntityState(this, (byte)7);
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
/*     */           }
/*     */           else {
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
/* 353 */             playTameEffect(false);
/* 354 */             this.worldObj.setEntityState(this, (byte)6);
/*     */           } 
/*     */         }
/* 357 */         return true;
/*     */       } 
/*     */     } 
/* 360 */     return super.interact(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 365 */   protected boolean isAIEnabled() { return true; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound compound) {
/* 370 */     super.writeEntityToNBT(compound);
/*     */     
/* 372 */     compound.setInteger("HamonIntAge", getIntAge());
/*     */   }
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound compound) {
/* 377 */     super.readEntityFromNBT(compound);
/*     */     
/* 379 */     setIntAge(compound.getInteger("HamonIntAge"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 384 */   protected void entityInit() { super.entityInit(); }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOwnerName() {
/* 389 */     String name = "N/A";
/* 390 */     if (getOwner() != null)
/*     */     {
/* 392 */       name = getOwner().getCommandSenderName();
/*     */     }
/* 394 */     return name;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOwner(EntityPlayer player) {
/* 399 */     String uuid = player.getUniqueID().toString();
/* 400 */     func_152115_b(uuid);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 405 */   protected String getHurtSound() { return SoundEvents.classic_hurt.toString(); }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 410 */     if (this.rand.nextInt(10) == 1)
/*     */     {
/* 412 */       return Items.apple;
/*     */     }
/* 414 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 419 */   public int getTotalArmorValue() { return 8; }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 424 */     if (isTamed()) {
/*     */       
/* 426 */       if (getOwnerName().equalsIgnoreCase("N/A"))
/*     */       {
/* 428 */         if (getIntAge() > 3 * this.upgradeValue)
/*     */         {
/* 430 */           return true;
/*     */         }
/*     */       }
/* 433 */       return false;
/*     */     } 
/* 435 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 441 */   public EntityAgeable createChild(EntityAgeable var1) { return null; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Entities/Entityhamonuser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */