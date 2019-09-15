$(function () {
    // 元件列表初始化
    $(".btn-tog").css("display", "none");
    $(".elename").attr("class", "col-lg-6 elename")
    $(".elenum").attr("class", "col-lg-4 elenum")
    $(".elebtn").attr("class", "col-lg-2 elebtn")
    $(".eleinfodet").attr("class", "col-lg-12 eleinfodet")
    $(".btn-tog-all").attr("onclick", "btntog2(this)");
    $(".btn-tog-all").text("展开");

    // 详情
    $(".xiangqing")
        .click(
            function () {
                var id = $(this).attr("id");
                $
                    .ajax({
                        type: "post",
                        url: "../order/orders?oid=" + id,
                        contentType: "application/json; charset=utf-8",
                        success: function (data) {
                            $(".modal-title").text("订单详情");
                            $(".modal-body").children().remove();
//										alert(data);
                            if (data != null)
                                if (data.tOrderdetails.length > 0)
                                    for (i = 0; i < data.tOrderdetails.length; i++) {

                                        var name = data.tOrderdetails[i].tComponent.name;
                                        var number = data.tOrderdetails[i].number;
                                        var specification = data.tOrderdetails[i].tComponent.specification;
                                        var brand = data.tOrderdetails[i].tComponent.brand;
                                        var version = data.tOrderdetails[i].tComponent.version;
                                        var price = data.tOrderdetails[i].tComponent.price;
                                        var place = data.tOrderdetails[i].tComponent.place;
                                        var store = data.tOrderdetails[i].tComponent.store;

                                        var div1 = $("<div class='row ordetails'></div>");
                                        var div2 = $("<div class='col-lg-12 col-lg-offset-0 alert alert-info'></div>");

                                        var div23 = $("<div class='col-lg-2  col-sm-12  col-xs-12 btn-tog'></div>");
                                        var img23 = $("<img src='/resource/img/register-success.jpg' class='img img-circle'	width='100px' height='100px' />");

                                        var div24 = $("<div class='col-lg-9 eleinfodet'></div>");
                                        var div241 = $("<div class='col-lg-12 elename'>"
                                            + name + "</div>");
                                        var div242 = $("<div class='col-lg-12 elenum'>"
                                            + number + "</div>");
                                        var div243 = $("<div class='col-lg-6 btn-tog'>规格："
                                            + specification + "</div>");
                                        var div244 = $("<div class='col-lg-6 btn-tog'>品牌："
                                            + brand + "</div>");
                                        var div245 = $("<div class='col-lg-6 btn-tog'>型号："
                                            + version + "</div>");
                                        var div246 = $("<div class='col-lg-6 btn-tog'>单价："
                                            + price + "￥</div>");
                                        var div247 = $("<div class='col-lg-6 btn-tog'>位置："
                                            + place + "</div>");
                                        var div248 = $("<div class='col-lg-6 btn-tog'>库存：<span>"
                                            + store + "</span>个	</div>");
                                        var div249 = $("<div class='col-lg-2 col-lg-offset-10 elebtn'><a href='#' class='btn-tog-all' onclick='btntog(this)'>收起</a></div>");

                                        div23.append(img23);
                                        div2.append(div23);

                                        div24.append(div241);
                                        div24.append(div242);
                                        div24.append(div243);
                                        div24.append(div244);
                                        div24.append(div245);
                                        div24.append(div246);
                                        div24.append(div247);
                                        div24.append(div248);
                                        div24.append(div249);
                                        div2.append(div24);
                                        div1.append(div2);
                                        $(".modal-body").append(div1);

                                    }
                            // $("#myInfo").children().remove();
                            // $("#myInfo").append(form1);

                        },
                        error: function () {

                            $(".modal-title").text("请求出错！");
                            $(".modal-body").children().remove();
                            alert('请重新登陆！');
                        }
                    });

            });
    // /xiangqing

    // 修改密码
    $("#xg-pwd-btn")
        .click(
            function () {
                var id = $("#info-btn").attr("uid");
                $
                    .ajax({
                        type: "post",
                        url: "../stu/find?id=" + id,
                        contentType: "application/json; charset=utf-8",
                        success: function (data) {
                            var jnumber = data.jnumber;// 学号
                            var name = data.name;// 姓名
                            var seat = data.seat; // 座位
                            var yjnum = data.yjnum; // 实验室编号
                            var pwd = data.pwd;

                            var tr1 = $("<tr></tr>");
                            var td11 = $("<td>学号</td>");
                            var td12 = $("<td><input type='number' name='jnumber' value='"
                                + jnumber + "'/></td>");
                            tr1.append(td11);
                            tr1.append(td12);
                            var tr2 = $("<tr></tr>");
                            var td21 = $("<td>姓名</td>");
                            var td22 = $("<td><input type='text' name='name' value='"
                                + name + "'/></td>");
                            tr2.append(td21);
                            tr2.append(td22);
                            var tr12 = $("<tr></tr>");
                            var td121 = $("<td>座位</td>");
                            var td122 = $("<td><input type='text'  name='seat' value='"
                                + seat + "'/></td>");
                            tr12.append(td121);
                            tr12.append(td122);
                            var tr13 = $("<tr></tr>");
                            var td131 = $("<td>实验室编号</td>");
                            var td132 = $("<td><input type='text'  name='yjnum' value='"
                                + yjnum + "'/></td>");
                            tr13.append(td131);
                            tr13.append(td132);
                            var tr14 = $("<tr></tr>");

                            var td143 = $("<td><input  type='hidden' name='id' value='"
                                + id + "'/></td>");

                            tr14.append(td143);
                            var tr140 = $("<tr></tr>");

                            var td1430 = $("<td>密码：</td><td><input  type='password' name='pwd' value='"
                                + pwd + "'/></td>");

                            tr140.append(td1430);


                            var form1 = $("<form action='../stu/update' method='post'></form>");

                            form1.append(tr1);
                            form1.append(tr2);
                            form1.append(tr12);
                            form1.append(tr13);
                            form1.append(tr14);
                            form1.append(tr140);
                            var sub = $("<input type='submit' value='确定修改'/>");
                            form1.append(sub);

                            $("#myInfo").children().remove();
                            $("#myInfo").append(form1);

                        },
                        error: function () {
                            alert('请重新登陆！');
                        }
                    });

            });

    // 修改个人信息
    $("#xg-info-btn")
        .click(
            function () {
                var id = $("#info-btn").attr("uid");
                $
                    .ajax({
                        type: "post",
                        url: "../stu/find?id=" + id,
                        contentType: "application/json; charset=utf-8",
                        success: function (data) {
                            var jnumber = data.jnumber;// 学号
                            var name = data.name;// 姓名
                            var sex = data.sex;// 性别
                            var tel = data.tel;// 电话
                            var qq = data.qq;// qq
                            var graid = data.graid; // 班级id
                            var isgraduate = data.isgraduate;// 毕业
                            var introduce = data.introduce; // 介绍
                            var photo = data.photo;// 头像
                            var intime = data.intime; // 入学年份

                            var tr1 = $("<tr></tr>");
                            var td11 = $("<td>学号</td>");
                            var td12 = $("<td><input type='number' name='jnumber' value='"
                                + jnumber + "'/></td>");
                            tr1.append(td11);
                            tr1.append(td12);
                            var tr2 = $("<tr></tr>");
                            var td21 = $("<td>姓名</td>");
                            var td22 = $("<td><input type='text' name='name' value='"
                                + name + "'/></td>");
                            tr2.append(td21);
                            tr2.append(td22);
                            var tr3 = $("<tr></tr>");
                            var td31 = $("<td>性别</td>");
                            var td32 = $("<td><input  type='text' name='sex' value='"
                                + sex + "'/></td>");
                            tr3.append(td31);
                            tr3.append(td32);
                            var tr4 = $("<tr></tr>");
                            var td41 = $("<td>电话</td>");
                            var td42 = $("<td><input type='number'  name='tel' value='"
                                + tel + "'/></td>");
                            tr4.append(td41);
                            tr4.append(td42);
                            var tr5 = $("<tr></tr>");
                            var td51 = $("<td>qq</td>");
                            var td52 = $("<td><input type='number'  name='qq' value='"
                                + qq + "'/></td>");
                            tr5.append(td51);
                            tr5.append(td52);
                            var tr6 = $("<tr></tr>");
                            var td61 = $("<td>荣耀值</td>");
                            var td62 = $("<td><input  type='number'  name='honourval' value='"
                                + honourval + "'/></td>");
                            tr6.append(td61);
                            tr6.append(td62);
                            var tr8 = $("<tr></tr>");
                            var td81 = $("<td>毕业</td>");
                            var td82 = $("<td><input name='isgraduate' value='"
                                + isgraduate + "'/></td>");
                            tr8.append(td81);
                            tr8.append(td82);
                            var tr9 = $("<tr></tr>");
                            var td91 = $("<td>介绍</td>");
                            var td92 = $("<td><input type='text'  name='introduce' value='"
                                + introduce + "'/></td>");
                            tr9.append(td91);
                            tr9.append(td92);
                            var tr10 = $("<tr></tr>");
                            var td101 = $("<td>头像</td>");
                            var td102 = $("<td><input type='file'  name='photo' value='"
                                + photo + "'/></td>");
                            tr10.append(td101);
                            tr10.append(td102);
                            var tr11 = $("<tr></tr>");
                            var td111 = $("<td>入学年份</td>");
                            var td112 = $("<td><input type='number'  name='intime' value='"
                                + intime + "'/></td>");
                            tr11.append(td111);
                            tr11.append(td112);
                            var tr14 = $("<tr></tr>");

                            var td143 = $("<td><input  type='hidden' name='id' value='"
                                + id + "'/></td>");

                            tr14.append(td143);
                            var form1 = $("<form action='../stu/update' method='post'></form>");

                            form1.append(tr1);
                            form1.append(tr2);
                            form1.append(tr3);
                            form1.append(tr4);
                            form1.append(tr5);
                            form1.append(tr6);
                            form1.append(tr8);
                            form1.append(tr9);
                            form1.append(tr11);
                            form1.append(tr12);
                            form1.append(tr13);
                            form1.append(tr14);
                            var sub = $("<input type='submit' value='确定修改'/>");
                            form1.append(sub);

                            $("#myInfo").children().remove();
                            $("#myInfo").append(form1);

                        },
                        error: function () {
                            alert('请重新登陆！');
                        }
                    });

            });

    // 个人信息展示
    $("#info-btn")
        .click(
            function () {
                var id = $("#info-btn").attr("uid");
                $
                    .ajax({
                        type: "post",
                        url: "../stu/find?id=" + id,
                        contentType: "application/json; charset=utf-8",
                        success: function (data) {

                            $("#myInfo").children().remove();

                            var jnumber = data.jnumber;// 学号
                            var name = data.name;// 姓名
                            var sex = data.sex;// 性别
                            var tel = data.tel;// 电话
                            var qq = data.qq;// qq
                            var honourval = data.honourval;// 荣耀值
                            var graid = data.graid; // 班级id
                            var level = data.level; // 申领权限
                            var isgraduate = data.isgraduate;// 毕业
                            var introduce = data.introduce; // 介绍
                            var photo = data.photo;// 头像
                            var intime = data.intime; // 入学年份
                            var seat = data.seat; // 座位
                            var yjnum = data.yjnum; // 实验室编号
                            var remark1 = data.remark1; // 类别

                            var tr1 = $("<tr></tr>");
                            var td11 = $("<td>学号</td>");
                            var td12 = $("<td>" + jnumber + "</td>");
                            tr1.append(td11);
                            tr1.append(td12);
                            var tr2 = $("<tr></tr>");
                            var td21 = $("<td>姓名</td>");
                            var td22 = $("<td>" + name + "</td>");
                            tr2.append(td21);
                            tr2.append(td22);
                            var tr3 = $("<tr></tr>");
                            var td31 = $("<td>性别</td>");
                            var td32 = $("<td> " + sex + " </td>");
                            tr3.append(td31);
                            tr3.append(td32);
                            var tr4 = $("<tr></tr>");
                            var td41 = $("<td>电话</td>");
                            var td42 = $("<td> " + tel + " </td>");
                            tr4.append(td41);
                            tr4.append(td42);
                            var tr5 = $("<tr></tr>");
                            var td51 = $("<td>qq</td>");
                            var td52 = $("<td> " + qq + " </td>");
                            tr5.append(td51);
                            tr5.append(td52);
                            var tr6 = $("<tr></tr>");
                            var td61 = $("<td>荣耀值</td>");
                            var td62 = $("<td> " + honourval
                                + " </td>");
                            tr6.append(td61);
                            tr6.append(td62);
                            var tr7 = $("<tr></tr>");
                            var td71 = $("<td>申领权限</td>");
                            var td72 = $("<td> " + level + " </td>");
                            tr7.append(td71);
                            tr7.append(td72);
                            var tr8 = $("<tr></tr>");
                            var td81 = $("<td>毕业</td>");
                            var td82 = $("<td> " + isgraduate
                                + " </td>");
                            tr8.append(td81);
                            tr8.append(td82);
                            var tr9 = $("<tr></tr>");
                            var td91 = $("<td>介绍</td>");
                            var td92 = $("<td> " + introduce
                                + " </td>");
                            tr9.append(td91);
                            tr9.append(td92);
                            var tr10 = $("<tr></tr>");
                            var td101 = $("<td>头像</td>");
                            var td102 = $("<td> " + photo
                                + " </td>");
                            tr10.append(td101);
                            tr10.append(td102);
                            var tr11 = $("<tr></tr>");
                            var td111 = $("<td>入学年份</td>");
                            var td112 = $("<td> " + intime
                                + " </td>");
                            tr11.append(td111);
                            tr11.append(td112);
                            var tr12 = $("<tr></tr>");
                            var td121 = $("<td>座位</td>");
                            var td122 = $("<td><input type='text'  name='seat' value='"
                                + seat + "'/></td>");
                            tr12.append(td121);
                            tr12.append(td122);
                            var tr13 = $("<tr></tr>");
                            var td131 = $("<td>实验室编号</td>");
                            var td132 = $("<td> " + yjnum
                                + " </td>");
                            tr13.append(td131);
                            tr13.append(td132);
                            var tr14 = $("<tr></tr>");
                            var td141 = $("<td>类别</td>");
                            var td142 = $("<td> " + remark1
                                + " </td>");
                            tr14.append(td141);
                            tr14.append(td142);

                            $("#myInfo").append(tr1);
                            $("#myInfo").append(tr2);
                            $("#myInfo").append(tr3);
                            $("#myInfo").append(tr4);
                            $("#myInfo").append(tr5);
                            $("#myInfo").append(tr6);
                            $("#myInfo").append(tr7);
                            $("#myInfo").append(tr8);
                            $("#myInfo").append(tr9);
                            $("#myInfo").append(tr11);
                            $("#myInfo").append(tr12);
                            $("#myInfo").append(tr13);
                            $("#myInfo").append(tr14);

                        },
                        error: function () {
                            alert('请重新登陆！');
                        }
                    });
            });

});

// 显示订单详情
function showordersinfo(node) {

    $(".showordersinfo").show();
    $(".showpersonalinfo").hide();
    $(".showorders_li").attr("class", "list-group-item active showorders_li");
    $(".showperson_li").attr("class", "list-group-item showperson_li");

    $(".showorders_li a").css("font-size", "25px");
    $(".showperson_li").css("font-size", "14px");
    return false;
}

// 显示个人信息
function showpersonalinfo(node) {
    $(".showordersinfo").hide();
    $(".showpersonalinfo").show();
    $(".showorders_li").attr("class", "list-group-item showorders_li");
    $(".showperson_li").attr("class", "list-group-item active showperson_li");
    $(".showorders_li a").css("font-size", "14px");
    $(".showperson_li").css("font-size", "25px");
    return false;
}

// 收起元件列表
function btntog(node) {
    $(node).parent().parent().parent().find($(".btn-tog")).css("display",
        "none");
    $(node).parent().parent().parent().find($(".elename")).attr("class",
        "col-lg-6 elename")
    $(node).parent().parent().parent().find($(".elenum")).attr("class",
        "col-lg-4 elenum")
    $(node).parent().parent().parent().find($(".elebtn")).attr("class",
        "col-lg-2 elebtn")
    $(node).parent().parent().parent().find($(".eleinfodet")).attr("class",
        "col-lg-12 eleinfodet")
    $(node).parent().parent().parent().find($(".btn-tog-all")).attr("onclick",
        "btntog2(this)");
    $(node).parent().parent().parent().find($(".btn-tog-all")).text("展开");
}

// 展开元件列表
function btntog2(node) {
    $(node).parent().parent().parent().find(".btn-tog").css("display", "block");
    $(node).parent().parent().parent().find($(".elename")).attr("class",
        "col-lg-12 elename")
    $(node).parent().parent().parent().find($(".elenum")).attr("class",
        "col-lg-12 elenum")
    $(node).parent().parent().parent().find($(".elebtn")).attr("class",
        "col-lg-2 col-lg-offset-10 elebtn")
    $(node).parent().parent().parent().find($(".eleinfodet")).attr("class",
        "col-lg-9 eleinfodet")
    $(node).parent().parent().parent().find($(".btn-tog-all")).attr("onclick",
        "btntog(this)");
    $(node).parent().parent().parent().find($(".btn-tog-all")).text("收起");
}

// 删除订单
function deleteorders(node) {
//	var flag = confirm('确定取消此订单？');
//	if (flag) {
//		$(node).parent().parent().remove();
//
//		return true;
//	} else {
//		alert("已取消");
//		return false;
//	}

}
