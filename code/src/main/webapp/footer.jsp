<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="section-p1">
    <div class="col">
        <img class="logo" src="img/logo.png" height="200" alt="">
    </div>
    <div class="col">
        <h4>Contact</h4>
        <p><strong>Address: </strong> 87/9 Tan Xuan,Xuan Dinh, Ha Noi.</p>
        <p><strong>Phone: </strong> 09899982351.</p>
        <p><strong>Hour </strong> 8:00-19:00,Mon - Sat.</p>
    </div>
    <div class="col">
        <h4>About</h4>
        <a href="contact.jsp">Contact us</a>
        <a href="#">Terms & Conditions</a>
        <a href="#">Privacy Policy</a>

    </div>
    <div class="col">
        <h4>My Account</h4>
        <%if(username == null) {%>
        <a href="login.jsp">Sign In</a>
        <%}%>
        <a href="cart.jsp">View Cart</a>
        <a href="#">Help</a>
    </div>
    <div class="copyright">
        <div class="follow">
            <div class="icon">
                <a href="#"><i class="fab fa-facebook-f"></i></a>
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
                <a href="#"><i class="fab fa-youtube"></i></a>
            </div>
        </div>
        <p>© Electro - All Rights Reserved</p>
    </div>
</footer>
