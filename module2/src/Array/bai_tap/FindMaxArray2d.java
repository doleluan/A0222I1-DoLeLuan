package Array.bai_tap;
import  java.util.*;
public class FindMaxArray2d {
    public static void main(String[] args) {
        int col,row;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input so dong ");
        row = Integer.parseInt(sc.nextLine());
        System.out.println("input so cot");
        col = Integer.parseInt(sc.nextLine());
        int [][] array = new int[row][col];
        for (int i =0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                System.out.println("Input elemen a["+i+"]"+"["+j+"]");
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        int max = array[0][0];
        for (int i =0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                if (max<array[i][j]){
                    max = array[i][j];
                }
                System.out.println("Input elemen a["+i+"]"+"["+j+"]" + " = " + array[i][j]);
            }
        }
        System.out.println("Phan tu lon nhat trong mang la: " + max);
    }
}
