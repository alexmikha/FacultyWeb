<%@ include file="include.jsp" %>
<html>
<head>
    <title>Teacher Info</title>
</head>
<body>

<%--<% Student transfered = (Student) request.getAttribute("student");%>--%>
<c:set var="transfered" value="${teacher}"/>


<div class="container">
    <ul>
        <li>
            <div class="column">
                id : ${transfered.id}
            </div>
        </li>
        <li>
            <div class="column">
                name : ${transfered.teacherName} <%-- must be a pojo class (get methods)--%>
            </div>
        </li>
        <li>
            <div class="column">
                experience : ${transfered.experience}
            </div>
        </li>
        <li>
            <div class="column">
                subject : ${transfered.subjectName}
            </div>
        </li>
    </ul>
</div>
</body>
</html>
