/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.setting.Setting;
/*    */ import eclipse.client.setting.SettingManager;
/*    */ import eclipse.client.ui.ColorUtil;
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class HitColor extends RenderedModule
/*    */ {
/*    */   public HitColor()
/*    */   {
/* 13 */     super(0, 0, "HitColor");
/* 14 */     Eclipse.client.setMgr.addSetting(new Setting("Color", this, "Chroma", new String[] { "Chroma", "Red", "Green", "Blue", "Magenta", "Yellow", "Cyan" }));
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 23 */     return 0;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */ 
/*    */   public Color getColor() {
/* 32 */     String mode = Eclipse.client.setMgr.getSettingByName("Color", this).getValString();
/* 33 */     if (this.enabled) {
/* 34 */       if (mode.equalsIgnoreCase("Red"))
/* 35 */         return Color.red;
/* 36 */       if (mode.equalsIgnoreCase("Green"))
/* 37 */         return Color.green;
/* 38 */       if (mode.equalsIgnoreCase("Blue"))
/* 39 */         return Color.blue;
/* 40 */       if (mode.equalsIgnoreCase("Magenta"))
/* 41 */         return Color.magenta;
/* 42 */       if (mode.equalsIgnoreCase("Yellow"))
/* 43 */         return Color.yellow;
/* 44 */       if (mode.equalsIgnoreCase("Cyan")) {
/* 45 */         return Color.cyan;
/*    */       }
/* 47 */       return ColorUtil.getRainbow(4.0F, 0.8F, 1.0F);
/*    */     }
/* 49 */     return new Color(1.0F, 0.0F, 0.0F, 0.3F);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.HitColor
 * JD-Core Version:    0.6.2
 */