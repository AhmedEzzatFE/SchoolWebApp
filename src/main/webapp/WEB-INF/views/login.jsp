<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>School</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <style>
        .container{
            padding-top: 100px;
            padding-left: 100px;
            background-color: darkgray}

    </style>
</head>

<body class="container">
<div>
    <form action="/login.do" method="post">
        <p>
            <font color="red">${errorMessage}</font>
        </p>
        Username: <input type="text" name="Username" /> Password:<input
            type="password" name="password" /> <BR/><br/><input type="submit" value="Login" /> <a href="/signup.do" class="btn">Sign Up</a>
    </form>

</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>