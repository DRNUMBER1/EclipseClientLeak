/*    */ package eclipse.client.cosmetic;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.IImageBuffer;
/*    */ import net.minecraft.client.renderer.ImageBufferDownload;
/*    */ import net.minecraft.client.renderer.ThreadDownloadImageData;
/*    */ import net.minecraft.client.renderer.texture.ITextureObject;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.commons.io.FilenameUtils;
/*    */ 
/*    */ public class UrlTextureUtil
/*    */ {
/*    */   public static void downloadAndSetTexture(String name, String url, ResourceLocationCallback callback)
/*    */   {
/* 20 */     if ((url != null) && (!url.isEmpty()))
/*    */     {
/* 22 */       String baseName = FilenameUtils.getBaseName(url);
/* 23 */       final ResourceLocation resourcelocation = new ResourceLocation("twilight/" + name + "/" + baseName);
/* 24 */       TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
/* 25 */       ITextureObject itextureobject = texturemanager.getTexture(resourcelocation);
/*    */ 
/* 27 */       if ((itextureobject != null) && ((itextureobject instanceof ThreadDownloadImageData)))
/*    */       {
/* 29 */         ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)itextureobject;
/*    */ 
/* 31 */         if (threaddownloadimagedata.imageFound != null)
/*    */         {
/* 33 */           if (threaddownloadimagedata.imageFound.booleanValue())
/*    */           {
/* 35 */             callback.onTextureLoaded(resourcelocation);
/*    */           }
/*    */ 
/* 38 */           return;
/*    */         }
/*    */       }
/*    */ 
/* 42 */       IImageBuffer iimagebuffer = new IImageBuffer()
/*    */       {
/* 44 */         ImageBufferDownload ibd = new ImageBufferDownload();
/*    */ 
/*    */         public BufferedImage parseUserSkin(BufferedImage image) {
/* 47 */           return image;
/*    */         }
/*    */ 
/*    */         public void skinAvailable() {
/* 51 */           UrlTextureUtil.this.onTextureLoaded(resourcelocation);
/*    */         }
/*    */       };
/* 54 */       ThreadDownloadImageData threaddownloadimagedata1 = new ThreadDownloadImageData(null, url, null, iimagebuffer);
/* 55 */       threaddownloadimagedata1.pipeline = true;
/* 56 */       texturemanager.loadTexture(resourcelocation, threaddownloadimagedata1);
/*    */     }
/*    */   }
/*    */ 
/*    */   public static abstract interface ResourceLocationCallback
/*    */   {
/*    */     public abstract void onTextureLoaded(ResourceLocation paramResourceLocation);
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.cosmetic.UrlTextureUtil
 * JD-Core Version:    0.6.2
 */