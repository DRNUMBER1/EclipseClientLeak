/*     */ package eclipse.client.cosmetic;
/*     */ 
/*     */ import co.gongzh.procbridge.Client;
/*     */ import eclipse.client.Eclipse;
/*     */ import eclipse.client.http.SocketClient;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ 
/*     */ public class CosmeticManager
/*     */   implements Runnable
/*     */ {
/*  22 */   public static HashMap<String, WingType> allowedWingsUsers = new HashMap();
/*  23 */   public static HashMap<String, BandanaType> allowedBandanaUsers = new HashMap();
/*  24 */   public static HashMap<String, MaskType> allowedMaskUsers = new HashMap();
/*     */   private static Thread thread;
/*     */ 
/*     */   public static void start()
/*     */   {
/*  28 */     thread = new Thread(new CosmeticManager(), "Cosmetic Thread");
/*  29 */     thread.start();
/*     */   }
/*     */ 
/*     */   public static void finish() {
/*     */     try {
/*  34 */       thread.join();
/*     */     } catch (InterruptedException e) {
/*  36 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*  42 */     if (Eclipse.client.online)
/*  43 */       refreshCosmetics();
/*  44 */     CapeManager.refreshCape();
/*  45 */     Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Refreshed Cosmetics!"));
/*  46 */     finish();
/*     */   }
/*     */   public static boolean ownsWings(AbstractClientPlayer p) {
/*  49 */     return allowedWingsUsers.containsKey(p.getNameClear());
/*     */   }
/*     */   public static WingType getWing(AbstractClientPlayer p) {
/*  52 */     return (WingType)allowedWingsUsers.get(p.getNameClear());
/*     */   }
/*     */   public static boolean ownsBandana(AbstractClientPlayer p) {
/*  55 */     return allowedBandanaUsers.containsKey(p.getNameClear());
/*     */   }
/*     */   public static BandanaType getBandana(AbstractClientPlayer p) {
/*  58 */     return (BandanaType)allowedBandanaUsers.get(p.getNameClear());
/*     */   }
/*     */   public static boolean ownsMask(AbstractClientPlayer p) {
/*  61 */     return allowedMaskUsers.containsKey(p.getNameClear());
/*     */   }
/*     */   public static MaskType getMask(AbstractClientPlayer p) {
/*  64 */     return (MaskType)allowedMaskUsers.get(p.getNameClear());
/*     */   }
/*     */   public static void refreshCosmetics() {
/*     */     try {
/*  68 */       String[] wingLines = ((String)SocketClient.client.request("getWings", "")).split(":");
/*  69 */       String[] bandanaLines = ((String)SocketClient.client.request("getBandana", "")).split(":");
/*  70 */       String[] maskLines = ((String)SocketClient.client.request("getMask", "")).split(":");
/*  71 */       allowedWingsUsers.clear();
/*  72 */       allowedBandanaUsers.clear();
/*  73 */       allowedMaskUsers.clear();
/*  74 */       String[] arrayOfString1 = wingLines; int j = wingLines.length; for (int i = 0; i < j; i++) { String line = arrayOfString1[i];
/*  75 */         String[] temp = line.split("-");
/*  76 */         allowedWingsUsers.put(temp[0], WingType.valueOf(temp[1].toUpperCase()));
/*     */       }
/*  78 */       for (String line : bandanaLines) {
/*  79 */         String[] temp = line.split("-");
/*  80 */         allowedBandanaUsers.put(temp[0], BandanaType.valueOf(temp[1].toLowerCase()));
/*     */       }
/*  82 */       for (String line : maskLines) {
/*  83 */         String[] temp = line.split("-");
/*  84 */         allowedMaskUsers.put(temp[0], MaskType.valueOf(temp[1].toLowerCase()));
/*     */       }
/*     */     } catch (Exception e) {
/*  87 */       System.out.println("ERROR!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static enum BandanaType
/*     */   {
/*  95 */     uwuband, 
/*  96 */     staffband;
/*     */   }
/*     */   public static enum MaskType {
/*  99 */     covidmask, 
/* 100 */     staffmask;
/*     */   }
/*     */ 
/*     */   public static enum WingType
/*     */   {
/*  91 */     REGULAR, 
/*  92 */     WHITE;
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.CosmeticManager
 * JD-Core Version:    0.6.2
 */