package ex04;

public class Description {
	private String voc;
	private String mean;
	private String type;
	
	public Description() {
}

	public Description(String voc, String mean, String type) {
		super();
		this.voc = voc;
		this.mean = mean;
		this.type = type;

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
	@Override
	public String toString() {
		return "Description (" + voc + ", " + mean + ", " + type + " )";
	}
}