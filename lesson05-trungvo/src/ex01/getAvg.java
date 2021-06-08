package ex01;

public class getAvg {
	public static void main(String[] args) {
        try {
            int data = 5 / 0;
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Khối lệnh finally luôn được thực thi");
        }
        System.out.println("Finished!");
    }
}
