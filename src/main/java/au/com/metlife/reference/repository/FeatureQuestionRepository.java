package au.com.metlife.reference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.metlife.reference.entity.Feature;
import au.com.metlife.reference.entity.FeatureQuestion;

public interface FeatureQuestionRepository extends JpaRepository<FeatureQuestion, Long> {
	
	List<FeatureQuestion> findByFeatureId(String featureId);	 

}
