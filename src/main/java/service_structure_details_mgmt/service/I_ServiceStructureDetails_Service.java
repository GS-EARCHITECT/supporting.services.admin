package service_structure_details_mgmt.service;

import java.util.ArrayList;
import service_structure_details_mgmt.model.dto.ServiceStructureDetail_DTO;
import service_structure_details_mgmt.model.master.ServiceStructureDetailPK;

public interface I_ServiceStructureDetails_Service
{
    public ServiceStructureDetail_DTO newServiceStructureDetail(ServiceStructureDetail_DTO serviceStructureDetailDTO);
    public ArrayList<ServiceStructureDetail_DTO> getAllServiceStructureDetails();    
    public ArrayList<ServiceStructureDetail_DTO> getSelectServiceStructureDetails(ArrayList<ServiceStructureDetailPK> ids);
    public ArrayList<ServiceStructureDetail_DTO> getSelectServiceStructureDetailsByServices(ArrayList<Long> ids, ArrayList<Long> cids);
    public ArrayList<ServiceStructureDetail_DTO> getSelectServiceStructureDetailsByParents(ArrayList<Long> ids);
	public void updServiceStructureDetail(ServiceStructureDetail_DTO serviceStructureDetailDTO);
    public void delAllServiceStructureDetails();
    public void delSelectServiceStructureDetails(ArrayList<ServiceStructureDetailPK> ids);    
    public void delSelectServiceStructureDetailsByParents(ArrayList<Long> pids);    
    public void delSelectServiceStructureDetailsByServices(ArrayList<Long> ids, ArrayList<Long> cids);    
}