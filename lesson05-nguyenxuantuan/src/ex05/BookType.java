package ex05;

public enum BookType {
	SACH_GIAO_KHOA ("SGK"),
	SACH_THAM_KHAO ("STK");
	
	private String type;
	
	private BookType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}