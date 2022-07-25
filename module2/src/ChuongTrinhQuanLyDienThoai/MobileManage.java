package ChuongTrinhQuanLyDienThoai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MobileManage {
    static Scanner scanner = new Scanner(System.in);
    public boolean checkId(List <Mobile> mobiles,int id){
        for (Mobile mobile : mobiles){
            if (mobile.getId()==id) return  true;
        }
        return  false;
    }
    public void addProduct(List<Mobile> mobiles){
        int lastId = 1;
        if (mobiles.size()>0){
            lastId = mobiles.get(mobiles.size()-1).getId()+1;
        }
        System.out.println("Chon loai san pham can them: (1).GenuineProducts | (2).PortableProducts");
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose==1){
            System.out.println("Them san pham chinh hang: ");
          Mobile genuineProduct = new GenuineProduct();
          genuineProduct.setId(lastId);
            genuineProduct.input();
            mobiles.add(genuineProduct);
        }
        else if(choose==2){
            Mobile portableProduct = new PortableProducts();
            portableProduct.setId(lastId);
            portableProduct.input();
            mobiles.add(portableProduct);
        }
    }
    public void display(List<Mobile> mobiles){
        mobiles.forEach(System.out::println);
    }
    public void deleteMobile(List<Mobile> mobiles, int id) throws NotFoundException {
        for (int i = 0; i < mobiles.size(); i++) {
            if(mobiles.get(i).getId() == id){
                mobiles.remove(i);
                return;
            }
        }
        throw new NotFoundException("Id is not exists");
    }
    public void searchName(List <Mobile> mobiles){
        System.out.println("Nhap ten san pham can tim: ");
        String name = scanner.nextLine();
        boolean flat = false;
        for (Mobile mobile : mobiles){
            if (name.toLowerCase().equalsIgnoreCase(mobile.getName().toLowerCase())){
                System.out.println(mobile);
                flat=true;
            }
        }
        if (!flat){
            System.out.println("Khong tim thay");
        }
    }
    public static void main(String[] args) {
        MobileManage mobileManage = new MobileManage();
        List<Mobile> mobiles = new ArrayList<>();
        int choose = -1;
        while (choose!=0){
            System.out.println("Nhap su lua chon: \n1.Them san pham \n2.Xoa dien thoai \n3.Tim dien thoai theo ten" +
                    "\n4.Hien thi danh sach dien thoai \n5.Exit!");
           choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case  1: mobileManage.addProduct(mobiles);break;
                case  2:
                    boolean isExists =false;

                    do{
                        System.out.print(isExists ? "Enter id again:" : "Enter id to delete:" );
                        int id = Integer.parseInt(scanner.nextLine());

                        try {
                            mobileManage.deleteMobile(mobiles, id);
                            isExists = false;
                            System.out.println("Deleted succesffully");
                        }
                        catch (NotFoundException e){
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                            isExists = true;
                        }

                    }while (isExists);
                    break;
                case 3:mobileManage.searchName(mobiles);break;
                case 4:mobileManage.display(mobiles);break;
                default:
                    System.out.println("Not Found");
            }
        }
    }
}
