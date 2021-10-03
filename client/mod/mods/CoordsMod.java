/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.multiplayer.WorldClient;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class CoordsMod extends RenderedModule
/*    */ {
/*    */   public CoordsMod()
/*    */   {
/* 11 */     super(20, 30, "Coords");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 16 */     this.f.drawString("X: " + (int)this.m.thePlayer.posX, getX(), getY(), -1);
/* 17 */     this.f.drawString("Y: " + (int)this.m.thePlayer.posY, getX(), getY() + 9, -1);
/* 18 */     this.f.drawString("Z: " + (int)this.m.thePlayer.posZ, getX(), getY() + 18, -1);
/* 19 */     this.f.drawString("Biome: " + this.m.theWorld.getBiomeGenForCoords(this.m.thePlayer.getPosition()).biomeName, getX(), getY() + 27, -1);
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 24 */     return 80;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 29 */     return 36;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.CoordsMod
 * JD-Core Version:    0.6.2
 */