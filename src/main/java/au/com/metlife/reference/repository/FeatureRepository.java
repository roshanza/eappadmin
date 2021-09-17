package au.com.metlife.reference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.metlife.reference.entity.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
	
	List<Feature> findByFundId(String fundCode);	 
	Feature findByIdAndFundId(Long id,String fundCode);

	
}
