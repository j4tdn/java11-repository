package ex03;

public class App {
	public static void main(String[] args) throws Exception {
        String str = "abcdef";
        StringBuffer strBuf = new StringBuffer(str);
        permutation(strBuf,str.length());
    }

    private static void  permutation (StringBuffer text, int index){

        if(index <= 0)
            System.out.println(text);            
        else { 
        	 permutation(text, index-1);
            int currPos = text.length()-index;
            for (int i = currPos+1; i < text.length(); i++) {
                swap(text,currPos, i);
                permutation(text, index-1);
                swap(text,i, currPos);
            }
        }
    }

    private  static void swap(StringBuffer str, int pos1, int pos2){
        char t1 = str.charAt(pos1);
        str.setCharAt(pos1, str.charAt(pos2));
        str.setCharAt(pos2, t1);
    }

}
