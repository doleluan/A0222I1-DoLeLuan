package repository;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductRepository implements IProductRepository{
    private final  String SELECT_ALL = "select * from product; ";
    private final String DELETE = "delete from product where id = ?;";
    private final String ADD_PRODUCT ="insert into product(name,price,quantity,color,description,category_id) values (?,?,?,?,?,?);";
    private final String FIND_BY_ID = "select * from product where id=?";
    private final String UPDATE = "update product set name =?,price=?,quantity =?,color=?,description=?,category_id=? where id =?";
    private final String SEARCH = "call search (?);";
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String des = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");

                products.add(new Product(id,name,price,quantity,color,des,category_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public void add(Product product) {
        Connection connection = BaseRepository.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(product.getId() > 0 ? UPDATE : ADD_PRODUCT);
            if(product.getId() > 0) {
                preparedStatement.setInt(7,product.getId());
            }
            preparedStatement.setString(1,product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Product> search(String find) {
        Connection connection = BaseRepository.getConnection();
        List<Product> products = new ArrayList<>();
        try{
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1,find);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String des = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                products.add(new Product(id,name,price,quantity,color,des,category_id));
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return products;
    }
    @Override
    public boolean deletebyId(int id) {
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
    public Product findById(int id) {
        Connection connection = BaseRepository.getConnection();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                product = new Product(id,name,price,quantity,color,description,category_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  product;
    }
}
