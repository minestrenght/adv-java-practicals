<%@page import="java.sql.*" %>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "root");
        PreparedStatement ps = con.prepareStatement("insert into user_login (user_name,user_pass) values (?,?)");
        ps.setString(1, request.getParameter("user"));
        ps.setString(2, request.getParameter("pass"));
        if(0 < ps.executeUpdate()) {
            out.println("Registration successful");
        } else {
            out.print("Registration Failed");
        }
        ps.close();
        con.close();
    } catch (Exception e) {
        out.print("Server error !");
    }
%>