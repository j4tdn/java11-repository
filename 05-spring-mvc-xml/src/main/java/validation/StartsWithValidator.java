package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartsWithValidator implements ConstraintValidator<StartsWith, String>{

	private String prefix;
	
	@Override
	public void initialize(StartsWith startsWith) {
		this.prefix = startsWith.prefix();
	}
	
	@Override
	public boolean isValid(String formInput, ConstraintValidatorContext context) {
		if (formInput == null || formInput.trim().isEmpty()) {
			return false;
		}
		
		return formInput.startsWith(prefix);
	}

}
