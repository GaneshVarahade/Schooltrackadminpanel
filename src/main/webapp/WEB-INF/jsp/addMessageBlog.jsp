<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/Teacher/addMessageBlog" commandName="Blog">

     <input type="hidden" name="action" id="action" value="Add">

	<div class="form-group">
		<form:label path="msg" class="col-sm-3 control-label"> &#42;Message </form:label>
		<div class="col-sm-8">
			<form:input type="text" path="msg" id="msg" value=""
				class="form-control" maxlength="20"
				 />
		</div>
	</div>

	<div class="form-group">
		<form:label path="studentClass" class="col-sm-3 control-label">&#42; Class </form:label>
		<div class="col-sm-8">
			<form:select path="studentClass" id="studentClass" class="form-control" >
				<form:option value="">Select</form:option>

				<form:option value="1A">1A</form:option>
				<form:option value="1B">1B</form:option>
				<form:option value="1B">1C</form:option>
				<form:option value="1B">1D</form:option>
				
			</form:select>
		</div>
	</div>
	
	<button type="submit" class="btn btn-sky btn-sm" >Save</button>
	 </form:form>  
</body>
</html>