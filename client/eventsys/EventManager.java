/*     */ package eclipse.client.eventsys;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class EventManager
/*     */ {
/* 145 */   private static final Map<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP = new HashMap();
/*     */ 
/*     */   public static void register(Object o)
/*     */   {
/*  19 */     for (Method method : o.getClass().getDeclaredMethods())
/*  20 */       if (!isMethodBad(method))
/*  21 */         register(method, o);
/*     */   }
/*     */ 
/*     */   public static void register(Object o, Class<? extends Event> clazz)
/*     */   {
/*  28 */     for (Method method : o.getClass().getDeclaredMethods())
/*  29 */       if (!isMethodBad(method, clazz))
/*  30 */         register(method, o);
/*     */   }
/*     */ 
/*     */   private static void register(Method method, Object o)
/*     */   {
/*  37 */     Class clazz = method.getParameterTypes()[0];
/*  38 */     Data methodData = new Data(o, method, ((EventTarget)method.getAnnotation(EventTarget.class)).value());
/*     */ 
/*  40 */     if (!methodData.target.isAccessible()) {
/*  41 */       methodData.target.setAccessible(true);
/*     */     }
/*     */ 
/*  44 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*  45 */       if (!((ArrayHelper)REGISTRY_MAP.get(clazz)).contains(methodData)) {
/*  46 */         ((ArrayHelper)REGISTRY_MAP.get(clazz)).add(methodData);
/*  47 */         sortListValue(clazz);
/*     */       }
/*     */     }
/*  50 */     else REGISTRY_MAP.put(clazz, new ArrayHelper()
/*     */       {
/*     */       });
/*     */   }
/*     */ 
/*     */   public static void unregister(Object o)
/*     */   {
/*     */     Iterator localIterator2;
/*  61 */     for (Iterator localIterator1 = REGISTRY_MAP.values().iterator(); localIterator1.hasNext(); 
/*  62 */       localIterator2.hasNext())
/*     */     {
/*  61 */       ArrayHelper flexibalArray = (ArrayHelper)localIterator1.next();
/*  62 */       localIterator2 = flexibalArray.iterator(); continue; Data methodData = (Data)localIterator2.next();
/*  63 */       if (methodData.source.equals(o)) {
/*  64 */         flexibalArray.remove(methodData);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  69 */     cleanMap(true);
/*     */   }
/*     */ 
/*     */   public static void unregister(Object o, Class<? extends Event> clazz)
/*     */   {
/*  74 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*  75 */       for (Data methodData : (ArrayHelper)REGISTRY_MAP.get(clazz)) {
/*  76 */         if (methodData.source.equals(o)) {
/*  77 */           ((ArrayHelper)REGISTRY_MAP.get(clazz)).remove(methodData);
/*     */         }
/*     */       }
/*     */ 
/*  81 */       cleanMap(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void cleanMap(boolean b)
/*     */   {
/*  88 */     Iterator iterator = REGISTRY_MAP.entrySet().iterator();
/*     */ 
/*  90 */     while (iterator.hasNext())
/*  91 */       if ((!b) || (((ArrayHelper)((Map.Entry)iterator.next()).getValue()).isEmpty()))
/*  92 */         iterator.remove();
/*     */   }
/*     */ 
/*     */   public static void removeEnty(Class<? extends Event> clazz)
/*     */   {
/*  99 */     Iterator iterator = REGISTRY_MAP.entrySet().iterator();
/*     */ 
/* 101 */     while (iterator.hasNext())
/* 102 */       if (((Class)((Map.Entry)iterator.next()).getKey()).equals(clazz)) {
/* 103 */         iterator.remove();
/* 104 */         break;
/*     */       }
/*     */   }
/*     */ 
/*     */   private static void sortListValue(Class<? extends Event> clazz)
/*     */   {
/* 111 */     ArrayHelper flexibleArray = new ArrayHelper();
/*     */ 
/* 113 */     for (byte b : Priority.VALUE_ARRAY) {
/* 114 */       for (Data methodData : (ArrayHelper)REGISTRY_MAP.get(clazz)) {
/* 115 */         if (methodData.priority == b) {
/* 116 */           flexibleArray.add(methodData);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 121 */     REGISTRY_MAP.put(clazz, flexibleArray);
/*     */   }
/*     */ 
/*     */   private static boolean isMethodBad(Method method)
/*     */   {
/* 126 */     return (method.getParameterTypes().length != 1) || (!method.isAnnotationPresent(EventTarget.class));
/*     */   }
/*     */ 
/*     */   private static boolean isMethodBad(Method method, Class<? extends Event> clazz)
/*     */   {
/* 131 */     return (isMethodBad(method)) || (method.getParameterTypes()[0].equals(clazz));
/*     */   }
/*     */ 
/*     */   public static ArrayHelper<Data> get(Class<? extends Event> clazz)
/*     */   {
/* 136 */     return (ArrayHelper)REGISTRY_MAP.get(clazz);
/*     */   }
/*     */ 
/*     */   public static void shutdown()
/*     */   {
/* 141 */     REGISTRY_MAP.clear();
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.eventsys.EventManager
 * JD-Core Version:    0.6.2
 */