<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#addGuruFormName").textbox({
			required:true,
			prompt:"名字不少于两位",
			validType:"mLength[2]"
		});
		
		$("#addGuruFormSaveBtn").linkbutton({
			onClick:function(){
				$("#addGuruForm").form("submit",{
					url:"${pageContext.request.contextPath}/Guru/addGuru.do",
					onSubmit:function(){
						return $("#addGuruForm").form("validate")					
					},
					success:function(){
						$("#addGuruDialog").dialog("close");
						$.messager.show({
							title:"添加成功",
							msg:"小老弟你怎么回事"
						});
						$("#tableGuru").datagrid("load")
					}
				})
			}
		});
		$("#addGuruFormResetBtn").linkbutton({
			onClick:function(){
				$("#addGuruForm").form("reset")
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

<form id="addGuruForm" method="post" enctype="multipart/form-data">
	<br/><br/>
	名字：<input id="addGuruFormTitle" name="name"/><br/><br/>
	简介：<input id="addGuruFormDesc" name="brief"/><br/><br/>
	头像：<input type="file" name="file"/><br/><br/>
	状态：<select name="status">
		<option value="0">展示</option>
		<option value="1">不展示</option>
	</select><br/><br/>
	<a id="addGuruFormSaveBtn">添加</a>
	<a id="addGuruFormResetBtn">重置</a>
</form>

