<%@ include file="WEB-INF/pages/include.jsp"%>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Main</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
          crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
          crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>

</head>
<body>

<div class="centerDiv" align="center" >
    <div class="header">
    <c:if test="${!inSystem}">
    <form  action="login" method="post">
        <input type="name" placeholder="Login" required>
        <input type="password" placeholder="Password" required>

        <input type="submit" value="Submit">
    </form>
    </c:if>
    <c:if test="${inSystem}">
    <ul>
        <li>Hello ${currentUserName}</li>
    </ul>
    </c:if>
</div>
</div>

<!--script>
    $("#loginButton").click(function () {
        $('#loginForm').submit();
    })
</script>-->
</body>
</html>