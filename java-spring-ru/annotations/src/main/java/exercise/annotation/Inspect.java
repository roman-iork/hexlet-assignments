package exercise.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// BEGIN
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Inspect {
}
// END
