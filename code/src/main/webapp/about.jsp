<%@ page import="com.btl.code.model.Product" %>
<%@ page import="com.btl.code.dao.ProductDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=11">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Electroshop</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <section id="page-header" class="about-head">
        <h2>#About Us</h2>
        <p>How we here</p>
    </section>
    <section id="about-head" class="section-p1">
        <img src="img/logo.png">
        <div>
            <h2>About Us</h2>
            <p> We will soon rule this world and more than that,the space about.But first i need you to help us by using
                our website to buy some products</p>
            <p>Creat your own imgages with as much as you like thank to something ...</p>

            <marquee bgcolor="#ccc" loop="-1" scrollamout="5" width="100%">Creat your own imgages with as much as you
                like thank to something ...
            </marquee>
        </div>
    </section>
    <%@ include file="category.jsp" %>
    <section id="newletter" class="section-p1 section-m1">
        <div class="newtext">
            <h4>Sign Up For Newletter</h4>
            <p>Get E-mail updates about our latest shop and <span>Special Offers.</span></p>
        </div>
        <div class="form">
            <input type="text" placeholder="Your email">
            <button class="normal">Sign Up</button>
        </div>
    </section>
    <%@ include file="footer.jsp" %>
    <script src="js/scripts.js"></script>
    <script src="js/slideshow.js"></script>
</body>
</html>
