package pl.sda.javawwa.KodProwadzacego;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotacja z przedrostkiem i koncowka
 * @author mj
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Dopisywacz {
	
	String koncowka() default "";

	String przedrostek() default "";
}
