/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class ArmorStatus extends RenderedModule
/*    */ {
/*    */   public ArmorStatus()
/*    */   {
/* 12 */     super(60, 20, "ArmorStatus");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 17 */     for (int i = 0; i < this.m.thePlayer.inventory.armorInventory.length; i++) {
/* 18 */       ItemStack itemStack = this.m.thePlayer.inventory.armorInventory[i];
/* 19 */       renderItemStack(getX(), getY(), i, itemStack);
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 25 */     return 64;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 30 */     return 64;
/*    */   }
/*    */ 
/*    */   private void renderItemStack(int x, int y, int i, ItemStack is) {
/* 34 */     if (is == null) {
/* 35 */       return;
/*    */     }
/* 37 */     GL11.glPushMatrix();
/* 38 */     int yAdd = -16 * i + 48;
/* 39 */     if (is.getItem().isDamageable()) {
/* 40 */       double damage = (is.getMaxDamage() - is.getItemDamage()) / is.getMaxDamage() * 100.0D;
/* 41 */       this.f.drawString(String.format("%.2f%%", new Object[] { Double.valueOf(damage) }), x + 20, y + yAdd + 5, -1);
/*    */     }
/* 43 */     RenderHelper.enableGUIStandardItemLighting();
/* 44 */     this.m.getRenderItem().renderItemIntoGUI(is, x, y + yAdd);
/* 45 */     GL11.glPopMatrix();
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.ArmorStatus
 * JD-Core Version:    0.6.2
 */