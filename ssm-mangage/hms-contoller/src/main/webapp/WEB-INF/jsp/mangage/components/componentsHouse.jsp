<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form  action="${pageContext.request.contextPath }/hms/comp/upfile" method="post" enctype="multipart/form-data">
						<h3>选择xlsx文件以导入元件信息到数据库:</h3><br/>
							<input type="file" value="" name="file" />
							<input type="submit" value="提交" />
		</form>
	</body>
</html>
