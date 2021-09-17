package au.com.metlife.reference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.metlife.reference.entity.Answer;
import au.com.metlife.reference.repository.AnswerRepository;

@Service("aService")
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
    private AnswerRepository aRepository;
	
	@Override
	public Answer createIndustry(Answer ans) {
		// TODO Auto-generated method stub
		return aRepository.save(ans);
	}
	
	

}
