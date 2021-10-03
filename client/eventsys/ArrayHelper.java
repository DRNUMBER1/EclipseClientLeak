/*     */ package eclipse.client.eventsys;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class ArrayHelper<T>
/*     */   implements Iterable<T>
/*     */ {
/*     */   private T[] elements;
/*     */ 
/*     */   public ArrayHelper(T[] array)
/*     */   {
/*  16 */     this.elements = array;
/*     */   }
/*     */ 
/*     */   public ArrayHelper()
/*     */   {
/*  21 */     this.elements = new Object[0];
/*     */   }
/*     */ 
/*     */   public void add(T t)
/*     */   {
/*  26 */     if (t != null) {
/*  27 */       Object[] array = new Object[size() + 1];
/*     */ 
/*  29 */       for (int i = 0; i < array.length; i++) {
/*  30 */         if (i < size())
/*  31 */           array[i] = get(i);
/*     */         else {
/*  33 */           array[i] = t;
/*     */         }
/*     */       }
/*     */ 
/*  37 */       set(array);
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean contains(T t)
/*     */   {
/*     */     Object[] array;
/*  45 */     int lenght = (array = array()).length; for (int i = 0; i < lenght; i++) {
/*  46 */       Object entry = array[i];
/*  47 */       if (entry.equals(t)) {
/*  48 */         return true;
/*     */       }
/*     */     }
/*     */ 
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */   public void remove(T t)
/*     */   {
/*  57 */     if (contains(t)) {
/*  58 */       Object[] array = new Object[size() - 1];
/*  59 */       boolean b = true;
/*     */ 
/*  61 */       for (int i = 0; i < size(); i++) {
/*  62 */         if ((b) && (get(i).equals(t)))
/*  63 */           b = false;
/*     */         else {
/*  65 */           array[(b ? i : i - 1)] = get(i);
/*     */         }
/*     */       }
/*     */ 
/*  69 */       set(array);
/*     */     }
/*     */   }
/*     */ 
/*     */   public T[] array()
/*     */   {
/*  75 */     return this.elements;
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/*  80 */     return array().length;
/*     */   }
/*     */ 
/*     */   public void set(T[] array)
/*     */   {
/*  85 */     this.elements = array;
/*     */   }
/*     */ 
/*     */   public T get(int index)
/*     */   {
/*  90 */     return array()[index];
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/*  95 */     this.elements = new Object[0];
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 100 */     return size() == 0;
/*     */   }
/*     */ 
/*     */   public Iterator<T> iterator()
/*     */   {
/* 106 */     return new Iterator()
/*     */     {
/* 108 */       private int index = 0;
/*     */ 
/*     */       public boolean hasNext()
/*     */       {
/* 113 */         return (this.index < ArrayHelper.this.size()) && (ArrayHelper.this.get(this.index) != null);
/*     */       }
/*     */ 
/*     */       public T next()
/*     */       {
/* 119 */         return ArrayHelper.this.get(this.index++);
/*     */       }
/*     */ 
/*     */       public void remove()
/*     */       {
/* 125 */         ArrayHelper.this.remove(ArrayHelper.this.get(this.index));
/*     */       }
/*     */     };
/*     */   }
/*     */ }

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.eventsys.ArrayHelper
 * JD-Core Version:    0.6.2
 */