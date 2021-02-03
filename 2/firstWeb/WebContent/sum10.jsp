<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
    int total = 0;
    for(int i = 1; i <= 10; i++){
        total = total + i;
    }//jsp는 html언어로 되어있지만 서블릿으로 바뀌어서 실행되는것
%>

1부터 10까지의 합 : <%=total %>

</body>
</html>