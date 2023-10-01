<%@ page import="java.util.List" %>
<%@ page import="com.btl.code.model.Product" %>
<%@ page import="com.btl.code.dao.ProductDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
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
    <section id="cart" class="section-p1">
        <h2>List of the products:</h2>
        <div id="adding">
            <button class="Addst"><a href="popup.jsp">Add Product</a></button>
        </div>
        <table width="100%">
            <thead>
            <tr>
                <td>ID</td>
                <td>Image</td>
                <td>Product Name</td>
                <td>Price</td>
                <td>Edit</td>
                <td>Remove</td>
            </tr>
            </thead>
            <tbody>
            <%for (int i = 0; i < products.size(); i++) { %>
            <tr>
                <td><%=products.get(i).getId()%></td>
                <td><img src=<%=products.get(i).getImage()%>></td>
                <td><%=products.get(i).getName()%></td>
                <td><%=products.get(i).getPrice()%>$</td>
                <td>
                    <button class="remove">
                        <a href=<%="/edit-product?productId="+products.get(i).getId()%>>
                            <i class="fal fa-edit"></i>
                        </a>
                    </button>
                </td>
                <td>
                    <button class="remove">
                        <a href=<%="/delete-product?productId="+products.get(i).getId()%>>
                            <i class="fal fa-window-close fa-sm"></i>
                        </a>
                    </button>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </section>
    <div id="paging">
        <div class="pgn">
            <button type="button" class="prev"><i class="fal fa-arrow-left fa-sm"></i></button>
            <button type="button" class="next"><i class="fal fa-arrow-right fa-sm"></i></button>
            <div class="pages">
                <div class="page-container">
                    <%for (int i = 1; i <= (int)request.getAttribute("totalPage"); i++) {
                        if(Integer.parseInt(request.getParameter("page")) == i){%>
                    <button type="button" class="btn-page active">
                        <a href=<%= "/product-manger?page="+ i %>><%= i %></a>
                    </button>
                    <%} else {%>
                    <button type="button" class="btn-page">
                        <a href=<%= "/product-manger?page="+ i %>><%= i %></a>
                    </button>
                    <%}}%>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
    <script src="js/scripts.js"></script>
    <script src="js/paging.js"></script>
</body>
</html>
