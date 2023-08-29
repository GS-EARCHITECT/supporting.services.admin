package service_class_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service_class_structure_mgmt.model.master.ServiceClassStructure;
import service_class_structure_mgmt.model.master.ServiceClassStructurePK;

@Repository("serviceClassStructureRepo")
public interface ServiceClassStructureRepo extends CrudRepository<ServiceClassStructure, ServiceClassStructurePK> 
{
	@Query(value = "SELECT * FROM SERVICE_CLASS_STRUCTURE a WHERE (a.service_class_seq_no in :ids and a.par_service_class_seq_no in :pids) order by service_class_seq_no", nativeQuery = true)
	ArrayList<ServiceClassStructure> getSelectServiceClassStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM SERVICE_CLASS_STRUCTURE a WHERE a.party_seq_no in :ids order by service_class_seq_no", nativeQuery = true)
	ArrayList<ServiceClassStructure> getSelectServiceClassStructuresByParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM SERVICE_CLASS_STRUCTURE a WHERE a.par_service_class_seq_no in :ids order by service_class_seq_no", nativeQuery = true)
	ArrayList<ServiceClassStructure> getSelectServiceClassStructuresByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM SERVICE_CLASS_STRUCTURE WHERE (a.service_class_seq_no in :ids and a.par_service_class_seq_no in :pids)", nativeQuery = true)
	void delSelectServiceClassStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM SERVICE_CLASS_STRUCTURE a WHERE a.par_service_class_seq_no in :ids", nativeQuery = true)
	void delSelectServiceClassStructuresByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM SERVICE_CLASS_STRUCTURE a WHERE a.party_seq_no in :ids", nativeQuery = true)
	void delSelectServiceClassStructuresByParties(@Param("ids") ArrayList<Long> ids);
}
