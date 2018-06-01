<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-28
  Time: 오후 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Beans.BoardBean" %>
<%
    BoardBean board = (BoardBean) request.getAttribute("boarddata");
%>
<html>
<head>
    <title>Board</title>
</head>
<body>

<!-- 게시판 수정 -->
<table cellpadding="0" cellspacing="0">
    <tr align="center" valign="middle">
        <td colspan="5">MVC 게시판</td>
    </tr>
    <tr>
        <td style="font-family:돋음; font-size:12px;" height="16">
            <div align="center">제 목&nbsp;&nbsp;</div>
        </td>
        <td style="font-family:돋음; font-size:12px;">
            <%=board.getTitle()%>
        </td>
    </tr>
    <tr bgcolor="cccccc">
        <td colspan="2" style="height:1px;">
        </td>
    </tr>
    <tr>
        <td style="font-family:돋음; font-size:12px;">
            <div align="center">내 용</div>
        </td>
        <td style="font-family:돋음; font-size:12px;">
            <table border=0 width=490 height=250 style="table-layout:fixed">
                <tr>
                    <td valign=top style="font-family:돋음; font-size:12px;">
                        <%=board.getContent() %>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td style="font-family:돋음; font-size:12px;">
            <div align="center">첨부파일</div>
        </td>
        <td style="font-family:돋음; font-size:12px;">
            <%if (!(board.getFile() == null)) { %>
            <a href="./boardupload/<%=board.getFile()%>">
                <%=board.getFile() %>
            </a>
            <%} %>
        </td>
    </tr>
    <tr bgcolor="cccccc">
        <td colspan="2" style="height:1px;"></td>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
    <tr align="center" valign="middle">
        <td colspan="5">
            <a href="./BoardModify.bo?num=<%=board.getIndex() %>">
                [수정]
            </a>&nbsp;&nbsp;
            <a href="./BoardDelete.bo?num=<%=board.getIndex() %>">
                [삭제]
            </a>&nbsp;&nbsp;
            <a href="./BoardList.bo">[목록]</a>&nbsp;&nbsp;
        </td>
    </tr>
</table>
</body>
</html>
