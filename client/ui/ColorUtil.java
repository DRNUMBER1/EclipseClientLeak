/*   */ package eclipse.client.ui;
/*   */ 
/*   */ import java.awt.Color;
/*   */ 
/*   */ public class ColorUtil
/*   */ {
/*   */   public static Color getRainbow(float seconds, float saturation, float brightness)
/*   */   {
/* 7 */     float hue = (float)(System.currentTimeMillis() % (int)(seconds * 1000.0F)) / (seconds * 1000.0F);
/* 8 */     int color = Color.getHSBColor(hue, saturation, brightness).getRGB();
/* 9 */     return new Color(color);
/*   */   }
/*   */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.ColorUtil
 * JD-Core Version:    0.6.2
 */