/*    */ package eclipse.client.cosmetic.sub;
/*    */ 
/*    */ import eclipse.client.cosmetic.CosmeticBase;
/*    */ import eclipse.client.cosmetic.CosmeticManager;
/*    */ import eclipse.client.cosmetic.CosmeticModelBase;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class CosmeticBandana extends CosmeticBase
/*    */ {
/*    */   private final ModelBandana modelBandana;
/*    */ 
/*    */   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8)
/*    */   {
/* 18 */     if (CosmeticManager.ownsBandana(var1)) {
/* 19 */       GlStateManager.pushMatrix();
/* 20 */       this.playerRenderer.bindTexture(new ResourceLocation("twilight/" + CosmeticManager.getBandana(var1) + ".png"));
/*    */ 
/* 22 */       if (var1.isSneaking()) {
/* 23 */         GL11.glTranslated(0.0D, 0.225D, 0.0D);
/*    */       }
/*    */ 
/* 26 */       this.modelBandana.render(var1, var2, var3, var5, var6, var7, var8);
/* 27 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 28 */       GL11.glPopMatrix();
/*    */     }
/*    */   }
/*    */ 
/*    */   public CosmeticBandana(RenderPlayer var1)
/*    */   {
/* 34 */     super(var1);
/* 35 */     this.modelBandana = new ModelBandana(this, var1); } 
/*    */   private class ModelBandana extends CosmeticModelBase { private ModelRenderer band2;
/*    */     private ModelRenderer band1;
/*    */     private ModelRenderer band3;
/*    */     private ModelRenderer band4;
/*    */     final CosmeticBandana this$0;
/*    */ 
/* 45 */     public ModelBandana(CosmeticBandana var1, RenderPlayer var2) { super();
/* 46 */       this.this$0 = var1;
/* 47 */       this.band1 = new ModelRenderer(this.playerModel, 0, 0);
/* 48 */       this.band1.addBox(-4.5F, -7.0F, -4.7F, 9, 2, 1);
/* 49 */       this.band2 = new ModelRenderer(this.playerModel, 0, 0);
/* 50 */       this.band2.addBox(3.5F, -7.0F, -3.5F, 1, 2, 8);
/* 51 */       this.band3 = new ModelRenderer(this.playerModel, 0, 0);
/* 52 */       this.band3.addBox(-4.5F, -7.0F, -3.5F, 1, 2, 8);
/* 53 */       this.band4 = new ModelRenderer(this.playerModel, 0, 0);
/* 54 */       this.band4.addBox(-4.5F, -7.0F, 4.0F, 9, 2, 1); }
/*    */ 
/*    */     public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
/*    */     {
/* 58 */       this.band1.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 59 */       this.band1.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 60 */       this.band1.rotationPointX = 0.0F;
/* 61 */       this.band1.rotationPointY = 0.0F;
/* 62 */       this.band1.render(var7);
/* 63 */       this.band2.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 64 */       this.band2.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 65 */       this.band2.rotationPointX = 0.0F;
/* 66 */       this.band2.rotationPointY = 0.0F;
/* 67 */       this.band2.render(var7);
/* 68 */       this.band3.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 69 */       this.band3.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 70 */       this.band3.rotationPointX = 0.0F;
/* 71 */       this.band3.rotationPointY = 0.0F;
/* 72 */       this.band3.render(var7);
/* 73 */       this.band4.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 74 */       this.band4.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 75 */       this.band4.rotationPointX = 0.0F;
/* 76 */       this.band4.rotationPointY = 0.0F;
/* 77 */       this.band4.render(var7);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.sub.CosmeticBandana
 * JD-Core Version:    0.6.2
 */