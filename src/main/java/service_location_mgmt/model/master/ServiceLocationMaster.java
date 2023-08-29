package service_location_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_LOCATION_MASTER database table.
 * 
 */
@Entity
@Table(name="SERVICE_LOCATION_MASTER")
public class ServiceLocationMaster implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1740229423912806847L;

	@EmbeddedId
	private ServiceLocationMasterPK id;

	@Column(name="QTY")
	private Float qty;

	@Column(name="QTY_SEQ_NO")
	private Long qtySeqNo;

	public ServiceLocationMasterPK getId() {
		return id;
	}

	public void setId(ServiceLocationMasterPK id) {
		this.id = id;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtySeqNo() {
		return qtySeqNo;
	}

	public void setQtySeqNo(Long qtySeqNo) {
		this.qtySeqNo = qtySeqNo;
	}

	public ServiceLocationMaster(ServiceLocationMasterPK id, Float qty, Long qtySeqNo) {
		super();
		this.id = id;
		this.qty = qty;
		this.qtySeqNo = qtySeqNo;
	}

	public ServiceLocationMaster() {
		super();
	}
		
}