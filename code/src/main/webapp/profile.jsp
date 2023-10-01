<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Information</title>
    <link rel="stylesheet" href="/css/profile.css">
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
   <form method="POST" action="profile">
       <div class="container">
           <div class="container_left">
               <div class="box_up">
                   <div class="box_up_1">
                       <img src="/img/user.png" id="userimg" alt="">
                   </div>
                   <div class="box_up_2">
                       <p name="name" id="username">${lastName}</p>
                       <a href="profile">
                           <i class="fa fa-pencil"></i>
                           Edit profile</a>
                   </div>
               </div>
               <div class="box-down">
                   <div class="stardust_dropdown_header">
                       <a href="profile">
                           <div>
                            <span id="macc">
                                <i class="fa-regular fa-user" style="color:rgb(97, 96, 96);"></i>
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
               <div class="myprofile">
                   <div class="profile">
                       <h1>
                           My profile
                       </h1>
                       <div>
                           <p>
                               Manage profile information for account security
                           </p>
                       </div>
                   </div>
                   <div class="content">
                       <div class="email">
                           <label for="email">Email</label>
                           <p name="email">${username} </p>
                       </div>
                       <div class="fullname">
                           <label for="fName">First Name</label>
                           <input name="firstName" placeholder="abc" value="${firstName}">
                       </div>
                       <div class="fullname">
                           <label for="lName">Last Name</label>
                           <input name="lastName" placeholder="fd" value="${lastName}">
                       </div>
                   </div>
                   <div class="confirm">
                       <a href="">
                           <button>
                               <span>Save</span>
                           </button>
                       </a>
                   </div>
               </div>

           </div>
       </div>
   </form>
</body>
</html>