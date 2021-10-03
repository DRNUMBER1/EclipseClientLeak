/*     */ package eclipse.client.setting;
/*     */ 
/*     */ import eclipse.client.mod.RenderedModule;
/*     */ 
/*     */ public class Setting
/*     */ {
/*     */   private String name;
/*     */   private RenderedModule parentGuiMod;
/*     */   private String dValString;
/*     */   private String currentValString;
/*     */   private String[] modes;
/*     */   private int i;
/*     */   private double dValInt;
/*     */   private double currentValInt;
/*     */   private double minValInt;
/*     */   private double maxValInt;
/*     */   private double increment;
/*     */   private boolean dValBoolean;
/*     */   private boolean currentValBoolean;
/*     */   private int settingType;
/*     */ 
/*     */   public String getValString()
/*     */   {
/*   8 */     return this.currentValString;
/*     */   }
/*     */ 
/*     */   public void setValString(String currentValString) {
/*  12 */     this.currentValString = currentValString;
/*     */   }
/*     */ 
/*     */   public double getValInt() {
/*  16 */     return this.currentValInt;
/*     */   }
/*     */ 
/*     */   public void setValInt(double d) {
/*  20 */     this.currentValInt = d;
/*     */   }
/*     */ 
/*     */   public boolean getValBoolean() {
/*  24 */     return this.currentValBoolean;
/*     */   }
/*     */ 
/*     */   public void setValBoolean(boolean currentValBoolean) {
/*  28 */     this.currentValBoolean = currentValBoolean;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  32 */     return this.name;
/*     */   }
/*     */ 
/*     */   public RenderedModule getParentGuiMod() {
/*  36 */     return this.parentGuiMod;
/*     */   }
/*     */ 
/*     */   public String getDefaultValString() {
/*  40 */     return this.dValString;
/*     */   }
/*     */ 
/*     */   public String[] getModes() {
/*  44 */     return this.modes;
/*     */   }
/*     */ 
/*     */   public double getDefaultValInt() {
/*  48 */     return this.dValInt;
/*     */   }
/*     */ 
/*     */   public double getMinValInt() {
/*  52 */     return this.minValInt;
/*     */   }
/*     */ 
/*     */   public double getMaxValInt() {
/*  56 */     return this.maxValInt;
/*     */   }
/*     */ 
/*     */   public boolean getDefaultValBoolean() {
/*  60 */     return this.dValBoolean;
/*     */   }
/*     */ 
/*     */   public void cycle() {
/*  64 */     if (this.settingType == 1) {
/*  65 */       this.i += 1;
/*  66 */       if (this.i > this.modes.length - 1) {
/*  67 */         this.i = 0;
/*     */       }
/*  69 */       this.currentValString = this.modes[this.i];
/*     */     }
/*  71 */     else if (this.settingType == 2) {
/*  72 */       this.currentValInt += this.increment;
/*  73 */       if (this.currentValInt > this.maxValInt) {
/*  74 */         this.currentValInt = this.minValInt;
/*     */       }
/*     */     }
/*  77 */     else if (this.settingType == 3) {
/*  78 */       this.currentValBoolean = (!this.currentValBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   public Setting(String name, RenderedModule parentGuiMod, String dValString, String[] modes)
/*     */   {
/* 104 */     this.name = name;
/* 105 */     this.parentGuiMod = parentGuiMod;
/* 106 */     this.dValString = dValString;
/* 107 */     this.currentValString = dValString;
/* 108 */     this.i = 0;
/* 109 */     this.modes = modes;
/* 110 */     this.settingType = 1;
/*     */   }
/*     */ 
/*     */   public Setting(String name, RenderedModule parentGuiMod, double dValInt, double minValInt, double maxValInt, double increment) {
/* 114 */     this.name = name;
/* 115 */     this.parentGuiMod = parentGuiMod;
/* 116 */     this.dValInt = dValInt;
/* 117 */     this.minValInt = minValInt;
/* 118 */     this.maxValInt = maxValInt;
/* 119 */     this.currentValInt = dValInt;
/* 120 */     this.settingType = 2;
/* 121 */     this.increment = increment;
/*     */   }
/*     */ 
/*     */   public Setting(String name, RenderedModule parentGuiMod, boolean dValBoolean) {
/* 125 */     this.name = name;
/* 126 */     this.parentGuiMod = parentGuiMod;
/* 127 */     this.dValBoolean = dValBoolean;
/* 128 */     this.currentValBoolean = dValBoolean;
/* 129 */     this.settingType = 3;
/*     */   }
/*     */ 
/*     */   public boolean isCombo() {
/* 133 */     return this.settingType == 1;
/*     */   }
/*     */ 
/*     */   public boolean isSlider() {
/* 137 */     return this.settingType == 2;
/*     */   }
/*     */ 
/*     */   public boolean isCheck() {
/* 141 */     return this.settingType == 3;
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.setting.Setting
 * JD-Core Version:    0.6.2
 */