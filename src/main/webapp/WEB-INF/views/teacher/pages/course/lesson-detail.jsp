<%--
  Created by IntelliJ IDEA.
  User: bt289
  Date: 4/5/2022
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
                        <div class="col-md-6 col-lg-4 mb-3">
                            <div class="card">
                                <h5 class="card-header">Video</h5>
                                <div class="card-body">
                                    <iframe width="300" height="500" src="${lessonsFound.link_video}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-3">
                            <div class="nav-align-top mb-4">
                                <ul class="nav nav-pills mb-3 nav-fill" role="tablist">
                                    <li class="nav-item">
                                        <button type="button" class="nav-link active" role="tab" data-bs-toggle="tab" data-bs-target="#navs-pills-justified-home" aria-controls="navs-pills-justified-home" aria-selected="true"><i class="tf-icons bx bx-detail"></i> Detail </button>
                                    </li>
                                    <li class="nav-item">
                                        <button type="button" class="nav-link" role="tab" data-bs-toggle="tab" data-bs-target="#navs-pills-justified-profile" aria-controls="navs-pills-justified-profile" aria-selected="false"><i class="tf-icons bx bx-book"></i> Profile</button>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane fade show active" id="navs-pills-justified-home" role="tabpanel">
                                        <span style="color: green">${notification}</span>
                                        <p>
                                            ${lessonsFound.name}
                                        </p>
                                        <p class="mb-0">
                                            ${lessonsFound.times}
                                        </p>
                                    </div>
                                    <div class="tab-pane fade" id="navs-pills-justified-profile" role="tabpanel">
                                        <h2>Give Exercise for student</h2>
                                        <div class="card mb-4">
                                            <h5 class="card-header">Basic</h5>
                                            <div class="card-body">
                                                <form action="${rootTeacher}course-manager/lesson/${lessonsFound.id}" class="dropzone needsclick" id="dropzone-basic" method="post" enctype="multipart/form-data">
                                                    <div class="dz-message needsclick">
                                                        Drop files here or click to upload
                                                        <span class="note needsclick">(This is just a demo dropzone. Selected files are
                                                        <strong>not</strong> actually uploaded.)</span>
                                                    </div>
                                                    <div class="row mb-3">
                                                        <label for="inputEnterYourName" class="col-sm-3 col-form-label">Title</label>
                                                        <div class="col-sm-9">
                                                            <input name="title" class="form-control" id="inputEnterYourName" placeholder="Please type title!!">
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3">
                                                        <label for="inputEnterYourName" class="col-sm-3 col-form-label">Times</label>
                                                        <div class="col-sm-9">
                                                            <input name="times" class="form-control" placeholder="Please enter time!!">
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3">
                                                        <label for="inputEnterYourName" class="col-sm-3 col-form-label">Max mark</label>
                                                        <div class="col-sm-9">
                                                            <input name="mark" type="number" class="form-control" placeholder="Mark must from 10-100!">
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3">
                                                        <label for="inputEnterYourName" class="col-sm-3 col-form-label">File Exercise</label>
                                                        <div class="col-sm-9">
                                                            <input name="file" type="file" />
                                                        </div>
                                                    </div>
                                                    <button type="submit" class="bg bg-primary">Submit</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
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
