<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<c:if test="${sessionScope.admin !=null}">
		<head>
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css"/>
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css"/>
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/easyui-lang-zh_CN.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/datagrid-detailview.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.edatagrid.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.etree.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/echarts.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/china.js"></script>
			<script type="text/javascript">
				
			</script>
		</head>
		
		<body>
			<div id="layout" class="easyui-layout" data-options="fit:true">
				<div data-options="region:'north',title:'欢迎',height:100,href:'${pageContext.request.contextPath }/top.jsp'" ></div>   
				<div data-options="region:'west',title:'管理',width:200,href:'${pageContext.request.contextPath }/left.jsp'"></div>
				<div data-options="region:'center',href:'${pageContext.request.contextPath }/center.jsp'"></div>
			</div>
		</body>
	</c:if>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="/login.jsp"></c:redirect>
	</c:if>
</html>