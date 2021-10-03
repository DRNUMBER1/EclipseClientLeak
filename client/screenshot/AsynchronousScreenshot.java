/*    */ package eclipse.client.screenshot;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class AsynchronousScreenshot
/*    */   implements Runnable
/*    */ {
/*    */   private BufferedImage bufferedimage;
/*    */   private File f;
/*    */ 
/*    */   public AsynchronousScreenshot(BufferedImage b, File f)
/*    */   {
/* 14 */     this.bufferedimage = b;
/* 15 */     this.f = f;
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/*    */     try {
/* 21 */       ImageIO.write(this.bufferedimage, "png", this.f);
/*    */     } catch (IOException e) {
/* 23 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.screenshot.AsynchronousScreenshot
 * JD-Core Version:    0.6.2
 */