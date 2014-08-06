package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Checker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String ans = req.getParameter("ans");//<-- get user answer here
        try {
            if ("d".equals(ans)) {
                pw.print("<p>Hurray right answer ...</p>");
            } else if ("abc".contains(ans)) {//<-- answer is a,b or c
                pw.print("<p>Oops wrong answer !, try again ...</p>");
            }
        } catch (NullPointerException ex) {
            pw.print("<p>Choose an answer !!</p>");
            ex.printStackTrace(System.err);
        } finally {
            pw.print("[<a href='index.html'>Back</a>]");
            pw.close();
        }
    }

}
