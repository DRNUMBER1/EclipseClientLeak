/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class HeldItem extends RenderedModule
/*    */ {
/*    */   public HeldItem()
/*    */   {
/* 15 */     super(80, 20, "HeldItem");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 20 */     if (this.m.thePlayer.getHeldItem() != null) {
/* 21 */       Gui.drawRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 120).getRGB());
/* 22 */       renderItemStack(getX(), getY(), 3, this.m.thePlayer.getHeldItem());
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 28 */     return 16;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 33 */     return 16;
/*    */   }
/*    */ 
/*    */   private void renderItemStack(int x, int y, int i, ItemStack is) {
/* 37 */     if (is == null) {
/* 38 */       return;
/*    */     }
/* 40 */     GL11.glPushMatrix();
/* 41 */     int yAdd = -16 * i + 48;
/* 42 */     this.f.drawString(is.getDisplayName(), x + 20, y + yAdd + 5, -1);
/* 43 */     RenderHelper.enableGUIStandardItemLighting();
/* 44 */     this.m.getRenderItem().renderItemIntoGUI(is, x, y + yAdd);
/* 45 */     GL11.glPopMatrix();
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.HeldItem
 * JD-Core Version:    0.6.2
 */