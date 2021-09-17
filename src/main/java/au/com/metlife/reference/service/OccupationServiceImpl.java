package au.com.metlife.reference.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import au.com.metlife.reference.dto.OccupationDTO;
import au.com.metlife.reference.repository.IndustryRepository;
import au.com.metlife.reference.repository.OccupationRepository;

@Service("occService")
public class OccupationServiceImpl implements OccupationService{

	
	@Autowired
    private OccupationRepository occRepository;
	
	@Autowired
    private IndustryRepository indRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	
	public List<OccupationDTO> getOccupations() {
		// TODO Auto-generated method stub
	
		
		return occRepository.findAll().stream().map(occ -> modelMapper.map(occ, OccupationDTO.class)) 	
				.collect(Collectors.toList());

	
		//return occRepository.findAll();
	}

	@Override
	@Cacheable("occupation")
	public List<OccupationDTO> getOccupations( Long industryId,String fundCode) {
		// TODO Auto-generated method stub
		//by fund and industry
		
		if(indRepository.findByIdAndFundId(industryId,fundCode)!=null) {
			return occRepository.findByIndustryId(
					industryId).stream().map(occ -> modelMapper.map(occ, OccupationDTO.class)) 	
					.collect(Collectors.toList());	
		}
		else {
			throw new ResponseStatusException(NOT_FOUND, String.format("Incorrect industryId: ", industryId));
		}
				
	}



}
