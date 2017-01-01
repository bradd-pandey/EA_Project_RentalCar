package ea.project.service;

import java.util.Date;
import java.util.List;

import ea.project.domain.Vehicle;
/**
 * @author Bharat Pandey
 *
 */
public interface VehicleService {

	public void saveVehicle(Vehicle vehicle);

	public List<Vehicle> getAllVehicles();

	public Vehicle findVehicleById(Integer vehicleId);

	public Boolean isAvailable(Integer vehicleId, Date checkoutDate, Date returnDate);

	public void removeVehicle(Integer id);
	
	public Vehicle findByid(Integer id);

}
