package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository  implements IUserRepository{
    private final String SELECT_ALL = "select * from users;";
    private final  String SELECT_BY_ID = "select * from users where id =?;";
    private final String DELETE_BY_ID = "delete from users where id =?";
    private final String INSERT_USERS = "insert into users (name,email,country) values (?,?,?);";
    private final String EDIT = "update users set `name`=?,email=?,country=? where id=?";
    private final String FIND_COUNTRY = "select * from users where country like ?";
    private final String SORT_NAME = "select * from users order by name asc";
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectionDB();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id,name,email,country));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  userList;
    }
    @Override
    public List<User> findByCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectionDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_COUNTRY);
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_COUNTRY.replace("?", country));
            preparedStatement.setString(1,'%'+country+'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country1 = resultSet.getString("country");
                userList.add(new User(id,name,email,country1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        Connection connection = BaseRepository.getConnectionDB();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  user;
    }

    @Override
    public void add(User user) {
        Connection connection = BaseRepository.getConnectionDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void edit(User user) {
        Connection connection = BaseRepository.getConnectionDB();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.setInt(4,user.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<User> sortName() {
        Connection connection = BaseRepository.getConnectionDB();
        List<User> userList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  userList;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectionDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            int num = preparedStatement.executeUpdate();
            return  (num==1);
        }catch (SQLException e){
            e.printStackTrace();
        }
            return  false;
    }
    @Override
    public List<User> findByAll(String name, String email, String country) {
        return null;
    }

}
