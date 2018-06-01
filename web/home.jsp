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
            window.location.href="list.do?dest=lecture";
        }
    </script>
</head>
<body>
<button onclick="lecture()">lecture</button>
<button onclick="free()">free</button>
</body>
</html>
