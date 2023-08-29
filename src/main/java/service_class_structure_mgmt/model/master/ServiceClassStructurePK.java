package service_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_CLASS_STRUCTURE database table.
 * 
 */
@Embeddable
public class ServiceClassStructurePK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6939353313120038940L;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "RESOURCE_CLASS_SEQ_NO")
	private Long serviceClassSeqNo;

	@Column(name = "PAR_RESOURCE_CLASS_SEQ_NO")
	private Long parServiceClassSeqNo;

	public ServiceClassStructurePK() {
	}

	public Long getServiceClassSeqNo() {
		return this.serviceClassSeqNo;
	}

	public void setServiceClassSeqNo(Long serviceClassSeqNo) {
		this.serviceClassSeqNo = serviceClassSeqNo;
	}

	public Long getParServiceClassSeqNo() {
		return this.parServiceClassSeqNo;
	}

	public void setParServiceClassSeqNo(Long parServiceClassSeqNo) {
		this.parServiceClassSeqNo = parServiceClassSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parServiceClassSeqNo == null) ? 0 : parServiceClassSeqNo.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((serviceClassSeqNo == null) ? 0 : serviceClassSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceClassStructurePK other = (ServiceClassStructurePK) obj;
		if (parServiceClassSeqNo == null) {
			if (other.parServiceClassSeqNo != null)
				return false;
		} else if (!parServiceClassSeqNo.equals(other.parServiceClassSeqNo))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (serviceClassSeqNo == null) {
			if (other.serviceClassSeqNo != null)
				return false;
		} else if (!serviceClassSeqNo.equals(other.serviceClassSeqNo))
			return false;
		return true;
	}

	public ServiceClassStructurePK(Long partySeqNo, Long serviceClassSeqNo, Long parServiceClassSeqNo) {
		super();
		this.partySeqNo = partySeqNo;
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.parServiceClassSeqNo = parServiceClassSeqNo;
	}

}