/*    */ package eclipse.client.cosmetic;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ 
/*    */ public class CosmeticModelBase extends ModelBase
/*    */ {
/*    */   protected final ModelBiped playerModel;
/*    */ 
/*    */   public CosmeticModelBase(RenderPlayer player)
/*    */   {
/* 12 */     this.playerModel = player.getMainModel();
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.CosmeticModelBase
 * JD-Core Version:    0.6.2
 */