package com.gl.tdms.labwk17d02dem1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.tdms.labwk17d02dem1.entity.TeacherDetails;
import com.gl.tdms.labwk17d02dem1.repository.TeacherRepository;

@Service
public class TeacherDetailServiceImpl implements TeacherDetailService{
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public List<TeacherDetails> findAll() {
		// TODO Auto-generated method stub
		List <TeacherDetails> teacherDetails = teacherRepository.findAll();
		return teacherDetails;
	}

	@Override
	public TeacherDetails findById(Integer theId) {
		// TODO Auto-generated method stub
		/*TeacherDetails teacherDetails = teacherRepository.findById(theId).orElseThrow("id not found");
		return teacherDetails;*/
		
		
		  TeacherDetails teacherDetails= teacherRepository.findById(theId).get();
		  
		  //teacherRepository.findById(theId).or
		  return teacherDetails;
		
		
	}

	@Override
	public void save(TeacherDetails teacherDetails) {
		// TODO Auto-generated method stub
		teacherRepository.save(teacherDetails);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		teacherRepository.deleteById(theId);
	}

}
