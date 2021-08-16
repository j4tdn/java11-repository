package example04;

public class Vocabulary implements Comparable{
	private String word;
	private String mean;
	private String pos;
	private String note;
	
	public Vocabulary() {
	}

	public Vocabulary(String word, String mean, String pos, String note) {
		this.word = word;
		this.mean = mean;
		this.pos = pos;
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

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Vocabulary [word=" + word + ", mean=" + mean + ", pos=" + pos + ", note=" + note + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Vocabulary)) {
			return false;
		}
		
		Vocabulary that = (Vocabulary)obj;
		
		return this.getWord() == that.getWord();
	}

	@Override
	public int compareTo(Object o) {
		return this.word.compareToIgnoreCase(((Vocabulary) o).getWord());
	}
}
