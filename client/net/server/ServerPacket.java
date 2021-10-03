/*    */ package eclipse.client.net.server;
/*    */ 
/*    */ import eclipse.client.net.TwilightPacket;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ 
/*    */ public abstract class ServerPacket extends TwilightPacket
/*    */ {
/*    */   public void writePacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/*    */   }
/*    */ 
/*    */   public String readString(PacketBuffer buf)
/*    */   {
/* 17 */     return buf.readStringFromBuffer(buf.readInt());
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.net.server.ServerPacket
 * JD-Core Version:    0.6.2
 */