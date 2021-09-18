package bean;

public enum Extension {
	png(".png"),
	jpg(".jpg"),
	jpeg(".jpeg"),
	mp3(".mp3"),
	mp4(".mp4"),
	bat(".bat"),
	java(".java"),
	txt(".txt");
	
	private final String value;
	
	Extension(String value) {
		this.value = value;
	}
	
	public String val() {
		return value;
	}
}
