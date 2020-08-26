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
    <h2>Select the required course and assign the grade</h2>
    <ol>

             <form action="/editStudentGrades.do" method="post">
                 <select name="CourseList">
                     <c:forEach items="${CourseList}" var="course">
                         <option value="${course.coursename}">${course.coursename}</option>
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
    </ol>
</div>
</body>

</html>
