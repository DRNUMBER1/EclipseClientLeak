/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.events.PlayerOnTick;
/*    */ import eclipse.client.eventsys.EventTarget;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.WorldClient;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityTNTPrimed;
/*    */ 
/*    */ public class TNTTimer extends RenderedModule
/*    */ {
/*    */   public TNTTimer()
/*    */   {
/* 15 */     super(0, 0, "TNT Timer");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */ 
/*    */   @EventTarget
/*    */   public void onUpdate(PlayerOnTick event) {
/* 34 */     for (Entity e : this.m.theWorld.loadedEntityList)
/* 35 */       if ((e instanceof EntityTNTPrimed)) {
/* 36 */         EntityTNTPrimed tnt = (EntityTNTPrimed)e;
/* 37 */         String s = (int)(tnt.fuse / 16.0F);
/* 38 */         String[] decimals = (tnt.fuse / 16.0F).replaceAll(s + ".", "").split("");
/*    */ 
/* 40 */         String tempDec = decimals[0] + (decimals.length != 1 ? decimals[1] : "");
/* 41 */         tnt.setCustomNameTag(s + "." + tempDec + "s left.");
/* 42 */         tnt.setAlwaysRenderNameTag(true);
/*    */       }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.TNTTimer
 * JD-Core Version:    0.6.2
 */