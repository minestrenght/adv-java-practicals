<%@page import="java.sql.*" %>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "root");
        PreparedStatement ps = con.prepareStatement("select * from user_login where user_name=? and user_pass=?");
        ps.setString(1, request.getParameter("user"));
        ps.setString(2, request.getParameter("pass"));
        ResultSet rs = ps.executeQuery();
        boolean exist = rs.next();
        rs.close();
        ps.close();
        con.close();
        if(exist){
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        else
             out.print("Login Failed");
    } catch (Exception e) {
        out.print("Server error !");
    }
    
%>