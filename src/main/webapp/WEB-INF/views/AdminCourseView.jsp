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
<div >

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
        <h2>All Courses Available</h2>
    <ol>
        <c:forEach items="${CourseList}" var="Course">
            <li>Course Name: ${Course.coursename}&nbsp&nbsp; &nbsp;&nbsp; Credit Hours: ${Course.credithours}&nbsp; <a
                    href="/courselist.do?coursename=${Course.coursename}">Show Student List</a></li>
        </c:forEach>
    </ol>

    <h3> Add a New Course</h3>
    <form action="/courseadmin.do" method="post">
        Course name: <input type="text" name="coursename" />
        Credit Hours: <input type="text" name="credithours" />
        Assign a teacher:
        <select name="Teacher">
            <c:forEach items="${TeacherList}" var="Teacher">
                <option value="${Teacher.teachername}">${Teacher.teachername}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Add New Course" />

    </form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>