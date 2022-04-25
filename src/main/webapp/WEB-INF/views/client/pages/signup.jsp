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
  <title>Elearning | Sign up</title>

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
        <h2>signup page</h2>
        <div class="breadcrumb-link margin-top-10">
          <span><a href="${rootpath}">home</a> / signup page</span>
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
          <h3>signup <span>now</span></h3>
          <span style="color: green">${notification}</span>
          <div class="google-button">
            <a href="#" class="template-button"><i class="fa fa-google"></i> google</a>
          </div>
          <span class="separator">or</span>

          <div class="tab-content margin-top-30">
            <div class="tab-one-content lost active">
              <form action="" method="post">
                <div class="form-group">
                  <label for="signupName"><i class="fa fa-user"></i> Your Name</label>
                  <input type="text" name="name" id="signupName" placeholder="Your Name">
                </div>
                <div class="form-group">
                  <label for="signupEmail"><i class="fa fa-envelope"></i> Email Address</label>
                  <input type="email" name="email" id="signupEmail" placeholder="Email Address">
                </div>
                <div class="form-group">
                  <label for="signupPhone"><i class="fa fa-envelope"></i> Phone Number</label>
                  <input type="text" name="phone" id="signupPhone" placeholder="Phone Number">
                </div>
                <div class="form-group">
                  <label for="signupPassword"><i class="fa fa-lock"></i> Password</label>
                  <input type="password" name="password" id="signupPassword" placeholder="Password">
                </div>
                <div class="form-group">
                  <label for="signupBirthday"><i class="fa fa-lock"></i> Birthday</label>
                  <input type="date" name="birthday" id="signupBirthday" placeholder="Birthday">
                </div>
                <div class="checkbox-forgotpass-area">
                  <div class="checkbox-part">
                    <input type="checkbox" id="signupRemember">
                    <label for="signupRemember"> remember me</label>
                  </div>
                  <div class="forgotpass-part">
                    <a href="#">forgot password?</a>
                  </div>
                </div>
                <div class="login-button margin-top-20">
                  <button type="submit" class="template-button">Register</button>
                  <span>already have an account? <a href="login.html">login</a></span>
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

