<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<!-- 메인해더 -->
		<a href="${pageContext.request.contextPath}/">
			<img class="logo" src="/jblog/assets/images/logo.jpg">
		</a>
		<ul class="menu">
			
			<c:choose>
				<c:when test="${empty authUser}">
					<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/user/joinForm">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath}/${authUser.id}">내블로그</a></li> 
				</c:otherwise>
			</c:choose>
				
 		</ul>
 		<!-- /메인해더 -->