package au.com.metlife.reference.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import au.com.metlife.reference.dto.IndustryAdminDTO;
import au.com.metlife.reference.dto.IndustryDTO;
import au.com.metlife.reference.entity.Fund;
import au.com.metlife.reference.entity.Industry;
import au.com.metlife.reference.repository.IndustryRepository;

@Service("indService")
public class IndustryServiceImpl implements IndustryService{

	@Autowired
    private IndustryRepository indRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	@Cacheable("indutry")
	public List<IndustryDTO> getIndustries(String fundCode) {
		// TODO Auto-generated method stub
		 List<Industry> indList=indRepository.findByFundId(fundCode);
		 List<IndustryDTO> indDTOList = new ArrayList<IndustryDTO>();
		for(Industry i:indList) {
			indDTOList.add(modelMapper.map(i, IndustryDTO.class));
		}		
		return indDTOList;
	}


	@Override
	public IndustryAdminDTO createIndustry(IndustryAdminDTO indDTO) {
		// TODO Auto-generated method stub
		Industry ind=modelMapper.map(indDTO, Industry.class);
		
		
		
		return modelMapper.map(indRepository.save(ind), IndustryAdminDTO.class)  ;
	}
	
	

}
