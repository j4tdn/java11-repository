package common;

public enum Extension {
	mp4(".mp4"), mp3(".mp3"), txt(".txt"), java(".java"), pnq(".pnq");

	private final String ext;

	private Extension(String ext) {
		this.ext = ext;
	}

	public String value() {
		return ext;
	}
}
