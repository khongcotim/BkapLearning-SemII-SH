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
<html lang="en" class="light-style layout-navbar-fixed layout-menu-fixed " dir="ltr" data-theme="theme-default"
      data-assets-path="<c:url value="/public/assetsTeacher/" />" data-template="vertical-menu-template">
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
                    <div class="row mb-4">
                        <!-- Browser Default -->
                        <div class="col-md mb-4 mb-md-0">
                            <div class="card">
                                <h5 class="card-header mb-3" style="color:green;">${notification}</h5>
                                <h5 class="card-header">Update Student | ${old_student.name}</h5>
                                <div class="card-body">
                                    <f:form modelAttribute="old_student" action="${rootTeacher}student-manage/update" class="browser-default-validation" enctype="multipart/form-data">
                                        <f:input path="id" type="hidden"></f:input>
                                        <div class="mb-3">
                                            <label class="form-label" for="basic-default-name">Name</label>
                                            <f:input path="name" type="text" class="form-control" id="basic-default-name"
                                                   placeholder="John Doe"
                                                     required = "true"></f:input>
                                            <f:errors path="name" cssStyle="color:red;"></f:errors>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label" for="basic-default-email">Email</label>
                                            <f:input path="email" type="email" class="form-control" id="basic-default-email"
                                                     placeholder="John Doe"
                                                     required = "true"></f:input>
                                            <f:errors path="email" cssStyle="color:red;"></f:errors>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label" for="basic-default-phone">Phone</label>
                                            <div class="input-group input-group-merge">
                                                <f:input path="phone" type="text" class="form-control" id="basic-default-phone"
                                                         placeholder="+123456789"
                                                         required = "true"></f:input>
                                            </div>
                                            <f:errors path="phone" cssStyle="color:red;"></f:errors>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label" for="basic-default-phone">Phone</label>
                                            <div class="input-group input-group-merge">
                                                <input type="file" class="form-control" id="basic-default-upload-file" name="avatarName" required />
                                            </div>
                                        </div>
                                        <div class="mb-3">
                                            <label class="d-block form-label">Gender</label>
                                            <div class="form-check mb-2">
                                                <f:radiobutton path="gender" value="true" id="basic-default-radio-male" class="form-check-input" checked="checked"/>
                                                <label class="form-check-label"
                                                       for="basic-default-radio-male">Male</label>
                                            </div>
                                            <div class="form-check">
                                                <f:radiobutton path="gender" value="false" id="basic-default-radio-feMale" class="form-check-input"/>
                                                <label class="form-check-label"
                                                       for="basic-default-radio-feMale">FeMale</label>
                                            </div>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label" for="basic-default-address">Address</label>
                                            <div class="input-group input-group-merge">
                                                <f:input path="address" type="text" class="form-control" id="basic-default-address"
                                                         placeholder="Viet Nam"
                                                         required = "true"></f:input>
                                            </div>
                                            <f:errors path="address" cssStyle="color:red;"></f:errors>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label" for="basic-default-birthday">Birthday</label>
                                            <div class="input-group input-group-merge">
                                                <f:input path="birthday" type="date" class="form-control" id="basic-default-birthday"
                                                         placeholder="+123456789"
                                                         required = "true"></f:input>
                                            </div>
                                            <f:errors path="birthday" cssStyle="color:red;"></f:errors>
                                        </div>
                                        <div class="row">
                                            <div class="col-12">
                                                <f:button type="submit" class="btn btn-primary">Submit</f:button>
                                                <f:button type="reset" class="btn btn-secondary">Clear</f:button>
                                            </div>
                                        </div>
                                    </f:form>
                                </div>
                            </div>
                        </div>
                        <!-- /Browser Default -->
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
<jsp:include page="/WEB-INF/views/teacher/layout/script.jsp"></jsp:include>

</body>

</html>
