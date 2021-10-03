/*     */ package eclipse.client.ui;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class RenderingUtil
/*     */ {
/*     */   public static void drawGradient(double x, double y, double x2, double y2, int col1, int col2)
/*     */   {
/*  19 */     float f = (col1 >> 24 & 0xFF) / 255.0F;
/*  20 */     float f1 = (col1 >> 16 & 0xFF) / 255.0F;
/*  21 */     float f2 = (col1 >> 8 & 0xFF) / 255.0F;
/*  22 */     float f3 = (col1 & 0xFF) / 255.0F;
/*     */ 
/*  24 */     float f4 = (col2 >> 24 & 0xFF) / 255.0F;
/*  25 */     float f5 = (col2 >> 16 & 0xFF) / 255.0F;
/*  26 */     float f6 = (col2 >> 8 & 0xFF) / 255.0F;
/*  27 */     float f7 = (col2 & 0xFF) / 255.0F;
/*     */ 
/*  29 */     GL11.glEnable(3042);
/*  30 */     GL11.glDisable(3553);
/*  31 */     GL11.glBlendFunc(770, 771);
/*  32 */     GL11.glEnable(2848);
/*  33 */     GL11.glShadeModel(7425);
/*     */ 
/*  35 */     GL11.glPushMatrix();
/*  36 */     GL11.glBegin(7);
/*  37 */     GL11.glColor4f(f1, f2, f3, f);
/*  38 */     GL11.glVertex2d(x2, y);
/*  39 */     GL11.glVertex2d(x, y);
/*     */ 
/*  41 */     GL11.glColor4f(f5, f6, f7, f4);
/*  42 */     GL11.glVertex2d(x, y2);
/*  43 */     GL11.glVertex2d(x2, y2);
/*  44 */     GL11.glEnd();
/*  45 */     GL11.glPopMatrix();
/*     */ 
/*  47 */     GL11.glEnable(3553);
/*  48 */     GL11.glDisable(3042);
/*  49 */     GL11.glDisable(2848);
/*  50 */     GL11.glShadeModel(7424);
/*     */   }
/*     */ 
/*     */   public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
/*  54 */     float f = (col1 >> 24 & 0xFF) / 255.0F;
/*  55 */     float f1 = (col1 >> 16 & 0xFF) / 255.0F;
/*  56 */     float f2 = (col1 >> 8 & 0xFF) / 255.0F;
/*  57 */     float f3 = (col1 & 0xFF) / 255.0F;
/*     */ 
/*  59 */     float f4 = (col2 >> 24 & 0xFF) / 255.0F;
/*  60 */     float f5 = (col2 >> 16 & 0xFF) / 255.0F;
/*  61 */     float f6 = (col2 >> 8 & 0xFF) / 255.0F;
/*  62 */     float f7 = (col2 & 0xFF) / 255.0F;
/*  63 */     GL11.glEnable(3042);
/*  64 */     GL11.glDisable(3553);
/*  65 */     GL11.glBlendFunc(770, 771);
/*  66 */     GL11.glEnable(2848);
/*  67 */     GL11.glShadeModel(7425);
/*     */ 
/*  69 */     GL11.glPushMatrix();
/*  70 */     GL11.glBegin(7);
/*  71 */     GL11.glColor4f(f1, f2, f3, f);
/*  72 */     GL11.glVertex2d(left, top);
/*  73 */     GL11.glVertex2d(left, bottom);
/*     */ 
/*  75 */     GL11.glColor4f(f5, f6, f7, f4);
/*  76 */     GL11.glVertex2d(right, bottom);
/*  77 */     GL11.glVertex2d(right, top);
/*  78 */     GL11.glEnd();
/*  79 */     GL11.glPopMatrix();
/*     */ 
/*  81 */     GL11.glEnable(3553);
/*  82 */     GL11.glDisable(3042);
/*  83 */     GL11.glDisable(2848);
/*  84 */     GL11.glShadeModel(7424);
/*  85 */     GL11.glColor4d(255.0D, 255.0D, 255.0D, 255.0D);
/*     */   }
/*     */ 
/*     */   public static void pre3D() {
/*  89 */     GL11.glPushMatrix();
/*  90 */     GL11.glEnable(3042);
/*  91 */     GL11.glBlendFunc(770, 771);
/*  92 */     GL11.glShadeModel(7425);
/*  93 */     GL11.glDisable(3553);
/*  94 */     GL11.glEnable(2848);
/*  95 */     GL11.glDisable(2929);
/*  96 */     GL11.glDisable(2896);
/*  97 */     GL11.glDepthMask(false);
/*  98 */     GL11.glHint(3154, 4354);
/*     */   }
/*     */ 
/*     */   public static void post3D() {
/* 102 */     GL11.glDepthMask(true);
/* 103 */     GL11.glEnable(2929);
/* 104 */     GL11.glDisable(2848);
/* 105 */     GL11.glEnable(3553);
/* 106 */     GL11.glDisable(3042);
/* 107 */     GL11.glPopMatrix();
/* 108 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   public static void glColor(float alpha, int redRGB, int greenRGB, int blueRGB) {
/* 112 */     float red = 0.003921569F * redRGB;
/* 113 */     float green = 0.003921569F * greenRGB;
/* 114 */     float blue = 0.003921569F * blueRGB;
/* 115 */     GL11.glColor4f(red, green, blue, alpha);
/*     */   }
/*     */ 
/*     */   public static void drawRect(float x, float y, float x1, float y1) {
/* 119 */     GL11.glBegin(7);
/* 120 */     GL11.glVertex2f(x, y1);
/* 121 */     GL11.glVertex2f(x1, y1);
/* 122 */     GL11.glVertex2f(x1, y);
/* 123 */     GL11.glVertex2f(x, y);
/* 124 */     GL11.glEnd();
/*     */   }
/*     */ 
/*     */   public static void glColor(int hex) {
/* 128 */     float alpha = (hex >> 24 & 0xFF) / 255.0F;
/* 129 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/* 130 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/* 131 */     float blue = (hex & 0xFF) / 255.0F;
/* 132 */     GL11.glColor4f(red, green, blue, alpha);
/*     */   }
/*     */ 
/*     */   public static void drawRect(float x, float y, float x1, float y1, int color) {
/* 136 */     enableGL2D();
/* 137 */     glColor(color);
/* 138 */     drawRect(x, y, x1, y1);
/* 139 */     disableGL2D();
/*     */   }
/*     */ 
/*     */   public static void drawRoundedRect(int x, int y, int x1, int y1, int borderC, int insideC) {
/* 143 */     Gui.drawRect((int)(x + 0.5F), y, (int)(x1 - 0.5F), (int)(y + 0.5F), insideC);
/* 144 */     Gui.drawRect((int)(x + 0.5F), (int)(y1 - 0.5F), (int)(x1 - 0.5F), y1, insideC);
/* 145 */     Gui.drawRect(x, (int)(y + 0.5F), x1, (int)(y1 - 0.5F), insideC);
/*     */   }
/*     */   public static void drawRoundedRect(int xCoord, int yCoord, int width, int height, int colour) {
/* 148 */     drawRect(xCoord + 1, yCoord, width - 1, height, colour);
/* 149 */     drawRect(xCoord, yCoord + 1, width, height - 1, colour);
/*     */   }
/*     */ 
/*     */   public static void drawVLine(float x, float y, float x1, float y1, float width, int color) {
/* 153 */     if (width <= 0.0F) {
/* 154 */       return;
/*     */     }
/* 156 */     GL11.glPushMatrix();
/* 157 */     pre3D();
/* 158 */     float var11 = (color >> 24 & 0xFF) / 255.0F;
/* 159 */     float var6 = (color >> 16 & 0xFF) / 255.0F;
/* 160 */     float var7 = (color >> 8 & 0xFF) / 255.0F;
/* 161 */     float var8 = (color & 0xFF) / 255.0F;
/* 162 */     GlStateManager.enableAlpha();
/* 163 */     GlStateManager.enableBlend();
/*     */ 
/* 165 */     int shade = GL11.glGetInteger(2900);
/* 166 */     GlStateManager.shadeModel(7425);
/* 167 */     GL11.glColor4f(var6, var7, var8, var11);
/* 168 */     float line = GL11.glGetFloat(2849);
/* 169 */     GL11.glLineWidth(width);
/* 170 */     GL11.glBegin(3);
/* 171 */     GL11.glVertex3d(x, y, 0.0D);
/* 172 */     GL11.glVertex3d(x1, y1, 0.0D);
/* 173 */     GL11.glEnd();
/* 174 */     GlStateManager.shadeModel(shade);
/* 175 */     GL11.glLineWidth(line);
/* 176 */     post3D();
/* 177 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   public static void enableGL2D() {
/* 181 */     GL11.glDisable(2929);
/* 182 */     GL11.glEnable(3042);
/* 183 */     GL11.glDisable(3553);
/* 184 */     GL11.glBlendFunc(770, 771);
/* 185 */     GL11.glDepthMask(true);
/* 186 */     GL11.glEnable(2848);
/* 187 */     GL11.glHint(3154, 4354);
/* 188 */     GL11.glHint(3155, 4354);
/*     */   }
/*     */ 
/*     */   public static void disableGL2D() {
/* 192 */     GL11.glEnable(3553);
/* 193 */     GL11.glDisable(3042);
/* 194 */     GL11.glEnable(2929);
/* 195 */     GL11.glDisable(2848);
/* 196 */     GL11.glHint(3154, 4352);
/* 197 */     GL11.glHint(3155, 4352);
/*     */   }
/*     */ 
/*     */   public static void drawEllipse(float cx, float cy, float rx, float ry, int num_segments, int col) {
/* 201 */     GL11.glPushMatrix();
/* 202 */     cx *= 2.0F;
/* 203 */     cy *= 2.0F;
/* 204 */     float theta = (float)(6.283185307179586D / num_segments);
/* 205 */     float c = (float)Math.cos(theta);
/* 206 */     float s = (float)Math.sin(theta);
/*     */ 
/* 208 */     float f = (col >> 24 & 0xFF) / 255.0F;
/* 209 */     float f1 = (col >> 16 & 0xFF) / 255.0F;
/* 210 */     float f2 = (col >> 8 & 0xFF) / 255.0F;
/* 211 */     float f3 = (col & 0xFF) / 255.0F;
/* 212 */     float x = 1.0F;
/* 213 */     float y = 0.0F;
/* 214 */     enableGL2D();
/* 215 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 216 */     GL11.glColor4f(f1, f2, f3, f);
/* 217 */     GL11.glBegin(2);
/* 218 */     for (int ii = 0; ii < num_segments; ii++)
/*     */     {
/* 220 */       GL11.glVertex2f(x * rx + cx, y * ry + cy);
/*     */ 
/* 223 */       float t = x;
/* 224 */       x = c * x - s * y;
/* 225 */       y = s * t + c * y;
/*     */     }
/* 227 */     GL11.glEnd();
/* 228 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 229 */     disableGL2D();
/* 230 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 231 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   public static void drawCircle(float cx, float cy, float r, int num_segments, int c) {
/* 235 */     GL11.glPushMatrix();
/* 236 */     cx *= 2.0F;
/* 237 */     cy *= 2.0F;
/* 238 */     float f = (c >> 24 & 0xFF) / 255.0F;
/* 239 */     float f1 = (c >> 16 & 0xFF) / 255.0F;
/* 240 */     float f2 = (c >> 8 & 0xFF) / 255.0F;
/* 241 */     float f3 = (c & 0xFF) / 255.0F;
/* 242 */     float theta = (float)(6.2831852D / num_segments);
/* 243 */     float p = (float)Math.cos(theta);
/* 244 */     float s = (float)Math.sin(theta);
/* 245 */     float x = r *= 2.0F;
/* 246 */     float y = 0.0F;
/* 247 */     enableGL2D();
/* 248 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 249 */     GL11.glColor4f(f1, f2, f3, f);
/* 250 */     GL11.glBegin(2);
/* 251 */     int ii = 0;
/* 252 */     while (ii < num_segments) {
/* 253 */       GL11.glVertex2f(x + cx, y + cy);
/* 254 */       float t = x;
/* 255 */       x = p * x - s * y;
/* 256 */       y = s * t + p * y;
/* 257 */       ii++;
/*     */     }
/* 259 */     GL11.glEnd();
/* 260 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 261 */     disableGL2D();
/* 262 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 263 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   public static void drawBorderedCircle(float circleX, float circleY, double radius, double width, int borderColor, int innerColor)
/*     */   {
/* 268 */     enableGL2D();
/* 269 */     GlStateManager.enableBlend();
/* 270 */     GL11.glEnable(2881);
/* 271 */     drawCircle(circleX, circleY, (float)(radius - 0.5D + width), 72, borderColor);
/* 272 */     drawFullCircle(circleX, circleY, (float)radius, innerColor);
/* 273 */     GlStateManager.disableBlend();
/* 274 */     GL11.glDisable(2881);
/* 275 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 276 */     disableGL2D();
/*     */   }
/*     */ 
/*     */   public static void drawFilledTriangle(float x, float y, float r, int c, int borderC)
/*     */   {
/* 281 */     enableGL2D();
/* 282 */     glColor(c);
/* 283 */     GL11.glEnable(2881);
/* 284 */     GL11.glBegin(4);
/* 285 */     GL11.glVertex2f(x + r / 2.0F, y + r / 2.0F);
/* 286 */     GL11.glVertex2f(x + r / 2.0F, y - r / 2.0F);
/* 287 */     GL11.glVertex2f(x - r / 2.0F, y);
/* 288 */     GL11.glEnd();
/* 289 */     GL11.glLineWidth(1.3F);
/* 290 */     glColor(borderC);
/* 291 */     GL11.glBegin(3);
/* 292 */     GL11.glVertex2f(x + r / 2.0F, y + r / 2.0F);
/* 293 */     GL11.glVertex2f(x + r / 2.0F, y - r / 2.0F);
/* 294 */     GL11.glEnd();
/* 295 */     GL11.glBegin(3);
/* 296 */     GL11.glVertex2f(x - r / 2.0F, y);
/* 297 */     GL11.glVertex2f(x + r / 2.0F, y - r / 2.0F);
/* 298 */     GL11.glEnd();
/* 299 */     GL11.glBegin(3);
/* 300 */     GL11.glVertex2f(x + r / 2.0F, y + r / 2.0F);
/* 301 */     GL11.glVertex2f(x - r / 2.0F, y);
/* 302 */     GL11.glEnd();
/* 303 */     GL11.glDisable(2881);
/* 304 */     disableGL2D();
/*     */   }
/*     */ 
/*     */   public static void drawFullCircle(float cx, float cy, float r, int c)
/*     */   {
/* 309 */     r *= 2.0F;
/* 310 */     cx *= 2.0F;
/* 311 */     cy *= 2.0F;
/* 312 */     float theta = 0.1963495F;
/* 313 */     float p = (float)Math.cos(theta);
/* 314 */     float s = (float)Math.sin(theta);
/*     */ 
/* 316 */     float x = r;
/* 317 */     float y = 0.0F;
/* 318 */     GL11.glEnable(3042);
/* 319 */     GL11.glDisable(3553);
/*     */ 
/* 323 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/*     */ 
/* 325 */     GL11.glBegin(2);
/* 326 */     glColor(c);
/* 327 */     for (int ii = 0; ii < 32; ii++) {
/* 328 */       GL11.glVertex2f(x + cx, y + cy);
/* 329 */       GL11.glVertex2f(cx, cy);
/* 330 */       float t = x;
/* 331 */       x = p * x - s * y;
/* 332 */       y = s * t + p * y;
/*     */     }
/* 334 */     GL11.glEnd();
/* 335 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 336 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 337 */     GL11.glDisable(3042);
/* 338 */     GL11.glEnable(3553);
/*     */   }
/*     */ 
/*     */   public static void ohnoes()
/*     */   {
/* 343 */     Minecraft.getMinecraft().shutdown();
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.RenderingUtil
 * JD-Core Version:    0.6.2
 */