package common;

public class Valitadtion {
    private static String regexEmail ="(^[a-z]\\w{2,}@gmail.com)$";
    public static boolean checkEmail(String email){
        return email.matches(regexEmail);
    }
}
