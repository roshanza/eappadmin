package au.com.metlife.reference.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FeatureDTO implements Serializable{	
	
  
	 Long id;	
	 String name;	
	 String description;
	 boolean eligable;
	 
	@ApiModelProperty( readOnly = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isEligable() {
		return eligable;
	}
	public void setEligable(boolean eligable) {
		this.eligable = eligable;
	}
	
	
	

	
	}
