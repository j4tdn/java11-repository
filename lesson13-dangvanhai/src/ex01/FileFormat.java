package ex01;

public enum FileFormat {
	png(".png"), jpg(".jpg"), jpeg(".jpeg"),
	mp3(".mp3"), mp4(".mp4"), 
	bat(".bat"), java(".java"), txt(".txt");

	private final String extension;

	private FileFormat(String extension) {
		this.extension = extension;
	}

	public String getExtension() {
		return this.extension;
	}
	
	public static FileFormat[] getAllFormats() {
		return new FileFormat[] {
				png, jpg, jpeg, mp3, mp4, bat, java, txt
		};
	}
	
	public static FileFormat[] getImageFormats() {
		return new FileFormat[] {
				png, jpg, jpeg
		};
	}
	
	public static FileFormat[] getMusicFormats() {
		return new FileFormat[] {
				mp3, mp4
		};
	}
	
	public static FileFormat[] getSystemFormats() {
		return new FileFormat[] {
				bat
		};
	}
	
	public static FileFormat[] getTrashFormats() {
		return new FileFormat[] {
				txt
		};
	}
	
	public static FileFormat[] getCodingFormats() {
		return new FileFormat[] {
				java
		};
	}
}
