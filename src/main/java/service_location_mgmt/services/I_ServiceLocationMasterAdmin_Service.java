package service_location_mgmt.services;

import java.util.ArrayList;

import service_location_mgmt.model.dto.ServiceLocationMaster_DTO;
import service_location_mgmt.model.master.ServiceLocationMasterPK;

public interface I_ServiceLocationMasterAdmin_Service
{
	public ServiceLocationMaster_DTO newPartyLocationService(ServiceLocationMaster_DTO serviceLocationMaster_DTO);
	public void updPartyLocationService(ServiceLocationMaster_DTO serviceLocationMaster_DTO);
    public ArrayList<ServiceLocationMaster_DTO> getAllPartyLocationServices();        
    public ArrayList<ServiceLocationMaster_DTO> getSelectServicesPartyLocations(ArrayList<ServiceLocationMasterPK> serviceLocationMasterPKs);
    public ArrayList<ServiceLocationMaster_DTO> getSelectServicesByLocations( ArrayList<Long> lidss);
    public ArrayList<ServiceLocationMaster_DTO> getSelectServicesByParties(ArrayList<Long> pids);
    public ArrayList<ServiceLocationMaster_DTO> getSelectServices(ArrayList<Long> ridss);
    public void delSelectServicesByLocations( ArrayList<Long> lidss);
    public void delSelectServicesByParties( ArrayList<Long> pidss);
    public void delSelectServices( ArrayList<Long> ridss);
    public void delAllPartyLocationService();
}