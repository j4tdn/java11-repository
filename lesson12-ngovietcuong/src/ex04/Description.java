package ex04;

import java.util.Objects;

public class Description {
	private String voc;
	private String mean;
	private String type;
	private String note;
	
	public Description() {
}

	public Description(String voc, String mean, String type, String note) {
		super();
		this.voc = voc;
		this.mean = mean;
		this.type = type;
		this.note = note;
	}

	public String getVoc() {
		return voc;
	}

	public void setVoc(String voc) {
		this.voc = voc;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Description (" + voc + ", " + mean + ", " + type + ", " + note + ")";
	}
}
