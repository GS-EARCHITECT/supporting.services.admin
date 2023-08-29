package service_structure_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_STRUCTURE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "SERVICE_STRUCTURE_DETAILS")
public class ServiceStructureDetail implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5739340476409640346L;
	@EmbeddedId
	private ServiceStructureDetailPK id;

	public ServiceStructureDetail() {
	}

	public ServiceStructureDetailPK getId() {
		return this.id;
	}

	public void setId(ServiceStructureDetailPK id) {
		this.id = id;
	}

	public ServiceStructureDetail(ServiceStructureDetailPK id) {
		super();
		this.id = id;
	}
	
	

}