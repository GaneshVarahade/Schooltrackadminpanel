<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script>
function getStudentId(){

	var studentId = '${studentToExamId}';
	alert(studentId);
	$("#studentToExamId").val(studentId);
}
</script>
</head>
<body onload="getStudentId()">
<form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/Teacher/addedMarksInStudent">
		
		<div class="form-group">
			<input type="hidden" name="studentToExamId" id="studentToExamId" value="">
			<c:if test= "${not empty studentToExam.subject1}">    
			<input type="text" value="${studentToExam.subject1}" name="subject1" id="subject1">   
			<input type="text" value="${studentToExam.subject1min}" name="subject1min" id="subject1min">
			<input type="text" value="${studentToExam.subject1max}" name="subject1max" id="subject1max">
			<input type="text" value="${studentToExam.subject1obtained}" name="subject1obtained" id="subject1obtained">
			</c:if>
			
			<c:if test= "${not empty studentToExam.subject2}">    
			<input type="text" value="${studentToExam.subject2}" name="subject2" id="subject2">
			<input type="text" value="${studentToExam.subject2min}" name="subject2min" id="subject2min">
			<input type="text" value="${studentToExam.subject2max}" name="subject2max" id="subject2max">
			<input type="text" value="${studentToExam.subject2obtained}" name="subject2obtained" id="subject2obtained">
			</c:if>
			
			<c:if test= "${not empty studentToExam.subject3}">    
			<input type="text" value="${studentToExam.subject3}" name="subject3" id="subject3">
			<input type="text" value="${studentToExam.subject3min}" name="subject3min" id="subject3min">
			<input type="text" value="${studentToExam.subject3max}" name="subject3max" id="subject3max">
			<input type="text" value="${studentToExam.subject3obtained}" name="subject3obtained" id="subject3obtained">
			</c:if>
			
			<c:if test= "${not empty studentToExam.subject4}">    
			<input type="text" value="${studentToExam.subject4}" name="subject4" id="subject4">
			<input type="text" value="${studentToExam.subject4min}" name="subject4min" id="subject4min">
			<input type="text" value="${studentToExam.subject4max}" name="subject4max" id="subject4max">
			<input type="text" value="${studentToExam.subject4obtained}" name="subject4obtained" id="subject4obtained">
			</c:if>
			
			<c:if test= "${not empty studentToExam.subject5}">    
			<input type="text" value="${studentToExam.subject5}" name="subject5" id="subject5">
			<input type="text" value="${studentToExam.subject5min}" name="subject5min" id="subject5min">
			<input type="text" value="${studentToExam.subject5max}" name="subject5max" id="subject5max">
			<input type="text" value="${studentToExam.subject5obtained}" name="subject5obtained" id="subject5obtained">
			</c:if>
			
			<c:if test= "${not empty studentToExam.subject6}">    
			<input type="text" value="${studentToExam.subject6}" name="subject6" id="subject6">
			<input type="text" value="${studentToExam.subject6min}" name="subject6min" id="subject6min">
			<input type="text" value="${studentToExam.subject6max}" name="subject6max" id="subject6max">
			<input type="text" value="${studentToExam.subject6obtained}" name="subject6obtained" id="subject6obtained">
			</c:if>
			
			<c:if test= "${not empty studentToExam.subject7}">    
			<input type="text" value="${studentToExam.subject7}" name="subject7" id="subject7">
			<input type="text" value="${studentToExam.subject1min}" name="subject7min" id="subject7min">
			<input type="text" value="${studentToExam.subject1max}" name="subject7max" id="subject7max">
			<input type="text" value="${studentToExam.subject1obtained}" name="subject7obtained" id="subject7obtained">
			</c:if>
			
			<c:if test= "${not empty studentToExam.subject8}">    
			<input type="text" value="${studentToExam.subject8}" name="subject8" id="subject8">
			<input type="text" value="${studentToExam.subject8min}" name="subject8min" id="subject8min">
			<input type="text" value="${studentToExam.subject8max}" name="subject8max" id="subject8max">
			<input type="text" value="${studentToExam.subject8obtained}" name="subject8obtained" id="subject8obtained">
			</c:if>
			
			<c:if test = "${not empty studentToExam.subject9}">    
			<input type="text" value="${studentToExam.subject9}" name="subject9" id="subject9">
			<input type="text" value="${studentToExam.subject9min}" name="subject9min" id="subject9min">
			<input type="text" value="${studentToExam.subject9max}" name="subject9max" id="subject9max">
			<input type="text" value="${studentToExam.subject9obtained}" name="subject9obtained" id="subject9obtained">
			</c:if>
			
			<c:if test = "${not empty studentToExam.subject10}">    
			<input type="text" value="${studentToExam.subject10}" name="subject10" id="subject10">
			<input type="text" value="${studentToExam.subject10min}" name="subject10min" id="subject10min">
			<input type="text" value="${studentToExam.subject10max}" name="subject10max" id="subject10max">
			<input type="text" value="${studentToExam.subject10obtained}" name="subject10obtained" id="subject10obtained">
			</c:if>
		</div>
	    <input type="submit" class="btn btn-sky btn-sm"  value="Save" >
	</form>
</body>
</html>