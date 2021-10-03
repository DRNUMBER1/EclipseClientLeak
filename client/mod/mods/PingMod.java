/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.ServerData;
/*    */ 
/*    */ public class PingMod extends RenderedModule
/*    */ {
/*    */   public PingMod()
/*    */   {
/* 12 */     super(20, 60, "Ping");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 17 */     if (this.m.isSingleplayer()) {
/* 18 */       this.f.drawString("[Ping: Offline]", getX(), getY(), -1);
/* 19 */       return;
/*    */     }
/* 21 */     this.f.drawString("[Ping: " + this.m.getCurrentServerData().pingToServer + "]", getX(), getY(), -1);
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 26 */     return this.f.getStringWidth("[Ping: Offline]");
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 31 */     return 9;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.PingMod
 * JD-Core Version:    0.6.2
 */