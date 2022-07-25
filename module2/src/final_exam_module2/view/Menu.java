package final_exam_module2.view;

import final_exam_module2.exception.DuplicatePersonalRecordException;
import final_exam_module2.models.NhanSu;
import final_exam_module2.models.NhanVien;
import final_exam_module2.service.NhanSuService;
import final_exam_module2.service.NhanSuServiceImpl;
import final_exam_module2.validate.Validate;
import phone_management.exception.NotFoundException;
import ss1_intro_to_java.thuc_hanh.Variable;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private  static NhanSuService nhanSuService = new NhanSuServiceImpl();
    public static void main(String[] args) {
        while (true){
            System.out.println("1. Them moi nhan su ");
            System.out.println("2. Xoa nhan su");
            System.out.println("3. Xem danh sach nhan su");
            System.out.println("4. Thoat");
            System.out.println("Chon chuc nang");
            int choice= getChoice();
            switch (choice){
                case 1: themNhanSu();break;
                case 2: xoaNhanSu();break;
                case 3: display();break;
                case 4:System.exit(0);
            }
        }
    }
    private static void themNhanSu(){
        while (true){
            System.out.println("Chon loai nhan su can them: ");
            System.out.println("1. Them moi nhan vien");
            System.out.println("2. Them moi hoc vien");
            System.out.println("3. Quay lai");
            System.out.println("Chon chuc nang: ");
            int choice;
            boolean checkChoice;
            do {
                choice= getChoice();
                checkChoice = choice!=1 && choice!=2 && choice!=3;
                if (checkChoice){
                    System.out.println("Nhap sai!. Vui long nhap lai");
                }
            }while (checkChoice);

            if (choice==1){
                String maDinhDanh ="";
                do {
                    System.out.print("Nhap ma dinh danh: ");
                    maDinhDanh= sc.nextLine();
                }while (!Validate.checkMaDinhDanh(maDinhDanh));
                String hoVaTen="";
                do {
                    System.out.print("Nhap ho va ten: ");
                    hoVaTen=sc.nextLine();
                }while (!Validate.checkName(hoVaTen));
                System.out.print("Nhap ngay sinh: ");
                String ngaySinh = sc.nextLine();
                System.out.print("Nhap dia chi: ");
                String diaChi = sc.nextLine();
                String soDienThoai ="";
                boolean checkSdt = false;
                do {
                    System.out.print(checkSdt  ? "Nhap lai so dien thoai: " :"Nhap so dien thoai: ");
                    soDienThoai = sc.nextLine();
                    if (!Validate.checkSdt(soDienThoai)){
                        checkSdt = true;
                    }
                }while (!Validate.checkSdt(soDienThoai));
                String luong ="";
                boolean checkLuong = false;
                do {
                    System.out.print(checkLuong  ? "Nhap lai luong: " :"Nhap luong: ");
                    luong = sc.nextLine();
                    if (!Validate.isNumber(luong)){
                        checkLuong = true;
                    }
                }while (!Validate.isNumber(luong));
                System.out.print("Nhap phong ban: ");
                String phongBan = sc.nextLine();
                System.out.print("Nhap vi tri: ");
                String viTri = sc.nextLine();
                NhanSu nhanSu = new NhanVien("Nhan Vien",maDinhDanh,hoVaTen,ngaySinh,diaChi,soDienThoai,Float.parseFloat(luong),phongBan,viTri);
                try{
                    nhanSuService.create(nhanSu);
                }catch (DuplicatePersonalRecordException e){
                    e.getMessage();
                }
            }
            if (choice==2){
                String maDinhDanh ="";
                do {
                    System.out.print("Nhap ma dinh danh: ");
                    maDinhDanh= sc.nextLine();
                }while (!Validate.checkMaDinhDanhHV(maDinhDanh));
                String hoVaTen="";
                do {
                    System.out.print("Nhap ho va ten: ");
                    hoVaTen=sc.nextLine();
                }while (!Validate.checkName(hoVaTen));
                System.out.print("Nhap ngay sinh: ");
                String ngaySinh = sc.nextLine();
                System.out.print("Nhap dia chi: ");
                String diaChi = sc.nextLine();
                String soDienThoai ="";
                boolean checkSdt = false;
                do {
                    System.out.print(checkSdt  ? "Nhap lai so dien thoai: " :"Nhap so dien thoai: ");
                    soDienThoai = sc.nextLine();
                    if (!Validate.checkSdt(soDienThoai)){
                        checkSdt = true;
                    }
                }while (!Validate.checkSdt(soDienThoai));
                boolean checkDiem = false;
                String diemthi = "";
                do {
                    System.out.print(checkDiem  ? "Nhap lai diem: " :"Nhap diem: ");
                    diemthi = sc.nextLine();
                    if (!Validate.isNumber(diemthi)){
                        checkDiem = true;
                    }
                }while (!Validate.isNumber(diemthi));
                System.out.print("Nhap ten lop: ");
                String phongBan = sc.nextLine();
                System.out.print("Nhap ngay nhap hoc: ");
                String viTri = sc.nextLine();
                NhanSu nhanSu = new NhanVien("Hoc Vien Vien",maDinhDanh,hoVaTen,ngaySinh,diaChi,soDienThoai,Float.parseFloat(diemthi),phongBan,viTri);
                try{
                    nhanSuService.create(nhanSu);
                }catch (DuplicatePersonalRecordException e){
                    e.getMessage();
                }
            }
            if (choice==3) break;
            System.out.println("Them thanh cong");
        }
    }
    public static void display(){
        List<NhanSu> nhanSus = nhanSuService.findAll();
        nhanSus.forEach(System.out::println);
    }
    public  static  void xoaNhanSu(){
        display();
        boolean check = false;
        do {
            System.out.print(check  ? "Nhap lai ma dinh danh: " :"Nhap ma dinh danh can xoa: ");
            String maDinhDanh = sc.nextLine();
            System.out.println("1. Co \n2. Khong");
            String choice= "";
            boolean checkChoice = false;
            do {
                System.out.print(checkChoice  ? "Nhap lai lua chon: " :"Nhap lua chon: ");
                choice = sc.nextLine();
                if (!Validate.check12(choice)){
                    checkChoice = true;
                }
            }while (!Validate.check12(choice));
            if (Integer.parseInt(choice) ==1){
                try{
                    nhanSuService.delete(maDinhDanh);
                    System.out.println("Xoa thanh cong");
                    check = false;
                }catch (DuplicatePersonalRecordException e){
                    e.getMessage();
                    check = true;
                }
            }
            else{
                break;
            }
        }while (check);
    }
    private static int getChoice(){
        System.out.print("Input your choice: ");
        return Integer.parseInt(sc.nextLine());
    }
}
