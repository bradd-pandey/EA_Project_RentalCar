package ea.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author swoven
 *@version 1.0
 */

@Controller
@RequestMapping(value="/confirmation")
public class ConfirmationController 
{
	@RequestMapping(method=RequestMethod.GET)
	public String setConfirmation(){
		return "Confirmation";
	}
	
	@RequestMapping(value="/backHome")
	public String transactionComplete(HttpServletRequest request){
		request.getSession().invalidate();
		return "home";
	}
}
