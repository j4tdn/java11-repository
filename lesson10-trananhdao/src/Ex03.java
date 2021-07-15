
public class Ex03 {
	 public static void main(String[] args) {
	        String[] strings = {"-2", "-6","a", "10", null, "4", "8", null, "Special",  "c",
	           "b", "xx"};
	        Utils.printf(strings);
	        for (int i = strings.length - 1; i > 0; i--) {
	            for (int j = 0; j < i; j++) {
	                if (strings[j] == null && strings[j + 1] != null) {
	                    swap(strings, j, j + 1);
	                    continue;
	                }
	                if (strings[j + 1] == null) {
	                    continue;
	                }

	                if (lower(strings[j])  && strings[j].compareTo(strings[j + 1]) > 0) {
	                    swap(strings, j, j + 1);
	                    continue;
	                }
	                if (lower(strings[j + 1])) {
	                    continue;
	                }

	                if (number(strings[j]) ) {
	                    swap(strings, j, j + 1);
	                    
	                    continue;
	                }
	               
	                if (number(strings[j + 1]) ) {
	                    continue;
	                }
	                
	                
	                if(upper(strings[j])){
	                   
	                    continue;
	                }
	                if (upper(strings[j + 1])) {
	                     swap(strings, j, j+1);
	                    continue;
	                }
	                if(negative(strings[j])){
	                   
	                    continue;
	                }
	                if (negative(strings[j + 1]) ) {
	                     swap(strings, j, j+1);
	                    continue;
	                }
	                if (strings[j].compareTo(strings[j + 1]) > 0) {
						swap(strings, j, j + 1);
					}

	            }
	        }
	        Utils.printf(strings);
	    }

	    private static boolean number(String s) {

	        if (s.matches(".*[0-9].*") && !s.contains("-")) {
	            return true;
	        }
	        return false;
	    }

	    private static boolean upper(String s) {

	        if (s.matches(".*[A-Z].*") && !s.contains("-")) {
	            return true;
	        }
	        return false;
	    }

	    private static boolean lower(String s) {

	        if (s.matches(".*[a-z].*") && !s.matches(".*[A-Z].*")) {
	            return true;
	        }
	        return false;
	    }

	    private static boolean negative(String s) {

	        if (s.contains("-") && s.matches(".*[0-9].*")) {
	            return true;
	        }
	        return false;
	    }

	    public static void swap(String[] str, int i, int j) {
	        String tmp = str[i];
	        str[i] = str[j];
	        str[j] = tmp;
	    }

}
