package ea.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ea.project.domain.Vehicle;

/**
 * @author Bharat Pandey
 *
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
	
	// HQL/JPQL
	@Query("SELECT v FROM Vehicle v WHERE vehicleId = :vehicleId")
	public Vehicle findVehicleById(@Param("vehicleId") Integer vehicleId);
	
	// Spring Data
	public Vehicle findByid(Integer id);
}
