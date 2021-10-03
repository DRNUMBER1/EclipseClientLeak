/*     */ package eclipse.client;
/*     */ 
/*     */ import co.gongzh.procbridge.Client;
/*     */ import eclipse.client.cosmetic.BadgeManager;
/*     */ import eclipse.client.cosmetic.CosmeticManager;
/*     */ import eclipse.client.events.KeyboardHit;
/*     */ import eclipse.client.events.PlayerOnTick;
/*     */ import eclipse.client.events.TickEvent;
/*     */ import eclipse.client.eventsys.EventTarget;
/*     */ import eclipse.client.http.SocketClient;
/*     */ import eclipse.client.mod.Mods;
/*     */ import eclipse.client.mod.MoveModScreen;
/*     */ import eclipse.client.mod.mods.Freelook;
/*     */ import eclipse.client.ui.ColorUtil;
/*     */ import eclipse.client.ui.notification.Notification;
/*     */ import eclipse.client.ui.notification.Notifications;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityTNTPrimed;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.util.Session;
/*     */ 
/*     */ public class ClientEvents
/*     */ {
/*  27 */   public boolean hasSent = false;
/*  28 */   public boolean hasGotSkin = false;
/*     */ 
/*  30 */   private int ticks = 0;
/*     */ 
/*  32 */   public Minecraft mc = Minecraft.getMinecraft();
/*     */ 
/*     */   @EventTarget
/*     */   public void onKey(KeyboardHit event) {
/*  36 */     if (event.k == this.mc.gameSettings.CLICKGUI.getKeyCode()) {
/*  37 */       this.mc.displayGuiScreen(new MoveModScreen());
/*     */     }
/*  39 */     if (event.k == 43)
/*  40 */       Eclipse.client.nots.addNotification(new Notification("Clicked a button :)", "So be happy", "Yay!", ColorUtil.getRainbow(4.0F, 0.8F, 1.0F)));
/*     */   }
/*     */ 
/*     */   @EventTarget
/*     */   public void onTick(TickEvent e) {
/*  45 */     if ((this.mc.gameSettings.PERSPECTIVE.isKeyDown()) && (Eclipse.client.mods.getFreelook().enabled) && (!Eclipse.client.mods.getFreelook().perspectiveToggled)) {
/*  46 */       Eclipse.client.mods.getFreelook().perspectiveToggled = true;
/*  47 */       this.mc.gameSettings.thirdPersonView = 1;
/*     */     }
/*  49 */     if ((this.mc.gameSettings.PERSPECTIVE.isKeyDown()) && (Eclipse.client.mods.getFreelook().enabled) && (Eclipse.client.mods.getFreelook().perspectiveToggled) && (!Eclipse.client.mods.getFreelook().returnOnRelease)) {
/*  50 */       Eclipse.client.mods.getFreelook().perspectiveToggled = false;
/*  51 */       this.mc.gameSettings.thirdPersonView = 0;
/*     */     }
/*  53 */     if ((!this.mc.gameSettings.PERSPECTIVE.isKeyDown()) && 
/*  54 */       (Eclipse.client.mods.getFreelook().perspectiveToggled) && (!this.mc.gameSettings.keyBindTogglePerspective.isPressed()) && 
/*  55 */       (this.mc.thePlayer != null) && (Eclipse.client.mods.getFreelook().returnOnRelease)) {
/*  56 */       this.mc.gameSettings.thirdPersonView = 0;
/*  57 */       Eclipse.client.mods.getFreelook().perspectiveToggled = false;
/*  58 */       Eclipse.client.mods.getFreelook().cameraPitch = this.mc.thePlayer.rotationPitch;
/*  59 */       Eclipse.client.mods.getFreelook().cameraYaw = this.mc.thePlayer.rotationYaw;
/*     */     }
/*     */ 
/*  62 */     if ((this.mc.gameSettings.keyBindTogglePerspective.isPressed()) && 
/*  63 */       (this.mc.thePlayer != null)) {
/*  64 */       Eclipse.client.mods.getFreelook().cameraPitch = this.mc.thePlayer.rotationPitch;
/*  65 */       Eclipse.client.mods.getFreelook().cameraYaw = this.mc.thePlayer.rotationYaw;
/*  66 */       Eclipse.client.mods.getFreelook().perspectiveToggled = false;
/*  67 */       this.mc.gameSettings.thirdPersonView = Eclipse.client.mods.getFreelook().previousPerspective;
/*     */     }
/*     */   }
/*     */ 
/*  72 */   @EventTarget
/*     */   public void onUpdate(PlayerOnTick event) { if (this.ticks <= 5000) {
/*  73 */       this.ticks += 1;
/*     */     } else {
/*  75 */       new Thread(new Runnable()
/*     */       {
/*     */         public void run() {
/*     */           try {
/*  79 */             BadgeManager.refreshBadges();
/*  80 */             CosmeticManager.refreshCosmetics();
/*  81 */             boolean banned = Boolean.parseBoolean((String)SocketClient.client.request("isBanned", Minecraft.getMinecraft().getSession().getUsername()));
/*  82 */             if (banned)
/*  83 */               throw new ReportedException(new CrashReport("You are banned from using the client. Make a ticket on the discord server.", new Exception()));
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */         }
/*     */       }
/*     */       , "Cosmetic Refresh Tick thread").start();
/*  89 */       this.ticks = 0;
/*     */     }
/*     */ 
/*  92 */     for (Notification n : Eclipse.client.nots.notifications) {
/*  93 */       n.tick();
/*     */     }
/*  95 */     ArrayList tntList = new ArrayList();
/*  96 */     for (Entity e : this.mc.theWorld.loadedEntityList) {
/*  97 */       if ((e instanceof EntityTNTPrimed)) {
/*  98 */         tntList.add((EntityTNTPrimed)e);
/*     */       }
/*     */     }
/* 101 */     if (tntList.size() > 60) {
/* 102 */       for (Entity e : this.mc.theWorld.loadedEntityList) {
/* 103 */         if ((e instanceof EntityTNTPrimed)) {
/* 104 */           this.mc.theWorld.removeEntity(e);
/*     */         }
/*     */       }
/*     */     }
/* 108 */     if ((this.mc.thePlayer != null) && (this.mc.theWorld != null) && 
/* 109 */       (!this.hasSent)) {
/* 110 */       this.hasSent = true;
/* 111 */       new Thread(new Runnable()
/*     */       {
/*     */         public void run() {
/*     */           try {
/* 115 */             SocketClient.client.request("start_client", ClientEvents.this.mc.getSession().getUsername() + ":true");
/* 116 */             Eclipse.client.online = true;
/*     */           } catch (Exception e) {
/* 118 */             Eclipse.client.online = false;
/* 119 */             System.out.println("Please use internet when using the client.");
/*     */           }
/*     */ 
/* 122 */           if (Eclipse.client.online) {
/* 123 */             BadgeManager.refreshBadges();
/* 124 */             CosmeticManager.refreshCosmetics();
/*     */           }
/*     */         }
/*     */       }
/*     */       , "Client Send Thread").start();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ClientEvents
 * JD-Core Version:    0.6.2
 */