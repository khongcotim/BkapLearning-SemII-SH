<%--
  Created by IntelliJ IDEA.
  User: bt289
  Date: 3/30/2022
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<c:url value="/admin/" var="rootAdmin"/>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--favicon-->
    <link rel="icon" href="<c:url value="/public/assetAdmin/images/favicon-32x32.png"/>" type="image/png"/>
    <!--plugins-->
    <link href="<c:url value="/public/assetAdmin/plugins/vectormap/jquery-jvectormap-2.0.2.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/public/assetAdmin/plugins/simplebar/css/simplebar.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/public/assetAdmin/plugins/perfect-scrollbar/css/perfect-scrollbar.css"/>"
          rel="stylesheet"/>
    <link href="<c:url value="/public/assetAdmin/plugins/metismenu/css/metisMenu.min.css"/>" rel="stylesheet"/>
    <!-- loader-->
    <link href="<c:url value="/public/assetAdmin/css/pace.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/public/assetAdmin/js/pace.min.js"/>"></script>
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/public/assetAdmin/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/public/assetAdmin/css/bootstrap-extended.css"/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&amp;display=swap" rel="stylesheet">
    <link href="<c:url value="/public/assetAdmin/css/app.css"/>" rel="stylesheet">
    <link href="<c:url value="/public/assetAdmin/css/icons.css"/>" rel="stylesheet">
    <!-- Theme Style CSS -->
    <link rel="stylesheet" href="<c:url value="/public/assetAdmin/css/dark-theme.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/public/assetAdmin/css/semi-dark.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/public/assetAdmin/css/header-colors.css"/>"/>
    <title>Login | Admin</title>
</head>
<body>
<c:if test="${userName!=null}">
    <%
        String backUrl = request.getHeader("Referer");
        response.sendRedirect(backUrl);
    %>
</c:if>
<div class="wrapper">
    <div class="section-authentication-signin d-flex align-items-center justify-content-center my-5 my-lg-0">
        <div class="container-fluid">
            <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-3">
                <div class="col mx-auto">
                    <div class="mb-4 text-center">
                        <img src="<c:url value="/public/assetAdmin/images/logo-img.png"/>" width="180" alt=""/>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <div class="border p-4 rounded">
                                <div class="d-grid">
                                    <a class="btn my-4 shadow-sm btn-white" href="javascript:;">
                                        <span style="color: green">${notification}</span>
                                        <span
                                            class="d-flex justify-content-center align-items-center">
                                                  <img class="me-2" src="<c:url value="/public/assetAdmin/images/icons/search.svg"/>" width="16"
                                                       alt="Image Description">
                                                  <span>Sign in with Google</span>
                                        </span>
                                    </a> <a href="javascript:;" class="btn btn-facebook"><i class="bx bxl-facebook"></i>Sign
                                    in with Facebook</a>
                                </div>
                                <div class="login-separater text-center mb-4"><span>OR SIGN IN WITH EMAIL</span>
                                    <hr/>
                                </div>
                                <div class="form-body">
                                    <f:form class="row g-3" modelAttribute="admins" method="post">
                                        <div class="col-12">
                                            <label for="inputEmailAddress" class="form-label">Email Address</label>
                                            <f:input path="email" type="email" class="form-control" id="inputEmailAddress"
                                                     placeholder="Email Address" required="true"/>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputChoosePassword" class="form-label">Enter Password</label>
                                            <div class="input-group" id="show_hide_password">
                                                <f:input path="password" type="password" class="form-control border-end-0"
                                                       id="inputChoosePassword" value=""
                                                       placeholder="Enter Password" required="true"/> <a href="javascript:;"
                                                                                        class="input-group-text bg-transparent"><i
                                                    class='bx bx-hide'></i></a>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="checkbox"
                                                       id="flexSwitchCheckChecked" checked>
                                                <label class="form-check-label" for="flexSwitchCheckChecked">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 text-end"><a href="#">Forgot
                                            Password ?</a>
                                        </div>
                                        <div class="col-12">
                                            <div class="d-grid">
                                                <f:button type="submit" class="btn btn-primary"><i
                                                        class="bx bxs-lock-open"></i>Sign in
                                                </f:button>
                                            </div>
                                        </div>
                                    </f:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--end row-->
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/admin/layout/plugins.jsp"/>
<script>
    $(document).ready(function () {
        $("#show_hide_password a").on('click', function (event) {
            event.preventDefault();
            if ($('#show_hide_password input').attr("type") == "text") {
                $('#show_hide_password input').attr('type', 'password');
                $('#show_hide_password i').addClass("bx-hide");
                $('#show_hide_password i').removeClass("bx-show");
            } else if ($('#show_hide_password input').attr("type") == "password") {
                $('#show_hide_password input').attr('type', 'text');
                $('#show_hide_password i').removeClass("bx-hide");
                $('#show_hide_password i').addClass("bx-show");
            }
        });
    });
</script>
</body>
</html>
