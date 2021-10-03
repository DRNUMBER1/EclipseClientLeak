/*    */ package eclipse.client.cosmetic.pets;
/*    */ 
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderHamster extends RenderLiving<EntityHamster>
/*    */ {
/* 26 */   private ResourceLocation hamsterTexture = new ResourceLocation("twilight/hamster.png");
/*    */ 
/*    */   public RenderHamster(RenderManager rendermanagerIn) {
/* 29 */     super(rendermanagerIn, new HamsterModel(), 0.2F);
/*    */   }
/*    */ 
/*    */   protected ResourceLocation getEntityTexture(EntityHamster entity)
/*    */   {
/* 34 */     return this.hamsterTexture;
/*    */   }
/*    */ 
/*    */   protected void preRenderCallback(EntityHamster entitylivingbaseIn, float partialTickTime)
/*    */   {
/* 39 */     super.preRenderCallback(entitylivingbaseIn, partialTickTime);
/* 40 */     GlStateManager.scale(0.5D, 0.5D, 0.5D);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.pets.RenderHamster
 * JD-Core Version:    0.6.2
 */