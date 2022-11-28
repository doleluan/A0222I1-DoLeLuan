package controller;

import model.MatBang;
import services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {
    private IMatBangServices matBangServices = new MatBangServices();
    private IVanPhongServices vanPhongServices = new VanPhongServices();
    private ITrangThaiServices trangThaiServices = new TrangThaiServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":add(request,response);break;
            case "delete": delete(request,response);break;
            default:showList(request,response);
        }
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

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("trangThai",trangThaiServices.findAll());
        request.setAttribute("vanPhong",vanPhongServices.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/update.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ServletException e){
            e.printStackTrace();
        }
    }
    private  void delete(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("deleteId"));
        matBangServices.deleteById(id);
        showList(request,response);
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("matBang",matBangServices.findAll());
        request.setAttribute("vanPhong",vanPhongServices.findAll());
        request.setAttribute("trangThai",trangThaiServices.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchValue = request.getParameter("searchInput");

        request.getRequestDispatcher("view/list.jsp").forward(request,response);
    }
    private void add (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maMB = request.getParameter("maMB");
        float dienTich = Float.parseFloat(request.getParameter("dientich"));
        int trangThai = Integer.parseInt(request.getParameter("trangThaiName"));
        int tang =Integer.parseInt(request.getParameter("tang"));
        float gia = Float.parseFloat(request.getParameter("giaChoThue"));
        int vanPhong = Integer.parseInt(request.getParameter("vanPhongName"));
        String ngayBD = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        matBangServices.add(new MatBang(maMB,dienTich,trangThai,tang,vanPhong,gia,ngayBD,ngayKetThuc));
        response.sendRedirect("/helloServlet");
    }
}
