package ea.project.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import org.springframework.web.multipart.MultipartFile;

import ea.project.customValidator.VehicleId;

/**
 * @author Bharat Pandey
 *
 */
@Entity
public class Vehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1705588213249003920L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@NotNull
	@VehicleId	// @VehicleId is a CustomValidator
	private Integer vehicleId;
	
	@OneToOne
	private VehicleClass vehicleClass;
	
	@OneToOne
	private Category category;
	
	@NotBlank
	@Size(min=4, max=20, message="{Vehicle.description.validation}")	
	private String description;
	
	@NotNull
	@Range(min = 1, max = 10, message="{Vehicle.capacity.validation}")
	private Integer capacity;
	
	@NotNull
	@Range(min = 1, max = 3, message="{Vehicle.bags.validation}")
	private Integer bags; 
	
	@NotNull
	private Double price;
	
	@NotEmpty
	private String specialFeatures;
	
	@Transient
	private MultipartFile  vehicleImage;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public VehicleClass getVehicleClass() {
		return vehicleClass;
	}
	public void setVehicleClass(VehicleClass vehicleClass) {
		this.vehicleClass = vehicleClass;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getBags() {
		return bags;
	}
	public void setBags(Integer bags) {
		this.bags = bags;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	public MultipartFile getVehicleImage() {
		return vehicleImage;
	}
	public void setVehicleImage(MultipartFile vehicleImage) {
		this.vehicleImage = vehicleImage;
	}

}
