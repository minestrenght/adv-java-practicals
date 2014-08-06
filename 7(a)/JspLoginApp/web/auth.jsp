<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%
    RequestDispatcher rd = null;
    String user = request.getParameter("user");
    String pass = request.getParameter("pass");
    
    boolean proceed = true;
    if (null == user || user.trim().isEmpty()) {
        proceed = false;
        request.setAttribute("user_reqd", "User name is required !");
    }
    if (null == pass || pass.trim().isEmpty()) {
        proceed = false;
        request.setAttribute("pass_reqd", "Paasword is required !");
    }
    if (!proceed) {
        rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
        return;
    }

    proceed = false;
    Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "");
        PreparedStatement ps = con.prepareStatement("select t.* from user_login t where t.user_name=? and decode(t.user_pass, '*')=?");
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        proceed = rs.next();
        rs.close();
        ps.close();
        con.close();
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace(System.out);
    } catch (SQLException ex) {
        if (null != con && !con.isClosed()) {
            con.close();
        }
        ex.printStackTrace(System.out);
    }

    if(proceed) {
        rd = request.getRequestDispatcher("index.jsp");
    } else {
        rd = request.getRequestDispatcher("login.jsp");
        request.setAttribute("invalid_login", "User name/Password is incorrect !");
    }
    rd.forward(request, response);
%>
