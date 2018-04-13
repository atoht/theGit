<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="sou/easyui/jquery.min.js"></script>
<script type="text/javascript">
window.onload = function()
{
$.ajax({
	type : "post",
	url : "firstIndex",
	dataType:"json",
	async : false,
	success:function(result) {
		$("#userID").val(result["SAVE_USERID"]);
		$("#password").val(result.SAVE_PASSWORD);
		var v = result.SAVE_PASSWORD;
		console.info(v);
	}
})
}
</script>
</head>
<body>
	
	<form action="login" method="POST">
	  <input type="text" id="userID" name="userID" > <br>
	  <input type="text" id="password" name="password" > <br>
	  <input type="submit" value="登陆">
	</form>
</body>
</html>