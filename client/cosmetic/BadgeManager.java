/*    */ package eclipse.client.cosmetic;
/*    */ 
/*    */ import co.gongzh.procbridge.Client;
/*    */ import eclipse.client.http.SocketClient;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class BadgeManager
/*    */ {
/*  8 */   public static ArrayList<String> onlineUsers = new ArrayList();
/*    */ 
/*    */   public static void refreshBadges() {
/*    */     try {
/* 12 */       String[] lines = ((String)SocketClient.client.request("badge", new Object())).split(":");
/* 13 */       String[] arrayOfString1 = lines; int j = lines.length; for (int i = 0; i < j; i++) { String s = arrayOfString1[i];
/* 14 */         onlineUsers.add(s);
/*    */       }
/* 16 */       System.out.println("Refreshed Badges");
/*    */     } catch (Exception e) {
/* 18 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.BadgeManager
 * JD-Core Version:    0.6.2
 */