package common;

public enum Extension {
	png(".png"),
	jpg(".jpg"),
	jpeg(".jpeg"),
	mp4(".mp4"),
	mp3(".mp3"),
	bat(".bat"),
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
