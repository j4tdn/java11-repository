package common;

public enum Extension {
	mp4(".mp4"), // Extension mp4 = new Extension(".mp4");
	mp3(".mp3"), 
	txt(".txt"), 
	java(".java"), 
	png(".png");

	private String ext;

	Extension(String ext) {
		this.ext = ext;
	}
	
	public String val() {
		return ext;
	}
}
