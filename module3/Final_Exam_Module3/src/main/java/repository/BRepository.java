package repository;

import model.BClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BRepository implements IBrepository {
    private final  String SELECT_ALL = "select * from product; ";
    @Override
    public List<BClass> findAll() {
        List<BClass> objects = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  objects;
    }
}
