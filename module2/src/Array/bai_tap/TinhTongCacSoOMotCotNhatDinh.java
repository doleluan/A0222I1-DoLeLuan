package Array.bai_tap;
import java.util.*;
public class TinhTongCacSoOMotCotNhatDinh {
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
                System.out.print("Input elemen a["+i+"]"+"["+j+"]");
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
            System.out.println();
        }
        int col2,maxCol = 0;
        System.out.println("Nhap vao thu tu cot");

        do {
            col2 = Integer.parseInt(sc.nextLine());
            if (col2<0 || col2>col-1){
                System.out.println("Nhap sai");
            }
        }while (col2<0 || col2>col-1);
        for (int i =0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                if (j==col2){
                    maxCol+=array[i][j];
                }
            }
        }
        System.out.println("Tong cac so o cot thu " + col2 +" la: " + maxCol);
    }
}
