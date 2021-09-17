package au.com.metlife.reference.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import au.com.metlife.reference.dto.FeatureDTO;
import au.com.metlife.reference.entity.Feature;
import au.com.metlife.reference.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("feaService")
public class FeatureServiceImpl implements FeatureService{
	
	@Autowired
    private FeatureRepository feaRepository;
	
	
	  @Autowired 
	  private ModelMapper modelMapper;
	 
	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
	//private FeatureMapper mapper;

	
	
	/*
	 * @Autowired public FeatureServiceImpl(ModelMapper modelMapper) {
	 * this.modelMapper = modelMapper;
	 * 
	 * }
	 */

	@Override
	@Cacheable("features")
	public List<FeatureDTO> getFeatures(String fundCode) {
		// TODO Auto-generated method stub
		List<Feature> features= feaRepository.findByFundId(fundCode);	
		//modelMapper.getConfiguration().se		
		
//		return feaRepository.findByFundId(fundCode).stream().map(feature -> modelMapper.map(feature, FeatureDTO.class)) 				.collect(Collectors.toList());
		
		 List<FeatureDTO> fdtoList = new ArrayList<FeatureDTO>();
		    
			
			  
			  
			 
			  for(Feature f :features){ 
				  
				 // FeatureDTO fdto=mapper.featureToFeatureDTO(f);
				  //modelMapper.map(features, fdtoList);
				  FeatureDTO fdto =modelMapper.map(f ,FeatureDTO.class);
				  
				  //FeatureDTO fdto=mapstructMapper.convertFeatureToFeatureDTO(f);				  
				  fdtoList.add(fdto); 
				  
			  }
			 
		
		return fdtoList;
	}

}
