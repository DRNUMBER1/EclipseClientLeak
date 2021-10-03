/*    */ package eclipse.client.mod;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.eventsys.EventManager;
/*    */ import eclipse.client.setting.Setting;
/*    */ import eclipse.client.setting.SettingManager;
/*    */ import eclipse.client.ui.font.FontUtil;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public abstract class RenderedModule
/*    */ {
/* 12 */   protected Minecraft m = Minecraft.getMinecraft();
/* 13 */   protected MinecraftFontRenderer f = FontUtil.normal;
/*    */   public int x;
/*    */   public int y;
/*    */   public String name;
/*    */   public boolean enabled;
/*    */   public MoveableMod modPart;
/*    */ 
/*    */   public RenderedModule(int x, int y, String name)
/*    */   {
/* 20 */     this.x = x;
/* 21 */     this.y = y;
/* 22 */     this.name = name;
/* 23 */     this.enabled = false;
/* 24 */     this.modPart = new MoveableMod(x, y, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB(), this);
/*    */   }
/*    */   public abstract void render();
/*    */ 
/* 28 */   public void renderFake(int mouseX, int mouseY) { this.modPart.draw(mouseX, mouseY);
/* 29 */     render(); } 
/*    */   public abstract int getWidth();
/*    */ 
/*    */   public abstract int getHeight();
/*    */ 
/* 33 */   public void onEnable() { EventManager.register(this); } 
/* 34 */   public void onDisable() { EventManager.unregister(this); } 
/*    */   public void setEnabled(boolean value) {
/* 36 */     this.enabled = value;
/* 37 */     if (this.enabled)
/* 38 */       onEnable();
/*    */     else
/* 40 */       onDisable(); 
/*    */   }
/*    */ 
/* 43 */   public void toggle() { this.enabled = (!this.enabled);
/* 44 */     if (this.enabled)
/* 45 */       onEnable();
/*    */     else
/* 47 */       onDisable(); }
/*    */ 
/*    */   public int getX() {
/* 50 */     return this.modPart.getX();
/*    */   }
/*    */   public int getY() {
/* 53 */     return this.modPart.getY();
/*    */   }
/*    */   public void addSetting(Setting set) {
/* 56 */     Eclipse.client.setMgr.addSetting(set);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.RenderedModule
 * JD-Core Version:    0.6.2
 */