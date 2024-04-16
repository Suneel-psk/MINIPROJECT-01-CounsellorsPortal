package in.psk.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.psk.entities.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry,Integer>{

	@Query(value="select count(*) from enquiry where counsellor_id=:id",nativeQuery=true)
	public Long getEnquirys(Integer id);
	@Query(value="select count(*) from enquiry where counsellor_id=:id and status=:status",nativeQuery=true)
	public Long getEnquirys(Integer id,String status);
}
