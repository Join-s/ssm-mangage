<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<!--bootstrap框架文件-->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/js/mangage/reports.js"></script>
	</head>

	<body>
		<div class="container-fluid">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<h3>
				反馈列表
			</h3>
				</div>
			</div>
			<div class="row clearfix">

				<div class="col-md-12 column">

					<form action="" method="post">

						<table class="table table-condensed table-striped">
							<thead>
								<tr></tr>
								<tr>
									<th>
										状态
									</th>
									<th>
										用户
									</th>
									<th>
										标题
									<th>
										内容
									</th>
									<th>
										时间
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<input type="checkbox" name="ids" value="" />
									</td>
									<td>
										是
									</td>
									<td>
										计算机与信息工程学院软件工程1班
									</td>
									<td>
										是的尴尬死人是的尴尬死人是的尴尬死人是的是的尴尬死人是的尴尬死人是的尴尬死人是的尴尬死人尴尬死人是的尴尬死人是的尴尬死人是的尴尬死人是的尴尬死人是的尴尬死人
									</td>
									<td>
2018-06-06
									</td>
								</tr>

							</tbody>
						</table>
					</form>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="col-lg-2">
						<ul class="pagination pagination-sm">
							<li>
								<a class="btn btn-primary" onclick="checkId()">全选</a>
							</li>
							<li>
								<a class="btn btn-warning" onclick="return delteCheck()">删除</a>
							</li>
						</ul>
					</div>

					<div class="col-lg-8">
						<ul class="pagination pagination-sm fenye-ul">
							<li>
								<a href="#">Prev</a>
							</li>
							<li class="active">
								<a href="#">1</a>
							</li>
							<li>
								<a href="#">2</a>
							</li>
							<li>
								<a href="#">3</a>
							</li>
							<li>
								<a href="#">4</a>
							</li>
							<li>
								<a href="#">5</a>
							</li>
							<li>
								<a href="#">Next</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="row">
						<!-- 公告模态框（Modal） -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">公告详情</h4>

									</div>
									<div class="modal-body">
										<!--修改显示公告信息表单-->
										学号，姓名，性别，电话，qq，荣耀值，学院专业班级，申领权限，是否毕业，辅导员，辅导员电话
										<form action="" method="post" id="xq-form" onsubmit="return checkinfo()">
											<table class="table table-condensed">
												<tr>
													<td>
														<b>公告标题:</b>
														<input type="text" value="" name="" id="ntitile" />
													</td>
												</tr>
												<tr>
													<td><b>公告内容:</b></td>
												</tr>
												<tr>
													<td>
														<textarea id="ntext" name="" cols="76%" rows="20"></textarea>
													</td>
												</tr>
												<tr>
													<td>
														<b>公告链接:</b>
													</td>
												</tr>
												<tr>
													<td>
														<input type="text" value="" name="" id="nurl" />
													</td>
												</tr>
												<tr>
													<td><b>公告时间:</b>
														<input type="date" value="" name="" id="ntime" />
													</td>
												</tr>
												<tr>
													<td><b>状态:</b>
														<input type="text" value="" name="" id="nstatus" />
														<input type="hidden" value="" name="" id="nid" />
													</td>
												</tr>
											</table>
										</form>
										<!-- /修改显示公告信息表单-->
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										<!--修改会自动影藏此按钮-->
										<button type="button" class="btn btn-primary" id="xq-form-sumbit" onclick="return confirm('确定修改？')">提交更改</button>
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