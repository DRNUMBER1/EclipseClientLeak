/*   */ package eclipse.client.events;
/*   */ 
/*   */ import eclipse.client.eventsys.Event;
/*   */ import net.minecraft.network.Packet;
/*   */ 
/*   */ public class ReceivePacket extends Event
/*   */ {
/*   */   public Packet p;
/*   */ 
/*   */   public ReceivePacket(Packet p)
/*   */   {
/* 9 */     this.p = p;
/*   */   }
/*   */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.events.ReceivePacket
 * JD-Core Version:    0.6.2
 */