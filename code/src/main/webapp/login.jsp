<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies=request.getCookies();
    String userName = "", password = "",rememberVal="";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("cookuser")) {
                userName = cookie.getValue();
            }
            if(cookie.getName().equals("cookpass")){
                password = cookie.getValue();
            }
            if(cookie.getName().equals("cookrem")){
                rememberVal = cookie.getValue();
            }
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>log_reg</title>
    <link rel="stylesheet" href="css/log_reg.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/toast_message.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
</head>
<body>
    <div class="wrap">
    </div>
    <%@ include file="header.jsp" %>
    <div class="customer-login-form">
        <div class="or-text">
            <span>or</span>
        </div>
        <div class="column-set">
            <div class="column1">
                <form action="/login" method="post" class="loginform">
                    <div class="login_title">
                        <h1>Login</h1>
                    </div>
                    <div class="welcome">
                        <p>Welcome back! Sign in to your account.</p>
                    </div>
                    <div class="username_or_email">
                        <label for="username">Username or email address *</label>
                        <input type="text" name="username" id="username" value="<%=userName%>">
                    </div>
                    <div class="password">
                        <label for="password">Password *</label>
                        <input type="password" name="password" id="password" value="<%=password%>">
                    </div>
                    <div class="remember">
                        <input type="checkbox" name="remember" id="checkbox"
                               value="1"
                            <%= "1".equals(rememberVal.trim()) ? "checked=\"checked\"" : "" %>
                        >
                        <span>Remember me</span>
                    </div>
                    <a href="" class="login">
                        <button>Log in</button>
                    </a>
                    <a href="forgot.jsp" class="forgot">Forgot your password?</a>
                </form>
            </div>

            <div class="column2">
                <form action="/sign-up" class="registerform" method="post">
                    <div class="register_title">
                        <h1>Register</h1>
                    </div>
                    <div class="create_message">
                        <p>Create new account today to reap the benefits of a personalized shopping experience.</p>
                    </div>
                    <div class="email">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email">
                    </div>
                    <div class="email">
                        <label for="first_name">First Name</label>
                        <input type="text" id="first_name" name="first_name">
                    </div>
                    <div class="email">
                        <label for="last_name">Last name</label>
                        <input type="text" id="last_name" name="last_name">
                    </div>
                    <div class="password">
                        <label for="password">Password</label>
                        <input type="password" id="pass" name="password">
                    </div>
                    <div class="password">
                        <label for="re-password">Re-Password</label>
                        <input type="password" id="re-password" name="re-password">
                    </div>
                    <div class="commit">
                        <p>Your personal data will be protected in our privacy policy.</p>
                    </div>
                    <button class="register_button" >Register</button>
                </form>
            </div>
        </div>
    </div>
    <%
        String status = "";
        if(request.getAttribute("status") != null) {
            status = request.getAttribute("status").toString();
        }
    %>
    <%@ include file="toast_message.jsp" %>
    <%if(status.equals("1")) { %>
    <script>
        showalertdk()
    </script>
    <%}%>
    <%if(status.equals("2")) { %>
    <script>
        showalerthdk()
    </script>
    <%}%>
    <%if(status.equals("6")) { %>
    <script>
        showalertNotFoundEmail()
    </script>
    <%}%>
    <%if(status.equals("7")) { %>
    <script>
        showalertResetPassword()
    </script>
    <%}%>
</body>
</html>