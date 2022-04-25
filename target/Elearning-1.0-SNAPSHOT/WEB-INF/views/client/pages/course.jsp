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
  <title>Elearning | Courses</title>

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
        <h2>course page</h2>
        <div class="breadcrumb-link margin-top-10">
          <span><a href="${rootpath}">home</a> / course page</span>
        </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Course Section Starts -->
<div class="course-page-content padding-120">
  <div class="container">
    <div class="page-content-top margin-bottom-40">
      <div class="row align-items-center">
        <div class="col-md-6">
          <div class="course-tab">
            <ul>
              <li class="active" data-filter="*">All courses</li>
              <c:forEach items="${categories}" var="item">
                  <li data-filter=".item${item.id}">${item.name}</li>
              </c:forEach>
            </ul>
          </div>
        </div>
        <div class="col-md-6">
          <div class="header-search">
            <form action="#">
              <input type="text" placeholder="Course Search">
              <button type="submit"><i class="fa fa-search"></i></button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="row grid">
      <c:forEach var="item" items="${courseByCate}">
        <div class="col-lg-4 col-sm-6 grid-item item${item.key}">
            <c:forEach items="${item.value}" var="course">
                <div class="course-single-item">
              <div class="course-image">
                <img src="<c:url value="/public/images/"/>${course.image}" alt="image">
                <div class="course-video-part">
                  <div class="video-play-button">
                    <a href="${course.linkVideo}" class="button-video">
                      <i class="fa fa-play"></i>
                    </a>
                  </div>
                </div>
              </div>
              <div class="course-content">
                <h4><a href="${rootpath}course.html/detail?id=${course.id}">${course.name}</a></h4>
                <p class="margin-top-20">${course.title}</p>

                <div class="signle-progressbar margin-top-20">
                  <div class="row align-items-center">
                    <div class="col-2">
                      <div class="progressbar-text">
                        <h6>80%</h6>
                      </div>
                    </div>
                    <div class="col-10">
                      <div id="bar1" class="barfiller">
                        <span class="fill" data-percentage="80"></span>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="cotent-bottom margin-top-20">
                  <div class="content-left">
                    <h6>leave a rating</h6>
                  </div>
                  <div class="content-right">
                    <ul>
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            </c:forEach>
        </div>
      </c:forEach>
    </div>
  </div>
</div>

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

