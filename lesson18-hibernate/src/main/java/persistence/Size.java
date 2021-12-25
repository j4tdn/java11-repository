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
	private String decs;
	
	public Size() {
	}

	public Size(String id, String decs) {
		super();
		this.id = id;
		this.decs = decs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDecs() {
		return decs;
	}

	public void setDecs(String decs) {
		this.decs = decs;
	}

	@Override
	public String toString() {
		return "Size [id=" + id + ", decs=" + decs + "]";
	}
	
	
	
}
