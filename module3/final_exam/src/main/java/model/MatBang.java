package model;

public class MatBang {
    private int id;
    private String maMB;
    private float dienTich;
    private int maTrangThai;
    private int tang;
    private  int maLoaiVanPhong;
    private  float gia;
    private  String ngayBatDau;
    private String ngayKetThuc;
    public MatBang(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMB() {
        return maMB;
    }

    public void setMaMB(String maMB) {
        this.maMB = maMB;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getMaLoaiVanPhong() {
        return maLoaiVanPhong;
    }

    public void setMaLoaiVanPhong(int maLoaiVanPhong) {
        this.maLoaiVanPhong = maLoaiVanPhong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(int id, String maMB, float dienTich, int maTrangThai, int tang, int maLoaiVanPhong, float gia, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.maMB = maMB;
        this.dienTich = dienTich;
        this.maTrangThai = maTrangThai;
        this.tang = tang;
        this.maLoaiVanPhong = maLoaiVanPhong;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    };
    public MatBang( String maMB, float dienTich, int maTrangThai, int tang, int maLoaiVanPhong, float gia, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.maMB = maMB;
        this.dienTich = dienTich;
        this.maTrangThai = maTrangThai;
        this.tang = tang;
        this.maLoaiVanPhong = maLoaiVanPhong;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    };
}
