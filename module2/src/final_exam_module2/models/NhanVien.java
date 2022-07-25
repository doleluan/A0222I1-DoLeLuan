package final_exam_module2.models;

public class NhanVien extends NhanSu {
    private float luong;
    private String phongBan;
    private String vitri;

    public NhanVien() {
        super();
    }
    public NhanVien(String type, String maDinhDanh, String hoVaTen, String ngaySinh, String diaChi, String soDienThoai, float luong, String phongBan, String vitri) {
        super(type, maDinhDanh, hoVaTen, ngaySinh, diaChi, soDienThoai);
        this.luong = luong;
        this.phongBan = phongBan;
        this.vitri = vitri;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "luong=" + luong +
                ", phongBan='" + phongBan + '\'' +
                ", vitri='" + vitri + '\'' +
                '}' + super.toString();
    }

    @Override
    public String toData() {
        return String.format("%s,%s,%s,%s",super.toData(),luong,phongBan,vitri);
    }
}
