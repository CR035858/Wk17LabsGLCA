package com.gl.tdms.labwk17d03dem1.service;

import java.util.List;

import com.gl.tdms.labwk17d03dem1.entity.Role;
import com.gl.tdms.labwk17d03dem1.entity.TeacherDetails;
import com.gl.tdms.labwk17d03dem1.entity.User;



public interface TeacherDetailService {

	public List <TeacherDetails> findAll();
	
	public TeacherDetails findById(int theId);
	
	public void save(TeacherDetails teacherDetails);
	
	public void deleteById(int theId);
	
	public List<TeacherDetails> searchByTeacherName(String teacherName);
	
	public List<TeacherDetails> sortByTeacherNameAsc();
	/**/
	
}
