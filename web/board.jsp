<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-26
  Time: 오후 7:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Beans.BoardBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>lecture</title>
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/layer_button.css"/>
</head>
<body>
<div align="center">
    <div>
        <h1>lecture</h1>
    </div>
    <div class="limiter">
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table100 ver4 m-b-10">
                    <div class="table100-head">
                        <table>
                            <thead>
                            <tr class="row100 head">
                                <th class="cell100 column1">index</th>
                                <th class="cell100 column2">title</th>
                                <th class="cell100 column3">writer</th>
                                <th class="cell100 column4">date</th>
                                <th class="cell100 column5">view</th>
                            </tr>
                            </thead>
                        </table>
                    </div>

                    <div class="table100-body js-pscroll">
                        <table>
                            <tbody>
                            <c:forEach items="${postList}" var="post">
                                <tr class="row100 body">
                                    <td class="cell100 column1">${post.index}</td>
                                    <td class="cell100 column2" onclick="window.location.href='count.do?index=${post.index}'">${post.title}</td>
                                    <td class="cell100 column3">${post.writer}</td>
                                    <td class="cell100 column4">${post.date}</td>
                                    <td class="cell100 column5">${post.view}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <button onclick="window.location.href='write.jsp'">write</button>
</div>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function () {
        let ps = new PerfectScrollbar(this);

        $(window).on('resize', function () {
            ps.update();
        })
    });
</script>
<script src="js/main.js"></script>
</body>
</html>
