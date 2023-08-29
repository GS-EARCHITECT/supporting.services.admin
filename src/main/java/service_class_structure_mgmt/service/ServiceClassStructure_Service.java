package service_class_structure_mgmt.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_class_details_mgmt.model.dto.ServiceClassDetail_DTO;
import service_class_details_mgmt.model.master.ServiceClassDetail;
import service_class_structure_mgmt.model.dto.ServiceClassStructure_DTO;
import service_class_structure_mgmt.model.master.ServiceClassStructure;
import service_class_structure_mgmt.model.master.ServiceClassStructurePK;
import service_class_structure_mgmt.model.repo.ServiceClassStructureRepo;

@Service("serviceClassStructureServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceClassStructure_Service implements I_ServiceClassStructure_Service 
{

	@Autowired
	private ServiceClassStructureRepo serviceClassStructureRepo;

	public ServiceClassStructure_DTO newServiceClassStructure(ServiceClassStructure_DTO lStructure) 
	{
		ServiceClassStructure_DTO serviceClassStructureDTO = null;
		ServiceClassStructurePK serviceClassStructurePK = new ServiceClassStructurePK();
		serviceClassStructurePK.setParServiceClassSeqNo(lStructure.getParServiceClassSeqNo());
		serviceClassStructurePK.setServiceClassSeqNo(lStructure.getServiceClassSeqNo());
		serviceClassStructurePK.setPartySeqNo(lStructure.getPartySeqNo());
		
		if (!serviceClassStructureRepo.existsById(serviceClassStructurePK)) 
		{			
			serviceClassStructureDTO = getServiceClassStructure_DTO(
			serviceClassStructureRepo.save(this.setServiceClassStructure(lStructure)));
		}
		return serviceClassStructureDTO;
	}
	
	public void updServiceClassStructure(ServiceClassStructure_DTO lStructure) 
	{
		ServiceClassStructurePK serviceClassStructurePK = new ServiceClassStructurePK();
		serviceClassStructurePK.setParServiceClassSeqNo(lStructure.getParServiceClassSeqNo());
		serviceClassStructurePK.setServiceClassSeqNo(lStructure.getServiceClassSeqNo());
		serviceClassStructurePK.setPartySeqNo(lStructure.getPartySeqNo());

		if (serviceClassStructureRepo.existsById(serviceClassStructurePK)) 
		{
			serviceClassStructureRepo.save(this.setServiceClassStructure(lStructure));
		}
		return;
	}

	public ArrayList<ServiceClassStructure_DTO> getSelectServiceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids)
    {
		ArrayList<ServiceClassStructure> lDetails = serviceClassStructureRepo.getSelectServiceClassStructures(ids, pids);
		ArrayList<ServiceClassStructure_DTO> serviceClassDetailsDTOs = lDetails != null ? this.getServiceClassStructure_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}
	
	public ArrayList<ServiceClassStructure_DTO> getAllServiceClassStructures()
    {
		ArrayList<ServiceClassStructure> lDetails = (ArrayList<ServiceClassStructure>) serviceClassStructureRepo.findAll();
		ArrayList<ServiceClassStructure_DTO> serviceClassDetailsDTOs = lDetails != null ? this.getServiceClassStructure_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}

	
	public ArrayList<ServiceClassStructure_DTO> getSelectServiceClassStructuresByParties( ArrayList<Long> ids)
    {
		ArrayList<ServiceClassStructure> lDetails = serviceClassStructureRepo.getSelectServiceClassStructuresByParties(ids);
		ArrayList<ServiceClassStructure_DTO> serviceClassDetailsDTOs = lDetails != null ? this.getServiceClassStructure_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}
	
	public ArrayList<ServiceClassStructure_DTO> getSelectServiceClassStructuresByParents(ArrayList<Long> ids)
    {
		ArrayList<ServiceClassStructure> lDetails = serviceClassStructureRepo.getSelectServiceClassStructuresByParents(ids);
		ArrayList<ServiceClassStructure_DTO> serviceClassDetailsDTOs = lDetails != null ? this.getServiceClassStructure_DTOs(lDetails) : null;
		return serviceClassDetailsDTOs;
	}
	
	public void delAllServiceClassStructures() {
		serviceClassStructureRepo.deleteAll();
	}

	public void delSelectServiceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids) 
	{
		if (ids != null && pids != null) {
			serviceClassStructureRepo.delSelectServiceClassStructures(ids, pids);
		}
	}
	
	public void delSelectServiceClassStructuresByParties(ArrayList<Long> ids) 
	{
		if (ids != null)
		{
			serviceClassStructureRepo.delSelectServiceClassStructuresByParties(ids);
		}
	}
	
	public void delSelectServiceClassStructuresByParents(ArrayList<Long> ids) 
	{
		if (ids != null)
		{
			serviceClassStructureRepo.delSelectServiceClassStructuresByParents(ids);
		}
	}

	private ArrayList<ServiceClassStructure_DTO> getServiceClassStructure_DTOs(
			ArrayList<ServiceClassStructure> lStructures) {
		ServiceClassStructure_DTO lDTO = null;
		ArrayList<ServiceClassStructure_DTO> lStructureDTOs = new ArrayList<ServiceClassStructure_DTO>();
		for (int i = 0; i < lStructures.size(); i++) {
			lDTO = getServiceClassStructure_DTO(lStructures.get(i));
			lStructureDTOs.add(lDTO);
		}
		return lStructureDTOs;
	}

	private ServiceClassStructure_DTO getServiceClassStructure_DTO(ServiceClassStructure lStructure) {
		ServiceClassStructure_DTO lDTO = new ServiceClassStructure_DTO();
		lDTO.setParServiceClassSeqNo(lStructure.getId().getParServiceClassSeqNo());
		lDTO.setServiceClassSeqNo(lStructure.getId().getServiceClassSeqNo());
		lDTO.setPartySeqNo(lStructure.getId().getPartySeqNo());
		return lDTO;
	}

	private ServiceClassStructure setServiceClassStructure(ServiceClassStructure_DTO lDTO) {
		ServiceClassStructure lStructure = new ServiceClassStructure();
		ServiceClassStructurePK serviceClassStructurePK = new ServiceClassStructurePK();
		serviceClassStructurePK.setParServiceClassSeqNo(lDTO.getParServiceClassSeqNo());
		serviceClassStructurePK.setServiceClassSeqNo(lDTO.getServiceClassSeqNo());
		serviceClassStructurePK.setPartySeqNo(lDTO.getPartySeqNo());
		lStructure.setId(serviceClassStructurePK);
		return lStructure;
	}
}