<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<input id="id1" name="sname" value="${sname}" type="text"> X <input id="id2" type="text"> = <label id="label" ></label> <br>
<input type="button" value="提交" onclick="sum();">
</div>
<div>
<table>
<tr>
<td id="td">4.3</td>
</tr>
</table>
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
		id2 = id2.replace(regEx,'');
			console.info(id2);
	console.info(str*2);
// 	console.info(parseFloat(str));
	var num = 6.5;
	var num1 = 3.5;
//     id1 = String(id1);
//     console.info(id1);
	$("#label").html(id1*id2);
// 	vad sum
}
</script>
</body>
</html>