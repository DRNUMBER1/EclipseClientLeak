/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.Queue;
/*    */ import org.lwjgl.input.Mouse;
/*    */ 
/*    */ public class CPS
/*    */ {
/*    */   public final Counter leftCounter;
/*    */   public final Counter rightCounter;
/*    */   private boolean LwasDown;
/*    */   private boolean RwasDown;
/*    */ 
/*    */   public CPS()
/*    */   {
/* 15 */     this.leftCounter = new Counter();
/* 16 */     this.rightCounter = new Counter();
/* 17 */     this.LwasDown = false;
/* 18 */     this.RwasDown = false;
/*    */   }
/*    */ 
/*    */   public void onTick() {
/* 22 */     cps();
/*    */   }
/*    */ 
/*    */   private void cps() {
/* 26 */     Mouse.poll();
/* 27 */     boolean downNow = Mouse.isButtonDown(0);
/* 28 */     if ((downNow != this.LwasDown) && (downNow)) {
/* 29 */       this.leftCounter.onClick();
/*    */     }
/* 31 */     this.LwasDown = downNow;
/* 32 */     downNow = Mouse.isButtonDown(1);
/* 33 */     if ((downNow != this.RwasDown) && (downNow)) {
/* 34 */       this.rightCounter.onClick();
/*    */     }
/* 36 */     this.RwasDown = downNow;
/*    */   }
/*    */ 
/*    */   public static class Counter
/*    */   {
/*    */     private final Queue<Long> clicks;
/*    */ 
/*    */     public Counter() {
/* 44 */       this.clicks = new LinkedList();
/*    */     }
/*    */ 
/*    */     public Counter onClick() {
/* 48 */       this.clicks.add(Long.valueOf(System.currentTimeMillis() + 1000L));
/* 49 */       return this;
/*    */     }
/*    */ 
/*    */     public int getCPS() {
/* 53 */       long time = System.currentTimeMillis();
/* 54 */       while ((!this.clicks.isEmpty()) && (((Long)this.clicks.peek()).longValue() < time)) {
/* 55 */         this.clicks.remove();
/*    */       }
/* 57 */       return this.clicks.size();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.CPS
 * JD-Core Version:    0.6.2
 */