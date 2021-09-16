package ex02;

public enum Extension02 {
	png(".png"),
	jpg(".jpg");
	private String ext;
	Extension02(String ext) {
		this.ext = ext;
	}
	public String val() {
		return ext;
	}
}


