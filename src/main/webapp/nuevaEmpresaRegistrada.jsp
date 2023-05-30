<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//Scriptlet
	String empresa = (String)request.getAttribute("nombreEmpresa");
	System.out.println(empresa);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
Empresa <%=empresa  %> registrada!
</body>
</html>