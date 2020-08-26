<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>School</title>
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
                    type:'POST',data:{Selected:selectedCountry,action:'demo1'},url:"studentship.do",success:function (result) {
                        $('#result1').text(result)
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
<nav class="navbar navbar-default">
        <a href="" class="navbar-brand">My School</a>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout.do">Logout &nbsp;</a></li>
        </ul>
    </nav>
    <h2>Your Courses</h2>
    <ol>
        <c:forEach items="${CourseList}" var="Course">
            <li>Course Name: ${Course.coursename}&nbsp&nbsp;  Credit Hours: ${Course.credithours} <a
                    href="/viewcourse.do?coursename=${Course.coursename}">Details</a></li>
        </c:forEach>
    </ol>
    <form action="/studentship.do" method="post">
        <h3>Enroll in a course :&nbsp;</h3>
        <select name="CourseList" id="SelectCourse" class="selectCourse"  onchange="GetSelectedText()">
            <c:forEach items="${NewCourseList}" var="category">
                <option value="${category.coursename}">${category.coursename}</option>
            </c:forEach>
        </select>
        
        <input type="submit" value="Add Course" />
    </form>

<p id="result1"></p>

    <p>
        <font color="red">${errorMessage}</font>
    </p>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>