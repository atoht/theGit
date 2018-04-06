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
<title>Insert title here</title>
</head>
<body>
Welcome back
<div>
<input type="button" value="打开PDF" onclick="showPDF()">
</div>
<form action="loginOut" method="POST">
<input type="submit" value="退出登录" >
</form>

<script type="text/javascript">
function showPDF() {
	console.info('<%=path%>');
	console.info('<%=basePath%>');
	window.open('<%=basePath%>/PDF/NEXT.pdf', 'myPDF', 'fullscreen=yes');
}
</script>
</body>
</html>