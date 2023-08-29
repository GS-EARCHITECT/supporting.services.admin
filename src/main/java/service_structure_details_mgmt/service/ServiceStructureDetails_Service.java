package service_structure_details_mgmt.service;

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
import service_structure_details_mgmt.model.dto.ServiceStructureDetail_DTO;
import service_structure_details_mgmt.model.master.ServiceStructureDetail;
import service_structure_details_mgmt.model.master.ServiceStructureDetailPK;
import service_structure_details_mgmt.model.repo.ServiceStructureDetails_Repo;

@Service("serviceStructureDetailServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceStructureDetails_Service implements I_ServiceStructureDetails_Service 
{

	@Autowired
	private ServiceStructureDetails_Repo ServiceStructureDetailsRepo;

	public ServiceStructureDetail_DTO newServiceStructureDetail(ServiceStructureDetail_DTO lStructure) 
	{
		ServiceStructureDetail_DTO ServiceStructureDetailDTO = null;
		ServiceStructureDetailPK ServiceStructureDetailPK = new ServiceStructureDetailPK();
		ServiceStructureDetailPK.setParServiceClassSeqNo(lStructure.getParServiceClassSeqNo());
		ServiceStructureDetailPK.setServiceClassSeqNo(lStructure.getServiceClassSeqNo());
		ServiceStructureDetailPK.setParServiceSeqNo(lStructure.getParServiceSeqNo());
		ServiceStructureDetailPK.setServiceSeqNo(lStructure.getServiceSeqNo());
		
		if (!ServiceStructureDetailsRepo.existsById(ServiceStructureDetailPK)) 
		{			
			ServiceStructureDetailDTO = getServiceStructureDetail_DTO(
			ServiceStructureDetailsRepo.save(this.setServiceStructureDetail(lStructure)));
		}
		return ServiceStructureDetailDTO;
	}
	
	public void updServiceStructureDetail(ServiceStructureDetail_DTO lStructure) 
	{
		ServiceStructureDetailPK ServiceStructureDetailPK = new ServiceStructureDetailPK();
		ServiceStructureDetailPK.setParServiceClassSeqNo(lStructure.getParServiceClassSeqNo());
		ServiceStructureDetailPK.setServiceClassSeqNo(lStructure.getServiceClassSeqNo());
		ServiceStructureDetailPK.setParServiceSeqNo(lStructure.getParServiceSeqNo());
		ServiceStructureDetailPK.setServiceSeqNo(lStructure.getServiceSeqNo());

		if (ServiceStructureDetailsRepo.existsById(ServiceStructureDetailPK)) 
		{
			ServiceStructureDetailsRepo.save(this.setServiceStructureDetail(lStructure));
		}
		return;
	}

	public ArrayList<ServiceStructureDetail_DTO> getAllServiceStructureDetails()
    {
		ArrayList<ServiceStructureDetail> lDetails = (ArrayList<ServiceStructureDetail>) ServiceStructureDetailsRepo.findAll();
		ArrayList<ServiceStructureDetail_DTO> serviceClassDetailsDTOs = lDetails != null ? this.getServiceStructureDetail_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}

	
	public ArrayList<ServiceStructureDetail_DTO> getSelectServiceStructureDetails(ArrayList<ServiceStructureDetailPK> ids)
    {
		ArrayList<ServiceStructureDetail> lDetails = (ArrayList<ServiceStructureDetail>) ServiceStructureDetailsRepo.findAllById(ids);
		ArrayList<ServiceStructureDetail_DTO> serviceClassDetailsDTOs = lDetails != null ? this.getServiceStructureDetail_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}
	
	public ArrayList<ServiceStructureDetail_DTO> getSelectServiceStructureDetailsByServices(ArrayList<Long> ids, ArrayList<Long> cids)
    {
		ArrayList<ServiceStructureDetail> lDetails = ServiceStructureDetailsRepo.getSelectServiceStructureDetailsByServices(ids, cids);
		ArrayList<ServiceStructureDetail_DTO> serviceClassDetailsDTOs = lDetails != null ? this.getServiceStructureDetail_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}
	
	public ArrayList<ServiceStructureDetail_DTO> getSelectServiceStructureDetailsByParents(ArrayList<Long> ids)
    {
		ArrayList<ServiceStructureDetail> lDetails = ServiceStructureDetailsRepo.getSelectServiceClassesByParents(ids);
		ArrayList<ServiceStructureDetail_DTO> serviceClassDetailsDTOs = lDetails != null ? this.getServiceStructureDetail_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}
	
	public void delAllServiceStructureDetails() {
		ServiceStructureDetailsRepo.deleteAll();
	}

	public void delSelectServiceStructureDetails(ArrayList<ServiceStructureDetailPK> ids) 
	{
		if (ids != null) 
		{
			ServiceStructureDetailsRepo.deleteAllById(ids);
		}
	}
	
	
	public void delSelectServiceStructureDetailsByServices(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		if (ids != null)
		{
			ServiceStructureDetailsRepo.delSelectServiceStructureDetailsByServices(ids, cids);
		}
	}
	
	public void delSelectServiceStructureDetailsByParents(ArrayList<Long> pids) 
	{
		if (pids != null)
		{
			ServiceStructureDetailsRepo.delSelectServiceStructureDetailsByParents(pids);
		}
	}
	
	
	private ArrayList<ServiceStructureDetail_DTO> getServiceStructureDetail_DTOs(
			ArrayList<ServiceStructureDetail> lStructures) {
		ServiceStructureDetail_DTO lDTO = null;
		ArrayList<ServiceStructureDetail_DTO> lStructureDTOs = new ArrayList<ServiceStructureDetail_DTO>();
		for (int i = 0; i < lStructures.size(); i++) {
			lDTO = getServiceStructureDetail_DTO(lStructures.get(i));
			lStructureDTOs.add(lDTO);
		}
		return lStructureDTOs;
	}

	private ServiceStructureDetail_DTO getServiceStructureDetail_DTO(ServiceStructureDetail lStructure) {
		ServiceStructureDetail_DTO lDTO = new ServiceStructureDetail_DTO();
		lDTO.setParServiceClassSeqNo(lStructure.getId().getParServiceClassSeqNo());
		lDTO.setServiceClassSeqNo(lStructure.getId().getServiceClassSeqNo());
		lDTO.setParServiceSeqNo(lStructure.getId().getParServiceSeqNo());
		lDTO.setServiceSeqNo(lStructure.getId().getServiceSeqNo());
		return lDTO;
	}

	private ServiceStructureDetail setServiceStructureDetail(ServiceStructureDetail_DTO lDTO) 
	{
		ServiceStructureDetail lStructure = new ServiceStructureDetail();
		ServiceStructureDetailPK ServiceStructureDetailPK = new ServiceStructureDetailPK();
		ServiceStructureDetailPK.setParServiceClassSeqNo(lDTO.getParServiceClassSeqNo());
		ServiceStructureDetailPK.setServiceClassSeqNo(lDTO.getServiceClassSeqNo());
		ServiceStructureDetailPK.setParServiceSeqNo(lDTO.getParServiceSeqNo());
		ServiceStructureDetailPK.setServiceSeqNo(lDTO.getServiceSeqNo());
		lStructure.setId(ServiceStructureDetailPK);
		return lStructure;
	}
}