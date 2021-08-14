package bt04;

import java.util.Objects;

import bt02.CD;

public class Vocabulary {
	private String word;
	private String mean;
	private String type;
	private String note;

	public Vocabulary() {
		// TODO Auto-generated constructor stub
	}

	public Vocabulary(String word, String mean, String type, String note) {
		super();
		this.word = word;
		this.mean = mean;
		this.type = type;
		this.note = note;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vocabulary)) {
			return false;
		}
		Vocabulary that = (Vocabulary) obj;
		return getWord().equalsIgnoreCase(that.getWord());
	}
	
	@Override
	public int hashCode() {
		//return getWord().hashCode();
		return getWord().toUpperCase().hashCode();
	}

	@Override
	public String toString() {
		return "Vocabulary [word=" + word + ", mean=" + mean + ", type=" + type + ", note=" + note + "]";
	}

}
