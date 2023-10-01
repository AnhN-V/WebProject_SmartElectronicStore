<%@ page import="com.btl.code.dao.CategoryDao" %>
<%@ page import="com.btl.code.model.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CategoryDao categoryDao = new CategoryDao();
    List<Category> list = categoryDao.getAllCategory();
%>
<section id="summary" class="section-p1">
    <%for (int i = 0; i < list.size(); i++) {%>
        <a href=<%= "/categories?category="+ list.get(i).getId() %>>
            <div class="sum-box">
                <img src="<%= list.get(i).getImgPath() %>" alt="" width="150" height="100">
                <h6><%= list.get(i).getName() %></h6>
            </div>
        </a>
    <%}%>
</section>
