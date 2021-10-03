/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.events.PlayerOnTick;
/*    */ import eclipse.client.eventsys.EventTarget;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import java.util.HashMap;
/*    */ import net.minecraft.block.BlockAir;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.WorldClient;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.PlayerCapabilities;
/*    */ import net.minecraft.util.BlockPos;
/*    */ 
/*    */ public class AntiCheat extends RenderedModule
/*    */ {
/* 14 */   public HashMap<EntityPlayer, String> hackerList = new HashMap();
/*    */ 
/*    */   public AntiCheat() {
/* 17 */     super(0, 0, "AntiCheat");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */ 
/*    */   @EventTarget
/*    */   public void onUpdate(PlayerOnTick event) {
/* 36 */     for (Entity e : this.m.theWorld.getLoadedEntityList())
/* 37 */       if ((e instanceof EntityPlayer)) {
/* 38 */         EntityPlayer suspect = (EntityPlayer)e;
/*    */ 
/* 40 */         if ((!suspect.capabilities.isCreativeMode) && (suspect.motionY >= 0.0D) && ((this.m.theWorld.getBlockState(suspect.getPosition().down()).getBlock() instanceof BlockAir)) && 
/* 41 */           (!this.hackerList.containsKey(suspect))) {
/* 42 */           this.hackerList.put(suspect, "Fly");
/*    */         }
/*    */ 
/* 46 */         if ((!suspect.capabilities.isCreativeMode) && (suspect.fallDistance > 3.0F) && (suspect.onGround) && 
/* 47 */           (!this.hackerList.containsKey(suspect)))
/* 48 */           this.hackerList.put(suspect, "NoFall");
/*    */       }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.AntiCheat
 * JD-Core Version:    0.6.2
 */