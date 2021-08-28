package ex04;

import java.util.Objects;

public class Vocabulary  implements Comparable<Vocabulary>{
	private String word;
	private String mean;
	private String type;
	private String note;
	
	public Vocabulary() {
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
		if(obj == this) {
			return true;
		}
		if(!(obj instanceof Vocabulary)) {
			return false;
		}
		
		Vocabulary that = (Vocabulary) obj;
		return this.getWord().equalsIgnoreCase(that.getWord());
	}
	
	@Override
	public int compareTo(Vocabulary o) {
		return word.compareTo(o.getWord());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
	

	@Override
	public String toString() {
		return "Vocabulary [word=" + word + ", mean=" + mean + ", type=" + type + ", note=" + note + "]";
	}

	
	
}
