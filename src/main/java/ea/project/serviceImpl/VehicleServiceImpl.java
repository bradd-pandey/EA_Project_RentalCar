package ea.project.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.project.domain.Vehicle;
import ea.project.repository.VehicleRepository;
import ea.project.service.IReservationService;
import ea.project.service.VehicleService;
/**
 * @author Bharat Pandey
 *
 */
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	IReservationService reservationService;
	
	@Override
	public void saveVehicle(Vehicle vehicle){
		// using CrudRepository
		vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		// using CrudRepository
		return (List<Vehicle>) vehicleRepository.findAll();
	}

	@Override
	public Vehicle findVehicleById(Integer vehicleId) {
		// using JPQL
		Integer vId = (Integer) vehicleId;
		return vehicleRepository.findVehicleById(vId);
	}

	@Override
	public Boolean isAvailable(Integer vehicleId, Date checkoutDate, Date returnDate) {
		// using JPQL
		return reservationService.isAvailable(vehicleId,  checkoutDate,  returnDate);
	}

	@Override
	public void removeVehicle(Integer id) {
		// using CrudRepository
		vehicleRepository.delete(id);	
	}

	@Override
	public Vehicle findByid(Integer id) {
		// using Spring Data
		return vehicleRepository.findByid(id);
	}

}
