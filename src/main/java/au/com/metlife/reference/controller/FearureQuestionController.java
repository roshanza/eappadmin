package au.com.metlife.reference.controller;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import au.com.metlife.reference.dto.QuestionDTO;
import au.com.metlife.reference.entity.FeatureQuestion;
import au.com.metlife.reference.service.QuestionService;
import au.com.metlife.reference.utils.CommonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping(path = "api")
public class FearureQuestionController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FearureQuestionController.class);

	// private static final String template = "Hello, %s!";
	@Autowired
	QuestionService qService;
	
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@GetMapping(value ="/secure/{featureId}/featureQuestion",produces = "application/vnd.aumet.app-v1+json")
	public ResponseEntity<?> featureQuestions(@PathVariable("featureId") Long featureId,
			@ApiParam(hidden = true) @AuthenticationPrincipal Jwt jwt) {
		LOGGER.info("Start of call");
		
		String fund=CommonUtils.getFundCodeFromJWT(jwt);
		
		List<QuestionDTO> qList = qService.getQuestionsForFeature(featureId,fund);
		
		return new ResponseEntity<List<QuestionDTO>>(qList, HttpStatus.OK);
		
	}
	
	
	
	  @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken")	  })	  
	  @PostMapping(value ="/admin/featureQuestion",produces =	  "application/vnd.aumet.app-v1+json")	
	public FeatureQuestion mapQuestionToFeature(@Valid @RequestBody FeatureQuestion fq,@ApiParam(hidden = true) @AuthenticationPrincipal Jwt jwt) {
		  //admin function
		  //validate fund
		  //valide feature
		  //add to db
		
		return null;

	}
	
	


}
