package ss15_debug_and_ngoai_le.bai_tap.bai_1;

public class Test {
    static void checkAge(int age) throws ArithmeticException {
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }

    public static void main(String[] args)  {
        try {
            checkAge(15);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
