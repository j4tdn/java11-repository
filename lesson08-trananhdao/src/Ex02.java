
public class Ex02 {
	public static void main(String[] args) {
        String s = "aDam Le vAN john Son";
        System.out.println("before: " + s);
        System.out.println("After: " + upperCase(s));

    }

    private static String upperCase(String s) {
        s = s.toLowerCase();
        char[] charArray = s.toCharArray();
        boolean foundSpace = true;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                if (foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }

        s = String.valueOf(charArray);
        return s;
    }

}
