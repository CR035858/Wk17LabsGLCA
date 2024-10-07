package com.gl.tdms.labwk17d03dem1.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gl.tdms.labwk17d03dem1.entity.TeacherDetails;

import com.gl.tdms.labwk17d03dem1.service.TeacherDetailService;



@RestController
@RequestMapping("/tdms")
public class TeacherDetailRestController {

	private TeacherDetailService teacherService;

	@Autowired
	public TeacherDetailRestController(TeacherDetailService theTeacherService) {
		teacherService = theTeacherService;
	}
	

	// expose "/Teachers" and return list of Teachers
	@GetMapping("/teachers")
	public List<TeacherDetails> findAll() {
		
		return teacherService.findAll();
	}

	// add mapping for GET /teachers/{teacherId}

	@GetMapping("/teachers/{teacherId}")
	public TeacherDetails getTeacherDetails(@PathVariable int teacherId) {

		TeacherDetails teacherDetail = teacherService.findById(teacherId);

		if (teacherDetail == null) {
			throw new RuntimeException("Employee id not found - " + teacherId);
		}

		return teacherDetail;
	}

	// add mapping for POST /employees - add new employee

	@PostMapping("/teachers")
	public TeacherDetails addTeacherDetail(@RequestBody TeacherDetails teacherDetail) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		teacherDetail.setId(0);

		teacherService.save(teacherDetail);

		return teacherDetail;
	}

	// add mapping for PUT /employees - update existing employee

	@PutMapping("/teachers")
	public TeacherDetails updateTeacherDetail(@RequestBody TeacherDetails teacherDetails) {

		teacherService.save(teacherDetails);

		return teacherDetails;
	}

	// add mapping for DELETE /teachers/{teacherId} - delete employee

	@DeleteMapping("/teachers/{teacherId}")

	public String deleteEmployee(@PathVariable int teacherId) {

		TeacherDetails teacherDetail = teacherService.findById(teacherId);

		// throw exception if null

		if (teacherDetail == null) {
			throw new RuntimeException("Employee id not found - " + teacherId);
		}

		teacherService.deleteById(teacherId);

		return "Deleted Tecaher Detail with  id - " + teacherId;
	}

	@GetMapping("/teachers/search/{teacherName}")
	public List<TeacherDetails> searchByFirstName(@PathVariable String teacherName) {
		return teacherService.searchByTeacherName(teacherName);
	}

	@GetMapping("/teachers/sort")
	public List<TeacherDetails> sortByTeacherName() {
		return teacherService.sortByTeacherNameAsc();
	} /* */

}
