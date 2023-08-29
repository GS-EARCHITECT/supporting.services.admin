package service_class_structure_mgmt.controller;

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
import service_class_structure_mgmt.model.dto.ServiceClassStructure_DTO;
import service_class_structure_mgmt.service.I_ServiceClassStructure_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceClassStructureManagement")
public class ServiceClassStructure_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ServiceClassStructure_Controller.class);

	@Autowired
	private I_ServiceClassStructure_Service serviceClassStructureServ;
	
	@PostMapping("/new")
	public ResponseEntity<ServiceClassStructure_DTO> newServiceClass(@RequestBody ServiceClassStructure_DTO serviceClassDTO) {
		ServiceClassStructure_DTO serviceClassDTO2 = serviceClassStructureServ.newServiceClassStructure(serviceClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(serviceClassDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllServiceClassStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassStructure_DTO>> getAllServiceClassStructures() {
		ArrayList<ServiceClassStructure_DTO> serviceClassDTOs = serviceClassStructureServ.getAllServiceClassStructures();
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServiceClassStructures", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassStructure_DTO>> getSelectServiceClassStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids) 
	{
		ArrayList<ServiceClassStructure_DTO> serviceClassDTOs = serviceClassStructureServ.getSelectServiceClassStructures(ids, pids);		
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServiceClassStructuresByParents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassStructure_DTO>> getSelectServiceClassStructuresByParents(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ServiceClassStructure_DTO> serviceClassDTOs = serviceClassStructureServ.getSelectServiceClassStructuresByParents(ids);		
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServiceClassStructuresByParties", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassStructure_DTO>> getSelectServiceClassStructuresByParties(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ServiceClassStructure_DTO> serviceClassDTOs = serviceClassStructureServ.getSelectServiceClassStructuresByParties(ids);		
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updServiceClassStructure")
	public void updateServiceClassStructure(@RequestBody ServiceClassStructure_DTO serviceClassStructureDTO) 
	{
		serviceClassStructureServ.updServiceClassStructure(serviceClassStructureDTO);	
		return;
	}

	
	@DeleteMapping("/delSelectServiceClassStrucures")
	public void deleteSelectserviceClassStrucures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		serviceClassStructureServ.delSelectServiceClassStructures(ids, pids);
		return;
	}
	
	@DeleteMapping("/delSelectServiceClassStrucuresByParties")
	public void deleteSelectserviceClassStrucuresByParties(@RequestBody ArrayList<Long> ids)
	{
		serviceClassStructureServ.delSelectServiceClassStructuresByParties(ids);
		return;
	}
	
	@DeleteMapping("/delSelectServiceClassStrucuresByParents")
	public void deleteSelectserviceClassStrucuresByParents(@RequestBody ArrayList<Long> ids)
	{
		serviceClassStructureServ.delSelectServiceClassStructuresByParents(ids);
		return;
	}

	@DeleteMapping("/delAllserviceClass")
	public void deleteAllserviceClasss() {
		serviceClassStructureServ.delAllServiceClassStructures();;
		return;
	}
	}