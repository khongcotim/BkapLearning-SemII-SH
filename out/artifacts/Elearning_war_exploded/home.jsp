<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/public/assets/icon/favicon.png"/>">
    <title>ELearning Project</title>
    <link rel="stylesheet" href="<c:url value="/public/assets/css/animate.css"/>">
    <link rel="stylesheet" href="<c:url value="/public/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/public/assets/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/public/assets/css/icofont.css"/>">
    <link rel="stylesheet" href="<c:url value="/public/assets/css/slick.css"/>">
    <link rel="stylesheet" href="<c:url value="/public/assets/css/magnific-popup.css"/>">
    <link rel="stylesheet" href="<c:url value="/public/assets/css/style.css"/>">
</head>
<body>
<c:url value="/" var="rootpath"></c:url>
<jsp:include page="WEB-INF/views/client/header/header.jsp"></jsp:include>
<jsp:include page="WEB-INF/views/client/menu/main_menu.jsp"></jsp:include>
<!-- Preloader Starts -->
<div class="preloader" id="preloader">
    <div class="preloader-inner">
        <div class="spinner">
            <div class="bounce1"></div>
            <div class="bounce2"></div>
            <div class="bounce3"></div>
        </div>
    </div>
</div>

<!-- Hero Section Starts -->
<section class="hero-section">
    <div class="hero-shape">
        <img src="<c:url value="/public/assets/images/round-shape-4.png"/>" alt="shape" class="hero-round-shape-4 item-moveTwo">
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 align-self-center">
                <div class="hero-content">
                    <h1>Course LMS, best <span>Online learning</span> Platform</h1>
                    <span class="hero-tagline">Learn Wherever, Whenever, However Online Classes.</span>
                    <div class="hero-button">
                        <a href="course.html" class="template-button">start course</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="hero-image">
                    <div class="hero-small-images">
                        <img src="<c:url value="/public/assets/images/hero-small-image-1.png"/>" alt="image" class="hero-small-image-1">
                        <img src="<c:url value="/public/assets/images/hero-small-image-2.png"/>" alt="image" class="hero-small-image-2">
                        <img src="<c:url value="/public/assets/images/hero-small-image-3.png"/>" alt="image" class="hero-small-image-3">
                        <img src="<c:url value="/public/assets/images/hero-small-image-4.png"/>" alt="image" class="hero-small-image-4">
                    </div>
                    <img src="<c:url value="/public/assets/images/hero-image.png"/>" alt="image">
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Feature Section Starts -->
<section class="feature-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="single-feature-item feature-item-1">
                    <div class="feature-icon template-icon green-icon">
                        <i class="icofont-document-folder"></i>
                    </div>
                    <div class="feature-content">
                        <h4>9 online courses</h4>
                        <p>Explore a variety of fresh topics.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="single-feature-item feature-item-2">
                    <div class="feature-icon template-icon yellow-icon">
                        <i class="icofont-cubes"></i>
                    </div>
                    <div class="feature-content">
                        <h4>expert instruction</h4>
                        <p>Find the right instructor for you.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="single-feature-item feature-item-3">
                    <div class="feature-icon template-icon blue-icon">
                        <i class="icofont-gears"></i>
                    </div>
                    <div class="feature-content">
                        <h4>lifetime access</h4>
                        <p>Learn on your schedule.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Categorry Section Starts -->
<section class="category-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title text-center">
                    <h2>popular <span>categories</span></h2>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div class="col-lg-3 col-md-6">
                    <a href="course.html"><div class="single-category-item">
                        <div class="category-image">
                            <img src="<c:url value="/public/assets/images/category-icon-1.png"/>" alt="image">
                            <img src="<c:url value="/public/assets/images/round-shape-3.png"/>" alt="shape" class="feature-round-shape-3">
                        </div>
                        <div class="category-title margin-bottom-10">
                            <h4>${category.name}</h4>
                        </div>
                        <span>03 course(S)</span>
                    </div></a>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<!-- Course Section Starts -->
<section class="course-section gradient-bg padding-top-115 padding-bottom-90">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="section-title text-center margin-bottom-40">
                    <h2>see our <span>popular courses</span></h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="popular-course-tab">
                    <ul>
                        <li class="active" data-filter="*">All course</li>
                        <li data-filter=".web">web design</li>
                        <li data-filter=".ux">UI UX design</li>
                        <li data-filter=".photography">photography</li>
                        <li data-filter=".marketing">marketing</li>
                        <li data-filter=".music">music</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row grid">
            <div class="col-lg-4 col-md-6 grid-item marketing">
                <div class="single-course-item">
                    <div class="course-image">
                        <img src="<c:url value="/public/assets/images/course-image-1.png"/>" alt="image">
                    </div>
                    <div class="course-content margin-top-30">
                        <div class="course-title">
                            <h4>user experience design with adobe XD</h4>
                        </div>
                        <div class="course-instructor-rating margin-top-20">
                            <div class="course-instructor">
                                <img src="<c:url value="/public/assets/images/course-instructor-1.png"/>" alt="instructor">
                                <h6>john doe</h6>
                            </div>
                            <div class="course-rating">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>4.2(30)</span>
                            </div>
                        </div>
                        <div class="course-info margin-top-20">
                            <div class="course-view">
                                <i class="fa fa-eye"></i>
                                <span>25,000 views</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <div class="course-price-cart margin-top-20">
                            <div class="course-price">
                                <span class="span-big">$ 400.00</span>
                                <span class="span-cross">$ 500.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="hover-state">
                        <span class="heart-icon"><i class="fa fa-heart-o"></i></span>
                        <span class="title-tag">by instructor</span>
                        <div class="course-title margin-top-10">
                            <h4><a href="course-details.html">user experience design with adobe XD</a></h4>
                        </div>
                        <div class="course-price-info margin-top-20">
                            <span class="best-seller">best seller</span>
                            <span class="course-category"><a href="#">web design</a></span>
                            <span class="course-price">$ 400.00</span>
                        </div>
                        <div class="course-info margin-top-30">
                            <div class="course-enroll">
                                <span>enrolled 0</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <p class="margin-top-20">Learn WordPress like a Professional! Start from the basics and go all the way to creating your own applications and website!</p>
                        <ul class="margin-top-20">
                            <li><i class="fa fa-circle-o"></i><span>Lorem ipsum dolor sit amet.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Consectetur adipisicing elit.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Placeat dolore quaerat itaque.</span></li>
                        </ul>
                        <div class="preview-button margin-top-20">
                            <a href="course-details.html" class="template-button">course preview</a>
                            <a href="cart.html" class="template-button margin-left-10">add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 grid-item ux">
                <div class="single-course-item diffrent-bg-color">
                    <div class="course-image">
                        <img src="<c:url value="/public/assets/images/course-image-2.png"/>" alt="image">
                    </div>
                    <div class="course-content margin-top-30">
                        <div class="course-title">
                            <h4>the complete financial analytic course</h4>
                        </div>
                        <div class="course-instructor-rating margin-top-20">
                            <div class="course-instructor">
                                <img src="<c:url value="/public/assets/images/course-instructor-2.png"/>" alt="instructor">
                                <h6>chris doe</h6>
                            </div>
                            <div class="course-rating">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>4.2(30)</span>
                            </div>
                        </div>
                        <div class="course-info margin-top-20">
                            <div class="course-view">
                                <i class="fa fa-eye"></i>
                                <span>10,000 views</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>30 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>1h 40mins</span>
                            </div>
                        </div>
                        <div class="course-price-cart margin-top-20">
                            <div class="course-price">
                                <span class="span-big">$ 250.00</span>
                                <span class="span-cross">$ 400.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="hover-state">
                        <span class="heart-icon"><i class="fa fa-heart-o"></i></span>
                        <span class="title-tag">by instructor</span>
                        <div class="course-title margin-top-10">
                            <h4><a href="course-details.html">the complete financial analytic course</a></h4>
                        </div>
                        <div class="course-price-info margin-top-20">
                            <span class="best-seller">best seller</span>
                            <span class="course-category"><a href="#">web design</a></span>
                            <span class="course-price">$ 250.00</span>
                        </div>
                        <div class="course-info margin-top-30">
                            <div class="course-enroll">
                                <span>enrolled 0</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <p class="margin-top-20">Learn WordPress like a Professional! Start from the basics and go all the way to creating your own applications and website!</p>
                        <ul class="margin-top-20">
                            <li><i class="fa fa-circle-o"></i><span>Lorem ipsum dolor sit amet.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Consectetur adipisicing elit.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Placeat dolore quaerat itaque.</span></li>
                        </ul>
                        <div class="preview-button margin-top-20">
                            <a href="course-details.html" class="template-button">course preview</a>
                            <a href="cart.html" class="template-button margin-left-10">add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 grid-item web">
                <div class="single-course-item">
                    <div class="course-image">
                        <img src="<c:url value="/public/assets/images/course-image-4.png"/>" alt="image">
                    </div>
                    <div class="course-content margin-top-30">
                        <div class="course-title">
                            <h4>user experience design with adobe XD</h4>
                        </div>
                        <div class="course-instructor-rating margin-top-20">
                            <div class="course-instructor">
                                <img src="<c:url value="/public/assets/images/course-instructor-1.png"/>" alt="instructor">
                                <h6>john doe</h6>
                            </div>
                            <div class="course-rating">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>4.2(30)</span>
                            </div>
                        </div>
                        <div class="course-info margin-top-20">
                            <div class="course-view">
                                <i class="fa fa-eye"></i>
                                <span>25,000 views</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <div class="course-price-cart margin-top-20">
                            <div class="course-price">
                                <span class="span-big">$ 400.00</span>
                                <span class="span-cross">$ 500.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="hover-state">
                        <span class="heart-icon"><i class="fa fa-heart-o"></i></span>
                        <span class="title-tag">by instructor</span>
                        <div class="course-title margin-top-10">
                            <h4><a href="course-details.html">user experience design with adobe XD</a></h4>
                        </div>
                        <div class="course-price-info margin-top-20">
                            <span class="best-seller">best seller</span>
                            <span class="course-category"><a href="#">web design</a></span>
                            <span class="course-price">$ 400.00</span>
                        </div>
                        <div class="course-info margin-top-30">
                            <div class="course-enroll">
                                <span>enrolled 0</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <p class="margin-top-20">Learn WordPress like a Professional! Start from the basics and go all the way to creating your own applications and website!</p>
                        <ul class="margin-top-20">
                            <li><i class="fa fa-circle-o"></i><span>Lorem ipsum dolor sit amet.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Consectetur adipisicing elit.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Placeat dolore quaerat itaque.</span></li>
                        </ul>
                        <div class="preview-button margin-top-20">
                            <a href="course-details.html" class="template-button">course preview</a>
                            <a href="cart.html" class="template-button margin-left-10">add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 grid-item music">
                <div class="single-course-item">
                    <div class="course-image">
                        <img src="<c:url value="/public/assets/images/course-image-3.png"/>" alt="image">
                    </div>
                    <div class="course-content margin-top-30">
                        <div class="course-title">
                            <h4>user experience design with adobe XD</h4>
                        </div>
                        <div class="course-instructor-rating margin-top-20">
                            <div class="course-instructor">
                                <img src="<c:url value="/public/assets/images/course-instructor-1.png"/>" alt="instructor">
                                <h6>john doe</h6>
                            </div>
                            <div class="course-rating">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>4.2(30)</span>
                            </div>
                        </div>
                        <div class="course-info margin-top-20">
                            <div class="course-view">
                                <i class="fa fa-eye"></i>
                                <span>25,000 views</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <div class="course-price-cart margin-top-20">
                            <div class="course-price">
                                <span class="span-big">$ 400.00</span>
                                <span class="span-cross">$ 500.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="hover-state">
                        <span class="heart-icon"><i class="fa fa-heart-o"></i></span>
                        <span class="title-tag">by instructor</span>
                        <div class="course-title margin-top-10">
                            <h4><a href="course-details.html">user experience design with adobe XD</a></h4>
                        </div>
                        <div class="course-price-info margin-top-20">
                            <span class="best-seller">best seller</span>
                            <span class="course-category"><a href="#">web design</a></span>
                            <span class="course-price">$ 400.00</span>
                        </div>
                        <div class="course-info margin-top-30">
                            <div class="course-enroll">
                                <span>enrolled 0</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <p class="margin-top-20">Learn WordPress like a Professional! Start from the basics and go all the way to creating your own applications and website!</p>
                        <ul class="margin-top-20">
                            <li><i class="fa fa-circle-o"></i><span>Lorem ipsum dolor sit amet.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Consectetur adipisicing elit.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Placeat dolore quaerat itaque.</span></li>
                        </ul>
                        <div class="preview-button margin-top-20">
                            <a href="course-details.html" class="template-button">course preview</a>
                            <a href="cart.html" class="template-button margin-left-10">add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 grid-item photography">
                <div class="single-course-item">
                    <div class="course-image">
                        <img src="<c:url value="/public/assets/images/course-image-4.png"/>" alt="image">
                    </div>
                    <div class="course-content margin-top-30">
                        <div class="course-title">
                            <h4>learn photography from scratch</h4>
                        </div>
                        <div class="course-instructor-rating margin-top-20">
                            <div class="course-instructor">
                                <img src="<c:url value="/public/assets/images/course-instructor-3.png"/>" alt="instructor">
                                <h6>chris doe</h6>
                            </div>
                            <div class="course-rating">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>4.2(30)</span>
                            </div>
                        </div>
                        <div class="course-info margin-top-20">
                            <div class="course-view">
                                <i class="fa fa-eye"></i>
                                <span>10,000 views</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>30 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>1h 40mins</span>
                            </div>
                        </div>
                        <div class="course-price-cart margin-top-20">
                            <div class="course-price">
                                <span class="span-big">$ 200.00</span>
                                <span class="span-cross">$ 400.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="hover-state">
                        <span class="heart-icon"><i class="fa fa-heart-o"></i></span>
                        <span class="title-tag">by instructor</span>
                        <div class="course-title margin-top-10">
                            <h4><a href="course-details.html">learn photography from scratch</a></h4>
                        </div>
                        <div class="course-price-info margin-top-20">
                            <span class="best-seller">best seller</span>
                            <span class="course-category"><a href="#">web design</a></span>
                            <span class="course-price">$ 200.00</span>
                        </div>
                        <div class="course-info margin-top-30">
                            <div class="course-enroll">
                                <span>enrolled 0</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <p class="margin-top-20">Learn WordPress like a Professional! Start from the basics and go all the way to creating your own applications and website!</p>
                        <ul class="margin-top-20">
                            <li><i class="fa fa-circle-o"></i><span>Lorem ipsum dolor sit amet.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Consectetur adipisicing elit.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Placeat dolore quaerat itaque.</span></li>
                        </ul>
                        <div class="preview-button margin-top-20">
                            <a href="course-details.html" class="template-button">course preview</a>
                            <a href="cart.html" class="template-button margin-left-10">add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 grid-item web">
                <div class="single-course-item diffrent-bg-color">
                    <div class="course-image">
                        <img src="<c:url value="/public/assets/images/course-image-5.png"/>" alt="image">
                    </div>
                    <div class="course-content margin-top-30">
                        <div class="course-title">
                            <h4>learn about microsoft SQL server</h4>
                        </div>
                        <div class="course-instructor-rating margin-top-20">
                            <div class="course-instructor">
                                <img src="<c:url value="/public/assets/images/course-instructor-4.png"/>" alt="instructor">
                                <h6>john doe</h6>
                            </div>
                            <div class="course-rating">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>4.2(30)</span>
                            </div>
                        </div>
                        <div class="course-info margin-top-20">
                            <div class="course-view">
                                <i class="fa fa-eye"></i>
                                <span>25,000 views</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <div class="course-price-cart margin-top-20">
                            <div class="course-price">
                                <span class="span-big">$ 300.00</span>
                                <span class="span-cross">$ 400.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="hover-state">
                        <span class="heart-icon"><i class="fa fa-heart-o"></i></span>
                        <span class="title-tag">by instructor</span>
                        <div class="course-title margin-top-10">
                            <h4><a href="course-details.html">learn about microsoft SQL server</a></h4>
                        </div>
                        <div class="course-price-info margin-top-20">
                            <span class="best-seller">best seller</span>
                            <span class="course-category"><a href="#">web design</a></span>
                            <span class="course-price">$ 300.00</span>
                        </div>
                        <div class="course-info margin-top-30">
                            <div class="course-enroll">
                                <span>enrolled 0</span>
                            </div>
                            <div class="course-video">
                                <i class="fa fa-play-circle-o"></i>
                                <span>36 lectures</span>
                            </div>
                            <div class="course-time">
                                <i class="fa fa-clock-o"></i>
                                <span>2h 40mins</span>
                            </div>
                        </div>
                        <p class="margin-top-20">Learn WordPress like a Professional! Start from the basics and go all the way to creating your own applications and website!</p>
                        <ul class="margin-top-20">
                            <li><i class="fa fa-circle-o"></i><span>Lorem ipsum dolor sit amet.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Consectetur adipisicing elit.</span></li>
                            <li><i class="fa fa-circle-o"></i><span>Placeat dolore quaerat itaque.</span></li>
                        </ul>
                        <div class="preview-button margin-top-20">
                            <a href="course-details.html" class="template-button">course preview</a>
                            <a href="cart.html" class="template-button margin-left-10">add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- CounterUp Section Starts -->
<section class="counterup-section">
    <div class="container">
        <div class="counterup-content common-section padding-top-60 padding-bottom-30">
            <div class="counter-shape">
                <img src="<c:url value="/public/assets/images/round-shape-2.png"/>" alt="shape" class="round-shape-2">
                <img src="<c:url value="/public/assets/images/plus-sign.png"/>" alt="shape" class="plus-sign item-rotate">
                <img src="<c:url value="/public/assets/images/round-shape-3.png"/>" alt="shape" class="round-shape-3">
            </div>
            <div class="row align-items-center">
                <div class="col-xl-3 col-sm-6">
                    <div class="single-counterup">
                        <div class="single-counterup-image">
                            <img src="<c:url value="/public/assets/images/counter-image-1.png"/>" alt="image">
                        </div>
                        <div class="single-counterup-content">
                            <div class="counter-number">
                                <h3 class="title counter">2000</h3>
                                <h3 class="title">+</h3>
                            </div>
                            <span>expert instructors</span>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-sm-6">
                    <div class="single-counterup">
                        <div class="single-counterup-image">
                            <img src="<c:url value="/public/assets/images/category-icon-3.png"/>" alt="image">
                        </div>
                        <div class="single-counterup-content">
                            <div class="counter-number">
                                <h3 class="title counter">7000</h3>
                                <h3 class="title">+</h3>
                            </div>
                            <span>students enrolled</span>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-sm-6">
                    <div class="single-counterup">
                        <div class="single-counterup-image">
                            <img src="<c:url value="/public/assets/images/counter-image-2.png"/>" alt="image">
                        </div>
                        <div class="single-counterup-content">
                            <div class="counter-number">
                                <h3 class="title counter">10</h3>
                                <h3 class="title">+</h3>
                            </div>
                            <span>experience years</span>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-sm-6">
                    <div class="single-counterup">
                        <div class="single-counterup-image">
                            <img src="<c:url value="/public/assets/images/category-icon-6.png"/>" alt="image">
                        </div>
                        <div class="single-counterup-content">
                            <div class="counter-number">
                                <h3 class="title counter">50</h3>
                                <h3 class="title">+</h3>
                            </div>
                            <span>total course</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Instructor Section Starts -->
<section class="instructor-section gradient-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title text-center">
                    <h2>top online <span>instructors</span></h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="single-instructor">
                    <span class="instructor-sign">john</span>
                    <div class="instructor-image">
                        <a href="#"><img src="<c:url value="/public/assets/images/instructor-1.png"/>" alt="image"></a>
                    </div>
                    <div class="instructor-content">
                        <h4><a href="#">john doe</a></h4>
                        <span>founder CEO</span>
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
            <div class="col-lg-3 col-md-6">
                <div class="single-instructor diffrent-bg-color">
                    <span class="instructor-sign">arya</span>
                    <div class="instructor-image">
                        <a href="#"><img src="<c:url value="/public/assets/images/instructor-3.png"/>" alt="image"></a>
                    </div>
                    <div class="instructor-content">
                        <h4><a href="#">arya stark</a></h4>
                        <span>web teacher</span>
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
            <div class="col-lg-3 col-md-6">
                <div class="single-instructor">
                    <span class="instructor-sign">chris</span>
                    <div class="instructor-image">
                        <a href="#"><img src="<c:url value="/public/assets/images/instructor-2.png"/>" alt="image"></a>
                    </div>
                    <div class="instructor-content">
                        <h4><a href="#">chris wokes</a></h4>
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
            <div class="col-lg-3 col-md-6">
                <div class="single-instructor diffrent-bg-color">
                    <span class="instructor-sign">devid</span>
                    <div class="instructor-image">
                        <a href="#"><img src="<c:url value="/public/assets/images/instructor-4.png"/>" alt="image"></a>
                    </div>
                    <div class="instructor-content">
                        <h4><a href="#">devid walter</a></h4>
                        <span>marketing teacher</span>
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
        <div class="row">
            <div class="col-lg-12">
                <div class="instructor-button margin-top-20 text-center">
                    <a href="#" class="template-button">see more instructor</a>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- About Section Starts -->
<section class="about-section padding-top-115">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title text-center">
                    <h2>know about <span>courses</span></h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="about-content-left">
                    <div class="about-single-content">
                        <div class="content-top">
                            <div class="content-icon template-icon green-icon">
                                <i class="icofont-document-folder"></i>
                            </div>
                            <h5>learn anything</h5>
                        </div>
                        <p class="margin-top-10">Explore a variety of fresh topics Podcasting better management inside workflows.</p>
                    </div>
                    <div class="about-single-content">
                        <div class="content-top">
                            <div class="content-icon template-icon yellow-icon">
                                <i class="icofont-layers"></i>
                            </div>
                            <h5>learn together</h5>
                        </div>
                        <p class="margin-top-10">Explore a variety of fresh topics Podcasting better management inside workflows.</p>
                    </div>
                    <div class="about-single-content">
                        <div class="content-top">
                            <div class="content-icon template-icon blue-icon">
                                <i class="icofont-hard-disk"></i>
                            </div>
                            <h5>online course</h5>
                        </div>
                        <p class="margin-top-10">Explore a variety of fresh topics Podcasting better management inside workflows.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="video-popup-area">
                    <div class="video-play-button">
                        <a href="https://www.youtube.com/watch?v=8AGgbIQyqR8" class="button-video">
                            <i class="fa fa-play item-ripple"></i>
                        </a>
                    </div>
                    <img src="<c:url value="/public/assets/images/about-image.png"/>" alt="image">
                    <div class="image-absolute">
                        <img src="<c:url value="/public/assets/images/hero-small-image-4.png"/>" alt="image" class="top-absolute">
                        <img src="<c:url value="/public/assets/images/hero-small-image-2.png"/>" alt="image" class="bottom-absolute">
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="about-content-right">
                    <div class="about-single-content">
                        <div class="content-top">
                            <div class="content-icon template-icon green-icon">
                                <i class="icofont-learn"></i>
                            </div>
                            <h5>bright mind & idea</h5>
                        </div>
                        <p class="margin-top-10">Explore a variety of fresh topics Podcasting better management inside workflows.</p>
                    </div>
                    <div class="about-single-content">
                        <div class="content-top">
                            <div class="content-icon template-icon yellow-icon">
                                <i class="icofont-library"></i>
                            </div>
                            <h5>wherever you go</h5>
                        </div>
                        <p class="margin-top-10">Explore a variety of fresh topics Podcasting better management inside workflows.</p>
                    </div>
                    <div class="about-single-content">
                        <div class="content-top">
                            <div class="content-icon template-icon blue-icon">
                                <i class="icofont-certificate-alt-1"></i>
                            </div>
                            <h5>customer preference</h5>
                        </div>
                        <p class="margin-top-10">Explore a variety of fresh topics Podcasting better management inside workflows.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- News Section Starts -->
<section class="blog-section padding-top-80 padding-bottom-120">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title text-center">
                    <h2>latest news & <span>article</span></h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="blog-single-item">
                    <div class="single-blog-image">
                        <a href="#"><img src="<c:url value="/public/assets/images/news-1.jpg"/>" alt="blog"></a>
                    </div>
                    <div class="blog-meta">
                        <ul>
                            <li><a href="#"><i class="fa fa-user-o"></i>john doe</a></li>
                            <li><a href="#"><i class="fa fa-bookmark-o"></i>education, learning</a></li>
                        </ul>
                    </div>
                    <div class="single-blog-content">
                        <h4 class="title"><a href="blog.html">Latest News Of wordPress development</a></h4>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="blog-single-item">
                    <div class="single-blog-image">
                        <a href="#"><img src="<c:url value="/public/assets/images/news-2.jpg"/>" alt="blog"></a>
                    </div>
                    <div class="blog-meta">
                        <ul>
                            <li><a href="#"><i class="fa fa-user-o"></i>arya stark</a></li>
                            <li><a href="#"><i class="fa fa-bookmark-o"></i>education, learning</a></li>
                        </ul>
                    </div>
                    <div class="single-blog-content">
                        <h4 class="title"><a href="blog.html">learn about web development</a></h4>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="blog-single-item">
                    <div class="single-blog-image">
                        <a href="#"><img src="<c:url value="/public/assets/images/news-3.jpg"/>" alt="blog"></a>
                    </div>
                    <div class="blog-meta">
                        <ul>
                            <li><a href="#"><i class="fa fa-user-o"></i>devid walter</a></li>
                            <li><a href="#"><i class="fa fa-bookmark-o"></i>education, learning</a></li>
                        </ul>
                    </div>
                    <div class="single-blog-content">
                        <h4 class="title"><a href="blog.html">learn about user interface Design</a></h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="blog-button text-center margin-top-20">
                    <a href="#" class="template-button">see more blog</a>
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

<jsp:include page="WEB-INF/views/client/footer/footer.jsp"></jsp:include>
<br/>
</body>
</html>