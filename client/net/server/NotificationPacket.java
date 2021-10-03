/*    */ package eclipse.client.net.server;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.ui.notification.Notification;
/*    */ import eclipse.client.ui.notification.Notifications;
/*    */ import java.awt.Color;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ 
/*    */ public class NotificationPacket extends ServerPacket
/*    */ {
/*    */   public String line1;
/*    */   public String line2;
/*    */   public String line3;
/*    */ 
/*    */   public void readPacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 20 */     String[] lines = readString(buf).split(";");
/* 21 */     this.line1 = lines[0];
/* 22 */     this.line2 = lines[1];
/* 23 */     this.line3 = lines[2];
/*    */   }
/*    */ 
/*    */   public void processPacket(INetHandler handler)
/*    */   {
/* 28 */     Eclipse.client.nots.addNotification(new Notification(this.line1, this.line2, this.line3, Color.white));
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.net.server.NotificationPacket
 * JD-Core Version:    0.6.2
 */