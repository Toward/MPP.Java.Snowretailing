<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Edit Type</title>
</head>
<body>

<h2>Edit characteristic</h2>
<form method="post"  action="/characteristics/${characteristic.id}/edit">
    <table>
        <tr>
            <td><form:label path="characteristic.name">Characteristic Name</form:label></td>
            <form:input path="characteristic.name" />
            <td><form:errors path="characteristic.name"/></td>
        </tr>
        <tr>
            <td><form:label path="characteristic.measurment">Type Cost</form:label></td>
            <td><form:select path="characteristic.measurment" >
                <form:option value="">Select Measurment</form:option>
                <form:option value="m">m</form:option>
                <form:option value="shape">Shape</form:option>
                <form:option value="points">Points</form:option>
                <form:option value="mm">mm</form:option>
                <form:option value="sm">sm</form:option>
            </form:select>
            </td>

            <td><form:errors path="characteristic.measurment"/></td>
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