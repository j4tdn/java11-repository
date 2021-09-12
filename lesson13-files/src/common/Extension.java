package common;

public enum Extension {
	// enumeration >> special classs
	// consist of constant object value
	// + amount of values in enum 
	// + object value
	mp4(".mp4"), // Extention mp4 = new Extention("abc");
	mp3(".mp3"), // Extention mp3 = new Extention("xyz" ); 
	txt(".txt"), 
	java(".java"), 
	png(".png");
	
	private final String ext;
	
	Extension(String ext) {
		this.ext = ext;
	}
	
	public String val() {
		return ext;
	}
	
}