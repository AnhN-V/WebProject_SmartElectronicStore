<%@ page import="java.util.List" %>
<%@ page import="com.btl.code.model.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.btl.code.dao.OrderDao" %>
<%@ page import="com.btl.code.dao.OrderDetailDao" %>
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
        List<Order> orders = new OrderDao().getOrder(user.getId());
        if(orders.isEmpty()) {
            orders = new ArrayList<>();
        }
        Object title = request.getAttribute("title");
        if(title == null) {
            title = "Order more to get great discount!";
        } else {
            title = title.toString();
        }
    %>
    <section id="page-header">
        <h2><%=title%></h2>
    </section>
    <section id="odercart" class="section-p1">
        <h2>List of oder:</h2>
        <table style=" margin-left:auto;
    margin-right:auto;"  width="50%">
            <thead>
            <tr>
                <td>Oders</td>
            </tr>
            </thead>
            <tbody>
            <% if(orders.isEmpty()) {%>
            <h3>Hiện tại bạn chưa có đơn hàng nào.</h3>
            <%}%>

            <%for (int i = 0; i < orders.size(); i++) { %>
            <tr class="all">
                <td>
                    <table class="oderdt">
                        <tr>
                            <td>Oder ID:</td>
                            <td>#<%=orders.get(i).getId()%></td>
                        </tr>
                        <tr>
                            <td>Products:</td>
                            <td><%= new OrderDetailDao().getProductName(orders.get(i).getId())%></td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td><%=orders.get(i).getStatus()%></td>
                        </tr>
                        <tr>
                            <td><strong>Total:</strong></td>
                            <td><strong><%=orders.get(i).getTotal()%>$</strong></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </section>
    <%@ include file="footer.jsp" %>
    <script src="js/scripts.js"></script>
</body>
</html>
