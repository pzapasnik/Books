package pl.coderslab.hibernate02.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsNumberValidator implements ConstraintValidator<IsNumber, String> {
    @Override
    public void initialize(IsNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Integer val = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException  e) {
            return false;
        }
    }
}
