package exercise02;

public enum Extention2 {
	JPG(".jpg"),
	PNG(".png");
	
	private String ext;
	
	private Extention2(String ext) {
		this.ext = ext;
	}
	
	public String val() {
		return ext;
	}
	
}
