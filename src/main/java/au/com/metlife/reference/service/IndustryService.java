package au.com.metlife.reference.service;

import java.util.List;

import au.com.metlife.reference.dto.IndustryAdminDTO;
import au.com.metlife.reference.dto.IndustryDTO;

public interface IndustryService {
	List<IndustryDTO> getIndustries(String fundCode);
	IndustryAdminDTO createIndustry(IndustryAdminDTO ind);

}
