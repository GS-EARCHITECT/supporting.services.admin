package service_class_structure_mgmt.model.dto;

import java.io.Serializable;

public class ServiceClassStructure_DTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9048219497594623051L;
	private Long partySeqNo;
	private Long serviceClassSeqNo;
	private Long parServiceClassSeqNo;

	public Long getServiceClassSeqNo() {
		return serviceClassSeqNo;
	}

	public void setServiceClassSeqNo(Long serviceClassSeqNo) {
		this.serviceClassSeqNo = serviceClassSeqNo;
	}

	public Long getParServiceClassSeqNo() {
		return parServiceClassSeqNo;
	}

	public void setParServiceClassSeqNo(Long parServiceClassSeqNo) {
		this.parServiceClassSeqNo = parServiceClassSeqNo;
	}

	public ServiceClassStructure_DTO(Long partySeqNo, Long serviceClassSeqNo, Long parServiceClassSeqNo) {
		super();
		this.partySeqNo = partySeqNo;
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.parServiceClassSeqNo = parServiceClassSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public ServiceClassStructure_DTO() {
		super();
	}

}