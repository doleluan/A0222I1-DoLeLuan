package repository;

import model.TrangThai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiRepository implements  ITrangThaiRepository{
    private final String SELECT_ALL = "select * from trangthai ";

    @Override
    public List<TrangThai> findAll() {
        Connection connection = BaseRepository.getConnection();

        List<TrangThai> trangThais = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                trangThais.add(new TrangThai(id, name));
            }
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return trangThais;
    }
}
