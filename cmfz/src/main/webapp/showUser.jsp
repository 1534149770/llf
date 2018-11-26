<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#tableUser").edatagrid({
			title:"用户管理",
			singleSelect:false,
			nowrap:true,
			pagination:true,
			fitColumns:true,
			pageSize:4,
			pageList:[3,4,5,6,7],
			toolbar:"#tbUser",
			/*updateUrl:"",
			destroyUrl:"",*/
			url:"${pageContext.request.contextPath}/User/findAllUser.do",
			view: detailview,
			detailFormatter: function(rowIndex, rowData){ 
			return  "<table><tr>"+
						"<td rowspan=2 style='border:0'><img width='300px' src=${pageContext.request.contextPath}/images/"+rowData.profile+"></td>" + 
						"<td style='border:0'>" + 
						"<p>username: " + rowData.username + "</p>" +
						"<p>dharmaName: " + rowData.dharmaName + "</p>" +
						"<p>sex: " + rowData.sex + "</p>" +
						"</td>" + 
					"</tr></table>";
			} 		
		})	
		
		$("#toolAddUserBtn").linkbutton({
			iconCls:"icon-add",
			onClick:function(){
				$("#addUserDialog").dialog("open")
			}
		})
		
		$("#toolUpdateUserBtn").linkbutton({
			iconCls:"icon-edit",
			onClick:function(){
				var row = $("#tableUser").edatagrid("getSelected");
				if(row==null){
					$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选中一行"
					})
				}else{
					$("#tableUser").edatagrid("editRow",$("#tableUser").edatagrid("getRowIndex",row))
				}
			}
		})
		
		$("#toolDeleteUserBtn").linkbutton({
			iconCls:"icon-remove",
			onClick:function(){
				var row = $("#tableUser").edatagrid("getSelected");
				if(row==null){
					$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选中一行"
					})
				}else{
					$("#tableUser").edatagrid("destroyRow")
				}
			}
		})
		
		$("#toolSaveUserBtn").linkbutton({
			iconCls:"icon-save",
			onClick:function(){
				$("#tableUser").edatagrid("saveRow")
			}
		})
		
		$("#addUserDialog").dialog({
			title:"添加图片",
			width:400,
			height:400,
			closed:true,
			href:"${pageContext.request.contextPath}/addUser.jsp"
		});
	})		
</script>

<table id="tableUser">
	<thead>
		<tr>
			<th data-options="field:'id',width:1">ID</th>
			<th data-options="field:'username',width:1">用户名</th>
			<th data-options="field:'dharmaName',width:1">法名</th>
			<th data-options="field:'sex',width:1">性别</th>
			<th data-options="field:'status',width:1" editor="{type:'text',options:{precision:0}}">展示状态</th>
		</tr>
	</thead>
</table>

<div id="tbUser">
	<a id="toolAddUserBtn">添加</a>
	<a id="toolUpdateUserBtn">修改</a>
	<a id="toolDeleteUserBtn">删除</a>
	<a id="toolSaveUserBtn">保存</a>
</div>

<div id="addUserDialog"></div>
