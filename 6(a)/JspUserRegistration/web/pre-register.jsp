<form method="post" action="post-register.jsp">
    <table>
        <tr>
            <td>User Name</td>
            <td><input type="text" name="user" value="${param.user}"/></td>
            <td><font color="red">${user_reqd}</font></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="pass1" value="${param.pass1}"/></td>
            <td><font color="red">${pass1_reqd}</font></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="pass2" value="${param.pass2}"/></td>
            <td><font color="red">${pass2_reqd}</font></td>
        </tr>
        <tr>
            <td><input type="reset"/></td>
            <td><input type="submit"/></td>
            <td><font color="red">${other_err}</font></td>
        </tr>
    </table>
</form>