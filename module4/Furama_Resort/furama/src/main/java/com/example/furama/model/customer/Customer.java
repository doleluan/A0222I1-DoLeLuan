package com.example.furama.model.customer;

import com.example.furama.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;

@Entity(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khach_hang")
    private Integer id;
    @NotBlank(message = "chu be dan")
    @NotEmpty(message = "chu be dan")
    @Pattern(regexp = "^(([A-Z]{1})([a-z]{1,4}))(((\\s{1}[A-Z]{1})([a-z]{1,4})){1,})$",message = "ten ngu")
    @Column(name = "ho_va_ten")
    private String name;
    @Column(name = "ngay_sinh")
    private Date dateOfBirth;
    @Column(name = "gioi_tinh")
    private Boolean gender;
    @Pattern(regexp = "^\\d{9}|\\d{11}$",message = "Cmnd phải đúng định dạng ")
    @Column (name = "so_cmnd")
    private String  identityCard;
    @Pattern(regexp = "^\\d{10}",message = "Sdt phải đúng định dạng ")
    @Column (name = "so_dien_thoai")
    private String phoneNumber;
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",message = "Email phai dung dinh dang")
    @Column (name = "email")
    private String email;
    @Column (name = "dia_chi")
    private String address;
    @ManyToOne
    @JoinColumn(name = "ma_loai_khach")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
//    public static final String REGEX_STR = "^[a-zA-Z\\s\\W|_]+$";
//    public static final String REGEX_VILLA = "^(SVVL)-\\d{4}$";
//    public static final String REGEX_HOUSE = "^(SVHO)-\\d{4}$";
//    public static final String REGEX_ROOM = "^(SVRO)-\\d{4}$";
//    public static final String REGEX_AREA = "^([3-9][0-9]\\.*\\d*|\\d{3,}\\.*\\d*)$";
//    public static final String REGEX_RENTALCOSTS = "^\\d+\\.*\\d*$";
//    public static final String REGEX_MAXPEOPLE = "^([1-9]|1[0-9])$";
//    public static final String REGEX_FLOORS = "^\\d+$";
//    public static final String REGEX_PHONE_NUMBER = "^(\\+84|0)\\d{9}$";
//    public static final String REGEX_EMAIL = "^[a-zA-Z][a-zA-Z0-9]+@gmail.com$";
//    public static final String REGEX_BIRTHDAY = "^([0-2][0-9]|3[0|1])\\/(0[1-9]|1[0-2])\\/\\d{4}$";
//    public static final String REGEX_NUMBERDOUBLE = "^\\d+\\.*\\d*$";
//    public static final String REGEX_NUMBER = "^\\d+$";
//6:11
