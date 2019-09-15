<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>

<!--注册页面-->
<html>

<head>
    <meta charset="UTF-8">
    <title>注册用户</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/css/register.css"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/css/bootstrap.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/hms/resource/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/js/register.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div class="container-fluid">
    <!-- 主体 start -->
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
            <form action="${pageContext.request.contextPath }/hms/user/register" method="post"
                  onsubmit="return check()">
                <h1><b>用户注册</b></h1><br/><br/>
                <table class="table table-hover">
                    <tbody>
                    <tr>
                        <td align="right">
                            姓名：
                        </td>
                        <td><input type="text" value="" name="name" id="username" onblur="checkUsername()"/><span
                                id="usernameSpan">*</span></td>
                    </tr>
                    <tr>
                        <td align="right">
                            学号：
                        </td>
                        <td><input type="text" value="" name="jnumber" id="usernumber" onblur="checkUsernumber()"/><span
                                id="usernumberSpan">*</span></td>
                    </tr>
                    <tr>
                        <td align="right">
                            密码：
                        </td>
                        <td><input type="password" value="" name="pwd" id="pwd" onblur="checkPwd()"/><span id="pwdSpan">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            确认密码：
                        </td>
                        <td><input type="password" value="" id="repwd" onblur="checkRepwd()"/><span
                                id="repwdSpan">*</span></td>
                    </tr>
                    <tr>
                        <td align="right">
                            性别：
                        </td>
                        <td><input type="radio" value="男" name="sex" checked="checked"/>男
                            <input type="radio" value="女" name="sex"/>女
                        </td>
                    </tr>


                    <tr>
                        <td align="right">QQ：</td>
                        <td><input type="text" name="qq" id="QQ" value=""/> <span id="QQSpan">*</span></td>
                    </tr>
                    <tr>
                        <td align="right">邮箱：</td>
                        <td><input type="email" name="remark2" id="email" value=""/> <span id="emailSpan">*</span></td>
                    </tr>
                    <tr>
                        <td align="right">手机号：</td>
                        <td><input type="text" name="tel" id="phone" value=""/> <span id="phoneSpan">*</span></td>
                    </tr>

                    <tr>
                        <td align="right">
                            院系专业班级：
                        </td>
                        <td>
                            <select id="college" onchange="selectcollege()">
                                <!--第一条不可删-->
                                <option value="0">请选择学院</option>
                                <c:forEach items="${depList }" var="dep">
                                    <option value="${dep.id }">${dep.name }</option>
                                </c:forEach>
                            </select>
                            <select id="major" style="display: none;" onchange="selectmajor()">
                                <option value="0">请选择专业</option>
                                <option value="1">软件工程</option>
                                <option value="2">信息管理</option>
                                <option value="3">城乡规划与管理争执学</option>
                            </select>
                            <select name="graid" id="team" style="display: none;" onchange="selectteam()">
                                <option value="0">请选择班级</option>
                                <option value="1">1班</option>
                                <option value="2">2班</option>
                                <option value="3">3班</option>
                                <option value="4">4班</option>
                                <option value="5">5班</option>
                                <option value="6">6班</option>
                                <option value="7">7班</option>
                                <option value="8">8班</option>
                                <option value="9">9班</option>
                                <option value="10">10班</option>
                            </select>
                            <span id="teamSpan">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="submit" value="注册" class="btn btn-info"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <!-- <input type="reset" value="重新输入" class="btn btn-warning"/> -->
                            <a href="${pageContext.request.contextPath }/hms/goLogin" class="btn btn-info">返回</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
<script>


    var datas = [{
        id: 1,
        name: "计算机与信息工程学院",
        tMajors: [{
            id: 1,
            depid: 1,
            name: "软件工程",
            tGrades: [{
                id: 1,
                magid: 1,
                name: "1班",
                year: 2016,
                tutor: "吴兴梅",
                tutortel: "130130130130",
                tMajor: null
            },
                {
                    id: 7,
                    magid: 1,
                    name: "2班",
                    year: 2017,
                    tutor: "瓦塔",
                    tutortel: "8464",
                    tMajor: null
                },
                {
                    id: 8,
                    magid: 1,
                    name: "3班",
                    year: 2016,
                    tutor: "填挖",
                    tutortel: "4864",
                    tMajor: null
                },
                {
                    id: 9,
                    magid: 1,
                    name: "4班",
                    year: 2016,
                    tutor: "他",
                    tutortel: "846",
                    tMajor: null
                }
            ],
            tDepartment: null
        },
            {
                id: 2,
                depid: 1,
                name: "信息管理与信息系统",
                tGrades: [{
                    id: 2,
                    magid: 2,
                    name: "1班",
                    year: 2016,
                    tutor: "输入法",
                    tutortel: "86",
                    tMajor: null
                },
                    {
                        id: 10,
                        magid: 2,
                        name: "2班",
                        year: 2018,
                        tutor: "啊为",
                        tutortel: "48644",
                        tMajor: null
                    },
                    {
                        id: 11,
                        magid: 2,
                        name: "3班",
                        year: 2017,
                        tutor: "war",
                        tutortel: "4864",
                        tMajor: null
                    },
                    {
                        id: 12,
                        magid: 2,
                        name: "4班",
                        year: 2016,
                        tutor: "啊为绕",
                        tutortel: "846",
                        tMajor: null
                    }
                ],
                tDepartment: null
            },
            {
                id: 3,
                depid: 1,
                name: "信息工程",
                tGrades: [{
                    id: 3,
                    magid: 3,
                    name: "1班",
                    year: 2016,
                    tutor: "阿莎",
                    tutortel: "77486",
                    tMajor: null
                },
                    {
                        id: 13,
                        magid: 3,
                        name: "2班",
                        year: 2018,
                        tutor: "安慰她",
                        tutortel: "4564",
                        tMajor: null
                    }
                ],
                tDepartment: null
            },
            {
                id: 4,
                depid: 1,
                name: "物联网工程",
                tGrades: [{
                    id: 4,
                    magid: 4,
                    name: "1班",
                    year: 2016,
                    tutor: "阿根廷",
                    tutortel: "486",
                    tMajor: null
                },
                    {
                        id: 14,
                        magid: 4,
                        name: "2班",
                        year: 2017,
                        tutor: "瓦塔",
                        tutortel: "456465",
                        tMajor: null
                    }
                ],
                tDepartment: null
            },
            {
                id: 5,
                depid: 1,
                name: "计算机科学与技术",
                tGrades: [{
                    id: 5,
                    magid: 5,
                    name: "1班",
                    year: 2016,
                    tutor: "爱国",
                    tutortel: "4864",
                    tMajor: null
                },
                    {
                        id: 15,
                        magid: 5,
                        name: "2班",
                        year: 2016,
                        tutor: "我",
                        tutortel: "45646",
                        tMajor: null
                    }
                ],
                tDepartment: null
            },
            {
                id: 6,
                depid: 1,
                name: "计算机科学与技术（对口）",
                tGrades: [{
                    id: 6,
                    magid: 6,
                    name: "1班",
                    year: 2016,
                    tutor: "啊我",
                    tutortel: "46548",
                    tMajor: null
                },
                    {
                        id: 16,
                        magid: 6,
                        name: "2班",
                        year: 2016,
                        tutor: "艾瑞网",
                        tutortel: "4531",
                        tMajor: null
                    }
                ],
                tDepartment: null
            }
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
        }
    ]


    $(function () {
        $.ajax({
            type: "post",
            url: "depList",
            dataType: "json",
            /*这句可用可不用，没有影响*/
            contentType: "application/json; charset=utf-8",
            success: function (data) {

                datas = data;


                if (datas != null) {
                    $("#college").children().remove();
                    $("#college").append("<option data-index='-1' value='0'>请选择班级</option>");

                    var len = datas.length
                    for (var i = 0; i < len; i++) {
                        $("#college").append("<option data-index=" + i + " value='" + datas[i].id + "'>" + datas[i].name + "</option>");
                    }
                }

                $("#college").change(function () {
                    var myindex = $("#college option:checked").attr("data-index");
                    if (myindex != -1) {
                        $("#major").children().remove();
                        $("#major").append("<option data-mindex='-1' value='0'>请选择专业</option>");

                        var mymajs = datas[myindex].tMajors;
                        for (var j = 0; j < mymajs.length; j++) {
                            $("#major").append("<option data-mindex='" + j + "'  value='" + mymajs[j].id + "'>" + mymajs[j].name + "</option>");
                        }
                    }
                });
                $("#major").change(function () {
                    var mycindex = $("#college option:checked").attr("data-index");
                    var mymindex = $("#major option:checked").attr("data-mindex");
//				console.log(mycindex);
//				console.log(mymindex);
                    if (mymindex != -1) {
                        $("#team").children().remove();
                        $("#team").append("<option data-tindex='-1' value='0'>请选择专业</option>");

                        var myteams = datas[mycindex].tMajors[mymindex].tGrades;
//					console.log(myteams);
                        for (var k = 0; k < myteams.length; k++) {
                            $("#team").append("<option data-tindex='" + k + "'  value='" + myteams[k].id + "'>" + myteams[k].year + "级" + myteams[k].name + "</option>");
                        }
                    }
                });


            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });


    });

</script>
</html>