package common;

public enum Extension {
	// enumeration >> special class
	// consist of constant values
	// + amount of value in enum
	mp4(".mp4"), // Extension mp4 = new Extension(
	mp3(".mp3"), // Extension mp3 = new Extension(
	png(".png"),
	java(".java"),
	txt(".txt");
	
	private final String ext;
	Extension(String ext){
		this.ext = ext;
	}
	public String val() {
		return "." + ext;
	}
}
