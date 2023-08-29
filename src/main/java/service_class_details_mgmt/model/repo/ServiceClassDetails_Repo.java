package service_class_details_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import service_class_details_mgmt.model.master.ServiceClassDetail;
import service_class_details_mgmt.model.master.ServiceClassDetailPK;

@Repository("serviceClassDetailsRepo")
public interface ServiceClassDetails_Repo extends CrudRepository<ServiceClassDetail, ServiceClassDetailPK> 
{
	@Query(value = "SELECT * FROM SERVICE_CLASS_DETAILS a WHERE (a.service_class_seq_no in :ids) order by service_seq_no", nativeQuery = true)
	ArrayList<ServiceClassDetail> getSelectServicesForClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM SERVICE_CLASS_DETAILS a WHERE (a.service_class_seq_no in :ids)", nativeQuery = true)
	void delSelectServicesForClasses(@Param("ids") ArrayList<Long> ids);

}
