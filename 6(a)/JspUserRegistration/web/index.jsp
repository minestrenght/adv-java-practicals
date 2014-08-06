<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<table>
    <tr>
        <th>User Id</th><th>User Name</th>
    </tr>
    <%
        Connection con = null;
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select t.user_id, t.user_name from user_login t");
            while (rs.next()) {
                out.print("<tr>");
                out.print("<td>");
                out.print(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString(2));
                out.print("</td>");
                out.print("</tr>");
                count++;
            }
            rs.close();
            stm.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            out.print("<p>Something went wrong ...</p>");
            ex.printStackTrace(System.err);
        } catch (SQLException ex) {
            out.print("<p>Something went wrong ...</p>");
            ex.printStackTrace(System.err);
            if (null != con && !con.isClosed()) {
                con.close();
            }
        }
    %>
</table>
<p>
    Total count: [<%=count%>] [<a href="pre-register.jsp">Register</a>]
</p>