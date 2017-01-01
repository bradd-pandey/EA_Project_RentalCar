package ea.project.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class PersonalDetail {
	
	private String title; 
	
	@NotEmpty(message="The first name must not be null")
	private
	String firstName;
	
	@NotEmpty(message="The middle name must not be null")
	private
	String middleName;
	
	@NotEmpty(message="The last name must not be null")
	private
	String lastName;
	
    @Past(message="Input valid date of birth date")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    @Temporal(TemporalType.DATE)
	private Date dateOfBirth;
		
	@NotEmpty(message = "The customer email must not be null")
	@Email
	private String customerEmail;
	
	 //validating phone number with -, . or spaces
	//@Pattern(regexp = "\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}", message = "Incorrect Phone Format")
	@NotEmpty(message = "The phone must not be valid")
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
    message="The phone must not be valid")
	private String customerPhone;

	//Driver license
	@NotEmpty(message = "The customer password must not be null")
	private String driverLicenceNumber;
	
	private String driverLicenceUsingCountryOrState;
	
	@Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "mm/dd/yyyy")
	@Future(message="The expired date is future date")
	private Date driverLicenceNumberExpirationDate;
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getDriverLicenceNumber() {
		return driverLicenceNumber;
	}

	public void setDriverLicenceNumber(String driverLicenceNumber) {
		this.driverLicenceNumber = driverLicenceNumber;
	}

	public String getDriverLicenceUsingCountryOrState() {
		return driverLicenceUsingCountryOrState;
	}

	public void setDriverLicenceUsingCountryOrState(String driverLicenceUsingCountryOrState) {
		this.driverLicenceUsingCountryOrState = driverLicenceUsingCountryOrState;
	}

	public Date getDriverLicenceNumberExpirationDate() {
		return driverLicenceNumberExpirationDate;
	}

	public void setDriverLicenceNumberExpirationDate(Date driverLicenceNumberExpirationDate) {
		this.driverLicenceNumberExpirationDate = driverLicenceNumberExpirationDate;
	}
}
