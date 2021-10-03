/*     */ package eclipse.client.login;
/*     */ 
/*     */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class PasswordField extends Gui
/*     */ {
/*     */   private final MinecraftFontRenderer fontRenderer;
/*     */   private final int xPos;
/*     */   private final int yPos;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private String text;
/*     */   private int maxStringLength;
/*     */   private int cursorCounter;
/*     */   private boolean enableBackgroundDrawing;
/*     */   private boolean canLoseFocus;
/*     */   public boolean isFocused;
/*     */   private boolean isEnabled;
/*     */   private int i;
/*     */   private int cursorPosition;
/*     */   private int selectionEnd;
/*     */   private int enabledColor;
/*     */   private int disabledColor;
/*     */   private boolean b;
/*     */ 
/*     */   public PasswordField(MinecraftFontRenderer par1FontRenderer, int par2, int par3, int par4, int par5)
/*     */   {
/*  35 */     this.text = "";
/*  36 */     this.maxStringLength = 50;
/*  37 */     this.enableBackgroundDrawing = true;
/*  38 */     this.canLoseFocus = true;
/*  39 */     this.isFocused = false;
/*  40 */     this.isEnabled = true;
/*  41 */     this.i = 0;
/*  42 */     this.cursorPosition = 0;
/*  43 */     this.selectionEnd = 0;
/*  44 */     this.enabledColor = 14737632;
/*  45 */     this.disabledColor = 7368816;
/*  46 */     this.b = true;
/*  47 */     this.fontRenderer = par1FontRenderer;
/*  48 */     this.xPos = par2;
/*  49 */     this.yPos = par3;
/*  50 */     this.width = par4;
/*  51 */     this.height = par5;
/*     */   }
/*     */ 
/*     */   public void updateCursorCounter() {
/*  55 */     this.cursorCounter += 1;
/*     */   }
/*     */ 
/*     */   public void setText(String par1Str) {
/*  59 */     if (par1Str.length() > this.maxStringLength) {
/*  60 */       this.text = par1Str.substring(0, this.maxStringLength);
/*     */     }
/*     */     else {
/*  63 */       this.text = par1Str;
/*     */     }
/*  65 */     setCursorPositionEnd();
/*     */   }
/*     */ 
/*     */   public String getText() {
/*  69 */     String newtext = this.text.replaceAll(" ", "");
/*  70 */     return newtext;
/*     */   }
/*     */ 
/*     */   public String getSelectedtext() {
/*  74 */     int var1 = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
/*  75 */     int var2 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
/*  76 */     return this.text.substring(var1, var2);
/*     */   }
/*     */ 
/*     */   public void writeText(String par1Str) {
/*  80 */     String var2 = "";
/*  81 */     String var3 = ChatAllowedCharacters.filterAllowedCharacters(par1Str);
/*  82 */     int var4 = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
/*  83 */     int var5 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
/*  84 */     int var6 = this.maxStringLength - this.text.length() - (var4 - this.selectionEnd);
/*  85 */     boolean var7 = false;
/*  86 */     if (this.text.length() > 0)
/*  87 */       var2 = String.valueOf(String.valueOf(var2)) + this.text.substring(0, var4);
/*     */     int var8;
/*     */     int var8;
/*  90 */     if (var6 < var3.length()) {
/*  91 */       var2 = String.valueOf(String.valueOf(var2)) + var3.substring(0, var6);
/*  92 */       var8 = var6;
/*     */     }
/*     */     else {
/*  95 */       var2 = String.valueOf(String.valueOf(var2)) + var3;
/*  96 */       var8 = var3.length();
/*     */     }
/*  98 */     if ((this.text.length() > 0) && (var5 < this.text.length())) {
/*  99 */       var2 = String.valueOf(String.valueOf(var2)) + this.text.substring(var5);
/*     */     }
/* 101 */     this.text = var2.replaceAll(" ", "");
/* 102 */     cursorPos(var4 - this.selectionEnd + var8);
/*     */   }
/*     */ 
/*     */   public void func_73779_a(int par1) {
/* 106 */     if (this.text.length() != 0)
/* 107 */       if (this.selectionEnd != this.cursorPosition) {
/* 108 */         writeText("");
/*     */       }
/*     */       else
/* 111 */         deleteFromCursor(getNthWordFromCursor(par1) - this.cursorPosition);
/*     */   }
/*     */ 
/*     */   public void deleteFromCursor(int par1)
/*     */   {
/* 117 */     if (this.text.length() != 0)
/* 118 */       if (this.selectionEnd != this.cursorPosition) {
/* 119 */         writeText("");
/*     */       }
/*     */       else {
/* 122 */         boolean var2 = par1 < 0;
/* 123 */         int var3 = var2 ? this.cursorPosition + par1 : this.cursorPosition;
/* 124 */         int var4 = var2 ? this.cursorPosition : this.cursorPosition + par1;
/* 125 */         String var5 = "";
/* 126 */         if (var3 >= 0) {
/* 127 */           var5 = this.text.substring(0, var3);
/*     */         }
/* 129 */         if (var4 < this.text.length()) {
/* 130 */           var5 = String.valueOf(String.valueOf(var5)) + this.text.substring(var4);
/*     */         }
/* 132 */         this.text = var5;
/* 133 */         if (var2)
/* 134 */           cursorPos(par1);
/*     */       }
/*     */   }
/*     */ 
/*     */   public int getNthWordFromCursor(int par1)
/*     */   {
/* 141 */     return getNthWordFromPos(par1, getCursorPosition());
/*     */   }
/*     */ 
/*     */   public int getNthWordFromPos(int par1, int par2) {
/* 145 */     return type(par1, getCursorPosition(), true);
/*     */   }
/*     */ 
/*     */   public int type(int par1, int par2, boolean par3) {
/* 149 */     int var4 = par2;
/* 150 */     boolean var5 = par1 < 0;
/* 151 */     int var6 = Math.abs(par1); for (int var7 = 0; var7 < var6; var7++) {
/* 152 */       if (!var5) {
/* 153 */         var8 = this.text.length();
/* 154 */         var4 = this.text.indexOf(' ', var4);
/* 155 */         if (var4 == -1) {
/* 156 */           var4 = var8;
/*     */         }
/*     */         else
/* 159 */           while (par3) {
/* 160 */             if (var4 >= var8) {
/*     */               break;
/*     */             }
/* 163 */             if (this.text.charAt(var4) != ' ') {
/*     */               break;
/*     */             }
/* 166 */             var4++;
/*     */           }
/*     */       }
/*     */       else
/*     */       {
/* 171 */         while (par3)
/*     */         {
/*     */           int var8;
/* 172 */           if (var4 <= 0) {
/*     */             break;
/*     */           }
/* 175 */           if (this.text.charAt(var4 - 1) != ' ') {
/*     */             break;
/*     */           }
/* 178 */           var4--;
/*     */         }
/* 180 */         while ((var4 > 0) && (this.text.charAt(var4 - 1) != ' ')) {
/* 181 */           var4--;
/*     */         }
/*     */       }
/*     */     }
/* 185 */     return var4;
/*     */   }
/*     */ 
/*     */   public void cursorPos(int par1) {
/* 189 */     setCursorPosition(this.selectionEnd + par1);
/*     */   }
/*     */ 
/*     */   public void setCursorPosition(int par1) {
/* 193 */     this.cursorPosition = par1;
/* 194 */     int var2 = this.text.length();
/* 195 */     if (this.cursorPosition < 0) {
/* 196 */       this.cursorPosition = 0;
/*     */     }
/* 198 */     if (this.cursorPosition > var2) {
/* 199 */       this.cursorPosition = var2;
/*     */     }
/* 201 */     func_73800_i(this.cursorPosition);
/*     */   }
/*     */ 
/*     */   public void setCursorPositionZero() {
/* 205 */     setCursorPosition(0);
/*     */   }
/*     */ 
/*     */   public void setCursorPositionEnd() {
/* 209 */     setCursorPosition(this.text.length());
/*     */   }
/*     */ 
/*     */   public boolean textboxKeyTyped(char par1, int par2) {
/* 213 */     if ((!this.isEnabled) || (!this.isFocused)) {
/* 214 */       return false;
/*     */     }
/* 216 */     switch (par1) {
/*     */     case '\001':
/* 218 */       setCursorPositionEnd();
/* 219 */       func_73800_i(0);
/* 220 */       return true;
/*     */     case '\003':
/* 223 */       GuiScreen.setClipboardString(getSelectedtext());
/* 224 */       return true;
/*     */     case '\026':
/* 227 */       writeText(GuiScreen.getClipboardString());
/* 228 */       return true;
/*     */     case '\030':
/* 231 */       GuiScreen.setClipboardString(getSelectedtext());
/* 232 */       writeText("");
/* 233 */       return true;
/*     */     }
/*     */ 
/* 236 */     switch (par2) {
/*     */     case 14:
/* 238 */       if (GuiScreen.isCtrlKeyDown()) {
/* 239 */         func_73779_a(-1);
/*     */       }
/*     */       else {
/* 242 */         deleteFromCursor(-1);
/*     */       }
/* 244 */       return true;
/*     */     case 199:
/* 247 */       if (GuiScreen.isShiftKeyDown()) {
/* 248 */         func_73800_i(0);
/*     */       }
/*     */       else {
/* 251 */         setCursorPositionZero();
/*     */       }
/* 253 */       return true;
/*     */     case 203:
/* 256 */       if (GuiScreen.isShiftKeyDown()) {
/* 257 */         if (GuiScreen.isCtrlKeyDown()) {
/* 258 */           func_73800_i(getNthWordFromPos(-1, getSelectionEnd()));
/*     */         }
/*     */         else {
/* 261 */           func_73800_i(getSelectionEnd() - 1);
/*     */         }
/*     */       }
/* 264 */       else if (GuiScreen.isCtrlKeyDown()) {
/* 265 */         setCursorPosition(getNthWordFromCursor(-1));
/*     */       }
/*     */       else {
/* 268 */         cursorPos(-1);
/*     */       }
/* 270 */       return true;
/*     */     case 205:
/* 273 */       if (GuiScreen.isShiftKeyDown()) {
/* 274 */         if (GuiScreen.isCtrlKeyDown()) {
/* 275 */           func_73800_i(getNthWordFromPos(1, getSelectionEnd()));
/*     */         }
/*     */         else {
/* 278 */           func_73800_i(getSelectionEnd() + 1);
/*     */         }
/*     */       }
/* 281 */       else if (GuiScreen.isCtrlKeyDown()) {
/* 282 */         setCursorPosition(getNthWordFromCursor(1));
/*     */       }
/*     */       else {
/* 285 */         cursorPos(1);
/*     */       }
/* 287 */       return true;
/*     */     case 207:
/* 290 */       if (GuiScreen.isShiftKeyDown()) {
/* 291 */         func_73800_i(this.text.length());
/*     */       }
/*     */       else {
/* 294 */         setCursorPositionEnd();
/*     */       }
/* 296 */       return true;
/*     */     case 211:
/* 299 */       if (GuiScreen.isCtrlKeyDown()) {
/* 300 */         func_73779_a(1);
/*     */       }
/*     */       else {
/* 303 */         deleteFromCursor(1);
/*     */       }
/* 305 */       return true;
/*     */     }
/*     */ 
/* 308 */     if (ChatAllowedCharacters.isAllowedCharacter(par1)) {
/* 309 */       writeText(Character.toString(par1));
/* 310 */       return true;
/*     */     }
/* 312 */     return false;
/*     */   }
/*     */ 
/*     */   public void mouseClicked(int par1, int par2, int par3)
/*     */   {
/* 320 */     boolean var4 = (par1 >= this.xPos) && (par1 < this.xPos + this.width) && (par2 >= this.yPos) && (par2 < this.yPos + this.height);
/* 321 */     if (this.canLoseFocus) {
/* 322 */       setFocused((this.isEnabled) && (var4));
/*     */     }
/* 324 */     if ((this.isFocused) && (par3 == 0)) {
/* 325 */       int var5 = par1 - this.xPos;
/* 326 */       if (this.enableBackgroundDrawing) {
/* 327 */         var5 -= 4;
/*     */       }
/* 329 */       String var6 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 330 */       setCursorPosition(this.fontRenderer.trimStringToWidth(var6, var5).length() + this.i);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void drawTextBox() {
/* 335 */     if (func_73778_q()) {
/* 336 */       if (getEnableBackgroundDrawing()) {
/* 337 */         Gui.drawRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
/* 338 */         Gui.drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
/*     */       }
/* 340 */       int var1 = this.isEnabled ? this.enabledColor : this.disabledColor;
/* 341 */       int var2 = this.cursorPosition - this.i;
/* 342 */       int var3 = this.selectionEnd - this.i;
/* 343 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 344 */       boolean var5 = (var2 >= 0) && (var2 <= var4.length());
/* 345 */       boolean var6 = (this.isFocused) && (this.cursorCounter / 6 % 2 == 0) && (var5);
/* 346 */       int var7 = this.enableBackgroundDrawing ? this.xPos + 4 : this.xPos;
/* 347 */       int var8 = this.enableBackgroundDrawing ? this.yPos + (this.height - 8) / 2 : this.yPos;
/* 348 */       int var9 = var7;
/* 349 */       if (var3 > var4.length()) {
/* 350 */         var3 = var4.length();
/*     */       }
/* 352 */       if (var4.length() > 0) {
/* 353 */         if (var5) {
/* 354 */           var4.substring(0, var2);
/*     */         }
/* 356 */         var9 = Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), var7, var8, var1);
/*     */       }
/* 358 */       boolean var10 = (this.cursorPosition < this.text.length()) || (this.text.length() >= getMaxStringLength());
/* 359 */       int var11 = var9;
/* 360 */       if (!var5) {
/* 361 */         var11 = var2 > 0 ? var7 + this.width : var7;
/*     */       }
/* 363 */       else if (var10) {
/* 364 */         var11 = var9 - 1;
/* 365 */         var9--;
/*     */       }
/* 367 */       if ((var4.length() > 0) && (var5) && (var2 < var4.length())) {
/* 368 */         Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(var4.substring(var2), var9, var8, var1);
/*     */       }
/* 370 */       if (var6) {
/* 371 */         if (var10) {
/* 372 */           Gui.drawRect(var11, var8 - 1, var11 + 1, var8 + 1 + this.fontRenderer.getHeight(), -3092272);
/*     */         }
/*     */         else {
/* 375 */           Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("_", var11, var8, var1);
/*     */         }
/*     */       }
/* 378 */       if (var3 != var2) {
/* 379 */         int var12 = var7 + this.fontRenderer.getStringWidth(var4.substring(0, var3));
/* 380 */         drawCursorVertical(var11, var8 - 1, var12 - 1, var8 + 1 + this.fontRenderer.getHeight());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawCursorVertical(int par1, int par2, int par3, int par4) {
/* 386 */     if (par1 < par3) {
/* 387 */       int var5 = par1;
/* 388 */       par1 = par3;
/* 389 */       par3 = var5;
/*     */     }
/* 391 */     if (par2 < par4) {
/* 392 */       int var5 = par2;
/* 393 */       par2 = par4;
/* 394 */       par4 = var5;
/*     */     }
/* 396 */     Tessellator var6 = Tessellator.getInstance();
/* 397 */     WorldRenderer var7 = var6.getWorldRenderer();
/* 398 */     GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
/* 399 */     GL11.glDisable(3553);
/* 400 */     GL11.glEnable(3058);
/* 401 */     GL11.glLogicOp(5387);
/* 402 */     var7.begin(7, var7.getVertexFormat());
/* 403 */     var7.pos(par1, par4, 0.0D);
/* 404 */     var7.pos(par3, par4, 0.0D);
/* 405 */     var7.pos(par3, par2, 0.0D);
/* 406 */     var7.pos(par1, par2, 0.0D);
/* 407 */     var7.finishDrawing();
/* 408 */     GL11.glDisable(3058);
/* 409 */     GL11.glEnable(3553);
/*     */   }
/*     */ 
/*     */   public void setMaxStringLength(int par1) {
/* 413 */     this.maxStringLength = par1;
/* 414 */     if (this.text.length() > par1)
/* 415 */       this.text = this.text.substring(0, par1);
/*     */   }
/*     */ 
/*     */   public int getMaxStringLength()
/*     */   {
/* 420 */     return this.maxStringLength;
/*     */   }
/*     */ 
/*     */   public int getCursorPosition() {
/* 424 */     return this.cursorPosition;
/*     */   }
/*     */ 
/*     */   public boolean getEnableBackgroundDrawing() {
/* 428 */     return this.enableBackgroundDrawing;
/*     */   }
/*     */ 
/*     */   public void setEnableBackgroundDrawing(boolean par1) {
/* 432 */     this.enableBackgroundDrawing = par1;
/*     */   }
/*     */ 
/*     */   public void func_73794_g(int par1) {
/* 436 */     this.enabledColor = par1;
/*     */   }
/*     */ 
/*     */   public void setFocused(boolean par1) {
/* 440 */     if ((par1) && (!this.isFocused)) {
/* 441 */       this.cursorCounter = 0;
/*     */     }
/* 443 */     this.isFocused = par1;
/*     */   }
/*     */ 
/*     */   public boolean isFocused() {
/* 447 */     return this.isFocused;
/*     */   }
/*     */ 
/*     */   public int getSelectionEnd() {
/* 451 */     return this.selectionEnd;
/*     */   }
/*     */ 
/*     */   public int getWidth() {
/* 455 */     return getEnableBackgroundDrawing() ? this.width - 8 : this.width;
/*     */   }
/*     */ 
/*     */   public void func_73800_i(int par1) {
/* 459 */     int var2 = this.text.length();
/* 460 */     if (par1 > var2) {
/* 461 */       par1 = var2;
/*     */     }
/* 463 */     if (par1 < 0) {
/* 464 */       par1 = 0;
/*     */     }
/* 466 */     this.selectionEnd = par1;
/* 467 */     if (this.fontRenderer != null) {
/* 468 */       if (this.i > var2) {
/* 469 */         this.i = var2;
/*     */       }
/* 471 */       int var3 = getWidth();
/* 472 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), var3);
/* 473 */       int var5 = var4.length() + this.i;
/* 474 */       if (par1 == this.i) {
/* 475 */         this.i -= this.fontRenderer.trimStringToWidth(this.text, var3, true).length();
/*     */       }
/* 477 */       if (par1 > var5) {
/* 478 */         this.i += par1 - var5;
/*     */       }
/* 480 */       else if (par1 <= this.i) {
/* 481 */         this.i -= this.i - par1;
/*     */       }
/* 483 */       if (this.i < 0) {
/* 484 */         this.i = 0;
/*     */       }
/* 486 */       if (this.i > var2)
/* 487 */         this.i = var2;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setCanLoseFocus(boolean par1)
/*     */   {
/* 493 */     this.canLoseFocus = par1;
/*     */   }
/*     */ 
/*     */   public boolean func_73778_q() {
/* 497 */     return this.b;
/*     */   }
/*     */ 
/*     */   public void func_73790_e(boolean par1) {
/* 501 */     this.b = par1;
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.login.PasswordField
 * JD-Core Version:    0.6.2
 */