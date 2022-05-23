package Array.bai_tap;
import java.util.*;
public class TongCacDuongCheo {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input so dong va cot cua ma tran vuong ");
        number = Integer.parseInt(sc.nextLine());
        int [][] array = new int[number][number];
        for (int i =0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                System.out.print("Input elemen a["+i+"]"+"["+j+"]");
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
            System.out.println();
        }
        int maxCheo = 0;
        for (int i =0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                if (i==j){
                    maxCheo +=array[i][j];
                }
            }
        }
        System.out.println("Tong duong cheo chinh cua ma tran " + maxCheo);
    }
}
