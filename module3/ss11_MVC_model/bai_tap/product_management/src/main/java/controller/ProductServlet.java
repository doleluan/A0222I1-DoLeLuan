package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet",urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
        private ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action  = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":updateProduct(request,response);
                break;
            case "delete":
                break;
            case "findName":findName(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action  = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":showEditProduct(request,response);
                break;
            case "delete": deleteProduct(request,response);
                break;
            case "view":
                break;
            default:
                listProduct(request, response);
                break;
        }
    }
    private  void listProduct (HttpServletRequest request, HttpServletResponse response){
//        List<Product> products = productService.findAll();
        request.setAttribute("products",productService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException x){
            x.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private  void createProduct(HttpServletRequest request, HttpServletResponse response){
        int id =90;
        String name = request.getParameter("name");
        float  price = Float.parseFloat(request.getParameter("price"));
        String manufactor = request.getParameter("manufactor");
        Product product = new Product(90,name,price,manufactor);
        Map map  = productService.create(product);
        String mess = "them moi thanh cong";
        if (!map.isEmpty()){
            mess= "them moi khong thanh cong";
            request.setAttribute("error",map);
        }
        request.setAttribute("mess",mess);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("product/create.jsp");
        try{
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private  void showEditProduct(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher=request.getRequestDispatcher("product/404-error.jsp");
        }
        else {
            request.setAttribute("product",product);
            requestDispatcher=request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String manufactor = request.getParameter("manufactor");
            Product product = productService.findById(id);
            RequestDispatcher requestDispatcher;
            if (product==null){
                requestDispatcher = request.getRequestDispatcher("product/404-error.jsp");
            }else {
                String mess = "Chỉnh sửa thành công";
                product.setName(name);
                product.setPrice(price);
                product.setManufactor(manufactor);
                request.setAttribute("mess",mess);
                requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
            }
             try {
            requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
        }
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        response.sendRedirect("/productServlet");
    }
    private void findName(HttpServletRequest  request, HttpServletResponse response){
        String name = request.getParameter("namefind");
        request.setAttribute("products",productService.findByName(name));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/findName.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException x){
            x.printStackTrace();
        }
    }
}
