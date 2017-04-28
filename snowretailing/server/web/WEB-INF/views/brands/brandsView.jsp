<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brands</title>
</head>
<table class="tg">
    <tr>
        <th>Brand ID</th>
        <th>Brand Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${brands}" var="brand">
        <tr>
            <td>><a href="<c:url value='/brands/${brand.id}' />" >${brand.id}</a></td>
            <td>${brand.brandName}</td>
            <td><a href="<c:url value='/brands/${brand.id}/edit' />"  >Edit</a></td>
            <td><a href="<c:url value='/brands/${brand.id}/delete' />" >Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/brands/create' />">Create</a>
</body>
</html>
