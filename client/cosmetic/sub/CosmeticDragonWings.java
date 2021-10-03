/*     */ package eclipse.client.cosmetic.sub;
/*     */ 
/*     */ import eclipse.client.cosmetic.CosmeticBase;
/*     */ import eclipse.client.cosmetic.CosmeticManager;
/*     */ import eclipse.client.cosmetic.CosmeticManager.WingType;
/*     */ import eclipse.client.cosmetic.CosmeticModelBase;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class CosmeticDragonWings extends CosmeticBase
/*     */ {
/*     */   private static ModelRenderer wing;
/*     */   private static ModelRenderer wingTip;
/*  21 */   boolean flying = false;
/*     */   private final ModelDragonWings modelDragonWings;
/*     */ 
/*     */   public CosmeticDragonWings(RenderPlayer renderPlayer)
/*     */   {
/*  29 */     super(renderPlayer);
/*  30 */     this.modelDragonWings = new ModelDragonWings(renderPlayer);
/*     */ 
/*  33 */     this.modelDragonWings.setTextureOffset("wingTip.bone", 112, 136);
/*  34 */     this.modelDragonWings.setTextureOffset("wing.skin", -56, 88);
/*  35 */     this.modelDragonWings.setTextureOffset("wing.bone", 112, 88);
/*  36 */     this.modelDragonWings.setTextureOffset("wingTip.skin", -56, 144);
/*     */ 
/*  38 */     int bw = this.modelDragonWings.textureWidth;
/*  39 */     int bh = this.modelDragonWings.textureHeight;
/*  40 */     this.modelDragonWings.textureWidth = 256;
/*  41 */     this.modelDragonWings.textureHeight = 256;
/*     */ 
/*  44 */     wing = new ModelRenderer(this.modelDragonWings, "wing");
/*  45 */     wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
/*  46 */     wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
/*  47 */     wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/*  48 */     wing.isHidden = true;
/*  49 */     wingTip = new ModelRenderer(this.modelDragonWings, "wingTip");
/*  50 */     wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
/*  51 */     wingTip.isHidden = true;
/*  52 */     wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
/*  53 */     wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/*  54 */     wing.addChild(wingTip);
/*  55 */     this.modelDragonWings.textureWidth = bw;
/*  56 */     this.modelDragonWings.textureWidth = bh;
/*     */   }
/*     */ 
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float HeadYaw, float headPitch, float scale)
/*     */   {
/*  61 */     if (CosmeticManager.ownsWings(player)) {
/*  62 */       GlStateManager.pushMatrix();
/*  63 */       this.modelDragonWings.render(player, limbSwing, limbSwingAmount, ageInTicks, HeadYaw, headPitch, scale);
/*  64 */       this.modelDragonWings.setRotationAngles(scale, limbSwing, limbSwingAmount, ageInTicks, HeadYaw, headPitch, player);
/*  65 */       GL11.glPopMatrix();
/*     */     }
/*     */   }
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/*     */   }
/*     */ 
/*     */   private class ModelDragonWings extends CosmeticModelBase {
/*  72 */     public ModelDragonWings(RenderPlayer player) { super(); }
/*     */ 
/*     */ 
/*     */     public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
/*     */     {
/*  79 */       super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/*  80 */       GlStateManager.pushMatrix();
/*     */ 
/*  82 */       float f1 = 0.0F;
/*     */ 
/*  84 */       if (Minecraft.getMinecraft().thePlayer.capabilities.isFlying)
/*  85 */         f1 = ageInTicks / 200.0F;
/*     */       else {
/*  87 */         f1 = ageInTicks / 80.0F;
/*     */       }
/*     */ 
/*  90 */       if (CosmeticManager.getWing((AbstractClientPlayer)entityIn) == CosmeticManager.WingType.REGULAR)
/*  91 */         Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/entity/enderdragon/dragon.png"));
/*  92 */       else if (CosmeticManager.getWing((AbstractClientPlayer)entityIn) == CosmeticManager.WingType.WHITE) {
/*  93 */         Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("twilight/Whitewings.png"));
/*     */       }
/*     */ 
/*  96 */       float anSpeed = 100.0F;
/*  97 */       if ((!entityIn.onGround) || (CosmeticDragonWings.this.flying))
/*     */       {
/*  99 */         anSpeed = 50.0F;
/* 100 */         CosmeticDragonWings.this.flying = true;
/*     */       }
/* 102 */       GlStateManager.scale(0.15D, 0.15D, 0.15D);
/* 103 */       GlStateManager.translate(0.0D, -0.3D, 1.1D);
/* 104 */       GlStateManager.rotate(50.0F, -50.0F, 0.0F, 0.0F);
/*     */ 
/* 106 */       int x = 0;
/* 107 */       int index = 0;
/*     */ 
/* 109 */       for (int i = 0; i < 2; i++)
/*     */       {
/* 111 */         float f6 = f1 * 9.141593F * 2.0F;
/* 112 */         CosmeticDragonWings.wing.rotateAngleX = (0.125F - (float)Math.cos(f6) * 0.2F);
/* 113 */         CosmeticDragonWings.wing.rotateAngleY = 0.25F;
/* 114 */         CosmeticDragonWings.wing.rotateAngleZ = ((float)(Math.sin(f6) + 1.225D) * 0.3F);
/*     */ 
/* 116 */         CosmeticDragonWings.wingTip.rotateAngleZ = (-(float)(Math.sin(f6 + 2.0F) + 0.5D) * 0.75F);
/* 117 */         CosmeticDragonWings.wing.isHidden = false;
/* 118 */         CosmeticDragonWings.wingTip.isHidden = false;
/*     */ 
/* 120 */         if (!entityIn.isInvisible())
/*     */         {
/* 125 */           GlStateManager.pushMatrix();
/*     */ 
/* 127 */           GlStateManager.disableLighting();
/*     */ 
/* 129 */           CosmeticDragonWings.wing.render(scale);
/* 130 */           GlStateManager.blendFunc(1, 1);
/* 131 */           GlStateManager.enableLighting();
/* 132 */           GlStateManager.popMatrix();
/*     */         }
/*     */ 
/* 136 */         CosmeticDragonWings.wing.isHidden = false;
/* 137 */         CosmeticDragonWings.wingTip.isHidden = false;
/*     */ 
/* 139 */         if (i == 0) {
/* 140 */           GlStateManager.scale(-1.0F, 1.0F, 1.0F);
/*     */         }
/*     */       }
/*     */ 
/* 144 */       GlStateManager.popMatrix();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.sub.CosmeticDragonWings
 * JD-Core Version:    0.6.2
 */