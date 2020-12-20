package by.smuraha.market.myAnotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE,  PARAMETER, TYPE_USE })
public @interface Unique {
    String message() default "{Unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
