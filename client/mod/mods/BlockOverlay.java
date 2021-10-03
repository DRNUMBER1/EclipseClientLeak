/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.setting.Setting;
/*    */ import eclipse.client.setting.SettingManager;
/*    */ import eclipse.client.ui.ColorUtil;
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class BlockOverlay extends RenderedModule
/*    */ {
/*    */   public BlockOverlay()
/*    */   {
/* 13 */     super(0, 0, "BlockOverlay");
/* 14 */     Eclipse.client.setMgr.addSetting(new Setting("Width", this, 4.0D, 2.0D, 32.0D, 1.0D));
/* 15 */     Eclipse.client.setMgr.addSetting(new Setting("Color", this, "Chroma", new String[] { "Chroma", "Red", "Green", "Blue", "Magenta", "Yellow", "Cyan" }));
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
/*    */   public float getOutlineWidth() {
/* 33 */     if (this.enabled) {
/* 34 */       return (float)Eclipse.client.setMgr.getSettingByName("Width", this).getValInt();
/*    */     }
/* 36 */     return 2.0F;
/*    */   }
/*    */ 
/*    */   public Color getOutlineColor()
/*    */   {
/* 41 */     if (this.enabled) {
/* 42 */       String mode = Eclipse.client.setMgr.getSettingByName("Color", this).getValString();
/* 43 */       if (mode.equalsIgnoreCase("Red"))
/* 44 */         return Color.red;
/* 45 */       if (mode.equalsIgnoreCase("Green"))
/* 46 */         return Color.green;
/* 47 */       if (mode.equalsIgnoreCase("Blue"))
/* 48 */         return Color.blue;
/* 49 */       if (mode.equalsIgnoreCase("Magenta"))
/* 50 */         return Color.magenta;
/* 51 */       if (mode.equalsIgnoreCase("Yellow"))
/* 52 */         return Color.yellow;
/* 53 */       if (mode.equalsIgnoreCase("Cyan")) {
/* 54 */         return Color.cyan;
/*    */       }
/* 56 */       return ColorUtil.getRainbow(4.0F, 0.8F, 1.0F);
/*    */     }
/* 58 */     return new Color(0.0F, 0.0F, 0.0F, 0.4F);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.BlockOverlay
 * JD-Core Version:    0.6.2
 */