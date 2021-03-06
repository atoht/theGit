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
<link rel="stylesheet" type="text/css" href="css/commion.css">
<link rel="stylesheet" type="text/css" href="sou/jquery-ui-1.12.1.custom/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="sou/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css">
<link rel="stylesheet" type="text/css" href="sou/jquery-ui-1.12.1.custom/jquery-ui-timepicker-addon.css">
<script type="text/javascript" src="sou/easyui/jquery.min.js"></script>
<script type="text/javascript" src="sou/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script type="text/javascript" src="sou/jquery-ui-1.12.1.custom/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript">
$(function () {
	$("#checkAll").click(function() {
    if (this.checked) {  
        $("input[id='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                    $(this).prop("checked", true);  
                })  
    } else {   //反之 取消全选   
        $("input[id='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                    $(this).prop("checked", false);  
                })  
    }  
	})
	$("#checkAll0").click(function() {
    if (this.checked) {  
        $("input[id='checkBox']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                    $(this).prop("checked", true);  
                })  
    } else {   //反之 取消全选   
        $("input[id='checkBox']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                    $(this).prop("checked", false);  
                })  
    }  
	})
	$("#formcheckboxBoo").click(function() {
		var v = document.getElementById("formcheckboxBoo").checked;
		document.getElementById("formcheckboxStr").checked = v;
		console.info(v);
	})
})
function keyup (val, index) {
	var regEx = /,/g;
	console.info(document.getElementById("unitprice"+index).innerText);
	var unitprice = (document.getElementById("unitprice"+index).innerText).replace(regEx,'');
// 	var totalAmount = (document.getElementById("totalAmount"+index).innerText).replace(regEx,'');
	document.getElementById("amount"+index).innerText = (val*unitprice).toLocaleString('en-US', {minimumFractionDigits: 3});
	document.getElementById("totalAmount").innerText = (val*unitprice).toLocaleString('en-US', {minimumFractionDigits: 3});
}

$(function() {
    $( "#datepicker" ).datepicker({
      showOn: "both", 
      buttonImage: "sou/jquery-ui-1.12.1.custom/images/9779.jpg_wh120.jpg",
      buttonImageOnly: true,
//       showButtonPanel: true, //显示面板底部按钮
//       closeTextType:"close", //关闭按钮文字
//       currentText: "today",
      dateFormat:"yy/mm/dd (D)",
      showOtherMonths: true,
      selectOtherMonths: true,
    });
    var v = true;
    if(!v){
    	
//     $("#datepicker").datepicker("disable")
    }
		$( "#datepicker" ).datepicker( "option", "showAnim", "drop" );
		 $(".ui_timepicker").datetimepicker({  
             dateFormat: "yy-mm-dd",  
             showSecond: true,  
             timeFormat: 'hh:mm:ss',  
             stepHour: 1,  
             stepMinute: 1,  
             stepSecond: 1  
         })  
  });
</script>
</head>
<body>
<div >
手动阀手动
${list[0].name }
EJB:<label >${hello }</label>
<form action="showCommodity" method="POST">
<input type="text" name="datetime" class="ui_timepicker" value="2015-3-25 13:40:10">  
<table>
<tr>
<th><input type="checkbox" id="checkAll0"></th>
<th>商品名称</th>
</tr>
<c:forEach items="${list }" var="vr">
<tr>
<td><input type="checkbox" id="checkBox" name="checkBox" value="${vr.id }"></td>
<td><input type="text" name="name" value="${vr.name }" ></td>
</tr>
</c:forEach>
</table>
<input type="checkbox" name="formcheckboxStr" id="formcheckboxStr">
<input type="checkbox" name="formcheckboxBoo" id="formcheckboxBoo">
<!-- <html:checkbox /> -->
<!-- <html:text/> -->
<input type="submit" value="提交">
</form>
</div>
<div id="box1">
<form action="enterTheOrder" method="POST">
<table border="1" id="table">
<tr>
<th><input type="checkbox" id="checkAll"></th>
<th>商品名称</th>
<th>商品型号</th>
<th>数量</th>
<th>单价</th>
<th>金额</th>
</tr>
<c:forEach items="${commodityList }" var="vr" varStatus="status">
<tr>
<td ><input type="checkbox" id="selectFlag" name="selectFlag${status.index +1}" value="${vr.id }" ></td>
<td width="20%">${vr.name }</td>
<td width="20%">${vr.model }</td>
<td width="10%"><input type="text" name="quantity${status.index +1}" value="1" id="quantity" onkeyup="keyup(this.value, ${status.index +1})" ></td>
<td id="unitprice${status.index +1}" align="right" width="20%"><fmt:formatNumber type="number" pattern="###,###.###" minFractionDigits="3">${vr.unitprice }</fmt:formatNumber></td>
<td id="amount${status.index +1}" align="right" width="20%"><fmt:formatNumber type="number" pattern="###,###.###" minFractionDigits="3">${vr.amount }</fmt:formatNumber></td>
</tr>
</c:forEach>
</table>
<input type="submit" value="提交"><br>
<div id="box2">
总价：<b id="totalAmount"><fmt:formatNumber type="number" pattern="###,###.###" minFractionDigits="3">0</fmt:formatNumber></b>
<b>日期：<input type="text" id="datepicker" name="datepicker" value="2003/3/4 (Tue)" ></b><br>
</div>
</form>
</div>
</body>
</html>