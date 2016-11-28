<%@ include file="include.jsp" %>
<html>
 <head>
  <meta charset="UTF-8" />
  <title>Main</title>
 </head>
 <body>
 <div class="centerDiv" align="center" >
 <form name="" action="" method="">
<input type="text" placeholder="Login" required>
<input type="password" placeholder="Password" required>

<input type="submit" value="Submit">
</form>

    <c:if test="${inSystem}">
        <ul>
            <li>Hello ${currentUserName}</li>
        </ul>
    </c:if>
 </body>
</html>