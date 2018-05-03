<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="box1">
<form action="downloadExcel" method="POST">
<table border="1" id="table">
<tr>
<!-- <th><input type="checkbox" id="checkAll"></th> -->
<th>商品名称</th>
<th>商品型号</th>
<th>数量</th>
<th>单价</th>
<th>金额</th>
</tr>
<c:forEach items="${commodityList }" var="vr" varStatus="status">
<c:set var="count" scope="session" value="${status.index}"/>
<c:if test="${formDto.selectFlag[count] }">
<tr>
<td width="20%">${vr.name }</td>
<td width="20%">${vr.model }</td>
<td width="10%">${formDto.quantity[count] }</td>
<td id="unitprice${status.index +1}" align="right" width="20%"><fmt:formatNumber type="number" pattern="###,###.###" minFractionDigits="3">${vr.unitprice }</fmt:formatNumber></td>
<td id="amount${status.index +1}" align="right" width="20%"><fmt:formatNumber type="number" pattern="###,###.###" minFractionDigits="3">${vr.amount }</fmt:formatNumber></td>
</tr>
</c:if>
</c:forEach>
</table>
<div id="box2">
总价：<b id="totalAmount"><fmt:formatNumber type="number" pattern="###,###.###" minFractionDigits="3">${orders.totalamount}</fmt:formatNumber></b><br>
</div>
<input type="submit" value="提交">
</form>
</div>
</body>
</html>