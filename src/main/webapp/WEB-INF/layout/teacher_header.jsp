<ul class="nav navbar-nav">
	<li id="homeActive" ><a href="${pageContext.request.contextPath}/Teacher/home">Home</a></li>
	<li id="schoolsActive" ><a href="${pageContext.request.contextPath}/Teacher/ChildList">ChildList</a></li>
</ul>
<script>
$(function(){
	if("${childProgressActive}" == 'childProgressActive'){
		$("#childProgressActive").addClass("active");
	}else if("${homeActive}" == 'homeActive'){
		$("#homeActive").addClass("active");
	}
})
</script>