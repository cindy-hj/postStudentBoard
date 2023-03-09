package com.exam.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.DTO.post.PostResponse;
import com.exam.DTO.student.Student;
import com.exam.service.PostService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class WebPostController {
	
	@Autowired
	private PostService ps;
	
	@GetMapping("/stdinfo")
	public String webpage1(Model m) {
		
		Student student = new Student();
		student.setId(1);
		student.setName("홍길동");
		student.setAge(20);
		student.setGrade(90);
		
		m.addAttribute("student", student);
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(student);
		studentList.add(new Student(2, "홍길자", 29, 88));
		studentList.add(new Student(3, "홍길남", 27, 73));
		m.addAttribute("studentList", studentList);
		
		return "studentinfo";
	}
	
	@GetMapping("/stdlist")
	public ModelAndView webpage2() {
		
		ModelAndView mview = new ModelAndView("studentlist");
		Student student = new Student();
		student.setId(1);
		student.setName("홍길동");
		student.setAge(20);
		student.setGrade(90);
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(student);
		studentList.add(new Student(2, "홍길자", 29, 88));
		studentList.add(new Student(3, "홍길남", 27, 73));
		
		mview.addObject("studentList", studentList);
		return mview;
	}
	
	@GetMapping("/boardlist1")
	public String webpage3(Model m, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("sid")==null) {
			return "loginerror";
		}
		
		List<PostResponse> result = ps.findAllPost();
		m.addAttribute("data", result);
		return "boardlist";
	}
	
	@GetMapping("/loginform")
	public String loginform(Model m) {
		return "login";
	}
	
	@GetMapping("/login")
	public String loginpage(Model m, HttpServletRequest req
			, @RequestParam("id")String id
			, @RequestParam("password")String password) {
		HttpSession session = req.getSession();
		
		if(id.equals("admin") && password.equals("admin123")) {
			session.setAttribute("sid", id);
			session.setAttribute("spassword", password);
			return "main";
		} 
		return "login";
	}
	
	@GetMapping("/main")
	public String mainpage(Model m, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("id")==null) {
			return "loginerror";
		}
		
		LocalDateTime today = LocalDateTime.now();
		String id = (String)session.getAttribute("sid");
		m.addAttribute("today", today);
		return "main";
	}
	
	@GetMapping("/logout")
	public String logout(Model m, HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "login";
	}
}
