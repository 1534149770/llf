<%@page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$.getJSON(
			"${pageContext.request.contextPath}/Type/findAll.do",
			function(res){
				$.each(res,function(idx,l1){
					var l2title="<div style='text-align: center'>";
					$.each(l1.types,function(ids,l2){
						 var s = JSON.stringify(l2);
                         l2title+="<div onclick='addtabs("+s+")' data-options='plain:true' style='border:1px #95B8E7 solid;width: 95%;margin:3px 0px 3px 0px' class='easyui-linkbutton'>"+l2.title+"<br/>"+"</div>";
					})
					l2title+="</div>";
					$("#Accordion").accordion("add",{
						title:l1.title,
						content:l2title
					})
				})
			}
		)
	})
	function addtabs(s){
		if($("#tabs").tabs("exists",s.title)){
			$("#tabs").tabs("select",s.title)
		}
		else{
			$("#tabs").tabs("add",{
				title:s.title,
				closable:true,
				href:s.url
			})
		}
	}
</script>

<div id="Accordion" class="easyui-accordion"></div>