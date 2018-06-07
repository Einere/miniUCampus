<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-06-01
  Time: 오후 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>U-CAMPUS</title>
    <script>
        function lecture(){
            window.location.href="list.do?dest=lecture";
        }
        function free(){
            window.location.href="list.do?dest=free";
        }
    </script>
</head>
<body>
<div>
    <span>welcome, ${identity}, ${id}, ${name}</span>
</div>

<section class="icons">
    <div class="topIcons">
        <c:if test="${identity eq 'professor'}">
        <button onclick="window.location.href='student.do'" class="student"><img src="images/logoImage/student.png"></button>
        </c:if>
        <button onclick="window.location.href='signout.do'" class="signout"><img src="images/logoImage/signout.png"></button>
    </div>
    <div class="mainIcons">
        <button onclick="lecture()"><img src="images/logoImage/lecture.png" width="300px" class="lecture"></button>
        <button onclick="free()"><img src="images/logoImage/free.png"width="300px" class="free"></button>
    </div>
</section>
</body>
</html>
