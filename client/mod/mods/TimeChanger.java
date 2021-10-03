/*     */ package eclipse.client.mod.mods;
/*     */ 
/*     */ import eclipse.client.events.PlayerOnTick;
/*     */ import eclipse.client.eventsys.EventTarget;
/*     */ import eclipse.client.mod.RenderedModule;
/*     */ import eclipse.client.setting.Setting;
/*     */ 
/*     */ public class TimeChanger extends RenderedModule
/*     */ {
/*  11 */   private int currentTime = 0;
/*  12 */   private double timeMultiplier = 0.5D;
/*  13 */   private double timeSpeed = 1.0D;
/*  14 */   private boolean timeFrozen = false;
/*     */   private transient Setting timeSpeedSlider;
/*     */   private transient Setting freezeTimeButton;
/*     */   private transient Setting presetSelectionDropdown;
/*     */   private int presetID;
/*     */ 
/*     */   public TimeChanger()
/*     */   {
/*  21 */     super(0, 0, "TimeChanger");
/*  22 */     this.timeSpeedSlider = new Setting("Time Speed", this, this.timeMultiplier, 0.0D, 1.0D, 0.18D);
/*  23 */     this.presetSelectionDropdown = new Setting("Mode", this, "Always Day", new String[] { "Always Day", "Always Night", "Always Midnight", "Always Sunset" });
/*  24 */     this.freezeTimeButton = new Setting("Freeze Time", this, true);
/*  25 */     addSetting(this.timeSpeedSlider);
/*  26 */     addSetting(this.presetSelectionDropdown);
/*  27 */     addSetting(this.freezeTimeButton);
/*     */   }
/*     */ 
/*     */   @EventTarget
/*     */   public void onUpdate(PlayerOnTick event) {
/*  32 */     this.timeFrozen = this.freezeTimeButton.getValBoolean();
/*  33 */     this.timeMultiplier = this.timeSpeedSlider.getValInt();
/*     */ 
/*  35 */     if ((this.timeMultiplier >= 0.0D) && (this.timeMultiplier < 0.12D))
/*     */     {
/*  37 */       this.timeSpeed = 0.25D;
/*     */     }
/*  39 */     else if ((this.timeMultiplier >= 0.12D) && (this.timeMultiplier < 0.25D))
/*     */     {
/*  41 */       this.timeSpeed = 0.5D;
/*     */     }
/*  43 */     else if ((this.timeMultiplier >= 0.25D) && (this.timeMultiplier < 0.37D))
/*     */     {
/*  45 */       this.timeSpeed = 0.75D;
/*     */     }
/*  47 */     else if ((this.timeMultiplier >= 0.37D) && (this.timeMultiplier < 0.5D))
/*     */     {
/*  49 */       this.timeSpeed = 1.0D;
/*     */     }
/*  51 */     else if ((this.timeMultiplier >= 0.5D) && (this.timeMultiplier < 0.63D))
/*     */     {
/*  53 */       this.timeSpeed = 1.25D;
/*     */     }
/*  55 */     else if ((this.timeMultiplier >= 0.63D) && (this.timeMultiplier < 0.75D))
/*     */     {
/*  57 */       this.timeSpeed = 1.5D;
/*     */     }
/*  59 */     else if ((this.timeMultiplier >= 0.75D) && (this.timeMultiplier < 0.88D))
/*     */     {
/*  61 */       this.timeSpeed = 1.75D;
/*     */     }
/*     */     else
/*     */     {
/*  65 */       this.timeSpeed = 2.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */   public long getCurrentWorldTimePreset()
/*     */   {
/*  76 */     long i = 0L;
/*  77 */     String s = this.presetSelectionDropdown.getValString();
/*  78 */     byte b0 = -1;
/*     */ 
/*  80 */     switch (s.hashCode())
/*     */     {
/*     */     case -2082005561:
/*  83 */       if (s.equals("Always Sunset"))
/*     */       {
/*  85 */         b0 = 3;
/*     */       }
/*     */ 
/*  88 */       break;
/*     */     case -1734711609:
/*  91 */       if (s.equals("Always Night"))
/*     */       {
/*  93 */         b0 = 1;
/*     */       }
/*     */ 
/*  96 */       break;
/*     */     case -1119132149:
/*  99 */       if (s.equals("Always Day"))
/*     */       {
/* 101 */         b0 = 0;
/*     */       }
/*     */ 
/* 104 */       break;
/*     */     case 724547009:
/* 107 */       if (s.equals("Always Midnight"))
/*     */       {
/* 109 */         b0 = 2;
/*     */       }
/*     */       break;
/*     */     }
/* 113 */     switch (b0)
/*     */     {
/*     */     case 0:
/* 116 */       i = TimePreset.ALWAYS_DAY.getTime();
/* 117 */       this.presetID = 0;
/* 118 */       break;
/*     */     case 1:
/* 121 */       i = TimePreset.ALWAYS_NIGHT.getTime();
/* 122 */       this.presetID = 1;
/* 123 */       break;
/*     */     case 2:
/* 126 */       i = TimePreset.ALWAYS_MIDNIGHT.getTime();
/* 127 */       this.presetID = 2;
/* 128 */       break;
/*     */     case 3:
/* 131 */       i = TimePreset.ALWAYS_SUNSET.getTime();
/* 132 */       this.presetID = 3;
/*     */     }
/*     */ 
/* 135 */     return i;
/*     */   }
/*     */ 
/*     */   public double getTimeMultiplier()
/*     */   {
/* 140 */     return this.timeSpeed;
/*     */   }
/*     */ 
/*     */   public boolean isTimeFrozen()
/*     */   {
/* 164 */     return this.timeFrozen;
/*     */   }
/*     */ 
/*     */   public void render()
/*     */   {
/*     */   }
/*     */ 
/*     */   public int getWidth()
/*     */   {
/* 173 */     return 0;
/*     */   }
/*     */ 
/*     */   public int getHeight()
/*     */   {
/* 178 */     return 0;
/*     */   }
/*     */ 
/*     */   private static enum TimePreset
/*     */   {
/* 145 */     ALWAYS_DAY(0), 
/* 146 */     ALWAYS_NIGHT(15000), 
/* 147 */     ALWAYS_MIDNIGHT(18000), 
/* 148 */     ALWAYS_SUNSET(13150);
/*     */ 
/*     */     private int time;
/*     */ 
/*     */     private TimePreset(int time)
/*     */     {
/* 154 */       this.time = time;
/*     */     }
/*     */ 
/*     */     public int getTime()
/*     */     {
/* 159 */       return this.time;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.mod.mods.TimeChanger
 * JD-Core Version:    0.6.2
 */