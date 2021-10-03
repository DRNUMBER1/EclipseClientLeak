/*    */ package eclipse.client.mod;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.ui.clickgui.ClickGui;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.client.renderer.EntityRenderer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class MoveModScreen extends GuiScreen
/*    */ {
/*    */   public void initGui()
/*    */   {
/* 19 */     this.buttonList.add(new GuiButton(1, this.width / 2, this.height / 2, 50, 20, "Mods"));
/* 20 */     this.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
/* 21 */     super.initGui();
/*    */   }
/*    */ 
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*    */   {
/* 26 */     ScaledResolution sr = new ScaledResolution(this.mc);
/*    */ 
/* 28 */     for (RenderedModule m : Eclipse.client.mods.getEnabledMods()) {
/* 29 */       m.renderFake(mouseX, mouseY);
/*    */     }
/* 31 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ 
/*    */   protected void actionPerformed(GuiButton button) throws IOException
/*    */   {
/* 36 */     if (button.id == 1) {
/* 37 */       this.mc.displayGuiScreen(new ClickGui());
/*    */     }
/* 39 */     super.actionPerformed(button);
/*    */   }
/*    */ 
/*    */   public void onGuiClosed()
/*    */   {
/* 44 */     if (this.mc.thePlayer != null)
/* 45 */       Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
/* 46 */     super.onGuiClosed();
/*    */   }
/*    */ 
/*    */   public boolean doesGuiPauseGame()
/*    */   {
/* 51 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.MoveModScreen
 * JD-Core Version:    0.6.2
 */