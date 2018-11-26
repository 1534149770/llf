<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	var rowid = null;
	$(function(){
		$("#tableAlbum").treegrid({    
		fitColumns:true,
		pagination:true,
		pageSize:7,
		pageList:[3,4,5,6,7],
		toolbar:"#tbAlbum",
	    url:"${pageContext.request.contextPath}/Album/findAllAlbumByPage.do",    
	    idField:"id",    
	    treeField:"title",    
	    columns:[[    
	        {field:"title",title:"名字",width:60},    
	        {field:"downloadPath",title:"下载路径",width:80},    
	        {field:"size",title:"章节大小",width:80},
	        {field:"duration",title:"时长",width:80}    
	    ]]    
	});  
		
		$("#toolAlbumDetilBtn").linkbutton({
			iconCls:"icon-large-smartart",
			onClick:function(){
				var row = $("#tableAlbum").treegrid("getSelected");
				if(row==null){
					$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选中一行"
					})
				}
				else{
					if(row.size==null){
						$("#AlbumDetilDialog").dialog("open");
						$("#AlbumDetilDialogForm").form("load",row);
						$("#albumCover").prop("src","${pageContext.request.contextPath}/images/"+row.cover)
					}
					else{
						$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选择专辑"
					})
					}
				}
			}
		})
		
		$("#toolAddAlbumBtn").linkbutton({
			iconCls:"icon-add",
			onClick:function(){
				$("#addAlbumDialog").dialog("open")
			}
		})
		
		$("#toolAddChapterBtn").linkbutton({
			iconCls:"icon-add",
			onClick:function(){
				var row = $("#tableAlbum").treegrid("getSelected");
				rowid = row.id;
				console.log(rowid);
				if(row==null){
					$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选择专辑"
					})
				}
				else{
					if(row.size==null){
						$("#addChapterDialog").dialog("open");
					}
					else{
						$.messager.alert({
						title:"小老弟你怎么回事",
						msg:"请选择专辑"
					})
					}
				}
			}
		})
		
		$("#toolDownloadAlbumBtn").linkbutton({
			iconCls:"icon-ok",
			onClick:function(){
				var row = $("#tableAlbum").treegrid("getSelected");
				$("#toolDownloadAlbumBtn").prop("href","${pageContext.request.contextPath}/Chapter/downChapter.do?url="+row.downloadPath+"&oldName="+row.title);
			}
		});

		
		$("#AlbumDetilDialog").dialog({
			title:"专辑详情",
			width:400,
			height:400,
			closed:true,
			resizable:true,
			modal:true
		})
		
		$("#addAlbumDialog").dialog({
			title:"添加专辑",
			width:400,
			height:400,
			resizable:true,
			modal:true,
			closed:true,
			href:"${pageContext.request.contextPath}/addAlbum.jsp"
		})
		
		$("#addChapterDialog").dialog({
			title:"添加章节",
			width:400,
			height:400,
			resizable:true,
			modal:true,
			closed:true,
			href:"${pageContext.request.contextPath}/addChapter.jsp"
		})
	})		
</script>

<table id="tableAlbum">
	
</table>

<div id="tbAlbum">
	<a id="toolAlbumDetilBtn">专辑详情</a>
	<a id="toolAddAlbumBtn">添加专辑</a>
	<a id="toolAddChapterBtn">添加章节</a>
	<a id="toolDownloadAlbumBtn">下载音频</a>
</div>

<div id="addAlbumDialog"></div>

<div id="addChapterDialog"></div>

<div id="AlbumDetilDialog">
	<form id="AlbumDetilDialogForm" method="post">
		<div>
			<label for="title">名字：</label>
			<input class="easyui-validatebox" id="albumTitle" type="text" name="title"/>
		</div>
		<div>
			<label for="count">音频数量：</label>
			<input class="easyui-validatebox" id="albumCount" type="text" name="count"/>
		</div>
		<div>
			<label for="cover">专辑封面：</label>
			<img id="albumCover" width="400px" src=""/>
		</div> 
	</form>
	
</div>
