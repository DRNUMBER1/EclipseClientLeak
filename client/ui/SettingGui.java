/*    */ package eclipse.client.ui;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.setting.Setting;
/*    */ import eclipse.client.setting.SettingManager;
/*    */ import java.awt.Color;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ 
/*    */ public class SettingGui extends GuiScreen
/*    */ {
/*    */   public RenderedModule mod;
/* 19 */   public ArrayList<SettingButton> buttons = new ArrayList();
/*    */ 
/* 21 */   public SettingGui(RenderedModule mod) { this.mod = mod; }
/*    */ 
/*    */   public void initGui()
/*    */   {
/* 25 */     super.initGui();
/* 26 */     int x = 40;
/* 27 */     int y = 20;
/* 28 */     for (Setting s : Eclipse.client.setMgr.getSettingsForModule(this.mod)) {
/* 29 */       this.buttons.add(new SettingButton(s, x, y));
/* 30 */       y += 10;
/*    */     }
/*    */   }
/*    */ 
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*    */   {
/* 36 */     super.drawScreen(mouseX, mouseY, partialTicks);
/* 37 */     ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
/* 38 */     Gui.drawRect(0.0D, 0.0D, sr.getScaledWidth(), sr.getScaledHeight(), new Color(0, 0, 0, 100).getRGB());
/* 39 */     for (SettingButton b : this.buttons)
/* 40 */       b.draw();
/*    */   }
/*    */ 
/*    */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
/*    */     throws IOException
/*    */   {
/* 46 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/* 47 */     for (SettingButton b : this.buttons)
/* 48 */       b.onClick(mouseX, mouseY);
/*    */   }
/*    */ 
/*    */   private class SettingButton
/*    */   {
/* 53 */     private FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
/*    */     private Setting s;
/*    */     private int x;
/*    */     private int y;
/*    */     private int width;
/* 56 */     private int height = this.fr.FONT_HEIGHT;
/*    */ 
/* 58 */     public SettingButton(Setting s, int x, int y) { this.s = s;
/* 59 */       this.x = x;
/* 60 */       this.y = y; }
/*    */ 
/*    */     public void draw() {
/* 63 */       if (this.s.isCombo()) {
/* 64 */         Gui.drawRect(this.x, this.y, this.x + this.fr.getStringWidth(this.s.getName() + ": " + this.s.getValString()), this.y + this.fr.FONT_HEIGHT, Color.black.getRGB());
/* 65 */         this.fr.drawString(this.s.getName() + ": " + this.s.getValString(), this.x, this.y, -1);
/* 66 */         this.width = this.fr.getStringWidth(this.s.getName() + ": " + this.s.getValString());
/*    */       }
/* 69 */       else if (this.s.isCheck()) {
/* 70 */         Gui.drawRect(this.x, this.y, this.x + this.fr.getStringWidth(this.s.getName() + ": " + this.s.getValBoolean()), this.y + this.fr.FONT_HEIGHT, Color.black.getRGB());
/* 71 */         this.fr.drawString(this.s.getName() + ": " + this.s.getValBoolean(), this.x, this.y, -1);
/* 72 */         this.width = this.fr.getStringWidth(this.s.getName() + ": " + this.s.getValBoolean());
/*    */       }
/* 75 */       else if (this.s.isSlider()) {
/* 76 */         Gui.drawRect(this.x, this.y, this.x + this.fr.getStringWidth(this.s.getName() + ": " + (int)this.s.getValInt()), this.y + this.fr.FONT_HEIGHT, Color.black.getRGB());
/* 77 */         this.fr.drawString(this.s.getName() + ": " + this.s.getValInt(), this.x, this.y, -1);
/* 78 */         this.width = this.fr.getStringWidth(this.s.getName() + ": " + this.s.getValInt());
/*    */       }
/*    */     }
/*    */ 
/* 82 */     public void onClick(int mouseX, int mouseY) { if ((mouseX >= this.x) && (mouseX <= this.x + this.width) && (mouseY >= this.y) && (mouseY <= this.y + this.height))
/* 83 */         this.s.cycle();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.SettingGui
 * JD-Core Version:    0.6.2
 */