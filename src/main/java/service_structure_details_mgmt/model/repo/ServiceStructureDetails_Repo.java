package service_structure_details_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import service_structure_details_mgmt.model.master.ServiceStructureDetail;
import service_structure_details_mgmt.model.master.ServiceStructureDetailPK;

@Repository("serviceStructureDetailsRepo")
public interface ServiceStructureDetails_Repo extends JpaRepository<ServiceStructureDetail, ServiceStructureDetailPK> 
{
	@Query(value = "SELECT * FROM SERVICE_STRUCTURE_DETAILS a WHERE (a.service_seq_no in :ids and a.service_class_seq_no in :cids) order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceStructureDetail> getSelectServiceStructureDetailsByServices(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);

	@Query(value = "SELECT * FROM SERVICE_STRUCTURE_DETAILS a WHERE a.par_service_class_seq_no in :pids order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceStructureDetail> getSelectServiceClassesByParents(@Param("pids") ArrayList<Long> pids);
	
	@Query(value = "delete FROM SERVICE_STRUCTURE_DETAILS a WHERE (a.service_seq_no in :ids and a.service_class_seq_no in :cids)", nativeQuery = true)
	void delSelectServiceStructureDetailsByServices(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);

	@Query(value = "delete FROM SERVICE_STRUCTURE_DETAILS a WHERE a.par_service_class_seq_no in :pids", nativeQuery = true)
	void delSelectServiceStructureDetailsByParents(@Param("pids") ArrayList<Long> pids);
}
