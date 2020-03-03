<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#addCarouselFormName").textbox({
			required:true,
			prompt:"名字不少于两位",
			validType:"mLength[2]"
		});
		
		$("#addCarouselFormSaveBtn").linkbutton({
			onClick:function(){
				$("#addCarouselForm").form("submit",{
					url:"${pageContext.request.contextPath}/Carousel/addCarousel.do",
					onSubmit:function(){
						return $("#addCarouselForm").form("validate")					
					},
					success:function(){
						$("#addCarouselDialog").dialog("close");
						$.messager.show({
							title:"添加成功",
							msg:"小老弟你怎么回事"
						});
						$("#tableCarousel").datagrid("load")
					}
				})
			}
		});
		$("#addCarouselFormResetBtn").linkbutton({
			onClick:function(){
				$("#addCarouselForm").form("reset")
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

<form id="addCarouselForm" method="post" enctype="multipart/form-data">
	<br/><br/>
	标题：<input id="addCarouselFormTitle" name="title"/><br/><br/>
	描述：<input id="addCarouselFormDesc" name="descript"/><br/><br/>
	图片：<input type="file" name="file"/><br/><br/>
	状态：<select name="status">
		<option value="0">展示</option>
		<option value="1">不展示</option>
	</select><br/><br/>
	<a id="addCarouselFormSaveBtn">添加</a>
	<a id="addCarouselFormResetBtn">重置</a>
</form>

