package service_location_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SERVICE_LOCATION_MASTER database table.
 * 
 */
@Embeddable
public class ServiceLocationMasterPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "SERVICE_SEQ_NO")
	private Long serviceSeqNo;

	@Column(name = "LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	public Long getServiceSeqNo() {
		return serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
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
		result = prime * result + ((locationSeqNo == null) ? 0 : locationSeqNo.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((serviceSeqNo == null) ? 0 : serviceSeqNo.hashCode());
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
		ServiceLocationMasterPK other = (ServiceLocationMasterPK) obj;
		if (locationSeqNo == null) {
			if (other.locationSeqNo != null)
				return false;
		} else if (!locationSeqNo.equals(other.locationSeqNo))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (serviceSeqNo == null) {
			if (other.serviceSeqNo != null)
				return false;
		} else if (!serviceSeqNo.equals(other.serviceSeqNo))
			return false;
		return true;
	}

	public ServiceLocationMasterPK(Long serviceSeqNo, Long locationSeqNo, Long partySeqNo) {
		super();
		this.serviceSeqNo = serviceSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.partySeqNo = partySeqNo;
	}

	public ServiceLocationMasterPK() {
		super();
	}

}