<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ChangePassword</title>
    <link rel="stylesheet" href="/css/changepassword.css">
    <link rel="stylesheet" href="css/toast_message.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/9544c6182b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">

</head>

<body>
    <div class="wrap">
    </div>
    <%@ include file="header.jsp" %>
    <form method="post" action="changepassword">
        <div class="container">
            <div class="container_left">
                <div class="box_up">
                    <div class="box_up_1">
                        <img src="/img/user.png" id="userimg" alt="">
                    </div>
                    <div class="box_up_2">
                        <p name="name" id="username">${lastName}</p>
                        <a href="profile.jsp">
                            <i class="fa fa-pencil"></i>
                            Edit profile</a>
                    </div>
                </div>
                <div class="box-down">
                    <div class="stardust_dropdown_header">
                        <a href="" >
                            <div>
                            <span id="macc">
                                <i class="fa-regular fa-user" style="color: rgb(97, 96, 96);"></i>
                                My Account </span>
                            </div>
                        </a>
                    </div>
                    <div class="stadust_dropdown_body">
                        <div class="isddb">
                            <a href="profile">
                                <span id="info">Infomation</span>
                            </a>
                            <a href="changepassword">
                                <span id="chpa">Change Password</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container_right">
                <div class="changepassword">
                    <div class="announcement">
                        <h1>
                            Change your password
                        </h1>
                        <div>
                            <p>
                                For account security, please do not share your password with others
                            </p>
                        </div>
                    </div>
                </div>
                <div class="content">
                    <div class="present_password">
                        <label for="">
                            Present password
                        </label>
                        <input type="password" name="password" id="pass" >
                        <i class="far fa-eye" id="togglePassword"></i>
                    </div>
                    <div class="new_password">
                        <label for="">
                            New password
                        </label>
                        <input type="password"  name="new_pass">

                    </div>
                    <div class="re_password">
                        <label for="">Re-Password</label>
                        <input type="password"  name="re_pass">

                    </div>
                </div>
                <div class="confirm">
                    <a href="">
                        <button >Confirm</button>
                    </a>
                </div>
            </div>
    </form>

    </div>
    <!-- hide password -->
    <script>
        const togglePassword = document.querySelector('#togglePassword');
        const password = document.querySelector('#pass');

        togglePassword.addEventListener('click', function (e) {
            const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
            password.setAttribute('type', type);
            this.classList.toggle('fa-eye-slash');
        });
    </script>
    <%
        String status = "";
        if(request.getAttribute("status") != null) {
            status = request.getAttribute("status").toString();
        }
    %>

    <script>
        <% if (status.equals("10")) { %>
        alert("Incorrect current password");
        <% } else if (status.equals("11")) { %>
        alert("re_password and new_password do not match");
        <% } else if (status.equals("12")) { %>
        alert("Success");
        <% } %>
    </script>
</body>

</html>