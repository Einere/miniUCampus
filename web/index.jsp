<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-30
  Time: 오후 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Kwangwoon University</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css\index.css"/>
</head>
<body>
<header>
    <div class="container">
        <a href="index.jsp"><img src="images/logoImage/main_logo.jpg" height="70px" alt="main logo"></a>
        <nav class="headNav">
            <a href="login.jsp" target="_blank" class="toUCam">U-CAM</a>
        </nav>
    </div>
</header>
<section class="mid">
    <div class="slider">
        <ul class="slides">
            <li class="slide"><img src="images/slideImage/00.jpg" alt="slide1" title="메인화면" width="800px"/></li>
            <li class="slide"><img src="images/slideImage/01.jpg" alt="slide2" title="기념관" width="800px"/></li>
            <li class="slide"><img src="images/slideImage/02.jpg" alt="slide3" title="비마상" width="800px"/></li>
            <li class="slide"><img src="images/slideImage/03.jpg" alt="slide4" title="새빛관" width="800px"/></li>
            <li class="slide"><img src="images/slideImage/04.jpg" alt="slide5" title="광팡야" width="800px"/></li>
        </ul>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        var currentSlide = 1;
        var $slider = $(".slides");
        var slideCount =$slider.children().length;
        var slideTime = 4000;
        var animationTime = 800;

        setInterval(function() {
            $slider.animate({
                marginLeft : '-=800px'
            } , animationTime , function(){
                currentSlide++;
                if(currentSlide === slideCount) {
                    currentSlide = 1;
                    $(this).css("margin-left", "0px");
                }
            });
        } , slideTime);
    </script>
</section>
</body>
</html>
