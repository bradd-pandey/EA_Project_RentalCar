package ea.project.customValidator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ea.project.domain.Vehicle;

/**
 * @author Bharat Pandey
 *
 */
public class VehicleValidator implements Validator{
	
	@Autowired
	private javax.validation.Validator beanValidator;
	private Set<Validator> springValidators;
	
	public VehicleValidator(){
		springValidators = new HashSet<Validator>();
	}

	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}
	
	public boolean supports(Class<?> myClass){
		return Vehicle.class.isAssignableFrom(myClass);		
	}
	
	public void validate(Object target, Errors errors){
		Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
		for(ConstraintViolation<Object> constraintViolation : constraintViolations){
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		for(Validator validator : springValidators){
			validator.validate(target, errors);
		}		
	}

}
