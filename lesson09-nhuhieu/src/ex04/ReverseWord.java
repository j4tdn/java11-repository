package ex04;

public class ReverseWord {

 public void reverseWordInMyString(String str)
    {
        String[] words = str.split(" ");
        String reversedString = "";
        for (int i = 0; i < words.length; i++)
        {
            String word = words[i];
            String reverseWord = "";
            for (int g = word.length()-1; g >= 0; g--)
            {
                reverseWord = reverseWord + word.charAt(g);
            }
            reversedString = reversedString + reverseWord + " ";
        }
        System.out.println(str);
        System.out.println(reversedString);
    }
    public static void main(String[] args)
    {
       ReverseWord e = new ReverseWord();
        e.reverseWordInMyString("Welcome to JAVA10 class");
    }
}