/*    */ package eclipse.client.ui;
/*    */ 
/*    */ import co.gongzh.procbridge.Client;
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.http.SocketClient;
/*    */ import eclipse.client.login.GuiAltLogin;
/*    */ import eclipse.client.mod.mods.DRPC;
/*    */ import eclipse.client.ui.font.FontUtil;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiMultiplayer;
/*    */ import net.minecraft.client.gui.GuiOptions;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.GuiSelectWorld;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Session;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MainMenu extends GuiScreen
/*    */ {
/*    */   public void initGui()
/*    */   {
/* 24 */     this.buttonList.add(new GuiButton(1, 20, this.height / 2 - 80, 100, 20, "Singleplayer"));
/* 25 */     this.buttonList.add(new GuiButton(2, 20, this.height / 2 - 40, 100, 20, "Multiplayer"));
/* 26 */     this.buttonList.add(new GuiButton(3, 20, this.height / 2, 100, 20, "Options"));
/* 27 */     this.buttonList.add(new GuiButton(4, 20, this.height / 2 + 40, 100, 20, "Quit"));
/* 28 */     this.buttonList.add(new GuiButton(5, 20, this.height / 2 + 80, 100, 20, "Change Account"));
/* 29 */     Eclipse.client.discordRP.update(Eclipse.client.name, "Main Menu");
/*    */ 
/* 31 */     super.initGui();
/*    */   }
/*    */ 
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 35 */     this.mc.getTextureManager().bindTexture(new ResourceLocation("twilight/mainmenu.jpg"));
/* 36 */     drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, this.width, this.height, this.width, this.height);
/*    */ 
/* 38 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 39 */     GlStateManager.pushMatrix();
/* 40 */     GlStateManager.translate(this.width / 2.0F, this.height / 2.0F, 0.0F);
/* 41 */     GlStateManager.scale(3.0F, 3.0F, 1.0F);
/* 42 */     GlStateManager.translate(-(this.width / 2.0F), -(this.height / 2.0F), 0.0F);
/* 43 */     drawCenteredString(this.mc.fontRendererObj, Eclipse.client.name, this.width / 2, this.height / 2 - this.mc.fontRendererObj.FONT_HEIGHT / 2, -1);
/* 44 */     GlStateManager.popMatrix();
/*    */ 
/* 46 */     FontUtil.normal.drawString("Copyright Mojang AB", this.width - this.fontRendererObj.getStringWidth("Copyright Mojang AB") - 2, this.height - 20, -1);
/* 47 */     FontUtil.normal.drawString("Using Optifine HDU-L5", this.width - this.fontRendererObj.getStringWidth("Using Optifine HDU-L5") - 2, this.height - 10, -1);
/*    */ 
/* 49 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ 
/*    */   protected void actionPerformed(GuiButton button) throws IOException {
/* 53 */     switch (button.id) {
/*    */     case 1:
/* 55 */       this.mc.displayGuiScreen(new GuiSelectWorld(this));
/* 56 */       break;
/*    */     case 2:
/* 58 */       this.mc.displayGuiScreen(new GuiMultiplayer(this));
/* 59 */       break;
/*    */     case 3:
/* 61 */       this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
/* 62 */       break;
/*    */     case 4:
/* 64 */       this.mc.shutdown();
/* 65 */       break;
/*    */     case 5:
/* 67 */       new Thread(new Runnable()
/*    */       {
/*    */         public void run() {
/* 70 */           SocketClient.client.request("stop_client", Minecraft.getMinecraft().getSession().getUsername() + ":true");
/*    */         }
/*    */       }
/*    */       , "Stop Alt Thread").start();
/* 73 */       Eclipse.client.events.hasSent = false;
/* 74 */       this.mc.displayGuiScreen(new GuiAltLogin());
/*    */     }
/*    */ 
/* 77 */     super.actionPerformed(button);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.MainMenu
 * JD-Core Version:    0.6.2
 */