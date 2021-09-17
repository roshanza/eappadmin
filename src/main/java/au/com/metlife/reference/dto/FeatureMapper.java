package au.com.metlife.reference.dto;

import au.com.metlife.reference.entity.Feature;
//@Component 
//@Mapper(componentModel = "spring",injectionStrategy =InjectionStrategy.CONSTRUCTOR,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeatureMapper {
	
	FeatureDTO featureToFeatureDTO(Feature entity);

}
