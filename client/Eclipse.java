/*    */ package eclipse.client;
/*    */ 
/*    */ import co.gongzh.procbridge.Client;
/*    */ import eclipse.client.eventsys.EventManager;
/*    */ import eclipse.client.http.SocketClient;
/*    */ import eclipse.client.mod.Mods;
/*    */ import eclipse.client.mod.mods.DRPC;
/*    */ import eclipse.client.setting.SettingManager;
/*    */ import eclipse.client.ui.ClientSettings;
/*    */ import eclipse.client.ui.WebChat;
/*    */ import eclipse.client.ui.font.FontUtil;
/*    */ import eclipse.client.ui.notification.Notifications;
/*    */ import java.io.PrintStream;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.Session;
/*    */ import org.lwjgl.opengl.Display;
/*    */ 
/*    */ public class Eclipse
/*    */ {
/* 25 */   public String name = "EclipseClient"; public String version = "Beta-1";
/*    */ 
/* 27 */   public static Eclipse client = new Eclipse();
/*    */ 
/* 29 */   public ClientEvents events = new ClientEvents();
/*    */   public EventManager eventMgr;
/*    */   public SettingManager setMgr;
/*    */   public Mods mods;
/*    */   public FileIO fileIO;
/*    */   public DRPC discordRP;
/*    */   public WebChat webChat;
/*    */   public Notifications nots;
/*    */   public ClientSettings clientSet;
/* 39 */   public boolean online = false;
/*    */ 
/*    */   public void start() {
/* 42 */     this.clientSet = new ClientSettings();
/* 43 */     this.eventMgr = new EventManager();
/* 44 */     FontUtil.bootstrap();
/* 45 */     this.setMgr = new SettingManager();
/* 46 */     this.mods = new Mods();
/* 47 */     this.fileIO = new FileIO();
/* 48 */     this.discordRP = new DRPC();
/* 49 */     this.webChat = new WebChat(Minecraft.getMinecraft());
/* 50 */     this.nots = new Notifications();
/*    */ 
/* 52 */     EventManager.register(this.events);
/* 53 */     Display.setTitle(this.name + " v" + this.version);
/* 54 */     this.discordRP.start();
/*    */ 
/* 56 */     Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
/*    */     {
/*    */       public void run() {
/* 59 */         Eclipse.this.stop();
/*    */       }
/*    */     }
/*    */     , "Eclipse Client Shutdown Thread"));
/*    */   }
/*    */ 
/*    */   public void stop() {
/* 65 */     if (this.online)
/* 66 */       SocketClient.client.request("stop_client", Minecraft.getMinecraft().getSession().getUsername() + ":true");
/* 67 */     EventManager.unregister(this.events);
/* 68 */     this.fileIO.save();
/* 69 */     this.discordRP.shutdown();
/* 70 */     System.out.println("Shutting down " + this.name + "!");
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.Eclipse
 * JD-Core Version:    0.6.2
 */