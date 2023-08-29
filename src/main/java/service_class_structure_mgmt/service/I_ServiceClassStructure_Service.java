package service_class_structure_mgmt.service;

import java.util.ArrayList;

import service_class_structure_mgmt.model.dto.ServiceClassStructure_DTO;

public interface I_ServiceClassStructure_Service
{
    public ServiceClassStructure_DTO newServiceClassStructure(ServiceClassStructure_DTO serviceClassStructureDTO);
    public ArrayList<ServiceClassStructure_DTO> getAllServiceClassStructures();    
    public ArrayList<ServiceClassStructure_DTO> getSelectServiceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids);
    public ArrayList<ServiceClassStructure_DTO> getSelectServiceClassStructuresByParties( ArrayList<Long> ids);
    public ArrayList<ServiceClassStructure_DTO> getSelectServiceClassStructuresByParents(ArrayList<Long> ids);
	public void updServiceClassStructure(ServiceClassStructure_DTO serviceClassStructureDTO);
    public void delAllServiceClassStructures();
    public void delSelectServiceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids);    
    public void delSelectServiceClassStructuresByParents(ArrayList<Long> ids);
    public void delSelectServiceClassStructuresByParties( ArrayList<Long> ids);
}