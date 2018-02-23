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

	<div id="container">

		<!-- 블로그 헤더 -->
		<c:import url="/WEB-INF/views/BlogIncludes/header.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4></h4>
					<p>
						
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${plist}" var="p" varStatus="status">
						<ul>
							<!-- 뽑아오고 css수정한 것  -->
							<li><a href="aaaaaaaaaaa?no=${postNo }" style="width:100%">${p.postTitle}</a> <span style="float:right">${p.regDate}</span></li>
						</ul>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<!-- src에 이 블로그 주인의 사진을 요청 /logo/{userNo}?logoFile=로고파일이름~~ -->
				<%-- <img src="${pageContext.request.contextPath}/logo/${ bvo.userNo }?logoFile=${bvo.logoFile}"> --%>
				<img src="${pageContext.request.contextPath}/upload/${bvo.logoFile}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
				<c:forEach items="${clist}" var="c" varStatus="status">
					<ul>
						<li><a href="">${c.cateName}</a></li>
					</ul>
				</c:forEach> 
		</div>
		
		<!-- 블로그 푸터 -->
		<c:import url="/WEB-INF/views/BlogIncludes/footer.jsp"></c:import>
		
	</div>
</body>
</html>