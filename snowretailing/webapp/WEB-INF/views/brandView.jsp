<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brands</title>
</head>
<body>
<ul>
    <c:forEach items="${brands}" var="brand">
        <li>
            <div>
                <p>${brand.id}</p>
                <p>${brand.brandName}</p>
            </div>
        </li>
    </c:forEach>
</ul>
</body>
</html>
