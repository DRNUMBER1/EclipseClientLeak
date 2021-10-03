/*    */ package eclipse.client.net.client;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.util.Session;
/*    */ 
/*    */ public class HWIDPacket extends ClientPacket
/*    */ {
/*    */   public void writePacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 12 */     writeString(buf, "New connection from " + Minecraft.getMinecraft().getSession().getToken());
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.net.client.HWIDPacket
 * JD-Core Version:    0.6.2
 */