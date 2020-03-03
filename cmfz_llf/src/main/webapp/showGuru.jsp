<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#tableGuru").edatagrid({
			title:"上师管理",
			singleSelect:false,
			nowrap:true,
			pagination:true,
			fitColumns:true,
			pageSize:4,
			pageList:[3,4,5,6,7],
			toolbar:"#tbGuru",
			updateUrl:"${pageContext.request.contextPath}/Guru/modifyGuru.do",
			destroyUrl:"${pageContext.request.contextPath}/Guru/removeGuru.do",
			url:"${pageContext.request.contextPath}/Guru/findGuruByPage.do",
			view: detailview,
			detailFormatter: function(rowIndex, rowData){ 
			return  "<table><tr>"+
						"<td rowspan=2 style='border:0'><img width='300px' src=${pageContext.request.contextPath}/images/"+rowData.profile+"></td>" + 
						"<td style='border:0'>" + 
						"<p>name: " + rowData.name + "</p>" + 
						"<p>brief: " + rowData.brief + "</p>" + 
						"<p>profile: " + rowData.profile + "</p>" + 
						"</td>" + 
					"</tr></table>";
			} 		
		})	
		
		$("#toolAddGuruBtn").linkbutton({
			iconCls:"icon-add",
			onClick:function(){
				$("#addGuruDialog").dialog("open")
			}
		})
		
		$("#toolUpdateGuruBtn").linkbutton({
			iconCls:"icon-edit",
			onClick:function(){
				var row = $("#tableGuru").edatagrid("getSelected");
				if(row==null){
					$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选中一行"
					})
				}else{
					$("#tableGuru").edatagrid("editRow",$("#tableGuru").edatagrid("getRowIndex",row))
				}
			}
		})
		
		$("#toolDeleteGuruBtn").linkbutton({
			iconCls:"icon-remove",
			onClick:function(){
				var row = $("#tableGuru").edatagrid("getSelected");
				if(row==null){
					$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选中一行"
					})
				}else{
					$("#tableGuru").edatagrid("destroyRow")
				}
			}
		})
		
		$("#toolSaveGuruBtn").linkbutton({
			iconCls:"icon-save",
			onClick:function(){
				$("#tableGuru").edatagrid("saveRow")
			}
		})
		
		$("#addGuruDialog").dialog({
			title:"添加图片",
			width:400,
			height:400,
			closed:true,
			href:"${pageContext.request.contextPath}/addGuru.jsp"
		});
	})		
</script>

<table id="tableGuru">
	<thead>
		<tr>
			<th data-options="field:'id',width:1">ID</th>
			<th data-options="field:'name',width:1">名字</th>
			<th data-options="field:'profile',width:1">头像路径</th>
			<th data-options="field:'brief',width:1">简介</th>
			<th data-options="field:'status',width:1" editor="{type:'text',options:{precision:0}}">展示状态</th>
		</tr>
	</thead>
</table>

<div id="tbGuru">
	<a id="toolAddGuruBtn">添加</a>
	<a id="toolUpdateGuruBtn">修改</a>
	<a id="toolDeleteGuruBtn">删除</a>
	<a id="toolSaveGuruBtn">保存</a>
</div>

<div id="addGuruDialog"></div>
