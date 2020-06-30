<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/static/index.css">
    <title>Microweb Sample</title>
</head>
<body>
    <p>This is Microweb generated Home Page!</p>
    <#if logged>
        <p>Welcome <strong>${user.name}</strong>!</p>
        <p>Logoff <a href="/v0/gui-user-logoff">here</a>.</p>
    <#else>
        <p>Login <a href="/v0/gui-user-login">here</a>.</p>
    </#if>
</body>
</html>