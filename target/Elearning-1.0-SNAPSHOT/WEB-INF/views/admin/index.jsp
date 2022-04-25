<%--
  Created by IntelliJ IDEA.
  User: bt289
  Date: 3/30/2022
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Admin</title>
</head>
<body>
    <div class="wrapper">
        <jsp:include page="/WEB-INF/views/admin/layout/menu.jsp"/>
        <jsp:include page="/WEB-INF/views/admin/layout/header.jsp"/>

        <div class="page-wrapper">
            <div class="page-content">
                <h1 style="color: red">${notification}</h1>
                <div class="row row-cols-1 row-cols-md-2 row-cols-xl-4">
                    <div class="col">
                        <div class="card radius-10 border-start border-0 border-3 border-info">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <div>
                                        <p class="mb-0 text-secondary">Total Orders</p>
                                        <h4 class="my-1 text-info">4805</h4>
                                        <p class="mb-0 font-13">+2.5% from last week</p>
                                    </div>
                                    <div class="widgets-icons-2 rounded-circle bg-gradient-scooter text-white ms-auto"><i class='bx bxs-cart'></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card radius-10 border-start border-0 border-3 border-danger">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <div>
                                        <p class="mb-0 text-secondary">Total Revenue</p>
                                        <h4 class="my-1 text-danger">$84,245</h4>
                                        <p class="mb-0 font-13">+5.4% from last week</p>
                                    </div>
                                    <div class="widgets-icons-2 rounded-circle bg-gradient-bloody text-white ms-auto"><i class='bx bxs-wallet'></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card radius-10 border-start border-0 border-3 border-success">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <div>
                                        <p class="mb-0 text-secondary">Bounce Rate</p>
                                        <h4 class="my-1 text-success">34.6%</h4>
                                        <p class="mb-0 font-13">-4.5% from last week</p>
                                    </div>
                                    <div class="widgets-icons-2 rounded-circle bg-gradient-ohhappiness text-white ms-auto"><i class='bx bxs-bar-chart-alt-2' ></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card radius-10 border-start border-0 border-3 border-warning">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <div>
                                        <p class="mb-0 text-secondary">Total Customers</p>
                                        <h4 class="my-1 text-warning">8.4K</h4>
                                        <p class="mb-0 font-13">+8.4% from last week</p>
                                    </div>
                                    <div class="widgets-icons-2 rounded-circle bg-gradient-blooker text-white ms-auto"><i class='bx bxs-group'></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--end row-->

            </div>
        </div>
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
