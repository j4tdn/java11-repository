package ex04;

import ex02.DishCD;

public class Word implements Comparable {
	private String word;	
	private String mean;
	private String loai;
	private String note;
	
	public Word() {
		// TODO Auto-generated constructor stub
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

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public Word(String word, String mean, String loai, String note) {
		super();
		this.word = word;
		this.mean = mean;
		this.loai = loai;
		this.note = note;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Word)) {
			return false;
		}
		Word that = (Word)obj;
		return this.getWord() == that.getWord();
	}
	
	@Override
	public int compareTo(Object obj) {
		return this.getWord().compareToIgnoreCase(((Word)obj).getWord());
	}

	@Override
	public String toString() {
		return word + ", " + mean + ", " + loai + ", " + note;
	}
	
	

	

}
