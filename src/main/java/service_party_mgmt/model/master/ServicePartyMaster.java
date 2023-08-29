package service_party_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_PARTY_MASTER database table.
 * 
 */
@Entity
@Table(name = "SERVICE_PARTY_MASTER")
public class ServicePartyMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVICE_SEQUENCE")
	@SequenceGenerator(name = "SERVICE_SEQUENCE", sequenceName = "SERVICE_SEQUENCE", allocationSize = 1)
	@Column(name = "SERVICE_SEQ_NO")
	private Long serviceSeqNo;

	@Column(name = "DISC_PER")
	private Float discPer;

	@Column(name = "DISC_SEQ_NO")
	private Long discSeqNo;

	@Column(name = "DISC_VAL")
	private Float discVal;

	@Column(name = "DUR_CODE_SEQ_NO")
	private Long durCodeSeqNo;

	@Column(name = "DURATION")
	private Float duration;

	@Column(name = "MASTER_SERVICE_SEQ_NO")
	private Long masterServiceSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SERVICE_ID")
	private String serviceId;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "TAX_PER")
	private Float taxPer;

	@Column(name = "TAX_SEQ_NO")
	private Long taxSeqNo;

	@Column(name = "TAX_VAL")
	private Float taxVal;

	@Column(name = "UNIT_PRICE")
	private Long unitPrice;

	@Column(name = "UNIT_PRICE_SEQ_NO")
	private Long unitPriceSeqNo;

	public ServicePartyMaster() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((masterServiceSeqNo == null) ? 0 : masterServiceSeqNo.hashCode());
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
		ServicePartyMaster other = (ServicePartyMaster) obj;
		if (masterServiceSeqNo == null) {
			if (other.masterServiceSeqNo != null)
				return false;
		} else if (!masterServiceSeqNo.equals(other.masterServiceSeqNo))
			return false;
		if (serviceSeqNo == null) {
			if (other.serviceSeqNo != null)
				return false;
		} else if (!serviceSeqNo.equals(other.serviceSeqNo))
			return false;
		return true;
	}

	public ServicePartyMaster(Long serviceSeqNo, Float discPer, Long discSeqNo, Float discVal, Long durCodeSeqNo,
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