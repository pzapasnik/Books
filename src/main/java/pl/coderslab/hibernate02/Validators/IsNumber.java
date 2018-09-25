package pl.coderslab.hibernate02.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNumber {
    String message() default "{IsNumber.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
