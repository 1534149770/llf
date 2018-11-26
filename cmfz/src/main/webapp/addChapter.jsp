<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#addChapterFormAlbum_id").prop("value",rowid)
		$("#addChapterFormTitle").textbox({
			required:true,
			prompt:"名字不少于两位",
			validType:"mLength[2]"
		});
		
		$("#addChapterFormSize").textbox({
			required:true
		});
		
		$("#addChapterFormDuration").textbox({
			required:true
		});
		
		
		
		$("#addChapterFormSaveBtn").linkbutton({
			onClick:function(){
				$("#addChapterForm").form("submit",{
					url:"${pageContext.request.contextPath}/Chapter/addChapter.do",
					onSubmit:function(){
						return $("#addChapterForm").form("validate")					
					},
					success:function(){
						$("#addChapterDialog").dialog("close");
						$.messager.show({
							title:"添加成功",
							msg:"小老弟你怎么回事"
						});
						$("#tableAlbum").treegrid("reload")
					}
				})
			}
		});
		$("#addChapterFormResetBtn").linkbutton({
			onClick:function(){
				$("#addChapterForm").form("reset")
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

<form id="addChapterForm" method="post" enctype="multipart/form-data">
	<br/><br/>
	名字：<input id="addChapterFormTitle" name="title"/><br/><br/>
	大小：<input id="addChapterFormSize" name="size"/><br/><br/>
	时长：<input id="addChapterFormDuration" name="duration"/><br/><br/>
	下载路径：<input id="addChapterFormDownloadPath" type="file" name="file"/><br/><br/>
	所属专辑：<input id="addChapterFormAlbum_id" name="album_id"/><br/><br/>
	<a id="addChapterFormSaveBtn">添加</a>
	<a id="addChapterFormResetBtn">重置</a>
</form>

