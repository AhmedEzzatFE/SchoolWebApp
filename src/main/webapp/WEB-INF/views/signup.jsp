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
    <H1>Sign Up Form</H1>
    <form action="/signup.do" method="post">
        <p>
            <font color="red">${errorMessage}</font>
        </p>
        Username: <input type="text" name="Username" /> <BR/><BR/>
        Your Name: <input type="text" name="Name" /><BR/><BR/>
        Password:<input type="password" name="password" /> <BR/><BR/>
        Your Age: <input type="text" name="Age" /><BR/><BR/>
        Your Telephone Number: <input type="text" name="Telephone" /><BR/><BR/>

        <input type="submit" value="Register" />

    </form>

</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>