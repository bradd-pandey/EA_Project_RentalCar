package ea.project.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class CreditCard {
	
	private String creditcardType;
	
	@Pattern(regexp = "\\d{11}", message = "Incorrect credit card Format")
	@CreditCardNumber
	private String creditCardNumber;
	
	 @DateTimeFormat(pattern = "mm/dd/yyyy")
    @Future(message="The expired date is future date")
	@Temporal(TemporalType.DATE)
	private Date creditCardExpirationDate;
	
	public String getCreditcardType() {
		return creditcardType;
	}
	public void setCreditcardType(String creditcardType) {
		this.creditcardType = creditcardType;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public Date getCreditCardExpirationDate() {
		return creditCardExpirationDate;
	}
	public void setCreditCardExpirationDate(Date creditCardExpirationDate) {
		this.creditCardExpirationDate = creditCardExpirationDate;
	}
}
