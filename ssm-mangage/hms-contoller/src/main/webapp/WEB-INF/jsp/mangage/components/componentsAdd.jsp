<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
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

		<style>
			tr td:first {
				/*text-align: right;*/
			}
			
			td {
				text-align: center;
				line-height: 25px;
			}
			
			input[type='text'] {
				border-width: 0px;
				width: 100%;
				line-height: 20px;
			}
			
			select{
				width: 200px;
				text-align: -moz-left;
				text-align: -webkit-left;
				text-align: left;
			}
		</style>

	</head>

	<body>
		添加新元件:
		<div class="container-fluid">
			<div class="row clearfix">
				<div class="col-lg-6 col-lg-offset-2">
					<form action="${pageContext.request.contextPath }/hms/comp/addComp" method="post"  enctype="multipart/form-data">
						<table class="table table-condensed">
							<tr>
								<td width="100px" align="right">序号:</td>
								<td><input type="text" name="id" placeholder="序号"  /></td>
							</tr>
							<tr>
								<td align="right">元件名称:</td>
								<td><input type="text" name="name" placeholder="元件名称"    /></td>
							</tr>
							<tr>
								<td align="right">型号规格:</td>
								<td><input type="text" name="specification" placeholder="型号规格" /></td>
							</tr>
							<tr>
								<td align="right">位置:</td>
								<td><input type="text" name="place" placeholder="位置"  /></td>
							</tr>
							<tr>
								<td align="right">库存:</td>
								<td><input type="number" name="store" placeholder="库存	"  /></td>
							</tr>
							<tr>
								<td align="right">是否入库:</td>
								<td>
									<select name="isstore">
										<option value="0">未入库</option>
										<option value="1">已入库</option>
									</select>
								</td>
							</tr>
							<tr>
								<td align="right">值 :</td>
								<td><input type="text" name="val" placeholder="值	"   /></td>
							</tr>
							<tr>
								<td align="right">图片:</td>
								<td><input type="file" name="file" placeholder="图片	"    /></td>
							</tr>
							<tr>
								<td align="right">介绍 :</td>
								<td><input type="text" name="introduce" placeholder="介绍	"    /></td>
							</tr>
							<tr>
								<td align="right">单价 :</td>
								<td><input type="number" name="price"placeholder="单价	"   /></td>
							</tr>
							<tr>
								<td align="right">商城链接:</td>
								<td><input type="text" name="malllink" placeholder="商城链接	"   /></td>
							</tr>
							<tr>
								<td align="right">申领等级:</td>
								<td><input type="number" name="level" placeholder="申领等级	"  value="100" /></td>
							</tr>
							<tr>
								<td align="right">元件封装连接:</td>
								<td><input type="text" name="sealing" placeholder="元件封装连接	"    /></td>
							</tr>
							<tr>
								<td align="right">下载链接:</td>
								<td><input type="text" name="updownlink" placeholder="下载链接	"   /></td>
							</tr>
							<tr>
								<td align="right">原厂型号:</td>
								<td><input type="text" name="version" placeholder="原厂型号	"  /></td>
							</tr>
							<tr>
								<td align="right">品牌:</td>
								<td><input type="text" name="brand" placeholder="品牌	"   /></td>
							</tr>
							<tr>
								<td align="right">包装类型:</td>
								<td><input type="text" name="remark1" placeholder="包装类型"   /></td>
							</tr>
							<tr>
								<td align="right">是否可借:</td>
								<td>
									<select name="remark3">
										<option value="1">可借</option>
										<option value="0">不可借</option>
									</select>
								</td>
							</tr>
							<tr>
								<td align="right">品牌等级:</td>
								<td><input type="text" name="remark2"placeholder="品牌等级"  /></td>
							</tr>
							<tr>
								<td align="right">元件大类:</td>
								<td>
									<select name="tSubclass.id">
									<c:forEach items="${subclasses }" var="sli">
										<option value="${sli.id }">${sli.name }</option>
									</c:forEach>
									</select>
									<!--<input type="text" name="" value="元件大类	" />-->
								</td>
							</tr>
							<tr>
								<td align="right">元件小类:</td>
								<td>
									<select name="sid">
										<c:forEach items="${largeclasses }" var="lli">
										<option value="${lli.id }">${lli.name }</option>
									</c:forEach>
									</select>
									<!--<input type="text" name="" value="元件小类	" />-->
								</td>
							</tr>
							<tr>
								<td align="right"></td>
								<td><input type="submit" value="提交" class="btn-default" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>

	</body>

</html>
