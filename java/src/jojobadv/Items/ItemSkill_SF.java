/*     */ package src.jojobadv.Items;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Timer;
/*     */ import net.minecraft.world.World;
/*     */ import src.jojobadv.Entities.Stands.EntityStickyFingers;
/*     */ import src.jojobadv.ModBase.JojoBAdv;
/*     */ import src.jojobadv.ModBase.SoundEvents;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemSkill_SF
/*     */   extends Item
/*     */ {
/*  21 */   private int tick = 0;
/*     */   private Entity target;
/*     */   private boolean inTarget = false;
/*     */   private EntityStickyFingers sf;
/*     */   private boolean canuse = false;
/*  26 */   private Timer timer = new Timer(20.0F);
/*     */   
/*     */   private Entity player;
/*     */ 
/*     */   
/*     */   public ItemSkill_SF() {
/*  32 */     this.maxStackSize = 99;
/*  33 */     setTextureName("jojobadv:item_stickyFingers");
/*  34 */     setUnlocalizedName("item_stickyFingers");
/*  35 */     setCreativeTab(JojoBAdv.tabJojoBAdvMain);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  40 */   public EnumAction getItemUseAction(ItemStack par1ItemStack) { return EnumAction.bow; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { return par1ItemStack; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   public int getMaxItemUseDuration(ItemStack par1ItemStack) { return 72000; }
/*     */ 
/*     */   
/*     */   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
/*  63 */     Entity entity1 = null;
/*  64 */     for (int i1 = 0; i1 < player.worldObj.loadedEntityList.size(); i1++) {
/*     */       
/*  66 */       Entity entityplayer1 = (Entity)player.worldObj.loadedEntityList.get(i1);
/*  67 */       double dst = entityplayer1.getDistanceSq(player.posX, player.posY, player.posZ);
/*  68 */       entity1 = entityplayer1;
/*  69 */       if (entity1 instanceof EntityStickyFingers && dst <= 15.0D) {
/*     */         
/*  71 */         this.canuse = true;
/*  72 */         this.sf = (EntityStickyFingers)entity1;
/*  73 */         if (((EntityStickyFingers)entity1).arrirush_s) {
/*     */           
/*  75 */           this.sf.arritickr = 30;
/*  76 */           this.sf.arrirush = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*  80 */     if (entity instanceof EntityLivingBase && !(entity instanceof src.jojobadv.Entities.EntityOneStand) && this.canuse && this.sf != null && !player.worldObj.isRemote)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  90 */       if (this.sf.arrirush && this.sf.arrirush_s) {
/*     */         
/*  92 */         player.worldObj.playSoundAtEntity(entity, SoundEvents.arrirush.toString(), 3.0F, 1.0F);
/*  93 */         this.target = entity;
/*  94 */         this.inTarget = false;
/*  95 */         this.canuse = false;
/*  96 */         if (!player.capabilities.isCreativeMode)
/*     */         {
/*  98 */           player.getFoodStats().addStats(-4, 0.0F);
/*     */         }
/*     */       } 
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 107 */     if (this.target != null && this.inTarget)
/*     */     {
/* 109 */       par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*     */     }
/* 111 */     return par1ItemStack;
/*     */   }
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/* 115 */     par2World.playSoundAtEntity(this.target, "jojo:zipdown", 1.0F, 1.0F);
/* 116 */     par2World.playSoundAtEntity(par3EntityPlayer, "jojo:zipdown", 1.0F, 1.0F);
/* 117 */     this.inTarget = false;
/* 118 */     if (this.sf != null && this.sf.arrirush) {
/*     */       
/* 120 */       if (this.sf.posY > 2.0D)
/*     */       {
/* 122 */         par3EntityPlayer.setPosition(this.sf.posX, this.sf.posY + 1.0D - par3EntityPlayer.getEyeHeight(), this.sf.posZ);
/*     */       }
/*     */       else
/*     */       {
/* 126 */         par3EntityPlayer.setPosition(this.sf.posX, this.sf.posY + 1.0D, this.sf.posZ);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 131 */       (Minecraft.getMinecraft()).gameSettings.thirdPersonView = 0;
/* 132 */       (Minecraft.getMinecraft()).renderViewEntity = null;
/* 133 */       (Minecraft.getMinecraft()).renderViewEntity = (EntityLivingBase)this.player;
/* 134 */       par3EntityPlayer.setPosition(this.target.posX, this.target.posY, this.target.posZ);
/* 135 */       par3EntityPlayer.setVelocity(this.target.motionX, this.target.motionY, this.target.motionZ);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
/* 140 */     this.player = par3Entity;
/* 141 */     if (par1ItemStack.stackSize > 1)
/*     */     {
/* 143 */       par1ItemStack.stackSize = 1;
/*     */     }
/* 145 */     if (this.sf != null && 60 == this.sf.arritickr) {
/*     */       
/* 147 */       (Minecraft.getMinecraft()).renderViewEntity = null;
/* 148 */       (Minecraft.getMinecraft()).renderViewEntity = this.sf;
/* 149 */       this.inTarget = true;
/* 150 */       par3Entity.setPosition(this.sf.posX, -5.0D, this.sf.posZ);
/*     */     } 
/* 152 */     if (this.sf != null && 60 <= this.sf.arritickr && this.sf.arritickr < 220) {
/*     */       
/* 154 */       Minecraft.getMinecraft().getSoundHandler().setListener(this.sf.getMaster(), this.timer.renderPartialTicks);
/* 155 */       (Minecraft.getMinecraft()).gameSettings.thirdPersonView = 10;
/* 156 */       this.sf.skilltarget = this.target;
/* 157 */       if (this.sf != null && this.sf.arrirush && !this.target.isDead) {
/*     */         
/* 159 */         par3Entity.setPosition(this.sf.posX, -5.0D, this.sf.posZ);
/*     */       }
/* 161 */       else if (this.sf != null && this.sf.arrirush && this.target.isDead && this.inTarget) {
/*     */         
/* 163 */         ((EntityPlayer)par3Entity).setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*     */       } 
/*     */     } 
/* 166 */     if (this.sf != null && this.sf.arritickr == 220)
/*     */     {
/* 168 */       if (this.target != null && !this.target.isDead && this.inTarget)
/* 169 */         ((EntityPlayer)par3Entity).setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack)); 
/*     */     }
/* 171 */     if (this.sf != null && 220 < this.sf.arritickr && this.sf.arritickr < 300) {
/*     */       
/* 173 */       (Minecraft.getMinecraft()).gameSettings.thirdPersonView = 10;
/* 174 */       if (this.target != null && !this.target.isDead && this.inTarget)
/* 175 */         ((EntityPlayer)par3Entity).setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack)); 
/*     */     } 
/* 177 */     if (this.sf != null && this.sf.arritickr == 300) {
/*     */       
/* 179 */       (Minecraft.getMinecraft()).gameSettings.thirdPersonView = 0;
/*     */       
/* 181 */       (Minecraft.getMinecraft()).renderViewEntity = (EntityLivingBase)par3Entity;
/*     */     
/*     */     }
/* 184 */     else if (this.sf != null && !this.sf.arrirush) {
/*     */       
/* 186 */       if (par3Entity instanceof EntityPlayer && this.target != null && this.inTarget)
/*     */       {
/* 188 */         if (!this.target.isDead) {
/*     */           
/* 190 */           (Minecraft.getMinecraft()).renderViewEntity = (EntityLivingBase)this.target;
/* 191 */           par3Entity.setPosition(this.target.posX, -5.0D, this.target.posZ);
/* 192 */           par3Entity.setVelocity(0.0D, 0.0D, 0.0D);
/*     */         }
/*     */         else {
/*     */           
/* 196 */           ((EntityPlayer)par3Entity).setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
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
/* 207 */   public int getItemEnchantability() { return 1; }
/*     */ }


/* Location:              /Volumes/NO NAME/JojoBAdv-0.2.4-1.7.10-deobf.jar!/src/jojobadv/Items/ItemSkill_SF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.2
 */