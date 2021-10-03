/*     */ package eclipse.client.ui.font;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MinecraftFontRenderer extends CFont
/*     */ {
/*  12 */   CFont.CharData[] boldChars = new CFont.CharData[256];
/*  13 */   CFont.CharData[] italicChars = new CFont.CharData[256];
/*  14 */   CFont.CharData[] boldItalicChars = new CFont.CharData[256];
/*  15 */   int[] colorCode = new int[32];
/*  16 */   String colorcodeIdentifiers = "0123456789abcdefklmnor";
/*     */   DynamicTexture texBold;
/*     */   DynamicTexture texItalic;
/*     */   DynamicTexture texItalicBold;
/*     */ 
/*     */   public MinecraftFontRenderer(Font font, boolean antiAlias, boolean fractionalMetrics)
/*     */   {
/*  20 */     super(font, antiAlias, fractionalMetrics);
/*  21 */     setupMinecraftColorcodes();
/*  22 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   public int drawStringWithShadow(String text, double x2, float y2, int color)
/*     */   {
/*  27 */     float shadowWidth = drawString(text, x2 + 0.8999999761581421D, y2 + 0.5D, color, true, 8.3F);
/*     */ 
/*  29 */     return (int)Math.max(shadowWidth, drawString(text, x2, y2, color, false, 8.3F));
/*     */   }
/*     */ 
/*     */   public int drawString(String text, double x2, float y2, int color) {
/*  33 */     return (int)drawString(text, x2, y2, color, false, 8.3F);
/*     */   }
/*     */ 
/*     */   public int drawPassword(String text, double x2, float y2, int color) {
/*  37 */     return (int)drawString(text.replaceAll(".", "."), x2, y2, color, false, 8.0F);
/*     */   }
/*     */ 
/*     */   public int drawNoBSString(String text, double x2, float y2, int color) {
/*  41 */     return (int)drawNoBSString(text, x2, y2, color, false);
/*     */   }
/*     */ 
/*     */   public int drawSmoothString(String text, double x2, float y2, int color) {
/*  45 */     return (int)drawSmoothString(text, x2, y2, color, false);
/*     */   }
/*     */ 
/*     */   public double getPasswordWidth(String text) {
/*  49 */     return getStringWidth(text.replaceAll(".", "."), 8.0F);
/*     */   }
/*     */ 
/*     */   public float drawCenteredString(String text, float x2, float y2, int color) {
/*  53 */     return drawString(text, x2 - getStringWidth(text) / 2, y2, color);
/*     */   }
/*     */ 
/*     */   public float drawNoBSCenteredString(String text, float x2, float y2, int color) {
/*  57 */     return drawNoBSString(text, x2 - getStringWidth(text) / 2, y2, color);
/*     */   }
/*     */ 
/*     */   public float drawCenteredStringWithShadow(String text, float x2, float y2, int color) {
/*  61 */     return drawStringWithShadow(text, x2 - getStringWidth(text) / 2, y2, color);
/*     */   }
/*     */ 
/*     */   public float drawString(String text, double x, double y, int color, boolean shadow, float kerning) {
/*  65 */     x -= 1.0D;
/*     */ 
/*  67 */     if (text == null) {
/*  68 */       return 0.0F;
/*     */     }
/*     */ 
/*  71 */     if (color == 553648127) {
/*  72 */       color = 16777215;
/*     */     }
/*     */ 
/*  75 */     if ((color & 0xFC000000) == 0) {
/*  76 */       color |= -16777216;
/*     */     }
/*     */ 
/*  79 */     if (shadow) {
/*  80 */       color = (color & 0xFCFCFC) >> 2 | color & 0xFF000000;
/*     */     }
/*     */ 
/*  83 */     CFont.CharData[] currentData = this.charData;
/*  84 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/*  85 */     boolean randomCase = false;
/*  86 */     boolean bold = false;
/*  87 */     boolean italic = false;
/*  88 */     boolean strikethrough = false;
/*  89 */     boolean underline = false;
/*  90 */     boolean render = true;
/*  91 */     x *= 2.0D;
/*  92 */     y = (y - 3.0D) * 2.0D;
/*  93 */     GL11.glPushMatrix();
/*  94 */     GlStateManager.scale(0.5D, 0.5D, 0.5D);
/*  95 */     GlStateManager.enableBlend();
/*  96 */     GlStateManager.blendFunc(770, 771);
/*  97 */     GlStateManager.color((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/*  98 */     GlStateManager.enableTexture2D();
/*  99 */     GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 100 */     GL11.glBindTexture(3553, this.tex.getGlTextureId());
/*     */ 
/* 102 */     for (int index = 0; index < text.length(); index++) {
/* 103 */       char character = text.charAt(index);
/*     */ 
/* 105 */       if (character == '§') {
/* 106 */         int colorIndex = 21;
/*     */         try
/*     */         {
/* 109 */           colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(index + 1));
/*     */         } catch (Exception e) {
/* 111 */           e.printStackTrace();
/*     */         }
/*     */ 
/* 114 */         if (colorIndex < 16) {
/* 115 */           bold = false;
/* 116 */           italic = false;
/* 117 */           randomCase = false;
/* 118 */           underline = false;
/* 119 */           strikethrough = false;
/* 120 */           GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 121 */           currentData = this.charData;
/*     */ 
/* 123 */           if (colorIndex < 0) {
/* 124 */             colorIndex = 15;
/*     */           }
/*     */ 
/* 127 */           if (shadow) {
/* 128 */             colorIndex += 16;
/*     */           }
/*     */ 
/* 131 */           int colorcode = this.colorCode[colorIndex];
/* 132 */           GlStateManager.color((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 133 */         } else if (colorIndex == 16) {
/* 134 */           randomCase = true;
/* 135 */         } else if (colorIndex == 17) {
/* 136 */           bold = true;
/*     */ 
/* 138 */           if (italic) {
/* 139 */             GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
/* 140 */             currentData = this.boldItalicChars;
/*     */           } else {
/* 142 */             GlStateManager.bindTexture(this.texBold.getGlTextureId());
/* 143 */             currentData = this.boldChars;
/*     */           }
/* 145 */         } else if (colorIndex == 18) {
/* 146 */           strikethrough = true;
/* 147 */         } else if (colorIndex == 19) {
/* 148 */           underline = true;
/* 149 */         } else if (colorIndex == 20) {
/* 150 */           italic = true;
/*     */ 
/* 152 */           if (bold) {
/* 153 */             GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
/* 154 */             currentData = this.boldItalicChars;
/*     */           } else {
/* 156 */             GlStateManager.bindTexture(this.texItalic.getGlTextureId());
/* 157 */             currentData = this.italicChars;
/*     */           }
/*     */         } else {
/* 160 */           bold = false;
/* 161 */           italic = false;
/* 162 */           randomCase = false;
/* 163 */           underline = false;
/* 164 */           strikethrough = false;
/* 165 */           GlStateManager.color((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 166 */           GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 167 */           currentData = this.charData;
/*     */         }
/*     */ 
/* 170 */         index++;
/* 171 */       } else if (character < currentData.length) {
/* 172 */         GL11.glBegin(4);
/* 173 */         drawChar(currentData, character, (float)x, (float)y);
/* 174 */         GL11.glEnd();
/*     */ 
/* 176 */         if (strikethrough) {
/* 177 */           drawLine(x, y + currentData[character].height / 2, x + currentData[character].width - 8.0D, y + currentData[character].height / 2, 1.0F);
/*     */         }
/*     */ 
/* 180 */         if (underline) {
/* 181 */           drawLine(x, y + currentData[character].height - 2.0D, x + currentData[character].width - 8.0D, y + currentData[character].height - 2.0D, 1.0F);
/*     */         }
/*     */ 
/* 184 */         x += currentData[character].width - kerning + this.charOffset;
/*     */       }
/*     */     }
/*     */ 
/* 188 */     GL11.glHint(3155, 4352);
/* 189 */     GL11.glPopMatrix();
/* 190 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 191 */     return (float)x / 2.0F;
/*     */   }
/*     */ 
/*     */   public float drawSmoothString(String text, double x, double y, int color, boolean shadow) {
/* 195 */     x -= 1.0D;
/*     */ 
/* 197 */     if (text == null) {
/* 198 */       return 0.0F;
/*     */     }
/*     */ 
/* 201 */     CFont.CharData[] currentData = this.charData;
/* 202 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 203 */     boolean randomCase = false;
/* 204 */     boolean bold = false;
/* 205 */     boolean italic = false;
/* 206 */     boolean strikethrough = false;
/* 207 */     boolean underline = false;
/* 208 */     boolean render = true;
/* 209 */     x *= 2.0D;
/* 210 */     y = (y - 3.0D) * 2.0D;
/* 211 */     GL11.glPushMatrix();
/* 212 */     GlStateManager.scale(0.5D, 0.5D, 0.5D);
/* 213 */     GlStateManager.enableBlend();
/* 214 */     GlStateManager.blendFunc(770, 771);
/* 215 */     GlStateManager.color((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 216 */     GlStateManager.enableTexture2D();
/* 217 */     GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 218 */     GL11.glBindTexture(3553, this.tex.getGlTextureId());
/* 219 */     GL11.glTexParameteri(3553, 10241, 9729);
/* 220 */     GL11.glTexParameteri(3553, 10240, 9729);
/*     */ 
/* 222 */     for (int index = 0; index < text.length(); index++) {
/* 223 */       char character = text.charAt(index);
/*     */ 
/* 225 */       if (character == '§') {
/* 226 */         int colorIndex = 21;
/*     */         try
/*     */         {
/* 229 */           colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(index + 1));
/*     */         } catch (Exception e) {
/* 231 */           e.printStackTrace();
/*     */         }
/*     */ 
/* 234 */         if (colorIndex < 16) {
/* 235 */           bold = false;
/* 236 */           italic = false;
/* 237 */           randomCase = false;
/* 238 */           underline = false;
/* 239 */           strikethrough = false;
/* 240 */           GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 241 */           currentData = this.charData;
/*     */ 
/* 243 */           if (colorIndex < 0) {
/* 244 */             colorIndex = 15;
/*     */           }
/*     */ 
/* 247 */           if (shadow) {
/* 248 */             colorIndex += 16;
/*     */           }
/*     */ 
/* 251 */           int colorcode = this.colorCode[colorIndex];
/* 252 */           GlStateManager.color((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 253 */         } else if (colorIndex == 16) {
/* 254 */           randomCase = true;
/* 255 */         } else if (colorIndex == 17) {
/* 256 */           bold = true;
/*     */ 
/* 258 */           if (italic) {
/* 259 */             GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
/* 260 */             currentData = this.boldItalicChars;
/*     */           } else {
/* 262 */             GlStateManager.bindTexture(this.texBold.getGlTextureId());
/* 263 */             currentData = this.boldChars;
/*     */           }
/* 265 */         } else if (colorIndex == 18) {
/* 266 */           strikethrough = true;
/* 267 */         } else if (colorIndex == 19) {
/* 268 */           underline = true;
/* 269 */         } else if (colorIndex == 20) {
/* 270 */           italic = true;
/*     */ 
/* 272 */           if (bold) {
/* 273 */             GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
/* 274 */             currentData = this.boldItalicChars;
/*     */           } else {
/* 276 */             GlStateManager.bindTexture(this.texItalic.getGlTextureId());
/* 277 */             currentData = this.italicChars;
/*     */           }
/*     */         } else {
/* 280 */           bold = false;
/* 281 */           italic = false;
/* 282 */           randomCase = false;
/* 283 */           underline = false;
/* 284 */           strikethrough = false;
/* 285 */           GlStateManager.color((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 286 */           GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 287 */           currentData = this.charData;
/*     */         }
/*     */ 
/* 290 */         index++;
/* 291 */       } else if (character < currentData.length) {
/* 292 */         GL11.glBegin(4);
/* 293 */         drawChar(currentData, character, (float)x, (float)y);
/* 294 */         GL11.glEnd();
/*     */ 
/* 296 */         if (strikethrough) {
/* 297 */           drawLine(x, y + currentData[character].height / 2, x + currentData[character].width - 8.0D, y + currentData[character].height / 2, 1.0F);
/*     */         }
/*     */ 
/* 300 */         if (underline) {
/* 301 */           drawLine(x, y + currentData[character].height - 2.0D, x + currentData[character].width - 8.0D, y + currentData[character].height - 2.0D, 1.0F);
/*     */         }
/*     */ 
/* 304 */         x += currentData[character].width - 8.3F + this.charOffset;
/*     */       }
/*     */     }
/*     */ 
/* 308 */     GL11.glHint(3155, 4352);
/* 309 */     GL11.glPopMatrix();
/* 310 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 311 */     return (float)x / 2.0F;
/*     */   }
/*     */ 
/*     */   public float drawNoBSString(String text, double x, double y, int color, boolean shadow) {
/* 315 */     x -= 1.0D;
/*     */ 
/* 317 */     if (text == null) {
/* 318 */       return 0.0F;
/*     */     }
/*     */ 
/* 321 */     CFont.CharData[] currentData = this.charData;
/* 322 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 323 */     boolean randomCase = false;
/* 324 */     boolean bold = false;
/* 325 */     boolean italic = false;
/* 326 */     boolean strikethrough = false;
/* 327 */     boolean underline = false;
/* 328 */     boolean render = true;
/* 329 */     x *= 2.0D;
/* 330 */     y = (y - 3.0D) * 2.0D;
/* 331 */     GL11.glPushMatrix();
/* 332 */     GlStateManager.scale(0.5D, 0.5D, 0.5D);
/* 333 */     GlStateManager.enableBlend();
/* 334 */     GlStateManager.blendFunc(770, 771);
/* 335 */     GlStateManager.color((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 336 */     GlStateManager.enableTexture2D();
/* 337 */     GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 338 */     GL11.glBindTexture(3553, this.tex.getGlTextureId());
/* 339 */     GL11.glTexParameteri(3553, 10241, 9728);
/* 340 */     GL11.glTexParameteri(3553, 10240, 9728);
/*     */ 
/* 342 */     for (int index = 0; index < text.length(); index++) {
/* 343 */       char character = text.charAt(index);
/*     */ 
/* 345 */       if (character == '§') {
/* 346 */         int colorIndex = 21;
/*     */         try
/*     */         {
/* 349 */           colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(index + 1));
/*     */         } catch (Exception e) {
/* 351 */           e.printStackTrace();
/*     */         }
/*     */ 
/* 354 */         if (colorIndex < 16) {
/* 355 */           bold = false;
/* 356 */           italic = false;
/* 357 */           randomCase = false;
/* 358 */           underline = false;
/* 359 */           strikethrough = false;
/* 360 */           GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 361 */           currentData = this.charData;
/*     */ 
/* 363 */           if (colorIndex < 0) {
/* 364 */             colorIndex = 15;
/*     */           }
/*     */ 
/* 367 */           if (shadow) {
/* 368 */             colorIndex += 16;
/*     */           }
/*     */ 
/* 371 */           int colorcode = this.colorCode[colorIndex];
/* 372 */           GlStateManager.color((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 373 */         } else if (colorIndex == 16) {
/* 374 */           randomCase = true;
/* 375 */         } else if (colorIndex == 17) {
/* 376 */           bold = true;
/*     */ 
/* 378 */           if (italic) {
/* 379 */             GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
/* 380 */             currentData = this.boldItalicChars;
/*     */           } else {
/* 382 */             GlStateManager.bindTexture(this.texBold.getGlTextureId());
/* 383 */             currentData = this.boldChars;
/*     */           }
/* 385 */         } else if (colorIndex == 18) {
/* 386 */           strikethrough = true;
/* 387 */         } else if (colorIndex == 19) {
/* 388 */           underline = true;
/* 389 */         } else if (colorIndex == 20) {
/* 390 */           italic = true;
/*     */ 
/* 392 */           if (bold) {
/* 393 */             GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
/* 394 */             currentData = this.boldItalicChars;
/*     */           } else {
/* 396 */             GlStateManager.bindTexture(this.texItalic.getGlTextureId());
/* 397 */             currentData = this.italicChars;
/*     */           }
/*     */         } else {
/* 400 */           bold = false;
/* 401 */           italic = false;
/* 402 */           randomCase = false;
/* 403 */           underline = false;
/* 404 */           strikethrough = false;
/* 405 */           GlStateManager.color((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 406 */           GlStateManager.bindTexture(this.tex.getGlTextureId());
/* 407 */           currentData = this.charData;
/*     */         }
/*     */ 
/* 410 */         index++;
/* 411 */       } else if (character < currentData.length) {
/* 412 */         GL11.glBegin(4);
/* 413 */         drawChar(currentData, character, (float)x, (float)y);
/* 414 */         GL11.glEnd();
/*     */ 
/* 416 */         if (strikethrough) {
/* 417 */           drawLine(x, y + currentData[character].height / 2, x + currentData[character].width - 8.0D, y + currentData[character].height / 2, 1.0F);
/*     */         }
/*     */ 
/* 420 */         if (underline) {
/* 421 */           drawLine(x, y + currentData[character].height - 2.0D, x + currentData[character].width - 8.0D, y + currentData[character].height - 2.0D, 1.0F);
/*     */         }
/*     */ 
/* 424 */         x += currentData[character].width - 8.3F + this.charOffset;
/*     */       }
/*     */     }
/*     */ 
/* 428 */     GL11.glHint(3155, 4352);
/* 429 */     GL11.glPopMatrix();
/* 430 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 431 */     return (float)x / 2.0F;
/*     */   }
/*     */ 
/*     */   public int getStringWidth(String text) {
/* 435 */     if (text == null) {
/* 436 */       return 0;
/*     */     }
/*     */ 
/* 439 */     float width = 0.0F;
/* 440 */     CFont.CharData[] currentData = this.charData;
/* 441 */     boolean bold = false; boolean italic = false;
/*     */ 
/* 443 */     for (int index = 0; index < text.length(); index++) {
/* 444 */       char character = text.charAt(index);
/*     */ 
/* 446 */       if (character == '§') {
/* 447 */         int colorIndex = "0123456789abcdefklmnor".indexOf(character);
/*     */ 
/* 449 */         bold = false;
/* 450 */         italic = false;
/*     */ 
/* 452 */         index++;
/* 453 */       } else if (character < currentData.length) {
/* 454 */         width += currentData[character].width - 8.3F + this.charOffset;
/*     */       }
/*     */     }
/*     */ 
/* 458 */     return (int)(width / 2.0F);
/*     */   }
/*     */ 
/*     */   public double getStringWidth(String text, float kerning) {
/* 462 */     if (text == null) {
/* 463 */       return 0.0D;
/*     */     }
/*     */ 
/* 466 */     float width = 0.0F;
/* 467 */     CFont.CharData[] currentData = this.charData;
/* 468 */     boolean bold = false; boolean italic = false;
/*     */ 
/* 470 */     for (int index = 0; index < text.length(); index++) {
/* 471 */       char c = text.charAt(index);
/*     */ 
/* 473 */       if (c == '§') {
/* 474 */         int colorIndex = "0123456789abcdefklmnor".indexOf(c);
/*     */ 
/* 476 */         bold = false;
/* 477 */         italic = false;
/*     */ 
/* 479 */         index++;
/* 480 */       } else if (c < currentData.length) {
/* 481 */         width += currentData[c].width - kerning + this.charOffset;
/*     */       }
/*     */     }
/*     */ 
/* 485 */     return width / 2.0F;
/*     */   }
/*     */ 
/*     */   public int getHeight() {
/* 489 */     return (this.fontHeight - 8) / 2;
/*     */   }
/*     */ 
/*     */   public void setFont(Font font)
/*     */   {
/* 494 */     super.setFont(font);
/* 495 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   public void setAntiAlias(boolean antiAlias)
/*     */   {
/* 500 */     super.setAntiAlias(antiAlias);
/* 501 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   public void setFractionalMetrics(boolean fractionalMetrics)
/*     */   {
/* 506 */     super.setFractionalMetrics(fractionalMetrics);
/* 507 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   private void setupBoldItalicIDs() {
/* 511 */     this.texBold = setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
/* 512 */     this.texItalic = setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
/* 513 */     this.texItalicBold = setupTexture(this.font.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
/*     */   }
/*     */ 
/*     */   private void drawLine(double x2, double y2, double x1, double y1, float width) {
/* 517 */     GL11.glDisable(3553);
/* 518 */     GL11.glLineWidth(width);
/* 519 */     GL11.glBegin(1);
/* 520 */     GL11.glVertex2d(x2, y2);
/* 521 */     GL11.glVertex2d(x1, y1);
/* 522 */     GL11.glEnd();
/* 523 */     GL11.glEnable(3553);
/*     */   }
/*     */ 
/*     */   public List<String> wrapWords(String text, double width) {
/* 527 */     ArrayList finalWords = new ArrayList();
/*     */ 
/* 529 */     if (getStringWidth(text) > width) {
/* 530 */       String[] words = text.split(" ");
/* 531 */       StringBuilder currentWord = new StringBuilder();
/* 532 */       char lastColorCode = 65535;
/*     */ 
/* 534 */       for (String word : words) {
/* 535 */         for (int innerIndex = 0; innerIndex < word.toCharArray().length; innerIndex++) {
/* 536 */           char c = word.toCharArray()[innerIndex];
/*     */ 
/* 538 */           if ((c == '§') && (innerIndex < word.toCharArray().length - 1)) {
/* 539 */             lastColorCode = word.toCharArray()[(innerIndex + 1)];
/*     */           }
/*     */         }
/*     */ 
/* 543 */         if (getStringWidth(currentWord + word + " ") < width) {
/* 544 */           currentWord.append(word).append(" ");
/*     */         } else {
/* 546 */           finalWords.add(currentWord.toString());
/* 547 */           currentWord = new StringBuilder("§" + lastColorCode + word + " ");
/*     */         }
/*     */       }
/*     */ 
/* 551 */       if (currentWord.length() > 0)
/* 552 */         if (getStringWidth(currentWord.toString()) < width) {
/* 553 */           finalWords.add("§" + lastColorCode + currentWord + " ");
/* 554 */           currentWord = new StringBuilder();
/*     */         } else {
/* 556 */           finalWords.addAll(formatString(currentWord.toString(), width));
/*     */         }
/*     */     }
/*     */     else {
/* 560 */       finalWords.add(text);
/*     */     }
/*     */ 
/* 563 */     return finalWords;
/*     */   }
/*     */ 
/*     */   public List<String> formatString(String string, double width) {
/* 567 */     ArrayList finalWords = new ArrayList();
/* 568 */     StringBuilder currentWord = new StringBuilder();
/* 569 */     char lastColorCode = 65535;
/* 570 */     char[] chars = string.toCharArray();
/*     */ 
/* 572 */     for (int index = 0; index < chars.length; index++) {
/* 573 */       char c = chars[index];
/*     */ 
/* 575 */       if ((c == '§') && (index < chars.length - 1)) {
/* 576 */         lastColorCode = chars[(index + 1)];
/*     */       }
/*     */ 
/* 579 */       if (getStringWidth(currentWord.toString() + c) < width) {
/* 580 */         currentWord.append(c);
/*     */       } else {
/* 582 */         finalWords.add(currentWord.toString());
/* 583 */         currentWord = new StringBuilder("§" + lastColorCode + c);
/*     */       }
/*     */     }
/*     */ 
/* 587 */     if (currentWord.length() > 0) {
/* 588 */       finalWords.add(currentWord.toString());
/*     */     }
/*     */ 
/* 591 */     return finalWords;
/*     */   }
/*     */ 
/*     */   private void setupMinecraftColorcodes() {
/* 595 */     int index = 0;
/*     */ 
/* 597 */     while (index < 32) {
/* 598 */       int noClue = (index >> 3 & 0x1) * 85;
/* 599 */       int red = (index >> 2 & 0x1) * 170 + noClue;
/* 600 */       int green = (index >> 1 & 0x1) * 170 + noClue;
/* 601 */       int blue = (index & 0x1) * 170 + noClue;
/*     */ 
/* 603 */       if (index == 6) {
/* 604 */         red += 85;
/*     */       }
/*     */ 
/* 607 */       if (index >= 16) {
/* 608 */         red /= 4;
/* 609 */         green /= 4;
/* 610 */         blue /= 4;
/*     */       }
/*     */ 
/* 613 */       this.colorCode[index] = ((red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF);
/* 614 */       index++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String trimStringToWidth(String text, int width) {
/* 619 */     return trimStringToWidth(text, width, false);
/*     */   }
/*     */ 
/*     */   public String trimStringToWidthPassword(String text, int width, boolean custom) {
/* 623 */     text = text.replaceAll(".", ".");
/* 624 */     return trimStringToWidth(text, width, custom);
/*     */   }
/*     */ 
/*     */   private float getCharWidthFloat(char c) {
/* 628 */     if (c == '§')
/* 629 */       return -1.0F;
/* 630 */     if (c == ' ') {
/* 631 */       return 2.0F;
/*     */     }
/* 633 */     int var2 = ""
/* 634 */       .indexOf(c);
/*     */ 
/* 636 */     if ((c > 0) && (var2 != -1))
/* 637 */       return this.charData[var2].width / 2.0F - 4.0F;
/* 638 */     if (this.charData[c].width / 2.0F - 4.0F != 0.0F) {
/* 639 */       int var3 = (int)(this.charData[c].width / 2.0F - 4.0F) >>> 4;
/* 640 */       int var4 = (int)(this.charData[c].width / 2.0F - 4.0F) & 0xF;
/* 641 */       var3 &= 15;
/* 642 */       var4++;
/* 643 */       return (var4 - var3) / 2 + 1;
/*     */     }
/* 645 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   public String trimStringToWidth(String text, int width, boolean custom)
/*     */   {
/* 651 */     StringBuilder buffer = new StringBuilder();
/* 652 */     float lineWidth = 0.0F;
/* 653 */     int offset = custom ? text.length() - 1 : 0;
/* 654 */     int increment = custom ? -1 : 1;
/* 655 */     boolean var8 = false;
/* 656 */     boolean var9 = false;
/*     */ 
/* 658 */     for (int index = offset; (index >= 0) && (index < text.length()) && (lineWidth < width); index += increment) {
/* 659 */       char character = text.charAt(index);
/* 660 */       float charWidth = getCharWidthFloat(character);
/*     */ 
/* 662 */       if (var8) {
/* 663 */         var8 = false;
/*     */ 
/* 665 */         if ((character != 'l') && (character != 'L')) {
/* 666 */           if ((character == 'r') || (character == 'R'))
/* 667 */             var9 = false;
/*     */         }
/*     */         else
/* 670 */           var9 = true;
/*     */       }
/* 672 */       else if (charWidth < 0.0F) {
/* 673 */         var8 = true;
/*     */       } else {
/* 675 */         lineWidth += charWidth;
/*     */ 
/* 677 */         if (var9) {
/* 678 */           lineWidth += 1.0F;
/*     */         }
/*     */       }
/*     */ 
/* 682 */       if (lineWidth > width)
/*     */       {
/*     */         break;
/*     */       }
/* 686 */       if (custom)
/* 687 */         buffer.insert(0, character);
/*     */       else {
/* 689 */         buffer.append(character);
/*     */       }
/*     */     }
/*     */ 
/* 693 */     return buffer.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.font.MinecraftFontRenderer
 * JD-Core Version:    0.6.2
 */