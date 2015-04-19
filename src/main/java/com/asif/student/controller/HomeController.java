package com.asif.student.controller;


import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.asif.student.model.Student;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:Beans.xml");

	StudentJDBCTemplate dataBaseConnection = (StudentJDBCTemplate) context
			.getBean("studentJDBCTemplate");

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
		 * locale); String formattedDate = dateFormat.format(date);
		 * model.addAttribute("serverTime", formattedDate );
		 */

		return "home";
	}

	// Insert Student Information
	@RequestMapping(value = "insertStudent.html", method = RequestMethod.POST)
	public String InsertData(Student student, Student student1,
			BindingResult result, Model model) {

		String name = student.getStudentName();
		String email = student.getStudentEmail();
		String id = "";
		dataBaseConnection.create(name, email);
		// JOptionPane.showMessageDialog(null, "a");
		student1 = dataBaseConnection.getStudents();
		id = student1.getStudentId().toString();
		model.addAttribute("message", "Auto Generated Student ID is : " + id);
		return "home";

	}

	// Display Table
	@RequestMapping(value = "searchAll.html")
	public ModelAndView searchAllData() {
		ModelAndView mav = new ModelAndView("home");
		List<Student> student = dataBaseConnection.listStudents();
		mav.addObject("alldata", student);
		return mav;
	}

	// Update customer Information
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String updateData(Student student, Model model) {
		return "edit";
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String updateData(Student student) {		
		String name = student.getStudentName();
		String email = student.getStudentEmail();
		Integer id = Integer.parseInt(student.getStudentId());		
		dataBaseConnection.update(id, name, email);	
		
		return "redirect:searchAll.html";
	}

	// Update customer Information
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public String deleteData(Student student, Model model) {
		Integer id = Integer.parseInt(student.getStudentId());
		dataBaseConnection.delete(id);
		return "redirect:searchAll.html";
	}
}
