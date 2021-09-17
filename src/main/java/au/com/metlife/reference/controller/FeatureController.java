package au.com.metlife.reference.controller;

import static org.springframework.http.HttpStatus.FORBIDDEN;

import java.util.List;

import javax.validation.Valid;

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

import au.com.metlife.reference.dto.FeatureDTO;
import au.com.metlife.reference.service.FeatureService;
import au.com.metlife.reference.utils.CommonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping(path = "api")
public class FeatureController {

	//private static final String template = "Hello, %s!";

	@Autowired 
	FeatureService  feaService;
		
	/*
	 * @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken")
	 * })
	 * 
	 * @GetMapping(value ="/secure/{memberTranscationNumber}/services",produces =
	 * "application/vnd.aumet.app-v1+json") public ResponseEntity <?>getFeatures(
	 * 
	 * @PathVariable("memberTranscationNumber")String memberTranscationNumber ,
	 * 
	 * @ApiParam(hidden = true) @AuthenticationPrincipal Jwt jwt) {
	 * 
	 * String cleintId = jwt.getClaimAsString("client_id"); if(cleintId!=null &&
	 * cleintId.length()==8) {
	 * 
	 * List<FeatureDTO> features=feaService.getFeatures(cleintId.substring(4));
	 * return new ResponseEntity<List<FeatureDTO>>(features,HttpStatus.OK); } else {
	 * throw new ResponseStatusException(FORBIDDEN, "Invalide Client ID:"+cleintId);
	 * }
	 * 
	 * 
	 * }
	 */
	
	
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@GetMapping(value ="/secure/services",produces = "application/vnd.aumet.app-v1+json")
	public  ResponseEntity <?>getFeaturesV1(
			
			@ApiParam(hidden = true) @AuthenticationPrincipal Jwt jwt) {		
		
		
		String fund=CommonUtils.getFundCodeFromJWT(jwt);
		List<FeatureDTO> features=feaService.getFeatures(fund);			
		return new ResponseEntity<List<FeatureDTO>>(features,HttpStatus.OK);	
		
			
		
		
	}
	

	
	 @PostMapping(value = "/public")
	    public FeatureDTO publicEndpoint(@Valid @RequestBody FeatureDTO occRateObj) {
		 
		 	return occRateObj;
		 	
	    }

}
