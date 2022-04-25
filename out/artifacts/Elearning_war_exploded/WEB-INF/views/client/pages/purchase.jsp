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
  <title>Elearning | Purchase</title>

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
        <h2>purchase page</h2>
        <div class="breadcrumb-link margin-top-10">
          <span><a href="${rootpath}">home</a> / purchase page</span>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Purchase Section Starts -->
<section class="purchase-section padding-120">
  <div class="container">
    <div class="purchase-table">
      <div class="purchase-table-head">
        <div class="row">
          <div class="col-5">
            <h5>purchase history</h5>
          </div>
          <div class="col-7">
            <ul>
              <li><h5>date</h5></li>
              <li><h5>total price</h5></li>
              <li><h5>payment type</h5></li>
              <li><h5>recipt</h5></li>
              <li><h5>invoice</h5></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="single-table-item">
        <div class="purchase-table-head">
          <div class="row">
            <div class="col-lg-5">
              <h5>purchase history</h5>
            </div>
            <div class="col-lg-7">
              <ul>
                <li><h5>date</h5></li>
                <li><h5>total price</h5></li>
                <li><h5>payment type</h5></li>
                <li><h5>recipt</h5></li>
                <li><h5>invoice</h5></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="purchase-table-item">
          <div class="row align-items-center">
            <div class="col-lg-5">
              <div class="row align-items-center">
                <div class="col-lg-4">
                  <a href="#"><img src="<c:url value="/public/assets/images/purchase-image-1.jpg"/>" alt="image"></a>
                </div>
                <div class="col-lg-8">
                  <h5><a href="#">ultimate photoshop training</a></h5>
                  <span>by <a href="#">john doe</a></span>
                </div>
              </div>
            </div>
            <div class="col-lg-7">
              <ul>
                <li><h5>18 june 2020</h5></li>
                <li><h5>$ 16,99</h5></li>
                <li><h5>free coupon</h5></li>
                <li><a href="#">recipt</a></li>
                <li><h5>unavailable</h5></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="single-table-item">
        <div class="purchase-table-head">
          <div class="row">
            <div class="col-lg-5">
              <h5>purchase history</h5>
            </div>
            <div class="col-lg-7">
              <ul>
                <li><h5>date</h5></li>
                <li><h5>total price</h5></li>
                <li><h5>payment type</h5></li>
                <li><h5>recipt</h5></li>
                <li><h5>invoice</h5></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="purchase-table-item">
          <div class="row align-items-center">
            <div class="col-lg-5">
              <div class="row align-items-center">
                <div class="col-lg-4">
                  <a href="#"><img src="<c:url value="/public/assets/images/purchase-image-2.jpg"/>" alt="image"></a>
                </div>
                <div class="col-lg-8">
                  <h5><a href="#">complete financial analysis</a></h5>
                  <span>by <a href="#">chris doe</a></span>
                </div>
              </div>
            </div>
            <div class="col-lg-7">
              <ul>
                <li><h5>18 june 2020</h5></li>
                <li><h5>$ 16,99</h5></li>
                <li><h5>free coupon</h5></li>
                <li><a href="#">recipt</a></li>
                <li><h5>unavailable</h5></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="single-table-item">
        <div class="purchase-table-head">
          <div class="row">
            <div class="col-lg-5">
              <h5>purchase history</h5>
            </div>
            <div class="col-lg-7">
              <ul>
                <li><h5>date</h5></li>
                <li><h5>total price</h5></li>
                <li><h5>payment type</h5></li>
                <li><h5>recipt</h5></li>
                <li><h5>invoice</h5></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="purchase-table-item">
          <div class="row align-items-center">
            <div class="col-lg-5">
              <div class="row align-items-center">
                <div class="col-lg-4">
                  <a href="#"><img src="<c:url value="/public/assets/images/purchase-image-3.jpg"/>" alt="image"></a>
                </div>
                <div class="col-lg-8">
                  <h5><a href="#">complete advance WP</a></h5>
                  <span>by <a href="#">john doe</a></span>
                </div>
              </div>
            </div>
            <div class="col-lg-7">
              <ul>
                <li><h5>18 june 2020</h5></li>
                <li><h5>$ 16,99</h5></li>
                <li><h5>free coupon</h5></li>
                <li><a href="#">recipt</a></li>
                <li><h5>unavailable</h5></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <div class="template-pagination margin-top-20">
          <ul>
            <li class="pagination-arrow"><a href="#"><i class="fa fa-angle-left"></i></a></li>
            <li><a href="#">01</a></li>
            <li><a href="#">02</a></li>
            <li><a href="#">03</a></li>
            <li><a href="#">04</a></li>
            <li class="pagination-arrow"><a href="#"><i class="fa fa-angle-right"></i></a></li>
          </ul>
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

