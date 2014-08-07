<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.SQLException"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.DriverManager"/>

<table>
    <tr>
        <th>User Id</th><th>User Name</th>
    </tr>
    <jsp:scriptlet>
        Connection con = null;
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "root");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select t.user_id, t.user_name from user_login t");
            while (rs.next()) {
    </jsp:scriptlet>
    <tr>
        <td><jsp:expression>rs.getInt(1)</jsp:expression></td>
        <td><jsp:expression>rs.getString(2)</jsp:expression></td>
    </tr>
    <jsp:scriptlet>
                count++;
            }
            rs.close();
            stm.close();
            con.close();
        } catch (ClassNotFoundException ex) {
    </jsp:scriptlet>
    <jsp:scriptlet>
            ex.printStackTrace(System.err);
        } catch (SQLException ex) {
    </jsp:scriptlet>
    <jsp:scriptlet>
            ex.printStackTrace(System.err);
            if (null != con && !con.isClosed()) {
                con.close();
            }
        }
    </jsp:scriptlet>
</table>
<p>
    Total count: [<jsp:expression>count</jsp:expression>] [<a href="pre-register.jsp">Register</a>]
</p>