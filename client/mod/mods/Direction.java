/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ 
/*    */ public class Direction extends RenderedModule
/*    */ {
/*    */   public Direction()
/*    */   {
/*  9 */     super(120, 25, "Direction");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 14 */     this.f.drawString("Facing: " + this.m.thePlayer.getHorizontalFacing().name().toLowerCase(), getX(), getY(), -1);
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 19 */     return this.f.getStringWidth("Facing: north");
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 24 */     return 9;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.Direction
 * JD-Core Version:    0.6.2
 */