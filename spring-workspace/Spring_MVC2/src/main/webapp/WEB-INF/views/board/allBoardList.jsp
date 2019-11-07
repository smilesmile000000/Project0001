<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<h1>게시판</h1>
	<hr>
	<c:if test="${sessionScope.member.memberId != null}">
		[${sessionScope.member.memberName }]님 환영합니다.<br>
	</c:if>
	<table style="text-align: center;">
		<tr><th>글번호</th><th>제목</th><th>작성자</th><th>내용</th><th>작성일</th></tr>
		<c:forEach items="${list }" var="b" varStatus="i">
			<tr>
				<td>${b.boardNo }</td>
				<td>${b.boardTitle }</td>
				<td>${b.boardAuthor }</td>
				<td>${b.boardContent }</td>
				<td>${b.boardEnrollDate }</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${sessionScope.member.memberId != null}">
		<a href="/boardEnrollPage.do">글쓰기</a><br>
	</c:if>
</body>
</html>