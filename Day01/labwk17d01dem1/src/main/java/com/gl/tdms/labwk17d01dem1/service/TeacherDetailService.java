package com.gl.tdms.labwk17d01dem1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.tdms.labwk17d01dem1.entity.TeacherDetails;




@Service
public interface TeacherDetailService {

	public List<TeacherDetails> findAll();

	public TeacherDetails findById(Integer theId);

	public void save(TeacherDetails teacherDetails);

	public void deleteById(int theId);

}
