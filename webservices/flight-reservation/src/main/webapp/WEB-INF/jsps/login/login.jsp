<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<h2>Login</h2>
		<pre>
Username <br><input type="text" name="email" /><br>
Password <br><input type="password" name="password" />
<br>
<input type="submit" value="Login" />
<br>
${loginMessage}
</pre>
	</form>
</body>
</html>