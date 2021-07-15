
public class Ex04 {
	 public static void main(String[] args) {
	        ObjectSort[] sorts = getOS();
	        
	        Utils.printf(Buble(sorts));

	    }

	    private static ObjectSort[] Buble(ObjectSort[] sorts) {
	        for (int i = 0; i < sorts.length; i++) {
				for (int j = 0; j < sorts.length - 1 - i; j++) {
					if (sorts[j].getName().compareTo(sorts[j + 1].getName())==0) {
						if (sorts[j].getAge().compareTo(sorts[j + 1].getAge())<0) {
							swap(sorts, j, j + 1);
						}
					}
					if(sorts[j].getName().compareTo(sorts[j + 1].getName())>0) {
						swap(sorts, j, j + 1);
						continue;
					}
				}
			}
	        return sorts;
	    }
	    private static ObjectSort[] getOS() {
			return new ObjectSort[]{ new ObjectSort("I1", "12", "a"), 
			                         new ObjectSort("I2", "19", "d"), 
			                         new ObjectSort("I3", "18", "c")}; 
	                                        
					
		}
	    public static void swap(ObjectSort[] str, int i, int j) {
			ObjectSort tmp = str[i];
			str[i] = str[j];
			str[j] = tmp;
		}
}
