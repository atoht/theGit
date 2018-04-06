<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>jQuery移除和添加图片</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="sou/jquery.serializeObject.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>


</head>
<body>
<%
int i =1/0;
%>
<input id="aa" type="button" value="aaaaaaaaaaaa" />
<form id='postStatus' action="testStudent" method="post" >
<!--     First Name:<input type="text" name="student.firstName" maxlength="12" size="12"/> <br/> -->
    list Name:<input type="text" name="student.lastName" maxlength="12" size="12"/> <br/>
    First Name:<input type="text" name="student.firstName" maxlength="12" size="12"/> <br/>
    user.Name:<input type="text" name="user.name" maxlength="36" size="12"/> <br/>
    user.firstName:<input type="text" name="user.firstName" maxlength="36" size="12"/> <br/>
    user.listName:<input type="text" name="user.listName" maxlength="36" size="12"/> <br/>
    user.age:<input type="text" name="user.age" maxlength="36" size="12"/> <br/>
    Gender:<br/>
    Male:<input type="radio" name="student.gender" value="1"/><br/>
    Female:<input type="radio" name="student.gender" value="0"/><br/>
    Favorite Food:<br/>
    Steak:<input type="checkbox" name="student.foods" value="Steak"/><br/>
    Pizza:<input type="checkbox" name="student.foods" value="Pizza"/><br/>
    Chicken:<input type="checkbox" name="student.foods" value="Chicken"/><br/>
    <textarea wrap="physical" cols="20" name="student.quote" rows="5">Enter your favorite quote!</textarea><br/>
    Select a Level of Education:<br/>
    <select name="education">
        <option value="Jr.High">Jr.High</option>
        <option value="HighSchool">HighSchool</option>
        <option value="College">College</option>
    </select><br/>
    Select your favorite time of day:<br/>
    <select size="3" name="tOfD">
        <option value="Morning">Morning</option>
        <option value="Day">Day</option>
        <option value="Night">Night</option>
    </select>

</form>
    <p><input type="button" value="formaaa" onclick="check()"/></p>
<!-- <form action="testStudent" method="post" charset=utf-8> -->
<!-- pppp<input type="text" name="p.name" /> -->
<!-- <input type="text" name="student.firstName" /> -->
<!-- <input type="text" name="p.age" /> -->
<!-- <!-- <input type="text" name="weight" /> --> -->
<!-- <!-- <input type="text" name="p.height" /> --> -->
<!-- <input type="submit" value="提交"/> -->
<!-- </form> -->
<script>
	var saveDataAry=[];  
    var data1={ "name": "士大夫", "age":23};  
    var data2={ "name": "Jason", "age":23 };  
    var data3={ "name": "Elliotte", "age":33 };  
    saveDataAry.push(data1);  
    saveDataAry.push(data2); 
    saveDataAry.push(data3); 
$(function () {
$("#aa").click(function () {
    $.ajax({
        type: "POST",
        url: "test000",
		dataType : 'json',
        contentType: "application/json; charset=utf-8",
        data:JSON.stringify(saveDataAry),
        success: function (result) {
            console.log(result);
        }
    });
});
});
function check(){
	$("#postStatus").submit();

	}
// $(function() {
// 	$('#postStatus').ajaxSubmit(function() { 
// 		success : function (result) {
//          console.log(result);
//      }
//     });
// 	$("#postStatus").ajaxForm ( {
		
// 		$.ajax({
//             url : "testStudent",
//             data : $("#postStatus").serializeObject(),
//             contentType : "application/json;charset=utf-8",
//             type : "post",
//             success : function (result) {
//                 console.log(result);
//             }
//         });
// 	});
// })
// 	$.fn.serializeObject = function()
// 	{
// 	   var o = {};
// 	   var a = this.serializeArray();
// 	   $.each(a, function() {
// 	       if (o[this.name]) {
// 	           if (!o[this.name].push) {
// 	               o[this.name] = [o[this.name]];
// 	           }
// 	           o[this.name].push(this.value || '');
// 	       } else {
// 	           o[this.name] = this.value || '';
// 	       }
// 	   });
// 	   return o;
// 	};

// 	var v = $("#postStatus").serializeObject();
// 	console.log(v);
</script>
</body>
</html>