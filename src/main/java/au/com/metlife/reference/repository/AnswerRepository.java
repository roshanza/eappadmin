package au.com.metlife.reference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.metlife.reference.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
}
