package team.awesome.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class creates a pet type
 *
 * @author Chuong Tran
 *
 */

// @Gaohan - Feel free to change pettype to int id by extends to IdEntity class instead. Thanks

@Entity
@Table(name = "PetType")
public class PetType {
	
	@Id
	@Column(name = "tc_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int typeId;
	@Column(name = "type")
	private String type;
	@Column(name = "category")
	private String category;
	
	public PetType() {}

	public PetType(int typeId, String type, String category) {
		super();
		this.typeId = typeId;
		this.type = type;
		this.category = category;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
