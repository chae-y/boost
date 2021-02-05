<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    StringBuffer url = request.getRequestURL();

    out.println("url : " + url.toString());
    out.println("<br>");
%>
</body>
</html>