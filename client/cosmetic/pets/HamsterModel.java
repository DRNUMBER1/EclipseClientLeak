/*     */ package eclipse.client.cosmetic.pets;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class HamsterModel extends ModelBase
/*     */ {
/*     */   private ModelRenderer hamsterHeadMain;
/*     */   private ModelRenderer hamsterBody;
/*     */   private ModelRenderer hamsterLeg1;
/*     */   private ModelRenderer hamsterLeg2;
/*     */   private ModelRenderer hamsterLeg3;
/*     */   private ModelRenderer hamsterLeg4;
/*     */   private ModelRenderer hamsterMane;
/*     */ 
/*     */   public HamsterModel()
/*     */   {
/*  65 */     float f = 0.0F;
/*     */ 
/*  67 */     this.hamsterHeadMain = new ModelRenderer(this, 0, 0);
/*  68 */     this.hamsterHeadMain.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
/*  69 */     this.hamsterHeadMain.setRotationPoint(-1.0F, 13.5F, -7.0F);
/*     */ 
/*  71 */     this.hamsterBody = new ModelRenderer(this, 18, 14);
/*  72 */     this.hamsterBody.addBox(-4.0F, -2.0F, -3.0F, 6, 9, 6, f);
/*  73 */     this.hamsterBody.setRotationPoint(0.0F, 14.0F, 2.0F);
/*     */ 
/*  75 */     this.hamsterMane = new ModelRenderer(this, 21, 0);
/*  76 */     this.hamsterMane.addBox(-4.0F, -3.0F, -3.0F, 8, 6, 7, f);
/*  77 */     this.hamsterMane.setRotationPoint(-1.0F, 14.0F, 2.0F);
/*     */ 
/*  79 */     this.hamsterLeg1 = new ModelRenderer(this, 0, 18);
/*  80 */     this.hamsterLeg1.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f + 0.5F);
/*  81 */     this.hamsterLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
/*     */ 
/*  83 */     this.hamsterLeg2 = new ModelRenderer(this, 0, 18);
/*  84 */     this.hamsterLeg2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f + 0.5F);
/*  85 */     this.hamsterLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
/*     */ 
/*  87 */     this.hamsterLeg3 = new ModelRenderer(this, 0, 18);
/*  88 */     this.hamsterLeg3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f + 0.5F);
/*  89 */     this.hamsterLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
/*     */ 
/*  91 */     this.hamsterLeg4 = new ModelRenderer(this, 0, 18);
/*  92 */     this.hamsterLeg4.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f + 0.5F);
/*  93 */     this.hamsterLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
/*     */ 
/*  95 */     this.hamsterHeadMain.setTextureOffset(16, 14).addBox(-3.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
/*  96 */     this.hamsterHeadMain.setTextureOffset(16, 14).addBox(1.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
/*  97 */     this.hamsterHeadMain.setTextureOffset(0, 10).addBox(-1.5F, 0.0F, -3.0F, 3, 3, 4, 0.0F);
/*     */   }
/*     */ 
/*     */   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
/*     */   {
/* 105 */     super.render(par1Entity, par2, par3, par4, par5, par6, par7);
/* 106 */     setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
/*     */ 
/* 108 */     GlStateManager.pushMatrix();
/* 109 */     GlStateManager.translate(0.0F, 0.2F, 0.0F);
/*     */ 
/* 111 */     if (this.isChild) {
/* 112 */       float f = 2.0F;
/* 113 */       GlStateManager.pushMatrix();
/* 114 */       GlStateManager.translate(0.0F, 5.0F * par7, 2.0F * par7);
/* 115 */       this.hamsterHeadMain.renderWithRotation(par7);
/* 116 */       GlStateManager.popMatrix();
/* 117 */       GlStateManager.pushMatrix();
/* 118 */       GlStateManager.scale(1.0F / f, 1.0F / f, 1.0F / f);
/* 119 */       GlStateManager.translate(0.0F, 24.0F * par7, 0.0F);
/* 120 */       this.hamsterBody.render(par7);
/* 121 */       this.hamsterLeg1.render(par7);
/* 122 */       this.hamsterLeg2.render(par7);
/* 123 */       this.hamsterLeg3.render(par7);
/* 124 */       this.hamsterLeg4.render(par7);
/* 125 */       this.hamsterMane.render(par7);
/* 126 */       GlStateManager.popMatrix();
/*     */     } else {
/* 128 */       this.hamsterHeadMain.renderWithRotation(par7);
/* 129 */       this.hamsterBody.render(par7);
/* 130 */       this.hamsterLeg1.render(par7);
/* 131 */       this.hamsterLeg2.render(par7);
/* 132 */       this.hamsterLeg3.render(par7);
/* 133 */       this.hamsterLeg4.render(par7);
/* 134 */       this.hamsterMane.render(par7);
/*     */     }
/*     */ 
/* 137 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */   public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4)
/*     */   {
/* 146 */     EntityHamster entityhamster = (EntityHamster)par1EntityLiving;
/*     */ 
/* 148 */     if (entityhamster.isSitting()) {
/* 149 */       this.hamsterHeadMain.setRotationPoint(-1.0F, 11.5F, -7.0F);
/* 150 */       this.hamsterMane.setRotationPoint(-1.0F, 14.0F, -3.0F);
/* 151 */       this.hamsterMane.rotateAngleX = 1.256637F;
/* 152 */       this.hamsterMane.rotateAngleY = 0.0F;
/* 153 */       this.hamsterBody.setRotationPoint(0.0F, 14.0F, 0.0F);
/* 154 */       this.hamsterBody.rotateAngleX = 0.9424779F;
/* 155 */       this.hamsterLeg1.setRotationPoint(-2.4F, 19.0F, 5.0F);
/* 156 */       this.hamsterLeg1.rotateAngleX = 4.712389F;
/* 157 */       this.hamsterLeg2.setRotationPoint(0.4F, 19.0F, 5.0F);
/* 158 */       this.hamsterLeg2.rotateAngleX = 4.712389F;
/* 159 */       this.hamsterLeg3.rotateAngleX = 0.0F;
/* 160 */       this.hamsterLeg3.setRotationPoint(-2.49F, 16.0F, -4.0F);
/* 161 */       this.hamsterLeg4.rotateAngleX = 0.0F;
/* 162 */       this.hamsterLeg4.setRotationPoint(0.51F, 16.0F, -4.0F);
/*     */     } else {
/* 164 */       this.hamsterHeadMain.setRotationPoint(-1.0F, 13.5F, -7.0F);
/* 165 */       this.hamsterBody.setRotationPoint(0.0F, 14.0F, 2.0F);
/* 166 */       this.hamsterBody.rotateAngleX = 1.570796F;
/* 167 */       this.hamsterMane.setRotationPoint(-1.0F, 14.0F, -3.0F);
/* 168 */       this.hamsterMane.rotateAngleX = this.hamsterBody.rotateAngleX;
/* 169 */       this.hamsterLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
/* 170 */       this.hamsterLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
/* 171 */       this.hamsterLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
/* 172 */       this.hamsterLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
/* 173 */       this.hamsterLeg1.rotateAngleX = (MathHelper.cos(par2 * 0.6662F) * 1.4F * par3);
/* 174 */       this.hamsterLeg2.rotateAngleX = (MathHelper.cos(par2 * 0.6662F + 3.141593F) * 1.4F * par3);
/* 175 */       this.hamsterLeg3.rotateAngleX = (MathHelper.cos(par2 * 0.6662F + 3.141593F) * 1.4F * par3);
/* 176 */       this.hamsterLeg4.rotateAngleX = (MathHelper.cos(par2 * 0.6662F) * 1.4F * par3);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
/*     */   {
/* 184 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */ 
/* 186 */     this.hamsterHeadMain.rotateAngleX = (par5 / 57.295776F);
/* 187 */     this.hamsterHeadMain.rotateAngleY = (par4 / 57.295776F);
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.pets.HamsterModel
 * JD-Core Version:    0.6.2
 */