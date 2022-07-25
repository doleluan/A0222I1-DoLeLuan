package ChuongTrinhQuanLyDienThoai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class GenuineProduct extends Mobile {
    private LocalDate warrantyPeriod;
    private String warrantyCode;
    public GenuineProduct(){
        super();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "06/07/2022";
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        this.warrantyPeriod = localDate;
        this.warrantyCode = "";
    }
    public  GenuineProduct(int id,String name,float price, String manufactor,LocalDate warrantyPeriod,String warrantyCode){
        super(id,name,price,manufactor);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyCode = warrantyCode;
    }
    public LocalDate getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(LocalDate warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyCode() {
        return warrantyCode;
    }

    public void setWarrantyCode(String warrantyCode) {
        this.warrantyCode = warrantyCode;
    }

    @Override
    public String toString() {
        return super.toString() + "GenuineProduct: " +
                "warrantyPeriod=" + warrantyPeriod +
                ", warrantyCode='" + warrantyCode + '\'' +
                '}';
    }
    public void input(){
        super.input();
        System.out.println("Nhap thoi han bao hanh: ");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        //convert String to LocalDate
//        LocalDate localDate = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Nhap ma san pham: ");
        this.warrantyCode = scanner.nextLine();
    }
}
