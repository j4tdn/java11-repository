package common;

public enum Extension {
	/*
	 *  enumeration >> special class
	 *  consist of constant values
	 *  + amount of value in enum
	 *  + object value
	 */
	mp3(".mp3"), // <=> Extension mp4 = new Extension(".mp3");
	mp4(".mp4"),
	txt(".txt"),
	java(".java"),
	png(".png"); // tenfile + "." + mp4 >> tenfile + mp4
	
	private final String ext;
	
	Extension(String ext) {
		this.ext = ext;
	}
	
	public String val() {
		return ext;
	}
}
