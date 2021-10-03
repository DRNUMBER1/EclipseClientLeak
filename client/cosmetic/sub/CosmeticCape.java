/*    */ package eclipse.client.cosmetic.sub;
/*    */ 
/*    */ import eclipse.client.cosmetic.CapeManager;
/*    */ import eclipse.client.cosmetic.CosmeticBase;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.model.ModelPlayer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class CosmeticCape extends CosmeticBase
/*    */ {
/*    */   public CosmeticCape(RenderPlayer player)
/*    */   {
/* 15 */     super(player);
/*    */   }
/*    */ 
/*    */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale)
/*    */   {
/* 20 */     if ((CapeManager.hasCape(player)) && (player.hasPlayerInfo()) && (!player.isInvisible())) {
/* 21 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 22 */       this.playerRenderer.bindTexture(new ResourceLocation("twilight/capes/" + CapeManager.getCape(player) + ".png"));
/* 23 */       GlStateManager.pushMatrix();
/* 24 */       GlStateManager.translate(0.0F, 0.0F, 0.125F);
/* 25 */       double d0 = player.prevChasingPosX + (player.chasingPosX - player.prevChasingPosX) * partialTicks - (player.prevPosX + (player.posX - player.prevPosX) * partialTicks);
/* 26 */       double d1 = player.prevChasingPosY + (player.chasingPosY - player.prevChasingPosY) * partialTicks - (player.prevPosY + (player.posY - player.prevPosY) * partialTicks);
/* 27 */       double d2 = player.prevChasingPosZ + (player.chasingPosZ - player.prevChasingPosZ) * partialTicks - (player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks);
/* 28 */       float f = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * partialTicks;
/* 29 */       double d3 = MathHelper.sin(f * 3.141593F / 180.0F);
/* 30 */       double d4 = -MathHelper.cos(f * 3.141593F / 180.0F);
/* 31 */       float f1 = (float)d1 * 10.0F;
/* 32 */       f1 = MathHelper.clamp_float(f1, -6.0F, 32.0F);
/* 33 */       float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
/* 34 */       float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
/*    */ 
/* 36 */       if (f2 < 0.0F)
/*    */       {
/* 38 */         f2 = 0.0F;
/*    */       }
/*    */ 
/* 41 */       if (f2 > 165.0F)
/*    */       {
/* 43 */         f2 = 165.0F;
/*    */       }
/*    */ 
/* 46 */       if (f1 < -5.0F)
/*    */       {
/* 48 */         f1 = -5.0F;
/*    */       }
/*    */ 
/* 51 */       float f4 = player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * partialTicks;
/* 52 */       f1 += MathHelper.sin((player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;
/*    */ 
/* 54 */       if (player.isSneaking())
/*    */       {
/* 56 */         f1 += 25.0F;
/* 57 */         GlStateManager.translate(0.0F, 0.142F, -0.0178F);
/*    */       }
/*    */ 
/* 60 */       GlStateManager.rotate(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
/* 61 */       GlStateManager.rotate(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
/* 62 */       GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
/* 63 */       GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
/* 64 */       this.playerRenderer.getMainModel().renderCape(0.0625F);
/* 65 */       GlStateManager.popMatrix();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.sub.CosmeticCape
 * JD-Core Version:    0.6.2
 */