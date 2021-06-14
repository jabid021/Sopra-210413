package formation.sopra.springBoot.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultipleDixValidator implements ConstraintValidator<MultipleDix, Double> {


	
	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		return (value % 10) != 0;
	}

}
