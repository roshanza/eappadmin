package au.com.metlife.reference.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.metlife.reference.dto.QuestionDTO;
import au.com.metlife.reference.entity.Question;
import au.com.metlife.reference.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping(path = "api")
public class QuestionController {

	// private static final String template = "Hello, %s!";
	@Autowired
	QuestionService qService;

	
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@GetMapping(value ="/admin/eligibilityQuestion",produces = "application/vnd.aumet.app-v1+json")
	public ResponseEntity<?> test() {
		
		
		List<QuestionDTO> qList = qService.getQuestions();
		return new ResponseEntity<List<QuestionDTO>>(qList, HttpStatus.OK);

	}
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })	
	@PostMapping(value ="/admin/eligibilityQuestion",produces = "application/vnd.aumet.app-v1+json")
	public QuestionDTO test(@Valid @RequestBody QuestionDTO q) {
		
		return qService.createQuestion(q);

	}


}
