package pl.coderslab.hibernate02.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsEighteenValidator implements ConstraintValidator<IsEighteen, String> {

    @Override
    public void initialize(IsEighteen constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Integer.parseInt(s) >= 18;
    }
}
