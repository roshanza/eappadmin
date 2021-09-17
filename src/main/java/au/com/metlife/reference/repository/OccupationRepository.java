package au.com.metlife.reference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.metlife.reference.entity.Occupation;

public interface OccupationRepository extends JpaRepository<Occupation, Long> {

	
	List<Occupation> findByIndustryId(Long industryId);	 
	

}
