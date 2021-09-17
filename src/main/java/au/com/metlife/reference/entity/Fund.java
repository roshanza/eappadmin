package au.com.metlife.reference.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "fund" , schema = "EAPPOCC")
public class Fund {

	@NotNull
	@Id
	private String id;
	
	@NotNull			
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	//setAnnualSalForUpgradeVal this will be used for occupatio upgrade .. value defined per fund
	
	
}
