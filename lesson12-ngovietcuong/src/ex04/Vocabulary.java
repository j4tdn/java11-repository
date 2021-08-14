package ex04;

import java.util.Objects;

public class Vocabulary {
	private String voc;

	public Vocabulary() {
	}

	public Vocabulary(String voc) {
		super();
		this.voc = voc;
	}

	public String getVoc() {
		return voc;
	}

	public void setVoc(String voc) {
		this.voc = voc;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if(!(o instanceof Vocabulary)) {
			return false;
		}
		
		Vocabulary that = (Vocabulary) o;
		
		return getVoc().equalsIgnoreCase(that.getVoc());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getVoc().toLowerCase());
	}
	
	@Override
	public String toString() {
		return "Vocabulary (" + voc + ")";
	}
}
