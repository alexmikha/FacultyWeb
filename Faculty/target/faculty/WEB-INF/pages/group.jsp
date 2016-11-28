
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group-Info</title>
</head>
<body>


<c:set var="transfered" value="${group}"/>


<div class="container">
    <ul>
        <li>
            <div class="column">
                id : ${transfered.id}
            </div>
        </li>
        <li>
            <div class="column">
                name : ${transfered.groupName} <%-- must be a pojo class (get methods)--%>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
