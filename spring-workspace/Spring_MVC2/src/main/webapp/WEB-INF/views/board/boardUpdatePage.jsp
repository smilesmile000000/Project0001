<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="/" >게시글</a></h1>
	<form action="/boardUpdate.do" method="post">
		글번호 : <input type="text" name="boardNo" value="${board.boardNo }" readonly><br>
		제목 : <input type="text" name="boardTitle" value="${board.boardTitle }"><br>
		작성자 : <input type="text" name="boardAuthor" value="${board.boardAuthor }" readonly><br>
		내용 : <input type="text" name="boardContent" value="${board.boardContent }"><br>
		작성일 : <input type="text" name="boardEnrollDate" value="${board.boardEnrollDate }" readonly><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>