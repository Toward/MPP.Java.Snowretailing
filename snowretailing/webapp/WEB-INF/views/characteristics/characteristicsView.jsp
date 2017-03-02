<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Characteristics</title>
</head>
<table class="tg">
    <tr>
        <th>Characteristic ID</th>
        <th>Characteristic Name</th>
        <th>Characteristic Measurment</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${characteristics}" var="characteristic">
        <tr>
            <td>><a href="<c:url value='/characteristics/${characteristic.id}' />" >${characteristic.id}</a></td>
            <td>${characteristic.name}</td>
            <td>${characteristic.measurment}</td>
            <td><a href="<c:url value='/characteristics/${characteristic.id}/edit' />"  >Edit</a></td>
            <td><a href="<c:url value='/characteristics/${characteristic.id}/delete' />" >Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/characteristics/create' />">Create</a>
</body>
</html>
