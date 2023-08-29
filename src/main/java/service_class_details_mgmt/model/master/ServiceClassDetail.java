package service_class_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_CLASS_DETAILS database table.
 * 
 */
@Entity
@Table(name = "SERVICE_CLASS_DETAILS")
public class ServiceClassDetail implements Serializable 
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4953748441508039467L;
	@EmbeddedId
	private ServiceClassDetailPK id;

	public ServiceClassDetail() {
	}

	public ServiceClassDetailPK getId() {
		return this.id;
	}

	public void setId(ServiceClassDetailPK id) {
		this.id = id;
	}

	public ServiceClassDetail(ServiceClassDetailPK id) {
		super();
		this.id = id;
	}

}