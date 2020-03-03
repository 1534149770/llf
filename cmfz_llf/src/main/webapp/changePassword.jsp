<%@page pageEncoding="UTF-8"%>
<html>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/datagrid-detailview.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.edatagrid.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.etree.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$("#changeAdminId").textbox({
			required:true
		});
	
		$("#changeAdminFormPwd").textbox({
			required:true,
			prompt:"名字不少于两位",
			validType:"mLength[2]"
		});
		
		$("#changeAdminFormSaveBtn").linkbutton({
			onClick:function(){
				$("#changeAdminForm").form("submit",{
					url:"${pageContext.request.contextPath}/Admin/change.do",
					onSubmit:function(){
						return $("#changeAdminForm").form("validate")					
					},
					success:function(){
						$.messager.show({
							title:"修改成功",
							msg:"小老弟你怎么回事"
						});
						href:"${pageContext.request.contextPath}/login.jsp"
					}
				})
			}
		});
		$("#changeAdminFormResetBtn").linkbutton({
			onClick:function(){
				$("#changeAdminForm").form("reset")
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
	
<form id="changeAdminForm" method="post" enctype="multipart/form-data">
	<br/><br/>
	id:<input id="changeAdminId" name="id" value="${sessionScope.admin.id }"/><br/><br/>
	新密码：<input id="changeAdminFormPwd" name="password"/><br/><br/>
	<a id="changeAdminFormSaveBtn">修改</a>
	<a id="changeAdminFormResetBtn">重置</a>
</form>
</html>



