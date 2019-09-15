$(function() {
//	$("#ss-btn").click(function(){
//		
//		$("#ss-form").submit();
//		
//	});
$("#tongguo-btn").click(function(){//审核通过学生订单
	
	
	window.location.reload();
	
	
});
	function fenyeInit() { //分页效果初始化
		//分页效果开始
		var ul_li_len = $(".fenye-ul li").length;
		if(ul_li_len > 7) {
			for(i = 4; i < ul_li_len - 3; i++) {
				$(".fenye-ul li").eq(i).hide();
			}
		}
		$(".fenye-ul li a").click(function() {
			$(".fenye-ul li").show(); //所有节点显示便于计数
			var lass = $(".fenye-ul li[class='active']").index(); //点击之前的页数
			var now = $(this).parent().index(); //当前点击的页数
			var nowt = $(this).text();
			var len = $(".fenye-ul li").length; //所有li的个数
			//重置
			$(".fenye-ul li").attr("class", "");
			if(now == 0) { //点击的是上一页
				if(lass > 1) {
					$(".fenye-ul li").eq(lass - 1).attr("class", "active");
				} else {
					$(".fenye-ul li").eq(1).attr("class", "active");
				}
			} else if(now == len - 1) { //点击的是下一页
				//			alert(lass);
				if(lass < len - 2) {
					$(".fenye-ul li").eq(lass + 1).attr("class", "active");
				} else {
					$(".fenye-ul li").eq(len - 2).attr("class", "active");
				}
			} else { //点击的是中间的页数
				$(".fenye-ul li").eq(now).attr("class", "active");
			};
			var nowactive = $(".fenye-ul li[class='active']").index(); //激活的页面序号
			//防止页数过多
			if(isNaN(nowt)) { //bu是数字？
				if(now == 0) { //点击的是上一页
					if(len - 2 > 5 && nowactive < len - 3 && nowactive > 3) { //大于5页 并且不是后两页 和前两页
						for(i = 3; i < nowactive; i++) {
							$(".fenye-ul li").eq(i).hide();
						}
						for(i = nowactive + 1; i < len - 3; i++) {
							$(".fenye-ul li").eq(i).hide();
						}
					} else if(len - 2 > 5 && nowactive >= len - 3 && nowactive < len) { //大于5页 是后两页
						for(i = 3; i < len - 4; i++) {
							$(".fenye-ul li").eq(i).hide();
						}
					} else if(len - 2 > 5 && nowactive >= 1 && nowactive <= 3) { //大于5页 是前两页
						for(i = 4; i < len - 3; i++) {
							$(".fenye-ul li").eq(i).hide();
						}
					}
				} else { //点击的是下一页
					if(len - 2 > 5 && nowactive < len - 3 && nowactive > 3) { //大于5页 并且不是后两页 和前两页
						for(i = 3; i < nowactive; i++) {
							$(".fenye-ul li").eq(i).hide();
						}
						for(i = nowactive + 1; i < len - 3; i++) {
							$(".fenye-ul li").eq(i).hide();
						}
					} else if(len - 2 > 5 && nowactive >= len - 3 && nowactive < len) { //大于5页 是后两页
						for(i = 3; i < len - 4; i++) {
							$(".fenye-ul li").eq(i).hide();
						}
					} else if(len - 2 > 5 && nowactive >= 1 && nowactive <= 3) { //大于5页 是前两页
						for(i = 4; i < len - 3; i++) {
							$(".fenye-ul li").eq(i).hide();
						}
					}
				}
			} else { //			alert('是数字');
				if(len - 2 > 5 && nowactive < len - 3 && nowactive > 3) { //大于5页 并且不是后两页 和前两页
					for(i = 3; i < nowactive; i++) {
						$(".fenye-ul li").eq(i).hide();
					}
					for(i = nowactive + 1; i < len - 3; i++) {
						$(".fenye-ul li").eq(i).hide();
					}
				} else if(len - 2 > 5 && nowactive >= len - 3 && nowactive < len) { //大于5页 是后两页
					for(i = 3; i < len - 4; i++) {
						$(".fenye-ul li").eq(i).hide();
					}
				} else if(len - 2 > 5 && nowactive >= 1 && nowactive <= 3) { //大于5页 是前两页
					for(i = 4; i < len - 3; i++) {
						$(".fenye-ul li").eq(i).hide();
					}
				}
			}
		}); ////分页效果结束
	}
	fenyeInit();
	
	//模态框弹出初始化
	function modelInitBtns() {
		//模态框表单提交
		$("#xq-form-sumbit").click(function() {
			$("#xq-form").submit();
			$("#myModal").modal('hide');
		});
		
		var host=window.location.host;

		//模态框详情点击按钮
		$(".xq-btn").click(function() {
			$("#xq-form-sumbit").hide();
			var oid=$(this).attr("oid");
			$("#myModalLabel").text("订单详情");//标题
			$("#xq-form table").children().remove();
			var url="orders?oid="+oid;
//			alert(url);
			
			$.ajax({
				type: "POST",
				url: url,
				contentType: "application/json",
				success: function(data) {
					//元件名称，规格，品牌，价格，位置，数量
					
					var tr1=$("<tr></tr>");
					var td1=$("<td>元件名称</td>");
					var td2=$("<td>数量</td>");
					var td3=$("<td>品牌</td>");
					var td4=$("<td>价格</td>");
					var td5=$("<td>位置</td>");
					var td6=$("<td>规格</td>");
					tr1.append(td1);
					tr1.append(td2);
					tr1.append(td3);
					tr1.append(td4);
					tr1.append(td5);
					tr1.append(td6);
					
					
					$("#xq-form table").append(tr1);
					for(i=0;i<data.tOrderdetails.length;i++){
						var tr2=$("<tr></tr>");
						var li21=$("<td>"+data.tOrderdetails[i].tComponent.name+"</td>");
						var li22=$("<td>"+data.tOrderdetails[i].number+"</td>");
						var li23=$("<td>"+data.tOrderdetails[i].tComponent.brand+"</td>");
						var li24=$("<td>"+data.tOrderdetails[i].tComponent.price+"</td>");
						var li25=$("<td>"+data.tOrderdetails[i].tComponent.place+"</td>");
						var li26=$("<td>"+data.tOrderdetails[i].tComponent.specification+"</td>");
						tr2.append(li21);
						tr2.append(li22);
						tr2.append(li23);
						tr2.append(li24);
						tr2.append(li26);
						tr2.append(li25);
						$("#xq-form table").append(tr2);
						
					}
					
					
					
					
					
					
					$("#xq-form-sumbit").hide();//提交按钮
				},
				error: function() {
						alert("error!");
					 
				}
			});
		});

		//模态框打回按钮
		$(".dh-btn").click(function() {
			$("#xq-form-sumbit").show();
			$("#myModalLabel").text("订单打回");//标题
			$("#xq-form").children().remove();
			
//			$("#xq-form").attr("action","");
			
			var oid = $(this).attr("oid");
//			alert(ids);
			
			var mtable = $("<table class='table table-condensed'></table>");
			var tr1 = $("<tr><td>打回原因</td></tr>");
			var tr2 = $("<tr></tr>");
			var td2 = $("<td></td>");
			var mtext2 = $("<textarea name='remark' cols='76' rows='10' >不和标准</textarea>");
			var hinput=$("<input type='hidden' name='id' value='"+oid+"'/>");
			var hinput2=$("<input type='hidden' name='status' value='3'/>");
			td2.append(mtext2);
			td2.append(hinput);
			td2.append(hinput2);
			tr2.append(td2);
			mtable.append(tr1);
			mtable.append(tr2);
			$("#xq-form").append(mtable);
			
//			$.ajax({
//				type: "get",
//				url: "#",
//				contentType: "application/json",
//				data: ids,
//				success: function(data) {
//
//				},
//				error: function(data) {
//				
//				}
//			});
		});
	} ////模态框弹出初始化
	modelInitBtns();
});

function checkId() {
	//获取name 为ids的集合
	var ids = document.getElementsByName("ids");
	//循环遍历
	for(var i in ids) {
		//获取循环出来的每一个input标签 
		var id = ids[i];
		if(id.checked) { //如果被选择  true
			id.checked = false;
		} else {
			id.checked = true;
		}
	}

}

function getCheckId() {
	var flag = false;
	//获取name 为ids的集合
	var ids = document.getElementsByName("ids");
	//循环遍历
	for(var i in ids) {
		//获取循环出来的每一个input标签 
		var id = ids[i];
		if(id.checked) { //如果被选择  true
			flag = true;
			return flag;
		}
	}
	return flag;
}
//删除按钮
function delteCheck() {
	var flag = getCheckId();
	var from1 = $("#from1");
	alert(1);
	if(flag) {
		from1.submit();
		alert("删除成功");
	} else {
		alert("请至少选择一行");
		return false;
	}
	return true;
}
//模态框表检查信息
function checkinfo() {
//	alert('提交失败');
//	return false;
}