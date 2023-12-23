<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<h1>Inventory Management System</h1>
<br><br><br>
<h2>Manager Login</h2>
<form action="LoginAdmin" method="post">
 <label>Email ID</label>
    <input type="text" placeholder="Enter Email" name="email">
    <br><br><br>
    <label>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <br><br><br>
    
    <button type="submit">Login</button>
</form>
</center>
</body>
</html>