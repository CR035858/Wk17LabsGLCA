package com.gl.tdms.labwk17d03dem1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.tdms.labwk17d03dem1.entity.Role;
import com.gl.tdms.labwk17d03dem1.entity.TeacherDetails;
import com.gl.tdms.labwk17d03dem1.entity.User;
import com.gl.tdms.labwk17d03dem1.repository.TeacherRepository;



@Service
public class TeacherDetailServiceImpl implements TeacherDetailService {

	private TeacherRepository teacherRepository;

	
	

	@Autowired
	public TeacherDetailServiceImpl(TeacherRepository theTeacherRepository) {
		teacherRepository = theTeacherRepository;
	}

	@Override
	public List <TeacherDetails> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public TeacherDetails findById(int theId) {
		Optional<TeacherDetails> result = teacherRepository.findById(theId);

		TeacherDetails teacherDetail = null;

		if (result.isPresent()) {
			teacherDetail = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Teacher id - " + theId);
		}

		return teacherDetail;
	}

	@Override
	public void save(TeacherDetails teacherDetail) {
		teacherRepository.save(teacherDetail);
	}

	@Override
	public void deleteById(int theId) {
		teacherRepository.deleteById(theId);
	}

	@Override
	public List<TeacherDetails> searchByTeacherName(String teacherName) {
		// TODO Auto-generated method stub
		return teacherRepository.findByTeacherNameContainsAllIgnoreCase(teacherName);
	}

	@Override
	public List <TeacherDetails> sortByTeacherNameAsc() {
		// TODO Auto-generated method stub
		return teacherRepository.findAllByOrderByTeacherNameAsc();
	}/**/



}
