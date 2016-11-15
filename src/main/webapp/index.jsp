<html>
<head>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.tools.js"></script>
    <script type="text/javascript" src="js/emailHandler.js"></script>

</head>
<body>
<h1>Email Form</h1>

<form  method="get" enctype="text/plain" action="">
<table>
    <tr><td>Recipient:</td><td><input type="text" id="recipient" name="recipient" required /></td></tr>
    <tr><td>Subject:</td><td><input type="text" id="subject" name="subject" required/></td></tr>
    <tr><td>Your Email:</td><td><input type="text" id="email"  name="email" required /></td></tr>
    <tr><td ></td><td><textarea cols="30" rows="20" id="emailBody" name="emailBody" placeholder="Enter email body here" required></textarea></td></tr>
</table>

    <script type="text/javascript">
        var contextPath='<%=request.getContextPath()%>';
        console.log(contextPath);
    </script>

    <p><input type="submit" name="submit" value="Send" />
        <input type="reset" name="reset" value="Clear Form" /></p>

</form>

<p id="results"></p>

</body>
</html>