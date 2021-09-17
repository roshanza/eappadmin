package au.com.metlife.reference.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "occupation" , schema = "EAPPOCC")
public class Occupation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private  String name;
	
	@Column(name="dthfxcategory")	
	private  String dthFxCategory;
	
	@Column(name="tpdfxcategory")
	private  String tpdFxCategory;
	
	@Column(name="ipfxcategory")
	private  String ipFxCategory;
	
	@Column(name="dthutcategory")
	private  String dthUtCategory;
	
	@Column(name="tpdutcategory")
	private  String tpdUtCategory;
	
	@Column(name="iputcategory")
	private  String ipUtCategory;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "industry_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	
    @JsonIgnore
	private Industry industry;


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


	public Industry getIndustry() {
		return industry;
	}


	public void setIndustry(Industry industry) {
		this.industry = industry;
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
