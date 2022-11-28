package controller;

import services.BServices;
import services.IBServices;
import services.IObjectServices;
import services.ObjectServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {
     private IObjectServices objectServices = new ObjectServices();
     IBServices ibServices = new BServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":add(request,response);break;
            case "search":searchFind(request,response);break;
            case "sort":sort(request,response);
            case "delete":delete(request,response);break;
            default:showList(request,response);
        }
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list",objectServices.sortName());
        toList(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("deleteId"));
            objectServices.deleteById(id);
            showList(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/helloServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case"create":showUpdate(request,response);break;
            default:showList(request,response);
        }
    }

    private void searchFind(HttpServletRequest request, HttpServletResponse response) {
        String searchValues = request.getParameter("searchInput");
        request.setAttribute("list",objectServices.search(searchValues));
        toList(request,response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("coverList",ibServices.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/update.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list",objectServices.findAll());
        toList(request,response);
    }
    private  void toList(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("coverList",ibServices.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
