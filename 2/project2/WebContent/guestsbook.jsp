<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>방명록</title>
<style>
.guestbook {
	padding: 5px 0px 5px 5px;
	margin-bottom: 5ps;
	border-bottom: 1px solid #efefef;
	font-size: 12px;
}
</style>
<meta charset="UTF-8">
</head>
<body>
	<div class="guestbooks">
		<c:forEach var="guestbook" items="${list}">
			<div class="gestbook">
				<div>
					<lavel>id: </lavel>
					${guestbook.id }
				</div>
				<div>
					<label>name: </label> ${guestbook.name }
				</div>
				<div>
					<p>${guestbook.content }</p>
				</div>
				<div>
					<label>regdate: </label> ${guestbook.regdate }
				</div>
			</div>
		</c:forEach>
	</div>

	<br>
	<br>
	<br>

	<form method="post" action="guestbooks/write">
		이름 : <input type="text" name="name"><br> 내용:
		<textarea name="content" col="50" row="5"></textarea>
		<input type="submit" value="확인">
	</form>
</body>
</html>