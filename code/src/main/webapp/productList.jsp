<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.btl.code.dao.CategoryDao" %>
<section id="product1" class="section-p1">
    <h2><%= title %></h2>
    <div class="pro-container">
        <%for (int i = 0; i < productList.size(); i++) { %>
        <div class="store-product">
            <a href=<%="/products?product=" + productList.get(i).getId()%>>
            <img src="<%= productList.get(i).getImage() %>" alt="">
            <div class="des">
                <span><%= new CategoryDao().getCategoryById(productList.get(i).getCategoryId()).getName() %></span>
                <h5><%= productList.get(i).getName() %></h5>
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h4><%= productList.get(i).getPrice() %>$</h4>
            </div>
            <a href=""><i class="fal fa-shopping-cart cart"></i></a>
            </a>
        </div>
        <%}%>
    </div>
</section>
