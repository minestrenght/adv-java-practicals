package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calc extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            int n1 = Integer.parseInt(req.getParameter("n1"));
            int n2 = Integer.parseInt(req.getParameter("n2"));
            int n3 = 0;
            String cmd = req.getParameter("cmd");
            if ("+".equals(cmd)) {
                n3 = n1 + n2;
            } else if ("-".equals(cmd)) {
                n3 = n1 - n2;
            } else if ("*".equals(cmd)) {
                n3 = n1 * n2;
            } else if ("/".equals(cmd)) {
                n3 = n1 / n2;
            } else {
                n3 = n1 % n2;
            }
            out.printf("%d %s %d = %d", n1, cmd, n2, n3);
        } catch (NumberFormatException e) {
            out.println("Not a number !");
        } catch (ArithmeticException e) {
            out.println("Can't divide by zero !");
        }
        out.close();
    }

}
