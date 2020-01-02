<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- 引入 css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resource/bootstrap.css">
<!-- 引入js -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/jquery-3.2.1.js"></script>
</head>
<body>
	<h1 align="center">商品列表</h1>

	<br>
	<br>

	<div class="container" style="margin-left: 545px">
		<br> <a href="/add">增加</a> <br>

		<c:forEach items="${info.list}" var="g">
			<div style="float: left; margin-right: 100px">
				<img alt="" src="/pic/${g.pic}" width="198px" height="258"> <br>
				价格： ${g.price}<br> 品牌：${g.brand.name} <br>
				类型：${g.type.name}<br>
			</div>
		</c:forEach>
		<div style="clear: both; margin-left: 280px">
			<jsp:include page="/WEB-INF/view/pages.jsp"></jsp:include>
		</div>
	</div>

	<script type="text/javascript">
 function goPage(page){
	   location.href="${pageContext.request.contextPath}/goods?page="+page
 }
 </script>
</body>
</html>