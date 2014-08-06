<form method="post" action="auth.jsp">
    <table>
        <tr>
            <td>User Name</td>
            <td><input type="text" name="user" value="${param.user}"/></td>
            <td><font color="red">${user_reqd}</font></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="pass" value="${param.pass}"/></td>
            <td><font color="red">${pass_reqd}</font></td>
        </tr>
        <tr>
            <td>
                <input type="reset"/>
            </td>
            <td>
                <input type="submit"/>
            </td>
            <td><font color="red">${invalid_login}</font></td>
        </tr>
    </table>
</form>
