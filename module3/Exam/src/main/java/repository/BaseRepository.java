package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String URL ="jdbc:mysql://localhost:3306/product_management";
    private static final String USER ="root";// mặc định của mysql
    private static final String PASS ="Dtt123765sslltt";// do cài đặt khi cài đặt mysql
    public static Connection getConnection() {
    Connection connection = null;
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }catch (SQLException e){
        e.printStackTrace();
    }
    return connection;
    }
}