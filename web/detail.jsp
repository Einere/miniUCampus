<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-29
  Time: 오후 7:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>detail</title>
    <link rel="stylesheet" type="text/css" href="css/layer_button.css"/>
    <style>
        .download{
            cursor: pointer;
        }
    </style>
    <script>
        function onDownload(index) {
            let elem = document.getElementById("download");
            elem.src = "download.do?index=" + index;
        }
    </script>
</head>
<body>
<div class="layer" align="center">
    <h1>detail</h1>
    <table border="1">                            <!-- border은 테두리를 표시하는 속성입니다. -->
        <tr>
            <th>index</th>
            <td>${index}</td>
            <th>writer</th>
            <td>${writer}</td>
            <th>dte</th>
            <td>${date}</td>
            <th>view</th>
            <td>${view}</td>
        </tr>
        <tr>
            <th colspan="2">title</th>                     <!-- colspan은 행병합 속성입니다. -->
            <td colspan="6">${title}</td>
        </tr>
        <tr>
            <th colspan="2">content</th>
            <td colspan="6">${content}</td>
        </tr>
        <tr>
            <th colspan="2">첨부파일</th>
            <td colspan="8">
                <a href="#" onclick="onDownload('${index}')">${fileName}</a>
            </td>
        </tr>
    </table>
    <br/>
    <button onclick="window.location.href='delete.do?index=' + ${index}">delete</button>
    <button onclick="window.location.href='list.do'">back to board</button>
</div>
<iframe id="download" style="position:absolute; z-index:1; visibility:hidden;"></iframe>
</body>
</html>
