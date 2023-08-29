package service_party_mgmt.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_party_mgmt.model.dto.ServicePartyMaster_DTO;
import service_party_mgmt.model.master.ServicePartyMaster;
import service_party_mgmt.model.repo.ServicePartyMasterAdmin_Repo;

@Service("servicePartyMasterAdminServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServicePartyMasterAdmin_Service implements I_ServicePartyMasterAdmin_Service 
{

	@Autowired
	private ServicePartyMasterAdmin_Repo serviceMasterAdminRepo;

	public ServicePartyMaster_DTO newServicePartyMaster(ServicePartyMaster_DTO lMaster)
	{
		ServicePartyMaster ServicePartyMaster = serviceMasterAdminRepo.save(this.setServicePartyMaster(lMaster));
		lMaster = getServicePartyMaster_DTO(ServicePartyMaster);
		return lMaster;
	}
	
	public void updServicePartyMaster(ServicePartyMaster_DTO lMaster) 
	{
		ServicePartyMaster serviceMaster = this.setServicePartyMaster(lMaster);
		if (serviceMasterAdminRepo.existsById(lMaster.getServiceSeqNo())) 
				{		
			serviceMaster.setServiceSeqNo(lMaster.getServiceSeqNo());			
			serviceMasterAdminRepo.save(serviceMaster);			
		}
		return;
	}

	public ArrayList<ServicePartyMaster_DTO> getAllServicePartyMasters() 
	{
		ArrayList<ServicePartyMaster> serviceList = (ArrayList<ServicePartyMaster>) serviceMasterAdminRepo.findAll();
		ArrayList<ServicePartyMaster_DTO> lMasterss = serviceList != null ? this.getServicePartyMaster_DTOs(serviceList) : null;
		return lMasterss;
	}

	public ArrayList<ServicePartyMaster_DTO> getSelectServices(ArrayList<Long> ids)
	{
		ArrayList<ServicePartyMaster> lMasters = (ArrayList<ServicePartyMaster>) serviceMasterAdminRepo.findAllById(ids);
		ArrayList<ServicePartyMaster_DTO> lMasterss = lMasters != null ? this.getServicePartyMaster_DTOs(lMasters) : null;
		return lMasterss;	
	}
	
	public ArrayList<ServicePartyMaster_DTO> getSelectServicesByServiceIds( ArrayList<String> ids)
	{
		ArrayList<ServicePartyMaster> lMasters = serviceMasterAdminRepo.getSelectServicesByServiceIds(ids);
		ArrayList<ServicePartyMaster_DTO> lMasterss = lMasters != null ? this.getServicePartyMaster_DTOs(lMasters) : null;
		return lMasterss;	
	}
   
	public ArrayList<ServicePartyMaster_DTO> getSelectServicesByOEMs( ArrayList<Long> ids)
	{
		ArrayList<ServicePartyMaster> lMasters = serviceMasterAdminRepo.getSelectServicesByOEMs(ids);
		ArrayList<ServicePartyMaster_DTO> lMasterss = lMasters != null ? this.getServicePartyMaster_DTOs(lMasters) : null;
		return lMasterss;	
	}
	
	public ArrayList<ServicePartyMaster_DTO> getSelectServiceByParties( ArrayList<Long> ids)
	{
		ArrayList<ServicePartyMaster> lMasters = serviceMasterAdminRepo.getSelectServicesByParties(ids);
		ArrayList<ServicePartyMaster_DTO> lMasterss = lMasters != null ? this.getServicePartyMaster_DTOs(lMasters) : null;
		return lMasterss;	
	}
	
	public ArrayList<ServicePartyMaster_DTO> getSelectServicesByPriceRange(Float fr, Float to)
	{
		ArrayList<ServicePartyMaster> lMasters = serviceMasterAdminRepo.getSelectServicesByPriceRange(fr, to);
		ArrayList<ServicePartyMaster_DTO> lMasterss = lMasters != null ? this.getServicePartyMaster_DTOs(lMasters) : null;
		return lMasterss;
	}

	public void delAllServicePartyMasters() {
		serviceMasterAdminRepo.deleteAll();
	}

	public void delSelectServices(ArrayList<Long> serviceSeqNos) 
	{
		if (serviceSeqNos != null) {
			serviceMasterAdminRepo.delSelectServices(serviceSeqNos);
		}
	}

	public void delSelectServiceByParties(ArrayList<Long> serviceSeqNos) 
	{
		if (serviceSeqNos != null) {
			serviceMasterAdminRepo.delSelectServiceByParties(serviceSeqNos);
		}
	}
	
	public void delSelectServicesByOEMs(ArrayList<Long> serviceSeqNos) 
	{
		if (serviceSeqNos != null) {
			serviceMasterAdminRepo.delSelectServicesByOEMs(serviceSeqNos);
		}
	}
	
	public void delSelectServicesByPriceRange( Float fr, Float to) 
	{
		serviceMasterAdminRepo.delSelectServicesByPriceRange(fr, to);
	
	}
	
	private ArrayList<ServicePartyMaster_DTO> getServicePartyMaster_DTOs(ArrayList<ServicePartyMaster> lMasters) {
		ServicePartyMaster_DTO lDTO = null;
		ArrayList<ServicePartyMaster_DTO> lMasterDTOs = new ArrayList<ServicePartyMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServicePartyMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServicePartyMaster_DTO getServicePartyMaster_DTO(ServicePartyMaster lMaster) 
	{		
		ServicePartyMaster_DTO lDTO = new ServicePartyMaster_DTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setUnitPrice(lMaster.getUnitPrice());
		lDTO.setUnitPriceSeqNo(lMaster.getUnitPriceSeqNo());
		lDTO.setDiscSeqNo(lMaster.getDiscSeqNo());
		lDTO.setDiscPer(lMaster.getDiscPer());
		lDTO.setDiscVal(lMaster.getDiscVal());
		lDTO.setTaxSeqNo(lMaster.getTaxSeqNo());
		lDTO.setTaxPer(lMaster.getTaxPer());
		lDTO.setTaxVal(lMaster.getTaxVal());
		lDTO.setDuration(lMaster.getDuration());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());		
		lDTO.setServiceId(lMaster.getServiceId());
		lDTO.setDurCodeSeqNo(lMaster.getDurCodeSeqNo());
		lDTO.setPartySeqNo(lMaster.getPartySeqNo());
		lDTO.setMasterServiceSeqNo(lMaster.getMasterServiceSeqNo());
		lDTO.setServiceSeqNo(lMaster.getServiceSeqNo());
		return lDTO;
	}

	private ServicePartyMaster setServicePartyMaster(ServicePartyMaster_DTO lDTO) 
	{
		ServicePartyMaster lMaster = new ServicePartyMaster();				
		lMaster.setRemark(lDTO.getRemark());		
		lMaster.setUnitPrice(lDTO.getUnitPrice());
		lMaster.setUnitPriceSeqNo(lDTO.getUnitPriceSeqNo());
		lMaster.setDiscSeqNo(lDTO.getDiscSeqNo());
		lMaster.setDiscPer(lDTO.getDiscPer());
		lMaster.setDiscVal(lDTO.getDiscVal());
		lMaster.setTaxSeqNo(lDTO.getTaxSeqNo());
		lMaster.setTaxPer(lDTO.getTaxPer());
		lMaster.setTaxVal(lDTO.getTaxVal());
		lMaster.setDuration(lDTO.getDuration());
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());		
		lMaster.setServiceId(lDTO.getServiceId());
		lMaster.setDurCodeSeqNo(lDTO.getDurCodeSeqNo());
		lMaster.setPartySeqNo(lDTO.getPartySeqNo());
		lMaster.setMasterServiceSeqNo(lDTO.getMasterServiceSeqNo());
		return lMaster;
	}
}