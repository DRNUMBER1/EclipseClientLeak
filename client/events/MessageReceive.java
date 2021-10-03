/*   */ package eclipse.client.events;
/*   */ 
/*   */ import eclipse.client.eventsys.Event;
/*   */ 
/*   */ public class MessageReceive extends Event
/*   */ {
/*   */   public String message;
/*   */ 
/*   */   public MessageReceive(String message)
/*   */   {
/* 8 */     this.message = message;
/*   */   }
/*   */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.events.MessageReceive
 * JD-Core Version:    0.6.2
 */