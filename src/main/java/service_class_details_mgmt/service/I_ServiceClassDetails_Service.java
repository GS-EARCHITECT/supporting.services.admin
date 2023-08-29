package service_class_details_mgmt.service;

import java.util.ArrayList;
import service_class_details_mgmt.model.dto.ServiceClassDetail_DTO;
import service_class_details_mgmt.model.master.ServiceClassDetailPK;

public interface I_ServiceClassDetails_Service
{
    abstract public ServiceClassDetail_DTO newServiceClassDetail(ServiceClassDetail_DTO serviceClassDetailsDTO);
    abstract public ArrayList<ServiceClassDetail_DTO> getAllServiceClassDetails();
    abstract public ArrayList<ServiceClassDetail_DTO> getSelectServiceClassDetails(ArrayList<ServiceClassDetailPK> ids);
    abstract public ArrayList<ServiceClassDetail_DTO> getSelectServicesForClasses(ArrayList<Long> ids);
    abstract public void updServiceClassDetail(ServiceClassDetail_DTO serviceClassDetailsDTO);
    abstract public void delAllServiceClassDetails();
    abstract public void delSelectServiceClassDetails(ArrayList<ServiceClassDetailPK> ids);
    abstract public void delSelectServicesForClasses(ArrayList<Long> ids);    
}