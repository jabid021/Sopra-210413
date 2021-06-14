package formation.sopra.springBoot.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MultipleDixValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipleDix {
	String message() default "pas de multiple de 10 pour le prix";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
