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
	<style>
	#bj,#fdy,#dfydh{
	
	width:300px;}
	.w300{
	width:300px;}
	
	</style>
	</head>
	</head>
	<body>
		<div class="container-fluid">
			<div class="col-md-12 column">
				<span>院系总览</span>
				<hr size="1pxs" color="#000000" />
				<div class="col-md-12 column">

					<span>院系：</span>
					<select name="" id="college" class="form-control">
						<option value="1">计算机学院</option>
					</select>

				</div>
				<div class="col-md-12 column">

					<span>专业：</span>
					<select name="" id="major" class="form-control">
						<option>请选择专业</option>
					</select>

				</div>

				<div class="col-md-3 column">
					<table class="table table-bordered" id="mytab">
						<caption>班级列表</caption>
						<thead>
							<tr>
								<th id="bj">班级名称</th>
								<th id="fdy">辅导员</th>
								<th id="fdydh">辅导员电话</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>暂无信息</td>
								<td>暂无信息</td>
								<td>暂无信息</td>
							</tr>

						</tbody>
					</table>

				</div>
			</div>
		
			<div class="col-md-12 column">
				<hr />
				<hr />
				<span>添加学生院系信息</span>
				<hr size="1pxs" color="#000000" />

				<label>请选择添加：</label>
				<br />
				<select id="fcollege" class="form-control">
					<option value="1">学院</option>
					<option value="2">专业</option>
					<option value="3">班级</option>
				</select>
				<br />
				<select id="fcolleges" class="form-control">
					<option value="-1">请选择学院</option>
					<option value="2">学院2</option>
					<option value="3">学院3</option>
				</select>
				<br />
				<select id="fmajors" class="form-control">
					<option value="-1">请选择专业</option>
					<option value="1">专业2</option>
				</select>
				<br />

				<br />
				<form action="../addAdaps" method="post">
				<input type="hidden" name="numid" id="numid" value="1">
				<input type="hidden" name="depid" id="whoid">
					<input type="text" id="mname" name="name" placeholder="请填写学院名" />
					<input type="text" class="mteam" id="year" name="year"   placeholder="请填写班级入学年级" />
					<input type="text" class="mteam" id="tutor" name="tutor"  placeholder="请填写辅导员" />
					<input type="text" class="mteam" id="tutortel" name="tutortel"    placeholder="请填写辅导员手机号" />
					<input type="submit" value="确认添加" />
				</form>
				<br/>
				<br/>
				<br/>
				<hr/>
				<hr/>
			</div>
		</div>
	</body>
	<script>
	

	var myDatas = [{
			id: 1,
			name: "计算机与信息工程学院",
			tMajors: [
			]
		},
		{
			id: 2,
			name: "数学与统计学院",
			tMajors: [{
					id: 7,
					depid: 2,
					name: "数学统计",
					tGrades: [{
						id: 17,
						magid: 7,
						name: "1半",
						year: 2016,
						tutor: "武侠",
						tutortel: "1561560",
						tMajor: null
					}],
					tDepartment: null
				},
				{
					id: 8,
					depid: 2,
					name: "数学计算",
					tGrades: [{
						id: 18,
						magid: 8,
						name: "2半",
						year: 2017,
						tutor: "阿莎",
						tutortel: "4516",
						tMajor: null
					}],
					tDepartment: null
				}
			]
		},
		{
			id: 3,
			name: "家里蹲",
			tMajors: []
		},
	]

		

		//console.log("-1-");
		$(function() {
			//console.log("-2-");
			
			function myInit(){


				if(myDatas != null) {
					
					$("#college").children().remove();
					$("#college").append("<option data-index='-1' value='0'>请选择学院</option>");
					//myDatas=updataInfos();
					
					//console.log("学院"+myDatas);
					var len = myDatas.length
					//console.log("学院"+len);
					for(var i = 0; i < len; i++) {
						$("#college").append("<option data-index=" + i + " value='" + myDatas[i].id + "'>" + myDatas[i].name + "</option>");
					}
					
					$("#fcolleges").children().remove();
					$("#fcolleges").append("<option data-index='-1' value='0'>请选择学院</option>");

					var len = myDatas.length
					for(var i = 0; i < len; i++) {
						$("#fcolleges").append("<option data-index=" + i + " value='" + myDatas[i].id + "'>" + myDatas[i].name + "</option>");
					}
					
					
				}

				$("#college").change(function() {
					var myindex = $("#college option:checked").attr("data-index");
					if(myindex != -1) {
						$("#major").children().remove();
						$("#major").append("<option data-mindex='-1' value='0'>请选择专业</option>");
						
						var mymajs = myDatas[myindex].tMajors;
						for(var j = 0; j < mymajs.length; j++) {
							$("#major").append("<option data-mindex='" + j + "'  value='" + mymajs[j].id + "'>" + mymajs[j].name + "</option>");
						}
					}
				});
				$("#major").change(function() {
					var mycindex = $("#college option:checked").attr("data-index");
					var mymindex = $("#major option:checked").attr("data-mindex");
					if(mymindex != -1) {
						$("#mytab tbody").children().remove();
						
						var myteams = myDatas[mycindex].tMajors[mymindex].tGrades;
						for(var k = 0; k < myteams.length; k++) {
							$("#mytab tbody").append("<tr><td class='w300'>" + myteams[k].year + "级" + myteams[k].name + "</td><td>" + myteams[k].tutor + "</td><td>" + myteams[k].tutortel + "</td></tr>");
						}
					}
				});
				
				$("#fcolleges").change(function() {
					var myindex = $("#fcolleges option:checked").attr("data-index");
					
					$("#whoid").attr("value",$("#fcolleges option:checked").attr("value"));
					if(myindex != -1) {
						$("#fmajors").children().remove();
						$("#fmajors").append("<option data-mindex='-1' value='0'>请选择专业</option>");

						var mymajs = myDatas[myindex].tMajors;
						for(var j = 0; j < mymajs.length; j++) {
							$("#fmajors").append("<option data-mindex='" + j + "'  value='" + mymajs[j].id + "'>" + mymajs[j].name + "</option>");
						}
					}
				});
				$("#fmajors").change(function() {
					$("#whoid").attr("value",$("#fmajors option:checked").attr("value"));
					
				});
						
						
						$("#fcolleges").hide();
						$("#fmajors").hide();
						$(".mteam").hide();
						$("#fcollege").change(function() {
							var cindex = $("#fcollege option:checked").val();
							//console.log(cindex);
							if(cindex == 1) { //学院
								$("#fcolleges").hide();
								$("#fmajors").hide();
								$("#mname").attr("placeholder", "请填写学院名");
								$("#numid").attr("value","1");
								$(".mteam").hide();
							} else if(cindex == 2) { //专业
								$("#fcolleges").show();
								$("#fmajors").hide();
								$("#numid").attr("value","2");
								$("#whoid").attr("name","depid");
								
								$("#mname").attr("placeholder", "请填写专业名");
								$(".mteam").hide();

							} else { //班级
								$("#fcolleges").show();
								$("#fmajor").show();
								$("#fmajors").show();
								$("#numid").attr("value","3");
								$("#mname").attr("placeholder", "请填写班级名");
								$("#whoid").attr("name","magid");
								
								$(".mteam").show();
							}

						});
				
			}//myInit

			function updataInfos(){
				$.ajax({
					type: "post",
					url: "../depList",
					dataType: "json",
					/*这句可用可不用，没有影响*/
					contentType: "application/json; charset=utf-8",
					success: function(data) {
						myDatas=data;
						
						//console.log("-3-"+myDatas.length);
						
						myInit();
						
					},
					error: function(XMLHttpRequest, textStatus, errorThrown) {
						 
						console.log(errorThrown);
					}
				});
				}//updataInfos
			updataInfos();
		});//初始化
		
		

		
		
		
		

	</script>
</html>
