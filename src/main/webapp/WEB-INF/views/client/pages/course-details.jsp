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
  <title>Elearning | Course Detail | ${detail.name}</title>

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
        <h2>course details page</h2>
        <div class="breadcrumb-link margin-top-10">
          <span><a href="${rootpath}">home</a> / ${detail.name}</span>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Course Details Section Starts -->
<section class="course-details-section padding-120">
  <div class="container">
    <div class="row">
      <div class="col-lg-4">
        <div class="course-details-sidebar">
          <div class="course-details-widget">
            <div class="course-widget-title">
              <h4>course details</h4>
            </div>
            <div class="course-widget-items">
              <div class="single-item">
                <div class="item-left">
                  <span><i class="fa fa-user-circle"></i> instructor</span>
                </div>
                <div class="item-right">
                  <span>${detail.teachers.name}</span>
                </div>
              </div>
              <div class="single-item">
                <div class="item-left">
                  <span><i class="fa fa-clock-o"></i> duration</span>
                </div>
                <div class="item-right">
                  <span>${detail.times}</span>
                </div>
              </div>
              <div class="single-item">
                <div class="item-left">
                  <span><i class="fa fa-share-alt"></i> share</span>
                </div>
                <div class="item-right">
                  <ul>
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-8">
        <div class="course-details-title">
          <h2>${detail.name}</h2>
        </div>
        <div class="course-details-tab">
          <div class="tab">
            <ul>
              <li class="tab-one active">
                <span>overview</span>
              </li>
              <li class="tab-two">
                <span>curriculum</span>
              </li>
              <li class="tab-three">
                <span>instructor</span>
              </li>
              <li class="tab-four">
                <span>review</span>
              </li>
            </ul>
          </div>
          <div class="tab-content margin-top-30">
            <div class="tab-one-content tab-content-bg overview-content lost active">
              <h4>course description</h4>
              <p class="margin-top-20">This course is aimed at teaching photographers what it takes to improve your techniques to earn more money.You'll start with the basics and tackle how a camera operates, the types of cameras and lenses available, and equipment you'll need for accomplishing your goals.</p>
              <div class="overview-video margin-top-30">
                <img src="<c:url value="/public/images/"/>${detail.image}" alt="thumbnail">
                <div class="video-play-button">
                  <a href="${detail.linkVideo}" class="button-video">
                    <i class="fa fa-play"></i>
                  </a>
                </div>
              </div>
              ${detail.description}
            </div>
            <div class="tab-two-content tab-content-bg curriculum-content lost">
              <h4>course content</h4>
              <p class="margin-top-20">Advanced story telling techniques for writers: Personas, Characters & Plots.</p>
              <div class="curriculum-accordion margin-top-30">
                <div class="accordion-wrapper tab-margin-bottom-50" id="accordionExample">
                  <div class="card">
                    <div class="card-header" id="headingFour">
                      <a href="#" role="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">plugin development <span>${lessons.size()} lectures</span></a>
                    </div>
                    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
                      <div class="card-body">
                        <c:forEach items="${lessons}" var="item">
                          <div class="single-course-video">
                            <a href="videos?cour_id=${detail.id}&id_less=${item.id}" class="button-video">
                              <i class="fa fa-play-circle"></i> ${item.name}
                            </a>
                            <span>${item.times}</span>
                          </div>
                        </c:forEach>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="overview-title margin-top-30">
                <h4>requirements</h4>
              </div>
              <ul class="require-item">
                <li><i class="fa fa-square"></i> <span>computer</span></li>
                <li><i class="fa fa-square"></i> <span>internet</span></li>
              </ul>
              <p>This course is aimed at teaching photographers what it takes to improve your techniques to earn more money.You'll start with the basics and tackle how a camera operates. While there are plenty of digital photography courses that focus on specific styles or how to use gear.</p>
            </div>
            <div class="tab-three-content tab-content-bg instructor-content lost">
              <div class="row align-items-center">
                <div class="col-lg-5">
                  <div class="instructor-author">
                    <div class="single-instructor">
                      <span class="instructor-sign">${detail.teachers.name}</span>
                      <div class="instructor-image">
                        <a href="#"><img src="<c:url value="/public/images/teachers/"/>${detail.teachers.avatar}" alt="image"></a>
                      </div>
                      <div class="instructor-content">
                        <h4><a href="#">${detail.teachers.name}</a></h4>
                        <span>UI UX teacher</span>
                      </div>
                      <div class="hover-state">
                        <ul>
                          <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                          <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                          <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                          <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-7">
                  <div class="instructor-about">
                    <h4>about ${detail.teachers.name}</h4>
                    <p class="margin-top-20">Blanche has always been a passionate educator and instructor for students who have a talent for languages and technical science. </p>
                    <p class="margin-top-20">She founded MaxCoach in 1988 and trained over 5000 students online, many of whom are now successful businessmen, educators & technicians.</p>
                    <p class="margin-top-20">${detail.teachers.address}</p>
                    <div class="instructor-button margin-top-30">
                      <a href="instructor-details.html" class="template-button">know more</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="tab-four-content tab-content-bg review-content lost">
              <div class="row">
                <div class="col-lg-4">
                  <div class="rating-left">
                    <h2>4.5</h2>
                    <ul class="green-starts">
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                      <li><a href="#"><i class="fa fa-star"></i></a></li>
                      <li><a href="#"><i class="fa fa-star-half-o"></i></a></li>
                    </ul>
                    <span>average rating</span>
                  </div>
                </div>
                <div class="col-lg-8">
                  <div class="rating-right">
                    <div class="review-title">
                      <h4>course reviews</h4>
                    </div>
                    <div class="single-review">
                      <div class="progress-part">
                        <div class="progress">
                          <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                      <div class="start-part">
                        <ul class="yellow-starts">
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                        </ul>
                      </div>
                      <div class="percentage-part">
                        <span>80%</span>
                      </div>
                    </div>
                    <div class="single-review">
                      <div class="progress-part">
                        <div class="progress">
                          <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                      <div class="start-part">
                        <ul class="yellow-starts">
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                        </ul>
                      </div>
                      <div class="percentage-part">
                        <span>50%</span>
                      </div>
                    </div>
                    <div class="single-review">
                      <div class="progress-part">
                        <div class="progress">
                          <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                      <div class="start-part">
                        <ul class="yellow-starts">
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                        </ul>
                      </div>
                      <div class="percentage-part">
                        <span>20%</span>
                      </div>
                    </div>
                    <div class="single-review">
                      <div class="progress-part">
                        <div class="progress">
                          <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: 10%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                      <div class="start-part">
                        <ul class="yellow-starts">
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                        </ul>
                      </div>
                      <div class="percentage-part">
                        <span>10%</span>
                      </div>
                    </div>
                    <div class="single-review">
                      <div class="progress-part">
                        <div class="progress">
                          <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: 10%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                      <div class="start-part">
                        <ul class="yellow-starts">
                          <li><a href="#"><i class="fa fa-star"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                          <li><a href="#"><i class="fa fa-star-o"></i></a></li>
                        </ul>
                      </div>
                      <div class="percentage-part">
                        <span>10%</span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
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

