package eclipse.client.eventsys;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EventTarget
{
  public abstract byte value();
}

/* Location:           C:\Users\Harris\Downloads\EclipseClient\EclipseClient.jar
 * Qualified Name:     eclipse.client.eventsys.EventTarget
 * JD-Core Version:    0.6.2
 */