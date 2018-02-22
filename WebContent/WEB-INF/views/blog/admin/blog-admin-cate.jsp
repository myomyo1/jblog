<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/jblog.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">



</head>
<body>

	<div id="container">
		
		<!-- 블로그 헤더 -->
		<c:import url="/WEB-INF/views/BlogIncludes/header.jsp"></c:import>

		
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write">글작성</a></li>
				</ul>
				<!-- 카테고리 리스트 테이블 -->
		      	<table class="admin-cat">
		      		<tr id="categoryAdd">
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
				</table>
								
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" id= "cat-add-submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
			</div>
		</div>

		<!-- 블로그 푸터 -->
		<c:import url="/WEB-INF/views/BlogIncludes/footer.jsp"></c:import>
		
	</div>
</body>



<script type="text/javascript">

$(document).ready(function() {
	fetchList();
});

/////////////////////////////////////////////////////////////////////////

var userVo = {
		userNo : ${sessionScope.authUser.userNo},
		id : '${sessionScope.authUser.id}',
		userName : '${sessionScope.authUser.userName}'
};

console.log(userVo);

function fetchList(){
	$.ajax({
		url : "${pageContext.request.contextPath }/admin/categorylist",
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(userVo),
		
		dataType : "json",
		success : function(clist){ //clist 변수명
			console.log(clist);
			
			for(var i =0; i<clist.length; i++){
				render(clist[i], "down"); //clist 변수명에 인덱스 [i] => 낱개 하나 cvo
			}
		},
		error : function(XHR, status, error) { 	
			console.error(status + " : " + error);
		}
	});
}

function render(cvo, updown){
	var str="";
	str += "		<tr id='c"+cvo.cateNo +"'>";
	str += "			<td>" + cvo.cateNo + "</td>";
	str += "			<td>" + cvo.cateName + "</td>";
	str += "			<td>" + cvo.cnt + "</td>";
	str += "			<td>" + cvo.description + "</td>";
	str += "			<td><img data-no='"+ cvo.cateNo +"' src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td>";		
	str += "		</tr>";

	if(updown == "up"){
		$("#categoryAdd").after(str); //클래스 밑에 th에 id값 주고 그 밑에 바로 붙이라는 의미의 after. th가 아닌 table값을 지정해주면 table(th, th)이므로 테이블 맨 밑으로 가서 붙는다
	}else if(updown =="down"){
		$(".admin-cat").append(str); //클래스값에 append이면 클래스 맨뒤에다 붙이라는 것. 
	}else {
		console.log("updown오류");
	}
		
}

////////////////////////////////////////////////////////////////////////////

$("#cat-add-submit").on("click", function(){
	var userNo = ${sessionScope.authUser.userNo};
	var name = $("[name=name]").val();
	var desc = $("[name=desc]").val();
	 
	console.log(name);
	console.log(desc);
	console.log(userNo);
	 
	var cvo = { //자바스크립트용 객체만든 것 위에있는 변수 담은 것.
			userNo : userNo,
			cateName : name,
			description : desc
	};
	
	$.ajax({
		url : "${pageContext.request.contextPath }/admin/categoryAdd",		
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(cvo),
					
		
		dataType : "json",
		success : function(cvo){ 
			render(cvo,"up");
		},
		error : function(XHR, status, error) { 	
			console.error(status + " : " + error);
		}
	});
	$("[name=name]").val("");
	$("[name=desc]").val("");
});
///////////////////////////////////////////////////////////////////////////////////////////////////

$(".admin-cat").on("click", "img" , function(){
	var td = $(this);
	var cateNo = td.data("no");
	console.log(cateNo);
	var userNo = ${sessionScope.authUser.userNo};

	$.ajax({
		url : "${pageContext.request.contextPath }/admin/categoryDelete",		
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(cateNo),
					
		
		dataType : "json",
		success : function(resultNum){ 
			if(resultNum!=0){
				$("#c"+cateNo).remove();
			}
		},
		error : function(XHR, status, error) { 	
			console.error(status + " : " + error);
		}
	});
});

</script>


</html>


