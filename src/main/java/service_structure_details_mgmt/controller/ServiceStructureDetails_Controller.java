package service_structure_details_mgmt.controller;

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
import service_structure_details_mgmt.model.dto.ServiceStructureDetail_DTO;
import service_structure_details_mgmt.model.master.ServiceStructureDetailPK;
import service_structure_details_mgmt.service.I_ServiceStructureDetails_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceStructureDetailsManagement")
public class ServiceStructureDetails_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ServiceStructureDetail_Controller.class);

	@Autowired
	private I_ServiceStructureDetails_Service serviceStructureDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<ServiceStructureDetail_DTO> newServiceClass(@RequestBody ServiceStructureDetail_DTO serviceClassDTO) {
		ServiceStructureDetail_DTO serviceClassDTO2 = serviceStructureDetailsServ.newServiceStructureDetail(serviceClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(serviceClassDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllServiceStructureDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceStructureDetail_DTO>> getAllServiceStructureDetails() {
		ArrayList<ServiceStructureDetail_DTO> serviceClassDTOs = serviceStructureDetailsServ.getAllServiceStructureDetails();
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServiceStructureDetails", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceStructureDetail_DTO>> getSelectServiceStructureDetails(@RequestBody ArrayList<ServiceStructureDetailPK> ids) 
	{
		ArrayList<ServiceStructureDetail_DTO> serviceClassDTOs = serviceStructureDetailsServ.getSelectServiceStructureDetails(ids);		
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServiceStructureDetailsByParents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceStructureDetail_DTO>> getSelectServiceStructureDetailsByParents(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ServiceStructureDetail_DTO> serviceClassDTOs = serviceStructureDetailsServ.getSelectServiceStructureDetailsByParents(ids);		
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServiceStructureDetailsByServices", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceStructureDetail_DTO>> getSelectServiceStructureDetailsByServices(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) 
	{
		ArrayList<ServiceStructureDetail_DTO> serviceClassDTOs = serviceStructureDetailsServ.getSelectServiceStructureDetailsByServices(ids, cids);		
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updServiceStructureDetail")
	public void updateServiceStructureDetail(@RequestBody ServiceStructureDetail_DTO serviceStructureDetailDTO) 
	{
		serviceStructureDetailsServ.updServiceStructureDetail(serviceStructureDetailDTO);	
		return;
	}
	
	@DeleteMapping("/delSelectServiceStructureDetails")
	public void deleteSelectserviceStructureDetails(@RequestBody ArrayList<ServiceStructureDetailPK> ids)
	{
		serviceStructureDetailsServ.delSelectServiceStructureDetails(ids);
		return;
	}
	
	@DeleteMapping("/delSelectServiceStructureDetailsByServices")
	public void deleteSelectserviceStructureDetailsByServices(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		serviceStructureDetailsServ.delSelectServiceStructureDetailsByServices(ids, pids);
		return;
	}
	
	@DeleteMapping("/delSelectServiceStructureDetailsByParents")
	public void deleteSelectserviceStructureDetailsByParents(@RequestBody ArrayList<Long> ids)
	{
		serviceStructureDetailsServ.delSelectServiceStructureDetailsByParents(ids);
		return;
	}

	@DeleteMapping("/delAllserviceClass")
	public void deleteAllserviceClasss() {
		serviceStructureDetailsServ.delAllServiceStructureDetails();;
		return;
	}
	}