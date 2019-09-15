<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
   <meta charset="utf-8"/>
   <title>首页</title>
   <meta name="viewport" content="width=device-width,initial-scale=1">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/css/foot.css"/>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/css/index.css"/>
   <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/css/bootstrap.css">
   <script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/js/jquery-2.1.1.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/js/autoifrheight.js"></script>
   </head>

   <body>
   <!--导航栏 start-->
   <nav class="navbar navbar-default navbar-fixed-top">
       <div class="container">
       <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
   <span class ="icon-bar"></span>
       </button>
       <a class="navbar-brand" href="#"> 硬件管理系统v2.0</a>
   </div>
   <div id="navbar" class="navbar-collapse collapse nav-tabs">
       <ul class="nav navbar-nav ">
       <li class="">
       <a href="${pageContext.request.contextPath }/hms/goC" target="mainifram"> 首页</a>
       </li>
       <li>
       <a href="${pageContext.request.contextPath }/hms/user/shoppingcat" target="mainifram"> 购物车</a>
       </li>
       <li>
       <a href="${pageContext.request.contextPath }/hms/user/myOrderList" target="mainifram"> 个人中心</a>
       </li>
       <li class="dropdown">
       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 关于<span class="caret"></span></a>
   <ul class="dropdown-menu">
       <li>
       <!--target="mainifram"-->
       <a href="${pageContext.request.contextPath }/hms/uploadOrder" target="_new"> 下载</a>
       </li>

       <li>
       <a href="${pageContext.request.contextPath }/hms/jiehuan?uid=${userID }" target="mainifram"> 借元件</a>
       </li>
       <li>
       <a href="${pageContext.request.contextPath }/hms/help" target="mainifram"> 帮助</a>
       </li>
       <li role="separator" class="divider"></li>
       <li class="dropdown-header"> system</li>
       <li>
       <a href="systemdebugging.html" target="mainifram"> system debugging</a>
   </li>
   <li>
   <a href="systemstate.html" target="mainifram"> system state</a>
   </li>
   </ul>
   </li>
   </ul>
   <ul class="nav navbar-nav navbar-right ">
      <c:choose>
         <c:when test='${sessionScope.user!=null && sessionScope.user.remark1=="0"}'>
            <li>
               <a href="${pageContext.request.contextPath }/hms/goOut" onclick="return confirm('确定退出？')"  data-toggle="tooltip" data-placement="bottom" data-original-title="点击退出登陆">
                  <img class="img-circle" src="${pageContext.request.contextPath }/hms/resource/img/${sessionScope.user.photo==null?'bg.jpg':sessionScope.user.photo }" height="20px" width="20px"/>
                  <span> ${sessionScope.user.name}</span>
               </a>
            </li>
         </c:when>
         <c:otherwise>
            <li>
               <a href="${pageContext.request.contextPath }/hms/goLogin" target="_self"> 登陆</a>
            </li>
         </c:otherwise>
      </c:choose>

       <%--<c:if test="${!sessionScope.flag || sessionScope.flag==null}">--%>
       <%--<li>--%>
       <%--<a href="${pageContext.request.contextPath }/hms/goLogin" target="_self"> 登陆</a>--%>
       <%--</li>--%>
       <%--</c:if>--%>
       <%--<c:if test="${sessionScope.flag }">--%>
          <%--<li>--%>
          <%--<a href="${pageContext.request.contextPath }/hms/goOut" onclick="return confirm('确定退出？')">--%>
             <%--<img class="img-circle" src="${pageContext.request.contextPath }/hms/resource/img/${sessionScope.user.photo==null?'bg.jpg':sessionScope.user.photo }" height="20px" width="20px"/>--%>
             <%--<span> ${sessionScope.user.name}</span>--%>
          <%--</a>--%>
          <%--</li>--%>
       <%--</c:if>--%>

       </ul>
       </div>
       </div>
       </nav>
       <!--导航栏 end-->
       <div class="container-fluid">
       <!--公告内容 start-->
       <div class="jumbotron col-lg-offset-2 col-lg-8">
       <c:if test="${notList!=null}">
       <c:forEach items="${notList}" var="nli">
       <!--公告标题-->
       <h1> ${nli.title }</h1>
       <!--公告内容-->
       <a href="${nli.link }"> ${nli.text }</a>
   </c:forEach>
   </c:if>
   <c:if test="${notList==null}">
    暂无公告
   </c:if>
   </div>
   <!--公告内容 start-->
   <div class="tab-content">
       <!--shouye start-->
       <div class="tab-pane active" id="shouye">
       <!--主体 start-->
       <div class="row">
       <div class="col-lg-12">
       <iframe id="mainifram" name="mainifram" src='${pageContext.request.contextPath }/hms/comp/queryBySid' frameborder="0" scrolling="auto">
       </iframe>
       </div>
       </div>
       </div>
       </div>
       <!--主体 end-->
       <!--页面底部 start-->
       <div class="row" id="foot">
       <div class="col-lg-12" style="background-color: #269ABC;">
       <div class="col-lg-6 col-lg-offset-3">
       <!--友情链接-->
       <ul>
       <li>
       <a href="#"> 学生教务系统</a>
       </li>
       <li>
       <a href="#"> 一卡通</a>
       </li>
       <li>
       <a href="#"> 当当网商城</a>
       </li>
       <li>
       <a href="#"> 四六级查询</a>
       </li>
       </ul>
       <div class="clear"></div>
       </div>
       <div class="col-lg-4 col-lg-offset-4">
       <p> &copy; 阜阳师范学院硬件实验室版权所有</p>
   </div>
   </div>
   </div>
   <!--页面底部 end-->
   </div>
   </div>
   </body>

<script >
    $(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });

</script>

   </html>