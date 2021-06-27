package ex03;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.regex.Pattern;

public class App {
	    public static void main(String[] args) {
	    	String string = "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêì"
	    				  + "íòóôõùúýĂăĐđĨĩŨũƠơƯưẠạẢả"
	    			      + "ẤấẦầẨẩẪẫẬậẮắẰằẲẳẴẵẶặẸẹẺẻ"
	    			      + "ẼẽẾếỀềỂểỄễỆệỈỉỊịỌọỎỏỐốỒồ"
	    			      + "ỔổỖỗỘộỚớỜờỞởỠỡỢợỤụỦủỨứỪừ"
	    			      + "ỬửỮữỰự";
	        String temp = Normalizer.normalize(string,Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            temp = pattern.matcher(temp).replaceAll("");
            temp = temp.contains("Đ") ? temp.replace("Đ","D") : temp;
            temp = temp.contains("đ") ? temp.replace("đ","d") : temp;
            System.out.println(temp);
		}
}

