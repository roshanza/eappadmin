package au.com.metlife.reference.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


public class IndustryAdminDTO implements Serializable{	

	private Long id;	
	private String name;
	private String fundId;
	
	
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
	public String getFundId() {
		return fundId;
	}
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	
	
   
	
}
