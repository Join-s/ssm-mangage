<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <title>jiehuan</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/css/foot.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/css/index.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath }/hms/resource/js/autoifrheight.js">
    </script>
    </head>
    <body>
    <form action="${pageContext.request.contextPath }/hms/or/insertReaback" method="post" enctype="multipart/form-data" role="form">
        <input type="hidden" value="${sessionScope.userID }" name="uid"/>
        <div class="form-group">
        元件名：
    <select name="cid">
        <c:forEach items="${clist }" var="cli">
        <option value="${cli.id }"> ${cli.name }
        </option>
        </c:forEach>
        </select>
        </div>
        <br/>
        <div class="form-group">
        日期：
    <input type="date" name="backtime"/>
        </div>
        <br/>
        <div class="form-group">
        <input type="submit" value="借入"/>
        </div>
        </form>
        <br/>
        <br/>
        <br/> 状态显示：
    <table cellpadding="0" cellspacing="0" border="1" class="table table-bordered">
        <tr>
        <td> 元件名
        </td>
        <td> 借出日
        </td>
        <td> 归还日
        </td>
        <td> 审核状态
        </td>
        </tr>
        <c:forEach items="${rblist }" var="li">
        <tr class="${li.state==1?" alert-success ":"alert-warning " }">
        <td> ${li.cname}
        </td>
        <td>
        <fmt:formatDate value="${li.createtime}" pattern="yyyy-MM-dd"/>
        </td>
        <td>
        <fmt:formatDate value="${li.backtime}" pattern="yyyy-MM-dd"/>
        </td>
        <td> ${li.state==0?"未审核":"审核通过" }
        </td>
        </tr>
        </c:forEach>
        </table>
        </body>
        </html>