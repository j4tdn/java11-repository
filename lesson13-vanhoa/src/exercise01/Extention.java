package exercise01;

public enum Extention {
	PNG(".png"),
	JPG(".jpg"),
	JPEG(".jpeg"),
	MP3(".mp3"),
	MP4(".mp4"),
	BAT(".bat"),
	JAVA(".java"),
	TXT(".txt");
	
	private String ext;
	
	private Extention(String ext) {
		this.ext = ext;
	}
	
	public String val() {
		return ext;
	}
	
}
