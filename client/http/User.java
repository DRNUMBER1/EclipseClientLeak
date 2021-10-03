/*    */ package eclipse.client.http;
/*    */ 
/*    */ public class User
/*    */ {
/*    */   public String mcName;
/*    */   public boolean isUser;
/*    */   public boolean banned;
/*    */ 
/*    */   public User(String mcName, boolean isUser)
/*    */   {
/*  9 */     this.mcName = mcName;
/* 10 */     this.isUser = isUser;
/* 11 */     this.banned = false;
/*    */   }
/*    */ 
/*    */   public String getProperties() {
/* 15 */     return this.mcName + ":" + (this.isUser ? "true" : "false");
/*    */   }
/*    */ 
/*    */   public String getMcName() {
/* 19 */     return this.mcName;
/*    */   }
/*    */ 
/*    */   public boolean isBanned() {
/* 23 */     return false;
/*    */   }
/*    */ 
/*    */   public void setBanned(boolean banned) {
/* 27 */     this.banned = banned;
/*    */   }
/*    */ 
/*    */   public boolean isUser() {
/* 31 */     return this.isUser;
/*    */   }
/*    */ 
/*    */   public void setMcName(String mcName) {
/* 35 */     this.mcName = mcName;
/*    */   }
/*    */ 
/*    */   public void setUser(boolean user)
/*    */   {
/* 40 */     this.isUser = user;
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.http.User
 * JD-Core Version:    0.6.2
 */