package au.com.metlife.reference.service;

import java.util.List;

import au.com.metlife.reference.dto.FeatureDTO;

public interface FeatureService {
	List<FeatureDTO> getFeatures(String fundCode);	

}
