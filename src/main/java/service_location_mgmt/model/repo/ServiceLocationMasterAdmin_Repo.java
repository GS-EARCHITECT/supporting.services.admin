package service_location_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service_location_mgmt.model.master.ServiceLocationMaster;
import service_location_mgmt.model.master.ServiceLocationMasterPK;

@Repository("serviceLocationMasterAdminRepo")
public interface ServiceLocationMasterAdmin_Repo extends JpaRepository<ServiceLocationMaster, ServiceLocationMasterPK> 
{		
	
	@Query(value = "select * FROM SERVICE_LOCATION_MASTER a WHERE a.location_seq_no in :lids order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceLocationMaster> getSelectServicesByLocations(@Param("lids") ArrayList<Long> lidss);

	@Query(value = "select * FROM SERVICE_LOCATION_MASTER a WHERE a.party_seq_no in :lids order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceLocationMaster> getSelectServicesByParties(@Param("pids") ArrayList<Long> pidss);
	
	@Query(value = "select * FROM SERVICE_LOCATION_MASTER a WHERE a.service_seq_no in :rids order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceLocationMaster> getSelectServices(@Param("rids") ArrayList<Long> ridss);

	@Query(value = "delete FROM SERVICE_LOCATION_MASTER a WHERE a.location_seq_no in :lids order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceLocationMaster> delSelectServicesByLocations(@Param("lids") ArrayList<Long> lidss);

	@Query(value = "delete FROM SERVICE_LOCATION_MASTER a WHERE a.party_seq_no in :lids order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceLocationMaster> delSelectServicesByParties(@Param("pids") ArrayList<Long> pidss);
	
	@Query(value = "delete FROM SERVICE_LOCATION_MASTER a WHERE a.service_seq_no in :rids order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceLocationMaster> delSelectServices(@Param("rids") ArrayList<Long> ridss);

}
