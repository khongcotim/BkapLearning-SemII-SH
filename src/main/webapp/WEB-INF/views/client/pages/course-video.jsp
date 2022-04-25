<%--
  Created by IntelliJ IDEA.
  User: bt289
  Date: 3/30/2022
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:set var = "theString" value = "${typeOfAttach}"/>
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
  <title>Elearning | Course Video</title>

  <!-- Favicon Icon -->
  <link rel="shortcut icon" href="<c:url value="/public/assets/icon/favicon.png"/>">
</head>

<body>
<c:url value="/" var="rootpath"></c:url>
<section class="course-video-section padding-bottom-110">
  <div class="container-fluid">
    <div class="row">
      <div class="col-lg-8 p-0 order-2 order-lg-1">
        <iframe width="1000" height="500" src="${lessonFound.link_video}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        <div class="course-video-tab padding-top-60">
          <span style="color: green">${notification}</span>
          <div class="tab">
            <ul>
              <li class="tab-one active">
                <span>overview</span>
              </li>
              <li class="tab-two">
                <span>Review lesson</span>
              </li>
              <li class="tab-three">
                <span>Send Excercise</span>
              </li>
            </ul>
            <div class="hr-line"></div>
          </div>
          <div class="tab-content">
            <div class="tab-one-content tab-content-bg overview-content lost active">
              ${lessonFound.description}
            </div>
            <div class="tab-two-content tab-content-bg note-content lost">
              <c:if test="${studentName!=null}">
                <span>Hey, you have new exercise below here....</span>
                <c:if test="${fn:contains(theString, 'pdf')}">
                  <i class="fa fa-file-pdf"></i>
                  <br>
                  <a href="<c:url value="/public/exercise/"/>${testFound.question}" download="">Click here to see your exercise</a>
                </c:if>
                <c:if test="${fn:contains(theString, 'jpg')}">
                  <a href="<c:url value="/public/exercise/"/>${testFound.question}" download="">
                    <img src="<c:url value="/public/exercise/"/>${testFound.question}" width="300" height="300">
                  </a>
                </c:if>
                <c:if test="${fn:contains(theString, 'txt')}">
                  <i class="fa fa-file"></i>
                  <br>
                  <a href="<c:url value="/public/exercise/"/>${testFound.question}" download="">Click here to see your exercise</a>
                </c:if>
              </c:if>
              <c:if test="${studentName==null}">
                <a href="${rootpath}login.html/${courseId}/${lessonFound.id}">Please login to see your exercise!!!</a>
              </c:if>
            </div>
            <div class="tab-three-content tab-content-bg note-content lost">
              <c:if test="${studentName!=null}">
                <span class="mb-3">Send your exercise to your teacher to test your level !!</span>
                <form method="post" action="${rootpath}course.html/send-exercise/${testFound.id}" enctype="multipart/form-data">
                  <input type="file" name="file-exc">
                  <button class="btn btn-primary" type="submit">Submit</button>
                </form>
              </c:if>
              <c:if test="${studentName==null}">
                <a href="${rootpath}login.html/${courseId}/${lessonFound.id}">Please login to send your exercise!!!</a>
              </c:if>

            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-4 p-0 order-1 order-lg-2">
        <div class="video-playlist-sidebar">
          <h4>${lessonFound.course.name}</h4>
          <div class="curriculum-accordion margin-top-30">
            <div class="accordion-wrapper tab-margin-bottom-50" id="accordionExample">
              <div class="card">
                <div class="card-header" id="headingFour">
                  <a href="#" role="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">plugin development</a>
                </div>
                <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
                  <div class="card-body">
                    <c:forEach items="${lessons}" var="lesson">
                      <div class="single-course-video">
                        <a href="${rootpath}course.html/videos?cour_id=${courseId}&id_less=${lesson.id}" class="button-video">
                          <i class="fa fa-play-circle"></i> ${lesson.name}
                        </a>
                        <span>${lesson.times}</span>
                      </div>
                    </c:forEach>
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

