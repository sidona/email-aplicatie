<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="bootsrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
    <style>
        body{
            background-color: #242358;

        }
    </style>
</head>
<body>
<div class="box">

    <h3>Lista cu userii</h3>

    <table class="table table-striped">
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                    <a href="/sidona-mail/emails?userId=${user.id}">
                            ${user.userName}
                        <hr>
                    </a>
                </td>
                <td><i>Nume:</i> <b>${user.firstName} </b></td>

                <td><i>Prenume:</i> <b>${user.lastName} </b></td>


            </tr>
        </c:forEach>
    </table>
    <a href="/sidona-mail/email"><b style="color: #000000">New email</b></a>
</div>
<div style="clear:both;"></div>
</body>

</html>