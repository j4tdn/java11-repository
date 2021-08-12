package ex04;

public class WordEnglish implements Comparable<WordEnglish> {
	private String word;
	private String wordType;
	private String note;

	public WordEnglish() {
		// TODO Auto-generated constructor stub
	}

	public WordEnglish(String word, String wordType, String note) {
		super();
		this.word = word;
		this.wordType = wordType;
		this.note = note;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWordType() {
		return wordType;
	}

	public void setWordType(String wordType) {
		this.wordType = wordType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		result = prime * result + ((wordType == null) ? 0 : wordType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnglish other = (WordEnglish) obj;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		if (wordType == null) {
			if (other.wordType != null)
				return false;
		} else if (!wordType.equals(other.wordType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WordEnglish [word=" + word + ", wordType=" + wordType + ", note=" + note + "]";
	}

	@Override
	public int compareTo(WordEnglish o) {
		return getWord().compareToIgnoreCase(o.getWord());
	}

}
