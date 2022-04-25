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
    <title>Courses</title>
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
                                <li class="breadcrumb-item active" aria-current="page">Courses</li>
                            </ol>
                        </nav>
                    </div>
                </div>
                <!--end breadcrumb-->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row align-items-center">
                                    <div class="col-lg-3 col-xl-2">
                                        <a href="${rootAdmin}course/init-insert" class="btn btn-primary mb-3 mb-lg-0"><i class='bx bxs-plus-square'></i>New Product</a>
                                    </div>
                                    <div class="col-lg-9 col-xl-10">
                                        <form class="float-lg-end" method="post" action="${rootAdmin}course/search">
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
                        <div class="card">
                            <div class="card-body">
                                <table class="table table-borderless mb-0">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Image</th>
                                        <th scope="col">Price - Sale Price</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Time</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Author</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${course}" var="item" varStatus="loop">
                                            <tr>
                                                <th scope="row">${loop.index+1}</th>
                                                <td><a href="${rootAdmin}/course/detail?id=${item.id}" title="Click here to view detail...">${item.name}</a> </td>
                                                <td><img src="<c:url value="/public/images"/>/${item.image}" width="80" height="120" alt="course's img"></td>
                                                <td>${item.title}</td>
                                                <td>${item.status==true?"Active":"In active"}</td>
                                                <td>${item.times}</td>
                                                <td>${item.category.name}</td>
                                                <td>${item.teachers.name}</td>
                                                <td>
                                                    <a href="${rootAdmin}course/init-update?id=${item.id}"><i class="bx bxs-edit"></i></a>
                                                    <a href="${rootAdmin}course/delete?id=${item.id}"><i class="bx bx-trash-alt"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <nav aria-label="Page navigation example" class="align-self-center">
                                <ul class="pagination round-pagination">
                                    <li class="page-item" >
                                        <a class="page-link" href="${rootAdmin}course/page/${page-1}">Previous</a>
                                    </li>
                                    <c:forEach begin="1" end="${pages}" var="page">
                                        <li class="page-item"><a class="page-link" href="${rootAdmin}course/page/${page}">${page}</a>
                                        </li>
                                    </c:forEach>
                                    <li class="page-item"><a class="page-link" href="${rootAdmin}course/page/${page+1}">Next</a>
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
