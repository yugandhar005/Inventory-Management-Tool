<%@page import="com.r3sys.model.ProcessedMaterial" %>
<%@page import="com.r3sys.dao.ProcessedMaterialDao" %>
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
List<ProcessedMaterial>processedMaterial=(List<ProcessedMaterial>)request.getAttribute("processedMaterial");
for(ProcessedMaterial pm:processedMaterial)
{
%>

<tr>
<td><%=pm.getId()%></td>
<td><%=pm.getName()%></td>
<td><%=pm.getQuantity()%></td>
<td><%=pm.getUnit()%></td>
<td><%=pm.getCostperunit()%></td>
<td><a href="deleteProcessed/<%=pm.getId() %>">Delete</a></td>
<td> <a href="updatepro?id=<%= pm.getId() %>">Update</a> </td>
<td><a href="issuepro?id=<%=pm.getId() %>&name=<%=pm.getName()%>">Issue</a></td>
</tr>
<%} %>
</table>
</center>
</body>
</html>