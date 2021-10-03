/*    */ package eclipse.client.ui.notification;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ 
/*    */ public class Notification
/*    */ {
/*    */   public String text;
/*    */   public String secondLine;
/*    */   private String thirdLine;
/* 13 */   private Minecraft mc = Minecraft.getMinecraft();
/* 14 */   private ScaledResolution sr = new ScaledResolution(this.mc);
/* 15 */   public int incrementY = 0;
/*    */   public Color lineColor;
/*    */   public int timeLeft;
/*    */ 
/*    */   public Notification(String text, Color lineColor)
/*    */   {
/* 24 */     this.text = text;
/* 25 */     this.secondLine = "";
/* 26 */     this.thirdLine = "";
/* 27 */     this.timeLeft = 200;
/* 28 */     this.lineColor = lineColor;
/*    */   }
/*    */ 
/*    */   public Notification(String text, String secondLine, Color lineColor) {
/* 32 */     this.text = text;
/* 33 */     this.secondLine = secondLine;
/* 34 */     this.thirdLine = "";
/* 35 */     this.timeLeft = 200;
/* 36 */     this.lineColor = lineColor;
/*    */   }
/*    */ 
/*    */   public Notification(String text, String secondLine, String thirdLine, Color lineColor) {
/* 40 */     this.text = text;
/* 41 */     this.secondLine = secondLine;
/* 42 */     this.thirdLine = thirdLine;
/* 43 */     this.timeLeft = 200;
/* 44 */     this.lineColor = lineColor;
/*    */   }
/*    */ 
/*    */   public void render() {
/* 48 */     if (this.timeLeft > 0) {
/* 49 */       Gui.drawRect(this.sr.getScaledWidth() - 220, this.sr.getScaledHeight() - 100 - this.incrementY, this.sr.getScaledWidth() - 20, this.sr.getScaledHeight() - 20 - this.incrementY, Color.BLACK.getRGB());
/* 50 */       this.mc.fontRendererObj.drawString(this.text, this.sr.getScaledWidth() - 215 + 5, this.sr.getScaledHeight() - 95 + 20 - this.incrementY, -1);
/* 51 */       this.mc.fontRendererObj.drawString(this.secondLine, this.sr.getScaledWidth() - 215 + 5, this.sr.getScaledHeight() - 95 + 20 - this.incrementY + 12, -1);
/* 52 */       this.mc.fontRendererObj.drawString(this.thirdLine, this.sr.getScaledWidth() - 215 + 5, this.sr.getScaledHeight() - 95 + 20 - this.incrementY + 24, -1);
/* 53 */       Gui.drawHorizontalLine(this.sr.getScaledWidth() - 220, this.sr.getScaledWidth() - 20 - this.timeLeft, this.sr.getScaledHeight() - 20 - this.incrementY, this.lineColor.getRGB());
/*    */     }
/*    */   }
/*    */ 
/*    */   public void tick() {
/* 58 */     if (this.timeLeft > 0)
/* 59 */       this.timeLeft -= 2;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.notification.Notification
 * JD-Core Version:    0.6.2
 */