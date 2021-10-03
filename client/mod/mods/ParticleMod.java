/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.setting.Setting;
/*    */ import eclipse.client.setting.SettingManager;
/*    */ 
/*    */ public class ParticleMod extends RenderedModule
/*    */ {
/*    */   public ParticleMod()
/*    */   {
/* 12 */     super(0, 0, "ParticleMod");
/* 13 */     Eclipse.client.setMgr.addSetting(new Setting("Multiplier", this, 0.0D, 0.0D, 40.0D, 1.0D));
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 22 */     return 0;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */ 
/*    */   public int getValue() {
/* 31 */     if (this.enabled) {
/* 32 */       return (int)Eclipse.client.setMgr.getSettingByName("Multiplier", this).getValInt();
/*    */     }
/* 34 */     return 1;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.ParticleMod
 * JD-Core Version:    0.6.2
 */