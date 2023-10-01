<%@ page import="com.btl.code.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object product = request.getAttribute("product");
    Product p = null;
    if(product == null) {
        System.out.println("Đây là add");
    } else {
        p = (Product) product;
        System.out.println("Đây là sửa");
    }
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Product</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/ManageProduct.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
</head>

<body>
    <%@ include file="header.jsp" %>
    <div class="container">
        <form class="information" action=<%= product == null ? "/add-product" : "/edit-product?productId="+p.getId()%> method="post">
            <%if(product != null){%>
            <h1 name="username">Edit Product</h1>
            <%}else {%>
            <h1 name="username">Add Product</h1>
            <%}%>
            <div class="add_info">
                <%if(product != null){%>
                <div class="id_product">
                    <label>Product's ID</label>
                    <input type="text" name="id_product" disabled value=<%=p.getId()%>>
                </div>
                <%}%>
                <%if(product != null){%>
                <div class="name_product">
                    <label>
                        Name
                    </label>
                    <input type="text" name="name_product" placeholder="Name of product" value=<%=p.getName()%>>
                </div>
                <%}else {%>
                <div class="name_product">
                    <label>
                        Name
                    </label>
                    <input type="text" name="name_product" placeholder="Name of product">
                </div>
                <%}%>
                <%if(product != null){%>
                <div class="name_product">
                    <label>
                        Description
                    </label>
                    <input type="text" name="description_product" placeholder="Description of product" value=<%=p.getDescription()%>>
                </div>
                <%}else {%>
                <div class="name_product">
                    <label>
                        Description
                    </label>
                    <input type="text" name="description_product" placeholder="Description of product">
                </div>
                <%}%>
                <%if(product != null){%>
                <div class="name_product">
                    <label>
                        Price
                    </label>
                    <input type="text" name="price_product" placeholder="Price of product" value=<%=p.getPrice()%>>
                </div>
                <%}else {%>
                <div class="name_product">
                    <label>
                        Price
                    </label>
                    <input type="text" name="price_product" placeholder="Price of product">
                </div>
                <%}%>
                <%if(product != null){%>
                <div class="name_product">
                    <label >
                        Image
                    </label>
                    <input type="text" name="img_product" placeholder="img/products/abc.jpg" value=<%=p.getImage()%>>
                </div>
                <%}else {%>
                <div class="name_product">
                    <label >
                        Image
                    </label>
                    <input type="text" name="img_product" placeholder="img/products/abc.jpg">
                </div>
                <%}%>
                <%if(product != null){%>
                <div class="name_product">
                    <label>
                        Category Id
                    </label>
                    <input type="text" name="category_id" placeholder="Category Id of product" value=<%=p.getCategoryId()%>>
                </div>
                <%}else {%>
                <div class="name_product">
                    <label>
                        Category Id
                    </label>
                    <input type="text" name="category_id" placeholder="Category Id of product">
                </div>
                <%}%>
            </div>
            <%if(product != null){%>
            <button type="submit" class="button confirm_button">
                <span>Update</span>
            </button>
            <%}else {%>
            <button type="submit" class="button confirm_button">
                <span>Add</span>
            </button>
            <%}%>
        </form>
    </div>
    <%@ include file="footer.jsp" %>
    <script src="js/scripts.js"></script>
</body>
</html>
