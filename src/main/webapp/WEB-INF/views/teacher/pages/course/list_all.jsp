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
                    <!-- Examples -->
                    <div class="row mb-5">
                        <c:forEach items="${courseLst}" var="course">
                            <div class="col-md-6 col-lg-4 mb-3">
                                <div class="card h-100">
                                    <img class="card-img-top" src="<c:url value="/public/images/"/>${course.image}" alt="Card image cap" />
                                    <div class="card-body">
                                        <h5 class="card-title">${course.name}</h5>
                                        <p class="card-text">
                                            ${course.title}
                                        </p>
                                        <a href="${rootTeacher}course-manager/detail/${course.id}" class="btn btn-outline-primary">Detail</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Examples -->
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
<jsp:include page="/WEB-INF/views/teacher/layout/script.jsp"></jsp:include>

</body>

</html>
