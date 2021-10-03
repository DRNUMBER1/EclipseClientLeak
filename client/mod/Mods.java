/*     */ package eclipse.client.mod;
/*     */ 
/*     */ import eclipse.client.Eclipse;
/*     */ import eclipse.client.mod.mods.AntiCheat;
/*     */ import eclipse.client.mod.mods.ArmorStatus;
/*     */ import eclipse.client.mod.mods.AutoGG;
/*     */ import eclipse.client.mod.mods.AutoJump;
/*     */ import eclipse.client.mod.mods.BlockOverlay;
/*     */ import eclipse.client.mod.mods.CoordsMod;
/*     */ import eclipse.client.mod.mods.CustomSkin;
/*     */ import eclipse.client.mod.mods.Direction;
/*     */ import eclipse.client.mod.mods.EnchantmentGlint;
/*     */ import eclipse.client.mod.mods.FramesMod;
/*     */ import eclipse.client.mod.mods.Freelook;
/*     */ import eclipse.client.mod.mods.HeldItem;
/*     */ import eclipse.client.mod.mods.HitColor;
/*     */ import eclipse.client.mod.mods.ItemPhysics;
/*     */ import eclipse.client.mod.mods.KeystrokesMod;
/*     */ import eclipse.client.mod.mods.NickHider;
/*     */ import eclipse.client.mod.mods.OnePointSevenAnimations;
/*     */ import eclipse.client.mod.mods.ParticleMod;
/*     */ import eclipse.client.mod.mods.PingMod;
/*     */ import eclipse.client.mod.mods.PotionStatus;
/*     */ import eclipse.client.mod.mods.ReachDisplay;
/*     */ import eclipse.client.mod.mods.SpeedMod;
/*     */ import eclipse.client.mod.mods.TNTTimer;
/*     */ import eclipse.client.mod.mods.Time;
/*     */ import eclipse.client.mod.mods.TimeChanger;
/*     */ import eclipse.client.mod.mods.ToggleSprint;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarInputStream;
/*     */ 
/*     */ public class Mods
/*     */ {
/*  16 */   private ArrayList<RenderedModule> mods = new ArrayList();
/*     */ 
/*     */   public Mods() {
/*  19 */     this.mods.clear();
/*     */ 
/*  21 */     this.mods.add(new FramesMod());
/*  22 */     this.mods.add(new CoordsMod());
/*  23 */     this.mods.add(new PingMod());
/*  24 */     this.mods.add(new KeystrokesMod());
/*  25 */     this.mods.add(new ToggleSprint());
/*  26 */     this.mods.add(new TimeChanger());
/*  27 */     this.mods.add(new ArmorStatus());
/*  28 */     this.mods.add(new OnePointSevenAnimations());
/*  29 */     this.mods.add(new Freelook());
/*  30 */     this.mods.add(new HeldItem());
/*  31 */     this.mods.add(new ReachDisplay());
/*  32 */     this.mods.add(new AutoGG());
/*  33 */     this.mods.add(new AutoJump());
/*  34 */     this.mods.add(new Direction());
/*  35 */     this.mods.add(new BlockOverlay());
/*  36 */     this.mods.add(new AntiCheat());
/*  37 */     this.mods.add(new NickHider());
/*  38 */     this.mods.add(new TNTTimer());
/*  39 */     this.mods.add(new PotionStatus());
/*  40 */     this.mods.add(new HitColor());
/*  41 */     this.mods.add(new ParticleMod());
/*  42 */     this.mods.add(new EnchantmentGlint());
/*  43 */     this.mods.add(new ItemPhysics());
/*  44 */     this.mods.add(new Time());
/*  45 */     this.mods.add(new SpeedMod());
/*     */ 
/*  47 */     loadLocalPlugins();
/*     */   }
/*     */ 
/*     */   public ArrayList<RenderedModule> getMods() {
/*  51 */     return this.mods;
/*     */   }
/*     */ 
/*     */   public Freelook getFreelook() {
/*  55 */     return (Freelook)getModBy("Freelook");
/*     */   }
/*     */ 
/*     */   public KeystrokesMod getKeystrokes() {
/*  59 */     return (KeystrokesMod)getModBy("Keystrokes");
/*     */   }
/*     */ 
/*     */   public BlockOverlay getBlockOverlay() {
/*  63 */     return (BlockOverlay)getModBy("BlockOverlay");
/*     */   }
/*     */ 
/*     */   public NickHider getNickHider() {
/*  67 */     return (NickHider)getModBy("NickHider");
/*     */   }
/*     */ 
/*     */   public CustomSkin getSkin() {
/*  71 */     return (CustomSkin)getModBy("Twilight Skins");
/*     */   }
/*     */ 
/*     */   public TimeChanger getTime() {
/*  75 */     return (TimeChanger)getModBy("TimeChanger");
/*     */   }
/*     */ 
/*     */   public HitColor getHitColor() {
/*  79 */     return (HitColor)getModBy("HitColor");
/*     */   }
/*     */ 
/*     */   public ParticleMod getParticle() {
/*  83 */     return (ParticleMod)getModBy("ParticleMod");
/*     */   }
/*     */ 
/*     */   public EnchantmentGlint getGlint() {
/*  87 */     return (EnchantmentGlint)getModBy("EnchantmentGlint");
/*     */   }
/*     */ 
/*     */   public AntiCheat getAntiCheat() {
/*  91 */     return (AntiCheat)getModBy("AntiCheat");
/*     */   }
/*     */ 
/*     */   private void loadLocalPlugins()
/*     */   {
/*  96 */     String basePath = new File(Eclipse.client.name).getAbsolutePath();
/*  97 */     String newPath = new File(basePath + File.separator + "plugins").getAbsolutePath();
/*  98 */     File test = new File(newPath);
/*     */ 
/* 100 */     if (!test.exists()) {
/* 101 */       test.mkdirs();
/*     */     }
/*     */ 
/* 104 */     for (File file : test.listFiles())
/*     */     {
/* 106 */       if (file.getAbsolutePath().endsWith(".jar"))
/*     */         try {
/* 108 */           loadJar(file);
/*     */         } catch (IOException e) {
/* 110 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void loadJar(File file)
/*     */     throws IOException
/*     */   {
/* 118 */     JarInputStream jis = new JarInputStream(new FileInputStream(file));
/* 119 */     URLClassLoader urlLoader = URLClassLoader.newInstance(new URL[] { file.toURI().toURL() });
/* 120 */     for (JarEntry jarEntry = jis.getNextJarEntry(); jarEntry != null; jarEntry = jis.getNextJarEntry())
/*     */     {
/* 122 */       if ((!jarEntry.isDirectory()) && (jarEntry.getName().endsWith(".class")))
/*     */       {
/* 125 */         String className = jarEntry.getName().replace('/', '.').substring(0, 
/* 126 */           jarEntry.getName().length() - ".class".length());
/*     */ 
/* 128 */         if (!className.contains("$"))
/*     */         {
/*     */           try
/*     */           {
/* 133 */             Class classs = urlLoader.loadClass(className);
/*     */ 
/* 135 */             if (RenderedModule.class.isAssignableFrom(classs))
/* 136 */               this.mods.add((RenderedModule)classs.newInstance());
/*     */           }
/*     */           catch (ReflectiveOperationException e) {
/* 139 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 143 */     jis.close();
/* 144 */     urlLoader.close();
/*     */   }
/*     */ 
/*     */   public ArrayList<RenderedModule> getEnabledMods() {
/* 148 */     ArrayList temp = new ArrayList();
/* 149 */     for (RenderedModule r : this.mods) {
/* 150 */       if (r.enabled) {
/* 151 */         temp.add(r);
/*     */       }
/*     */     }
/* 154 */     return temp;
/*     */   }
/*     */ 
/*     */   public RenderedModule getModBy(String s) {
/* 158 */     for (RenderedModule r : this.mods) {
/* 159 */       if (r.name.equalsIgnoreCase(s)) {
/* 160 */         return r;
/*     */       }
/*     */     }
/* 163 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.Mods
 * JD-Core Version:    0.6.2
 */