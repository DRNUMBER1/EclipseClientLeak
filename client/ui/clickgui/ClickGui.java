/*     */ package eclipse.client.ui.clickgui;
/*     */ 
/*     */ import eclipse.client.Eclipse;
/*     */ import eclipse.client.mod.Mods;
/*     */ import eclipse.client.mod.RenderedModule;
/*     */ import eclipse.client.setting.SettingManager;
/*     */ import eclipse.client.ui.SettingGui;
/*     */ import eclipse.client.ui.font.FontUtil;
/*     */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class ClickGui extends GuiScreen
/*     */ {
/*  22 */   private ArrayList<Button> btns = new ArrayList();
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  26 */     this.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
/*     */ 
/*  28 */     this.btns.clear();
/*  29 */     int x = 250;
/*  30 */     int y = 70;
/*  31 */     for (RenderedModule mod : Eclipse.client.mods.getMods()) {
/*  32 */       this.btns.add(new Button(mod, x, y));
/*  33 */       y += 50;
/*  34 */       if (y > 400) {
/*  35 */         y = 70;
/*  36 */         x += 120;
/*     */       }
/*     */     }
/*     */ 
/*  40 */     super.initGui();
/*     */   }
/*     */ 
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*     */   {
/*  45 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*  46 */     ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
/*     */ 
/*  48 */     drawRoundedRectWithTransparency(this.width / 4 - 40, 40, sr.getScaledWidth() - this.width / 4 + 40, sr.getScaledHeight() - 20, 5.0F, new Color(0, 0, 0, 125).getRGB());
/*     */ 
/*  50 */     this.mc.getTextureManager().bindTexture(new ResourceLocation("twilight/invlogo.png"));
/*  51 */     drawModalRectWithCustomSizedTexture(sr.getScaledWidth() / 2 - 50, 2, 0.0F, 0.0F, 25, 25, 25.0F, 25.0F);
/*  52 */     FontUtil.normal.drawString(Eclipse.client.name, sr.getScaledWidth() / 2 - 25, 12.0F, -1);
/*     */ 
/*  54 */     for (Button b : this.btns)
/*  55 */       b.draw();
/*     */   }
/*     */ 
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
/*     */     throws IOException
/*     */   {
/*  61 */     for (Button b : this.btns) {
/*  62 */       b.onClick(mouseX, mouseY);
/*     */     }
/*  64 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */   public void onGuiClosed()
/*     */   {
/* 108 */     if (this.mc.thePlayer != null)
/* 109 */       Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
/* 110 */     super.onGuiClosed();
/*     */   }
/*     */ 
/*     */   public boolean doesGuiPauseGame()
/*     */   {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */   private class Button extends Gui
/*     */   {
/*  68 */     private Minecraft mc = Minecraft.getMinecraft();
/*  69 */     private FontRenderer fr = this.mc.fontRendererObj;
/*     */     private RenderedModule parentMod;
/*     */     private int x;
/*     */     private int y;
/*     */ 
/*     */     public Button(RenderedModule parentMod, int x, int y)
/*     */     {
/*  75 */       this.parentMod = parentMod;
/*  76 */       this.x = x;
/*  77 */       this.y = y;
/*     */     }
/*     */ 
/*     */     public void draw() {
/*  81 */       drawRoundedRectWithTransparency(this.x, this.y, this.x + this.fr.getStringWidth(this.parentMod.name) + 6, this.y + this.fr.FONT_HEIGHT + 6, 3.0F, new Color(255, 255, 255, 120).getRGB());
/*  82 */       FontUtil.normal.drawCenteredString(this.parentMod.name, this.x + this.fr.getStringWidth(this.parentMod.name) / 2 + 3, this.y + 3, getColor());
/*  83 */       this.mc.getTextureManager().bindTexture(new ResourceLocation("twilight/setting.png"));
/*  84 */       drawModalRectWithCustomSizedTexture(this.x + this.fr.getStringWidth(this.parentMod.name) + 6, this.y, 0.0F, 0.0F, 15, 15, 15.0F, 15.0F);
/*     */     }
/*     */ 
/*     */     public void onClick(int mouseX, int mouseY) {
/*  88 */       if ((mouseX >= this.x) && (mouseY >= this.y) && (mouseX <= this.x + this.fr.getStringWidth(this.parentMod.name) + 6) && (mouseY <= this.y + this.fr.FONT_HEIGHT + 6))
/*  89 */         this.parentMod.setEnabled(!this.parentMod.enabled);
/*  90 */       else if ((mouseX >= this.x + this.fr.getStringWidth(this.parentMod.name) + 6) && (mouseY >= this.y) && (mouseX <= this.x + this.fr.getStringWidth(this.parentMod.name) + 6 + 15) && (mouseY <= this.y + 15) && 
/*  91 */         (!Eclipse.client.setMgr.getSettingsForModule(this.parentMod).isEmpty()))
/*  92 */         this.mc.displayGuiScreen(new SettingGui(this.parentMod));
/*     */     }
/*     */ 
/*     */     public int getColor()
/*     */     {
/*  98 */       if (this.parentMod.enabled) {
/*  99 */         return Color.green.getRGB();
/*     */       }
/* 101 */       return Color.red.getRGB();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.clickgui.ClickGui
 * JD-Core Version:    0.6.2
 */