<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Client List</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<h3>Client List</h3>
<a href="addClient">Add Client</a>
<br><br>
<div>

    <table border="1">
        <tr>
            <th>Name</th>
            <th>Legal Address</th>
        </tr>
        <#list clients as client>
            <tr>
                <td>${client.name}</td>
                <td>${client.legaladdress}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>