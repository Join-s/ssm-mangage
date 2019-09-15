<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
			<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<!--bootstrap框架文件-->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/css/bootstrap.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	</head>
	</head>
	<body>
					<table cellpadding="0" cellspacing="0" border="1" class="table">
<tr>
	<td>借入人</td>
	<td>元件名</td>
	<td>借出日</td>
	<td>归还日</td>
	<td>状态</td>
	<td>审核</td>
</tr>			
<c:forEach items="${rblist }" var="li"> 
	<tr  class="${li.state==1?"alert-success":"alert-warning" }">
	<td>${li.uname}</td>
	<td>${li.cname}</td>
	<td><fmt:formatDate value="${li.createtime}" pattern="yyyy-MM-dd"/>   </td>
	<td><fmt:formatDate value="${li.backtime}" pattern="yyyy-MM-dd"/> </td>
	<td>${li.state==0?"未审核":"审核通过" }</td>
	<td><a href="${pageContext.request.contextPath }/hms/or/updateById?id=${li.id }&state=1">通过</a>
		<a href="${pageContext.request.contextPath }/hms/or/updateById?id=${li.id }&state=0">驳回</a>
		<a href="${pageContext.request.contextPath }/hms/or/deleteById?id=${li.id }">删除</a>
	</td>
</tr>
</c:forEach>




		</table>
	</body>
</html>
