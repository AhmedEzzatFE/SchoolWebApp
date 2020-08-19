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

    <h1>Course Details</h1>
    <p>Course Name:${Coursedetails.coursename}</p><br/><p>Your Grade: ${Coursedetails.grade}</p><br/>
    <p>Current Teacher:${Coursedetails.teachername}</p><br/>
    <p>Teacher Contact info: ${Coursedetails.teachertelephone}</p>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>