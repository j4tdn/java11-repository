package demo;

public class Ex03 {
	public static void main(String[] args) {
		Item item = new Item();
		
		Item[] items = new Item[2];
		for(int i = 0; i< items.length; i++) {
			if(items[i] ==null ) {
				items[i] = new Item();
			}
			updateValues(items[i]);
		}
		print(items);
	}
	private static void updateValues(Item item) {
		item.setId(133);
		item.setName("Bat man");
	}
	private static void print(Item[] items) {
		for(Item item : items) {
			System.out.println(item);
		}
	}

}


class Item {
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
	
	@Override
	public String toString() {
		return id + ", " + name;
	}

}
