package common;

public class Pageable {

	private int pageNum; // offset=(pageNum-1) * pageSize
	private int pageSize; // rowCount

	public static Pageable of(int pageNum, int pageSize) {
		return new Pageable(pageNum, pageSize);
	}

	private Pageable(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	
	public int getOffset() {
		return (pageNum-1) * pageSize;
	}
	
	public int getRowCount() {
		return pageSize;
	}
	
	@Override
	public String toString() {
		return "pageNum = " + pageNum + ", offset = " + getOffset() + ", rowcount = " + getRowCount(); 
	}
}
