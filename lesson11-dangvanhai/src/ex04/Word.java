package ex04;

enum TypeOfWord {
	NOUN, VERD, ADJECTIVE, ADVERD, PREPOSITION, CONJUNCTION, INTERJECTION;
}

public class Word {
	private String name;
	private TypeOfWord type;
	private String meaning;
	private String example;

	public Word() {
	}

	public Word(String name, TypeOfWord type, String meaning, String example) {
		this.name = name;
		this.type = type;
		this.meaning = meaning;
		this.example = example;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public TypeOfWord getType() {
		return type;
	}

	public void setType(TypeOfWord type) {
		this.type = type;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[" + name + "]")
			.append(" (" + type + ")")
			.append(": " + meaning)
			.append("\n-Example: " + example);
		return str.toString();
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
		if (this.getName().equals(that.getName()) && this.getType().equals(that.getType())) {
			return true;
		}
		return false;
	}
}
