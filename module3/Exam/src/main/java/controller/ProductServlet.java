package controller;

import model.Product;
import services.CategoryService;
import services.ICategoryService;
import services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ProductServlet",urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "search":search(request,response);break;
            case "create":addProduct(request,response);break;
            case "delete":delete(request,response);break;
            default:showList(request,response);
        }
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":showCreate(request,response);break;
            default:showList(request,response);
        }
    }
    private  void showList(HttpServletRequest request,HttpServletResponse response) {
        request.setAttribute("products",productService.findAll());
        toList(request,response);
    }
    private  void delete(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = productService.deletebyId(id);
        String mess = "Xoa thanh cong";
        if (!check){
            mess="Xoa khong thanh cong";
        }
        request.setAttribute("mess",mess);
        request.setAttribute("products",productService.findAll());
        toList(request,response);
    }
    private  void addProduct(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryName"));
        String des = request.getParameter("des");
        Map<String,String> map = new HashMap<>();
        Product product = new Product(name,Float.parseFloat(price),Integer.parseInt(quantity),color,des,categoryId);
        if(id.isEmpty()) {
            // add
            map = productService.add(new Product(0,name,Float.parseFloat(price),Integer.parseInt(quantity),color,des,categoryId));
        } else {
            // edit
            map = productService.add(new Product(Integer.parseInt(id),name,Float.parseFloat(price),Integer.parseInt(quantity),color,des,categoryId));
        }
        if (!map.isEmpty()){
            request.setAttribute("error",map);
            request.setAttribute("categoryList",categoryService.findAll());
            request.setAttribute("product",product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
            try {
                requestDispatcher.forward(request,response);
            }catch (IOException e){
                e.printStackTrace();
            }catch (ServletException e){
                e.printStackTrace();
            }
        }else {
            response.sendRedirect("/products");
        }
    }
    private  void showCreate(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if(id != null) {
            Product product = productService.findById(Integer.parseInt(id));
            request.setAttribute("product",product);
            request.setAttribute("id",Integer.parseInt(id));
        }
        request.setAttribute("categoryList",categoryService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ServletException e){
            e.printStackTrace();
        }
    }
    private  void search(HttpServletRequest request, HttpServletResponse response){
        String searchValue = request.getParameter("searchInput");
        request.setAttribute("products",productService.search(searchValue));
        toList(request,response);
    }
    private void  toList(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("categorys",categoryService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ServletException e){
            e.printStackTrace();
        }
    }
}
