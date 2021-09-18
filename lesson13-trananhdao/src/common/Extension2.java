package common;

public enum Extension2 {
	
	png(".png"),
	jpg(".jpg");
	
	
	private String ext;
	
	Extension2(String ext){
		this.ext = ext;
	}
	public String val() {
		return ext;
	}
}
