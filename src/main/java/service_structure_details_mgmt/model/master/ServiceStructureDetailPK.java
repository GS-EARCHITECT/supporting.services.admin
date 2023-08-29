package service_structure_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SERVICE_STRUCTURE_DETAILS database table.
 * 
 */
@Embeddable
public class ServiceStructureDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8181208048215514270L;

	@Column(name = "SERVICE_CLASS_SEQ_NO")
	private Long serviceClassSeqNo;

	@Column(name = "SERVICE_SEQ_NO")
	private Long serviceSeqNo;

	@Column(name = "PAR_SERVICE_CLASS_SEQ_NO")
	private Long parServiceClassSeqNo;

	@Column(name = "PAR_SERVICE_SEQ_NO")
	private Long parServiceSeqNo;

	public ServiceStructureDetailPK() {
	}

	public Long getServiceClassSeqNo() {
		return this.serviceClassSeqNo;
	}

	public void setServiceClassSeqNo(Long serviceClassSeqNo) {
		this.serviceClassSeqNo = serviceClassSeqNo;
	}

	public Long getServiceSeqNo() {
		return this.serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public Long getParServiceClassSeqNo() {
		return this.parServiceClassSeqNo;
	}

	public void setParServiceClassSeqNo(Long parServiceClassSeqNo) {
		this.parServiceClassSeqNo = parServiceClassSeqNo;
	}

	public Long getParServiceSeqNo() {
		return this.parServiceSeqNo;
	}

	public void setParServiceSeqNo(Long parServiceSeqNo) {
		this.parServiceSeqNo = parServiceSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ServiceStructureDetailPK)) {
			return false;
		}
		ServiceStructureDetailPK castOther = (ServiceStructureDetailPK) other;
		return (this.serviceClassSeqNo == castOther.serviceClassSeqNo)
				&& (this.serviceSeqNo == castOther.serviceSeqNo)
				&& (this.parServiceClassSeqNo == castOther.parServiceClassSeqNo)
				&& (this.parServiceSeqNo == castOther.parServiceSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.serviceClassSeqNo ^ (this.serviceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.serviceSeqNo ^ (this.serviceSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parServiceClassSeqNo ^ (this.parServiceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parServiceSeqNo ^ (this.parServiceSeqNo >>> 32)));
		return hash;

	}

	public ServiceStructureDetailPK(Long serviceClassSeqNo, Long serviceSeqNo, Long parServiceClassSeqNo,
			Long parServiceSeqNo) {
		super();
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.serviceSeqNo = serviceSeqNo;
		this.parServiceClassSeqNo = parServiceClassSeqNo;
		this.parServiceSeqNo = parServiceSeqNo;
	}
}