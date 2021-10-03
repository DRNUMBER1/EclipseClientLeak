/*    */ package eclipse.client.cosmetic;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.PrintStream;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.ThreadDownloadImageData;
/*    */ import net.minecraft.client.renderer.texture.ITextureObject;
/*    */ import net.minecraft.client.renderer.texture.SimpleTexture;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.src.Config;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.optifine.player.CapeImageBuffer;
/*    */ 
/*    */ public class EclipseCapeUtils
/*    */ {
/* 20 */   private static final Pattern PATTERN_USERNAME = Pattern.compile("[a-zA-Z0-9_]+");
/*    */ 
/*    */   public static void downloadCape(AbstractClientPlayer player)
/*    */   {
/* 24 */     String s = player.getNameClear();
/*    */ 
/* 26 */     if ((s != null) && (!s.isEmpty()) && (!s.contains("")) && (PATTERN_USERNAME.matcher(s).matches()) && (CapeManager.hasCape(player)))
/*    */     {
/* 28 */       String s1 = "http://shop.eclipseclient.xyz/capes/" + CapeManager.getCape(player) + ".png";
/* 29 */       System.out.println("Refreshing capes");
/* 30 */       System.out.println(s + " has a " + CapeManager.getCape(player));
/* 31 */       ResourceLocation resourcelocation = new ResourceLocation("capesystem/" + CapeManager.getCape(player) + ".png");
/* 32 */       TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
/* 33 */       ITextureObject itextureobject = texturemanager.getTexture(resourcelocation);
/*    */ 
/* 35 */       if ((itextureobject != null) && ((itextureobject instanceof ThreadDownloadImageData)))
/*    */       {
/* 37 */         ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)itextureobject;
/*    */ 
/* 39 */         if (threaddownloadimagedata.imageFound != null)
/*    */         {
/* 41 */           if (threaddownloadimagedata.imageFound.booleanValue())
/*    */           {
/* 44 */             if ((threaddownloadimagedata.getImageBuffer() instanceof CapeImageBuffer))
/*    */             {
/* 46 */               CapeImageBuffer localCapeImageBuffer1 = (CapeImageBuffer)threaddownloadimagedata.getImageBuffer();
/*    */             }
/*    */           }
/*    */ 
/* 50 */           return;
/*    */         }
/*    */       }
/*    */ 
/* 54 */       CapeImageBuffer capeimagebuffer = new CapeImageBuffer(player, resourcelocation);
/* 55 */       ThreadDownloadImageData threaddownloadimagedata1 = new ThreadDownloadImageData(null, s1, resourcelocation, capeimagebuffer);
/* 56 */       threaddownloadimagedata1.pipeline = true;
/* 57 */       texturemanager.loadTexture(resourcelocation, threaddownloadimagedata1);
/*    */     }
/*    */   }
/*    */ 
/*    */   public static BufferedImage parseCape(BufferedImage img)
/*    */   {
/* 63 */     int i = 64;
/* 64 */     int j = 32;
/* 65 */     int k = img.getWidth();
/*    */ 
/* 67 */     for (int l = img.getHeight(); (i < k) || (j < l); j *= 2)
/*    */     {
/* 69 */       i *= 2;
/*    */     }
/*    */ 
/* 72 */     BufferedImage bufferedimage = new BufferedImage(i, j, 2);
/* 73 */     Graphics graphics = bufferedimage.getGraphics();
/* 74 */     graphics.drawImage(img, 0, 0, null);
/* 75 */     graphics.dispose();
/* 76 */     return bufferedimage;
/*    */   }
/*    */ 
/*    */   public static boolean isElytraCape(BufferedImage imageRaw, BufferedImage imageFixed)
/*    */   {
/* 81 */     return imageRaw.getWidth() > imageFixed.getHeight();
/*    */   }
/*    */ 
/*    */   public static void reloadCape(AbstractClientPlayer player)
/*    */   {
/* 86 */     String s = player.getNameClear();
/* 87 */     ResourceLocation resourcelocation = new ResourceLocation("capesystem/" + CapeManager.getCape(player));
/* 88 */     TextureManager texturemanager = Config.getTextureManager();
/* 89 */     ITextureObject itextureobject = texturemanager.getTexture(resourcelocation);
/*    */ 
/* 91 */     if ((itextureobject instanceof SimpleTexture))
/*    */     {
/* 93 */       SimpleTexture simpletexture = (SimpleTexture)itextureobject;
/* 94 */       simpletexture.deleteGlTexture();
/* 95 */       texturemanager.deleteTexture(resourcelocation);
/*    */     }
/* 97 */     downloadCape(player);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.EclipseCapeUtils
 * JD-Core Version:    0.6.2
 */