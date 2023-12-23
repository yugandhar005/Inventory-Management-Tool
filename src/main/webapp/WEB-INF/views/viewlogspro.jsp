<%@page import="com.r3sys.model.IssueProcessed" %>
<%@page import="com.r3sys.dao.IssueProcessedDao" %>
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
List<IssueProcessed>issueProcessed=(List<IssueProcessed>)request.getAttribute("issueProcessed");
for(IssueProcessed ip:issueProcessed)
{
%>

<tr>
<td><%=ip.getId()%></td>
<td><%=ip.getPid()%></td>
<td><%=ip.getProductName()%></td>
<td><%=ip.getQuantity()%></td>
<td><%=ip.getIssuerName()%></td>
<td><%=ip.getDate()%></td>

</tr>
<%} %>
</table>
</center>
</body>
</html>