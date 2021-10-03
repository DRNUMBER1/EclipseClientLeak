/*    */ package eclipse.client.eventsys;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public abstract class Event
/*    */ {
/*    */   private boolean cancelled;
/*    */ 
/*    */   public Event call()
/*    */   {
/* 48 */     this.cancelled = false;
/* 49 */     call(this);
/* 50 */     return this;
/*    */   }
/*    */ 
/*    */   public boolean isCancelled()
/*    */   {
/* 55 */     return this.cancelled;
/*    */   }
/*    */ 
/*    */   public void setCancelled(boolean cancelled)
/*    */   {
/* 60 */     this.cancelled = cancelled;
/*    */   }
/*    */ 
/*    */   private static final void call(Event event)
/*    */   {
/* 65 */     ArrayHelper dataList = EventManager.get(event.getClass());
/*    */ 
/* 67 */     if (dataList != null)
/* 68 */       for (Data data : dataList)
/*    */         try
/*    */         {
/* 71 */           data.target.invoke(data.source, new Object[] { event });
/*    */         } catch (IllegalAccessException e) {
/* 73 */           e.printStackTrace();
/*    */         } catch (InvocationTargetException e) {
/* 75 */           e.printStackTrace();
/*    */         }
/*    */   }
/*    */ 
/*    */   public static enum State
/*    */   {
/* 37 */     PRE("PRE", 0), 
/*    */ 
/* 39 */     POST("POST", 1);
/*    */ 
/*    */     private State(String string, int number)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.eventsys.Event
 * JD-Core Version:    0.6.2
 */