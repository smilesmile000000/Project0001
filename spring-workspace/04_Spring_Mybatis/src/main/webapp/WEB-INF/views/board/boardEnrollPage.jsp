<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="/" >게시판 글쓰기</a></h1>
	<hr>
	<form action="/boardEnroll.do" method="post">
		제목 : <input type="text" name="boardTitle"><br>
		작성자 : <input type="text" name="boardAuthor" value="${sessionScope.member.memberName }" readonly><br>
		내용 : <input type="text" name="boardContent"><br>
		<input type="submit" value="작성"><br>
	</form>
</body>
</html>