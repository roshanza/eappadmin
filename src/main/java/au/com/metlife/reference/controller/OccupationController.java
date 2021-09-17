package au.com.metlife.reference.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import au.com.metlife.reference.dto.OccupationDTO;
import au.com.metlife.reference.dto.OccupationDTORespose;
import au.com.metlife.reference.service.OccupationService;
import au.com.metlife.reference.utils.CommonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping(path = "api")
public class OccupationController {

	// private static final String template = "Hello, %s!";
	@Autowired
	OccupationService occService;

	@Autowired 
	private ModelMapper modelMapper;
		

	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@GetMapping(value ="/secure/{industryId}/occupation",produces = "application/vnd.aumet.app-v1+json")
	public ResponseEntity<?> getOccupationsByIndustryV1(
			@ApiParam(hidden = true) @AuthenticationPrincipal Jwt jwt,
			@PathVariable("industryId") Long industryID ,
			@RequestParam(value="occCategory",defaultValue="exclude") String occCategory) {
		
		String fund=CommonUtils.getFundCodeFromJWT(jwt);		
		
		List<OccupationDTO> occupation = occService.getOccupations(industryID,fund);			
		if(occupation!=null && occupation.size()==0) {
			throw new ResponseStatusException(NOT_FOUND, String.format("No resource found for id (%s)", industryID));
		}
		else {
			if(occCategory.equalsIgnoreCase("include")) {
				return new ResponseEntity<List<OccupationDTO>>(occupation, HttpStatus.OK);	
			}else {
				
					
				
				return new ResponseEntity<List<OccupationDTORespose>>(
						occupation.stream().map(occ -> modelMapper.map(occ, OccupationDTORespose.class)).collect(Collectors.toList())
						, HttpStatus.OK);
			}
				
		}
		

	}

}
