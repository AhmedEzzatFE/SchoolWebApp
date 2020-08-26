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
</head>
<body class="container">

<div>

    <nav class="navbar navbar-default">

        <a href="/administerStudent.do" class="navbar-brand">My School</a>
        <ul class="nav navbar-nav">
            <li><a href="/administerStudent.do">Students &nbsp;</a></li>
            <li class="active"><a href="/courseadmin.do">Courses &nbsp;</a></li>
            <li><a href="/adminsterteacher.do">Teachers  &nbsp;</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout.do">Logout &nbsp;</a></li>
        </ul>
    </nav>
    <div class="container">

       <h2> All Students Enrolled for this course</h2><ol>
            <c:forEach items="${CourseList}" var="Course">
                <li>Student Name: ${Course.name}&nbsp; &nbsp;&nbsp;</li>
            </c:forEach>
        </ol>
    </div>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>