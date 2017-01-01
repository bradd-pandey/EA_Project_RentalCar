package ea.project.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ea.project.domain.Vehicle;
import ea.project.service.VehicleService;

/**
 * @author Bharat Pandey
 *
 */
public class VehicleIdValidator implements ConstraintValidator<VehicleId, Integer> {
	
	@Autowired
	VehicleService vehicleService;
	
	public void initialize(VehicleId constraintAnnotation){
		
	}
	
	public boolean isValid(Integer value, ConstraintValidatorContext context){
		Vehicle vehicle;
		try {
			vehicle = vehicleService.findVehicleById(value);
		} catch (Exception e) {
			return true;
		}
		
		if(vehicle!= null) {
			return false;
		}
		
		return true;
	}
	
}
