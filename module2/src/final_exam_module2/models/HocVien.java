package final_exam_module2.models;

public class HocVien extends NhanSu {
    private float diemThi;
    private String tenLop;
    private String ngayNhapHoc;
    public HocVien(){
        super();
    }
    public HocVien(String type, String maDinhDanh, String hoVaTen, String ngaySinh, String diaChi, String soDienThoai, float diemThi, String tenLop, String ngayNhapHoc) {
        super(type, maDinhDanh, hoVaTen, ngaySinh, diaChi, soDienThoai);
        this.diemThi = diemThi;
        this.tenLop = tenLop;
        this.ngayNhapHoc = ngayNhapHoc;
    }

    @Override
    public String toString() {
        return "HocVien{" +
                "diemThi=" + diemThi +
                ", tenLop='" + tenLop + '\'' +
                ", ngayNhapHoc='" + ngayNhapHoc + '\'' +
                '}' + super.toString();
    }

    @Override
    public String toData() {
        return String.format("%s,%s,%s,%s",super.toData(),diemThi,tenLop,ngayNhapHoc);
    }
}
