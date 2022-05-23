package ss1_intro_to_java.bai_tap;
import java.util.*;
public class ReadNumber {
    public static String hangchuc(int n){
        switch (n){
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            case 20: return "Twenty";
            default:
                return"Not Found";
        }
    }
    public static String hangdonvi(int n){
        switch (n) {
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            default:
                return "Not Found";
        }
    }
    public static String hangChucCuaTram(int n){
        int hangChucCuaTram = n/10;
        int hangDonViCuaTram = n%10;
        String str ="";
        switch (hangChucCuaTram){
            case 3: str+= "Thirty ";break;
            case 4: str+= "Forty ";break;
            case 5: str+= "Fifty ";break;
            case 6: str+= "Sixty ";break;
            case 7: str+= "Seventy ";break;
            case 8: str+= "Eighty ";break;
            case 9: str+= "Ninety ";break;
            default: str+="";
        }
        str += hangdonvi(hangChucCuaTram);
        return str;
    }
    public  static  String hangTram(int n){
        String str ="";
        int hangChuc = n%100;
        int hangTram = n/100;
        int hangDonVi = n%10;
        switch (hangTram){
            case 1: str +="One Hundred and ";break;
            case 2: str +="Two Hundred and ";break;
            case 3: str +="Three Hundred and ";break;
            case 4: str +="Four Hundred and ";break;
            case 5: str +="Five Hundred and ";break;
            case 6: str +="Six Hundred and ";break;
            case 7: str +="Seven Hundred and ";break;
            case 8: str +="Eight Hundred and ";break;
            case 9: str +="Nine Hundred and ";break;
        }
        if (hangChuc<10){
                str += hangdonvi(hangChuc);
        }else if (hangChuc>10 && hangChuc<=20){
            str+= hangchuc(hangChuc);
        }else if(hangChuc>20) {
            str+=hangChucCuaTram(hangChuc);
        }
        return str;
    }
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number");
        do {
            number = Integer.parseInt(sc.nextLine());
            if (number < 0 || number > 999) {
                System.out.println("Nhap sai, vui long nhap lai");
            }
        } while (number < 0 || number > 999);

        if (number >= 0 && number <= 10) {
            System.out.println(hangdonvi(number));;
        }else if (number > 10 && number <= 20) {
            System.out.println(hangchuc(number));;
        }
//        else if (number>20 && number<100){
//
//        }
        else{
            System.out.println(hangTram(number));
        }
    }
}
