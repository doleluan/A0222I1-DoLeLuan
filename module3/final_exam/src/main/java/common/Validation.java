package common;

public class Validation {
    private static String regexEmail = "(^[a-z]\\w{2,}@gmail.com)$";
    private  static String regexNumber = "^\\d{1,}$";
    private static String regexColor = "^\\D{3,}$";
    public static boolean checkEmail(String email) {
        return email.matches(regexEmail);
    }
    public static boolean checkNumber(String number){
        return number.matches(regexNumber);
    }
    public static boolean checkColor (String color){
        return  color.matches(regexColor);
    }

    public  static  boolean checkDate(String ngayBatDau,String ngayKetThuc){
//        ngayBatDau.split("-");
        return  false;
    }
}
