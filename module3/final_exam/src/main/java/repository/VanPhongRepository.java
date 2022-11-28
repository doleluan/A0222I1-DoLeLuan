package repository;

import model.TrangThai;
import model.VanPhong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VanPhongRepository implements IVanPhongRepository{
    private final String SELECT_ALL = "select * from vanphong ";
    @Override
    public List<VanPhong> findAll() {
        Connection connection = BaseRepository.getConnection();

        List<VanPhong> vanPhongs = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                vanPhongs.add(new VanPhong(id, name));
            }
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return vanPhongs;
    }
}
