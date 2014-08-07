<jsp:scriptlet>
    String user = request.getParameter("user");
    String pass1 = request.getParameter("pass1");
    String pass2 = request.getParameter("pass2");

    boolean proceed = true;

    if(null == user || user.trim().isEmpty()){
        proceed = false;
        request.setAttribute("user_reqd", "User name is required !");
    }
    if(null == pass1 || pass1.trim().isEmpty()){
        proceed = false;
        request.setAttribute("pass1_reqd", "Password is required !");
    }
    if(null == pass2 || pass2.trim().isEmpty()){
        proceed = false;
        request.setAttribute("pass2_reqd", "Confirm password is required !");
    }

    if(proceed && !pass1.equals(pass2)) {
        proceed = false;
        request.setAttribute("other_err", "Password & Confirm password don't match !");
    }

    if(!proceed){
        request.getRequestDispatcher("pre-register.jsp").forward(request, response);
        return;
    }
</jsp:scriptlet>
pending ...