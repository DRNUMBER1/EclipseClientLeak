/*     */ package eclipse.client.ui.font;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class CFont
/*     */ {
/*  11 */   float imgSize = 512.0F;
/*  12 */   CharData[] charData = new CharData[256];
/*     */   Font font;
/*     */   boolean antiAlias;
/*     */   boolean fractionalMetrics;
/*  15 */   int fontHeight = -1; int charOffset = 0;
/*     */   DynamicTexture tex;
/*     */ 
/*     */   public CFont(Font font, boolean antiAlias, boolean fractionalMetrics)
/*     */   {
/*  19 */     this.font = font;
/*  20 */     this.antiAlias = antiAlias;
/*  21 */     this.fractionalMetrics = fractionalMetrics;
/*  22 */     this.tex = setupTexture(font, antiAlias, fractionalMetrics, this.charData);
/*     */   }
/*     */ 
/*     */   protected DynamicTexture setupTexture(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  26 */     BufferedImage img = generateFontImage(font, antiAlias, fractionalMetrics, chars);
/*     */     try
/*     */     {
/*  29 */       return new DynamicTexture(img);
/*     */     } catch (Exception e) {
/*  31 */       e.printStackTrace();
/*  32 */     }return null;
/*     */   }
/*     */ 
/*     */   protected BufferedImage generateFontImage(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars)
/*     */   {
/*  37 */     int imgSize = (int)this.imgSize;
/*  38 */     BufferedImage bufferedImage = new BufferedImage(imgSize, imgSize, 2);
/*  39 */     Graphics2D graphics = (Graphics2D)bufferedImage.getGraphics();
/*  40 */     graphics.setFont(font);
/*  41 */     graphics.setColor(new Color(255, 255, 255, 0));
/*  42 */     graphics.fillRect(0, 0, imgSize, imgSize);
/*  43 */     graphics.setColor(Color.WHITE);
/*  44 */     graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, fractionalMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
/*  45 */     graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, antiAlias ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*  46 */     graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, antiAlias ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
/*  47 */     FontMetrics fontMetrics = graphics.getFontMetrics();
/*  48 */     int charHeight = 0;
/*  49 */     int positionX = 0;
/*  50 */     int positionY = 1;
/*  51 */     int index = 0;
/*     */ 
/*  53 */     while (index < chars.length) {
/*  54 */       char c = (char)index;
/*  55 */       CharData charData = new CharData();
/*  56 */       Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(c), graphics);
/*  57 */       charData.width = (dimensions.getBounds().width + 8);
/*  58 */       charData.height = dimensions.getBounds().height;
/*     */ 
/*  60 */       if (positionX + charData.width >= imgSize) {
/*  61 */         positionX = 0;
/*  62 */         positionY += charHeight;
/*  63 */         charHeight = 0;
/*     */       }
/*     */ 
/*  66 */       if (charData.height > charHeight) {
/*  67 */         charHeight = charData.height;
/*     */       }
/*     */ 
/*  70 */       charData.storedX = positionX;
/*  71 */       charData.storedY = positionY;
/*     */ 
/*  73 */       if (charData.height > this.fontHeight) {
/*  74 */         this.fontHeight = charData.height;
/*     */       }
/*     */ 
/*  77 */       chars[index] = charData;
/*  78 */       graphics.drawString(String.valueOf(c), positionX + 2, positionY + fontMetrics.getAscent());
/*  79 */       positionX += charData.width;
/*  80 */       index++;
/*     */     }
/*     */ 
/*  83 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */   public void drawChar(CharData[] chars, char c, float x, float y) throws ArrayIndexOutOfBoundsException {
/*     */     try {
/*  88 */       drawQuad(x, y, chars[c].width, chars[c].height, chars[c].storedX, chars[c].storedY, chars[c].width, chars[c].height);
/*     */     } catch (Exception e) {
/*  90 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void drawQuad(float x2, float y2, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
/*  95 */     float renderSRCX = srcX / this.imgSize;
/*  96 */     float renderSRCY = srcY / this.imgSize;
/*  97 */     float renderSRCWidth = srcWidth / this.imgSize;
/*  98 */     float renderSRCHeight = srcHeight / this.imgSize;
/*  99 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 100 */     GL11.glVertex2d(x2 + width, y2);
/* 101 */     GL11.glTexCoord2f(renderSRCX, renderSRCY);
/* 102 */     GL11.glVertex2d(x2, y2);
/* 103 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 104 */     GL11.glVertex2d(x2, y2 + height);
/* 105 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 106 */     GL11.glVertex2d(x2, y2 + height);
/* 107 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
/* 108 */     GL11.glVertex2d(x2 + width, y2 + height);
/* 109 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 110 */     GL11.glVertex2d(x2 + width, y2);
/*     */   }
/*     */ 
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 114 */     if (this.antiAlias != antiAlias) {
/* 115 */       this.antiAlias = antiAlias;
/* 116 */       this.tex = setupTexture(this.font, antiAlias, this.fractionalMetrics, this.charData);
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isFractionalMetrics() {
/* 121 */     return this.fractionalMetrics;
/*     */   }
/*     */ 
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 125 */     if (this.fractionalMetrics != fractionalMetrics) {
/* 126 */       this.fractionalMetrics = fractionalMetrics;
/* 127 */       this.tex = setupTexture(this.font, this.antiAlias, fractionalMetrics, this.charData);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setFont(Font font) {
/* 132 */     this.font = font;
/* 133 */     this.tex = setupTexture(font, this.antiAlias, this.fractionalMetrics, this.charData);
/*     */   }
/*     */ 
/*     */   protected static class CharData
/*     */   {
/*     */     public int width;
/*     */     public int height;
/*     */     public int storedX;
/*     */     public int storedY;
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.font.CFont
 * JD-Core Version:    0.6.2
 */