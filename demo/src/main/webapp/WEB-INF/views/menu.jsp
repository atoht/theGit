<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <%  
String path = request.getContextPath();  
String basePath = request.getScheme() + "://"  
    + request.getServerName() + ":" + request.getServerPort()+path;  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="save" content="history">  
<style type="text/css">  
    input{behavior:url(#default#savehistory)};  
 </style>  
<title>Insert title here</title>
<script type="text/javascript" src="sou/easyui/jquery.min.js"></script>
</head>
<body>
Welcome back 
<div>
<input type="button" value="打开PDF" onclick="showPDF()">
</div>
<form action="loginOut" method="POST">
<input type="submit" value="退出登录" >
</form>
<div>
<h3>English, USA</h3> 
<fmt:setLocale value="en_US" /> 
<table border="1">
<tr><th>第一位数</th>
<th></th>
<th>第二位数</th>
<th></th>
<th>结果</th></tr>
<tr><td><input id="id1" name="sname" value="${sname}" type="text"></td>
<td> X </td>
<td><input id="id2" name="sname" value="${sname}" type="text"></td>
<td> = </td>
<td id="td" ><fmt:formatNumber type="number" pattern="###,###.###" minFractionDigits="3">95616546569.62</fmt:formatNumber></td></tr>
</table>
<input type="button" value="提交" onclick="sum();">
</div>
<div>
<table>
<tr>
<td id="td">4.3</td>
</tr>
</table>
<fmt:formatNumber type="currency" value="80000.5" /><br/>
</div>
<script type="text/javascript">
function showPDF() {
	console.info('<%=path%>');
	console.info('<%=basePath%>');
	window.open('<%=basePath%>/PDF/NEXT.pdf', 'myPDF', 'fullscreen=yes');
}

function sum() {
	var id1 = $("#id1").val();
	var id2 = $("#id2").val();
	var str = "8.5";
	console.info((document.getElementById("td").innerText)*2);
	var regEx = /,/g;
		id1 = id1.replace(regEx,'');
		id2 = id2.replace(regEx,'');
			console.info(id2);
	console.info(str*2);
// 	console.info(parseFloat(str));
	var num = 6.5;
	var num1 = 3.5;
//     id1 = String(id1);
//     console.info(id1);
	$("#td").html((id1*id2).toLocaleString('en-US', {minimumFractionDigits: 3}));
// 	vad sum
}
</script>
</body>
</html>