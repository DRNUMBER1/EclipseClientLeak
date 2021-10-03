/*    */ package eclipse.client.cosmetic;
/*    */ 
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/*    */ 
/*    */ public abstract class CosmeticBase
/*    */   implements LayerRenderer<AbstractClientPlayer>
/*    */ {
/*    */   protected final RenderPlayer playerRenderer;
/*    */ 
/*    */   public CosmeticBase(RenderPlayer player)
/*    */   {
/* 12 */     this.playerRenderer = player;
/*    */   }
/*    */ 
/*    */   public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale)
/*    */   {
/* 17 */     if ((player.hasPlayerInfo()) && (!player.isInvisible()))
/* 18 */       render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, scale);
/*    */   }
/*    */ 
/*    */   public abstract void render(AbstractClientPlayer paramAbstractClientPlayer, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
/*    */ 
/*    */   public boolean shouldCombineTextures()
/*    */   {
/* 26 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.CosmeticBase
 * JD-Core Version:    0.6.2
 */