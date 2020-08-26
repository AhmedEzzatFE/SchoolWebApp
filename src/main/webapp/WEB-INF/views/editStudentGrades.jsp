<%@ page import="Service.AdminService" %>
<%@ page import="java.sql.*" %>
<%@ page import="Service.AdminService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        .container{background-color: darkgray}

    </style>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
        $(document).ready(function(){
            $("select.selectCourse").change(function(){
                var selectedCountry = $(this).children("option:selected").val();
               $.ajax({
                   type:'POST',data:{Selected:selectedCountry,action:'demo1'},url:"editStudentGrades.do",success:function (result) {
                 $('#result1').html(result)
                   }
               })
            });
        });
    </script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
        var result=null;
        var grade=null;
        function GetSelectedText() {
            var e = document.getElementById("SelectCourse");
            result = e.options[e.selectedIndex].text;
            document.getElementById("result").innerHTML = result;

        }

    </script>
</head>
<body class="container">
<div>
    <nav class="navbar navbar-default">

        <a href="/" class="navbar-brand">My School</a>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/administerStudent.do">Students &nbsp;</a></li>
            <li><a href="/courseadmin.do">Courses &nbsp;</a></li>
            <li><a href="/adminsterteacher.do">Teachers</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout.do">Logout &nbsp;</a></li>
        </ul>
    </nav>
    <h2>Select the required course and assign the grade</h2>
    <ol>
        <form action="/editStudentGrades.do" method="post" name="productForm">
            <select name="CourseList" id="SelectCourse" class="selectCourse"  onchange="GetSelectedText()">
                <c:forEach items="${CourseList}" var="course">
                    <option >${course.coursename}</option>
                </c:forEach>
            </select>
            Assign Grade:
            <select name="category">
                <c:forEach items="${GradeList}" var="category">
                    <option value="${category}">${category}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Add Grade" />

        </form>

        <h3>Selected Course details</h3>
        <p>Coursename:<p id="result"></p></p>
        <p id="result1"></p>

    </ol>
</div>
</body>


</html>
