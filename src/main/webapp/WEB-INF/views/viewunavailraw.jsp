<%@page import="com.r3sys.model.RawMaterial"%>
<%@page import="java.util.List"%>

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
    <th>NAME</th>
    <th>QUANTITY</th>
    <th>UNIT</th>
    <th>COST PER UNIT</th>
    
    
  </tr>
  <% 
  List<RawMaterial> rawMaterial=(List<RawMaterial>)request.getAttribute("rawMaterial");
  for(RawMaterial pr:rawMaterial)
  {
	  if(pr.getQuantity()==0)
	  {
  %>
  <tr>
    <td><%=pr.getId() %></td>
    <td><%=pr.getName() %></td>
    <td><%=pr.getQuantity() %></td>
    <td><%=pr.getUnit()%></td>
    <td><%=pr.getCostperunit() %></td>
    <td>
   
    </td>
    
    
  </tr>
  <%}} %>
 
</table>
</center>
</body>
</html>