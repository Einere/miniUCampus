<%@ page import="java.util.*" %>
<%@ page import="Beans.BoardBean" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-28
  Time: 오후 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    try{
        List boardList = (List) request.getAttribute("boardlist");
        int listcount = (Integer) request.getAttribute("listcount");
        int nowpage = (Integer) request.getAttribute("page");
        int maxpage = (Integer) request.getAttribute("maxpage");
        int startpage = (Integer) request.getAttribute("startpage");
        int endpage = (Integer) request.getAttribute("endpage");
    }catch(Exception e){
        int listcount = 0;
        int nowpage = 0;
        int maxpage = 0;
        int startpage = 0;
        int endpage = 0;
    }
    BoardBean bl = null;
%>
<html>
<head>
    <title>MVC 게시판</title>
</head>
<body>
<!-- 게시판 리스트 -->
<table width=50% border="0" cellpadding="0" cellspacing="0">
    <tr align="center" valign="middle">
        <td colspan="4">MVC 게시판</td>
        <td align=right>글 개수 : ${listcount}</td>
    </tr>
    <tr align="center" valign="middle" bordercolor="#333333">
        <td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
            <div align="center">번호</div>
        </td>
        <td style="font-family:Tahoma;font-size:8pt;" width="50%">
            <div align="center">제목</div>
        </td>
        <td style="font-family:Tahoma;font-size:8pt;" width="14%">
            <div align="center">작성자</div>
        </td>
        <td style="font-family:Tahoma;font-size:8pt;" width="17%">
            <div align="center">날짜</div>
        </td>
        <td style="font-family:Tahoma;font-size:8pt;" width="11%">
            <div align="center">조회수</div>
        </td>
    </tr>
    <%
        for (int i = 0; i < boardList.size(); i++) {
            bl = (BoardBean) boardList.get(i);
        }
    %>
    <tr align="center" valign="middle" bordercolor="#333333"
        onmouseover="this.style.backgroundColor='F8F8F8'"
        onmouseout="this.style.backgroundColor=''">
        <td height="23" style="font-family:Tahoma;font-size:10pt;">
            <%=bl.getIndex()%>
        </td>
        <td style="font-family:Tahoma;font-size:10pt;">
            <div align="left">
                <!--%if (bl.getBOARD_RE_LEV() != 0) { %>
                <!--%for (int a = 0; a <= bl.getBOARD_RE_LEV() * 2; a++) { %>
                &nbsp;
                <!--%} %>
                ▶
                <!--%} else { %>
                ▶
                <!--%} %>
                <a href="./BoardDetailAction.bo?num=<!--%=bl.getBOARD_NUM()%>">
                    <!--%=bl.getBOARD_SUBJECT()%>
                </a-->
            </div>
        </td>
        <td style="font-family:Tahoma;font-size:10pt;">
            <div align="center"><%=bl.getWriter() %>
            </div>
        </td>
        <td style="font-family:Tahoma;font-size:10pt;">
            <div align="center"><%=bl.getDate() %>
            </div>
        </td>
        <td style="font-family:Tahoma;font-size:10pt;">
            <div align="center"><%=bl.getViewCount() %>
            </div>
        </td>
    </tr>
    <!--%} %-->
    <tr align=center height=20>
        <td colspan=7 style=font-family:Tahoma;font-size:10pt;>
            <%if (nowpage <= 1) { %>
            [이전]&nbsp;
            <%} else { %>
            <a href="./BoardList.bo?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
            <%} %>
            <%
                for (int a = startpage; a <= endpage; a++) {
                    if (a == nowpage) {
            %>
            [<%=a %>]
            <%} else { %>
            <a href="./BoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
            <%} %>
            <%} %>
            <%if (nowpage >= maxpage) { %>
            [다음]
            <%} else { %>
            <a href="./BoardList.bo?page=<%=nowpage+1 %>">[다음]</a>
            <%} %>
        </td>
    </tr>
    <tr align="right">
        <td colspan="5">
            <a href="./BoardWrite.bo">[글쓰기]</a>
        </td>
    </tr>
</body>
</html>
