<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<User> users = new UserDao().getAllUser();
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
        <h2>List of the users:</h2>
        <table width="100%">
            <thead>
            <tr>
                <td>ID</td>
                <td>Email</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Role</td>
                <td>Remove</td>
            </tr>
            </thead>
            <tbody>
            <%for (int i = 0; i < users.size(); i++) { %>
            <tr>
                <td><%=users.get(i).getId()%></td>
                <td><%=users.get(i).getEmail()%></td>
                <td><%=users.get(i).getFirstName()%></td>
                <td><%=users.get(i).getLastName()%></td>
                <td><%=users.get(i).getRole()%></td>
                <td>
                    <button class="remove">
                        <a href=<%="/delete?userId="+users.get(i).getId()%>>
                            <i class="fal fa-window-close fa-sm"></i>
                        </a>
                    </button>
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
