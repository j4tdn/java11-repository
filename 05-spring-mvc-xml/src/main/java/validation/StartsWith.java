package validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {StartsWithValidator.class})
public @interface StartsWith {
	
	String prefix();
	
	String message() default "";

	// require
	Class<?>[] groups() default { };

	// require
	Class<? extends Payload>[] payload() default { };
	
}
