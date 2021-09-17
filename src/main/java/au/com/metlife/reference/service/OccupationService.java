package au.com.metlife.reference.service;

import java.util.List;

import au.com.metlife.reference.dto.OccupationDTO;

public interface OccupationService {
	
	List<OccupationDTO> getOccupations();
	List<OccupationDTO> getOccupations(Long industryId,String fundCode);

	
	
}
