<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-29
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>write</title>
    <link rel="stylesheet" type="text/css" href="css/layer_button.css"/>
    <script>
        function formCheck() {
            var title = document.forms[0].title.value;
            var writer = document.forms[0].writer.value;
            var date = document.forms[0].date.value;
            var content = document.forms[0].content.value; // 추가되었습니다. 글내용

            if (title == null || title === "") {      // null인지 비교한 뒤
                alert('제목을 입력하세요');           // 경고창을 띄우고
                document.forms[0].title.focus();    // 해당태그에 포커스를 준뒤
                return false;                       // false를 리턴합니다.
            }
            if (content == null || content === "") {
                alert('내용을 입력하세요');
                document.forms[0].content.focus();
                return false;
            }
        }

        window.onload = function () {
            let date = document.getElementsByName("date")[0];
            date.value = new Date().toISOString().split('T')[0];
        }
    </script>

</head>
<body>
<div class="layer" align="center">
    <form action="insert.do" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
        <table>
            <tr>
                <td>title :</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr style="display: none">
                <td>date :</td>
                <td><input type="text" name="date"></td>
            </tr>
            <tr>
                <td>content :</td>
                <td><textarea rows="10" cols="20" name="content"></textarea></td>
            </tr>
            <tr>
                <td>file :</td>
                <td><input type="file" name="fileName"></td>
            </tr>
        </table>
        <input type="submit" value="post"/>
    </form>
    <button onclick="window.location.href='list.do'">back to board</button>
</div>
</body>
</html>
