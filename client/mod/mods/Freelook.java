/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.Eclipse;
/*    */ import eclipse.client.events.PlayerOnTick;
/*    */ import eclipse.client.eventsys.EventTarget;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.setting.Setting;
/*    */ import eclipse.client.setting.SettingManager;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.util.MouseHelper;
/*    */ import org.lwjgl.opengl.Display;
/*    */ 
/*    */ public class Freelook extends RenderedModule
/*    */ {
/* 18 */   public boolean returnOnRelease = true;
/* 19 */   public boolean perspectiveToggled = false;
/* 20 */   public float cameraYaw = 0.0F;
/* 21 */   public float cameraPitch = 0.0F;
/* 22 */   public int previousPerspective = 0;
/*    */ 
/*    */   public Freelook() {
/* 25 */     super(0, 0, "Freelook");
/* 26 */     addSetting(new Setting("Mode", this, "Hold", new String[] { "Hold", "Toggle" }));
/*    */   }
/*    */ 
/*    */   @EventTarget
/*    */   public void onUpdate(PlayerOnTick event) {
/* 31 */     this.returnOnRelease = Eclipse.client.setMgr.getSettingByName("Mode", this).getValString().equalsIgnoreCase("Hold");
/* 32 */     if (this.perspectiveToggled) {
/* 33 */       this.previousPerspective = this.m.gameSettings.thirdPersonView;
/* 34 */       this.m.gameSettings.thirdPersonView = 1;
/*    */     }
/*    */   }
/*    */ 
/*    */   public float getCameraYaw() {
/* 39 */     return this.perspectiveToggled ? this.cameraYaw : this.m.thePlayer.rotationYaw;
/*    */   }
/*    */ 
/*    */   public float getCameraPitch() {
/* 43 */     return this.perspectiveToggled ? this.cameraPitch : this.m.thePlayer.rotationPitch;
/*    */   }
/*    */ 
/*    */   public boolean overrideMouse() {
/* 47 */     if ((this.m.inGameHasFocus) && (Display.isActive())) {
/* 48 */       if (!this.perspectiveToggled) {
/* 49 */         return true;
/*    */       }
/* 51 */       this.m.mouseHelper.mouseXYChange();
/* 52 */       float f1 = this.m.gameSettings.mouseSensitivity * 0.6F + 0.2F;
/* 53 */       float f2 = f1 * 3.0F * 0.8F;
/* 54 */       float f3 = this.m.mouseHelper.deltaX * f2;
/* 55 */       float f4 = this.m.mouseHelper.deltaY * f2;
/*    */ 
/* 57 */       this.cameraYaw += f3 * 0.15F;
/* 58 */       this.cameraPitch += f4 * 0.15F;
/*    */     }
/*    */ 
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 71 */     return 0;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 76 */     return 0;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.Freelook
 * JD-Core Version:    0.6.2
 */