import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/customer")
public class Servlet extends HttpServlet {
    private static List<Customer> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Customer("Huynh Tuan Khanh","09-04-2001","Trong tim Han","../img/ngoant6.jpg"));
        list.add(new Customer("Huynh Ngoc Hop","11-03-2001","Quang Nam","../img/ngoant6.jpg"));
        list.add(new Customer("Pham Viet Ngoan","18-02-2001","Quang Nam","../img/ngoant6.jpg"));
        list.add(new Customer("Huynh Xuan Nhat","01-01-2001","Quang Nam","../img/ngoant6.jpg"));
        list.add(new Customer("Thai Quang Huy Hoang","09-09-2001","Trong tim Ngan","../img/ngoant6.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        request.setAttribute("customerList",list);
        requestDispatcher.forward(request,response);
    }
}
