<%@ page import="com.btl.code.model.Product" %>
<%@ page import="com.btl.code.dao.ProductDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="HandheldFriendly" content="true">
    <title> Electroshop</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
    <link rel="icon" type="image/x-icon" href="/img/logo.png">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="slideshow-container">
        <div class="mySlides fade">
            <img src="img/banner/hero8.png" style="width:100%">
        </div>
        <div class="mySlides fade">
            <img src="img/banner/hero6.png" style="width:100%">
        </div>
        <div class="mySlides fade">
            <img src="img/banner/hero4.jpg" style="width:100%">
        </div>

    </div>
    <br>
    <div style="text-align:center">
        <span class="dot"></span>
        <span class="dot"></span>
        <span class="dot"></span>
    </div>
    <%@ include file="category.jsp" %>
    <%
        List<Product> productList = new ProductDao().getNewProduct();
        String title = "New product";
    %>
    <%@ include file="productList.jsp" %>
    <section id="banner" class="section-m1">
        <h4>1 Year Warranty For New Items This Year</h4>
        <h2>Chance to recive <span>50% OFF Coupon</span> when buying this month </h2>
        <button class="normal">FIND HERE!</button>

    </section>
    <section id="sm-banner">
        <a href="#"><img src="img/banner/Banner2.PNG" height="200" style="width:100%" class="pic" alt=""></a>
        <a href="#"><img src="img/banner/banner3.PNG" height="200" style="width:100%" class="pic1" alt=""></a>
        <a href="#"><img src="img/banner/banner4.PNG" height="200" style="width:100%" class="pic2" alt=""></a>
    </section>
    <section id="hero">
        <h4>Hot Offer</h4>
        <h1>Electronic Of the Season</h1>
        <h2>BUY NOW FOR UP TO 25% OFF !</h2>
        <a href="shop.jsp"><button>Start Buying</button></a>
    </section>
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