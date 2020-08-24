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
   <h2> Students in the school</h2>
    <ol>
        <c:forEach items="${StudentList}" var="Student">
            <li>Student Name: ${Student.name} &nbsp;  <a href="/editStudentGrades.do?Username=${Student.username}">Add Grade</a></li>
        </c:forEach>
    </ol>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </div>
</body>

</html>
