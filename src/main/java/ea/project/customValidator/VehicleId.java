package ea.project.customValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Bharat Pandey
 *
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = VehicleIdValidator.class)
@Documented
public @interface VehicleId {	
	String message() default "{Vehicle.vehicleId.validation}";
    Class<?>[] groups() default {};    
    public abstract Class<? extends Payload>[] payload() default {};
}
