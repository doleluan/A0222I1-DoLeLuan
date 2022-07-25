package product.view;

import product.exception.NotFoundException;
import product.models.Export;
import product.models.Import;
import product.models.Product;
import product.service.ProductService;
import product.validate.Valid;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    static ProductService productService = new ProductService();
    private static  void display(){
        List<Product> products = productService.findAll();
        products.forEach(System.out::println);
    }
    public static void main(String[] args) {
        while (true){
            System.out.println("1. Them san pham");
            System.out.println("2. Xoa san pham");
            System.out.println("3. Hien thi san pham");
            System.out.println("4. Tim kiem san pham");
            System.out.println("5. Thoat!");
            int choice = getChoice();
            switch (choice){
                case 1:create();break;
                case 2:delete();break;
                case 3:display();break;
                case 5:System.exit(0);
            }
        }
    }
    private static int getChoice(){
        System.out.print("Input your choice: ");
        return Integer.parseInt(sc.nextLine());
    }
    private static void delete(){
        display();
        boolean check = false;
        int i;
        do {
            System.out.println(check? "Nhap lai id: " : "Nhap id: ");
            i = Integer.parseInt(sc.nextLine());
            try {
                productService.delete(i);
                check=false;
            }catch (NotFoundException e){
                e.getMessage();
                check=true;
            }
        }while (check);
    }

    private static void create(){
        System.out.println("1.Export Product \n2.Import Product");
        int choice = getChoice();
        if (choice==1){
            System.out.print("Nhap ma san pham: ");
            String code = sc.nextLine();
            System.out.print("Nhap ten san pham: ");
            String name = sc.nextLine();
            String price="";
            boolean checkPrice = false;
            do {
                System.out.print(checkPrice? "Nhap lai gia: " : "Nhap gia: ");
                price= sc.nextLine();
                if (Valid.isNumber(price)){
                    checkPrice= true;
                }
            }while (!Valid.isNumber(price));
            System.out.print("Nhap nha san xuat: ");
            String mannufacturer = sc.nextLine();
            String exportPrice = "";
            boolean checkExport=false;
            do {
                System.out.print(checkExport? "Nhap lai gia xuat khau : " : "Nhap gia xuat khau: ");
                exportPrice= sc.nextLine();
                if (!Valid.isNumber(exportPrice)){
                    checkExport= true;
                }
            }while (!Valid.isNumber(exportPrice));
            System.out.print("Nhap quoc gia nhap khau: ");
            String importContry = sc.nextLine();
            Product product = new Export("Export",0,code,name,Double.parseDouble(price),mannufacturer,Double.parseDouble(exportPrice),importContry);
            productService.create(product);
        }else if(choice==2){
            System.out.print("Nhap ma san pham: ");
            String code = sc.nextLine();
            System.out.print("Nhap ten san pham: ");
            String name = sc.nextLine();
            String price="";
            boolean checkPrice = false;
            do {
                System.out.print(checkPrice? "Nhap lai gia: " : "Nhap gia: ");
                price= sc.nextLine();
                if (Valid.isNumber(price)){
                    checkPrice= true;
                }
            }while (!Valid.isNumber(price));
            System.out.print("Nhap nha san xuat: ");
            String mannufacturer = sc.nextLine();
            String importPrice = "";
            boolean checkExport=false;
            do {
                System.out.print(checkExport? "Nhap lai gia nhap khau : " : "Nhap gia nhap khau: ");
                importPrice= sc.nextLine();
                if (!Valid.isNumber(importPrice)){
                    checkExport= true;
                }
            }while (!Valid.isNumber(importPrice));
            System.out.print("Nhap tinh nhap khau: ");
            String importProvince = sc.nextLine();
            String importTax ="";
            boolean checkTax = false;
            do {
                System.out.print(checkTax? "Nhap lai thue nhap khau : " : "Nhap thue nhap khau: ");
                importTax= sc.nextLine();
                if (!Valid.isNumber(importTax)){
                    checkTax= true;
                }
            }while (!Valid.isNumber(importTax));
            Product product = new Import("Import",0,code,name,Double.parseDouble(price),mannufacturer,Double.parseDouble(importPrice),importProvince,Float.parseFloat(importTax));
            productService.create(product);
        }
    }

}
