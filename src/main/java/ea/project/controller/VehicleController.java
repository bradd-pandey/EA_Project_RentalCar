package ea.project.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.project.domain.Category;
import ea.project.domain.Vehicle;
import ea.project.domain.VehicleClass;
import ea.project.service.CategoryService;
import ea.project.service.VehicleClassService;
import ea.project.service.VehicleService;

/**
 * @author Bharat Pandey
 *
 */
@Controller
@RequestMapping(value={"/","/vehicle"})
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	VehicleClassService vehicleClassService;
	
	@RequestMapping(value={"","/showVehicle"}, method = RequestMethod.GET)
	public String showVehicles(Model model){
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		model.addAttribute("vehicles", vehicles);
		return "home";
	}
	
	@RequestMapping("/vehicleDetail")
	public String getVehicleById(Model model, @RequestParam("id") Integer vehicleId) {
		Vehicle vehicle = vehicleService.findVehicleById(vehicleId);
		model.addAttribute("vehicle", vehicle);
		return "vehicleDetails";
	}
	
	@RequestMapping(value="/addVehicle", method = RequestMethod.GET)
	public String addVehicle(@ModelAttribute("newVehicle") Vehicle vehicle, Model model){
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("categories",categories);
		List<VehicleClass> vehicleClasses = vehicleClassService.getAllVehicleClass();
		System.out.println(vehicleClasses);
		model.addAttribute("vehicleClasses", vehicleClasses);
		return "addVehicle";
	}
	
	@RequestMapping(value="/addVehicle", method = RequestMethod.POST)
	public String saveVehicle(@Valid @ModelAttribute("newVehicle") Vehicle vehicle, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request, Model model){
		if(bindingResult.hasErrors()){
			List<Category> categories = categoryService.getAllCategory();
			model.addAttribute("categories",categories);
			List<VehicleClass> vehicleClasses = vehicleClassService.getAllVehicleClass();
			System.out.println(vehicleClasses);
			model.addAttribute("vehicleClasses", vehicleClasses);
			return "addVehicle";
		}
		MultipartFile vehicletImage = vehicle.getVehicleImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (vehicletImage!=null && !vehicletImage.isEmpty()) {
		       try {
		    	   vehicletImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+vehicle.getVehicleId() + ".png"));
		       } catch (Exception e) {
		    	   throw new RuntimeException("Vehicle Image saving failed", e);
		       }		
		}
		vehicleService.saveVehicle(vehicle);
		redirectAttributes.addFlashAttribute(vehicle);
		return "redirect:/vehicle";
	}
	
	@RequestMapping(value="/removeVehicle", method = RequestMethod.GET)
	public String removeVehicle(@RequestParam("id") Integer id) {
		vehicleService.removeVehicle(id);		
		return "redirect:/vehicle";
	}
}
