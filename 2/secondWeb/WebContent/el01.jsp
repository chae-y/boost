<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("p1","page scope value");
	request.setAttribute("r1","request sope value");
	session.setAttribute("s1","session sope value");
	application.setAttribute("a1","application sope value");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
pageContext.getAttribute("p1") : <%=pageContext.getAttribute("p1") %> <br>
pageContext.getAttribute("p1") : ${pageScope.p1} <br>
requestContext.getAttribute("r1") : ${requestScope.r1} <br>
sessionContext.getAttribute("s1") : ${sessionScope.s1} <br>
applicationContext.getAttribute("a1") : ${applicationScope.a1} <br>

pageContext.getAttribute("p1") : ${p1} <br>
requestContext.getAttribute("r1") : ${r1} <br>
sessionContext.getAttribute("s1") : ${s1} <br>
applicationContext.getAttribute("a1") : ${a1} <br>
</body>
</html>