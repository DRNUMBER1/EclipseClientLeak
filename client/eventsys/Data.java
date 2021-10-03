/*    */ package eclipse.client.eventsys;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class Data
/*    */ {
/*    */   public final Object source;
/*    */   public final Method target;
/*    */   public final byte priority;
/*    */ 
/*    */   Data(Object source, Method target, byte priority)
/*    */   {
/* 18 */     this.source = source;
/* 19 */     this.target = target;
/* 20 */     this.priority = priority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.eventsys.Data
 * JD-Core Version:    0.6.2
 */