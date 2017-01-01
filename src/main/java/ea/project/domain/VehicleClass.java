package ea.project.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Bharat Pandey
 *
 */
@Entity
public class VehicleClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7335465689356801706L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	private String classType;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}



}
