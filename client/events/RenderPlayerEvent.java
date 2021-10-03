/*    */ package eclipse.client.events;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import eclipse.client.eventsys.Event;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public final class RenderPlayerEvent extends Event
/*    */ {
/*    */ 
/*    */   @NotNull
/*    */   private final AbstractClientPlayer entity;
/*    */ 
/*    */   @NotNull
/*    */   private final RenderManager renderManager;
/*    */   private final double x;
/*    */   private final double y;
/*    */   private final double z;
/*    */   private final float partialTicks;
/*    */ 
/*    */   public RenderPlayerEvent(@NotNull AbstractClientPlayer entity, @NotNull RenderManager renderManager, double x, double y, double z, float partialTicks)
/*    */   {
/* 44 */     Preconditions.checkNotNull(entity, "entity");
/* 45 */     Preconditions.checkNotNull(renderManager, "renderManager");
/*    */ 
/* 47 */     this.entity = entity;
/* 48 */     this.renderManager = renderManager;
/* 49 */     this.x = x;
/* 50 */     this.y = y;
/* 51 */     this.z = z;
/* 52 */     this.partialTicks = partialTicks;
/*    */   }
/*    */ 
/*    */   @NotNull
/*    */   public final AbstractClientPlayer getEntity() {
/* 57 */     return this.entity;
/*    */   }
/*    */ 
/*    */   @NotNull
/*    */   public final RenderManager getRenderManager() {
/* 62 */     return this.renderManager;
/*    */   }
/*    */ 
/*    */   public final double getX() {
/* 66 */     return this.x;
/*    */   }
/*    */ 
/*    */   public final double getY() {
/* 70 */     return this.y;
/*    */   }
/*    */ 
/*    */   public final double getZ() {
/* 74 */     return this.z;
/*    */   }
/*    */ 
/*    */   public final float getPartialTicks() {
/* 78 */     return this.partialTicks;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.events.RenderPlayerEvent
 * JD-Core Version:    0.6.2
 */