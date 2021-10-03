/*    */ package eclipse.client.cosmetic;
/*    */ 
/*    */ import co.gongzh.procbridge.Client;
/*    */ import eclipse.client.http.SocketClient;
/*    */ import java.io.PrintStream;
/*    */ import java.util.HashMap;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ 
/*    */ public class CapeManager
/*    */ {
/* 16 */   private static HashMap<String, String> capeList = new HashMap();
/*    */ 
/* 18 */   public static boolean hasCape(AbstractClientPlayer p) { return capeList.containsKey(p.getNameClear()); }
/*    */ 
/*    */   public static String getCape(AbstractClientPlayer p) {
/* 21 */     return (String)capeList.get(p.getNameClear());
/*    */   }
/*    */   public static void refreshCape() {
/*    */     try {
/* 25 */       String[] capeLines = ((String)SocketClient.client.request("getCape", "")).split(":");
/* 26 */       capeList.clear();
/* 27 */       String[] arrayOfString1 = capeLines; int j = capeLines.length; for (int i = 0; i < j; i++) { String line = arrayOfString1[i];
/* 28 */         String[] temp = line.split("-");
/* 29 */         capeList.put(temp[0], temp[1]);
/*    */       }
/* 31 */       System.out.println(String.join(", ", capeLines));
/*    */     } catch (Exception e) {
/* 33 */       System.out.println("Failed to reload cape!");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.CapeManager
 * JD-Core Version:    0.6.2
 */