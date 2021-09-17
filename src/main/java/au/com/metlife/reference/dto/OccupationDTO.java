package au.com.metlife.reference.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


public class OccupationDTO implements Serializable{

	
	private Long id;	
	
	private  String name;	
	private  String dthFxCategory;
	private  String tpdFxCategory;
	private  String ipFxCategory;
	private  String dthUtCategory;
	private  String tpdUtCategory;	
	private  String ipUtCategory;
	
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
	public String getDthFxCategory() {
		return dthFxCategory;
	}
	public void setDthFxCategory(String dthFxCategory) {
		this.dthFxCategory = dthFxCategory;
	}
	public String getTpdFxCategory() {
		return tpdFxCategory;
	}
	public void setTpdFxCategory(String tpdFxCategory) {
		this.tpdFxCategory = tpdFxCategory;
	}
	public String getIpFxCategory() {
		return ipFxCategory;
	}
	public void setIpFxCategory(String ipFxCategory) {
		this.ipFxCategory = ipFxCategory;
	}
	public String getDthUtCategory() {
		return dthUtCategory;
	}
	public void setDthUtCategory(String dthUtCategory) {
		this.dthUtCategory = dthUtCategory;
	}
	public String getTpdUtCategory() {
		return tpdUtCategory;
	}
	public void setTpdUtCategory(String tpdUtCategory) {
		this.tpdUtCategory = tpdUtCategory;
	}
	public String getIpUtCategory() {
		return ipUtCategory;
	}
	public void setIpUtCategory(String ipUtCategory) {
		this.ipUtCategory = ipUtCategory;
	}
	
	
	
	

}
