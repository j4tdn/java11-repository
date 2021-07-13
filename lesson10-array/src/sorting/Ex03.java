package sorting;
import bean.Item;
import utils.ArrayUtils;
public class Ex03 {
  public static void main(String[] args) {
	Item[] items = getItems();
	for(int i = 0;i<items.length;i++) {
		for(int j = 0;j<items.length - i -1;j++) {
			if(items[j].getStoreId() > items[j+1].getStoreId()) {
				swap(items,j,j+1);
				continue;
			}
			if(items[j].getStoreId() == items[j+1].getStoreId()) {
				if(items[j].getItemId() < items[j+1].getItemId()) {
					swap(items, j, j+1);
				}
			}
		}
	}
	ArrayUtils.printf(items);
}
  private static Item[] getItems() {
	  return new Item[] {
			  new Item(1 ,12 ,"A",278),
			  new Item(4 ,132,"B",228),
			  new Item(2 ,122,"C",212),
			  new Item(12,212,"D",120),
			  new Item(11,123,"E",412)
	  };
  }
  private static void swap(Item[] items,int i,int j) {
	  Item tmp = items[i];
	  items[i] = items[j];
	  items[j] = tmp;
	  
  }
}
