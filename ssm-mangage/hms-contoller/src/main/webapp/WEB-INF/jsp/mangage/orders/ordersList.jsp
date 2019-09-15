<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<!--bootstrap框架文件-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/hms/resource/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/hms/resource/js/mangage/ordersList.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3>学生订单</h3>
			</div>
		</div>
		<div class="row clearfix">

			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="alert alert-success alert-dismissable">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
						人生的价值，并不是用时间，而是用深度量去衡量的。 
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-2 column">
							<div class="btn-group">
								
								<button class="btn btn-default" type="button">
									<em class="glyphicon glyphicon glyphicon-download"></em><a href="${pageContext.request.contextPath }/hms/uploadOrder">导出所有</a>
								</button>
							</div>
						</div>
						<div class="col-md-6 column">
							<form role="form" action="${pageContext.request.contextPath }/hms/or/queryList" method="post" id="ss-form">
								<div class="input-group">
									<input type="text" class="form-control" id="exampleInputEmail1" name="oid"
										placeholder="订单编号" /><span type="submit"
										class="btn btn-default input-group-addon glyphicon glyphicon-search"><span id="ss-btn">搜索</span></span>
								</div>
							</form>
						</div>
						<div class="col-md-3 column">
							<div class="btn-group">
								<button class="btn btn-default" type="button">
									<a class="glyphicon glyphicon glyphicon-resize-vertical" href="${pageContext.request.contextPath }/or/queryList?status=${status==0?1:0}">时间</a>
								</button>
								
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-12 column">

				<form action="${pageContext.request.contextPath }/hms/deleteStuOrders" method="post"id="from1" >

					<table class="table table-condensed table-striped">
						<thead>
							<tr></tr>
							<tr>
								<th>状态</th>
								<th>订单号</th>
								<th>学生</th>
								<th>时间</th>
								<th>备注</th>
								<th>审核状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody> 
					<!-- 	// status 1：未审核 2：已审核 3：打回 -->
								<c:forEach items="${OrdersPageInfo.list}" var="li">
									<tr>
										<td><input type="checkbox" name="ids" value="${li.id }" /></td>
										<td>${li.id }</td>
										<td>${li.tUser.name }</td>
										<td> <fmt:formatDate value="${li.createtime }" pattern="yyyy-MM-dd hh:mm:ss"/> </td>
										<td>${li.remark }</td>
										<td>${li.status==2?'已审核':li.status==3?'打回':li.status==1?'未提交':'未审核' }</td>
										<td><a href="javascript:void(-1);" class="xq-btn alert-info"
											data-toggle="modal" data-target="#myModal" oid="${li.id }">详情</a>
											<a href="#" data-toggle="modal" data-target="#myModal"
											class="alert-danger dh-btn" oid="${li.id }">打回</a>
											<a href="${pageContext.request.contextPath }/hms/or/update?id=${li.id }&status=2" id="tongguo-btn" class="alert-success" oid="${li.id }"> 通过</a>
											</td>
									</tr>

								</c:forEach>

						</tbody>
					</table>
				</form>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="col-lg-2">
					<ul class="pagination pagination-sm">
						<li><a class="btn btn-primary" onclick="checkId()">全选</a></li>
						<li><a class="btn btn-warning" onclick="return delteCheck()">删除</a>
						</li>
					</ul>
				</div>

				<div class="col-lg-8">
					<ul class="pagination pagination-sm fenye-ul">
						<li><a href="${pageContext.request.contextPath }/hms/or/queryList?pageNum=${OrdersPageInfo.prePage}">Prev</a></li>
						
						<c:forEach end="${OrdersPageInfo.pages }" begin="1" step="1" var="str">
						
						<c:if test="${ str==OrdersPageInfo.pageNum}">
						<li class="active"><a href="${pageContext.request.contextPath }/hms/or/queryList?pageNum=${OrdersPageInfo.pageNum}">${str }</a></li>
						</c:if>
						<c:if test="${ str!=OrdersPageInfo.pageNum}">
						<li ><a href="${pageContext.request.contextPath }/hms/or/queryList?pageNum=${str}">${str }</a></li>
						</c:if>
						
						
						</c:forEach>
						 
						<li><a href="${pageContext.request.contextPath }/hms/or/queryList?pageNum=${OrdersPageInfo.nextPage}">Next</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="row">
			<!-- 公告模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">公告详情</h4>

						</div>
						<div class="modal-body">
							<!--修改显示公告信息表单-->

							<form action="${pageContext.request.contextPath }/hms/or/update" method="post" id="xq-form"
								onsubmit="return checkinfo()">
								<table class="table table-condensed">

								</table>
							</form>
							<!-- /修改显示公告信息表单-->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<!--修改会自动影藏此按钮-->
							<button type="button" class="btn btn-primary" id="xq-form-sumbit"
								onclick="return confirm('确定修改？')">提交更改</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.公告模态框（Modal） -->
			</div>
		</div>
	</div>
</body>

</html>