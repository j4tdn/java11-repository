package ex04;

public class Word {
	private String vocabulary;
	private String mean;
	private WordType wordType;
	private String note;
	
	public Word() {
	}

	public Word(String vocabulary, String mean, WordType wordType, String note) {
		super();
		this.vocabulary = vocabulary;
		this.mean = mean;
		this.wordType = wordType;
		this.note = note;
	}

	public String getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
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

	@Override
	public String toString() {
		return "Vocabulary: " + vocabulary +
			   "\nMean: " + mean +
			   "\nWordType: " + wordType +
			   "\nNote="+ note +
			   "\n========================";
	}
	
	
}
