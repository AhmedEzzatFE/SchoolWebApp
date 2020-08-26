<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>School</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

    <script type="text/javascript">
        function validateForm() {
            var Username = document.forms["myForm"]["Username"].value;
            var password = document.forms["myForm"]["password"].value;
            var Name = document.forms["myForm"]["Name"].value;


            if(Username === "" && password==="" && Name==="" ){
                document.getElementById("error").innerHTML = "Empty Fields, Please enter your Credentials ";
                return false;
            }
            else if (Username === "") {
                document.getElementById("error").innerHTML = "No Username found , Please Enter your Username";
                return false;
            }
            else if (Password===""){
                document.getElementById("error").innerHTML = "No Password found , Please Enter your Password    ";
                return false;
            }
            else if (Name===""){
                document.getElementById("error").innerHTML = "No Name found , Please Enter your Name";
                return false;
            }
        }
    </script>
</head>

<body>

<div class="container">
    <H1>Sign Up Form</H1>
    <form action="/signup.do" method="post"  name="myForm" onsubmit="return validateForm()" required>
        <p id="error">
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