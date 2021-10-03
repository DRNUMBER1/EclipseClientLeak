/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import net.arikia.dev.drpc.DiscordEventHandlers;
/*    */ import net.arikia.dev.drpc.DiscordEventHandlers.Builder;
/*    */ import net.arikia.dev.drpc.DiscordRPC;
/*    */ import net.arikia.dev.drpc.DiscordRichPresence.Builder;
/*    */ import net.arikia.dev.drpc.DiscordUser;
/*    */ import net.arikia.dev.drpc.callbacks.ReadyCallback;
/*    */ 
/*    */ public class DRPC
/*    */ {
/* 10 */   private boolean running = true;
/* 11 */   private long created = 0L;
/*    */ 
/* 13 */   public void start() { this.created = System.currentTimeMillis();
/*    */ 
/* 15 */     DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback()
/*    */     {
/*    */       public void apply(DiscordUser user) {
/* 18 */         System.out.println("Hello " + user.username + "#" + user.discriminator);
/* 19 */         DRPC.this.update("Booting up", "Booting up the client");
/*    */       }
/*    */     }).build();
/*    */ 
/* 23 */     DiscordRPC.discordInitialize("884793891054845953", handlers, true);
/*    */ 
/* 25 */     new Thread("Discord RPC Callback")
/*    */     {
/*    */       public void run() {
/* 28 */         while (DRPC.this.running)
/* 29 */           DiscordRPC.discordRunCallbacks();
/*    */       }
/*    */     }
/* 32 */     .start(); }
/*    */ 
/*    */   public void shutdown() {
/* 35 */     this.running = false;
/* 36 */     DiscordRPC.discordShutdown();
/*    */   }
/*    */   public void update(String firstLine, String secondLine) {
/* 39 */     DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
/* 40 */     b.setBigImage("large", "");
/* 41 */     b.setDetails(firstLine);
/* 42 */     b.setStartTimestamps(this.created);
/*    */ 
/* 44 */     DiscordRPC.discordUpdatePresence(b.build());
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.DRPC
 * JD-Core Version:    0.6.2
 */