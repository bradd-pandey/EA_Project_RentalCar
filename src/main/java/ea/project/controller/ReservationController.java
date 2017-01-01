package ea.project.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.project.domain.CreditCard;
import ea.project.domain.Customer;
import ea.project.domain.PersonalDetail;
import ea.project.domain.Reservation;
import ea.project.domain.Vehicle;
import ea.project.service.ICustomerService;
import ea.project.service.VehicleService;
import ea.project.serviceImpl.CustomerServiceImpl;

/**
 * @author swoven
 * @version 1.0
 */
@Controller
@RequestMapping(value="/reservation")
public class ReservationController 
{	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String setReservation(@RequestParam("id") int id, Model model, HttpServletRequest request){
		Reservation reservation=new Reservation();
		Vehicle vehicle=vehicleService.findVehicleById(id);
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String name=auth.getName();
		System.out.println(name);
		Customer customer=(Customer)customerService.findCustomerByUserName(name);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("customer", customer);
		session.setAttribute("vehicle", vehicle);
		session.setAttribute("vehicleId", id);
		model.addAttribute("reservationForm", reservation);
		
		return "ReservationForm";
	}
	
	@RequestMapping(method= RequestMethod.POST) 
	public String createReservation(@ModelAttribute("reservationForm") Reservation reservation, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpServletRequest request){
		//Handling Error
		if(result.hasErrors()) {
			return "/ReservationForm";
		}
		HttpSession session=request.getSession();
		//Getting vehicle object from the vehicle service with the use of session id
		Vehicle vehicle=vehicleService.findVehicleById((Integer)session.getAttribute("vehicleId"));
		//setting up the reservation cost
		reservation.setCost(reservation.calculateCost(reservation.getPickUpDate(), reservation.getReturnDate(),vehicle.getPrice()));
		reservation.setVehicleId((Integer)session.getAttribute("vehicleId"));
		//adding flash attribute 
		redirectAttributes.addFlashAttribute("reservationAttribute", reservation);
		//adding reservation in session so that it can be accessed when we are in session
		session.setAttribute("reservation", reservation);		
//		System.out.println(reservation.getPickUpDate());
//		System.out.println(reservation.getReturnDate());
//		System.out.println(reservation.getCost());
		//reservationService.createReservation(reservation);
		return "redirect:/payment";
	}
}
