package au.com.metlife.reference.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


public class IndustryDTO implements Serializable{	

	private Long id;	
	private String name;
	
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
	
	
   
	
}
