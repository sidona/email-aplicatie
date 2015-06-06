<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<html>
<head>
    <title>Email</title>

    <script type="text/javascript" src="bootsrap/js/bootsrap.js"></script>
    <link rel="stylesheet" type="text/css" href="bootsrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
    <style>
        body{
            background-color: #0e3753;

        }
    </style>
</head>
<body>

<p align="center"><h3>Lista Emailuri</h3></p>

<form action="/sidona-mail/email" method="post" id="lista">
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label"><h3>Email</h3></label>
        <div class="col-sm-10">
            <input class="textbox" type="text" name="sender" id="inputEmail"value="${email.senderId}"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputReceiver" class="col-sm-2 control-label"><h1>Receiver</h1></label>
        <div class="col-sm-10">
            <input  class="textbox" type="text" name="receiver" id="inputReceiver" value="${email.receiverId}"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputSubject" class="col-sm-2 control-label"><h1>Subject</h1></label>
        <div class="col-sm-10">
            <input class="textbox" type="text" name="subject" id="inputSubject" value="${email.subject}"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputBody" class="col-sm-2 control-label"><h1>Body</h1></label>
        <div class="col-sm-10">
            <input class="textbox" type="text" name="body" id="inputBody" value="${email.body}"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input  type="button" id="login_button" value=" Trimite "/></br></br>
        </div>
    </div>
</form>


</body>
</html>



