<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-23
  Time: 오전 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--jsp:include page="WEB-INF/jsLibrary.jsp" -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>U-Campus Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css"/>
</head>

<body>

<section class="logoContainer">
    <a href="index.jsp"><img src="images/logoImage/no_back_logo.png" height="100px" alt="toMain" class="logo"></a>
</section>
<section class="user">
    <form action="signin.do" method="post">
        <ul class= "info">
            <li><select name="identity" class="getLV">
                <option value="student">학부생</option>
                <option value="professor">교수</option>
            </select></li>
            <li><input type="text" name="id" placeholder="아이디" class="getID"></li>
            <li><input type="password" name="pw" placeholder="비밀번호"class="getPW"></li>
            <li><input type="submit" value="로그인" class="loginButton" ></li>
        </ul>
    </form>
</section>
</body>