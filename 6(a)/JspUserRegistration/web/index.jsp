<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%
    Connection con = null;
    int count = 0;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "root");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select t.user_id, t.user_name from user_login t");
%>
<table>
    <tr>
        <th>User Id</th><th>User Name</th>
    </tr>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%=rs.getInt(1)%></td>
        <td><%=rs.getString(2)%></td>
    </tr>
    <%
            count++;
        }
    %>
</table>
<p>Total count: [<%=count%>] [<a href="pre-register.jsp">Register</a>]</p>
<%
    rs.close();
    stm.close();
    con.close();
} catch (ClassNotFoundException ex) {
%>
<p><font color="red">Something went wrong ...</font></p>
    <%
        ex.printStackTrace(System.err);
    } catch (SQLException ex) {
    %>
<p><font color="red">Something went wrong ...</font></p>
<%
        ex.printStackTrace(System.err);
        if (null != con && !con.isClosed()) {
            con.close();
        }
    }
%>