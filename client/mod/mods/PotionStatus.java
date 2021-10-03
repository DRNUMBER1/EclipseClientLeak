/*    */ package eclipse.client.mod.mods;
/*    */ 
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.ui.font.FontUtil;
/*    */ import eclipse.client.ui.font.MinecraftFontRenderer;
/*    */ import java.util.Collection;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.WorldRenderer;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class PotionStatus extends RenderedModule
/*    */ {
/*    */   protected float zLevelFloat;
/*    */ 
/*    */   public PotionStatus()
/*    */   {
/* 23 */     super(70, 140, "PotionStatus");
/*    */   }
/*    */ 
/*    */   public void render()
/*    */   {
/* 28 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 29 */     int offsetX = 21;
/* 30 */     int offsetY = 14;
/* 31 */     int i = 80;
/* 32 */     int i2 = 16;
/* 33 */     Collection collection = this.m.thePlayer.getActivePotionEffects();
/*    */ 
/* 35 */     if (!collection.isEmpty())
/*    */     {
/* 37 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 38 */       GlStateManager.disableLighting();
/* 39 */       int l = 33;
/*    */ 
/* 42 */       if (collection.size() > 5)
/*    */       {
/* 44 */         l = 132 / (collection.size() - 1);
/*    */       }
/*    */ 
/* 47 */       for (PotionEffect potioneffect : this.m.thePlayer.getActivePotionEffects())
/*    */       {
/* 49 */         Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
/* 50 */         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*    */ 
/* 52 */         if (potion.hasStatusIcon())
/*    */         {
/* 54 */           this.m.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
/* 55 */           int i1 = potion.getStatusIconIndex();
/* 56 */           drawTexturedModalRect(getX() + offsetX - 20, getY() + i2 - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
/*    */         }
/*    */ 
/* 59 */         String s1 = I18n.format(potion.getName(), new Object[0]);
/* 60 */         s1 = s1 + " " + potioneffect.getAmplifier();
/*    */ 
/* 62 */         FontUtil.normal.drawString(s1, getX() + offsetX, getY() + i2 - offsetY, -1);
/* 63 */         String s = Potion.getDurationString(potioneffect);
/* 64 */         FontUtil.normal.drawString(s, getX() + offsetX, getY() + i2 + 10 - offsetY, -1);
/* 65 */         i2 += l;
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getWidth()
/*    */   {
/* 72 */     return 101;
/*    */   }
/*    */ 
/*    */   public int getHeight()
/*    */   {
/* 77 */     return 154;
/*    */   }
/*    */ 
/*    */   public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height)
/*    */   {
/* 82 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 83 */     float f = 0.0039063F;
/* 84 */     float f1 = 0.0039063F;
/* 85 */     Tessellator tessellator = Tessellator.getInstance();
/* 86 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 87 */     worldrenderer.begin(7, DefaultVertexFormats.field_181707_g);
/* 88 */     worldrenderer.pos(x + 0, y + height, this.zLevelFloat).func_181673_a((textureX + 0) * f, (textureY + height) * f1).func_181675_d();
/* 89 */     worldrenderer.pos(x + width, y + height, this.zLevelFloat).func_181673_a((textureX + width) * f, (textureY + height) * f1).func_181675_d();
/* 90 */     worldrenderer.pos(x + width, y + 0, this.zLevelFloat).func_181673_a((textureX + width) * f, (textureY + 0) * f1).func_181675_d();
/* 91 */     worldrenderer.pos(x + 0, y + 0, this.zLevelFloat).func_181673_a((textureX + 0) * f, (textureY + 0) * f1).func_181675_d();
/* 92 */     tessellator.draw();
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.PotionStatus
 * JD-Core Version:    0.6.2
 */