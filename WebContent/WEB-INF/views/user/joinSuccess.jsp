<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
				
		<!-- 메인 헤더 -->
		<c:import url="/WEB-INF/views/MainIncludes/header.jsp"></c:import>
		
		<p class="welcome-message">
			<span> 감사합니다.
				       회원 가입 및 블로그가 성공적으로 만들어 졌습니다.
		    </span>
			<br><br>
			<a href="${pageContext.request.contextPath}/user/loginForm">로그인 하기</a>
		</p>
		
	</div>
</body>
</html>
