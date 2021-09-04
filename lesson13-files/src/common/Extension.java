package common;

public enum Extension {
	mp4(".mp4"), 
	mp3(".mp3"), 
	txt(".txt"), 
	java(".java"), 
	png(".png");
	
//	 Extension mp4 = new Extension("abc")
//	 Extension mp3 = new Extension("cxs")		

	private String ext;

	Extension(String ext) {
		this.ext = ext;
	}

	public String val() {
		return ext;
	}
}
