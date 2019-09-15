<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    response.setContentType("application/vnd.ms-excel");

    String M = session.getAttribute("user").toString();
    response.addHeader("Content-Disposition", "attachment;filename=" + new String(("订单表" + M).getBytes("gb2312"), "iso8859-1") + ".xls");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>title</title>
    </head>
    <body>
        <table border="1" cellspacing="0px" cellpadding="0px">
            <tr>
                <th>订单编号</th>
                <th>元件名称</th>
                <th>数量</th>
                <th>型号</th>
                <th>规格</th>
                <th>品牌</th>
                <th>介绍</th>
                <th>单价</th>
                <th>位置</th>
                <th>库存</th>
                <th>下单人</th>
                <th>下单状态</th>
                <th>下单日期</th>
            </tr>
            <c:forEach items="${ulist.tOrderdetails }" var="li">
                <tr>
                    <td>${ulist.id}</td>
                    <td>${li.tComponent.name}</td>
                    <td>${li.number}</td>
                    <td>${li.tComponent.version}</td>
                    <td>${li.tComponent.specification}</td>
                    <td>${li.tComponent.brand}</td>
                    <td>${li.tComponent.introduce}</td>
                    <td>${li.tComponent.price}</td>
                    <td>${li.tComponent.place}</td>
                    <td>${li.tComponent.store}</td>
                    <td>${user.name}</td>
                    <td>${ulist.status}</td>
                    <td><fmt:formatDate value="${ulist.createtime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>