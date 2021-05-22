package ex05;

import java.util.Arrays;

public class Store {
	private TextBook [] textbook;
	private ReferenceBooks [] referenceBooks;
	
	public Store() {
		
	}
	
	public Store(TextBook[] textbook, ReferenceBooks[] referenceBooks) {
		super();
		this.textbook = textbook;
		this.referenceBooks = referenceBooks;
	}

	public TextBook[] getTextbook() {
		return textbook;
	}

	public void setTextbook(TextBook[] textbook) {
		this.textbook = textbook;
	}

	public ReferenceBooks[] getReferenceBooks() {
		return referenceBooks;
	}

	public void setReferenceBooks(ReferenceBooks[] referenceBooks) {
		this.referenceBooks = referenceBooks;
	}

	@Override
	public String toString() {
		return "Store [textbook=" + Arrays.toString(textbook) + ", referenceBooks=" + Arrays.toString(referenceBooks)
				+ "]";
	}
	
	
}
