<%--
  Created by IntelliJ IDEA.
  User: serhii
  Date: 10.04.16
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="WEB-INF/pages/include.jsp"%>
<html>
<head>
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

  <div class="header">

    <ul>
      <li><a href="register">Register</a></li>
    </ul>

    <c:if test="${!inSystem}">
    <form action="login" method="post">
      <ul>
        <li>Input name:
          <input name="name" type="text">
        </li>
        <li>Input name:
          <input name="pass" type="password">
        </li>
        <li>Submit:
          <input type="submit">
        </li>
      </ul>
    </form>
    </c:if>
    <c:if test="${inSystem}">
      <ul>
        <li>Hello ${currentUserName}</li>
      </ul>
    </c:if>

  </div>

</body>
</html>
