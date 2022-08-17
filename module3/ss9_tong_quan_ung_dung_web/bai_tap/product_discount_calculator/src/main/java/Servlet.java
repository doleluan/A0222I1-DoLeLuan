import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet",urlPatterns = "/caculater")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float price = Float.parseFloat(request.getParameter("productPrice"));
        float discount = Float.parseFloat(request.getParameter("discountPercent"));
        String productDes = request.getParameter("productDes");
        float discountAmout = (float) (price * discount * 0.01);
        PrintWriter writer = response.getWriter();
        float discountPrice =price- discountAmout  ;
        writer.println("<html>");
        writer.println("<h1> Discount Amount:" + discountAmout +"</h1>" );
        writer.println("<h1> Discount Price:" + discountPrice +"</h1>" );
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
