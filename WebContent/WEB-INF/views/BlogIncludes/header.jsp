<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<!-- 블로그 해더 -->
		<div id="header">
			<h1><a href="${pageContext.request.contextPath}/${authUser.id}">${bvo.blogTitle}</a></h1>
			<ul>
			<c:choose>
				<c:when test="${empty authUser}">
					<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">내블로그관리</a></li> 
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
		<!-- /블로그 해더 -->