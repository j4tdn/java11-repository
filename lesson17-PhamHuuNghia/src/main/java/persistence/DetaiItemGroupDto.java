package persistence;

public class DetaiItemGroupDto {
private int idTem;
private String nameItem;
private int numberOfItem;
public DetaiItemGroupDto(int idTem, String nameItem, int numberOfItem) {
	this.idTem = idTem;
	this.nameItem = nameItem;
	this.numberOfItem = numberOfItem;
}
public int getIdTem() {
	return idTem;
}
public void setIdTem(int idTem) {
	this.idTem = idTem;
}
public String getNameItem() {
	return nameItem;
}
public void setNameItem(String nameItem) {
	this.nameItem = nameItem;
}
public int getNumberOfItem() {
	return numberOfItem;
}
public void setNumberOfItem(int numberOfItem) {
	this.numberOfItem = numberOfItem;
}
@Override
public String toString() {
	return "DetaiItemDto [idTem=" + idTem + ", nameItem=" + nameItem + ", numberOfItem=" + numberOfItem + "]";
}
}
