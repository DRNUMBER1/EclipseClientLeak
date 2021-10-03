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
/*    */ public class CosmeticMask extends CosmeticBase
/*    */ {
/*    */   private final ModelBandana modelBandana;
/*    */ 
/*    */   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8)
/*    */   {
/* 20 */     if (CosmeticManager.ownsMask(var1)) {
/* 21 */       GlStateManager.pushMatrix();
/* 22 */       this.playerRenderer.bindTexture(new ResourceLocation("twilight/" + CosmeticManager.getMask(var1) + ".png"));
/* 23 */       if (var1.isSneaking()) {
/* 24 */         GL11.glTranslated(0.0D, 0.225D, 0.0D);
/*    */       }
/* 26 */       this.modelBandana.render(var1, var2, var3, var5, var6, var7, var8);
/* 27 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 28 */       GL11.glPopMatrix();
/*    */     }
/*    */   }
/*    */ 
/*    */   public CosmeticMask(RenderPlayer var1)
/*    */   {
/* 34 */     super(var1);
/* 35 */     this.modelBandana = new ModelBandana(this, var1); } 
/*    */   private class ModelBandana extends CosmeticModelBase { final CosmeticMask this$0;
/*    */     private ModelRenderer band1;
/*    */     private ModelRenderer band2;
/*    */     private ModelRenderer band4;
/*    */     private ModelRenderer band3;
/*    */ 
/* 46 */     public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) { this.band1.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 47 */       this.band1.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 48 */       this.band1.rotationPointX = 0.0F;
/* 49 */       this.band1.rotationPointY = 0.0F;
/* 50 */       this.band1.render(var7);
/* 51 */       this.band2.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 52 */       this.band2.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 53 */       this.band2.rotationPointX = 0.0F;
/* 54 */       this.band2.rotationPointY = 0.0F;
/* 55 */       this.band2.render(var7);
/* 56 */       this.band3.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 57 */       this.band3.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 58 */       this.band3.rotationPointX = 0.0F;
/* 59 */       this.band3.rotationPointY = 0.0F;
/* 60 */       this.band3.render(var7);
/* 61 */       this.band4.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 62 */       this.band4.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 63 */       this.band4.rotationPointX = 0.0F;
/* 64 */       this.band4.rotationPointY = 0.0F;
/* 65 */       this.band4.render(var7); }
/*    */ 
/*    */     public ModelBandana(CosmeticMask var1, RenderPlayer var2)
/*    */     {
/* 69 */       super();
/* 70 */       this.this$0 = var1;
/* 71 */       this.band1 = new ModelRenderer(this.playerModel, 0, 0);
/* 72 */       this.band1.addBox(-4.5F, -9.0F, -4.7F, 9, 9, 1);
/* 73 */       this.band2 = new ModelRenderer(this.playerModel, 0, 0);
/* 74 */       this.band2.addBox(3.5F, -7.0F, -3.5F, 1, 2, 8);
/* 75 */       this.band3 = new ModelRenderer(this.playerModel, 0, 0);
/* 76 */       this.band3.addBox(-4.5F, -7.0F, -3.5F, 1, 2, 8);
/* 77 */       this.band4 = new ModelRenderer(this.playerModel, 0, 0);
/* 78 */       this.band4.addBox(-4.5F, -7.0F, 4.0F, 9, 2, 1);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.sub.CosmeticMask
 * JD-Core Version:    0.6.2
 */