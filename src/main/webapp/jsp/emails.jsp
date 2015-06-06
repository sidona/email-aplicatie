<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emails Page</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />

</head>
<body>
<div class="box">

    <div style="margin:10px 15px 10px 15px">
<table>
    <c:forEach var="email" items="${emails}">
        <tr>
            <td>Email Subjects
                <a href="/sidona-mail/email?email=${email.id}">
                        ${email.subject}
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
        <br>
            <br>
                <br>
<a href="/sidona-mail/email?userId=${email.receiverId}"><b>New email</b></a>
    </div>
    <div style="clear:both;"></div>
</body>
</html>