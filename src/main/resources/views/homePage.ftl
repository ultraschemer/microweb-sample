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
        <hr/>
        <p>Add image here:</p>
        <form action="/v0/image" method="post" enctype="multipart/form-data">
            <table style="width: 100%">
                <tr>
                    <td style="width: 30%">Name:</input></td>
                    <td>File:</td>
                </tr>
                <tr>
                    <td style="width: 30%"><input name="fileName" style="width: 100%" type="text"></input></td>
                    <td style="padding-left: 10px"><input name="fileData" style="width: 100%" type="file"></input></td>
                </tr>
            </table>
            <input type="submit" value="Send"></input>
        </form>
        <hr/>
        <#if (images?size > 0) >
        <p><strong>Your images here:</strong></p>
        <table style="width: 100%">
        <tr>
            <td>Name:</td>
            <td>Owner:</td>
            <td>Alias:</td>
            <td>Details:</td>
        </tr>
        <#list images as image>
            <tr>
                <td>${image.name}</td>
                <td>${image.ownerName}</td>
                <td><#if image.alias??>${image.alias}</#if></td>
                <td><a href="/v0/image/${image.id}"><strong>+</strong></a></td>
            </tr>
        </#list>
        </table>
        </#if>
    <#else>
        <p>Login <a href="/v0/gui-user-login">here</a>.</p>
    </#if>
</body>
</html>