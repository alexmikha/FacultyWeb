<%@ include file="include.jsp" %>
<html>
<head>
    <title>Subject Info</title>
</head>
<body>


<c:set var="transfered" value="${subject}"/>


<div class="container">
    <ul>
        <li>
            <div class="column">
                id : ${transfered.id}
            </div>
        </li>
        <li>
            <div class="column">
                name : ${transfered.subjectName} <%-- must be a pojo class (get methods)--%>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
