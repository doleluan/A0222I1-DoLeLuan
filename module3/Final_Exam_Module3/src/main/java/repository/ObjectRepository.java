package repository;

import model.ObjectModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectRepository implements IObjectRepository {
    private final  String SELECT_ALL = "select * from product; ";
    private final String DELETE = "delete from product where id = ?;";
    private final String FIND_BY_ID = "select * from product where id=?";
    private  final String ADD ="insert into product () values(?,?,?)";
    private final String SEARCH = "call search (?);";
    private final String SORT = "select * from product order by name";
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
        return  false;
    }

    @Override
    public void add(ObjectModel object) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);

            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ObjectModel> search(String search) {
        Connection connection = BaseRepository.getConnection();
        List<ObjectModel> objects = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1,search);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  objects;
    }

    @Override
    public List<ObjectModel> findAll() {
        List<ObjectModel> objects = new ArrayList<>();
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

    @Override
    public List<ObjectModel> sortName() {
        List<ObjectModel> objects = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SORT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  objects;
    }

    @Override
    public ObjectModel findById(int id) {
        Connection connection = BaseRepository.getConnection();
        ObjectModel objects = null;
        try{
            PreparedStatement preparedStatement =connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
