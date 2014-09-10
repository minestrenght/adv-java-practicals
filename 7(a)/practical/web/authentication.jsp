<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.sql.*"%>
<%
    String user_id = request.getParameter("t1");
    String password = request.getParameter("t2");

    try {
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "root");
        PreparedStatement ps = con.prepareStatement("select t.* from user_login t where t.user_name=? and decode(t.user_pass, '*')=?");
        ps.setString(1, user_id);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            session.setAttribute("user_id", user_id);
            response.sendRedirect("welcome.jsp");
        } else {
            out.println("Could not Login!");
        }
        rs.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        out.println("Error: " + e);
    }
%>
