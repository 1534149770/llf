<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#userChangePwd").linkbutton({
			iconCls:"icon-edit",
			onClick:function(){
				$("#userChangePwd").prop("href","${pageContext.request.contextPath}/changePassword.jsp?id="+${sessionScope.admin.id})
			}
		})
		$("#userExit").linkbutton({
			iconCls:"icon-no",
			onClick:function(){
				$("#userExit").prop("href","${pageContext.request.contextPath}/Admin/exit.do")
			}
		})
	})
</script>
<div data-options="region:'north',split:true" style="height:80px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.username } &nbsp;
    <a id="userChangePwd">修改密码</a>&nbsp;
    <a id="userExit">退出系统</a></div>
</div>   

