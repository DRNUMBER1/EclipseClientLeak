/*    */ package eclipse.client.events;
/*    */ 
/*    */ import eclipse.client.eventsys.Event;
/*    */ 
/*    */ public final class RenderEntitiesEvent extends Event
/*    */ {
/*    */   private final float partialTicks;
/*    */ 
/*    */   public RenderEntitiesEvent(float partialTicks)
/*    */   {
/* 30 */     this.partialTicks = partialTicks;
/*    */   }
/*    */ 
/*    */   public final float getPartialTicks() {
/* 34 */     return this.partialTicks;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.events.RenderEntitiesEvent
 * JD-Core Version:    0.6.2
 */