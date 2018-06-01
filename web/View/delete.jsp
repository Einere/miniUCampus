<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-29
  Time: 오전 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
    <title>MVC 게시판</title>
</head>
<body>
<form name="deleteForm" action="./BoardDeleteAction.bo?num=<%=num %>" method="post">
    <table border=1>
        <tr>
            <td>
                <label>글 비밀번호 : </label>
            </td>
            <td>
                <input name="BOARD_PASS" type="password">
            </td>
        </tr>
        <tr>
            <td colspan=2 align=center>
                <a href="javascript:deleteForm.submit()">삭제</a>
                &nbsp;&nbsp;
                <a href="javascript:history.go(-1)">돌아가기</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
