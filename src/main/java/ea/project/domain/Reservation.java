package ea.project.domain;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author swoven
 * @version 1.0
 *Reservation POJO
 */

@Entity
public class Reservation implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2000174163656047611L;
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name="PickUpDate")
	@Temporal(TemporalType.DATE)
	private Date pickUpDate;
	
	@Column(name="ReturnDate")
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	
	@Column(name="Cost")
	private double cost;
	
	private Integer vehicleId;
	
	public Reservation(){
		//default
	}
	
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	@Transient
	public double calculateCost(Date start, Date end, double price){
		
		int days=(int)(end.getTime()-start.getTime())/(1000*60*60*24);
		double totPrice = price + price*days;
		System.out.println(totPrice);
		return totPrice;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
