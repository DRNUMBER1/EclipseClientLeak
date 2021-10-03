/*    */ package eclipse.client.login;
/*    */ 
/*    */ import com.mojang.authlib.Agent;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import com.mojang.authlib.exceptions.AuthenticationException;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*    */ import fr.litarvan.openauth.microsoft.MicrosoftAuthResult;
/*    */ import fr.litarvan.openauth.microsoft.MicrosoftAuthenticationException;
/*    */ import fr.litarvan.openauth.microsoft.MicrosoftAuthenticator;
/*    */ import fr.litarvan.openauth.microsoft.model.response.MinecraftProfile;
/*    */ import java.net.Proxy;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.Session;
/*    */ 
/*    */ public final class AltLoginThread extends Thread
/*    */ {
/*    */   private final String password;
/*    */   private String status;
/*    */   private final String username;
/* 23 */   private Minecraft mc = Minecraft.getMinecraft();
/*    */   private GuiAltLogin g;
/* 25 */   private boolean microsoft = false;
/*    */ 
/*    */   public AltLoginThread(String username, String password, GuiAltLogin g) {
/* 28 */     super("Alt Login Thread");
/* 29 */     this.username = username;
/* 30 */     this.password = password;
/* 31 */     this.g = g;
/* 32 */     this.status = (EnumChatFormatting.GRAY + "Waiting...");
/*    */   }
/*    */ 
/*    */   public AltLoginThread(String username, String password, GuiAltLogin g, boolean microsoft) {
/* 36 */     super("Alt Login Thread");
/* 37 */     this.username = username;
/* 38 */     this.password = password;
/* 39 */     this.g = g;
/* 40 */     this.status = (EnumChatFormatting.GRAY + "Waiting...");
/* 41 */     this.microsoft = true;
/*    */   }
/*    */ 
/*    */   private Session createSession(String username, String password) {
/* 45 */     YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
/* 46 */     YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
/* 47 */     auth.setUsername(username);
/* 48 */     auth.setPassword(password);
/*    */     try {
/* 50 */       auth.logIn();
/* 51 */       return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
/*    */     }
/*    */     catch (AuthenticationException localAuthenticationException) {
/* 54 */       localAuthenticationException.printStackTrace();
/* 55 */     }return null;
/*    */   }
/*    */ 
/*    */   public String getStatus()
/*    */   {
/* 60 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 65 */     if (this.password.equals("")) {
/* 66 */       this.mc.session = new Session(this.username, "", "", "mojang");
/* 67 */       this.status = (EnumChatFormatting.GREEN + "Logged in. (" + this.username + " - offline name)");
/* 68 */       return;
/*    */     }
/* 70 */     if (this.microsoft) {
/* 71 */       this.status = (EnumChatFormatting.YELLOW + "Logging in...");
/* 72 */       MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
/*    */       try {
/* 74 */         MicrosoftAuthResult acc = authenticator.loginWithCredentials(this.username, this.password);
/* 75 */         this.mc.session = new Session(acc.getProfile().getName(), acc.getProfile().getId(), acc.getAccessToken(), "legacy");
/* 76 */         this.status = (EnumChatFormatting.GREEN + "Logged in - " + acc.getProfile().getName() + " (Microsoft)");
/*    */       } catch (MicrosoftAuthenticationException e) {
/* 78 */         this.status = (EnumChatFormatting.RED + "Login failed!");
/*    */       }
/* 80 */       return;
/*    */     }
/* 82 */     this.status = (EnumChatFormatting.YELLOW + "Logging in...");
/* 83 */     Session auth = createSession(this.username, this.password);
/* 84 */     if (auth == null) {
/* 85 */       this.status = (EnumChatFormatting.RED + "Login failed!");
/*    */     } else {
/* 87 */       this.status = (EnumChatFormatting.GREEN + "Logged in. (" + auth.getUsername() + ")");
/* 88 */       this.mc.session = auth;
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setStatus(String status) {
/* 93 */     this.status = status;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.login.AltLoginThread
 * JD-Core Version:    0.6.2
 */