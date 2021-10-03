/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.events.PlayerOnTick;
/*    */ import eclipse.client.eventsys.EventTarget;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ 
/*    */ public class AutoJump extends RenderedModule
/*    */ {
/*    */   public AutoJump()
/*    */   {
/* 10 */     super(0, 0, "AutoJump");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 20 */     return 0;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 25 */     return 0;
/*    */   }
/*    */ 
/*    */   @EventTarget
/*    */   public void onUpdate(PlayerOnTick event) {
/* 30 */     if ((this.m.thePlayer.onGround) && (this.m.thePlayer.isCollidedHorizontally))
/* 31 */       this.m.thePlayer.jump();
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.AutoJump
 * JD-Core Version:    0.6.2
 */