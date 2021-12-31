package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KichCo")
public class Size {
	
	@Id
	@Column(name = "MaKC")
	private String id;
	
	@Column(name = "MoTa")
	private String desc;
	
	public Size() {
	}

	public Size(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Size [id=" + id + ", desc=" + desc + "]";
	}
	
	
	
}
