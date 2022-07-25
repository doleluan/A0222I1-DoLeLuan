package phone_management.view;
import phone_management.exception.NotFoundException;
import phone_management.models.AuthenticPhone;
import phone_management.models.HandPhone;
import phone_management.models.Phone;
import phone_management.service.PhoneService;
import phone_management.validate.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private static PhoneService phoneService = new PhoneService();
    public static void main(String[] args) {
        while (true){
            System.out.println("1. Them dien thoai");
            System.out.println("2. Xoa dien thoai");
            System.out.println("3. Tim kiem theo ten");
            System.out.println("4. Hien thi danh sach");
            System.out.println("5. Exit");
            int choice= getChoice();
            switch (choice){
                case 1: addPhone();break;
                case 2: delete();break;
                case 3: searchName();break;
                case 4:display();break;
                case 5: System.exit(0);
            }
        }
    }
    private static void addPhone(){
        System.out.println("1. Authentic Phone");
        System.out.println("2. Hand Phone");
        int choice;
        boolean checkChoice;
        do {
            choice= getChoice();
            checkChoice = choice!=1 && choice!=2;
            if (checkChoice){
                System.out.println("Nhap sai!. Vui long nhap lai");
            }
        }while (checkChoice);
        String name ="";
        do {
            System.out.print("Nhap ten dung dinh dang: ");
            name= sc.nextLine();
        }while (!Valid.checkName(name));

        String price="";
        do {
            System.out.print("Nhap gia: ");
            price=sc.nextLine();
        }while (!Valid.moreThan0(price));
        System.out.print("Nhap hang san xuat: ");
        String mannufacturer = sc.nextLine();
        if (choice==1){
            System.out.print("Nhap thoi gian bao hanh: ");
            String durationByYear = sc.nextLine();
            System.out.print("Nhap ma bao hanh: ");
            String durationByCode = sc.nextLine();
            Phone phone = new AuthenticPhone(0,name,Double.parseDouble(price),mannufacturer,durationByYear,durationByCode);
            phoneService.addPhone(phone);
        }
        if (choice==2){
            System.out.print("Nhap quoc gia: ");
            String contry = sc.nextLine();
            System.out.print("Nhap trang thai: ");
            String status = sc.nextLine();
            Phone phone = new HandPhone(0,name,Double.parseDouble(price),mannufacturer,contry,status);
            phoneService.addPhone(phone);
        }
        System.out.println("Them thanh cong");
    }
    public static void display(){
        List<Phone> phone = phoneService.displayPhones();
        phone.forEach(System.out::println);
    }
    private static void delete(){
        display();
        boolean check = false;
        do {
            System.out.print(check  ? "Nhap lai id: " :"Nhap id can xoa: ");
            int id = Integer.parseInt(sc.nextLine());
            try{
                phoneService.deletePhone(id);
                System.out.println("Xoa thanh cong");
                check = false;
            }catch (NotFoundException e){
                e.getMessage();
                check = true;
            }
        }while (check);
    }
    public static void searchName(){
        System.out.print("Nhap ten can tim: ");
        String name = sc.nextLine();
        List<Phone> phones = phoneService.searchName(name);
        if(phones.size() > 0){
            phones.forEach(System.out::println);
        }
        else{
            System.out.println("Empty list");
        }
    }
    private static int getChoice(){
        System.out.print("Input your choice: ");
        return Integer.parseInt(sc.nextLine());
    }
}
