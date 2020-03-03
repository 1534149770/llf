<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#tableCarousel").edatagrid({
			title:"轮播图管理",
			singleSelect:false,
			nowrap:true,
			pagination:true,
			fitColumns:true,
			pageSize:4,
			pageList:[3,4,5,6,7],
			toolbar:"#tbCarousel",
			updateUrl:"${pageContext.request.contextPath}/Carousel/modifyCarousel.do",
			destroyUrl:"${pageContext.request.contextPath}/Carousel/removeCarousel.do",
			url:"${pageContext.request.contextPath}/Carousel/findCarouselByPage.do",
			view: detailview,
			detailFormatter: function(rowIndex, rowData){ 
			return  "<table><tr>"+
						"<td rowspan=2 style='border:0'><img width='300px' src=${pageContext.request.contextPath}/images/"+rowData.imgPath+"></td>" + 
						"<td style='border:0'>" + 
						"<p>date: " + rowData.createTime + "</p>" + 
						"<p>descript: " + rowData.descript + "</p>" + 
						"<p>path: " + rowData.imgPath + "</p>" + 
						"</td>" + 
					"</tr></table>";
			} 		
		})	
		
		$("#toolAddCarouselBtn").linkbutton({
			iconCls:"icon-add",
			onClick:function(){
				$("#addCarouselDialog").dialog("open")
			}
		})
		
		$("#toolUpdateCarouselBtn").linkbutton({
			iconCls:"icon-edit",
			onClick:function(){
				var row = $("#tableCarousel").edatagrid("getSelected");
				if(row==null){
					$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选中一行"
					})
				}else{
					$("#tableCarousel").edatagrid("editRow",$("#tableCarousel").edatagrid("getRowIndex",row))
				}
			}
		})
		
		$("#toolDeleteCarouselBtn").linkbutton({
			iconCls:"icon-remove",
			onClick:function(){
				var row = $("#tableCarousel").edatagrid("getSelected");
				if(row==null){
					$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选中一行"
					})
				}else{
					$("#tableCarousel").edatagrid("destroyRow")
				}
			}
		})
		
		$("#toolSaveCarouselBtn").linkbutton({
			iconCls:"icon-save",
			onClick:function(){
				$("#tableCarousel").edatagrid("saveRow")
			}
		})
		
		$("#addCarouselDialog").dialog({
			title:"添加图片",
			width:400,
			height:400,
			closed:true,
			href:"${pageContext.request.contextPath}/addCarousel.jsp"
		});
	})		
</script>

<table id="tableCarousel">
	<thead>
		<tr>
			<th data-options="field:'id',width:1">ID</th>
			<th data-options="field:'title',width:1">标题</th>
			<th data-options="field:'descript',width:1">描述</th>
			<th data-options="field:'imgPath',width:1">图片路径</th>
			<th data-options="field:'status',width:1" editor="{type:'text',options:{precision:0}}">展示状态</th>
			<th data-options="field:'createTime',width:1">添加时间</th>
		</tr>
	</thead>
</table>

<div id="tbCarousel">
	<a id="toolAddCarouselBtn">添加图片</a>
	<a id="toolUpdateCarouselBtn">修改图片</a>
	<a id="toolDeleteCarouselBtn">删除图片</a>
	<a id="toolSaveCarouselBtn">保存</a>
</div>

<div id="addCarouselDialog"></div>
