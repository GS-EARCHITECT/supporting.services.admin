package service_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_CLASS_STRUCTURE database table.
 * 
 */
@Entity
@Table(name = "SERVICE_CLASS_STRUCTURE")
public class ServiceClassStructure implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -165096294394351290L;
	
	@EmbeddedId
	private ServiceClassStructurePK id;

	public ServiceClassStructure() {
	}

	public ServiceClassStructurePK getId() {
		return this.id;
	}

	public void setId(ServiceClassStructurePK id) {
		this.id = id;
	}

	public ServiceClassStructure(ServiceClassStructurePK id) {
		super();
		this.id = id;
	}

}