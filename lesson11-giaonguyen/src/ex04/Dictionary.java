package ex04;

import java.util.Objects;

import ex02.CDStore;

public class Dictionary implements Comparable<String>{
	private String word;
	private String mean;
	private String type;
	private String note;
	
	public Dictionary() {
		// TODO Auto-generated constructor stub
	}

	public Dictionary(String word, String mean, String type, String note) {
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
	public boolean equals(Object o) {
		Objects.requireNonNull(o);
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof Dictionary)) {
			return false;
		}
		
		Dictionary that = (Dictionary)o;
		return getWord() == that.getWord();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(word);
	}
	
	@Override
	public int compareTo(String o) {
		return getWord().compareToIgnoreCase(o);
	}

	@Override
	public String toString() {
		return "Dictionary [word=" + word + ", mean=" + mean + ", type=" + type + ", note=" + note + "]";
	}
	
	
}
