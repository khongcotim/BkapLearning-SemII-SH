<%--
  Created by IntelliJ IDEA.
  User: bt289
  Date: 3/30/2022
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required Meta Tags -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="<c:url value="/public/assets/css/animate.css"/>">
  <link rel="stylesheet" href="<c:url value="/public/assets/css/bootstrap.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/public/assets/css/font-awesome.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/public/assets/css/icofont.css"/>">
  <link rel="stylesheet" href="<c:url value="/public/assets/css/slick.css"/>">
  <link rel="stylesheet" href="<c:url value="/public/assets/css/magnific-popup.css"/>">
  <link rel="stylesheet" href="<c:url value="/public/assets/css/style.css"/>">
  <!-- Page Title -->
  <title>Elearning | Login</title>

  <!-- Favicon Icon -->
  <link rel="shortcut icon" href="<c:url value="/public/assets/icon/favicon.png"/>">
</head>

<body>
<c:url value="/" var="rootpath"></c:url>
<jsp:include page="/WEB-INF/views/client/menu/main_menu.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/client/header/header.jsp"></jsp:include>

<!-- Breadcrumb Section Starts -->
<section class="breadcrumb-section">
  <div class="breadcrumb-shape">
    <img src="<c:url value="/public/assets/images/round-shape-2.png"/>" alt="shape" class="hero-round-shape-2 item-moveTwo">
    <img src="<c:url value="/public/assets/images/plus-sign.png"/>" alt="shape" class="hero-plus-sign item-rotate">
  </div>
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h2>login page</h2>
        <div class="breadcrumb-link margin-top-10">
          <span><a href="${rootpath}">home</a> / login page</span>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Login Section Starts -->
<section class="login-section padding-120">
  <div class="container">
    <div class="row">
      <div class="col-lg-6">
        <div class="login-image">
          <img src="<c:url value="/public/assets/images/login-image.jpg"/>" alt="image">
        </div>
      </div>
      <div class="col-lg-6">
        <div class="login-form">
          <h3>login to your <span>account!</span></h3>
          <div class="google-button">
            <a href="#" class="template-button"><i class="fa fa-google"></i> google</a>
          </div>
          <span class="separator">or</span>
          <div class="login-tab">
            <div class="tab">
              <ul>
                <li class="tab-one active">
                  <a href="#" class="template-button-2">admin</a>
                </li>
                <li class="tab-second">
                  <a href="#" class="template-button-2">instructor</a>
                </li>
                <li class="tab-three">
                  <a href="#" class="template-button-2">student</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="tab-content margin-top-30">
            <div class="tab-one-content lost active">
              <form action="#">
                <div class="form-group">
                  <label for="loginEmail"><i class="fa fa-envelope"></i> Email Address</label>
                  <input type="email" id="loginEmail" placeholder="Email Address">
                </div>
                <div class="form-group">
                  <label for="loginPassword"><i class="fa fa-lock"></i> Password</label>
                  <input type="password" id="loginPassword" placeholder="Password">
                </div>
                <div class="checkbox-forgotpass-area">
                  <div class="checkbox-part">
                    <input type="checkbox" id="remember">
                    <label for="remember"> remember me</label>
                  </div>
                  <div class="forgotpass-part">
                    <a href="#">forgot password?</a>
                  </div>
                </div>
                <div class="login-button margin-top-20">
                  <a href="#" class="template-button">login account</a>
                </div>
              </form>
            </div>
            <div class="tab-second-content lost">
              <form action="#">
                <div class="form-group">
                  <label for="loginEmail2"><i class="fa fa-envelope"></i> Email Address</label>
                  <input type="email" id="loginEmail2" placeholder="Email Address">
                </div>
                <div class="form-group">
                  <label for="loginPassword2"><i class="fa fa-lock"></i> Password</label>
                  <input type="password" id="loginPassword2" placeholder="Password">
                </div>
                <div class="checkbox-forgotpass-area">
                  <div class="checkbox-part">
                    <input type="checkbox" id="remember2">
                    <label for="remember2"> remember me</label>
                  </div>
                  <div class="forgotpass-part">
                    <a href="#">forgot password?</a>
                  </div>
                </div>
                <div class="login-button margin-top-20">
                  <a href="#" class="template-button">login account</a>
                </div>
              </form>
            </div>
            <div class="tab-three-content lost">
              <form action="#">
                <div class="form-group">
                  <label for="loginEmail3"><i class="fa fa-envelope"></i> Email Address</label>
                  <input type="email" id="loginEmail3" placeholder="Email Address">
                </div>
                <div class="form-group">
                  <label for="loginPassword3"><i class="fa fa-lock"></i> Password</label>
                  <input type="password" id="loginPassword3" placeholder="Password">
                </div>
                <div class="checkbox-forgotpass-area">
                  <div class="checkbox-part">
                    <input type="checkbox" id="remember3">
                    <label for="remember3"> remember me</label>
                  </div>
                  <div class="forgotpass-part">
                    <a href="#">forgot password?</a>
                  </div>
                </div>
                <div class="login-button margin-top-20">
                  <a href="#" class="template-button">login account</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- CTA Section Starts -->
<section class="cta-section gradient-bg padding-top-60 padding-bottom-30">
  <div class="cta-shape">
    <img src="<c:url value="/public/assets/images/plus-sign.png"/>" alt="image" class="plus-sign item-rotate">
  </div>
  <div class="container">
    <div class="row align-items-center">
      <div class="col-lg-6">
        <div class="section-title margin-bottom-40">
          <h2>enhance your skills with <span>best online course</span></h2>
        </div>
        <div class="cta-button">
          <a href="#" class="template-button margin-right-20">start teaching</a>
          <a href="#" class="template-button-2">start learning</a>
        </div>
      </div>
      <div class="col-xl-4 offset-xl-2 col-lg-6">
        <div class="cta-image">
          <img src="<c:url value="/public/assets/images/cta-image.png"/>" alt="image">
        </div>
      </div>
    </div>
  </div>
</section>
<jsp:include page="/WEB-INF/views/client/footer/footer.jsp"></jsp:include>
</body>
</html>

