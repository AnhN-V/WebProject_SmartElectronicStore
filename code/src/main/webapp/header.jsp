<%@ page import="com.btl.code.dao.UserDao" %>
<%@ page import="com.btl.code.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  UserDao userDao = new UserDao();
  String username = null;
  String name = null;
  User user = null;
  boolean isAdmin = false;
  if(session.getAttribute("username") != null) {
    username = (String)session.getAttribute("username");
    user = userDao.getUserByEmail(username);
    if(user != null) {
      name = user.getLastName();
      isAdmin = user.getRole().equals("ROLE_ADMIN");
    }
  }
%>
<nav id="navbar_1">
  <p>Welcome to Smart Electronic Store</p>
  <i class="fas fa-map-marker-alt" style="color: #696969;"></i>
  <a href="">Store Locator</a>
  <i class="far fa-truck" style="color: #696969;"></i>
  <%if(username != null){%>
  <a href="order.jsp">Track your Order</a>
  <%}else {%>
  <a href="login.jsp">Track your Order</a>
  <%}%>
</nav>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="managerUser.jsp"><i class="fa fa-fw fa-shopping-cart"></i>Manage User</a>
  <a href="managerOrder.jsp"><i class="fa fa-fw fa-envelope"></i>Manage Order</a>
  <a href="/product-manger?page=1"><i class="fa fa-fw fa-wrench"></i>Manage Product</a>
</div>
<section id="header">
  <a  href="/"><img src="img/logo.png" class="logo logo_header" height="120" alt=""></a>
  <ul id="navbar">
    <% if(isAdmin){ %>
    <li><span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span></li>
    <% } %>
    <li><a href="/">Home</a></li>
    <li><a href="/shop?page=1">Shop</a></li>
    <li><a href="about.jsp">About</a></li>
    <li><a href="contact.jsp">Contact</a></li>
    <div class="search">
      <form action="/search" method="post" class="search_bar">
        <input type="text"
               placeholder=" Search..."
               name="name">
        <button type="submit">
          <i class="fa fa-search"
             style="font-size: 18px;">
          </i>
        </button>
      </form>
    </div>
    <%if(username != null) {%>
    <li><a href="cart.jsp"><i class="far fa-shopping-bag"></i></a></li>
    <%}%>
  </ul>
  <%if(username == null) {%>
  <div id="login">
    <i class="fas fa-user" style="color: #696969;"></i>
    <a href="" class="account">My Account</a>
    <ul class="submenu">
      <li><a href="login.jsp">Login</a></li>
      <li><a href="login.jsp">Sign up</a></li>
    </ul>
  </div>
  <%} else {%>
  <div id="login">
    <i class="fas fa-user" style="color: #696969;"></i>
    <a href="" class="account">Hi, <%= name %></a>
    <ul class="submenu">
      <li><a href="/profile">My account</a></li>
      <li><a href="/logout">Log out</a></li>
    </ul>
  </div>
  <%}%>
</section>
