package service_party_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service_party_mgmt.model.master.ServicePartyMaster;

@Repository("servicePartyMasterAdminRepo")
public interface ServicePartyMasterAdmin_Repo extends JpaRepository<ServicePartyMaster, Long> 
{
	@Query(value = "SELECT * FROM SERVICE_DETAILS a WHERE upper(trim(a.service_id)) in :ids order by service_seq_no", nativeQuery = true)
	ArrayList<ServicePartyMaster> getSelectServicesByServiceIds(@Param("ids") ArrayList<String> ids);

	@Query(value = "SELECT * FROM SERVICE_DETAILS a WHERE a.oem_seq_no in :ids order by service_seq_no", nativeQuery = true)
	ArrayList<ServicePartyMaster> getSelectServicesByOEMs(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM SERVICE_PARTY_MASTER a WHERE a.party_seq_no in :ids order by service_seq_no", nativeQuery = true)
	ArrayList<ServicePartyMaster> getSelectServicesByParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM SERVICE_DETAILS a WHERE a.unit_price>=:fr and a.unit_price<=:to order by service_seq_no", nativeQuery = true)
	ArrayList<ServicePartyMaster> getSelectServicesByPriceRange(@Param("fr") Float fr, @Param("to") Float to);
	
	@Query(value = "DELETE FROM SERVICE_DETAILS WHERE a.service_seq_no in :ids", nativeQuery = true)
	void delSelectServices(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM SERVICE_PARTY_MASTER a WHERE a.party_seq_no in :ids", nativeQuery = true)
	void delSelectServiceByParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "deleet FROM SERVICE_DETAILS a WHERE a.oem_seq_no in :ids", nativeQuery = true)
	void delSelectServicesByOEMs(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM SERVICE_DETAILS a WHERE a.unit_price>=:fr and a.unit_price<=:to ", nativeQuery = true)
	void delSelectServicesByPriceRange(@Param("fr") Float fr, @Param("to") Float to);

}
