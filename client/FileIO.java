/*    */ package eclipse.client;
/*    */ 
/*    */ import eclipse.client.mod.Mods;
/*    */ import eclipse.client.mod.MoveableMod;
/*    */ import eclipse.client.mod.RenderedModule;
/*    */ import eclipse.client.setting.Setting;
/*    */ import eclipse.client.setting.SettingManager;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class FileIO
/*    */ {
/*    */   private File dir;
/*    */   private File dataFile;
/*    */ 
/*    */   public FileIO()
/*    */   {
/* 19 */     this.dir = new File(Minecraft.getMinecraft().mcDataDir, Eclipse.client.name);
/* 20 */     if (!this.dir.exists()) {
/* 21 */       this.dir.mkdir();
/*    */     }
/* 23 */     this.dataFile = new File(this.dir, "data.twilight");
/* 24 */     if (!this.dataFile.exists()) {
/*    */       try {
/* 26 */         this.dataFile.createNewFile();
/*    */       } catch (IOException e) {
/* 28 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */ 
/* 32 */     load();
/*    */   }
/*    */   public void save() {
/* 35 */     ArrayList toSave = new ArrayList();
/*    */ 
/* 37 */     for (RenderedModule mod : Eclipse.client.mods.getMods()) {
/* 38 */       toSave.add("MOD:" + mod.name + ":" + mod.enabled + ":" + mod.getX() + ":" + mod.getY());
/*    */     }
/* 40 */     for (Setting set : Eclipse.client.setMgr.settings) {
/* 41 */       if (set.isCheck()) {
/* 42 */         toSave.add("SET:" + set.getName() + ":" + set.getParentGuiMod().name + ":" + set.getValBoolean());
/*    */       }
/* 44 */       if (set.isCombo()) {
/* 45 */         toSave.add("SET:" + set.getName() + ":" + set.getParentGuiMod().name + ":" + set.getValString());
/*    */       }
/* 47 */       if (set.isSlider())
/* 48 */         toSave.add("SET:" + set.getName() + ":" + set.getParentGuiMod().name + ":" + set.getValInt());
/*    */     }
/*    */     try
/*    */     {
/* 52 */       PrintWriter pw = new PrintWriter(this.dataFile);
/*    */ 
/* 54 */       for (String str : toSave) {
/* 55 */         pw.println(str);
/*    */       }
/*    */ 
/* 58 */       pw.close();
/*    */     } catch (FileNotFoundException e) {
/* 60 */       e.printStackTrace(); } 
/*    */   }
/*    */ 
/* 64 */   public void load() { ArrayList lines = new ArrayList();
/*    */     String line;
/*    */     try {
/* 67 */       BufferedReader reader = new BufferedReader(new FileReader(this.dataFile));
/* 68 */       line = reader.readLine();
/* 69 */       while (line != null) {
/* 70 */         lines.add(line);
/* 71 */         line = reader.readLine();
/*    */       }
/* 73 */       reader.close();
/*    */     } catch (Exception e) {
/* 75 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 78 */     for (String s : lines) {
/* 79 */       String[] args = s.split(":");
/* 80 */       if (s.toLowerCase().startsWith("mod:")) {
/* 81 */         RenderedModule m = Eclipse.client.mods.getModBy(args[1]);
/* 82 */         if (m != null) {
/* 83 */           m.setEnabled(Boolean.parseBoolean(args[2]));
/* 84 */           m.modPart.setX(Integer.parseInt(args[3]));
/* 85 */           m.modPart.setY(Integer.parseInt(args[4]));
/*    */         }
/* 87 */       } else if (s.toLowerCase().startsWith("set:")) {
/* 88 */         RenderedModule m = Eclipse.client.mods.getModBy(args[2]);
/* 89 */         if (m != null) {
/* 90 */           Setting set = Eclipse.client.setMgr.getSettingByName(args[1], m);
/* 91 */           if (set != null) {
/* 92 */             if (set.isCheck()) {
/* 93 */               set.setValBoolean(Boolean.parseBoolean(args[3]));
/*    */             }
/* 95 */             if (set.isCombo()) {
/* 96 */               set.setValString(args[3]);
/*    */             }
/* 98 */             if (set.isSlider())
/* 99 */               set.setValInt(Double.parseDouble(args[3]));
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.FileIO
 * JD-Core Version:    0.6.2
 */