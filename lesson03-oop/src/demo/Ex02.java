package demo;

public class Ex02 {
    public static void main(String[] args) {
        int[] digits = new int[4];
        digits[0] = 10;
        digits[1] = 15;
        digits[2] = 3;
        digits[3] = 7;
        System.out.println(newArray(digits));
}

    private static int[] newArray(int[] a) {
        int[] b = new int[a.length];
        int mul = 1;
        for (int i = 0; i < a.length; i++) {
            mul *= a[i];
        }
        for (int i = 0; i < a.length; i++) {
            b[i] = mul / a[i];
        }
        return b;
    }

}
