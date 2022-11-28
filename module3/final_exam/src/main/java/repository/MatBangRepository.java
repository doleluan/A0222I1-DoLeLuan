package repository;

import model.MatBang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IMatBangRepository {
    private final  String SELECT_ALL = "select * from matbang; ";
    private final String ADD ="insert into matbang(ma_mat_bang,dien_tich,ma_trang_thai,tang,ma_loai_van_phong,gia,ngay_bat_dau,ngay_ket_thuc) values (?,?,?,?,?,?,?,?);";
    private  final String FIND_ID = "select * from matbang where id =?";
    private final String DELETE = "delete from matbang where id = ?";
    @Override
    public List<MatBang> findAll() {
        List<MatBang> matBangs = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + (checkSearch == null ? "" : " where ")  );
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String maMB = resultSet.getString("ma_mat_bang");
                int dientich = resultSet.getInt("dien_tich");
                int maTrangThai = resultSet.getInt("ma_trang_thai");
                int tang = resultSet.getInt("tang");
                int maVanPhong = resultSet.getInt("ma_loai_van_phong");
                float gia = resultSet.getInt("gia");
                String ngayBatDau = resultSet.getString("ngay_bat_dau");
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");

                matBangs.add(new MatBang(id,maMB,dientich,maTrangThai,tang,maVanPhong,gia,ngayBatDau,ngayKetThuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  matBangs;
    }

    @Override
    public void add(MatBang matBang) {
        Connection connection = BaseRepository.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setString(1,matBang.getMaMB());
            preparedStatement.setFloat(2,matBang.getDienTich());
            preparedStatement.setInt(3,matBang.getMaTrangThai());
            preparedStatement.setInt(4,matBang.getTang());
            preparedStatement.setInt(5,matBang.getMaLoaiVanPhong());
            preparedStatement.setFloat(6,matBang.getGia());
            preparedStatement.setString(7,matBang.getNgayBatDau());
            preparedStatement.setString(8,matBang.getNgayKetThuc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MatBang findById(int id) {
        Connection connection = BaseRepository.getConnection();
        MatBang matBang = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String maMB = resultSet.getString("ma_mat_bang");
                float dientich = resultSet.getFloat("dientich");
                int maTrangThai = resultSet.getInt("ma_trang_thai");
                int tang = resultSet.getInt("tang");
                int maVP = resultSet.getInt("ma_loai_van_phong");
                float gia = resultSet.getFloat("gia");
                String ngayBD = resultSet.getString("ngay_bat_dau");
                String ngayKT = resultSet.getString("ngay_ket_thuc");
                matBang = new MatBang(id,maMB,dientich,maTrangThai,tang,maVP,gia,ngayBD,ngayKT);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  matBang;
    }

    @Override
    public boolean deleteById(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            int num = preparedStatement.executeUpdate();
            return (num==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
