/*     */ package eclipse.client.login;
/*     */ 
/*     */ import eclipse.client.ui.MainMenu;
/*     */ import eclipse.client.ui.font.FontUtil;
/*     */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ public final class GuiAltLogin extends GuiScreen
/*     */ {
/*     */   private PasswordField password;
/*     */   private AltLoginThread thread;
/*     */   private GuiTextField username;
/*     */ 
/*     */   protected void actionPerformed(GuiButton button)
/*     */   {
/*  25 */     switch (button.id) {
/*     */     case 1:
/*  27 */       this.mc.displayGuiScreen(new MainMenu());
/*  28 */       break;
/*     */     case 0:
/*  31 */       this.thread = new AltLoginThread(this.username.getText(), this.password.getText(), this);
/*  32 */       this.thread.start();
/*     */     case 234:
/*  35 */       this.thread = new AltLoginThread(this.username.getText(), this.password.getText(), this, true);
/*  36 */       this.thread.start();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void drawScreen(int x2, int y2, float z2)
/*     */   {
/*  43 */     drawDefaultBackground();
/*  44 */     this.username.drawTextBox();
/*  45 */     this.password.drawTextBox();
/*  46 */     FontUtil.normal.drawCenteredString("Login", this.width / 2, 20.0F, -1);
/*  47 */     FontUtil.normal.drawCenteredString(this.thread == null ? EnumChatFormatting.GRAY + "Idle..." : this.thread.getStatus(), this.width / 2, 29.0F, -1);
/*  48 */     if (this.username.getText().isEmpty()) {
/*  49 */       FontUtil.normal.drawString("Username / E-Mail", this.width / 2 - 96, 66.0F, -7829368);
/*     */     }
/*  51 */     if (this.password.getText().isEmpty()) {
/*  52 */       FontUtil.normal.drawString("Password", this.width / 2 - 96, 106.0F, -7829368);
/*     */     }
/*  54 */     super.drawScreen(x2, y2, z2);
/*     */   }
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  59 */     int var3 = this.height / 4 + 24;
/*  60 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, var3 + 72 + 12, "Login"));
/*  61 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, var3 + 72 + 12 + 24, "Back"));
/*  62 */     this.buttonList.add(new GuiButton(234, this.width / 2 - 100, var3 + 72 + 12 + 24 + 24, "Login Microsoft"));
/*  63 */     this.username = new GuiTextField(var3, FontUtil.normal, this.width / 2 - 100, 60, 200, 20);
/*  64 */     this.password = new PasswordField(FontUtil.normal, this.width / 2 - 100, 100, 200, 20);
/*  65 */     this.username.setFocused(true);
/*  66 */     Keyboard.enableRepeatEvents(true);
/*     */   }
/*     */ 
/*     */   protected void keyTyped(char character, int key)
/*     */   {
/*     */     try {
/*  72 */       super.keyTyped(character, key);
/*     */     }
/*     */     catch (IOException e) {
/*  75 */       e.printStackTrace();
/*     */     }
/*  77 */     if (character == '\t') {
/*  78 */       if ((!this.username.isFocused()) && (!this.password.isFocused())) {
/*  79 */         this.username.setFocused(true);
/*     */       } else {
/*  81 */         this.username.setFocused(this.password.isFocused());
/*  82 */         this.password.setFocused(!this.username.isFocused());
/*     */       }
/*     */     }
/*  85 */     if (character == '\r') {
/*  86 */       actionPerformed((GuiButton)this.buttonList.get(0));
/*     */     }
/*  88 */     this.username.textboxKeyTyped(character, key);
/*  89 */     this.password.textboxKeyTyped(character, key);
/*     */   }
/*     */ 
/*     */   protected void mouseClicked(int x2, int y2, int button)
/*     */   {
/*     */     try {
/*  95 */       super.mouseClicked(x2, y2, button);
/*     */     }
/*     */     catch (IOException e) {
/*  98 */       e.printStackTrace();
/*     */     }
/* 100 */     this.username.mouseClicked(x2, y2, button);
/* 101 */     this.password.mouseClicked(x2, y2, button);
/*     */   }
/*     */ 
/*     */   public void onGuiClosed()
/*     */   {
/* 106 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/* 111 */     this.username.updateCursorCounter();
/* 112 */     this.password.updateCursorCounter();
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.login.GuiAltLogin
 * JD-Core Version:    0.6.2
 */