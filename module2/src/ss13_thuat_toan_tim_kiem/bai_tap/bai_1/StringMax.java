package ss13_thuat_toan_tim_kiem.bai_tap.bai_1;
import java.util.*;
public class StringMax {
    private static Scanner sc = new Scanner(System.in);
    public static List<Integer> chanToValue(String s){
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            list.add(((int)s.charAt(i)));
        }
        return list;
    }
    public static void  ascendingString(List <Integer> s){
        List<Integer> list = new ArrayList<>();
        list.add(s.get(0));
        for (int i=0;i<s.size()-1;i++){
            if (list.get(list.size()-1)<s.get(i+1)){
                list.add(s.get(i+1));
            }
        }
        list.forEach((p)->{
            System.out.print(Character.toChars(p));
        });
    }
    public static void main(String[] args) {
        System.out.println("Enter String");
        String string = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        list = chanToValue(string);
        ascendingString(list);
    }

}
