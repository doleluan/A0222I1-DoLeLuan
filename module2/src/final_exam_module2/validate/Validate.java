package final_exam_module2.validate;

public class Validate {
    public static boolean checkMaDinhDanh(String maDinhDanh){
        return  maDinhDanh.matches("NV-[0-9]{1,3}");
    }
    public static boolean checkMaDinhDanhHV(String maDinhDanh){
        return  maDinhDanh.matches("HV-[0-9]{1,3}");
    }
    public static boolean checkName(String name){
        return  name.matches("([A-Z][a-z]+\\ *)+");
    }
    public static  boolean checkSdt(String sdt){
        return  sdt.matches("0[0-9]{10,11}");
    }
    public  static  boolean isNumber(String number){
            return  number.matches("\\d+");
        }
    public static  boolean check12(String number){
        return  number.matches("[12]");
    }
}
