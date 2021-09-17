package au.com.metlife.reference.service;

import java.util.List;

import au.com.metlife.reference.dto.QuestionDTO;

public interface QuestionService {
	
	QuestionDTO createQuestion(QuestionDTO qDTO);
	List<QuestionDTO> getQuestions();
	List<QuestionDTO> getQuestionsForFeature(Long featureId);
	List<QuestionDTO> getQuestionsForFeature(Long featureId,String fundCode);

}
