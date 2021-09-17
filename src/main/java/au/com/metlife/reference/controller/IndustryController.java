package au.com.metlife.reference.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.metlife.reference.dto.IndustryAdminDTO;
import au.com.metlife.reference.dto.IndustryDTO;
import au.com.metlife.reference.service.IndustryService;
import au.com.metlife.reference.utils.CommonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping(path = "api")
public class IndustryController {

	private static final Logger LOGGER=LoggerFactory.getLogger(IndustryController.class);
	

	@Autowired 
	IndustryService  indService;
	
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@GetMapping(value ="/secure/industry",produces = "application/vnd.aumet.app-v1+json")
	
	public  ResponseEntity <?>getIndustryV1(@ApiParam(hidden = true) @AuthenticationPrincipal Jwt jwt) {		
				
		String fund=CommonUtils.getFundCodeFromJWT(jwt);		
		List<IndustryDTO> industry=indService.getIndustries(fund);
		return new ResponseEntity<List<IndustryDTO>>(industry,HttpStatus.OK);	
	}
	
	
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@GetMapping(value ="/secure/industry",produces = "application/vnd.aumet.app-v2+json")
	
	public  ResponseEntity <?>getIndustryV2(@ApiParam(hidden = true) @AuthenticationPrincipal Jwt jwt) {		
				
		String fund=CommonUtils.getFundCodeFromJWT(jwt);		
		List<IndustryDTO> industry=indService.getIndustries(fund);
		return new ResponseEntity<List<IndustryDTO>>(industry,HttpStatus.OK);	
	}
	
	
	
	
	  @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken")	  })	  
	  @PostMapping(value ="/admin/industry",produces =	  "application/vnd.aumet.app-v1+json")	  
	  public IndustryAdminDTO createIndustry(@ApiParam(hidden =true) @AuthenticationPrincipal Jwt jwt,@Valid @RequestBody IndustryAdminDTO indDTO) { 
	  
	  	return indService.createIndustry(indDTO);
	  
	  }
	 
	 

}
