<%--
  Created by IntelliJ IDEA.
  User: bt289
  Date: 3/30/2022
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="rootpath" />
<div class="main-menu">
    <div class="menu-logo">
        <a href="${rootpath}"><img src="<c:url value="/public/assets/images/logo-both-color.png" />" alt="logo"></a>
    </div>
    <ul>
        <li><a href="${rootpath}">home</a></li>
        <li><a href="${rootpath}about.html">about</a></li>
        <li class="have-submenu"><a href="#">course</a>
            <ul class="sub-menu">
                <li><a href="#">web development</a></li>
                <li><a href="#">education</a></li>
                <li><a href="#">business</a></li>
                <li><a href="#">banking</a></li>
                <li><a href="#">corporate</a></li>
                <li><a href="#">consulting</a></li>
                <li><a href="#">marketing</a></li>
                <li><a href="#">photography</a></li>
                <li><a href="#">music</a></li>
            </ul>
        </li>
        <li><a href="${rootpath}package.html">package</a></li>
        <li><a href="${rootpath}instructor-details.html">instructor details</a></li>
        <li><a href="${rootpath}cart.html">cart</a></li>
        <li><a href="${rootpath}purchase.html">purchase</a></li>
        <li><a href="${rootpath}blog.html">blog</a></li>
        <li><a href="${rootpath}contact.html">contact</a></li>
        <li><a href="${rootpath}login.html">log in</a></li>
        <li><a href="${rootpath}sign-up">sign up</a></li>
        <li><a href="${rootpath}logout.html">Log Out</a></li>
    </ul>
</div>