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
import com.fidelit.model.Exam;
import com.fidelit.model.ExamToSubject;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.StudentToExam;
import com.fidelit.service.GtsService;
import com.fidelit.service.RouteService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;
import com.fidelit.service.TeacherService;

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

	@Autowired
	private TeacherService teacherService;
	
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
	
	@RequestMapping(value = "/addExam")
	public String addExam(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		
		Exam exam= new Exam();
		
		String examName = request.getParameter("examName");
		System.out.println("examName:"+examName);
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		int subjectNo = Integer.parseInt(request.getParameter("subjectNo"));
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userName:"+userName);
		
		exam.setExamName(examName);
		exam.setDateFrom(dateFrom);
		exam.setDateTo(dateTo);
		exam.setSubjectNo(subjectNo);
		teacherService.addExam(exam);
	
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
		request.setAttribute("subjects", exam.getSubjectNo());
		request.setAttribute("examIDD", exam.getExamId());
		return "AddSubjects";	
		}
	
	@RequestMapping(value = "/addSubject")
	public String addSubject(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		ExamToSubject ets = new ExamToSubject();
		int subjectNo = Integer.parseInt(request.getParameter("subjectNo"));
		int examIDD = Integer.parseInt(request.getParameter("examIDD"));
		String[] subArray = new String[subjectNo];
		int[] subMin = new int[subjectNo];
		int[] subMax = new int[subjectNo];
		
		for(int i=0; i<subjectNo; i++){
			subArray[i] = request.getParameter("subjectId"+i);
			subMin[i] = Integer.parseInt(request.getParameter("min"+i));
			subMax[i] = Integer.parseInt(request.getParameter("max"+i));
			if(i == 0){
				ets.setSubject1(subArray[0]);
				ets.setSubject1min(subMin[0]);
				ets.setSubject1max(subMax[0]);
			}
			if(i == 1){
				ets.setSubject2(subArray[1]);
				ets.setSubject2min(subMin[1]);
				ets.setSubject2max(subMax[1]);
			}
			if(i == 2){
				ets.setSubject3(subArray[2]);
				ets.setSubject3min(subMin[2]);
				ets.setSubject3max(subMax[2]);
			}
			if(i == 3){
				ets.setSubject4(subArray[3]);
				ets.setSubject4min(subMin[3]);
				ets.setSubject4max(subMax[3]);
			}
			if(i == 4){
				ets.setSubject5(subArray[4]);
				ets.setSubject5min(subMin[4]);
				ets.setSubject5max(subMax[4]);
			}
			if(i == 5){
				ets.setSubject6(subArray[5]);
				ets.setSubject6min(subMin[5]);
				ets.setSubject6max(subMax[5]);
			}
			if(i == 6){
				ets.setSubject7(subArray[6]);
				ets.setSubject7min(subMin[6]);
				ets.setSubject7max(subMax[6]);
			}
			if(i == 7){
				ets.setSubject8(subArray[7]);
				ets.setSubject8min(subMin[7]);
				ets.setSubject8max(subMax[7]);
			}
			if(i == 8){
				ets.setSubject9(subArray[8]);
				ets.setSubject9min(subMin[8]);
				ets.setSubject9max(subMax[8]);
			}
			if(i == 9){
				ets.setSubject10(subArray[9]);
				ets.setSubject10min(subMin[9]);
				ets.setSubject10max(subMax[9]);
			}
				
		
		}
		Exam exam = teacherService.getExamByExamId(examIDD);
		ets.setExam(exam);
		teacherService.addSubjectInExam(ets);

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
	
	@RequestMapping(value = "/addStudentMarks")
	public String addStudentMarks(@ModelAttribute("examObj") Exam examObj,HttpServletRequest request, HttpServletResponse response,ModelMap model){
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		request.setAttribute("studentId", studentId);
		List<Exam> exam = teacherService.getAllExam();
		model.addAttribute("examList", exam);
		return "StudentMarks";
	}
	
	
	@RequestMapping(value = "/examforstudent")
	public String examforstudent(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		String examId = request.getParameter("examName");
		int examID = Integer.parseInt(examId);
		String studentId =request.getParameter("studentId");
		int studentID = Integer.parseInt(studentId);
		System.out.println("examId:"+examId+"  studentId:"+studentId);
		ExamToSubject ets = teacherService.getExamToSubjectByExamId(examID);
		SchoolAdmin student = schoolAdminService.getSchoolAdminId(studentID);
		StudentToExam ste = new StudentToExam();
		Exam exam = teacherService.getExamByExamId(examID);
		StudentToExam studentToExam = teacherService.setStudentToExam(ste, ets, student, exam);
		model.addAttribute("studentToExam", studentToExam);
		request.setAttribute("studentToExamId", studentToExam.getId());
		return "StudentMarksEnter";
	}
	

	@RequestMapping(value = "/addedMarksInStudent")
	public String addedMarksInStudent(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
	
		String studentToExamId = request.getParameter("studentToExamId");
		int Id = Integer.parseInt(studentToExamId);
		System.out.println("studentToExamID:"+Id);
		StudentToExam ste = teacherService.getStudentToExamById(Id);
		 request.getParameter("studentToExamId");
		if(ste.getSubject1() != null){
			int ob = Integer.parseInt(request.getParameter("subject1obtained"));
			ste.setSubject1obtained(ob);
		}
		if(ste.getSubject2() != null){
			int ob = Integer.parseInt(request.getParameter("subject2obtained"));
			ste.setSubject2obtained(ob);
		}
		if(ste.getSubject3() != null){
			int ob = Integer.parseInt(request.getParameter("subject3obtained"));
			ste.setSubject3obtained(ob);
		}
		if(ste.getSubject4() != null){
			int ob = Integer.parseInt(request.getParameter("subject4obtained"));
			ste.setSubject4obtained(ob);
		}
		if(ste.getSubject5() != null){
			int ob = Integer.parseInt(request.getParameter("subject5obtained"));
			ste.setSubject5obtained(ob);
		}
		if(ste.getSubject6() != null){
			int ob = Integer.parseInt(request.getParameter("subject6obtained"));
			ste.setSubject6obtained(ob);
		}
		if(ste.getSubject7() != null){
			int ob = Integer.parseInt(request.getParameter("subject7obtained"));
			ste.setSubject7obtained(ob);
		}
		if(ste.getSubject8() != null){
			int ob = Integer.parseInt(request.getParameter("subject8obtained"));
			ste.setSubject8obtained(ob);
		}
		if(ste.getSubject9() != null){
			int ob = Integer.parseInt(request.getParameter("subject9obtained"));
			ste.setSubject9obtained(ob);
		}
		if(ste.getSubject10() != null){
			int ob = Integer.parseInt(request.getParameter("subject10obtained"));
			ste.setSubject10obtained(ob);
		}
		
		teacherService.updateStudentToExam(ste);
		
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

