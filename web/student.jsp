<%--
  Created by IntelliJ IDEA.
  User: HJ
  Date: 2018-06-02
  Time: 오후 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Board</title>
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/layer_button.css"/>
</head>
<body>
<div align="center">
    <div>
        <label>id : <input type="text" id="search"/></label>
        <button onclick="search()">search</button>
    </div>
    <label>lecture : </label>
    <select name="lectures" id="lectures" onchange="selectChanged()">
        <c:forEach items="${lectureList}" var="lecture">
            <option value="${lecture}" <c:if test="${lecture eq lectureName}">selected</c:if>>${lecture}</option>
        </c:forEach>
    </select>
    <div>
        <h1>Student</h1>
    </div>
    <form method="post" action="mail.do" onsubmit="return check()">
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100 ver4 m-b-10">
                        <div class="table100-head">
                            <table>
                                <thead>
                                <tr class="row100 head">
                                    <th class="cell100 column1_1">check</th>
                                    <th class="cell100 column2_2">sNumber</th>
                                    <th class="cell100 column3_3">Major</th>
                                    <th class="cell100 column4_4">sYear</th>
                                    <th class="cell100 column5_5">Email</th>
                                    <th class="cell100 column6_6">sGender</th>
                                    <th class="cell100 column7_7">phone</th>
                                </tr>
                                </thead>
                            </table>
                        </div>

                        <div class="table100-body js-pscroll">
                            <table>
                                <tbody id="tbody">
                                <c:forEach items="${studentList}" var="student">
                                    <tr class="row100 body" onclick="">
                                        <td class="cell100 column1_1"><input type="checkbox" name="mailList" value="${student.email}"></td>
                                        <td class="cell100 column2_2">${student.SNumber}</td>
                                        <td class="cell100 column3_3">${student.major_number}</td>
                                        <td class="cell100 column4_4">${student.SYear}</td>
                                        <td class="cell100 column5_5">${student.email}</td>
                                        <td class="cell100 column6_6">${student.SGender}</td>
                                        <td class="cell100 column7_7">${student.phone_number}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <table>
            <tr>
                <td>subject : <input type="text" name="subject"/></td>
            </tr>
            <tr>
                <td>body : <textarea rows="10" cols="50" name="body"></textarea></td>
            </tr>
        </table>
        <input type="submit" value="mailmailmail">
    </form>
    <button onclick="window.location.href='redirectToHomeAction.do'">back to home</button>
</div>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function () {
        let ps = new PerfectScrollbar(this);

        $(window).on('resize', function () {
            ps.update();
        })
    });

    function selectChanged() {
        window.location.href = "student.do?lectureName=" + $('#lectures option:selected').val();
    }

    function search() {
        //get search id
        let searchId = $('#search').val();

        let parent = $('.cell100.column2_2');
        for (let child of parent) {
            if (child.innerHTML !== "sNumber" && child.innerHTML !== searchId) {
                let tr = child.parentElement;
                let tbody = tr.parentElement;
                tbody.removeChild(tr);
            }
        }
    }

    function check() {
        let mailList = document.getElementsByName("mailList");

        for (let mail of mailList) {
            if (mail.checked) return true;
        }
        return false;
    }


</script>
<script src="js/main.js"></script>
</body>
</html>

