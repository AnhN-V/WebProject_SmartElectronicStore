<%@ page import="java.util.List" %>
<%@ page import="com.btl.code.model.Product" %>
<%@ page import="com.btl.code.dao.ProductDao" %>
<%@ page import="com.btl.code.dao.CartItemDao" %>
<%@ page import="com.btl.code.model.CartItem" %>
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
    <%
        List<CartItem> list = new CartItemDao().getAllItemInCart(user.getId());
        Integer totalPrice = 0;
    %>
    <section id="page-header" class="about-head">
        <h2>#Checkout now</h2>
        <p>Order now to get more offers.</p>
    </section>
    <section id="cart" class="section-p1">
        <table width="100%">
            <thead>
            <tr>
                <td>Image</td>
                <td>Products</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Subtotal</td>
            </tr>
            </thead>
            <tbody>
            <%for (int i = 0; i < list.size(); i++) { %>
            <%
                Product product = new ProductDao().getProductById(list.get(i).getProductId());
                totalPrice+=product.getPrice()*list.get(i).getQuantity();
            %>
            <tr>
                <td><img src=<%=product.getImage()%>></td>
                <td><%=product.getName()%></td>
                <td><%=product.getPrice()%>$</td>
                <td><%=list.get(i).getQuantity()%></td>
                <td><%=product.getPrice()%>$</td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </section>
    <section id="cart-add" class="section-p1">
        <div id="sub-total">
            <h3>Cart Totals</h3>
            <table>
                <tr>
                    <td>Cart Subtotal</td>
                    <td><%=totalPrice%>$</td>
                </tr>
                <tr>
                    <td>Shipping</td>
                    <td>Free</td>
                </tr>
                <tr>
                    <td><strong>Total</strong></td>
                    <td><strong><%=totalPrice%>$</strong></td>
                </tr>
            </table>
            <%if(list.isEmpty()){%>
            <button class="normal">Confirm Checkout</button>
            <%}else {%>
            <button class="normal"><a href=<%="/checkout?userId="+user.getId()%>>Confirm Checkout</a></button>
            <%}%>
        </div>
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
</body>
</html>
