/*     */ package eclipse.client.cosmetic.pets;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.ai.EntityAIFollowOwner;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.pathfinding.PathNavigateGround;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ public class EntityHamster extends EntityTameable
/*     */ {
/*     */   public EntityHamster(World worldIn)
/*     */   {
/*  37 */     super(worldIn);
/*  38 */     setSize(0.4F, 0.2F);
/*  39 */     ((PathNavigateGround)getNavigator()).setAvoidsWater(true);
/*  40 */     this.tasks.addTask(1, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
/*  41 */     this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
/*  42 */     this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayerSP.class, 8.0F));
/*  43 */     this.tasks.addTask(3, new EntityAILookIdle(this));
/*  44 */     setTamed(true);
/*  45 */     this.preventEntitySpawning = false;
/*     */   }
/*     */ 
/*     */   public void onLivingUpdate()
/*     */   {
/*  50 */     super.onLivingUpdate();
/*  51 */     updateEntityActionState();
/*     */   }
/*     */ 
/*     */   public void moveEntityWithHeading(float strafe, float forward)
/*     */   {
/*  56 */     if (!isInWater()) {
/*  57 */       if (!isInLava()) {
/*  58 */         float f4 = 0.91F;
/*     */ 
/*  60 */         if (this.onGround) {
/*  61 */           f4 = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(getEntityBoundingBox().minY) - 1, 
/*  62 */             MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91F;
/*     */         }
/*     */ 
/*  65 */         float f = 0.1627714F / (f4 * f4 * f4);
/*  66 */         float f5 = this.onGround ? getAIMoveSpeed() * f : this.jumpMovementFactor;
/*  67 */         moveFlying(strafe, forward, f5);
/*  68 */         f4 = 0.91F;
/*     */ 
/*  70 */         if (this.onGround) {
/*  71 */           f4 = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(getEntityBoundingBox().minY) - 1, 
/*  72 */             MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91F;
/*     */         }
/*     */ 
/*  75 */         if (isOnLadder()) {
/*  76 */           float f6 = 0.15F;
/*  77 */           this.motionX = MathHelper.clamp_double(this.motionX, -f6, f6);
/*  78 */           this.motionZ = MathHelper.clamp_double(this.motionZ, -f6, f6);
/*  79 */           this.fallDistance = 0.0F;
/*  80 */           if (this.motionY < -0.15D) this.motionY = -0.15D;
/*     */         }
/*     */ 
/*  83 */         moveEntity(this.motionX, this.motionY, this.motionZ);
/*     */ 
/*  85 */         if ((this.isCollidedHorizontally) && (isOnLadder())) this.motionY = 0.2D;
/*     */ 
/*  87 */         if ((this.worldObj.isRemote) && ((!this.worldObj.isBlockLoaded(new BlockPos((int)this.posX, 0, (int)this.posZ))) || 
/*  88 */           (!this.worldObj.getChunkFromBlockCoords(new BlockPos((int)this.posX, 0, (int)this.posZ)).isLoaded())))
/*  89 */           this.motionY = (this.posY > 0.0D ? -0.1D : 0.0D);
/*     */         else {
/*  91 */           this.motionY -= 0.08D;
/*     */         }
/*     */ 
/*  94 */         this.motionY *= 0.9800000190734863D;
/*  95 */         this.motionX *= f4;
/*  96 */         this.motionZ *= f4;
/*     */       } else {
/*  98 */         double d1 = this.posY;
/*  99 */         moveFlying(strafe, forward, 0.02F);
/* 100 */         moveEntity(this.motionX, this.motionY, this.motionZ);
/* 101 */         this.motionX *= 0.5D;
/* 102 */         this.motionY *= 0.5D;
/* 103 */         this.motionZ *= 0.5D;
/* 104 */         this.motionY -= 0.02D;
/*     */ 
/* 106 */         if ((this.isCollidedHorizontally) && (isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579D - this.posY + d1, this.motionZ)))
/* 107 */           this.motionY = 0.300000011920929D;
/*     */       }
/*     */     }
/*     */     else {
/* 111 */       double d0 = this.posY;
/* 112 */       float f1 = 0.8F;
/* 113 */       float f2 = 0.02F;
/* 114 */       float f3 = EnchantmentHelper.getDepthStriderModifier(this);
/* 115 */       if (f3 > 3.0F) f3 = 3.0F;
/* 116 */       if (!this.onGround) f3 *= 0.5F;
/*     */ 
/* 118 */       if (f3 > 0.0F) {
/* 119 */         f1 += (0.5460001F - f1) * f3 / 3.0F;
/* 120 */         f2 += (getAIMoveSpeed() * 1.0F - f2) * f3 / 3.0F;
/*     */       }
/*     */ 
/* 123 */       moveFlying(strafe, forward, f2);
/* 124 */       moveEntity(this.motionX, this.motionY, this.motionZ);
/* 125 */       this.motionX *= f1;
/* 126 */       this.motionY *= 0.800000011920929D;
/* 127 */       this.motionZ *= f1;
/* 128 */       this.motionY -= 0.02D;
/*     */ 
/* 130 */       if ((this.isCollidedHorizontally) && (isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579D - this.posY + d0, this.motionZ))) {
/* 131 */         this.motionY = 0.300000011920929D;
/*     */       }
/*     */     }
/*     */ 
/* 135 */     super.moveEntityWithHeading(strafe, forward);
/*     */   }
/*     */ 
/*     */   public EntityAgeable createChild(EntityAgeable ageable)
/*     */   {
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean canMateWith(EntityAnimal otherAnimal)
/*     */   {
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean canBeCollidedWith()
/*     */   {
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */   protected void updateAITasks()
/*     */   {
/* 155 */     super.updateAITasks();
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.pets.EntityHamster
 * JD-Core Version:    0.6.2
 */