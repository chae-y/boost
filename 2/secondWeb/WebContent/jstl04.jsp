<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
	List<String> list = new ArrayList<>();
	list.add("hello");
	list.add("word");
	list.add("!!!!");
	
	request.setAttribute("list",list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list }" var="item">
${item } <br>
</c:forEach>

<c:forEach items="${list }" var="item" begin="1">
${item } <br>
</c:forEach>
</body>
</html>