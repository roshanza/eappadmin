package au.com.metlife.reference.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import au.com.metlife.reference.dto.QuestionDTO;
import au.com.metlife.reference.entity.Answer;
import au.com.metlife.reference.entity.Question;
import au.com.metlife.reference.repository.AnswerRepository;
import au.com.metlife.reference.repository.FeatureRepository;
import au.com.metlife.reference.repository.QuestionRepository;

@Service("qService")
public class QuestionServiceImpl implements QuestionService{

	@Autowired
    private QuestionRepository qRepository;
	
	@Autowired
    private AnswerRepository aRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Autowired
    private FeatureRepository feaRepository;
	
	
	@Override
	public QuestionDTO createQuestion(QuestionDTO qDTO) {
		// TODO Auto-generated method stub
		Question q=modelMapper.map(qDTO, Question.class);
		createQuestionIntoDB(q);		
		return modelMapper.map(q, QuestionDTO.class);
	}
	
	private Question createQuestionIntoDB(Question q) {
		// TODO Auto-generated method stub
		qRepository.saveAndFlush(q);
		
		List<Answer> ans =q.getPossibleAnswers();
		
		if(ans!=null && ans.size()>0) {
			for (Answer a : ans){
				a.setQuestion(q);
				aRepository.saveAndFlush(a);
				
				List<Question> cQList=a.getChildQuestions();				
				if (cQList!=null && cQList.size()>0) {
					for (Question cq : cQList){						
						cq.setChildQuestion(a);					
						createQuestionIntoDB(cq);
						
					}	
				}
				
			}	
			
			
		}
		
		
		
		return q;
	}

	@Override
	public List<QuestionDTO> getQuestions() {
		// TODO Auto-generated method stub
		
		
		return qRepository.findAll().stream().map(que -> modelMapper.map(que, QuestionDTO.class)) 	
				.collect(Collectors.toList());
	}

	@Override
	public List<QuestionDTO> getQuestionsForFeature(Long featureId) {
		// TODO Auto-generated method stub
		
		return qRepository.findByFeatureId(
				featureId).stream().map(que -> modelMapper.map(que, QuestionDTO.class)) 	
				.collect(Collectors.toList());
		
		
	}

	@Override
	@Cacheable("featurequestions")
	public List<QuestionDTO> getQuestionsForFeature(Long featureId, String fundCode) {
		// TODO Auto-generated method stub
				
		if(feaRepository.findByIdAndFundId(featureId, fundCode)!=null) {
			return qRepository.findByFeatureId(
					featureId).stream().map(que -> modelMapper.map(que, QuestionDTO.class)) 	
					.collect(Collectors.toList());
		}
		else {
			throw new ResponseStatusException(NOT_FOUND, String.format("Incorrect featureId: ", featureId));
		}
			
		
	}

	
	
	

}
