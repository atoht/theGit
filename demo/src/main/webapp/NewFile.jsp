<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>jQuery移除和添加图片</title>
<link rel="stylesheet" type="text/css" href="sou/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="sou/easyui/themes/icon.css">
<script type="text/javascript" src="sou/easyui/jquery.min.js"></script>
<script type="text/javascript" src="sou/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
.changeImage {
	background: url(img/chrome_big.jpg) no-repeat center;
	background-size: 40px 40px;
}
</style>
<script>
	$("#tab tr:last").each(function() {
		var td = $("<tr><td>1997</td><td>Ford</td><td>E350</td></tr>");
		$('#tab').append(td);
	});
	var text = $("#tab tr").find("td:nth-child(1)").text(ss);
	function removeimg() {
		$("#tab tr").find("td").removeClass("changeImage");
	}
	function addimg() {
		$("#select").find("option").text("ddddd");
		$("div").find("p").addClass("changeImage");
	}
</script>
</head>
<body>
<div id="b" style="padding: 5px">
		<ul id="tt" class="easyui-tree tree"
			data-options="url:'sou/easyui/demo/tree/tree_data1.json',checkbox:true">
			<li><div id="_easyui_tree_14" class="tree-node">
					<span class="tree-hit tree-expanded"></span><span
						class="tree-checkbox tree-checkbox0"></span><span
						class="tree-title">a</span>
				</div>
				<ul style="display: block">
					<li><div id="_easyui_tree_15" class="tree-node">
							<span class="tree-indent"></span><span
								class="tree-hit tree-collapsed"></span>
								<span
								class="tree-title">Photos</span><span
								class="tree-icon tree-folder icon-add"></span><span
								class="tree-icon tree-folder icon-add"></span><span
								class="tree-checkbox tree-checkbox0"></span><span
								class="tree-title">Photos</span>
						</div>
						<ul style="display: none">
							<li><div id="_easyui_tree_16" class="tree-node">
									<span class="tree-indent"></span><span class="tree-indent"></span><span
										class="tree-indent"></span><span
										class="tree-checkbox tree-checkbox0"></span><span
										class="tree-title">Friend</span>
								</div></li>
							<li><div id="_easyui_tree_17" class="tree-node">
									<span class="tree-indent"></span><span class="tree-indent"></span><span
										class="tree-indent"></span><span class="tree-icon tree-file "></span><span
										class="tree-checkbox tree-checkbox0"></span><span
										class="tree-title">Wife</span>
								</div></li>
							<li><div id="_easyui_tree_18" class="tree-node">
									<span class="tree-indent"></span><span class="tree-indent"></span><span
										class="tree-indent"></span><span class="tree-icon tree-file "></span><span
										class="tree-checkbox tree-checkbox0"></span><span
										class="tree-title">Company</span>
								</div></li>
						</ul></li>
					<li><div id="_easyui_tree_19" class="tree-node">
							<span class="tree-indent"></span><span
								class="tree-hit tree-collapsed"></span><span
								class="tree-icon tree-folder "></span><span
								class="tree-checkbox tree-checkbox0"></span><span
								class="tree-title">Program Files</span>
						</div>
						<ul style="display: none">
							<li><div id="_easyui_tree_20" class="tree-node">
									<span class="tree-indent"></span><span class="tree-indent"></span><span
										class="tree-indent"></span><span class="tree-icon tree-file "></span><span
										class="tree-checkbox tree-checkbox0"></span><span
										class="tree-title">Intel</span>
								</div></li>
							<li><div id="_easyui_tree_21" class="tree-node">
									<span class="tree-indent"></span><span class="tree-indent"></span><span
										class="tree-indent"></span><span class="tree-icon tree-file "></span><span
										class="tree-checkbox tree-checkbox0"></span><span
										class="tree-title">Java</span>
								</div></li>
							<li><div id="_easyui_tree_22" class="tree-node">
									<span class="tree-indent"></span><span class="tree-indent"></span><span
										class="tree-indent"></span><span class="tree-icon tree-file "></span><span
										class="tree-checkbox tree-checkbox0"></span><span
										class="tree-title">Microsoft Office</span>
								</div></li>
							<li><div id="_easyui_tree_23" class="tree-node">
									<span class="tree-indent"></span><span class="tree-indent"></span><span
										class="tree-indent"></span><span class="tree-icon tree-file "></span><span
										class="tree-checkbox tree-checkbox0"></span><span
										class="tree-title">Games</span>
								</div></li>
						</ul></li>
					<li><div id="_easyui_tree_24" class="tree-node">
							<span class="tree-indent"></span><span class="tree-indent"></span><span
								class="tree-icon tree-file "></span><span
								class="tree-checkbox tree-checkbox0"></span><span
								class="tree-title">index.html</span>
						</div></li>
					<li><div id="_easyui_tree_25" class="tree-node">
							<span class="tree-indent"></span><span class="tree-indent"></span><span
								class="tree-icon tree-file "></span><span
								class="tree-checkbox tree-checkbox0"></span><span
								class="tree-title">about.html</span>
						</div></li>
					<li><div id="_easyui_tree_26" class="tree-node">
							<span class="tree-indent"></span><span class="tree-indent"></span><span
								class="tree-icon tree-file "></span><span
								class="tree-checkbox tree-checkbox0"></span><span
								class="tree-title">welcome.html</span>
						</div></li>
				</ul></li>
		</ul>
	</div>
	<table border=1 id="tab">
		<tr>
			<td>年</td>
			<td>制造商</td>
			<td>型号</td>
			<td>说明</td>
			<td>价值</td>
		</tr>
		<tr>
			<td>1997</td>
			<td>Ford</td>
			<td>E350</td>
			<td>"ac</td>
			<td>abs</td>
			<td>moon"</td>
			<td>3000.00</td>
		</tr>
		<tr>
			<td>1999</td>
			<td>Chevy</td>
			<td>"Venture ""Extended Edition"""</td>
			<td>""</td>
			<td>4900.00</td>
		</tr>
		<tr>
			<td>1999</td>
			<td>Chevy</td>
			<td>"Venture ""Extended Edition</td>
			<td>Very Large"""</td>
			<td>""</td>
			<td>5000.00</td>
		</tr>
		<tr>
			<td>1996</td>
			<td>Jeep</td>
			<td>Grand Cherokee</td>
			<td>"MUST SELL!</td>
		</tr>
		<tr>
			<td>air</td>
			<td>moon roof</td>
			<td>loaded"</td>
			<td>4799.00</td>
		</tr>
	</table>
	<input type="button" value="添加样式" onclick="addimg()" />
	<input type="button" value="删除样式" onclick="removeimg()" />
	<div id="select">
		<select>
			<option value="img/chrome_big.jpg" selected>aa</option>
			<option>b</option>
		</select>
	</div>
	<div>
		<p align="center">This is some
			text&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;short
			paragraph</p>
	</div>
</body>
</html>