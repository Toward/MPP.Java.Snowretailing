<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Create Brand</title>
</head>
<body>

<h2>Create Brand</h2>
<form method="post" action="/brands/create">
    <table>
        <tr>
            <td><form:label path="brand.brandName">Brand Name</form:label></td>
            <td><form:input path="brand.brandName" /></td>
            <td><form:errors path="brand.brandName"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>