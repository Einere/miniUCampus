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
    <title>home</title>
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
<button onclick="lecture()">lecture</button>
<button onclick="free()">free</button>
<c:if test="${identity eq 'professor'}">
    <button onclick="window.location.href='student.do'">student</button>
</c:if>
<button onclick="window.location.href='signout.do'">sign out</button>
<div>
    <span>welcome, ${identity}, ${id}, ${name}</span>
</div>
</body>
</html>
