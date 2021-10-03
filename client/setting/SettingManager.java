/*    */ package eclipse.client.setting;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class SettingManager
/*    */ {
/*    */   public ArrayList<Setting> settings;
/*    */ 
/*    */   public SettingManager()
/*    */   {
/* 11 */     this.settings = new ArrayList();
/*    */   }
/*    */ 
/*    */   public void addSetting(Setting s) {
/* 15 */     this.settings.add(s);
/*    */   }
/*    */ 
/*    */   public ArrayList<Setting> getSettingsForModule(RenderedModule m) {
/* 19 */     ArrayList tempSets = new ArrayList();
/* 20 */     for (Setting s : this.settings) {
/* 21 */       if (s.getParentGuiMod() == m) {
/* 22 */         tempSets.add(s);
/*    */       }
/*    */     }
/* 25 */     return tempSets;
/*    */   }
/*    */ 
/*    */   public Setting getSettingByName(String name, RenderedModule parentMod) {
/* 29 */     for (Setting s : this.settings) {
/* 30 */       if ((s.getName().equalsIgnoreCase(name)) && (s.getParentGuiMod() == parentMod)) {
/* 31 */         return s;
/*    */       }
/*    */     }
/* 34 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.setting.SettingManager
 * JD-Core Version:    0.6.2
 */