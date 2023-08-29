package service_party_mgmt.service;

import java.util.ArrayList;

import service_party_mgmt.model.dto.ServicePartyMaster_DTO;

public interface I_ServicePartyMasterAdmin_Service
{
    public ServicePartyMaster_DTO newServicePartyMaster(ServicePartyMaster_DTO serviceCategoryMasterDTO);
    public void updServicePartyMaster(ServicePartyMaster_DTO ServicePartyMaster_DTO);
    public ArrayList<ServicePartyMaster_DTO> getAllServicePartyMasters();   
    public ArrayList<ServicePartyMaster_DTO> getSelectServices(ArrayList<Long> ids);
    public ArrayList<ServicePartyMaster_DTO> getSelectServicesByServiceIds( ArrayList<String> ids);
    public ArrayList<ServicePartyMaster_DTO> getSelectServicesByOEMs( ArrayList<Long> ids);
	public ArrayList<ServicePartyMaster_DTO> getSelectServiceByParties( ArrayList<Long> ids);
	public ArrayList<ServicePartyMaster_DTO> getSelectServicesByPriceRange( Float fr, Float to);    
    public void delAllServicePartyMasters();    
    public void delSelectServices(ArrayList<Long> ids);
    public void delSelectServiceByParties( ArrayList<Long> ids);
    public void delSelectServicesByOEMs( ArrayList<Long> ids);    
    public void delSelectServicesByPriceRange( Float fr, Float to);
}