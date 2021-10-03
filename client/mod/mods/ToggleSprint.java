/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.events.KeyboardHit;
/*    */ import eclipse.client.events.PlayerOnTick;
/*    */ import eclipse.client.eventsys.EventTarget;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ public class ToggleSprint extends RenderedModule
/*    */ {
/* 16 */   private boolean sprinting = false;
/*    */ 
/*    */   public ToggleSprint() {
/* 19 */     super(30, 40, "ToggleSprint");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 24 */     if (this.sprinting)
/* 25 */       this.f.drawString("[Sprinting: Toggled]", getX(), getY(), -1);
/*    */     else
/* 27 */       this.f.drawString("[]", getX(), getY(), -1);
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 33 */     return this.f.getStringWidth("[Sprinting: Toggled]");
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 38 */     return 9;
/*    */   }
/*    */ 
/*    */   @EventTarget
/*    */   public void onKey(KeyboardHit event) {
/* 43 */     if (Keyboard.isKeyDown(this.m.gameSettings.keyBindSprint.getKeyCode())) {
/* 44 */       this.sprinting = (!this.sprinting);
/* 45 */       if (!this.sprinting)
/* 46 */         KeyBinding.setKeyBindState(this.m.gameSettings.keyBindSprint.getKeyCode(), false);
/*    */     }
/*    */   }
/*    */ 
/*    */   @EventTarget
/*    */   public void onUpdate(PlayerOnTick event)
/*    */   {
/* 53 */     if (this.sprinting)
/* 54 */       KeyBinding.setKeyBindState(this.m.gameSettings.keyBindSprint.getKeyCode(), true);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.ToggleSprint
 * JD-Core Version:    0.6.2
 */