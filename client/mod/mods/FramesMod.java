/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class FramesMod extends RenderedModule
/*    */ {
/*    */   public FramesMod()
/*    */   {
/* 11 */     super(20, 10, "Frames");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 16 */     this.f.drawString("[FPS: " + Minecraft.getDebugFPS() + "]", getX(), getY(), -1);
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 21 */     return this.f.getStringWidth("[FPS: " + Minecraft.getDebugFPS() + "]");
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 26 */     return 9;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.FramesMod
 * JD-Core Version:    0.6.2
 */