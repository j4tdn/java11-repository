package extension;

public enum Extension {
	png(".png"),
	jpg(".jpg"),
	jpeg(".jpeg"),
	mp3(".mp3"),
	mp4(".mp4"),
	bat(".bat"),
	java(".java"),
	txt(".txt");

    private String ets;
    private Extension(String ets) {
    	this.ets = ets;
	}
    public String val() {
    	return ets;
    }
}
