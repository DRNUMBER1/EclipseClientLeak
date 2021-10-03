/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.events.PlayerAttack;
/*    */ import eclipse.client.events.PlayerOnTick;
/*    */ import eclipse.client.eventsys.EventTarget;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import java.text.DecimalFormat;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class ReachDisplay extends RenderedModule
/*    */ {
/*    */   private int decimals;
/*    */   private long lastAttack;
/* 19 */   String ReachDisplay = "";
/*    */ 
/*    */   public ReachDisplay() {
/* 22 */     super(60, 10, "ReachDisplay");
/*    */   }
/*    */ 
/*    */   @EventTarget
/*    */   public void onHit(PlayerAttack event) {
/* 27 */     Vec3 var2 = this.m.getRenderViewEntity().getPositionEyes(1.0F);
/* 28 */     double var3 = this.m.objectMouseOver.hitVec.distanceTo(var2);
/* 29 */     this.ReachDisplay = ("[Reach]: " + getFormatter().format(var3));
/* 30 */     this.lastAttack = System.nanoTime();
/*    */   }
/*    */ 
/*    */   @EventTarget
/*    */   public void onTick(PlayerOnTick event) {
/* 35 */     if (System.nanoTime() - this.lastAttack >= 2000000000.0D)
/* 36 */       this.ReachDisplay = "[Reach]: 0";
/*    */   }
/*    */ 
/*    */   private DecimalFormat getFormatter()
/*    */   {
/* 41 */     StringBuilder var1 = new StringBuilder("0.");
/*    */ 
/* 43 */     for (int var2 = 0; this.decimals > var2; var2++) {
/* 44 */       var1.append('0');
/*    */     }
/* 46 */     return new DecimalFormat(var1.toString());
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 51 */     this.f.drawString(this.ReachDisplay, getX(), getY(), -1);
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 56 */     return this.f.getStringWidth("[Reach]: 3");
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 61 */     return 9;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.ReachDisplay
 * JD-Core Version:    0.6.2
 */