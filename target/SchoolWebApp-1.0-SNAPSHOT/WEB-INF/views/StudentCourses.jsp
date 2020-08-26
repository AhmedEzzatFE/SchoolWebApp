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
</head>

<<body class="container">
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
        <select name="category">
            <c:forEach items="${NewCourseList}" var="category">
                <option value="${category.coursename}">${category.coursename}</option>
            </c:forEach>
        </select>
        
        <input type="submit" value="Add Course" />
    </form>
    <p>
        <font color="red">${errorMessage}</font>
    </p>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>