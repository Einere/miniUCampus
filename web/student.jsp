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
    <title>student</title>
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
    <label>search : <input type="text" id="search"></label>
    <button onclick="search()">search</button>
    <div>
        <h1>Student</h1>
    </div>
    <div class="limiter">
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table100 ver4 m-b-10">
                    <div class="table100-head">
                        <table>
                            <thead>
                            <tr class="row100 head">
                                <th class="cell100 column1">sNumber</th>
                                <th class="cell100 column2">Major_number</th>
                                <th class="cell100 column3">sYear</th>
                                <th class="cell100 column4">Email</th>
                                <th class="cell100 column5">sGender</th>
                                <th class="cell100 column5">phone_Number</th>
                            </tr>
                            </thead>
                        </table>
                    </div>

                    <div class="table100-body js-pscroll">
                        <table>
                            <tbody id="tbody">
                            <c:forEach items="${studentList}" var="student">
                                <tr class="row100 body" onclick="window.location.href=''">
                                    <td class="cell100 column1">${student.sNumber}</td>
                                    <td class="cell100 column2">${student.Major_number}</td>
                                    <td class="cell100 column3">${student.SYear}</td>
                                    <td class="cell100 column4">${student.Email}</td>
                                    <td class="cell100 column5">${student.SGender}</td>
                                    <td class="cell100 column5">${student.Phone_Number}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <button onclick="window.location.href=''">mail</button>
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

    function search() {
        //get serach id
        let searchId = $("#search").val();

        //reset tbody
        let tbody = $("#tbody");
        tbody.empty();

        //set new row
        for(let student of ${studentList}){
            if(searchId === student.sNumber){
                let newTr = $("<tr></tr>").props({class: "row100 body", onclick: window.location.href=''});
                let newTd1 = $("<td></td>").props("class", "cell100 column1").val(student.sNumber);
                let newTd2 = $("<td></td>").props("class", "cell100 column2").val(student.Major_number);
                let newTd3 = $("<td></td>").props("class", "cell100 column3").val(student.sYear);
                let newTd4 = $("<td></td>").props("class", "cell100 column4").val(student.Email);
                let newTd5 = $("<td></td>").props("class", "cell100 column5").val(student.sGender);
                let newTd6 = $("<td></td>").props("class", "cell100 column5").val(student.phone_Number);
                newTr.appendChild(newTd1);
                newTr.appendChild(newTd2);
                newTr.appendChild(newTd3);
                newTr.appendChild(newTd4);
                newTr.appendChild(newTd5);
                newTr.appendChild(newTd6);
                tbody.appendChild(newTr);
            }
        }
    }
</script>
<script src="js/main.js"></script>
</body>
</html>
