package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Result extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int r = 0, w = 0;//count right, wrong
        if("f".equals(req.getParameter("v"))) {//get vowel value
            r ++;
        } else {
            w ++;
        }
        if("5".equals(req.getParameter("a"))) {//get addition value
            r ++;
        } else {
            w ++;
        }
        out.printf("No. of answers right: %d, wrong: %d", r, w);
        out.close();
    }
}
