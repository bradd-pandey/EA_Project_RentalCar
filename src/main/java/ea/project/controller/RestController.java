package ea.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ea.project.domain.Confirmation;
import ea.project.domain.Reservation;
import ea.project.service.IConfirmationService;
import ea.project.service.IReservationService;



/**
 * @author swoven
 * @version 1.0
 * This controller can be used for all restful related stuff
 */
@Controller
@RequestMapping(value="/rest")
public class RestController 
{
	@Autowired
	private IReservationService reservationService;
	
	@Autowired
	private IConfirmationService confirmationService;
	
	@RequestMapping(value="/reservations", method=RequestMethod.GET)
	public @ResponseBody List<Reservation> getAllReservation(){
		return reservationService.listReservation();
	}
	
	@RequestMapping(value="/confirmations", method=RequestMethod.GET)
	public @ResponseBody List<Confirmation> getAllConfirmation(){
		return confirmationService.listConfirmation();
	}
}
