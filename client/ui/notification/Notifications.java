/*    */ package eclipse.client.ui.notification;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Notifications
/*    */ {
/*  6 */   public ArrayList<Notification> notifications = new ArrayList();
/*    */ 
/*    */   public void addNotification(Notification n) {
/*  9 */     if (!this.notifications.isEmpty()) this.notifications.clear();
/* 10 */     this.notifications.add(n);
/* 11 */     System.out.println("new notification " + n.text);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.notification.Notifications
 * JD-Core Version:    0.6.2
 */