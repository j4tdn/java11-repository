package demo;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("Start");
		
		Item item = new Item();
		//item = null;
		updateValues(item);
		System.out.println("End");
		
		//Intinial Array
		Item[] items = new Item[2];
		for (int i = 0; i < items.length; i++) {
			if( items[i] == null ) {
				items[i] = new Item();
			}
			updateValues(items[i]);
		}
		printf(items);
	}
	
	private static void printf(Item[] items) {
		for (Item item : items) {
			System.out.println(item);
		}
	}
	
	private static void updateValues(Item item) {
		item.setId(123);
		item.setName("abc");
	}
}

class Item{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}