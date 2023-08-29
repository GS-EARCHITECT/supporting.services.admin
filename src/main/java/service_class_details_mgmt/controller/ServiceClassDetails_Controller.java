package service_class_details_mgmt.controller;

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

import service_class_details_mgmt.model.dto.ServiceClassDetail_DTO;
import service_class_details_mgmt.model.master.ServiceClassDetailPK;
import service_class_details_mgmt.service.I_ServiceClassDetails_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceClassDetailsManagement")
public class ServiceClassDetails_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ServiceClassDetails_Controller.class);

	@Autowired
	private I_ServiceClassDetails_Service serviceClassDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<ServiceClassDetail_DTO> newserviceClass(@RequestBody ServiceClassDetail_DTO serviceClassDTO) {
		ServiceClassDetail_DTO serviceClassDTO2 = serviceClassDetailsServ.newServiceClassDetail(serviceClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(serviceClassDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllServiceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassDetail_DTO>> getAllServiceClassDetails() {
		ArrayList<ServiceClassDetail_DTO> serviceClassDTOs = serviceClassDetailsServ.getAllServiceClassDetails();
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServiceClasses", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassDetail_DTO>> getSelectServiceClassDetails(@RequestBody ArrayList<ServiceClassDetailPK> ids) 
	{
		ArrayList<ServiceClassDetail_DTO> serviceClassDTOs = serviceClassDetailsServ.getSelectServiceClassDetails(ids);		
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServicesForClasses", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassDetail_DTO>> getSelectServicesForClasses(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ServiceClassDetail_DTO> serviceClassDTOs = serviceClassDetailsServ.getSelectServicesForClasses(ids);		
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updServiceClassDetail")
	public void updateServiceClassDetail(@RequestBody ServiceClassDetail_DTO serviceClassDetailsDTO) 
	{
		serviceClassDetailsServ.updServiceClassDetail(serviceClassDetailsDTO);	
		return;
	}

	
	@DeleteMapping("/delSelectServiceClassDetails")
	public void deleteSelectserviceClassDetails(@RequestBody ArrayList<ServiceClassDetailPK> ids)
	{
		serviceClassDetailsServ.delSelectServiceClassDetails(ids);
		return;
	}
	
	@DeleteMapping("/delAllServiceClassDetails")
	public void deleteAllserviceClassDetails() {
		serviceClassDetailsServ.delAllServiceClassDetails();;
		return;
	}
	}