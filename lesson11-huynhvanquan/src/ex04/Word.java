package ex04;

import java.util.Objects;

public class Word implements Comparable<Word>{
	String identityName;
	String meaning;
	WordType wordType;
	String note;

	public String getIdentityName() {
		return identityName;
	}
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public WordType getWordType() {
		return wordType;
	}
	public void setWordType(WordType wordType) {
		this.wordType = wordType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public Word(String identityName, String meaning, WordType wordType, String note) {
		super();
		this.identityName = identityName;
		this.meaning = meaning;
		this.wordType = wordType;
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "Word [name=" + identityName + ", meaning=" + meaning + ", wordType=" + wordType + ", note=" + note + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Word)) {
			return false;
		}
		Word that = (Word) obj;
		return this.getIdentityName() == that.getIdentityName();	
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(identityName);
	}
	
	@Override
	public int compareTo(Word word) {
		return this.getIdentityName().compareToIgnoreCase(word.getIdentityName());
	}
	
}
