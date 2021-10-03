/*    */ package eclipse.client.mod;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import org.lwjgl.input.Mouse;
/*    */ 
/*    */ public class MoveableMod
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int width;
/*    */   private int height;
/*    */   private int lastX;
/*    */   private int lastY;
/*    */   private RenderedModule parentMod;
/*    */   private boolean dragging;
/*    */ 
/*    */   public MoveableMod(int x, int y, int width, int height, int color, RenderedModule parentMod)
/*    */   {
/* 22 */     this.width = width;
/* 23 */     this.height = height;
/* 24 */     this.x = x;
/* 25 */     this.y = y;
/* 26 */     this.parentMod = parentMod;
/*    */   }
/*    */ 
/*    */   public int getX() {
/* 30 */     return this.x;
/*    */   }
/*    */ 
/*    */   public int getY() {
/* 34 */     return this.y;
/*    */   }
/*    */ 
/*    */   public void setX(int x) {
/* 38 */     this.x = x;
/*    */   }
/*    */ 
/*    */   public void setY(int y) {
/* 42 */     this.y = y;
/*    */   }
/*    */ 
/*    */   public int getHeight() {
/* 46 */     return this.height;
/*    */   }
/*    */ 
/*    */   public int getWidth() {
/* 50 */     return this.width;
/*    */   }
/*    */ 
/*    */   public void draw(int mouseX, int mouseY) {
/* 54 */     draggingFix(mouseX, mouseY);
/* 55 */     boolean mouseOverX = (mouseX >= getX()) && (mouseX <= getX() + getWidth());
/* 56 */     boolean mouseOverY = (mouseY >= getY()) && (mouseY <= getY() + getHeight());
/* 57 */     if ((mouseOverX) && (mouseOverY) && 
/* 58 */       (Mouse.isButtonDown(0)) && 
/* 59 */       (!this.dragging)) {
/* 60 */       this.lastX = (this.x - mouseX);
/* 61 */       this.lastY = (this.y - mouseY);
/* 62 */       this.dragging = true;
/*    */     }
/*    */ 
/* 66 */     Gui.drawVerticalLine(this.x, this.y, this.y + this.height, this.dragging ? -1 : new Color(100, 100, 100).getRGB());
/* 67 */     Gui.drawVerticalLine(this.x + this.width, this.y, this.y + this.height, this.dragging ? -1 : new Color(100, 100, 100).getRGB());
/* 68 */     Gui.drawHorizontalLine(this.x, this.x + this.width, this.y, this.dragging ? -1 : new Color(100, 100, 100).getRGB());
/* 69 */     Gui.drawHorizontalLine(this.x, this.x + this.width, this.y + this.height, this.dragging ? -1 : new Color(100, 100, 100).getRGB());
/*    */   }
/*    */ 
/*    */   private void draggingFix(int mouseX, int mouseY) {
/* 73 */     if (this.dragging) {
/* 74 */       this.x = (mouseX + this.lastX);
/* 75 */       this.y = (mouseY + this.lastY);
/* 76 */       if (!Mouse.isButtonDown(0)) this.dragging = false;
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.MoveableMod
 * JD-Core Version:    0.6.2
 */