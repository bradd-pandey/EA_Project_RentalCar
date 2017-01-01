package ea.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.project.domain.VehicleClass;
import ea.project.repository.VehicleClassRepository;
import ea.project.service.VehicleClassService;
/**
 * @author Bharat Pandey
 *
 */
@Service
@Transactional
public class VehicleClassServiceImpl implements VehicleClassService{
	
	@Autowired
	VehicleClassRepository vehicleClassRepository;

	@Override
	public List<VehicleClass> getAllVehicleClass() {
		return (List<VehicleClass>) vehicleClassRepository.findAll();
	}

}
