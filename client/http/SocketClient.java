/*    */ package eclipse.client.http;
/*    */ 
/*    */ import co.gongzh.procbridge.Client;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class SocketClient
/*    */ {
/*  7 */   public static final Client client = new Client("46.101.3.75", 254);
/*    */ 
/*    */   public static Object sendRequest(String[] args) {
/* 10 */     return client.request("echo", String.join(" ", args));
/*    */   }
/*    */ 
/*    */   public static boolean isUser(String username) throws Exception {
/* 14 */     String[] arguments = client.request("isUser", username).toString().split(":");
/* 15 */     if (arguments[0].equals("true"))
/* 16 */       return true;
/* 17 */     if (arguments[0].equals("false")) {
/* 18 */       return false;
/*    */     }
/* 20 */     System.out.println("Extremely annoying issue with: " + username);
/* 21 */     return false;
/*    */   }
/*    */ 
/*    */   public static double randomNumber(double max, double min)
/*    */   {
/* 26 */     return Math.random() * (max - min) + min;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.http.SocketClient
 * JD-Core Version:    0.6.2
 */