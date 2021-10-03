/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import java.time.LocalDateTime;
/*    */ import java.time.format.DateTimeFormatter;
/*    */ 
/*    */ public class Time extends RenderedModule
/*    */ {
/*    */   public Time()
/*    */   {
/* 11 */     super(67, 23, "Clock");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 16 */     this.f.drawString(getTime(), getX(), getY(), -1);
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 21 */     return this.f.getStringWidth("8:00 PM");
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 26 */     return this.f.getHeight();
/*    */   }
/*    */ 
/*    */   private String getTime() {
/* 30 */     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a");
/* 31 */     LocalDateTime localTime = LocalDateTime.now();
/* 32 */     return dtf.format(localTime);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.Time
 * JD-Core Version:    0.6.2
 */