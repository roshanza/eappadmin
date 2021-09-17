package au.com.metlife.reference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.metlife.reference.entity.Industry;

public interface IndustryRepository extends JpaRepository<Industry, Long> {

	List<Industry> findByName(String name);	
	List<Industry> findByFundId(String fundCode);
	
	Industry findByIdAndFundId(Long id,String fundCode);

}
