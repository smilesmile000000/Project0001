<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지2</h1>
	<hr>
	<c:choose>
		<c:when test="${sessionScope.member != null }">
			[${sessionScope.member.memberName }]님 환영합니다.<br>
			<a href="/logout.do">로그아웃</a>
			<br>
			<a href="/mypage.do">나의정보</a>
			<br>
			<a href="/deleteMember.do">회원탈퇴</a>
			<br>
			<a href="/allMemberList.do">회원 전체 보기</a>
			<br>
			<a href="/allBoardList.do">게시판</a>
			<br>
		</c:when>
		<c:otherwise>
			<fieldset>
				<legend>로그인</legend>
				<form action="/login.do" method="post">
					ID : <input type="text" name="memberId"><br>
					PW : <input type="password" name="memberPw"><br>
					<input type="submit" value="로그인"><br>
					<a href="/enrollPage.do">회원가입</a>
				</form>
			</fieldset>
		</c:otherwise>
	</c:choose>
	<hr>
	<form action="/uploadTest.do" method="post" enctype="multipart/form-data">
		<input type="file" name="fileTest"><br>
		<input type="text" name="test"><br>
		<input type="submit" value="파일 테스트"><br>
	</form>
	<form action="/insertBaod.do" method="post" enctype="multipart/form-data";>
	<input type="text" name="title"><br>
	<input type="text" name="content"><br>
	<input type="text" name="writer"><br>
	<input type="text" name="filename"><br>
	<input type="submit" value="글쓰기"><br>
	</form>
</body>
</html>