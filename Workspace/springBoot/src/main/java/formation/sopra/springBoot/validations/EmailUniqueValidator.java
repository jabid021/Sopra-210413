package formation.sopra.springBoot.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import formation.sopra.springBoot.services.FournisseurService;

@Configurable
public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

	@Autowired
	private FournisseurService frsService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println(frsService);
//		if (!value.isEmpty()) {
//			Fournisseur f = frsService.getByContact(value);
//			return f.getId() == null;
//		}
		return true;
	}

}
