package ss8_cleancode_and_refactoring.thuc_hanh.bai_2;

public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if(isFizz && isBuzz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return String.valueOf(number);
    }

    public static void main(String[] args) {

        System.out.println( fizzBuzz(5));
        System.out.println(      fizzBuzz(3));
        System.out.println(fizzBuzz(15));
    }
}
