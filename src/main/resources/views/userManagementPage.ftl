<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/static/index.css">
    <title>Microweb Sample</title>
</head>
<body>
    <p>User Management</p>
    <p>Welcome <strong>${user.name}</strong>!</p>
    <p>Return to <a href="/v0">home</a></p>
    <hr/>
    <form method="post" action="/v0/gui-user">
        <table>
            <tr>
                <td>Name:</td>
                <td>Password:</td>
                <td>Password confirmation:</td>
            </tr>
            <tr>
                <td><input type="text" name="name"/></td>
                <td style="padding-left: 10px"><input type="password" name="password"/></td>
                <td style="padding-left: 10px"><input type="password" name="passConfirmation"/></td>
            </tr>
        </table>
        <input type="submit" value="Create"/>
    </form>
    <hr/>
    <table style="width: 100%">
        <tr>
            <td>Name:</td>
            <td>Roles:</td>
        </tr>
        <#list users as u>
            <td>${u.name}</td>
            <td>
                <#list u.roles as r>
                    <strong>[</strong>${r.name}<strong>]</strong>&nbsp;
                </#list>
            </td>
        </#list>
    </table>
</body>
</html>