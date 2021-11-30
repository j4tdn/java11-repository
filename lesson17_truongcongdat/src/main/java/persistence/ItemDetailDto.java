package persistence;

public class ItemDetailDto {
	private Integer igItem;
	private String nameIg;
	private Integer number;
	
	public ItemDetailDto() {
	}

	public ItemDetailDto(Integer igItem, String nameIg, Integer number) {
		this.igItem = igItem;
		this.nameIg = nameIg;
		this.number = number;
	}

	public Integer getIgItem() {
		return igItem;
	}

	public void setIgItem(Integer igItem) {
		this.igItem = igItem;
	}

	public String getNameIg() {
		return nameIg;
	}

	public void setNameIg(String nameIg) {
		this.nameIg = nameIg;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "ItemDetailDto [igItem=" + igItem + ", nameIg=" + nameIg + ", number=" + number + "]";
	}	
}
