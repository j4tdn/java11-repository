package common;

public enum Extension {
	mp4(".mp4"), mp3(".mp3"), txt(".txt"), java(".java"), png(".txt");

	private final String ext;

	private Extension(String ext) {
		this.ext = ext;
	}

	public String val() {
		return ext;
	}
}
