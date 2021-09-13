package common;

public enum Extension {
	// enumeration >> special class
	// consist of constant values
	// + amount of values in enum
	// + object value
	mp4(".mp4"), // Extension mp4 = new Extension("abc");
	mp3(".mp3"), // Extension mp3 = new Extension("xyz");
	png(".png"),
	java(".java"),
	txt(".txt"); 
	
	private final String ext;
	
	Extension(String ext) {
		this.ext = ext;
	}
	
	public String val() {
		return ext;
	}
}
