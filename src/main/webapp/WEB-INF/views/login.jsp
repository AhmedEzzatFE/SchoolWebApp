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
    <form action="/login.do" method="post">
        <p>
            <font color="red">${errorMessage}</font>
        </p>
        Username: <input type="text" name="name" /> Password:<input
            type="password" name="password" /> <BR/><br/><input type="submit" value="Login" /> <a href="/signup.do" class="btn">Sign Up</a>
    </form>

</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>