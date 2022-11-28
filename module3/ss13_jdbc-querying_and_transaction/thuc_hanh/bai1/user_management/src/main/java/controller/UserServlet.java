package controller;

import service.UserService;
import model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet(name = "UserServlet",urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":create(request,response);break;
            case "sort":sortName(request,response);break;
            case  "edit": editUser(request,response);break;
            case "findByCountry":findByCountry(request,response);break;
            default:showList(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
            if (action==null){
                action ="";
            }
            switch (action){
                case "create":showCreate(request,response);
                    break;
                case  "edit":showEdit(request,response);
                    break;
                case  "delete":deleteUser(request,response);break;
                default:showList(request,response);
            }
    }
    private void findByCountry(HttpServletRequest request,HttpServletResponse response){
            String country = request.getParameter("findCountry");
            request.setAttribute("userList",userService.findByCountry(country));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
            try {
                requestDispatcher.forward(request,response);
            }catch (ServletException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
    }
    private  void sortName (HttpServletRequest request,HttpServletResponse response){
            request.setAttribute("userList",userService.sortName());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showList(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("userList",userService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = userService.delete(id);
        String mess ="Xóa thành công";
        if (!check){
            mess =  "Xóa không thành công";
        }
        request.setAttribute("mess",mess);
        request.setAttribute("userList",userService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            response.sendRedirect("view/create.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void create (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Map<String,String> map = userService.add(new User(name,email,country));
        if(map.isEmpty()){
            response.sendRedirect("/users?");
        }
    }
    private void showEdit(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));

        User user = userService.findById(id);
        request.setAttribute("user",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void editUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println(1);
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        System.out.println(name);
        userService.edit(user);
        request.setAttribute("userList",userService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
