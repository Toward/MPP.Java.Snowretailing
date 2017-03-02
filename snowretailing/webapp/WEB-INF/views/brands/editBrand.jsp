<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Edit Brand</title>
</head>
<body>

<h2>Edit brand</h2>
<form modelAttribute="brand" method="post" action="/brands/${brand.id}/edit">
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