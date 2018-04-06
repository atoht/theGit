<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Made with Thimble</title>
<link rel="stylesheet" type="text/css" href="sou/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="sou/easyui/themes/icon.css">

<script type="text/javascript" src="sou/easyui/jquery.min.js"></script>
<script type="text/javascript" src="sou/easyui/easyloader.js"></script>
</head>
<body>
	<h2>CheckBox Treeä¸­</h2>
	<p>Tree nodes with check boxes.</p>
<a href="NewFile.html">gå¨</a>
	<div style="margin: 20px 0;">
		<a href="#" class="easyui-linkbutton" onclick="getChecked()">GetChecked</a>
	</div>
	<div>
		<input class="easyui-linkbutton easyui-tooltip" value="Add" onclick="$('#dlg').dialog('open')" data-options="
icons:[{
				iconCls:'icon-search'}]">
		<a href="#" class="easyui-linkbutton easyui-tooltip" title="Add" data-options="iconCls:'icon-add'"></a>
	</div>
	
	
	<p>Click below button to open or close dialog.</p>
	
	<div id="dlg" style="width:300px;height:350px;padding:10px" >
	<p>title</p>
		<div id="b" style="padding: 5px">
		<ul id="tt" class="easyui-tree"
			data-options="url:'sou/easyui/demo/tree/tree_data1.json',checkbox:true"></ul>
	</div>
	</div>
	<c:forEach items="${User }" var="vr">
	${vr.value }
	</c:forEach>
<a href="WEB-INF/views/NewFile.jsp">点击</a>	
	<body>
  <table border=1 id="tab">
  <tr><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th></tr>
  <tr><td id="cc1">1997</td><td>Ford</td><td>E350</td><td>"ac</td><td> abs</td><td> moon"</td><td>3000.00</td></tr>
  <tr><td id="cc2">1997</td><td>Ford</td><td>E350</td><td>"ac</td><td> abs</td><td> moon"</td><td>3000.00</td></tr>
  </table>
	<script type="text/javascript">
	  $(function() {
		  easyloader.load(['dialog','tree'], function() {
		  $('#dlg').dialog( {
				  modal : true,
				  closable:false,
				  border:false,
				  noheader:true,
				  closed: true,
				  buttons : [{
					  text : 'OK',
					  handler : function(){
						  var s = getChecked();
						  var ss = s.split(',');
						  if(s != '') {
							  for(var i=0; i<ss.length; i++) {
								  var td = '';
								  td += "<tr><td>1997</td><td>Ford</td><td>E350</td>";
								  td +="<td onClick='getDel(this)' ><input type='button' value='check' ></td>"; 
								  td +="</tr>"
								  $('#tab').append(td);
							      var text = $("#tab tr:last").find("td:nth-child(1)").text(ss[i]); 
								  }
						  }
						  	var root=$("#tt").tree('getRoot');  
						  	console.info(root.target);
					        $("#tt").tree('uncheck',root.target); 
						    $('#dlg').dialog('close');
					  }
				  },{
					  text : 'claer',
					  handler : function(){
						  var root=$("#tt").tree('getRoot'); 
					      $("#tt").tree('uncheck',root.target); 
						  $('#dlg').dialog('close');
					  }
				  }]
		  });
		  
	  $('#tt').tree({ onSelect: function(node){
			  
			  if($("#tt").tree('getSelected').state=='open'){
	                $(this).tree('collapse',node.target);  
	            }else{
	                $(this).tree('expand',node.target);  
	            }
			  var isLeaf = $("#tt").tree('isLeaf', node.target);  
		        if (isLeaf) {  
					if (node.checked) {
						$('#tt').tree('uncheck', node.target);
			 
					} else {
						$('#tt').tree('check', node.target);
			 
					}
		        }
		  }
	  });
		  
	  }); 
		  });
      function getChecked(){        
        var nodes = $('#tt').tree('getChecked');
        var s = '';
        for(var i=0; i<nodes.length; i++){
          if (s != '') s += ',';
          s += nodes[i].text;
        }
        return s;
      }
      function getDel(obj)
      { 
        $(obj).parent().remove(); 
      } 
      
    </script>
</body>
</html>
