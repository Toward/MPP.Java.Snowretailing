<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Create Type</title>
</head>
<body>

<h2>Create Type</h2>
<form method="post" action="/types/create">
    <table>
        <tr>
            <td><form:label path="type.name">Type Name</form:label></td>
            <form:select path="type.name" >
                <form:option value="">Select Type</form:option>
                <form:option value="board">Board</form:option>
                <form:option value="ski">Ski</form:option>
                <form:option value="poles">Poles</form:option>
                <form:option value="helmet">Helmet</form:option>
                <form:option value="shoes">Shoes</form:option>
            </form:select>
            <td><form:errors path="type.name"/></td>
        </tr>
        <tr>
            <td><form:label path="type.cost">Type Cost</form:label></td>
            <td><form:input path="type.cost" /></td>

            <td><form:errors path="type.cost"/></td>
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