/*    */ package eclipse.client.net.client;
/*    */ 
/*    */ import eclipse.client.net.TwilightPacket;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ 
/*    */ public abstract class ClientPacket extends TwilightPacket
/*    */ {
/*    */   public void readPacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void processPacket(INetHandler handler)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void writeString(PacketBuffer buf, String string)
/*    */   {
/* 22 */     buf.writeInt(string.length());
/* 23 */     buf.writeString(string);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.net.client.ClientPacket
 * JD-Core Version:    0.6.2
 */