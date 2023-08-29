package service_class_details_mgmt.model.dto;

import java.io.Serializable;

public class ServiceClassDetail_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4779957818815714120L;
	private Long serviceClassSeqNo;
	private Long serviceSeqNo;
	
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

	public ServiceClassDetail_DTO(Long serviceClassSeqNo, Long serviceSeqNo)
	{
		super();
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.serviceSeqNo = serviceSeqNo;
	}

	public ServiceClassDetail_DTO() {
		super();
	}

}