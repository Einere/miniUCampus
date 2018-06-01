<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-05-23
  Time: 오전 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--jsp:include page="WEB-INF/jsLibrary.jsp" -->
<html>
<head>
    <title>Login</title>
    <style type="text/css">
        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 14px;
        }

        label {
            font-weight: bold;
            width: 100px;
            font-size: 14px;
        }

        .box {
            border: #666666 solid 1px;
        }

        .layer {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            display: -webkit-flex;
            /*-webkit-align-item:center;*/
            -webkit-justify-content: center;
        }
    </style>
</head>
<body>
<div align="center" class="layer">
    <div style="width: 350px; border: solid 1px;" align="center">
        <div style="background-color:#333333; color:#FFFFFF; padding:10px;"><b>Log in</b></div>
        <div style="margin:30px;">
            <form action="signin.do" method="post">
                <table>
                    <tr>
                        <td><label>Id : </label></td>
                        <td><input type="text" name="id" class="box"/></td>
                    </tr>
                    <tr>
                        <td><label>Password : </label></td>
                        <td><input type="password" name="pw" class="box"/></td>
                    </tr>
                    <tr>
                        <td><label>Identity : </label></td>
                        <td>
                            <select name="identity" class="box">
                                <option value="student">student</option>
                                <option value="professor">professor</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Log in" style="margin-right: 40px;"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
