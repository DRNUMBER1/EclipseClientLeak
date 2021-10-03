/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.util.Timer;
/*    */ 
/*    */ public class SpeedMod extends RenderedModule
/*    */ {
/*    */   public SpeedMod()
/*    */   {
/*  8 */     super(43, 90, "SpeedMod");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 13 */     float rat = this.m.timer.ticksPerSecond * this.m.timer.timerSpeed;
/* 14 */     float bps = (float)(this.m.thePlayer.getDistance(this.m.thePlayer.lastTickPosX, this.m.thePlayer.posY, this.m.thePlayer.lastTickPosZ) * rat);
/* 15 */     this.f.drawString("Speed: " + bps + " bps", getX(), getY(), -1);
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 20 */     return this.f.getStringWidth("Speed: 3.0 bps");
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 25 */     return this.f.getHeight();
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.SpeedMod
 * JD-Core Version:    0.6.2
 */