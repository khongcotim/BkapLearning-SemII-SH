<%--
  Created by IntelliJ IDEA.
  User: bt289
  Date: 3/30/2022
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/admin/" var="rootAdmin"/>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--favicon-->
    <link rel="icon" href="<c:url value="/public/assetAdmin/images/favicon-32x32.png"/>" type="image/png" />
    <!--plugins-->
    <link href="<c:url value="/public/assetAdmin/plugins/vectormap/jquery-jvectormap-2.0.2.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/public/assetAdmin/plugins/simplebar/css/simplebar.css"/>" rel="stylesheet" />
    <link href="<c:url value="/public/assetAdmin/plugins/perfect-scrollbar/css/perfect-scrollbar.css"/>" rel="stylesheet" />
    <link href="<c:url value="/public/assetAdmin/plugins/metismenu/css/metisMenu.min.css"/>" rel="stylesheet" />
    <!-- loader-->
    <link href="<c:url value="/public/assetAdmin/css/pace.min.css"/>" rel="stylesheet" />
    <script src="<c:url value="/public/assetAdmin/js/pace.min.js"/>"></script>
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/public/assetAdmin/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/public/assetAdmin/css/bootstrap-extended.css"/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&amp;display=swap" rel="stylesheet">
    <link href="<c:url value="/public/assetAdmin/css/app.css"/>" rel="stylesheet">
    <link href="<c:url value="/public/assetAdmin/css/icons.css"/>" rel="stylesheet">
    <!-- Theme Style CSS -->
    <link rel="stylesheet" href="<c:url value="/public/assetAdmin/css/dark-theme.css"/>" />
    <link rel="stylesheet" href="<c:url value="/public/assetAdmin/css/semi-dark.css"/>" />
    <link rel="stylesheet" href="<c:url value="/public/assetAdmin/css/header-colors.css"/>" />
    <title>Teachers</title>
</head>
<body>
    <div class="wrapper">
        <jsp:include page="/WEB-INF/views/admin/layout/menu.jsp"/>
        <jsp:include page="/WEB-INF/views/admin/layout/header.jsp"/>

        <!--start page wrapper -->
        <div class="page-wrapper">
            <div class="page-content">
                <!--breadcrumb-->
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="${rootAdmin}"><i class="bx bx-home-alt"></i></a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Teachers</li>
                            </ol>
                        </nav>
                    </div>
                    <div class="ms-auto">
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary">Options</button>
                            <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
                            </button>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">
                                <a class="dropdown-item" href="${rootAdmin}teacher-manage/init-insert">Add new</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end breadcrumb-->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row align-items-center">
                                    <div class="col-lg-9 col-xl-10">
                                        <form class="float-lg-end" method="post" action="${rootAdmin}teacher-manage/search">
                                            <div class="row row-cols-lg-2 row-cols-xl-auto g-2">
                                                <div class="col">
                                                    <div class="position-relative">
                                                        <input type="text" name="key" class="form-control ps-5" placeholder="Search Any Course..."> <span class="position-absolute top-50 product-show translate-middle-y"><i class="bx bx-search"></i></span>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <button type="submit" class="btn btn-primary mb-3 mb-lg-0"><i class='bx bx-search-alt-2'></i>Search</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <span style="color: green; text-align: center">${notification}</span>
                </div>
                <div class="row">
                    <div class="col-xl-9 mx-auto">
                        <h6 class="mb-0 text-uppercase">All Teacher</h6>
                        <div class="card">
                            <div class="card-body">
                                <table class="table table-borderless mb-0">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Image</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Phone</th>
                                        <th scope="col">Gender</th>
                                        <th scope="col">Address</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${teachers}" var="item" varStatus="loop">
                                            <tr>
                                                <th scope="row">${loop.index+1}</th>
                                                <td><a href="${rootAdmin}/teacher-manage/detail?id=${item.id}" > ${item.name}</a></td>
                                                <td><img src="<c:url value="/public/images/teachers/"/>${item.avatar}" width="80" height="120" alt=""></td>
                                                <td>${item.email}</td>
                                                <td>${item.phone}</td>
                                                <td>${item.gender==true?"Nam":"Nữ"}</td>
                                                <td>${item.address}</td>
                                                <td>
                                                    <a href="${rootAdmin}teacher-manage/init-update?id=${item.id}"><i class="bx bxs-edit"></i></a>
                                                    <a href="${rootAdmin}teacher-manage/delete?id=${item.id}"><i class="bx bx-trash-alt"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <nav aria-label="Page navigation example" class="align-self-center">
                                <ul class="pagination round-pagination">
                                    <li class="page-item" >
                                        <a class="page-link" href="${rootAdmin}teacher-manage/page/${page-1}">Previous</a>
                                    </li>
                                    <c:forEach begin="1" end="${pages}" var="page">
                                        <li class="page-item"><a class="page-link" href="${rootAdmin}teacher-manage/page/${page}">${page}</a>
                                        </li>
                                    </c:forEach>
                                    <li class="page-item"><a class="page-link" href="${rootAdmin}teacher-manage/page/${page+1}">Next</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <!--end row-->
            </div>
        </div>
        <!--end page wrapper -->
        <!--start overlay-->
        <div class="overlay toggle-icon"></div>
        <!--end overlay-->

        <!--Start Back To Top Button-->
        <a href="javaScript:;" class="back-to-top"><i class='bx bxs-up-arrow-alt'></i></a>
        <!--End Back To Top Button-->

        <jsp:include page="/WEB-INF/views/admin/layout/footer.jsp"/>
    </div>
    <jsp:include page="/WEB-INF/views/admin/layout/plugins.jsp"/>
</body>
</html>
