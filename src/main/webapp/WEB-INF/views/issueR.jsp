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
<h2>Issue RawMaterial</h2>
<form action="issueR" method="post">
<label><b>ID:</b></label>
<input type="number" name="id">
<br><br>
<label><b>ProductName:</b></label>
<input type="text" name="productName" value="<%=request.getParameter("name") %>">
<br><br>
<label><b>Quantity:</b></label>
<input type="text" name="quantity">
<br><br>
<label><b>IssuerName:</b></label>
<br><br>
<input type="text" name="issuerName">
<br><br>
<label><b>Date:</b></label>
<input type="text" name="date">
<br><br>
<label><b>Pid:</b></label>
<input type="text" name="pid" value="<%=request.getParameter("id")%>">
<br><br>
<button type="submit">Submit</button>
</form>
</center>
</body>
</html>