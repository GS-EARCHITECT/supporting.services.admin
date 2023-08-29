package service_party_mgmt.model.dto;

import java.io.Serializable;

public class ServicePartyMaster_DTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -125261785256616166L;
	private Long serviceSeqNo;
	private Float discPer;
	private Long discSeqNo;
	private Float discVal;
	private Long durCodeSeqNo;
	private Float duration;
	private Long masterServiceSeqNo;
	private Long partySeqNo;
	private String remark;
	private String serviceId;
	private Long specificationSeqNo;
	private Float taxPer;
	private Long taxSeqNo;
	private Float taxVal;
	private Long unitPrice;
	private Long unitPriceSeqNo;

	public ServicePartyMaster_DTO() {
	}

	public Long getServiceSeqNo() {
		return this.serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public Float getDiscPer() {
		return this.discPer;
	}

	public void setDiscPer(Float discPer) {
		this.discPer = discPer;
	}

	public Long getDiscSeqNo() {
		return this.discSeqNo;
	}

	public void setDiscSeqNo(Long discSeqNo) {
		this.discSeqNo = discSeqNo;
	}

	public Float getDiscVal() {
		return this.discVal;
	}

	public void setDiscVal(Float discVal) {
		this.discVal = discVal;
	}

	public Long getDurCodeSeqNo() {
		return this.durCodeSeqNo;
	}

	public void setDurCodeSeqNo(Long durCodeSeqNo) {
		this.durCodeSeqNo = durCodeSeqNo;
	}

	public Float getDuration() {
		return this.duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Long getMasterServiceSeqNo() {
		return this.masterServiceSeqNo;
	}

	public void setMasterServiceSeqNo(Long masterServiceSeqNo) {
		this.masterServiceSeqNo = masterServiceSeqNo;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public Float getTaxPer() {
		return this.taxPer;
	}

	public void setTaxPer(Float taxPer) {
		this.taxPer = taxPer;
	}

	public Long getTaxSeqNo() {
		return this.taxSeqNo;
	}

	public void setTaxSeqNo(Long taxSeqNo) {
		this.taxSeqNo = taxSeqNo;
	}

	public Float getTaxVal() {
		return this.taxVal;
	}

	public void setTaxVal(Float taxVal) {
		this.taxVal = taxVal;
	}

	public Long getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getUnitPriceSeqNo() {
		return this.unitPriceSeqNo;
	}

	public void setUnitPriceSeqNo(Long unitPriceSeqNo) {
		this.unitPriceSeqNo = unitPriceSeqNo;
	}

	public ServicePartyMaster_DTO(Long serviceSeqNo, Float discPer, Long discSeqNo, Float discVal, Long durCodeSeqNo,
			Float duration, Long masterServiceSeqNo, Long partySeqNo, String remark, String serviceId,
			Long specificationSeqNo, Float taxPer, Long taxSeqNo, Float taxVal, Long unitPrice, Long unitPriceSeqNo) {
		super();
		this.serviceSeqNo = serviceSeqNo;
		this.discPer = discPer;
		this.discSeqNo = discSeqNo;
		this.discVal = discVal;
		this.durCodeSeqNo = durCodeSeqNo;
		this.duration = duration;
		this.masterServiceSeqNo = masterServiceSeqNo;
		this.partySeqNo = partySeqNo;
		this.remark = remark;
		this.serviceId = serviceId;
		this.specificationSeqNo = specificationSeqNo;
		this.taxPer = taxPer;
		this.taxSeqNo = taxSeqNo;
		this.taxVal = taxVal;
		this.unitPrice = unitPrice;
		this.unitPriceSeqNo = unitPriceSeqNo;
	}

}