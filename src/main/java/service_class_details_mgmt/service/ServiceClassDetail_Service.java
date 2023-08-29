package service_class_details_mgmt.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_class_details_mgmt.model.dto.ServiceClassDetail_DTO;
import service_class_details_mgmt.model.master.ServiceClassDetail;
import service_class_details_mgmt.model.master.ServiceClassDetailPK;
import service_class_details_mgmt.model.repo.ServiceClassDetails_Repo;

@Service("serviceClassDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceClassDetail_Service implements I_ServiceClassDetails_Service 
{

	@Autowired
	private ServiceClassDetails_Repo serviceClassDetailsRepo;

	public ServiceClassDetail_DTO newServiceClassDetail(ServiceClassDetail_DTO lDetails) 
	{
		Optional<ServiceClassDetail> serviceClassDetails = null;
		ServiceClassDetail_DTO serviceClassDetailsDTO = null;
		ServiceClassDetailPK serviceClassDetailsPK = new ServiceClassDetailPK();
		serviceClassDetailsPK.setServiceSeqNo(lDetails.getServiceSeqNo());
		serviceClassDetailsPK.setServiceClassSeqNo(lDetails.getServiceClassSeqNo());
		serviceClassDetails = serviceClassDetailsRepo.findById(serviceClassDetailsPK);
		
		if(!serviceClassDetails.isPresent())
		{
		serviceClassDetails.get().setId(serviceClassDetailsPK);	
		serviceClassDetailsDTO = 	getServiceClassDetail_DTO(serviceClassDetailsRepo.save(serviceClassDetails.get()));
		}
		return serviceClassDetailsDTO;
	}

	public ArrayList<ServiceClassDetail_DTO> getAllServiceClassDetails() {
		ArrayList<ServiceClassDetail> serviceList = (ArrayList<ServiceClassDetail>) serviceClassDetailsRepo.findAll();
		ArrayList<ServiceClassDetail_DTO> lDetails = new ArrayList<ServiceClassDetail_DTO>();
		lDetails = serviceList != null ? this.getServiceClassDetail_DTOs(serviceList) : null;
		return lDetails;
	}

    
	public ArrayList<ServiceClassDetail_DTO> getSelectServicesForClasses(ArrayList<Long> ids)
    {
		ArrayList<ServiceClassDetail> lDetails = serviceClassDetailsRepo.getSelectServicesForClasses(ids);
		ArrayList<ServiceClassDetail_DTO> serviceClassDetailsDTOs = null;
		serviceClassDetailsDTOs = lDetails != null ? this.getServiceClassDetail_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}

	public ArrayList<ServiceClassDetail_DTO> getSelectServiceClassDetails(ArrayList<ServiceClassDetailPK> ids)
    {
		ArrayList<ServiceClassDetail> lDetails = (ArrayList<ServiceClassDetail>) serviceClassDetailsRepo.findAllById(ids);
		ArrayList<ServiceClassDetail_DTO> serviceClassDetailsDTOs = null;
		serviceClassDetailsDTOs = lDetails != null ? this.getServiceClassDetail_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}
		
	public void updServiceClassDetail(ServiceClassDetail_DTO lDetails) 
	{
		ServiceClassDetailPK serviceClassDetailsPK = new ServiceClassDetailPK();
		serviceClassDetailsPK.setServiceSeqNo(lDetails.getServiceSeqNo());
		serviceClassDetailsPK.setServiceClassSeqNo(lDetails.getServiceClassSeqNo());	
		
		if (serviceClassDetailsRepo.existsById(serviceClassDetailsPK)) 
			{			
			serviceClassDetailsRepo.save(this.setServiceClassDetail(lDetails));			
		}
		return;
	}

	
	public void delAllServiceClassDetails() {
		serviceClassDetailsRepo.deleteAll();
	}

	public void delSelectServiceClassDetails(ArrayList<ServiceClassDetailPK> ids) 
	{
		if (ids != null) 
		{
			serviceClassDetailsRepo.deleteAllById(ids);
		}
	}
	
	public void delSelectServicesForClasses(ArrayList<Long> ids) 
	{
		if (ids != null) 
		{
			serviceClassDetailsRepo.delSelectServicesForClasses(ids);
		}
	}

	private ArrayList<ServiceClassDetail_DTO> getServiceClassDetail_DTOs(ArrayList<ServiceClassDetail> lDetails) {
		ServiceClassDetail_DTO lDTO = null;
		ArrayList<ServiceClassDetail_DTO> lDetailsDTOs = new ArrayList<ServiceClassDetail_DTO>();		
		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getServiceClassDetail_DTO(lDetails.get(i));			
			lDetailsDTOs.add(lDTO);
		}
		return lDetailsDTOs;
	}

	private ServiceClassDetail_DTO getServiceClassDetail_DTO(ServiceClassDetail lDetails) 
	{		
		ServiceClassDetail_DTO lDTO = new ServiceClassDetail_DTO();		
		lDTO.setServiceSeqNo(lDetails.getId().getServiceSeqNo());
		lDTO.setServiceClassSeqNo(lDetails.getId().getServiceClassSeqNo());
		return lDTO;
	}

	private ServiceClassDetail setServiceClassDetail(ServiceClassDetail_DTO lDTO) 
	{
		ServiceClassDetail lDetails = new ServiceClassDetail();
		ServiceClassDetailPK serviceClassDetailsPK = new ServiceClassDetailPK();
		serviceClassDetailsPK.setServiceSeqNo(lDTO.getServiceSeqNo());
		serviceClassDetailsPK.setServiceClassSeqNo(lDTO.getServiceClassSeqNo());
		lDetails.setId(serviceClassDetailsPK);
		return lDetails;
	}
}