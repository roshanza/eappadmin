package au.com.metlife.reference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.metlife.reference.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query(
			  value = "SELECT q.* FROM EAPPOCC.Question q join EAPPOCC.feature_question fq on fq.question_id=q.id WHERE fq.feature_id = ?1", 
			  nativeQuery = true)
	List<Question> findByFeatureId(Long featureId);
		
	

}
