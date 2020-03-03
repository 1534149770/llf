<%@page pageEncoding="UTF-8" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
	    	// 看不清，换一张
	  	  	function img(obj){
	    		obj.src = "${pageContext.request.contextPath }/Admin/img?suiyi="+Math.random();
	   		 }
	   		 $(function(){
	   		 	$("#loginBtn").linkbutton({
	   		 		onClick:function(){
	   		 			$("#loginForm").form("submit",{
	   		 				url:"${pageContext.request.contextPath }/Admin/login"
	   		 			})
	   		 		}
	   		 	})
	   		 })
   		</script>
    	<style type="text/css">
    		img{
    			cursor: pointer;
    		}
    		div.login {
				width: 520px;
				height: 302px;
				padding: 150px 160px 0px 160px;
				margin: 60px auto 0px auto;
				overflow: hidden;
				background: url(./images/login.png) 0px 0px no-repeat;
			}
   	 	</style>
	</head>
	
	<body>
		<div class="login">
			<form id="loginForm" method="post" action="${pageContext.request.contextPath }/Admin/login">
				<table>
						<tbody>
							<tr>
								<td width="190" rowspan="2" align="center" valign="bottom">
									<img src="./images/header_logo.gif" />
								</td>
								<th>
									用户名:
								</th>
								<td>
									<input type="text"  name="username" class="text" maxlength="20"/>
								</td>
						  </tr>
						  <tr>
								<th>
									密&nbsp;&nbsp;&nbsp;码:
								</th>
								<td>
									<input type="password" name="password" class="text" maxlength="20" autocomplete="off"/>
								</td>
						  </tr>
						
							<tr>
								<td>&nbsp;</td>
								<th>验证码:</th>
								<td>
									<input type="text" id="enCode" name="clientCode" maxlength="4" autocomplete="off"/>
									<img id="captchaImage" onclick="img(this)" src="${pageContext.request.contextPath }/Admin/img" title="点击更换验证码"/>
								</td>
							</tr>					
						<tr>
							<td>
								&nbsp;
							</td>
							<th>
								&nbsp;
							</th>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<th>&nbsp;</th>
							<td>
								<!-- <a id="loginBtn">登录</a> -->
								<input type="submit" value="登录"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</body>
</html>