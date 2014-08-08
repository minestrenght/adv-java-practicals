<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%
    String user = request.getParameter("user");
    String pass1 = request.getParameter("pass1");
    String pass2 = request.getParameter("pass2");

    boolean proceed = true;

    if (null == user || user.trim().isEmpty()) {
        proceed = false;
        request.setAttribute("user_reqd", "User name is required !");
    }
    if (null == pass1 || pass1.trim().isEmpty()) {
        proceed = false;
        request.setAttribute("pass1_reqd", "Password is required !");
    }
    if (null == pass2 || pass2.trim().isEmpty()) {
        proceed = false;
        request.setAttribute("pass2_reqd", "Confirm password is required !");
    }

    if (proceed && !pass1.equals(pass2)) {
        proceed = false;
        request.setAttribute("add_failure", "Password & Confirm password don't match !");
    }

    if (!proceed) {
        request.getRequestDispatcher("pre-register.jsp").forward(request, response);
    } else {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "root");
            ps = con.prepareStatement("select user_id from user_login where user_name=?");
            ps.setString(1, user);
            rs = ps.executeQuery();
            if(rs.next()) {
                request.setAttribute("add_failure", "User name already exist !");
            } else {
                ps = con.prepareStatement("insert into user_login (user_name,user_pass) values (?, decode(?,'*'))");
                ps.setString(1, user);
                ps.setString(2, pass1);
                if(0 < ps.executeUpdate()) {
                    request.setAttribute("add_success", "User registered !");
                } else {
                    request.setAttribute("add_failure", "User registration failed !");
                }
            }
            rs.close();
            ps.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            request.setAttribute("add_failure", "Something went wrong !");
            ex.printStackTrace(System.err);
        } catch (SQLException ex) {
            if(null != con && !con.isClosed()){
                con.close();
            }
            request.setAttribute("add_failure", "Something went wrong !");
            ex.printStackTrace(System.err);
        }
        request.getRequestDispatcher("pre-register.jsp").forward(request, response);
    }
%>
