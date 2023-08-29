package service_location_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service_location_mgmt.model.dto.ServiceLocationMaster_DTO;
import service_location_mgmt.model.master.ServiceLocationMasterPK;
import service_location_mgmt.services.I_ServiceLocationMasterAdmin_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceLocationMasterAdminManagement")
public class ServiceLocationMasterAdmin_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ServiceLocationMaster_Controller.class);

	@Autowired
	private I_ServiceLocationMasterAdmin_Service serviceLocationMasterAdminServ;

	@PostMapping("/new")
	public ResponseEntity<ServiceLocationMaster_DTO> newResourc(@RequestBody ServiceLocationMaster_DTO serviceDTO) {
		ServiceLocationMaster_DTO serviceDTO2 = serviceLocationMasterAdminServ.newPartyLocationService(serviceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(serviceDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping("/updPartyLocationService")
	public void updPartyLocationService(@RequestBody ServiceLocationMaster_DTO serviceLocationMaster_DTO) {
		serviceLocationMasterAdminServ.updPartyLocationService(serviceLocationMaster_DTO);
		return;
	}

	@GetMapping(value = "/getAllPartyLocationServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceLocationMaster_DTO>> getAllPartyLocationServices() {
		ArrayList<ServiceLocationMaster_DTO> serviceDTOs = serviceLocationMasterAdminServ
				.getAllPartyLocationServices();
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServicesPartyLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceLocationMaster_DTO>> getSelectServicesPartyLocations(
			@RequestBody ArrayList<ServiceLocationMasterPK> lids) {
		ArrayList<ServiceLocationMaster_DTO> serviceDTOs = serviceLocationMasterAdminServ
				.getSelectServicesPartyLocations(lids);
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServicesByLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceLocationMaster_DTO>> getSelectServicesByLocations(
			@RequestBody ArrayList<Long> llids) {
		ArrayList<ServiceLocationMaster_DTO> serviceDTOs = serviceLocationMasterAdminServ
				.getSelectServicesByLocations(llids);
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServicesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceLocationMaster_DTO>> getSelectServicesByParties(
			@RequestBody ArrayList<Long> pids) {
		ArrayList<ServiceLocationMaster_DTO> serviceDTOs = serviceLocationMasterAdminServ
				.getSelectServicesByParties(pids);
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceLocationMaster_DTO>> getSelectServices(@RequestBody ArrayList<Long> rids) {
		ArrayList<ServiceLocationMaster_DTO> serviceDTOs = serviceLocationMasterAdminServ.getSelectServices(rids);
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}

	@DeleteMapping("/delSelectServicesByLocations")
	public void delSelectServicesByLocations(@RequestBody ArrayList<Long> lids) {
		serviceLocationMasterAdminServ.delSelectServicesByLocations(lids);
	}

	@DeleteMapping("/delSelectServicesByParties")
	public void delSelectServicesByParties(@RequestBody ArrayList<Long> pids) {
		serviceLocationMasterAdminServ.delSelectServicesByParties(pids);
	}

	@DeleteMapping("/delSelectServices")
	public void delSelectServices(@RequestBody ArrayList<Long> rids) {
		serviceLocationMasterAdminServ.delSelectServices(rids);
	}

	@DeleteMapping("/delAllservice")
	public void deleteAllservices() {
		serviceLocationMasterAdminServ.delAllPartyLocationService();
		return;
	}
}