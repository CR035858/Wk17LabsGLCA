package com.gl.tdms.labwk17d02dem1.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.tdms.labwk17d02dem1.entity.TeacherDetails;
import com.gl.tdms.labwk17d02dem1.service.TeacherDetailService;

@Controller
@RequestMapping("/teachers")
public class TeacherDetailsController {
	
	@Autowired
	TeacherDetailService teacherService;
	
	@RequestMapping(value="/allTeacherDetails")
	public  String getAllTeacherDetails(Model model)
	{
		List <TeacherDetails> teacherDetails = teacherService.findAll();
		model.addAttribute("teacherDetails", teacherDetails);
		return "teacherdetails-list";
	}
	
	@GetMapping(value="/teacherById")
	public String getTeacherDetailsById(Model model,@RequestParam("teacherId") int teacherId)
	{
		TeacherDetails teacherDetails = teacherService.findById(teacherId);
		model.addAttribute("teacherDetails", teacherDetails);
		return "teacherdetails-list";
	}
	
	@RequestMapping(value="/showFormForAdd")
	public String addTeacherDetails(Model model)
	{
		TeacherDetails teacherDetails = new TeacherDetails();
		model.addAttribute("teacherDetails", teacherDetails);
		
		return "teacherdetails-form";
	}
	
//	@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping(value="/save")
	public String saveTeacherDetails(@ModelAttribute TeacherDetails teacherDetails)
	{
		teacherService.save(teacherDetails);
		return "redirect:/teachers/allTeacherDetails";
	}
	
//	@RequestMapping(value="/showFormForUpdate",method=RequestMethod.POST)
	@RequestMapping(value="/showFormForUpdate",method=RequestMethod.POST)
	public String showUpdateForm(Model model,@RequestParam("teacherId") Integer teacherId) {
		TeacherDetails teacherDetails = teacherService.findById(teacherId);
		System.out.println("Teacher Details Object "+teacherDetails);
		model.addAttribute("teacherDetails", teacherDetails);
		return "teacherdetails-form";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	//@RequestMapping(value="/delete")
	public String delete(@RequestParam("teacherId") Integer teacherId) {
		teacherService.deleteById(teacherId);
		return "redirect:/teachers/allTeacherDetails";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

	

}
