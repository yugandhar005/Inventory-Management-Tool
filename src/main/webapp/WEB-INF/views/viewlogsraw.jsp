<%@page import="com.r3sys.model.IssueRaw" %>
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
<th>PID</th>
<th>ProductName</th>
<th>Quantity</th>
<th>IssuerName</th>
<th>Date</th>

</tr>
<%
List<IssueRaw>issueRaw=(List<IssueRaw>)request.getAttribute("issueRaw");
for(IssueRaw ir:issueRaw)
{
%>

<tr>
<td><%=ir.getId()%></td>
<td><%=ir.getPid()%></td>
<td><%=ir.getProductName()%></td>
<td><%=ir.getQuantity()%></td>
<td><%=ir.getIssuerName()%></td>
<td><%=ir.getDate()%></td>

</tr>
<%} %>
</table>
</center>
</body>
</html>