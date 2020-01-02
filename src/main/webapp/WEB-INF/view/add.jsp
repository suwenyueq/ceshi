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
	<h1 align="center">商品增加</h1>
	<hr>

	<div class="container">
		<form id="form1">
			商品名称：<input type="text" name="name"><br> 商品名称：<input
				type="text" name="ename"><br> 品牌：<select name="bid"
				id="bid">


			</select><br> 种类：<select name="tid" id="tid">


			</select><br> 价格：<input type="text" name="price"><br> 数量：<input
				type="text" name="num"><br> 商品图片：<input type="file"
				name="file"><br>
			<button type="button" onclick="add()">增加</button>
		</form>
	</div>

	<script type="text/javascript">
	$(function(){
		 $.get("/selectTypes",function(list){
			 for(var i in list){
				$("#tid").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>") 
			 }
		 }); 
		 
		 $.get("/selectBrands",function(list){
			 for(var i in list){
				$("#bid").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>") 
			 }
		 }); 
		 
	 })
	 
	 function add(){
		var formData = new FormData($("#form1")[0]);
		
		$.ajax({
			type:"post",
			url:"/add",
			data:formData,
			processData:false,
			contentType:false,
			success:function(flag){
			  if(flag){
				  alert("保存成功");
				  location.href="/goods";
			  }	else{
				  alert("保存失败")
			  }
			}
			
			
		}) 
	}
	</script>
</body>
</html>