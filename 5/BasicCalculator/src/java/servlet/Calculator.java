package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String cmd = req.getParameter("cmd");
        String s1 = req.getParameter("num1");
        String s2 = req.getParameter("num2");
        float f1 = 0f, f2 = 0f;
        boolean toQuit = false;
        try {
            f1 = Float.parseFloat(s1);
        } catch (NumberFormatException ex) {
            pw.printf("<p>First input is not a number: %s</p>", s1);
            toQuit = true;
        } catch (NullPointerException ex) {
            pw.printf("<p>First number was not given</p>");
            toQuit = true;
        }
        try {
            f2 = Float.parseFloat(s2);
        } catch (NumberFormatException ex) {
            pw.printf("<p>Second input is not a number: %s</p>", s2);
            toQuit = true;
        } catch (NullPointerException ex) {
            pw.printf("<p>Second number was not given</p>");
            toQuit = true;
        }
        if (!toQuit) {
            float r = 0f;
            toQuit = false;
            try {
                if ("+".equals(cmd)) {
                    r = f1 + f2;
                } else if ("-".equals(cmd)) {
                    r = f1 - f2;
                } else if ("/".equals(cmd)) {
                    r = f1 / f2;
                } else if ("*".equals(cmd)) {
                    r = f1 * f2;
                } else if ("%".equals(cmd)) {
                    r = f1 % f2;
                } else {
                    pw.print("<p>Please choose command to perform !</p>");
                    toQuit = true;
                }

                if (!toQuit) {
                    pw.printf("<p>%s %s %s = %s</p>", f1,cmd,f2, r);
                }
            } catch (ArithmeticException ex) {
                pw.printf("<p>Cannot do: %s %s %s !</p>", s1, cmd, s2);
            }
        }
        pw.println("<p>[<a href='index.html'>Back</a>]</p>");
        pw.close();
    }

}
