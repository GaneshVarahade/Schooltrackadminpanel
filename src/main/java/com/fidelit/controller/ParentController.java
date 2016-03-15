package com.fidelit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fidelit.model.Blog;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.StudentToExam;
import com.fidelit.service.ParentService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.StudentService;
import com.fidelit.service.TeacherService;

@Controller
@RequestMapping({"/parent"})
public class ParentController {
	
	@Autowired
	private SchoolAdminService schoolAdminService;
	
	@Autowired
	private ParentService parentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/ChildList")
	public String ChildList(HttpServletRequest request, HttpServletResponse response,ModelMap model){
		String userName1 = SecurityContextHolder.getContext()
				.getAuthentication().getName();
			SchoolAdmin parent = schoolAdminService.getSchoolAdminByUsername(userName1);
		int parentId = parent.getId();
		System.out.println("parentId"+parentId);
		List<SchoolAdmin> studentList = parentService.getChildrenByParentId(parentId);
		model.addAttribute("studentList", studentList);
		return "ParentToChildList";
		
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response,ModelMap model){
		return "parent_home";
	}
	
	@RequestMapping(value = "/seeResults")
	public String seeResults(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		List<StudentToExam> ste = teacherService.getStudentToExamByStudentId(studentId);
		model.addAttribute("StudentToExam", ste);
		return "seeResultsForParent";
	}
	
	@RequestMapping(value = "/seeBlogs")
	public String seeBlogs(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		SchoolAdmin student = schoolAdminService.getSchoolAdminId(studentId);
		String studentClass = student.getStudentClass();
		List<Blog> blogs = studentService.getBlogsByClass(studentClass);
		
		model.addAttribute("blogs", blogs);
		return "seeBlogsForParent";
	}
}
