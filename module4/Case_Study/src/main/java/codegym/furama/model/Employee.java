package codegym.furama.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer id;
    @Column(name = "ho_va_ten")
    private String name;
    @Column(name = "ngay_sinh")
    private Date dateOfBirth;
    @Column (name = "so_cmnd")
    private String  identityCard;
    @Column (name = "luong")
    private Double salary;
    @Column (name = "so_dien_thoai")
    private String phoneNumber;
    @Column (name = "email")
    private String email;
    @Column (name = "dia_chi")
    private String address;
    public  Employee(){

    }
}
