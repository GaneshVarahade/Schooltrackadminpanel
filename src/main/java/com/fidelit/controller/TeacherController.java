package com.fidelit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fidelit.model.ChildProgress;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.service.GtsService;
import com.fidelit.service.RouteService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;

@Controller
@RequestMapping({ "/Teacher" })
public class TeacherController {

	@Autowired
	private SchoolAdminService schoolAdminService;

	@Autowired
	private GtsService gtsService;

	@Autowired
	RouteService routeService;

	@Autowired
	private SchoolService schoolService;

	@RequestMapping(value = "/home")
	public String userHome(ModelMap model) {

		model.addAttribute("homeActive", "homeActive");
		return "schoolAdminHome";
	}

	@RequestMapping(value = "/ChildList")
	public String allStudentList(
			@ModelAttribute("schoolAdmin") SchoolAdmin schoolAdmin,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		System.out.println("In child list");
		HttpSession session = request.getSession();

		SchoolAdmin currentUserr = (SchoolAdmin) session
				.getAttribute("currentUser");
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList = schoolAdminService
				.getStudentList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList = schoolService.allSchoolList(currentUserr
				.getAccountId());
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);

		model.addAttribute("schoolList", schoolList);
		model.addAttribute("childProgressActive", "childProgressActive");
		return "ChildList";

	}

	@RequestMapping(value = "/addMarks")
	public String AddMarks(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		
		ChildProgress cp= new ChildProgress();
		String ExamName = request.getParameter("ExamName");
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String date = request.getParameter("Date");
		String Subject = request.getParameter("Subject");
		int MinMarks = Integer.parseInt(request.getParameter("MinMarks"));
		int MaxMarks = Integer.parseInt(request.getParameter("MaxMarks"));
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userName:"+userName);
		SchoolAdmin student=schoolAdminService.getSchoolAdminId(studentId);
		
		
		cp.setExamName(ExamName);
		cp.setDate(date);
		cp.setMaxMarks(MaxMarks);
		cp.setMinMarks(MinMarks);
		cp.setSubject(Subject);
		
	
		HttpSession session = request.getSession();

		SchoolAdmin currentUserr = (SchoolAdmin) session
				.getAttribute("currentUser");
		String userName1 = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList = schoolAdminService
				.getStudentList(userName1);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList = schoolService.allSchoolList(currentUserr
				.getAccountId());
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);

		model.addAttribute("schoolList", schoolList);
		model.addAttribute("childProgressActive", "childProgressActive");
		return "ChildList";


	
}
}
