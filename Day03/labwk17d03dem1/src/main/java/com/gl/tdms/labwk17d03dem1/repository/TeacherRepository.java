package com.gl.tdms.labwk17d03dem1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.tdms.labwk17d03dem1.entity.TeacherDetails;



public interface TeacherRepository extends JpaRepository<TeacherDetails, Integer> {
	
	List<TeacherDetails> findByTeacherNameContainsAllIgnoreCase(String teacherName);

	List<TeacherDetails> findAllByOrderByTeacherNameAsc();

}
