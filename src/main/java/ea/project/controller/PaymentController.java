package ea.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ea.project.domain.Confirmation;
import ea.project.domain.Customer;
import ea.project.domain.Reservation;
import ea.project.domain.Vehicle;
import ea.project.service.IConfirmationService;
import ea.project.service.IReservationService;




/**
 * @author swoven
 *@version 1.0
 */

@Controller
@RequestMapping(value="/payment")
public class PaymentController 
{	
	@Autowired
	private IReservationService reservationService;
	
	@Autowired
	private IConfirmationService confirmationService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String setPayment(Model model){
		return "CreditCard";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String confirmPayment(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		Reservation rev=(Reservation)session.getAttribute("reservation");
		Vehicle vehicle=(Vehicle)session.getAttribute("vehicle");
		Customer customer=(Customer)session.getAttribute("customer");
		Confirmation confirm=new Confirmation();
		confirm.setConfirmationNumber(confirm.createRandom());
		confirm.setReservation(rev);
		confirm.setCustomer(customer);
		confirm.setVehicle(vehicle);
		
		session.setAttribute("confirmation", confirm);
		reservationService.createReservation(rev);
		confirmationService.createConfirmation(confirm);
		
		return "redirect:/confirmation";
	}
	
	@RequestMapping(value="/cancelReservation")
	public String cancelPayment(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		session.removeAttribute("reservation");
		return "home";
	}
}
