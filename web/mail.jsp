<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-06-02
  Time: 오후 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail</title>
</head>
<body>
<form action="mail.do" method="post">
    <table>
        <tr>
            <td><label>receiver : <input type="text" name="receiver" id="receiver" onchange="checkEmail()"/></label> </td>
        </tr>
        <tr>
            <td><label id="alarm"></label></td>
        </tr>
        <tr>
            <td>subject : <input type="text" name="subject"/></td>
        </tr>
        <tr>
            <td>body : <textarea rows="10" cols="50" name="body"></textarea></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
<button onclick="window.location.href='student.do'">back to student</button>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    function checkEmail() {
        //get email
        var email = $("#receiver").val();

        //set regexp
        var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

        if (email.match(regExp) != null) {
            $("#alarm").html("<span style='color:blue;'>right email</span>");
        }
        else {
            $("#alarm").html("<span style='color:red;'>wrong email</span>");
        }
    };

    $(document).ready(function() {
        $(window).keydown(function(event){
            if(event.keyCode == 13) {
                event.preventDefault();
                return false;
            }
        });
    });
</script>
<script src="js/main.js"></script>
</body>
</html>
