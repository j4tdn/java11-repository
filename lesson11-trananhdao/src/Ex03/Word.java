package Ex03;

public class Word implements Comparable {
	private String word;
    private String mean;
    private String type;
    private String notes;

    public Word() {

    }

    public Word(String word, String mean, String type, String notes) {
        this.word = word;
        this.mean = mean;
        this.type = type;
        this.notes = notes;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;

    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean equals(Object obj) {
        Word w = (Word) obj;
        return word.equalsIgnoreCase(w.getWord());
    }

    public String toString() {
        return word + ": " + type + ": " + mean + ": " + notes;
    }

    public int compareTo(Object o) {
        return this.word.compareToIgnoreCase(((Word) o).getWord());
    }
}
