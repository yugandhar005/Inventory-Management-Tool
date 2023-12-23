<%@page import="com.r3sys.model.RawMaterial" %>
<%@page import="com.r3sys.dao.RawMaterialDao" %>
<%@page import="java.util.List" %>
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
<table>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Quantity</th>
<th>Unit</th>
<th>CostPerUnit</th>
<th>Action</th>
</tr>
<%
List<RawMaterial>rawMaterial=(List<RawMaterial>)request.getAttribute("rawMaterial");
for(RawMaterial rm:rawMaterial)
{
%>

<tr>
<td><%=rm.getId()%></td>
<td><%=rm.getName()%></td>
<td><%=rm.getQuantity()%></td>
<td><%=rm.getUnit()%></td>
<td><%=rm.getCostperunit()%></td>
<td><a href="deleteRaw/<%=rm.getId() %>">Delete</a></td>
<td> <a href="update?id=<%= rm.getId() %>">Update</a> </td>
<td><a href="issueR?id=<%=rm.getId() %>&name=<%=rm.getName()%>">Issue</a></td>
</tr>
<%} %>
</table>
</center>
</body>
</html>