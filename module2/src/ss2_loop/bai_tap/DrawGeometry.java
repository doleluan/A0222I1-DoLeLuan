package ss2_loop.bai_tap;
import java.util.*;
public class DrawGeometry {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;

        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the triangle");
            System.out.println("4. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice =Integer.parseInt(input.nextLine());
            int height,width,edge;
            switch (choice) {
                case 1:
                    System.out.println("Input width");
                    width = Integer.parseInt(input.nextLine());
                    System.out.println("Input height");
                    height = Integer.parseInt(input.nextLine());
                    for (int i=1;i<=height;i++){
                        for (int j=1;j<=width;j++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Input edge");
                    edge = Integer.parseInt(input.nextLine());
                    for (int i=1;i<=edge;i++){
                        for (int j=1;j<=edge;j++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:int choose = -1;
                    while (choose != 0) {
                        System.out.println("Menu");
                        System.out.println("1. Draw Triangle Top - Left");
                        System.out.println("2. Draw Triangle Top - Right");
                        System.out.println("3. Draw Triangle Bottom - Left");
                        System.out.println("4. Draw Triangle Bottom - Right");
                        System.out.println("0. Exit");
                        System.out.println("Enter your choice: ");
                        choose = Integer.parseInt(input.nextLine());
                        switch (choose){
                            case 1:System.out.println("Input height");
                                height = Integer.parseInt(input.nextLine());
                                for (int i=height;i>=1;i--){
                                        for (int j=i;j>=1;j--){
                                            System.out.print("* ");
                                        }
                                    System.out.println();
                                }
                                break;
                            case 2:System.out.println("Input height");
                                height = Integer.parseInt(input.nextLine());
                                for (int i=height;i>=1;i--){
                                    for (int j=height;j>=1;j--){
                                        if (j>i){
                                            System.out.print("  ");
                                        }else {
                                            System.out.print("* ");
                                        }
                                    }
                                    System.out.println();
                                }
                                break;
                            case 3:System.out.println("Input height");
                                height = Integer.parseInt(input.nextLine());
                                for (int i=1;i<=height;i++){
                                    for (int j=1;j<=i;j++){
                                        System.out.print("* ");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 4:System.out.println("Input height");
                                height = Integer.parseInt(input.nextLine());
                                for (int i=1;i<=height;i++){
                                    for (int j=height;j>=1;j--){
                                        if (j>i){
                                            System.out.print("  ");
                                        }else {
                                            System.out.print("* ");
                                        }
                                    }
                                    System.out.println();
                                }
                                break;
                        }
                    }
                    break;
                case 4:System.out.println("Input height");
                    height = Integer.parseInt(input.nextLine());
                    for (int i=1;i<=height;i++){
                        for (int j=1;j<=height*2;j++){
                            if (Math.abs(height-j)<(i-1) ){
                                System.out.print("* ");
                            }else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }
        }
    }
}
