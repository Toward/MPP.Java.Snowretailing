<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brands</title>
</head>
<table class="tg">
    <tr>
        <th>Type ID</th>
        <th>Type Name</th>
        <th>Type Cost</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${types}" var="type">
        <tr>
            <td>><a href="<c:url value='/types/${type.id}' />" >${type.id}</a></td>
            <td>${type.name}</td>
            <td>${type.cost}</td>
            <td><a href="<c:url value='/types/${type.id}/edit' />"  >Edit</a></td>
            <td><a href="<c:url value='/types/${type.id}/delete' />"  data-method="delete">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/types/create' />">Create</a>
</body>
</html>
