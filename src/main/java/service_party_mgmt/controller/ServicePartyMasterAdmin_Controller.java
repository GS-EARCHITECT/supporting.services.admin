package service_party_mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service_party_mgmt.model.dto.ServicePartyMaster_DTO;
import service_party_mgmt.service.I_ServicePartyMasterAdmin_Service;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/servicePartyAdminManagement")
public class ServicePartyMasterAdmin_Controller
{

//	private static final Logger logger = LoggerFactory.getLogger(ServiceMaster_Controller.class);

	@Autowired
	private I_ServicePartyMasterAdmin_Service servicePartyMasterAdminServ;

	@PostMapping("/new")
	public ResponseEntity<ServicePartyMaster_DTO> newPartyService(@RequestBody ServicePartyMaster_DTO servicePartyMasterDTO) 
	{
		ServicePartyMaster_DTO servicePartyMaster_DTO2 = servicePartyMasterAdminServ.newServicePartyMaster(servicePartyMasterDTO);
		HttpHeaders httpHeaders = new HttpHeaders();		
		return new ResponseEntity<>(servicePartyMaster_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping("/updServicePartyMaster")
	public void updServicePartyMaster(@RequestBody ServicePartyMaster_DTO serviceDTO) 
	{
			servicePartyMasterAdminServ.updServicePartyMaster(serviceDTO);;	
		return;
	}
	
	@GetMapping(value = "/getAllServicePartyMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServicePartyMaster_DTO>> getAllServiceMasters() {
		ArrayList<ServicePartyMaster_DTO> serviceDTOs = servicePartyMasterAdminServ.getAllServicePartyMasters();
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServices", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServicePartyMaster_DTO>> getSelectServiceMasters(@RequestBody ArrayList<Long> serviceSeqNos) {
		ArrayList<ServicePartyMaster_DTO> serviceDTOs = servicePartyMasterAdminServ.getSelectServices(serviceSeqNos);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServicesByServiceIds", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServicePartyMaster_DTO>> getSelectServicesByServiceIds(@RequestBody ArrayList<String> ids) 
	{
		ArrayList<ServicePartyMaster_DTO> serviceDTOs = servicePartyMasterAdminServ.getSelectServicesByServiceIds(ids);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServicesByOEMs", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServicePartyMaster_DTO>> getSelectServiceMastersByOEMs(@RequestBody ArrayList<Long> cos) {
		ArrayList<ServicePartyMaster_DTO> serviceDTOs = servicePartyMasterAdminServ.getSelectServicesByOEMs(cos);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServicesByParties", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServicePartyMaster_DTO>> getSelectServiceMastersByParties(@RequestBody ArrayList<Long> cos) {
		ArrayList<ServicePartyMaster_DTO> serviceDTOs = servicePartyMasterAdminServ.getSelectServiceByParties(cos);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServicesByPriceRange/{fr}/{to}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServicePartyMaster_DTO>> getSelectServiceMastersByPriceRange(@PathVariable Float fr, @PathVariable Float to) {
		ArrayList<ServicePartyMaster_DTO> serviceDTOs = servicePartyMasterAdminServ.getSelectServicesByPriceRange(fr, to);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}
	
	@DeleteMapping("/delAllServicePartyMasters")
	public void deleteAlldelAllServicePartyMasters() {
		servicePartyMasterAdminServ.delAllServicePartyMasters();
		return;
	}
	
	@DeleteMapping("/delSelectServices")
	public void delSelectServices(@RequestBody ArrayList<Long> serviceSeqNoList) {
		servicePartyMasterAdminServ.delSelectServices(serviceSeqNoList);;
		return;
	}

	@DeleteMapping("/delSelectServiceByParties")
	public void delSelectServiceByParties(@RequestBody ArrayList<Long> serviceSeqNoList) {
		servicePartyMasterAdminServ.delSelectServiceByParties(serviceSeqNoList);;
		return;
	}

	@DeleteMapping("/delSelectServicesByOEMs")
	public void delSelectServicesByOEMs(@RequestBody ArrayList<Long> serviceSeqNoList) {
		servicePartyMasterAdminServ.delSelectServicesByOEMs(serviceSeqNoList);;
		return;
	}
	
	@DeleteMapping("/deltSelectServicesByPriceRange/{fr}/{to}")
	public void delSelectServiceMastersByPriceRange(@PathVariable Float fr, @PathVariable Float to) 
	{
		servicePartyMasterAdminServ.delSelectServicesByPriceRange(fr, to);
		return;
		
	}
	
}
	