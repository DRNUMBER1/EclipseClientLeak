/*    */ package eclipse.client.ui;
/*    */ 
/*    */ import eclipse.client.ui.font.FontUtil;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ public class ClientSettings extends GuiScreen
/*    */ {
/*    */   public GuiButton capeType;
/*    */ 
/*    */   public ClientSettings()
/*    */   {
/* 14 */     this.capeType = new GuiButton(1, this.width / 2, 30, "Cape Type: Eclipse");
/*    */   }
/*    */ 
/*    */   public void initGui()
/*    */   {
/* 19 */     this.buttonList.add(this.capeType);
/*    */   }
/*    */ 
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*    */   {
/* 24 */     drawDefaultBackground();
/* 25 */     FontUtil.normal.drawCenteredString("Client Settings", this.width / 2, 10.0F, -1);
/*    */ 
/* 27 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ 
/*    */   protected void actionPerformed(GuiButton button) throws IOException
/*    */   {
/* 32 */     if (button.id == 1) {
/* 33 */       if (button.displayString.equalsIgnoreCase("Cape Type: Eclipse"))
/* 34 */         button.displayString = "Cape Type: Optifine";
/*    */       else {
/* 36 */         button.displayString = "Cape Type: Eclipse";
/*    */       }
/* 38 */       if (this.mc.thePlayer != null)
/*    */       {
/* 40 */         long i = 3000L;
/* 41 */         long j = System.currentTimeMillis() + i;
/* 42 */         this.mc.thePlayer.setReloadCapeTimeMs(j);
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.ui.ClientSettings
 * JD-Core Version:    0.6.2
 */