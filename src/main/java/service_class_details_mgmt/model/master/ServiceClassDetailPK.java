package service_class_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Service_CLASS_DETAILS database table.
 * 
 */
@Embeddable
public class ServiceClassDetailPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5839746384226812223L;

	@Column(name = "Service_CLASS_SEQ_NO")
	private Long serviceClassSeqNo;

	@Column(name = "Service_SEQ_NO")
	private Long serviceSeqNo;

	public ServiceClassDetailPK() {
	}

	public Long getServiceClassSeqNo() {
		return serviceClassSeqNo;
	}

	public void setServiceClassSeqNo(Long serviceClassSeqNo) {
		this.serviceClassSeqNo = serviceClassSeqNo;
	}

	public Long getServiceSeqNo() {
		return serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceClassSeqNo == null) ? 0 : serviceClassSeqNo.hashCode());
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
		ServiceClassDetailPK other = (ServiceClassDetailPK) obj;
		if (serviceClassSeqNo == null) {
			if (other.serviceClassSeqNo != null)
				return false;
		} else if (!serviceClassSeqNo.equals(other.serviceClassSeqNo))
			return false;
		if (serviceSeqNo == null) {
			if (other.serviceSeqNo != null)
				return false;
		} else if (!serviceSeqNo.equals(other.serviceSeqNo))
			return false;
		return true;
	}

	public ServiceClassDetailPK(Long serviceClassSeqNo, Long serviceSeqNo) {
		super();
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.serviceSeqNo = serviceSeqNo;
	}

}