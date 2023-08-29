package service_location_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_location_mgmt.model.dto.ServiceLocationMaster_DTO;
import service_location_mgmt.model.master.ServiceLocationMaster;
import service_location_mgmt.model.master.ServiceLocationMasterPK;
import service_location_mgmt.model.repo.ServiceLocationMasterAdmin_Repo;

@Service("serviceLocationMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceLocationMasterAdmin_Service implements I_ServiceLocationMasterAdmin_Service 
{

	@Autowired
	private ServiceLocationMasterAdmin_Repo serviceLocationMasterAdminRepo;

	public ServiceLocationMaster_DTO newPartyLocationService(ServiceLocationMaster_DTO lMaster) 
	{
		ServiceLocationMasterPK serviceLocationMasterPK= new ServiceLocationMasterPK();
		serviceLocationMasterPK.setLocationSeqNo(lMaster.getLocationSeqNo());
		serviceLocationMasterPK.setServiceSeqNo(lMaster.getServiceSeqNo());
		serviceLocationMasterPK.setPartySeqNo(lMaster.getServiceSeqNo());
		Optional<ServiceLocationMaster> resOptional = serviceLocationMasterAdminRepo.findById(serviceLocationMasterPK);
		ServiceLocationMaster serviceLocationMaster = null;
		ServiceLocationMaster_DTO serviceLocationMasterDTO = null;
		
		if(!resOptional.isPresent())
		{
		serviceLocationMaster = this.setServiceLocationMaster(lMaster);
		serviceLocationMaster.setId(serviceLocationMasterPK);
		serviceLocationMasterDTO=getServiceLocationMaster_DTO(serviceLocationMasterAdminRepo.save(serviceLocationMaster));
		}	
		return serviceLocationMasterDTO;
	}

	public void updPartyLocationService(ServiceLocationMaster_DTO lDTO) 
	{
		ServiceLocationMasterPK serviceLocationMasterPK= new ServiceLocationMasterPK();
 		serviceLocationMasterPK.setLocationSeqNo(lDTO.getLocationSeqNo());
 		serviceLocationMasterPK.setServiceSeqNo(lDTO.getServiceSeqNo());
 		serviceLocationMasterPK.setPartySeqNo(lDTO.getPartySeqNo());
 		 		
 		if(serviceLocationMasterAdminRepo.existsById(serviceLocationMasterPK))
 		{
 			serviceLocationMasterAdminRepo.save(this.setServiceLocationMaster(lDTO));	
 		}
 	
		return;
	}

	
	public ArrayList<ServiceLocationMaster_DTO> getAllPartyLocationServices() 
	{
		ArrayList<ServiceLocationMaster> serviceList = (ArrayList<ServiceLocationMaster>) serviceLocationMasterAdminRepo.findAll();
		ArrayList<ServiceLocationMaster_DTO> lMasters = new ArrayList<ServiceLocationMaster_DTO>();
		lMasters = serviceList != null ? this.getServiceLocationMaster_DTOs(serviceList) : null;
		return lMasters;
	}

	public ArrayList<ServiceLocationMaster_DTO> getSelectServicesPartyLocations(ArrayList<ServiceLocationMasterPK> serviceLocationMasterPKs)
	{
		ArrayList<ServiceLocationMaster> lMasters = (ArrayList<ServiceLocationMaster>) serviceLocationMasterAdminRepo.findAllById(serviceLocationMasterPKs);
		ArrayList<ServiceLocationMaster_DTO> serviceLocationMaster_DTOs = new ArrayList<ServiceLocationMaster_DTO>();
		serviceLocationMaster_DTOs = serviceLocationMaster_DTOs != null ? this.getServiceLocationMaster_DTOs(lMasters) : null;
		return serviceLocationMaster_DTOs;
	}
	
	
	public ArrayList<ServiceLocationMaster_DTO> getSelectServicesByLocations( ArrayList<Long> lidss)
	{
		ArrayList<ServiceLocationMaster> lMasters = serviceLocationMasterAdminRepo.getSelectServicesByLocations(lidss);
		ArrayList<ServiceLocationMaster_DTO> serviceLocationMaster_DTOs = new ArrayList<ServiceLocationMaster_DTO>();
		serviceLocationMaster_DTOs = serviceLocationMaster_DTOs != null ? this.getServiceLocationMaster_DTOs(lMasters) : null;
		return serviceLocationMaster_DTOs;
	}

	public ArrayList<ServiceLocationMaster_DTO> getSelectServicesByParties(ArrayList<Long> pids)
	{
		ArrayList<ServiceLocationMaster> lMasters = serviceLocationMasterAdminRepo.getSelectServicesByParties(pids);
		ArrayList<ServiceLocationMaster_DTO> serviceLocationMaster_DTOs = new ArrayList<ServiceLocationMaster_DTO>();
		serviceLocationMaster_DTOs = serviceLocationMaster_DTOs != null ? this.getServiceLocationMaster_DTOs(lMasters) : null;
		return serviceLocationMaster_DTOs;
	}

    public ArrayList<ServiceLocationMaster_DTO> getSelectServices(ArrayList<Long> rids)
	{
		ArrayList<ServiceLocationMaster> lMasters = serviceLocationMasterAdminRepo.getSelectServices(rids);
		ArrayList<ServiceLocationMaster_DTO> serviceLocationMaster_DTOs = new ArrayList<ServiceLocationMaster_DTO>();
		serviceLocationMaster_DTOs = serviceLocationMaster_DTOs != null ? this.getServiceLocationMaster_DTOs(lMasters) : null;
		return serviceLocationMaster_DTOs;
	}

    public void delSelectServicesByLocations( ArrayList<Long> lids)
    {
    serviceLocationMasterAdminRepo.delSelectServicesByLocations(lids);
    }
    
    public void delSelectServicesByParties( ArrayList<Long> pidss)
    {
    serviceLocationMasterAdminRepo.delSelectServicesByParties(pidss);
    }
    
    public void delSelectServices( ArrayList<Long> ridss)
    {
    serviceLocationMasterAdminRepo.delSelectServices(ridss);
    }
    
    public void delAllPartyLocationService() 
	{
		serviceLocationMasterAdminRepo.deleteAll();
	}

	
	private synchronized ArrayList<ServiceLocationMaster_DTO> getServiceLocationMaster_DTOs(ArrayList<ServiceLocationMaster> lMaster) 
	{
		ServiceLocationMaster_DTO lDTO = null;
		ArrayList<ServiceLocationMaster_DTO> lMasterDTOs = new ArrayList<ServiceLocationMaster_DTO>();		
		for (int i = 0; i < lMaster.size(); i++) {
			lDTO = getServiceLocationMaster_DTO(lMaster.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized ServiceLocationMaster_DTO getServiceLocationMaster_DTO(ServiceLocationMaster lMaster) 
	{		
		ServiceLocationMaster_DTO lDTO = new ServiceLocationMaster_DTO();
		lDTO.setLocationSeqNo(lMaster.getId().getLocationSeqNo());		
		lDTO.setServiceSeqNo(lMaster.getId().getServiceSeqNo());
		lDTO.setPartySeqNo(lMaster.getId().getPartySeqNo());
		lDTO.setQtySeqNo(lMaster.getQtySeqNo());
		lDTO.setQty(lMaster.getQty());
		return lDTO;
	}
	
	private synchronized ServiceLocationMaster setServiceLocationMaster(ServiceLocationMaster_DTO lDTO) 
	{
		ServiceLocationMaster lMaster = new ServiceLocationMaster();
		ServiceLocationMasterPK serviceLocationMasterPK= new ServiceLocationMasterPK();
 		serviceLocationMasterPK.setLocationSeqNo(lDTO.getLocationSeqNo());
 		serviceLocationMasterPK.setServiceSeqNo(lDTO.getServiceSeqNo());
 		serviceLocationMasterPK.setPartySeqNo(lDTO.getPartySeqNo());
 		lMaster.setId(serviceLocationMasterPK);
		lMaster.setQty(lDTO.getQty());
		lMaster.setQtySeqNo(lDTO.getQtySeqNo());
		return lMaster;
	}

}