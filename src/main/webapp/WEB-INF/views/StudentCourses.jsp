<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>School</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            background-color: #f5f5f5;
        }
    </style>
</head>

<body>
<div class="container">
    <H1>Welcome ${Username}</H1>

    Your Courses are
    <ol>
        <c:forEach items="${CourseList}" var="Course">
            <li>Course Name: ${Course.coursename}&nbsp&nbsp;  Credit Hours: ${Course.credithours} <a
                    href="/viewcourse.do?coursename=${Course.coursename}">Details</a></li>
        </c:forEach>
    </ol>

    <a href="/add-todo.do">Add new Course</a>
    <p>
        <font color="red">${errorMessage}</font>
    </p>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>