package demo;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("Main end");
		Item item = new Item();
		updateValues(item);
		System.out.println(item);
		
		System.out.println("Main end");
		
		Item[] items = new Item[3];
		for(int i = 0; i < items.length ; i++) {
			if(items[i] == null) {
				items[i] = new Item(); 
			}
			updateValues(items[i]);
		}
		
		printf(items);
		
	}
	
	private static void updateValues(Item item) {
		item.setId(123);
		item.setName("Kate Man");
	}
	
	private static void printf(Item[] items) {
		for(Item item : items) {
			System.out.println(item);
		}
	}
}

class Item{
	private int id;
	private String name;
	
	public Item() {
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + id + ", " + name;
	}
}
