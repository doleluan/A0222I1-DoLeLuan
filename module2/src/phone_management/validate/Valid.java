package phone_management.validate;

public class Valid {
//    public static boolean isNumber(String number){
//        try{
//            Double.parseDouble(number);
//            return true;
//        }catch (Exception e){
//            System.err.println("Khong phai so");
//            return false;
//        }
//    }
    public static boolean moreThan0(String a){
        return  a.matches("\\d+");
    }
    public static boolean isNotNumber(String string){
        return string.matches("\\S+");
    }
    public static boolean checkName(String name){
        return  name.matches("([A-Z][a-z]+\\ *)+");
    }
}
