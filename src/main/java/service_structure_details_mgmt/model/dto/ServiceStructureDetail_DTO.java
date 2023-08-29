package service_structure_details_mgmt.model.dto;

import java.io.Serializable;

public class ServiceStructureDetail_DTO implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3826488719575325838L;
	private Long serviceClassSeqNo;
	private Long serviceSeqNo;
	private Long parServiceClassSeqNo;
	private Long parServiceSeqNo;

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

	public Long getParServiceClassSeqNo() {
		return parServiceClassSeqNo;
	}

	public void setParServiceClassSeqNo(Long parServiceClassSeqNo) {
		this.parServiceClassSeqNo = parServiceClassSeqNo;
	}

	public Long getParServiceSeqNo() {
		return parServiceSeqNo;
	}

	public void setParServiceSeqNo(Long parServiceSeqNo) {
		this.parServiceSeqNo = parServiceSeqNo;
	}

	public ServiceStructureDetail_DTO(Long serviceClassSeqNo, Long serviceSeqNo, Long parServiceClassSeqNo,
			Long parServiceSeqNo) {
		super();
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.serviceSeqNo = serviceSeqNo;
		this.parServiceClassSeqNo = parServiceClassSeqNo;
		this.parServiceSeqNo = parServiceSeqNo;
	}

	public ServiceStructureDetail_DTO() {
		super();
	}

}