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
    <title>MVC 게시판</title>
    <script type="text/javascript">
        function modifyboard() {
            modifyform.submit();
        }
    </script>
</head>
<body>
<!-- 게시판 수정 -->
<form action="BoardModifyAction.bo" method="post" name="modifyform">
    <input type="hidden" name="BOARD_NUM" value=<%=board.getIndex() %>>
    <table cellpadding="0" cellspacing="0">
        <tr align="center" valign="middle">
            <td colspan="5">MVC 게시판</td>
        </tr>
        <tr>
            <td height="16" style="font-family:돋음; font-size:12px;">
                <div align="center">제 목</div>
            </td>
            <td>
                <input name="BOARD_SUBJECT" size="50" maxlength="100"
                       value="<%=board.getTitle()%>">
            </td>
        </tr>
        <tr>
            <td style="font-family:돋음; font-size:12px;">
                <div align="center">내 용</div>
            </td>
            <td>
            <textarea name="BOARD_CONTENT" cols="67" rows="15">
            <%=board.getContent() %>
            </textarea>
            </td>
        </tr>
        <%if (!(board.getFile() == null)) { %>
        <tr>
            <td style="font-family:돋음; font-size:12px;">
                <div align="center">파일 첨부</div>
            </td>
            <td>
                &nbsp;&nbsp;<%=board.getFile() %>
            </td>
        </tr>
        <%} %>
        <tr>
        </tr>
        <tr bgcolor="cccccc">
            <td colspan="2" style="height:1px;">
            </td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr align="center" valign="middle">
            <td colspan="5">
                <a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
                <a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
<!-- 게시판 수정 -->
</body>
</html>