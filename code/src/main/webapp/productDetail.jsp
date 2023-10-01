<%@ page import="com.btl.code.model.Product" %>
<%@ page import="com.btl.code.model.Category" %>
<%@ page import="com.btl.code.dao.CategoryDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.btl.code.dao.ProductDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    String category = new CategoryDao().getCategoryById(product.getCategoryId()).getName();
%>
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
    <section id="prodetails" class="section-p1">
        <div class="image-container" id="img-container">
            <img src=<%=product.getImage()%> width="100%" id="featured">
        </div>
        <div class="detailspro">
            <h6>Categories/<%=category%></h6>
            <h4><%=product.getName()%></h4>
            <h2><%=product.getPrice()%>$</h2>
            <% if(user != null) {%>
            <form action="/addToCart" method="post">
                <input type="text" name="productId" hidden value=<%=product.getId()%>>
                <input type="text" name="userId" hidden value=<%=user.getId()%>>
                <input type="number" name="quantity" value="1">
                <button class="normal">Add to cart</button>
            </form>
            <%}%>
            <h4><%=product.getDescription()%></h4>
            <span>Fingertip controls: On-speaker volume and bass.</span>
        </div>
    </section>
    <%
        List<Product> products = new ProductDao().getAllProductByCategoryId(product.getCategoryId());
        List<Product> productList = new ArrayList<>();
        int count = 0;
        for(Product p : products) {
            if(count == 4) {
                break;
            }
            if(product.getId() != p.getId()) {
                productList.add(p);
                count++;
            }
        }
        String title = "Featured Products";
    %>
    <%@ include file="productList.jsp" %>
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
</body>
</html>
