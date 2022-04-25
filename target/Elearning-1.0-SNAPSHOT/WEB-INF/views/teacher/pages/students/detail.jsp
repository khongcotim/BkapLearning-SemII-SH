<%--
  Created by IntelliJ IDEA.
  User: bt289
  Date: 4/5/2022
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="rootTeacher" value="/teacher/"></c:url>
<!DOCTYPE html>
<html lang="en"  class="light-style layout-navbar-fixed layout-menu-fixed " dir="ltr" data-theme="theme-default" data-assets-path="<c:url value="/public/assetsTeacher/" />" data-template="vertical-menu-template">
<head>
    <jsp:include page="/WEB-INF/views/teacher/layout/pluginHeader.jsp"></jsp:include>
</head>
<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->

        <jsp:include page="/WEB-INF/views/teacher/layout/menu.jsp"></jsp:include>
        <!-- / Menu -->
        <!-- Layout container -->
        <div class="layout-page">
            <!-- Navbar -->
            <jsp:include page="/WEB-INF/views/teacher/layout/header.jsp"></jsp:include>
            <!-- / Navbar -->

            <!--start page wrapper -->
            <div class="content-wrapper">
                <div class="container-xxl flex-grow-1 container-p-y">
                    <div class="card"></div>
                    <div class="page-content">
                        <!--end breadcrumb-->
                        <div class="row">
                            <span style="color: green; text-align: center">${notification}</span>
                        </div>
                        <div class="table-responsive text-nowrap">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Gender</th>
                                    <th>Address</th>
                                    <th>Birthday</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody class="table-border-bottom-0">
                                    <c:forEach items="${students}" var="item" varStatus="loop">
                                        <tr>
                                            <td>${loop.index+1}</td>
                                            <td>${item.id}</td>
                                            <td>${item.name}</td>
                                            <td>${item.email}</td>
                                            <td>${item.phone}</td>
                                            <td>${item.gender==true?"Nam":"Nữ"}</td>
                                            <td>${item.address}</td>
                                            <td>${item.birthday}</td>
                                            <td>
                                                <a href="${rootTeacher}student-manage/init-update?id=${item.id}"><i class="bx bxs-edit"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!--end row-->
                    </div>
                </div>

            </div>
            <!--end page wrapper -->
        </div>
        <!-- / Layout page -->
    </div>
    <!-- Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>
    <!-- Drag Target Area To SlideIn Menu On Small Screens -->
    <div class="drag-target"></div>
</div>
<!-- / Layout wrapper -->
<div class="buy-now">
    <a href="https://1.envato.market/frest_admin" target="_blank" class="btn btn-danger btn-buy-now">Buy Now</a>
</div>
<jsp:include page="/WEB-INF/views/teacher/layout/script.jsp"></jsp:include>

</body>

</html>
