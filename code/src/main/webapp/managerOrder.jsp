<%@ page import="java.util.List" %>
<%@ page import="com.btl.code.model.Order" %>
<%@ page import="com.btl.code.dao.OrderDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Order> orders = new OrderDao().getAllOrder();
    int totalPriceAll = 0;
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
        <h2>List of the order:</h2>
        <table width="100%">
            <thead>
            <tr>
                <td>ID</td>
                <td>Order Time</td>
                <td>Status</td>
                <td>Total</td>
            </tr>
            </thead>
            <tbody>
            <%for (int i = 0; i < orders.size(); i++) {
                totalPriceAll+=orders.get(i).getTotal();
            %>
            <tr>
                <td><%=orders.get(i).getId()%></td>
                <td><%=orders.get(i).getOrderTime()%></td>
                <td><%=orders.get(i).getStatus()%></td>
                <td><%=orders.get(i).getTotal()%>$</td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <h3 class="totalPriceAllOrder">Total: <%=totalPriceAll%>$</h3>
    </section>
    <%@ include file="footer.jsp" %>
    <script src="js/scripts.js"></script>
</body>
</html>
