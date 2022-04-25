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
  <title>Elearning | Contact</title>

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
        <h2>contact page</h2>
        <div class="breadcrumb-link margin-top-10">
          <span><a href="${rootpath}">home</a> / contact page</span>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Contact Info Section Starts -->
<section class="contact-info-section padding-top-115">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="section-title text-center">
          <h2>get in <span>touch</span></h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-3 col-md-6">
        <div class="single-contact-info">
          <div class="contact-info-icon">
            <img src="<c:url value="/public/assets/images/contact-info-1.png"/>" alt="icon">
            <img src="<c:url value="/public/assets/images/round-shape-3.png"/>" alt="shape" class="feature-round-shape-3">
          </div>
          <div class="contact-info-title margin-bottom-10">
            <h4>phone us 24/7</h4>
          </div>
          <span>123-5874624</span>
        </div>
      </div>
      <div class="col-lg-3 col-md-6">
        <div class="single-contact-info">
          <div class="contact-info-icon">
            <img src="<c:url value="/public/assets/images/contact-info-2.png"/>" alt="icon">
            <img src="<c:url value="/public/assets/images/round-shape-3.png"/>" alt="shape" class="feature-round-shape-3">
          </div>
          <div class="contact-info-title margin-bottom-10">
            <h4>visit us daily</h4>
          </div>
          <span>10 division st, new york, 1020</span>
        </div>
      </div>
      <div class="col-lg-3 col-md-6">
        <div class="single-contact-info">
          <div class="contact-info-icon">
            <img src="<c:url value="/public/assets/images/contact-info-3.png"/>" alt="icon">
            <img src="<c:url value="/public/assets/images/round-shape-3.png"/> alt="shape" class="feature-round-shape-3">
          </div>
          <div class="contact-info-title margin-bottom-10">
            <h4>mail us 24/7</h4>
          </div>
          <span>support@rumbok.com</span>
        </div>
      </div>
      <div class="col-lg-3 col-md-6">
        <div class="single-contact-info">
          <div class="contact-info-icon">
            <img src="<c:url value="/public/assets/images/contact-info-4.png"/>" alt="icon">
            <img src="<c:url value="/public/assets/images/round-shape-3.png"/>" alt="shape" class="feature-round-shape-3">
          </div>
          <div class="contact-info-title margin-bottom-10">
            <h4>contact us</h4>
          </div>
          <span>sofftech-it.com</span>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Contact Bottom Section Starts -->
<section class="contact-bottom-section">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="map-area">
          <iframe src="https://maps.google.com/maps?width=100%25&amp;height=600&amp;hl=en&amp;q=uttara%2011+(SoftTech%20IT)&amp;t=&amp;z=14&amp;ie=UTF8&amp;iwloc=B&amp;output=embed"></iframe>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-5">
        <div class="contact-page-form">
          <div class="contact-form-title">
            <h3>write <span>to us</span></h3>
          </div>
          <form action="#">
            <input type="text" placeholder="Your Name">
            <input type="text" placeholder="Your Email">
            <input type="text" placeholder="Your Website">
            <textarea name="message" id="message" cols="30" rows="10" placeholder="Write Your Message"></textarea>
            <button type="submit" class="template-button">send a message</button>
          </form>
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

