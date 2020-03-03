<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#addAlbumFormTitle").textbox({
			required:true,
			prompt:"名字不少于两位",
			validType:"mLength[2]"
		});
		
		$("#addAlbumFormCount").textbox({
			required:true
		});
		
		$("#addAlbumFormAutor").textbox({
			required:true
		});
		
		$("#addAlbumFormBroadCast").textbox({
			required:true
		});
		
		$("#addAlbumFormBrief").textbox({
			required:true
		});
		
		$("#addAlbumFormScore").textbox({
			required:true
		});
		
		$("#addAlbumFormSaveBtn").linkbutton({
			onClick:function(){
				$("#addAlbumForm").form("submit",{
					url:"${pageContext.request.contextPath}/Album/addAlbum.do",
					onSubmit:function(){
						return $("#addAlbumForm").form("validate")					
					},
					success:function(){
						$("#addAlbumDialog").dialog("close");
						$.messager.show({
							title:"添加成功",
							msg:"小老弟你怎么回事"
						});
						$("#tableAlbum").datagrid("load")
					}
				})
			}
		});
		$("#addAlbumFormResetBtn").linkbutton({
			onClick:function(){
				$("#addAlbumForm").form("reset")
			}
		});
		
		$.extend($.fn.validatebox.defaults.rules, {    
		   	mLength:{
		   		validator:function(value,params){
		   			return value.length >= params[0];
		   		},
		   		message:"最小长度为{0}"
		   	},
		   	eLength:{
		   		validator:function(value,params){
		   			return value.length = params[0];
		   		},
		   		message:"长度需为{0}"
		   	}
		});  	
	})
</script>

<form id="addAlbumForm" method="post" enctype="multipart/form-data">
	<br/><br/>
	名字：<input id="addAlbumFormTitle" name="title"/><br/><br/>
	封面：<input type="file" name="file"/><br/><br/>
	音频数量：<input id="addAlbumFormCount" name="count"/><br/><br/>
	作者：<input id="addAlbumFormAutor" name="autor"/><br/><br/>
	朗读者：<input id="addAlbumFormBroadCast" name="broadCast"/><br/><br/>
	简介：<input id="addAlbumFormBrief" name="brief"/><br/><br/>
	分数：<input id="addAlbumFormScore" name="score"/><br/><br/>
	<a id="addAlbumFormSaveBtn">添加</a>
	<a id="addAlbumFormResetBtn">重置</a>
</form>

