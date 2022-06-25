package spring.mvc.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.Student;
import common.MockData;

import static common.Application.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

/**
 * student --> index page student/id --> get page student/add --> add page
 * student/save --> save/update page student/delete --> delete page
 */
@Controller
@RequestMapping("/student")
public class StudentController {

	private List<Student> students;

	@PostConstruct
	public void init() {
		System.out.println("----> @PostConstruct#init");
		students = MockData.getStudents();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping
	public String showIndexPage(Model model) {
		model.addAttribute("students", students);
		return STUDENT_INDEX_PAGE;
	}

	@GetMapping("/add")
	public String showAddPage(Model model) {
		addStudentAttributes(model, new Student(), STUDENT_ADD_TITLE);
		return STUDENT_FORM_PAGE;
	}

	@GetMapping("/edit")
	public String showEditPage(@RequestParam("id") String studentId, Model model) {
		Student foundStudent = students.stream()
				.filter(st -> st.getId().equals(studentId))
				.findFirst().get();
		addStudentAttributes(model, foundStudent, STUDENT_EDIT_TITLE);
		return STUDENT_FORM_PAGE;
	}

	@PostMapping("/save")
	public String saveOrUpdate(Model model, 
			@Valid @ModelAttribute("student") Student student,
			BindingResult bindingResult ) {
		System.out.println("=======> student: " + student);
		System.out.println("=======> binding results: " + bindingResult);
		boolean hasErrors = bindingResult.hasErrors();
		
		String formStudentId = student.getId();
		List<String> studentIds = students.stream().map(Student::getId).collect(Collectors.toList());
		
		if (studentIds.contains(formStudentId)) {
			// update
			if (hasErrors) {
				addStudentAttributes(model, student, STUDENT_EDIT_TITLE);
				return STUDENT_FORM_PAGE;
			}
			Student foundStudent = students.stream()
					.filter(st -> st.getId().equals(formStudentId))
					.findFirst().get();
			foundStudent.transfer(student);
		} else {
			// add
			if (hasErrors) {
				addStudentAttributes(model, student, STUDENT_ADD_TITLE);
				return STUDENT_FORM_PAGE;
			}
			students.add(student);
		}
		return "redirect:/student";
	}

	private static void addStudentAttributes(Model model, Student student, String title) {
		model.addAttribute("title", title);
		
		// data-binding
		model.addAttribute("student", student);

		// select option
		model.addAttribute("countries", MockData.getCountries());

		// check-box
		model.addAttribute("operatingSystems", MockData.getOses());
	}

}
