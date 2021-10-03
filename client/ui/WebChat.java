/*    */ package eclipse.client.ui;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.http.SocketClient;
/*    */ import eclipse.client.mod.Mods;
/*    */ import eclipse.client.mod.mods.AntiCheat;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiNewChat;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.util.Session;
/*    */ 
/*    */ public class WebChat extends GuiNewChat
/*    */ {
/*    */   public WebChat(Minecraft mcIn)
/*    */   {
/* 15 */     super(mcIn);
/*    */   }
/*    */ 
/*    */   public void addWebMessage(final String message) {
/* 19 */     if (message.startsWith(".")) {
/* 20 */       if (message.startsWith(".hackers")) {
/* 21 */         ArrayList hackers = new ArrayList();
/* 22 */         for (EntityPlayer e : Eclipse.client.mods.getAntiCheat().hackerList.keySet()) {
/* 23 */           hackers.add(e.getDisplayName().getUnformattedText());
/*    */         }
/* 25 */         printChatMessage(new ChatComponentText(String.join(", ", hackers)));
/* 26 */         printChatMessage(new ChatComponentText(String.join(", ", Eclipse.client.mods.getAntiCheat().hackerList.values())));
/*    */       }
/* 28 */       return;
/*    */     }
/* 30 */     printChatMessage(new ChatComponentText("§7[§2Web§7]§f: §e" + message));
/* 31 */     if (Eclipse.client.online)
/* 32 */       new Thread(new Runnable() { public void run() { SocketClient.sendRequest(new String[] { WebChat.this.mc.getSession().getUsername() + ": ", message }); }
/*    */ 
/*    */       }
/*    */       , "Message Send Thread").start();
/*    */     else
/* 34 */       printChatMessage(new ChatComponentText("[Error]: Failed to send message"));
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.WebChat
 * JD-Core Version:    0.6.2
 */